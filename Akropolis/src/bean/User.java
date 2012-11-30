package bean;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	private String email;
	private String name;
	private String say;
	private String photo;
	private int honor;
	private int dishonor;
	
	private String flag;

	private String education;
	private List<Interest> interestList;
	
	public User(){}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public List<Interest> getInterestList() {
		return interestList;
	}
	public void setInterestList(List<Interest> interestList) {
		this.interestList = interestList;
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
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	
}
