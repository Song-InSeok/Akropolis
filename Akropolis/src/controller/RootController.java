package controller;

import hello.annotation.Mapping;
import hello.annotation.RootURL;
import hello.mv.ModelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MainTopicDAO;
import dao.OpinionDAO;
import dao.SubTopicDAO;

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
	
	@Mapping(url="/decotest.ap")
	ModelView deco(HttpServletRequest request,HttpServletResponse response){
		ModelView mv = new ModelView("/decotest");
		return mv;
	}
	
	@Mapping(url="/debate.ap")
	ModelView debate(HttpServletRequest request,HttpServletResponse response){
		MainTopicDAO mdao = new MainTopicDAO();
		SubTopicDAO sdao = new SubTopicDAO();
		OpinionDAO odao = new OpinionDAO();
		
		System.out.println(mdao.getMainTopic(2).getMt_title());
		System.out.println(sdao.getSubTopics(2).size());
		System.out.println(odao.getOpinions(2, 2).size());
		
		
		
		ModelView mv = new ModelView("/debate");
		return mv;
	}
}