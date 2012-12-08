package mapper;

import java.util.List;

import bean.Participant;

public interface ParticipantMapper {
	Participant selectParticipant(String email);
	List<Participant> getParticipants(int mt_id);
	Participant getParticipant(Participant par);
<<<<<<< HEAD
	int insertParticipant(Participant par);
	int updateFlag(Participant par);
	int updateRequest(Participant par);
	int yesNum(int mt_id);
	int noNum(int mt_id);
=======
<<<<<<< HEAD
=======

>>>>>>> 586239d4ed741115109e24aeb23eba0755c75889
>>>>>>> 5905c3741281c391dc07f651c0b37aaff496cb20
}
