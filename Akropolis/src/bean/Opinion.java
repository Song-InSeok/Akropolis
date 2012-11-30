package bean;

import java.io.Serializable;

public class Opinion implements Serializable {
	private int mt_id;
	private int sub_id;
	private int opinion_id;
	private String content;
	private int honor;
	private String e_mail;
	private String photo;
	private String name;
	private String flag;
	
	private String request;
	
	public Opinion(){
		
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
	public int getOpinion_id() {
		return opinion_id;
	}
	public void setOpinion_id(int opinion_id) {
		this.opinion_id = opinion_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHonor() {
		return honor;
	}
	public void setHonor(int honor) {
		this.honor = honor;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
