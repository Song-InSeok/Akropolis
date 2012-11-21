package controller;

import hello.annotation.Mapping;
import hello.annotation.RootURL;
import hello.mv.ModelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@RootURL("/")
public class RootController {

	@Mapping(url="/main.ap")
	ModelView deco(HttpServletRequest request,HttpServletResponse response){
		//Model(Bean)
		ModelView mv = new ModelView("/main");
		return mv;
	}
}