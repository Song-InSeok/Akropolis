package bean;

import java.io.Serializable;

public class Opinion implements Serializable {
	private int uid; // user id or Email for finding users info
	private String text; // opinion body
	private int likeIt;
	private int report;
	public Opinion(){
		
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
}
