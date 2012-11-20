package controller;

import hello.annotation.Mapping;
import hello.annotation.RootURL;
import hello.mv.ModelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BeanTest;


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
}