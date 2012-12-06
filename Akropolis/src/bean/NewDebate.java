package bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class NewDebate implements Serializable {

	private String email;
	private String mTopic;
	private List<tagList> tags;
	private List<SubTopic>  subtopics;
	private List<SubTopic> stList;

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

	public List<tagList> getTags() {
		return tags;
	}

	public void setTags(List<tagList> tags) {
		this.tags = tags;
	}

	public List<SubTopic> getSubtopics() {
		return subtopics;
	}

	public void setSubtopics(List<SubTopic> subtopics) {
		this.subtopics = subtopics;
	}

	public List<SubTopic> getStList() {
		return stList;
	}

	public void setStList(List<SubTopic> stList) {
		this.stList = stList;
	}
}
