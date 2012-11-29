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