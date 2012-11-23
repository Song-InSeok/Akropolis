package bean;

import java.util.List;

public class User {
	private String email;
	private String name;
	private String say;
	private String photo;
	private int honor;
	private int dishonor;
	private String education;
	private List<String> concern;
	
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public List<String> getConcern() {
		return concern;
	}
	public void setConcern(List<String> concern) {
		this.concern = concern;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSay() {
		return say;
	}
	public void setSay(String say) {
		this.say = say;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getHonor() {
		return honor;
	}
	public void setHonor(int honor) {
		this.honor = honor;
	}
	public int getDishonor() {
		return dishonor;
	}
	public void setDishonor(int dishonor) {
		this.dishonor = dishonor;
	}
	
}
