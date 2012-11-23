package controller;

import hello.annotation.Mapping;
import hello.annotation.RootURL;
import hello.mv.ModelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BeanTest;
import bean.User;
import dao.UserDAO;



@RootURL("/mypage")
public class MyPageController {

	@Mapping(url="/decotest.ap",bean="bean.BeanTest") //bean 사용 안할시 bean 빼면됨
	ModelView deco(HttpServletRequest request,HttpServletResponse response,Object bean){ // bean 사용 안할시 Object bean 빼면됨
		//Model(Bean)
		BeanTest bt = (BeanTest)bean; //캐스팅해서 적절히 사용
		ModelView mv = new ModelView("/mypage/decotest");
		
		//Mybatis 사용예제
		UserDAO dao = new UserDAO();
		User user = dao.getUser("younghak@gmail.com");
		dao.getUserList();
		mv.setModel("user", user);
		
		//request.setAttribute("model",mv); 가 자동으로 등록됨
		//따라서 꺼낼시에  ((ModelView)request.getAttribute("model")).getModel("id"); 로 꺼낸다
		mv.setModel("id", "younghak");
		return mv;
	}
	
	@Mapping(url="/adminDebate.ap",bean="bean.BeanTest") //bean 사용 안할시 bean 빼면됨
	ModelView adminDebate(HttpServletRequest request,HttpServletResponse response,Object bean){ // bean 사용 안할시 Object bean 빼면됨
		//Model(Bean)
		BeanTest bt = (BeanTest)bean; //캐스팅해서 적절히 사용
		ModelView mv = new ModelView("/mypage/adminDebate");
		
		//request.setAttribute("model",mv); 가 자동으로 등록됨
		//따라서 꺼낼시에  ((ModelView)request.getAttribute("model")).getModel("id"); 로 꺼낸다
		mv.setModel("id", "younghak");
		return mv;
	}
	
	@Mapping(url="/adminPerson.ap",bean="bean.BeanTest") //bean 사용 안할시 bean 빼면됨
	ModelView adminPerson(HttpServletRequest request,HttpServletResponse response,Object bean){ // bean 사용 안할시 Object bean 빼면됨
		//Model(Bean)
		BeanTest bt = (BeanTest)bean; //캐스팅해서 적절히 사용
		ModelView mv = new ModelView("/mypage/adminPerson");
		
		//request.setAttribute("model",mv); 가 자동으로 등록됨
		//따라서 꺼낼시에  ((ModelView)request.getAttribute("model")).getModel("id"); 로 꺼낸다
		mv.setModel("id", "younghak");
		return mv;
	}
	
	@Mapping(url="/newDebate.ap",bean="bean.BeanTest") //bean 사용 안할시 bean 빼면됨
	ModelView newDebate(HttpServletRequest request,HttpServletResponse response,Object bean){ // bean 사용 안할시 Object bean 빼면됨
		//Model(Bean)
		BeanTest bt = (BeanTest)bean; //캐스팅해서 적절히 사용
		ModelView mv = new ModelView("/mypage/newDebate");
		
		//request.setAttribute("model",mv); 가 자동으로 등록됨
		//따라서 꺼낼시에  ((ModelView)request.getAttribute("model")).getModel("id"); 로 꺼낸다
		mv.setModel("id", "younghak");
		return mv;
	}
	
	@Mapping(url="/profile.ap")
	ModelView profile(HttpServletRequest request,HttpServletResponse response){
		//Model(Bean)
		ModelView mv = new ModelView("/mypage/profile");
		return mv;
	}
	@Mapping(url="/timeline.ap")
	ModelView timeline(HttpServletRequest request,HttpServletResponse response){
		//Model(Bean)
		ModelView mv = new ModelView("/mypage/timeline");
		return mv;
	}
	
	/*
	 * Controller 클래스 기본 형태1
	 * @RootURL(Contextpath 제외한 URL에서 앞부분에서 매칭될 부분)
	 * 
	 * 함수의 기본 형태 1
	 * @Mapping(url=RootURL을 제외한 나머지 URL에서 매칭될 부분[,bean=bean의 풀패스 클래스 이름])
	 * ModelView 함수이름(HttpServletRequest request,HttpServletResponse response){
	 * 		ModelView mv = new ModelView(뷰이름);
	 * 		return mv;
	 * }
	 * 
	 * 함수의 기본 형태 2(bean을 사용 하는 경우)
	 * @Mapping(url=RootURL을 제외한 나머지 URL에서 매칭될 부분[,bean=bean의 풀패스 클래스 이름])
	 * ModelView 함수이름(HttpServletRequest request,HttpServletResponse response,Object bean){
	 * 		ModelView mv = new ModelView(뷰이름);
	 * 		return mv;
	 * }
	 */
}
