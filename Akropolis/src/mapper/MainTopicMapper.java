package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bean.MainTopic;
import bean.Timeline;

public interface MainTopicMapper {
	MainTopic getMainTopic(int t_id);
	int getTotal();
	int getTitleSearchTotal(String searchText);
	int getTagSearchTotal(String searchText);
	List<MainTopic> getHotTopics(@Param("to") int to, @Param("number") int number);
	List<MainTopic> getLatelyTopics(@Param("to") int to, @Param("number") int number);
	List<MainTopic> getTitleSearchTopics(
			@Param("to") int to, @Param("number") int number, @Param("searchText") String searchText);
	List<MainTopic> getTagSearchTopics(
			@Param("to") int to, @Param("number") int number, @Param("searchText") String searchText);
	List<MainTopic> getTagTopics(
			@Param("to") int to, @Param("number") int number, @Param("id") int id);
	List<Timeline> getTimeline(String email);
	List<String> getTitleAuto(@Param("searchText") String searchText);
	List<String> getTagAuto(@Param("searchText") String searchText);
	int updateFlag(MainTopic mt);
}
