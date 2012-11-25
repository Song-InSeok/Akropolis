package controller;

import hello.annotation.Mapping;
import hello.annotation.RootURL;
import hello.mv.ModelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DebateManager;
import bean.User;

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
		ModelView mv = new ModelView("/main");
		FaceBook fb = (FaceBook)bean;
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
//			MainTopic mt = mdao.getMainTopic(mt_id);
//			mt.setSubs(sdao.getSubTopics(mt_id));
//			List<Opinion> opinion_list = odao.getOpinions(mt_id, st_id);
			//System.out.println(mdao.getMainTopic(2).getMt_title());
			//System.out.println(sdao.getSubTopics(2));
			//System.out.println(odao.getOpinions(2, 2).size());			
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