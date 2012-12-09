package util;

import hello.mv.ModelView;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DebateManager;
import bean.Opinion;
import bean.Participant;
import bean.Report;
import bean.SubTopic;
import bean.Thumbsup;
import bean.User;
import dao.EtcDAO;
import dao.MainTopicDAO;
import dao.OpinionDAO;
import dao.ParticipantDAO;
import dao.SubTopicDAO;
import dao.UserDAO;

public class DebatePageManager {
	public DebatePageManager(){
		
	}
	public static boolean following(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		UserDAO udao = new UserDAO();
		int i=0;
		User loginUser = (User)request.getSession().getAttribute("user");
		String following = request.getParameter("following");
		String follower = loginUser.getEmail();
		udao.insertFollower(following, follower);
		System.out.println("following.....");
		return true;
	}

	public static boolean deleteOp(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		OpinionDAO odao = new OpinionDAO();
		int op = Integer.parseInt(request.getParameter("opop"));
		int i = odao.deleteOP(op);
		if(i>0)System.out.println("delete success");
		else System.out.println("delete fail");
		return true;
	}
	public static boolean thumbsUp(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		EtcDAO edao = new EtcDAO();
		OpinionDAO odao = new OpinionDAO();
		UserDAO udao = new UserDAO();
		Opinion newopinion,preopinion;
		User loginUser = (User)request.getSession().getAttribute("user");
		String email=loginUser.getEmail();
		int op = Integer.parseInt(request.getParameter("opop"));
		int mt = Integer.parseInt(request.getParameter("mtmt"));
		int st =  Integer.parseInt(request.getParameter("stst"));
		Thumbsup t = new Thumbsup();
		Thumbsup tup=null;
		newopinion = odao.getOP(op);
		
		t.setE_mail(email);
		t.setSub_id(st);
		t.setOpinion_id(op);
		tup = edao.getThumbsup(t);
		if(tup==null){
			edao.insertThumbsup(t);
			udao.honorPP(newopinion.getE_mail());
			odao.changeHonor(0, op);
		}else{
			preopinion = odao.getOP(tup.getOpinion_id());
			edao.updateThumbsup(t);
			udao.honorPP(newopinion.getE_mail());
			udao.honorMM(preopinion.getE_mail());
			odao.changeHonor(preopinion.getOpinion_id(), op);
		}
		System.out.println("thumbs up end");
		return true;
	}

	public static boolean insertReport(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		EtcDAO edao = new EtcDAO();
		OpinionDAO odao = new OpinionDAO();
		UserDAO udao = new UserDAO();
		Opinion opinion;
		User loginUser = (User)request.getSession().getAttribute("user");
		String email=loginUser.getEmail();
		int op = Integer.parseInt(request.getParameter("opop"));
		String content = request.getParameter("reportarea");
		Report report = new Report();
		report.setContent(content);
		report.setE_mail(email);
		report.setOpinion_id(op);
		if(edao.insertReport(report)<=0) return false;
		else{
			opinion = odao.getOP(op);
			udao.disPP(opinion.getE_mail());
		}
		System.out.println("insertReport");
		return true;
	}
	
	public static boolean changeReq(HttpServletRequest request,HttpServletResponse response,String req) throws UnsupportedEncodingException{
		ParticipantDAO pdao = new ParticipantDAO();
		User loginUser = (User)request.getSession().getAttribute("user");
		String email = loginUser.getEmail(); 
		int mt = Integer.parseInt(request.getParameter("mtmt"));
		Participant pt = pdao.getParticipant(email, mt);
		if(pt!=null){
			System.out.println("pt != null");
			pt.setRequest(req);
//			pdao.changeReq(pt);
			pdao.updateRequest(pt);
		}else{
			System.out.println("pt == null");
			pt = new Participant();
			pt.setE_mail(email);
			pt.setMt_id(mt);
			pt.setReport(0);
			pt.setFlag(null);
			pt.setRequest(req);
			pdao.insertParticipant(pt);
		}
		System.out.println("change req end");

		return true;
	}
	public static boolean submitPage(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("chatarea1"));
		System.out.println(request.getParameter("mtmt"));
		System.out.println(request.getParameter("stst"));
		System.out.println(request.getParameter("post_type"));
		
		return true;
	}
	public static boolean insertOP(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		Opinion op = new Opinion();
		OpinionDAO odao = new OpinionDAO();

		User loginUser = (User)request.getSession().getAttribute("user");
		op.setContent(request.getParameter("chatarea1"));
		op.setMt_id(Integer.parseInt(request.getParameter("mtmt")));
		op.setSub_id(Integer.parseInt(request.getParameter("stst")));
		op.setE_mail(loginUser.getEmail());
		System.out.println("넣겠음 "+op.getE_mail()+" "+op.getContent()+" "+op.getMt_id()+" "+op.getSub_id());
		if(odao.insertOP(op)<1) System.out.println("insert fail");
		else System.out.println("insert success"); 
		
		return true;
	}
	public static boolean vote(HttpServletRequest request,HttpServletResponse response,String flag) throws UnsupportedEncodingException{
		ParticipantDAO pdao = new ParticipantDAO();
		MainTopicDAO mdao = new MainTopicDAO();
		User loginUser = (User)request.getSession().getAttribute("user");
		int res=0;
		Participant pt = null;
		Participant pt2 = new Participant();
		pt2.setE_mail(loginUser.getEmail());
		pt2.setMt_id(Integer.parseInt(request.getParameter("mtmt")));
		pt2.setFlag(flag);
		pt2.setRequest("B");
		pt = pdao.getParticipant(pt2.getE_mail(), pt2.getMt_id());
		if(pt==null){
			System.out.println("insert ");
			if(pdao.insertParticipant(pt2)==0) System.out.println("insert fail");
			else System.out.println("insert success");
		}else{
			System.out.println("update");
			if(pdao.updateFlag(pt2)==0) System.out.println("update fail");
			else System.out.println("update Success");
		}
		mdao.updateFlag(pt2.getMt_id());
		return true;
	}
	
	public static boolean makePage(HttpServletRequest request,HttpServletResponse response){
		User loginUser;
		MainTopicDAO mdao = new MainTopicDAO();
		SubTopicDAO sdao = new SubTopicDAO();
		OpinionDAO odao = new OpinionDAO();
		UserDAO udao = new UserDAO();
		ParticipantDAO pdao = new ParticipantDAO();
		int mt_id,st_id,st_O,st_L;
		boolean flag=false;
		ModelView mv = null;
		mt_id=st_id=st_O=st_L=0;
		
		if(request.getParameter("mt")!=null) 	mt_id = Integer.parseInt(request.getParameter("mt"));
		if(request.getParameter("st")!=null&&!request.getParameter("st").equals("")) st_id = Integer.parseInt(request.getParameter("st"));
		loginUser = (User)request.getSession().getAttribute("user");
		System.out.println(mt_id+" "+st_id+" "+loginUser);
		if(mt_id==0){
			if(loginUser==null){
				return false;
			}else{
				mt_id = new UserDAO().getUsersDebate(loginUser.getEmail());
			}
		}
		
		DebateManager dm = new DebateManager();
		dm.setMt(mdao.getMainTopic(mt_id));
		dm.setStList(sdao.getSubTopics(mt_id));
		dm.setUserList(udao.getDebateUsers(mt_id));
		if(loginUser==null){ 
			dm.setIsLogin(0);
			dm.setIsMine("N");
			dm.setLogUser(loginUser);
		}else{ 
			dm.setIsLogin(1);
			dm.setLogUser(loginUser);
			dm.setLogPt(pdao.getParticipant(loginUser.getEmail(), mt_id));
			if(dm.getLogPt()==null) dm.setIsPt(0);
			else dm.setIsPt(1);
			if(dm.getMt().getE_mail().equals(loginUser.getEmail())) dm.setIsMine("Y");
			else dm.setIsMine("N");
		}

		List<SubTopic> slist = dm.getStList();
		for(int i=0;i<slist.size();i++){
			if((st_L=slist.get(i).getSub_id())==st_id) flag=true;
			if(slist.get(i).getSub_close().equals("O")) st_O = slist.get(i).getSub_id();
		}
		if(flag) dm.setSt(st_id);
		else if(!flag&&st_O!=0) dm.setSt(st_O);
		else dm.setSt(st_L);
		
		dm.setSubTopic(sdao.getSubTopic(mt_id, dm.getSt()));
		System.out.println("subtopic = "+dm.getSubTopic());
		System.out.println("login = "+loginUser);
		
		dm.setOpList(odao.getOPs(mt_id, dm.getSt()));
		dm.setAlert(request.getParameter("err"));
		dm.setSimList(mdao.getSimTopics(dm.getMt()));
		System.out.println("simlist "+dm.getSimList().size()+" ");
//		System.out.println(dm.getSt()+" "+st_O+" "+st_L+" "+dm.getSt()+" flag = "+dm.getUserList().get(0).getFlag());
		if(dm.getOpList().size()>0){
			System.out.println(dm.getOpList().get(0).getFlag()+" " +dm.getOpList().get(0).getPhoto()+" " +dm.getOpList().get(0).getE_mail());
		}else{
			System.out.println("size = "+dm.getOpList().size());
		}

		
		System.out.println(dm.getMt().getMt_title());
		System.out.println(dm.getStList().size());
		System.out.println(dm.getOpList().size() + "isMine "+dm.getIsMine());
		request.setAttribute("debatemanager", dm);
		return true;
	}
	
	
}
