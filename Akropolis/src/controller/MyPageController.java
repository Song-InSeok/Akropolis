package controller;

import hello.annotation.Mapping;
import hello.annotation.RootURL;
import hello.mv.ModelView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import bean.AdminManager;
import bean.BeanTest;
import bean.Follower;
import bean.Interest;
import bean.MainTopic;
import bean.NewDebate;
import bean.Participant;
import bean.Report;
import bean.SubTopic;
import bean.TagTag;
import bean.Timeline;
import bean.User;
import dao.CreateTopicDAO;
import dao.EtcDAO;
import dao.InterestDAO;
import dao.MainTopicDAO;
import dao.OpinionDAO;
import dao.ParticipantDAO;
import dao.SubTopicDAO;
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
	
	@Mapping(url="/adminPerson.ap",bean="bean.BeanTest",method="POST") //bean 사용 안할시 bean 빼면됨
	ModelView adminPersonPost(HttpServletRequest request,HttpServletResponse response,Object bean){ // bean 사용 안할시 Object bean 빼면됨
		
		ModelView mv = new ModelView("redirect:/Akropolis/mypage/adminPerson.ap");
		try{
			ParticipantDAO pdao = new ParticipantDAO();
			EtcDAO edao = new EtcDAO();
			request.setCharacterEncoding("utf-8");
			String post_type = request.getParameter("post_type");
			System.out.println("post_type : "+post_type);
			if(post_type.equals("ban")){
				int mt_id = Integer.parseInt(request.getParameter("mtmt"));
				int rep_id = Integer.parseInt(request.getParameter("rep_id"));
				String e_mail = request.getParameter("e_mail");
				Participant pt = new Participant();
				pt.setMt_id(mt_id);
				pt.setE_mail(e_mail);
				pt.setRequest("X");
				if(pdao.changeReq(pt)>0){
					System.out.println(post_type+" "+mt_id+" "+e_mail+" 추방 성공 ");
					if(edao.deleteReport(rep_id)>0) System.out.println("신고 삭제 성공 "+rep_id);
					else System.out.println("신고 삭제 실패 "+rep_id);
				}else{
					System.out.println(post_type+" "+mt_id+" "+e_mail+" 추방 실패");
				}
			}else if(post_type.equals("access")){
				int mt_id = Integer.parseInt(request.getParameter("mtmt"));
				String e_mail = request.getParameter("e_mail");
				Participant pt = new Participant();
				pt.setMt_id(mt_id);
				pt.setE_mail(e_mail);
				pt.setRequest("Y");
				if(pdao.changeReq(pt)>0){
					System.out.println(post_type+" "+mt_id+" "+e_mail+" 토론요청 수락 성공");
				}else{
					System.out.println(post_type+" "+mt_id+" "+e_mail+" 토론요청 수락 실패");
				}
			}
			
		}catch(Exception e){
			
		}finally{
			
		}
		return mv;

	}
	@Mapping(url="/adminDebate.ap") 
	ModelView adminDebate(HttpServletRequest request,HttpServletResponse response){ 
		//Model(Bean)

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		NewDebate nowDebate=null;
		CreateTopicDAO nowtopicDao = new CreateTopicDAO();
		nowDebate = nowtopicDao.findDebate(user.getEmail());
		
		// subtopic세팅
		SubTopicDAO subtopicDao = new SubTopicDAO();
		List<SubTopic> subtopics = null;
		subtopics = subtopicDao.getSubTopics(nowDebate.getMt_id());
		nowDebate.setSubtopics(subtopics);
		
		//태그가져오기
		List<TagTag> taglist = null;
		taglist = nowtopicDao.getTags(nowDebate.getMt_id());
		nowDebate.setTags(taglist);
		
		System.out.println(nowDebate.getSubtopics().get(0).getStart_time());
		ModelView mv = new ModelView("/mypage/adminDebate");
		
		mv.setModel("nowDebate", nowDebate);
		mv.setModel("user", user);
		return mv;
	}
	
	@Mapping(url="/adminDebate.ap", method="POST") 
	ModelView adminDebatePost(HttpServletRequest request,HttpServletResponse response){ 
		//Model(Bean)

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String subCount = request.getParameter("subCount");
		String tagCount =request.getParameter("tagCount");
		System.out.println(request.getParameter("mTopic"));
		
		NewDebate nowDebate=null;
		CreateTopicDAO nowtopicDao = new CreateTopicDAO();
		nowDebate = nowtopicDao.findDebate(user.getEmail());
		
		// subtopic세팅
		SubTopicDAO subtopicDao = new SubTopicDAO();
		List<SubTopic> subtopics = null;
		subtopics = subtopicDao.getSubTopics(nowDebate.getMt_id());
		nowDebate.setSubtopics(subtopics);
		//태그가져오기
		List<TagTag> taglist = null;
		taglist = nowtopicDao.getTags(nowDebate.getMt_id());
		nowDebate.setTags(taglist);
		//////////////////////////////////////////////////////밑은 새로받을꺼
		
		
		
//		String tagL[] = request.getParameterValues("tag");
		String subTopic[] = request.getParameterValues("sub_title");
		int mt_id=nowDebate.getMt_id();
		//시간 설정부분
		String sDateL[] = request.getParameterValues("sDate");
		String sHour[] = request.getParameterValues("sHour");
		String sMin[] = request.getParameterValues("sMin");

		String eDateL[] = request.getParameterValues("eDate");
		String eHour[] = request.getParameterValues("eHour");
		String eMin[] = request.getParameterValues("eMin");

		
		List<String> start_time= new ArrayList<String>();
		List<String> end_time= new ArrayList<String>();

		//시작시간, 종료시간 다합쳐서 스트링만들기
		if(subTopic!=null){
			for(int i=0;i<subTopic.length;i++){
				start_time.add(i, sDateL[i]+" "+sHour[i]+":"+sMin[i]+":00");
				end_time.add(i, eDateL[i]+" "+eHour[i]+":"+eMin[i]+":00");
			}
			//시간입력테스트
			for(String time : start_time){
				System.out.println(time);
			}

			List<SubTopic> subTopicList = new ArrayList<SubTopic>();

			//subtopicList에 서브토픽정보들 set

			for(int i=0;i<subTopic.length;i++){
				SubTopic subtopic = new SubTopic();
				subtopic.setSub_title(subTopic[i]);
				subtopic.setStart_time(start_time.get(i));
				subtopic.setEnd_time(end_time.get(i));
				subtopic.setMt_id(mt_id);
				subTopicList.add(subtopic);
			}
			nowDebate.setSubtopics(subTopicList);
			for(SubTopic subtopic: nowDebate.getSubtopics()){
				System.out.println("서브토픽들: "+subtopic.getSub_title());
			}
		}

		//태그추가하기
//		System.out.println(taglist.size()); 
//		List<TagTag> tagList = new ArrayList<TagTag>();
//		for(String tag : tagL){  //태그수만큼
//			TagTag tags = new TagTag();  //태그리스트객체를만들고
//			tags.setTag(tag);  // 추가하고 (아이디는 자동카운팅이라니까신경안써도됨)
//			tags.setMt_id(mt_id);
//			tagList.add(tags);  //tagListArray에 계속 넣기
//		}
//		nowDebate.setTags(tagList);
		//태그입력테스트
//		for(TagTag tag : nowDebate.getTags()){
//			System.out.println(tag.getTag());
//		}
//		nowtopicDao.insertANDconnetTag(nowDebate);
		

		CreateTopicDAO changeTopic = new CreateTopicDAO();

		//토론추가
		changeTopic.setSubTopic(nowDebate);

		//추가된거 추가
		List<SubTopic> nowsubtopics = subtopicDao.getSubTopics(mt_id);
		nowDebate.setSubtopics(nowsubtopics);
//		//		System.out.println("추가된거확인 : "+ nowDebate.getSubtopics().get(0).getSub_title());
		////////있다가 수정하자


		ModelView mv = new ModelView("/mypage/adminDebate");
		mv.setModel("nowDebate", nowDebate);
		return mv;
	}

	@Mapping(url="/adminPerson.ap",bean="bean.BeanTest",method="GET") //bean 사용 안할시 bean 빼면됨
	ModelView adminPerson(HttpServletRequest request,HttpServletResponse response,Object bean){ // bean 사용 안할시 Object bean 빼면됨
		//Model(Bean)
		BeanTest bt = (BeanTest)bean; //캐스팅해서 적절히 사용
		ModelView mv = new ModelView("/mypage/adminPerson");
		//		ModelView mv;
		try{
			UserDAO udao = new UserDAO();
			ParticipantDAO pdao = new ParticipantDAO();
			EtcDAO edao = new EtcDAO();
			MainTopicDAO mdao = new MainTopicDAO();
			OpinionDAO odao = new OpinionDAO();

			AdminManager adm = new AdminManager();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			System.out.println("asdfasdf");
			MainTopic mt=null;
			if(user==null) return mv;
			
			adm.setLoginUser(user);
			mt = mdao.getOpenUserTopic(user);
			
			if(mt==null){
				System.out.println("asdf");
				adm.setIsOpen("N");
				request.setAttribute("adminmanager", adm);
				return mv;
			}
			adm.setMt_id(mt.getMt_id());
			adm.setUserList(udao.getJoinUsers(mt.getMt_id()));
			System.out.println("userList size : "+adm.getUserList().size());
			adm.setPartList(pdao.getJoiner(mt.getMt_id()));
			System.out.println("partList size : "+adm.getPartList().size());
			adm.setBanList(udao.getMyUsers(mt.getMt_id(), "B"));
			adm.setInviteList(udao.getMyUsers(mt.getMt_id(), "I"));
			
			List<Report> rl =null;
			rl = edao.getReports(mt.getMt_id());
			adm.setReportList(rl);
			System.out.println("zxcv1");

			if(rl.size()>0){
				for(Report rep : rl){
					rep.setReported(odao.getEmail(rep.getOpinion_id()));
				}
				if(rl!=null)System.out.println("Repots size : "+adm.getReportList().size()+"email email"+adm.getReportList().get(0).getE_mail()+adm.getReportList().get(0).getReported());
			}
			System.out.println("zxcv");
			request.setAttribute("adminmanager", adm);
			
		}catch(Exception e){
			
		}finally{
			
		}
		
		//request.setAttribute("model",mv); 가 자동으로 등록됨
		//따라서 꺼낼시에  ((ModelView)request.getAttribute("model")).getModel("id"); 로 꺼낸다
		mv.setModel("id", "younghak");
		return mv;
	}
	
	@Mapping(url="/nowDebate.ap" ) //bean 사용 안할시 bean 빼면됨
	ModelView nowDebate(HttpServletRequest request,HttpServletResponse response){ // bean 사용 안할시 Object bean 빼면됨
		//Model(Bean)
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		List<NewDebate> mainTopic;
		
		CreateTopicDAO maintopicdao = new CreateTopicDAO();
		System.out.println(user.getEmail());
		mainTopic = maintopicdao.getNowTopic(user.getEmail());
		
		ModelView mv = new ModelView("/mypage/nowDebate");
		
		mv.setModel("topic", mainTopic);
		mv.setModel("user", user);
		return mv;
	}
	
	@Mapping(url="/pastDebate.ap") //bean 사용 안할시 bean 빼면됨
	ModelView pastDebate(HttpServletRequest request,HttpServletResponse response){ // bean 사용 안할시 Object bean 빼면됨
		//Model(Bean)
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		List<NewDebate> mainTopic;
		
		CreateTopicDAO maintopicdao = new CreateTopicDAO();
		System.out.println(user.getEmail());
		mainTopic = maintopicdao.getPastTopic(user.getEmail());
		
		ModelView mv = new ModelView("/mypage/pastDebate");
		
		mv.setModel("topic", mainTopic);
		mv.setModel("user", user);
		return mv;
	}
	@Mapping(url="/newDebate.ap") //bean 사용 안할시 bean 빼면됨
	ModelView newDebate(HttpServletRequest request,HttpServletResponse response){ // bean 사용 안할시 Object bean 빼면됨
		//Model(Bean)
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(MainTopicDAO.isOpen(user.getEmail())){
			ModelView mv = new ModelView("redirect:/Akropolis/mypage/adminDebate.ap");
			return mv;
		}else{
			ModelView mv = new ModelView("/mypage/newDebate");
			return mv;
		}

		//request.setAttribute("model",mv); 가 자동으로 등록됨
		//따라서 꺼낼시에  ((ModelView)request.getAttribute("model")).getModel("id"); 로 꺼낸다
		
	}
	
	@Mapping(url="/newDebate.ap",method="POST",bean="bean.NewDebate")
	ModelView getPostDebate(HttpServletRequest request,HttpServletResponse response,Object bean){ 
		//Model(Bean)
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("success0");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		NewDebate newDebate = (NewDebate) bean;
		System.out.println("메인토픽 : "+newDebate.getMTopic());
		
		String email = user.getEmail();   //로그인된유저로 넘오온 이메일
		//sets attribute
		newDebate.setEmail(email);
		System.out.println(email);
		
		
		
		String tagL[] = request.getParameterValues("tag");  //토픽리스트
		String check = request.getParameter("invite");
		System.out.println("invite= "+check);
		
		String subTopic[] = request.getParameterValues("subTopic");
		int mt_id=-1;
		
		//시간 설정부분
		String sDateL[] = request.getParameterValues("sDate");
		String sHour[] = request.getParameterValues("sHour");
		String sMin[] = request.getParameterValues("sMin");
		
		String eDateL[] = request.getParameterValues("eDate");
		String eHour[] = request.getParameterValues("eHour");
		String eMin[] = request.getParameterValues("eMin");
		
		List<String> start_time= new ArrayList<String>();
		List<String> end_time= new ArrayList<String>();

		//시작시간, 종료시간 다합쳐서 스트링만들기
		for(int i=0;i<subTopic.length;i++){
			start_time.add(i, sDateL[i]+" "+sHour[i]+":"+sMin[i]+":00");
			end_time.add(i, eDateL[i]+" "+eHour[i]+":"+eMin[i]+":00");
		}
		//시간입력테스트
		for(String time : start_time){
			System.out.println(time);
		}

		
		
		CreateTopicDAO createTopicDao = new CreateTopicDAO();
		//mt_id까지 다오로 설정
		createTopicDao.setMainTopic(newDebate);
		mt_id=createTopicDao.getMt_id(newDebate);
		System.out.println("mt_id : "+mt_id);
		newDebate.setMt_id(mt_id);
		createTopicDao.setParticipant(newDebate);
		
		newDebate.setIsinvite(newDebate.getInvite());
		
		List<Follower> followerList =null;
		if(newDebate.getIsinvite()){
			followerList = createTopicDao.findFolower(email); 
		}
		for(Follower follow : followerList){
			follow.setMt_id(mt_id);
			createTopicDao.setFollower(follow);
		}
		

		//위에꺼랑순서바꾸면안됨
		List<SubTopic> subTopicList = new ArrayList<SubTopic>();
		
		//subtopicList에 서브토픽정보들 set
		for(int i=0;i<subTopic.length;i++){
			SubTopic subtopic = new SubTopic();
			subtopic.setSub_title(subTopic[i]);
			subtopic.setStart_time(start_time.get(i));
			subtopic.setEnd_time(end_time.get(i));
			subtopic.setMt_id(mt_id);
			subTopicList.add(subtopic);
		}
		newDebate.setSubtopics(subTopicList);
		for(SubTopic subtopic: newDebate.getSubtopics()){
			System.out.println("서브토픽들: "+subtopic.getSub_title());
		}
		createTopicDao.setSubTopic(newDebate);

		List<TagTag> tagList = new ArrayList<TagTag>();
		for(String tag : tagL){  //태그수만큼
			TagTag tags = new TagTag();  //태그리스트객체를만들고
			tags.setTag(tag);  // 추가하고 (아이디는 자동카운팅이라니까신경안써도됨)
			tags.setMt_id(mt_id);
			tagList.add(tags);  //tagListArray에 계속 넣기
		}
		newDebate.setTags(tagList);
		//태그입력테스트
		for(TagTag tag : newDebate.getTags()){
			System.out.println(tag.getTag());
		}

		createTopicDao.insertANDconnetTag(newDebate);
		ModelView mv = new ModelView("redirect:/Akropolis/debate.ap?mt="+newDebate.getMt_id());
		
		mv.setModel("newDebate", newDebate);  
		

		System.out.printf("All_success");
		//request.setAttribute("model",mv); 가 자동으로 등록됨
		//따라서 꺼낼시에  ((ModelView)request.getAttribute("model")).getModel("id"); 로 꺼낸다
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
		
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("user");
		String email = user.getEmail();
		
		UserDAO userDao=new UserDAO();
		user=userDao.getUser(email);
		
		MainTopicDAO mainTopicDao = new MainTopicDAO();
		List<Timeline> timeline = new ArrayList<Timeline>();
		
		timeline = mainTopicDao.getTimeline(email);
		
		ModelView mv = new ModelView("/mypage/timeline");
		mv.setModel("timeline", timeline);
		mv.setModel("user", user);
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
