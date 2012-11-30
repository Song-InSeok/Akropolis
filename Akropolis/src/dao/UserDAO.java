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
	
	public int setUser(User user){
		SqlSession session = sqlSessionFactory.openSession();
		int row = 0;
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			row = mapper.insertUser(user);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return row; 
	}
	
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
	}
	public List<User> getUserList(){
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectAllUser();
		return list;
	}
	
	public List<User> getDebateUsers(int mt_id){
		List<User> ret=null;
		SqlSession session = sqlSessionFactory.openSession();
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			ret = mapper.getDebateUsers(mt_id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return ret;
	}
	//수정한척
}
