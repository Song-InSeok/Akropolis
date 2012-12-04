package controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import hello.annotation.Mapping;
import hello.annotation.RootURL;
import hello.mv.ModelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BeanTest;
import bean.Interest;
import bean.NewDebate;
import bean.User;
import dao.InterestDAO;
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
		request.setAttribute("user", new User());
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
	
	@Mapping(url="/nowDebate.ap",bean="bean.BeanTest" ) //bean 사용 안할시 bean 빼면됨
	ModelView nowDebate(HttpServletRequest request,HttpServletResponse response,Object bean){ // bean 사용 안할시 Object bean 빼면됨
		//Model(Bean)
		BeanTest bt = (BeanTest)bean; //캐스팅해서 적절히 사용
		ModelView mv = new ModelView("/mypage/nowDebate");
		
		//request.setAttribute("model",mv); 가 자동으로 등록됨
		//따라서 꺼낼시에  ((ModelView)request.getAttribute("model")).getModel("id"); 로 꺼낸다
		mv.setModel("id", "younghak");
		return mv;
	}
	@Mapping(url="/pastDebate.ap",bean="bean.BeanTest") //bean 사용 안할시 bean 빼면됨
	ModelView pastDebate(HttpServletRequest request,HttpServletResponse response,Object bean){ // bean 사용 안할시 Object bean 빼면됨
		//Model(Bean)
		BeanTest bt = (BeanTest)bean; //캐스팅해서 적절히 사용
		ModelView mv = new ModelView("/mypage/pastDebate");
		
		//request.setAttribute("model",mv); 가 자동으로 등록됨
		//따라서 꺼낼시에  ((ModelView)request.getAttribute("model")).getModel("id"); 로 꺼낸다
		mv.setModel("id", "younghak");
		return mv;
	}
	@Mapping(url="/newDebate.ap",bean="bean.NewDebate") //bean 사용 안할시 bean 빼면됨
	ModelView newDebate(HttpServletRequest request,HttpServletResponse response,Object bean){ // bean 사용 안할시 Object bean 빼면됨
		//Model(Bean)
		
		ModelView mv = new ModelView("/mypage/newDebate");

		//request.setAttribute("model",mv); 가 자동으로 등록됨
		//따라서 꺼낼시에  ((ModelView)request.getAttribute("model")).getModel("id"); 로 꺼낸다
		mv.setModel("id", "younghak");
		return mv;
	}
	@Mapping(url="/newDebate.ap",bean="bean.NewDebate",method="POST") //bean 사용 안할시 bean 빼면됨
	ModelView newPostDebate(HttpServletRequest request,HttpServletResponse response,Object bean){ // bean 사용 안할시 Object bean 빼면됨
		//Model(Bean)
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String email = user.getEmail();
		
		NewDebate newDebate = new NewDebate();
		newDebate.setEmail(email);
		

		newDebate.setMt(request.getParameter("mTopic"));
//여기수정하는중		
		newDebate.setTag("tag");
		

		ModelView mv = new ModelView("/mypage/adminDebate");
		System.out.printf("success");
		//request.setAttribute("model",mv); 가 자동으로 등록됨
		//따라서 꺼낼시에  ((ModelView)request.getAttribute("model")).getModel("id"); 로 꺼낸다
		mv.setModel("id", "younghak");
		return mv;
	}
	@Mapping(url="/profile.ap",bean="bean.User")
	ModelView getProfile(HttpServletRequest request,HttpServletResponse response,Object bean){	
		
		List<Interest> interestList;
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String follower=null;
		String email = user.getEmail();
		String education = user.getEducation();
		
		UserDAO userDao = new UserDAO();
		interestList = new ArrayList<Interest>();
		user.setInterestList(interestList);
		user = userDao.getUser(email);
		user.setEducation(education);
		
		InterestDAO interestDao = new InterestDAO();
		interestList = interestDao.getInterestList();		// select all interest
		
		ModelView mv = new ModelView("/mypage/profile");
		
		follower=request.getParameter("follower");
		if(follower!=null && !(follower.equals(""))) {
			userDao.deleteFollower(follower, email);
			mv.setModel("msg", "Success : Deletion");
		}

		List<User> followerList=userDao.getFollowerList(user.getEmail());

		mv.setModel("user", user);
		mv.setModel("followerList",followerList);
		mv.setModel("interestList", interestList);
		return mv;
	}
	
	@Mapping(url="/profile.ap", bean="bean.User", method="POST")
	ModelView postProfile(HttpServletRequest request,HttpServletResponse response,Object bean){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String say;
		List<Interest> interestList;		// user interestList
		
		User user = (User)bean;
		UserDAO userDao = new UserDAO();
		InterestDAO interestDao = new InterestDAO();
		
		HttpSession session = request.getSession();
		user = (User)session.getAttribute("user");
		
		say=request.getParameter("say");
		String interests[] = new String[3];
		interests[0] = request.getParameter("interest1");
		interests[1] = request.getParameter("interest2");
		interests[2] = request.getParameter("interest3");
		System.out.println(say);
		interestList = new ArrayList<Interest>();
		
		for(int i=0;i<3;i++){
			boolean flag=true;
			for(int j=0;j<i;j++){
				if(i!=j && interests[i].equals(interests[j])){
					flag=false;
				}
			}
			if(flag){
				interestList.add(new Interest(interests[i]));
				interestList.get(interestList.size()-1).setId(interestDao.getInterestID(interests[i]));
			}
		}
		
		user.setSay(say);
		user.setInterestList(interestList);
		userDao.setSay(user);
		userDao.setInterest(user);
		
		List<User> followerList=userDao.getFollowerList(user.getEmail());
		interestList = interestDao.getInterestList();		// select all interest
		
		ModelView mv = new ModelView("/mypage/profile");
		mv.setModel("user", user);
		mv.setModel("followerList",followerList);
		mv.setModel("interestList", interestList);
		return mv;
	}
	@Mapping(url="/addFollower.ap", bean="bean.User", method="POST")
	ModelView addFollower(HttpServletRequest request,HttpServletResponse response,Object bean){
		User user = (User)bean;
		HttpSession session = request.getSession();
		user = (User)session.getAttribute("user");
		
		String msg = null;
		String following = user.getEmail();
		String follower = null;
		follower = request.getParameter("followerEmail");

		if(follower!=null && !(follower.equals("")) && !(follower.equals(following))) {
			UserDAO userDao = new UserDAO();
			msg = userDao.insertFollower(follower, following);
		}
		if(follower.equals(following)){
			msg="You never can be your follower";
		}
		ModelView mv = getProfile(request, response, bean);
		mv.setModel("msg", msg);
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
