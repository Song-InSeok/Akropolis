package dao;

import java.util.List;

import mapper.UserMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.Interest;
import bean.User;

public class UserDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();
	
	public User getUser(String email){
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
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
		List<User> list=null;
		
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			list = mapper.selectAllUser();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
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

	public void setInterest(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);	
			mapper.deleteInterests(user.getEmail());
			for(Interest interest : user.getInterestList()) {
				mapper.insertInterest(user.getEmail(), interest.getId());
			}
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void setSay(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.updateUserSay(user);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public List<User> getFollowerList(String email){
		SqlSession session = sqlSessionFactory.openSession();
		List<User> list=null;
		
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			list = mapper.getFollowerList(email);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	public String insertFollower(String follower, String following){
		SqlSession session = sqlSessionFactory.openSession();
		List<User> list = null;
		boolean isUser=false;
		list = getFollowerList(following);
		for(User user : list) {
			if(user.getEmail().equals(follower)) return "Registered Follower";
		}
		list = getUserList();
		for(User user : list) {
			if(user.getEmail().equals(follower)) {
				isUser=true;
			}
		}
		if(!isUser) return "Not user";

		try{
			UserMapper mapper = session.getMapper(UserMapper.class);	
			mapper.insertFollower(follower, following);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return "Success : Insertion";
	}
	public void deleteFollower(String follower, String following){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.deleteFollower(follower, following);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
