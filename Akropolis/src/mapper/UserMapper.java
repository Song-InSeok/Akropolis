package mapper;

import java.util.List;
import bean.User;

public interface UserMapper {
	User selectUser(String email);
	List<User> selectAllUser();
	int getUsersDebate(String email);
	int insertUser(User user);
}