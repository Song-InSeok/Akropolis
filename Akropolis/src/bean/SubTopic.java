package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class SubTopic implements Serializable {
	//opinions
	private ArrayList<Opinion> ops = new ArrayList<Opinion>();
	private int sid;
	private String title;
	private String startTime;
	private String endTime;
	private int cu_op; // current opinion number for get opinion
	public SubTopic(){
		
	}
	public ArrayList<Opinion> getOps() {
		return ops;
	}
	public void setOps(ArrayList<Opinion> ops) {
		this.ops = ops;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getCu_op() {
		return cu_op;
	}
	public void setCu_op(int cu_op) {
		this.cu_op = cu_op;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
}
