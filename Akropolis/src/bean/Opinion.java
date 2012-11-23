package bean;

import java.io.Serializable;

public class Opinion implements Serializable {
	private String user; // user id or Email for finding users info
	private String text; // opinion body
	private int likeIt;
	private int report;
	public Opinion(){
		
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getLikeIt() {
		return likeIt;
	}
	public void setLikeIt(int likeIt) {
		this.likeIt = likeIt;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
}
