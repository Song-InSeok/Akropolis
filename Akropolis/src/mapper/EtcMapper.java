package mapper;

import bean.Report;
import bean.Thumbsup;

public interface EtcMapper {
	int insertThumbsup(Thumbsup t);
	int insertReport(Report r);
	int updateThumbsup(Thumbsup t);
	Thumbsup getThumbsup(Thumbsup t);
}
