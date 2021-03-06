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
	private List<MainTopic> simList;
	private SubTopic subTopic;
	private String flag;
	private User logUser;
	private int isLogin;
	private int isPt;
	private Participant logPt;
	private String alert;
	private String isMine;
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

	public int getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}

	public User getLogUser() {
		return logUser;
	}

	public void setLogUser(User logUser) {
		this.logUser = logUser;
	}

	public Participant getLogPt() {
		return logPt;
	}

	public void setLogPt(Participant logPt) {
		this.logPt = logPt;
	}

	public int getIsPt() {
		return isPt;
	}

	public void setIsPt(int isPt) {
		this.isPt = isPt;
	}

	public SubTopic getSubTopic() {
		return subTopic;
	}

	public void setSubTopic(SubTopic subTopic) {
		this.subTopic = subTopic;
	}

	public List<MainTopic> getSimList() {
		return simList;
	}

	public void setSimList(List<MainTopic> simList) {
		this.simList = simList;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public String getIsMine() {
		return isMine;
	}

	public void setIsMine(String isMine) {
		this.isMine = isMine;
	}
}
