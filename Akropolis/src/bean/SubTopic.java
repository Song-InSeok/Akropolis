package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubTopic implements Serializable {
	//opinions
	private List<Opinion> ops;
	private int mt_id;
	private int sub_id;
	private String sub_title;
	private String start_time;
	private String end_time;
	private String sub_close;
	private int cu_op; // current opinion number for get opinion
	public SubTopic(){
		
	}
	public List<Opinion> getOps() {
		return ops;
	}
	public void setOps(ArrayList<Opinion> ops) {
		this.ops = ops;
	}
	public int getMt_id() {
		return mt_id;
	}
	public void setMt_id(int mt_id) {
		this.mt_id = mt_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public String getSub_title() {
		return sub_title;
	}
	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getSub_close() {
		return sub_close;
	}
	public void setSub_close(String sub_close) {
		this.sub_close = sub_close;
	}
	public int getCu_op() {
		return cu_op;
	}
	public void setCu_op(int cu_op) {
		this.cu_op = cu_op;
	}
	public void setOps(List<Opinion> ops) {
		this.ops = ops;
	}
}
