package mapper;

import java.util.List;

import bean.Participant;

public interface ParticipantMapper {
	Participant selectParticipant(String email);
	List<Participant> getParticipants(int mt_id);
<<<<<<< HEAD
	Participant getParticipant(Participant par);

=======
>>>>>>> 712f7be99456a6e5867844dc7bee32904a8fdad0
}
