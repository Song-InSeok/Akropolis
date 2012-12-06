package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bean.Interest;
import bean.MainTopic;
import bean.Timeline;
import bean.User;

public interface UserMapper {
	User selectUser(String email);
	List<User> selectAllUser();
	int getUsersDebate(String email);
	int insertUser(User user);
	List<User> getDebateUsers(int mt_id);
	void updateUserSay(User user);
	void deleteInterests(@Param("e_mail")String email);
	void insertInterest(@Param("e_mail")String email, @Param("interest_id")int id);
	List<User> getFollowerList(String email);
	void insertFollower(@Param("e_mail")String follower, @Param("following")String following);
	void deleteFollower(@Param("e_mail")String follower, @Param("following")String following);
	List<String> getNowTopic(String email);
}