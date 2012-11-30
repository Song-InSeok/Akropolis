package mapper;

import java.util.List;
import bean.User;

public interface UserMapper {
	User selectUser(String email);
	void updateUser(User user);
	void updateUserInterest(int id);
	List<User> selectAllUser();
	int getUsersDebate(String email);
	int insertUser(User user);
	List<User> getDebateUsers(int mt_id);
}