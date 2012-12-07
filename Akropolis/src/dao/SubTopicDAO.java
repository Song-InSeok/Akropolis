package dao;

import java.util.List;

import mapper.SubTopicMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.MainTopic;
import bean.SubTopic;

public class SubTopicDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();

	public List<SubTopic> getSubTopics(int mt_id){
		SqlSession session = sqlSessionFactory.openSession();
		List<SubTopic> list = null;
		try{
			SubTopicMapper mapper = session.getMapper(SubTopicMapper.class);
			list = mapper.getSubTopics(mt_id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	public SubTopic getSubTopic(int mt_id,int st_id){
		SqlSession session = sqlSessionFactory.openSession();
		SubTopic st = new SubTopic();
		st.setMt_id(mt_id);
		st.setSub_id(st_id);
		try{
			SubTopicMapper mapper = session.getMapper(SubTopicMapper.class);
			st = mapper.getSubTopic(st);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return st;
	}
}
