package controller;

import hello.annotation.Mapping;
import hello.annotation.RootURL;
import hello.mv.ModelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BeanTest;

@RootURL("/mypage")
public class AkroController {
	@Mapping(url="/ssss.ap",bean="bean.BeanTest")
	ModelView deco(HttpServletRequest request,HttpServletResponse response,Object bean){
		//Model(Bean)
		BeanTest bt = (BeanTest)bean;
		System.out.println(bt.getId());
		System.out.println(bt.getPwd());
		ModelView mv = new ModelView("/mypage/decotest");
		return mv;
	}
}
