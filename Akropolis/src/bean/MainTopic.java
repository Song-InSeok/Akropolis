package bean;

import java.io.Serializable;
import java.util.List;

public class MainTopic implements Serializable{
	// subject arraylist
	private List<SubTopic> subs;
	private String e_mail; // Make User Email
	private int mt_id;
	private String mt_title;
	private String date;
	private int agree;
	private int disagree;
	private String m_close;
	
	public MainTopic(){
		
	}
	public List<SubTopic> getSubs() {
		return subs;
	}
	public void setSubs(List<SubTopic> subs) {
		this.subs = subs;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public int getMt_id() {
		return mt_id;
	}
	public void setMt_id(int mt_id) {
		this.mt_id = mt_id;
	}
	public String getMt_title() {
		return mt_title;
	}
	public void setMt_title(String mt_title) {
		this.mt_title = mt_title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
	public String getM_close() {
		return m_close;
	}
	public void setM_close(String m_close) {
		this.m_close = m_close;
	}
}