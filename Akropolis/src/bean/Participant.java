package bean;

import java.io.Serializable;

public class Participant implements Serializable {
	private String request;
	private int report;
	private int mt_id;
	private String e_mail;
	private String flag;
	public Participant(){
		
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	public int getMt_id() {
		return mt_id;
	}
	public void setMt_id(int mt_id) {
		this.mt_id = mt_id;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
