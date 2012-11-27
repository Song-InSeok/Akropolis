package dao;

import java.util.List;

import mapper.InterestMapper;
import mapper.UserMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.Interest;
import bean.User;

public class InterestDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();
	
	public List<Interest> getInterestList(){

		SqlSession session = sqlSessionFactory.openSession();
		List<Interest> list = null;
		try{
			InterestMapper mapper = session.getMapper(InterestMapper.class);
			list = mapper.selectAll();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
		
	}
}
