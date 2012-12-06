package dao;

import java.util.List;

import mapper.UserMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class CreateTopicDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();

	public List<String> getNowTopic(String email){
		SqlSession session = sqlSessionFactory.openSession();
		List<String> nowMainTopic = null;
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			nowMainTopic = mapper.getNowTopic(email);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return nowMainTopic;
	}
}
