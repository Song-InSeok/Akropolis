package bean;

import java.io.Serializable;

public class Follower  implements Serializable {
	private String e_mail;
	private int mt_id;
	
	public Follower(){
		
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String email) {
		this.e_mail = email;
	}

	public int getMt_id() {
		return mt_id;
	}

	public void setMt_id(int mt_id) {
		this.mt_id = mt_id;
	}

}
