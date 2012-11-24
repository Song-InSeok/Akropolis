package controller;

import hello.annotation.Mapping;
import hello.annotation.RootURL;
import hello.mv.ModelView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MainTopic;
import bean.Opinion;
import dao.MainTopicDAO;
import dao.OpinionDAO;
import dao.SubTopicDAO;



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
		int mt_id,st_id;
		mt_id = 2;
		st_id = 2;
		MainTopic mt = mdao.getMainTopic(mt_id);
		mt.setSubs(sdao.getSubTopics(mt_id));
		List<Opinion> opinion_list = odao.getOpinions(mt_id, st_id);
		//System.out.println(mdao.getMainTopic(2).getMt_title());
		//System.out.println(sdao.getSubTopics(2));
		//System.out.println(odao.getOpinions(2, 2).size());
		System.out.println(mt.getMt_title());
		System.out.println(mt.getSubs().size());
		System.out.println(opinion_list.size());
		
		
		
		ModelView mv = new ModelView("/debate");
		return mv;
	}
}