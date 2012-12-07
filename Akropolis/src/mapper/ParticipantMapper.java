package mapper;

import java.util.List;

import bean.Participant;

public interface ParticipantMapper {
	Participant selectParticipant(String email);
	List<Participant> getParticipants(int mt_id);
	Participant getParticipant(Participant par);
<<<<<<< HEAD

=======
>>>>>>> 23386101fd655422b6bf2aeec0e0bbb80cab6487
}
