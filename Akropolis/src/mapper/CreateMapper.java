package mapper;


import bean.NewDebate;
import bean.SubTopic;
import bean.TagTag;

public interface CreateMapper {
	void insertMaintopic(NewDebate newdebate);
	void insertSubtopic(SubTopic subtopic);
	int getMt_id(NewDebate newdebate);

	void insertTag(TagTag tag);
	int getTagId(TagTag tag);
	void connectTag(TagTag tag);
}