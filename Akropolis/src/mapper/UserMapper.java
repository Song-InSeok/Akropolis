package mapper;

import java.util.List;
import bean.User;

public interface UserMapper {
	User selectUser(String email);
	void updateUser(User user);
	List<User> selectAllUser();
}