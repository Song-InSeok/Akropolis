package bean;

public class Report {
	int opinion_id;
	int report_id;
	String e_mail;
	String content;
	String reported;
	public Report(){
		
	}
	public int getOpinion_id() {
		return opinion_id;
	}
	public void setOpinion_id(int opinion_id) {
		this.opinion_id = opinion_id;
	}
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReported() {
		return reported;
	}
	public void setReported(String reported) {
		this.reported = reported;
	}
}
