package bean;

import java.io.Serializable;
import java.util.List;

public class DebateManager implements Serializable {
	private MainTopic mt;
	private int st;
	private List<SubTopic> stList;
	private List<Opinion>	opList;
	private List<User>	userList;
	private List<Participant>	ptList;
	private String flag;
	public DebateManager(){
		
	}

	public MainTopic getMt() {
		return mt;
	}

	public void setMt(MainTopic mt) {
		this.mt = mt;
	}

	public List<SubTopic> getStList() {
		return stList;
	}

	public void setStList(List<SubTopic> stList) {
		this.stList = stList;
	}

	public List<Opinion> getOpList() {
		return opList;
	}

	public void setOpList(List<Opinion> opList) {
		this.opList = opList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Participant> getPtList() {
		return ptList;
	}

	public void setPtList(List<Participant> ptList) {
		this.ptList = ptList;
	}

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
