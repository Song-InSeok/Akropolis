package mapper;

import java.util.List;

import bean.Participant;

public interface ParticipantMapper {
	Participant selectParticipant(String email);
	List<Participant> getParticipants(int mt_id);
	Participant getParticipant(Participant par);

}
