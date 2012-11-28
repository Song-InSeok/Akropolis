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
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DebateManager;
import bean.FaceBook;
import bean.SubTopic;
import bean.User;

import com.mysql.jdbc.StringUtils;

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
//							session.setAttribute("fInfo", JSONValue.parse(line));
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
		UserDAO udao = new UserDAO();
		int mt_id,st_id,st_O,st_L;
		boolean flag=false;
		ModelView mv = null;
		mt_id=st_id=st_O=st_L=0;
		
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
			dm.setUserList(udao.getDebateUsers(mt_id));
			
			
			List<SubTopic> slist = dm.getStList();
			for(int i=0;i<slist.size();i++){
				if((st_L=slist.get(i).getSub_id())==st_id) flag=true;
				if(slist.get(i).getSub_close().equals("O")) st_O = slist.get(i).getSub_id();
			}
			if(flag) dm.setSt(st_id);
			else if(!flag&&st_O!=0) dm.setSt(st_O);
			else dm.setSt(st_L);
			
			System.out.println(st_id+" "+st_O+" "+st_L+" "+dm.getSt()+" flag = "+dm.getUserList().get(0).getFlag());
			
			dm.setOpList(odao.getOpinions(mt_id, st_id));
			System.out.println(dm.getMt().getMt_title());
			System.out.println(dm.getStList().size());
			System.out.println(dm.getOpList().size());
			request.setAttribute("debatemanager", dm);
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