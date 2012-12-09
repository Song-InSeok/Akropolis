package bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class NewDebate implements Serializable {

	private int mt_id;
	private String email;  //넣었음
	private String mTopic;  //자동으로빈
	private String invite;
	private boolean isInvite=false;
	
	private List<TagTag> tags;  //컨트롤러에서 넣어줌
	private List<SubTopic>  subtopics;  //이것도 컨트롤러에서

	public NewDebate() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getMTopic() {
		return mTopic;
	}

	public void setMTopic(String mTopic) {
		this.mTopic = mTopic;
	}


	public List<SubTopic> getSubtopics() {
		return subtopics;
	}

	public void setSubtopics(List<SubTopic> subtopics) {
		this.subtopics = subtopics;
	}


	public List<TagTag> getTags() {
		return tags;
	}

	public void setTags(List<TagTag> tags) {
		this.tags = tags;
	}

	public int getMt_id() {
		return mt_id;
	}

	public void setMt_id(int mt_id) {
		this.mt_id = mt_id;
	}

	public String getInvite() {
		return invite;
	}

	public void setInvite(String invite) {
		this.invite = invite;
	}
	public void setIsinvite(String invite){
		if(invite.equals("Yes")){
			this.isInvite=true;
		}else{
			this.isInvite=false;
		}
	}
	public boolean getIsinvite(){
		return isInvite;
	}
}
