package mapper;

import bean.User;

public interface UserMapper {
	User selectUser(String email);
}
