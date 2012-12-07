package bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class NewDebate implements Serializable {

	private String email;  //자동으로빈
	private String mTopic;  //자동으로빈
	
	private List<tag> tags;  //컨트롤러에서 넣어줌
	private List<SubTopic>  subtopics;  

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


	public List<tag> getTags() {
		return tags;
	}

	public void setTags(List<tag> tags) {
		this.tags = tags;
	}
}
