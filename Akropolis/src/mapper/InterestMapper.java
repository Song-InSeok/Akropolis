package mapper;

import java.util.List;
import bean.Interest;

public interface InterestMapper {
	List<Interest> selectAll();
	int selectID(String interest);
}