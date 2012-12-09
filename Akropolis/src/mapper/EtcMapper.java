package mapper;

import java.util.List;

import bean.Report;
import bean.Thumbsup;

public interface EtcMapper {
	int insertThumbsup(Thumbsup t);
	int insertReport(Report r);
	int updateThumbsup(Thumbsup t);
	Thumbsup getThumbsup(Thumbsup t);
	List<Report> getReports(int mt_id);
	int deleteReport(int report_id);
}
