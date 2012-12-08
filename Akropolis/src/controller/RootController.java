package controller;

import hello.annotation.Mapping;
import hello.annotation.RootURL;
import hello.mv.ModelView;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import util.DebatePageManager;
import util.FaceBookAuth;
import bean.FaceBook;
import bean.MainTopic;
import bean.PageResult;
import bean.User;
import dao.MainTopicDAO;
import dao.UserDAO;



@RootURL("/")
public class RootController {
	
	@Mapping(url="/main.ap", method="GET")
	ModelView getMain(HttpServletRequest request,HttpServletResponse response){

		int page;
		PageResult<MainTopic> result=null;
		String option = request.getParameter("option");
		String text = request.getParameter("text");
		MainTopicDAO mainTopicDao = new MainTopicDAO();
		if(request.getParameter("page")!=null){
			page = Integer.parseInt((request.getParameter("page")));
		}
		else page=1;

		if (option == null || option.equals("") || option.equals("hot")) {
			result = mainTopicDao.getHotPage(page);	
			
		} else if (option.equals("lately")) {
			result = mainTopicDao.getLately(page);
		} else if(option.equals("Title")){
			result = mainTopicDao.getTitleSearch(page, text);
		}
		
		ModelView mv = new ModelView("/main");
		mv.setModel("option", option);
		mv.setModel("text", text);
		mv.setModel("result", result);
		return mv;
	}
	
	@Mapping(url="/main.ap", method="POST")
	ModelView getPost(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		int page = 1;
		PageResult<MainTopic> result=null;
		MainTopicDAO mainTopicDao = new MainTopicDAO();
		String searchOption = request.getParameter("searchOption");
		String searchText = request.getParameter("searchText");

		if(searchOption.equals("Title")){
			result = mainTopicDao.getTitleSearch(page, searchText);
		}else if(searchOption.equals("Tag")){
			result = mainTopicDao.getTagSearch(page, searchText);
		}
		ModelView mv = new ModelView("/main");
		mv.setModel("option", searchOption);
		mv.setModel("text", searchText);
		mv.setModel("result", result);
		return mv;
	}

	@Mapping(url="/autocomplete.ap")
	ModelView autoComplete(HttpServletRequest request,HttpServletResponse response){
		ModelView mv = new ModelView("/autocomplete");
		String searchText = request.getParameter("searchText");
		String type = request.getParameter("type");
		MainTopicDAO dao = new MainTopicDAO();
		if(type.equals("Tag")){
			mv.setModel("list", dao.getTagAuto(searchText));
		}else if(type.equals("Title")){
			mv.setModel("list", dao.getTitleAuto(searchText));
		}
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
	
	@Mapping(url="/logout.ap")
	ModelView logout(HttpServletRequest request,HttpServletResponse response){
		ModelView mv = new ModelView("redirect:/Akropolis/main.ap");
		request.getSession().invalidate();
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
	@Mapping(url="/debate.ap",method="POST")
	ModelView debatePost(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		ModelView mv=null;
		String post_type = request.getParameter("post_type");
		System.out.println("post_type : "+post_type);
	try{
//		boolean isSuccess=DebatePageManager.submitPage(request, response);
		String st,mt;
		mt=request.getParameter("mtmt");
		st=request.getParameter("stst");		

		User loginUser = (User)request.getSession().getAttribute("user");
		if(loginUser==null){
			mv = new ModelView("redirect:/Akropolis/debate.ap?mt="+mt+"&st="+st+"&err=L");
			return mv;
		}

		if(post_type.equals("add_opinion")){
			DebatePageManager.insertOP(request, response);
		}else if(post_type.equals("no_btn")){
			DebatePageManager.vote(request, response, "N");
		}else if(post_type.equals("yes_btn")){
			DebatePageManager.vote(request, response, "Y");
		}else if(post_type.equals("request_join")){
			DebatePageManager.changeReq(request, response, "D");
		}else if(post_type.equals("access_join")){
			DebatePageManager.changeReq(request, response, "Y");
		}else if(post_type.equals("thumbs_up")){
			DebatePageManager.thumbsUp(request, response);
		}else if(post_type.equals("report")){
			DebatePageManager.insertReport(request,response);
			System.out.println("report op id : "+request.getParameter("opop")+"\n신고내용 : "+request.getParameter("reportarea"));
		}
		//else mv = new ModelView("/error");
		System.out.println("debate post");
		
		mv = new ModelView("redirect:/Akropolis/debate.ap?mt="+mt+"&st="+st);
		return mv;
	}catch(Exception e){
		e.printStackTrace();
		mv = new ModelView("/error");
	}finally{
		
	}
	return mv;
}
	@Mapping(url="/debate.ap",method="GET")
	ModelView debate(HttpServletRequest request,HttpServletResponse response){
//		User loginUser;
//		MainTopicDAO mdao = new MainTopicDAO();
//		SubTopicDAO sdao = new SubTopicDAO();
//		OpinionDAO odao = new OpinionDAO();
//		UserDAO udao = new UserDAO();
//		int mt_id,st_id,st_O,st_L;
//		boolean flag=false;
		ModelView mv = null;
//		mt_id=st_id=st_O=st_L=0;
		
		try{
//			if(request.getParameter("mt")!=null) 	mt_id = Integer.parseInt(request.getParameter("mt"));
//			if(request.getParameter("st")!=null) st_id = Integer.parseInt(request.getParameter("st"));
//			loginUser = (User)request.getSession().getAttribute("user");
//			System.out.println(mt_id+" "+st_id+" "+loginUser);
//			
//			if(mt_id==0){
//				if((loginUser=(User)request.getSession().getAttribute("user"))==null){
//					mv = new ModelView("/error");
//					return mv;
//				}else{
//					mt_id = new UserDAO().getUsersDebate(loginUser.getEmail());
//				}
//			}
//			
//			DebateManager dm = new DebateManager();
//			dm.setMt(mdao.getMainTopic(mt_id));
//			dm.setStList(sdao.getSubTopics(mt_id));
//			dm.setUserList(udao.getDebateUsers(mt_id));
//			
//			
//			List<SubTopic> slist = dm.getStList();
//			for(int i=0;i<slist.size();i++){
//				if((st_L=slist.get(i).getSub_id())==st_id) flag=true;
//				if(slist.get(i).getSub_close().equals("O")) st_O = slist.get(i).getSub_id();
//			}
//			if(flag) dm.setSt(st_id);
//			else if(!flag&&st_O!=0) dm.setSt(st_O);
//			else dm.setSt(st_L);
//			
//			
//			dm.setOpList(odao.getOPs(mt_id, dm.getSt()));
//			
//			System.out.println(dm.getSt()+" "+st_O+" "+st_L+" "+dm.getSt()+" flag = "+dm.getUserList().get(0).getFlag());
//			if(dm.getOpList().size()>0){
//				System.out.println(dm.getOpList().get(0).getFlag()+" " +dm.getOpList().get(0).getPhoto()+" " +dm.getOpList().get(0).getE_mail());
//			}else{
//				System.out.println("size = "+dm.getOpList().size());
//			}
//
//			
//			System.out.println(dm.getMt().getMt_title());
//			System.out.println(dm.getStList().size());
//			System.out.println(dm.getOpList().size());
//			request.setAttribute("debatemanager", dm);
			if(DebatePageManager.makePage(request, response)) mv = new ModelView("/debate");
			else mv = new ModelView("/debate");
			System.out.println("debate servlet complete");
			return mv;
		}catch(Exception e){
			e.printStackTrace();
			mv = new ModelView("/error");
		}finally{
			
		}
		return mv;


	}
}