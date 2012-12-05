package bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class NewDebate implements Serializable {

	private String email;
	private String mt;
	private int st;
	private List<tagList> tag;
	private List<SubTopic> stList;
	private Date sDate;
	private Date eDate;
	private String invite;
	private boolean isinvite; 

	public NewDebate() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMt() {
		return mt;
	}

	public void setMt(String mTopic) {
		this.mt = mTopic;
	}

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

		

	public List<SubTopic> getStList() {
		return stList;
	}

	public void setStList(List<SubTopic> stList) {
		this.stList = stList;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}


	public void setInvite(String invite) {
		this.invite = invite;
		this.setIsinvite(invite);
	}

	
	public String getInvite() {
		return invite;
	}

	public boolean isIsinvite() {
		return isinvite;
	}

	public void setIsinvite(String invite) {
		if(invite.equals("yes")){
			this.isinvite = true;
		}else{
			this.isinvite = false;
		}
	}

	public List<tagList> getTag() {
		return tag;
	}

	public void setTag(List<tagList> tag) {
		this.tag = tag;
	}

}
