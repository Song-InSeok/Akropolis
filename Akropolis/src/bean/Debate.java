package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Debate implements Serializable{
	// subject arraylist
	private ArrayList<Subject> subs = new ArrayList<Subject>();
	private int did;
	private String user; // Make User Email
	private String title;
	private int date;
	private int agree;
	private int disagree;
	private boolean isClose;
	private int cu_sub;
	
	public Debate(){
	
	}
	public Debate makeDebate(int did,int subNum){
		//find debate by did
		//가져온 debate의 소주제 가져옴
		// 필요한 소주제에 의견채움;
		return this;
	}
	public ArrayList<Subject> getSubs() {
		return subs;
	}

	public void setSubs(ArrayList<Subject> subs) {
		this.subs = subs;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getAgree() {
		return agree;
	}

	public void setAgree(int agree) {
		this.agree = agree;
	}

	public int getDisagree() {
		return disagree;
	}

	public void setDisagree(int disagree) {
		this.disagree = disagree;
	}

	public boolean isClose() {
		return isClose;
	}

	public void setClose(boolean isClose) {
		this.isClose = isClose;
	}

	public int getCu_sub() {
		return cu_sub;
	}

	public void setCu_sub(int cu_sub) {
		this.cu_sub = cu_sub;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
}
