package bean;

import java.io.Serializable;
import java.util.List;

public class TagTag implements Serializable{
	
	private int mt_id;
	private int tag_id;
	private String tag;
	

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getMt_id() {
		return mt_id;
	}

	public void setMt_id(int mt_id) {
		this.mt_id = mt_id;
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	
}
