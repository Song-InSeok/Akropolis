package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bean.MainTopic;
import bean.PageResult;

public interface MainTopicMapper {
	MainTopic getMainTopic(int t_id);
	int getTotal();
	List<MainTopic> getHotTopics(@Param("to") int to, @Param("number") int number);
	List<MainTopic> getLatelyTopics(@Param("to") int to, @Param("number") int number);
	List<MainTopic> getTitleSearchTopics(
			@Param("to") int to, @Param("number") int number, @Param("searchText") String searchText);
	int getSearchTotal(String searchText);
}
