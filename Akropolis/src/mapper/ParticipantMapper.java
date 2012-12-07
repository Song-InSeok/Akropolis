package mapper;

import java.util.List;

import bean.Participant;

public interface ParticipantMapper {
	List<Participant> getParticipants(int mt_id);
	Participant getParticipant(Participant par);

}
