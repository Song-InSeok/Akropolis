package mapper;

import java.util.List;

import bean.Opinion;

public interface OpinionMapper {
	List<Opinion> getOpinions(Opinion opinion);
	List<Opinion> getOPs(Opinion opinion);
	int insertOP(Opinion opinion);
	Opinion getOP(int opinion_id);
	int honorPP(int opinion_id);
	int honorMM(int opinion_id);
	int deleteOP(int opinion_id);
	String getEmail(int opinion_id);
}
