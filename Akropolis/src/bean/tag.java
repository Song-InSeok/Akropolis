package bean;

import java.io.Serializable;
import java.util.List;

public class tag implements Serializable{
	
	private int id;
	private String tag;
	
	public tag(){
		id=-1;
		tag=null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
