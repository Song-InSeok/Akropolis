package mapper;

import java.util.List;

import bean.SubTopic;

public interface SubTopicMapper {
	List<SubTopic> getSubTopics(int mt_id);
	SubTopic getSubTopic(SubTopic st);
}
