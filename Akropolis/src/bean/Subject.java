package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Subject implements Serializable {
	//opinions
	private ArrayList<Opinion> ops = new ArrayList<Opinion>();
	private String title;
	private int startTime;
	private int endTime;
	private int cu_op; // current opinion number for get opinion
	public Subject(){
		
	}
}
