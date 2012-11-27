package controller;

import hello.annotation.Mapping;
import hello.annotation.RootURL;
import hello.mv.ModelView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONValue;

import bean.DebateManager;
import bean.FaceBook;
import bean.User;


import com.mysql.jdbc.StringUtils;

import bean.FaceBook;
import bean.MainTopic;
import bean.Opinion;
import dao.MainTopicDAO;
import dao.OpinionDAO;
import dao.SubTopicDAO;
import dao.UserDAO;

//import dao.MainTopicDAO;
//import dao.OpinionDAO;
//import dao.SubTopicDAO;



@RootURL("/")
public class RootController {

	@Mapping(url="/main.ap")
	ModelView main(HttpServletRequest request,HttpServletResponse response){
		//Model(Bean)
		ModelView mv = new ModelView("/main");
		return mv;
	}
	
	@Mapping(url="/login.ap",bean="bean.FaceBook")
	ModelView login(HttpServletRequest request,HttpServletResponse response,Object bean){
		ModelView mv = new ModelView("/close");
		FaceBook fb = (FaceBook)bean;
		HttpSession session = request.getSession();
		if(!StringUtils.isNullOrEmpty(fb.getCode())){
			URL url;
			BufferedReader br;
			HttpURLConnection conn;
			try {
				url = new URL("https://graph.facebook.com/oauth/access_token?client_id="+
						request.getServletContext().getInitParameter("appID")+"&redirect_uri="+
						request.getServletContext().getInitParameter("callback")+"&client_secret="+
						request.getServletContext().getInitParameter("appSecret")+
						"&code="+fb.getCode());
				conn = (HttpURLConnection)url.openConnection();
				if (conn != null) {
					conn.setConnectTimeout(10000);
					conn.setUseCaches(false);
					if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
						br = new BufferedReader(
								new InputStreamReader(conn.getInputStream()));
						for (;;) {
							String line = br.readLine();
							if (line == null) break;
							session.setAttribute("accessToken", line.substring(line.indexOf("=")+1, line.indexOf("&")));
							session.setAttribute("expires",line.substring(line.lastIndexOf("=")+1));
						}
						br.close();
					}
					conn.disconnect();
				}
				
				url = new URL("https://graph.facebook.com/me?access_token="+session.getAttribute("accessToken"));
				System.out.println("https://graph.facebook.com/me?access_token="+session.getAttribute("accessToken"));
				conn = (HttpURLConnection) url.openConnection();
				if(conn != null){
					conn.setConnectTimeout(10000);
					conn.setUseCaches(false);
					if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
						br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						for (;;) {
							String line = br.readLine();
							if (line == null) break;
							session.setAttribute("fInfo", JSONValue.parse(line));
						}
						br.close();
					}
					conn.disconnect();
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mv;
	}
	
	@Mapping(url="/decotest.ap")
	ModelView deco(HttpServletRequest request,HttpServletResponse response){
		ModelView mv = new ModelView("/decotest");
		return mv;
	}
	
	@Mapping(url="/error.ap")
	ModelView error(HttpServletRequest request,HttpServletResponse response){
		ModelView mv = new ModelView("/error");
		return mv;
	}
	
	@Mapping(url="/debate.ap",method="GET")
	ModelView debate(HttpServletRequest request,HttpServletResponse response){
		User loginUser;
		MainTopicDAO mdao = new MainTopicDAO();
		SubTopicDAO sdao = new SubTopicDAO();
		OpinionDAO odao = new OpinionDAO();
		int mt_id,st_id;
		ModelView mv = null;
		mt_id=st_id=0;
		
		try{
			if(request.getParameter("mt")!=null) 	mt_id = Integer.parseInt(request.getParameter("mt"));
			if(request.getParameter("st")!=null) st_id = Integer.parseInt(request.getParameter("st"));
			loginUser = (User)request.getSession().getAttribute("user");
			System.out.println(mt_id+" "+st_id+" "+loginUser);
			
			if(mt_id==0){
				if((loginUser=(User)request.getSession().getAttribute("user"))==null){
					mv = new ModelView("/error");
					return mv;
				}else{
					mt_id = new UserDAO().getUsersDebate(loginUser.getEmail());
				}
			}
			
			DebateManager dm = new DebateManager();
			dm.setMt(mdao.getMainTopic(mt_id));
			dm.setStList(sdao.getSubTopics(mt_id));
			if(st_id==0){
				st_id=dm.getStList().size();
			}
			dm.setOpList(odao.getOpinions(mt_id, st_id));
			System.out.println(dm.getMt().getMt_title());
			System.out.println(dm.getStList().size());
			System.out.println(dm.getOpList().size());
			mv = new ModelView("/debate");
			return mv;
		}catch(Exception e){
			e.printStackTrace();
			mv = new ModelView("/error");
		}finally{
			
		}
		return mv;


	}
}