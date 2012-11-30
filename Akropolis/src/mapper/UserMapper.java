package mapper;

import java.util.List;

import bean.Interest;
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
	void insertInterest(Interest interest);
}