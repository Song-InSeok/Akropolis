package bean;

import java.io.Serializable;
import java.util.List;

public class Timeline extends MainTopic implements Serializable{
	String request;
	String flag;
	String p_date;
	
	public Timeline(){
		super();
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getP_date() {
		return p_date;
	}
}