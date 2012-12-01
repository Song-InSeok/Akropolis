package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bean.Interest;
import bean.MainTopic;
import bean.User;

public interface UserMapper {
	User selectUser(String email);
	//void updateUser(User user);
	List<User> selectAllUser();
	int getUsersDebate(String email);
	int insertUser(User user);
	List<User> getDebateUsers(int mt_id);
	void updateUserSay(User user);
	void deleteInterests(User user);
	void insertInterest(@Param("e_mail")String email, @Param("interest_id")int id);
}