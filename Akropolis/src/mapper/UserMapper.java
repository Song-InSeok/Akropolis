package mapper;

import java.util.List;
import bean.User;

public interface UserMapper {
	User selectUser(String email);
	List<User> selectAllUser();
	List<User> selectUserInterest(String email);
}