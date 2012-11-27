package dao;

import java.util.List;

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
<<<<<<< HEAD
	public void SetUser(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			System.out.println("test!!"+user.getEmail());
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.updateUser(user);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
=======
	public int getUsersDebate(String email){
		int ret = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			ret = mapper.getUsersDebate(email);
		}catch(Exception e){
			e.printStackTrace();
			ret = 0;
		}finally{
			session.close();
		}
		return ret;
>>>>>>> ba0c5b55b65402c4ad37d8d13579217033e7a321
	}
	public List<User> getUserList(){
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectAllUser();
		return list;
	}
	
}
