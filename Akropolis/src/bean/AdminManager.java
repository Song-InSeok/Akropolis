package bean;

import java.util.List;

public class AdminManager {
	List<User> userList;
	List<Participant> partList;
	List<Report>	reportList;
	List<User> banList;
	List<User> inviteList;
	String isOpen;
	User loginUser;
	int mt_id;
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<Participant> getPartList() {
		return partList;
	}
	public void setPartList(List<Participant> partList) {
		this.partList = partList;
	}
	public List<Report> getReportList() {
		return reportList;
	}
	public void setReportList(List<Report> reportList) {
		this.reportList = reportList;
	}
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	public User getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	public int getMt_id() {
		return mt_id;
	}
	public void setMt_id(int mt_id) {
		this.mt_id = mt_id;
	}
	public List<User> getBanList() {
		return banList;
	}
	public void setBanList(List<User> banList) {
		this.banList = banList;
	}
	public List<User> getInviteList() {
		return inviteList;
	}
	public void setInviteList(List<User> inviteList) {
		this.inviteList = inviteList;
	}
}
