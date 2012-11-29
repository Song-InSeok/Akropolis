package controller;

import hello.annotation.Mapping;
import hello.annotation.RootURL;
import hello.mv.ModelView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import util.FaceBookAuth;
import bean.DebateManager;
import bean.FaceBook;
import bean.User;
import bean.SubTopic;

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
		FaceBookAuth fba = new FaceBookAuth();
		HttpSession session = request.getSession();
		UserDAO udao = new UserDAO();
		User user = null;
		List<String> list = null;
		
		if(session.getAttribute("accessToken") == null){
			list = fba.getAuth(fb, request.getServletContext().getInitParameter("appID"), request.getServletContext().getInitParameter("callback"), request.getServletContext().getInitParameter("appSecret"));
			if(list == null){
				mv.setView("/fail");
			}else{
				session.setAttribute("accessToken", list.get(0));
			}
		}
		if(session.getAttribute("email") == null){
			JSONObject json = fba.getInfo((String)session.getAttribute("accessToken"));
			if(json == null){
				mv.setView("/fail");
			}else{
				user = udao.getUser((String)json.get("email"));
				if(user == null){
					user = fba.JSONUserMapper(json);
					udao.setUser(user);
				}else{
					JSONArray array = (JSONArray)json.get("education");
					JSONObject obj = (JSONObject)array.get(array.size()-1);
					user.setEducation((String)((JSONObject)obj.get("school")).get("name"));
				}
				session.setAttribute("user",user);
			}
		}
		return mv;
	}
	
	@Mapping(url="/decotest.ap")
	ModelView deco(HttpServletRequest request,HttpServletResponse response){
		ModelView mv = new ModelView("/decotest");
		UserDAO dao = new UserDAO();
		User user = dao.getUser("oojoo2n@naver.com");
		if(user == null){
			System.out.println("null");
		}else{
			System.out.println("not null");
		}
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