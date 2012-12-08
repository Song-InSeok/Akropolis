package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bean.Participant;

public interface ParticipantMapper {
	Participant selectParticipant(String email);
	List<Participant> getParticipants(int mt_id);
	Participant getParticipant(Participant par);
	int insertParticipant(Participant par);
	int updateFlag(Participant par);
	int updateRequest(Participant par);
	int yesNum(int mt_id);
	int noNum(int mt_id);
	List<String> getParticipantAuto(@Param("mt_id") int mt_id,@Param("searchText") String searchText);
}
