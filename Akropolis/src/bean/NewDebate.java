package bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class NewDebate implements Serializable {

	private String email;
	private String mt;
	private int st;
	private List<String> tag;
	private List<SubTopic> stList;
	private Date sDate;
	private Date eDate;
	private boolean invite;

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

	public List<String> getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag.add(tag);
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

	public boolean isInvite() {
		return invite;
	}

	public void setInvite(boolean invite) {
		this.invite = invite;
	}

}
