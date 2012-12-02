package bean;

import java.io.Serializable;
import java.util.List;

public class Interest implements Serializable{
	private int id;
	private String interest;
	
	public Interest(){
		id=-1;
		interest=null;
	}
	public Interest(String interest){
		this.interest=interest;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
	
}
