package dao;

import mapper.MainTopicMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.MainTopic;
import bean.User;

public class MainTopicDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();

	public MainTopic getMainTopic(int t_id){
		SqlSession session = sqlSessionFactory.openSession();
		MainTopic main = null;
		try{
			MainTopicMapper mapper = session.getMapper(MainTopicMapper.class);
			main = mapper.getMainTopic(t_id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return main;
	}
}
