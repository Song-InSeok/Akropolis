package dao;

import mapper.UserMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.User;

public class UserDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();
	
	public User getUser(String email){
		SqlSession session = sqlSessionFactory.openSession();
		User user = null;
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			user = mapper.selectUser(email);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return user;
	}
}