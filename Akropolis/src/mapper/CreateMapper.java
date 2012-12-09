package mapper;


import java.util.List;

import bean.NewDebate;
import bean.SubTopic;
import bean.TagTag;
import bean.User;

public interface CreateMapper {
	void insertMaintopic(NewDebate newdebate);
	void insertSubtopic(SubTopic subtopic);
	int getMt_id(NewDebate newdebate);
	int findMt_id(User user);

	void insertTag(TagTag tag);
	Integer getTagId(TagTag tag);
	void connectTag(TagTag tag);
	void setParticipate(NewDebate newdebate);
	
	NewDebate findDebate(String email);
	List<TagTag> findTag(int mt_id);
	
}