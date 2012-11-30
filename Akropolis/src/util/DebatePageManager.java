package util;

import hello.mv.ModelView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DebateManager;
import bean.SubTopic;
import bean.User;
import dao.MainTopicDAO;
import dao.OpinionDAO;
import dao.SubTopicDAO;
import dao.UserDAO;

public class DebatePageManager {
	public DebatePageManager(){
		
	}
	public static boolean makePage(HttpServletRequest request,HttpServletResponse response){
		User loginUser;
		MainTopicDAO mdao = new MainTopicDAO();
		SubTopicDAO sdao = new SubTopicDAO();
		OpinionDAO odao = new OpinionDAO();
		UserDAO udao = new UserDAO();
		int mt_id,st_id,st_O,st_L;
		boolean flag=false;
		ModelView mv = null;
		mt_id=st_id=st_O=st_L=0;
		
		if(request.getParameter("mt")!=null) 	mt_id = Integer.parseInt(request.getParameter("mt"));
		if(request.getParameter("st")!=null) st_id = Integer.parseInt(request.getParameter("st"));
		loginUser = (User)request.getSession().getAttribute("user");
		System.out.println(mt_id+" "+st_id+" "+loginUser);
		
		if(mt_id==0){
			if((loginUser=(User)request.getSession().getAttribute("user"))==null){
				return false;
			}else{
				mt_id = new UserDAO().getUsersDebate(loginUser.getEmail());
			}
		}
		
		DebateManager dm = new DebateManager();
		dm.setMt(mdao.getMainTopic(mt_id));
		dm.setStList(sdao.getSubTopics(mt_id));
		dm.setUserList(udao.getDebateUsers(mt_id));
		
		
		List<SubTopic> slist = dm.getStList();
		for(int i=0;i<slist.size();i++){
			if((st_L=slist.get(i).getSub_id())==st_id) flag=true;
			if(slist.get(i).getSub_close().equals("O")) st_O = slist.get(i).getSub_id();
		}
		if(flag) dm.setSt(st_id);
		else if(!flag&&st_O!=0) dm.setSt(st_O);
		else dm.setSt(st_L);
		
		
		dm.setOpList(odao.getOPs(mt_id, dm.getSt()));
		
		System.out.println(dm.getSt()+" "+st_O+" "+st_L+" "+dm.getSt()+" flag = "+dm.getUserList().get(0).getFlag());
		if(dm.getOpList().size()>0){
			System.out.println(dm.getOpList().get(0).getFlag()+" " +dm.getOpList().get(0).getPhoto()+" " +dm.getOpList().get(0).getE_mail());
		}else{
			System.out.println("size = "+dm.getOpList().size());
		}

		
		System.out.println(dm.getMt().getMt_title());
		System.out.println(dm.getStList().size());
		System.out.println(dm.getOpList().size());
		request.setAttribute("debatemanager", dm);
		return true;
	}
}
