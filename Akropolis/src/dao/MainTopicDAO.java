package dao;

import java.util.List;
import mapper.MainTopicMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.MainTopic;
import bean.PageResult;

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

	public PageResult<MainTopic> getHotPage(int page) {	

		SqlSession session = sqlSessionFactory.openSession();
		PageResult<MainTopic> result = new PageResult<MainTopic>(page);
		int total=0;
		int from=0;
		int number=0;	
		if (page <= 0) {
			page = 1;
		}
		try{
			MainTopicMapper mapper = session.getMapper(MainTopicMapper.class);
			total = mapper.getTotal();
			result.setTotal(total);
			result.setPageNation();
			from = page*result.getItemNumber()-result.getItemNumber();
			number = result.getItemNumber();
			List<MainTopic> topics = mapper.getHotTopics(from, number);
			result.setTopicList(topics);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;		
	}

	public PageResult<MainTopic> getLately(int page) {

		SqlSession session = sqlSessionFactory.openSession();
		PageResult<MainTopic> result = new PageResult<MainTopic>(page);
		int total=0;
		int from=0;
		int number=0;	
		if (page <= 0) {
			page = 1;
		}
		try{
			MainTopicMapper mapper = session.getMapper(MainTopicMapper.class);
			total = mapper.getTotal();
			result.setTotal(total);
			result.setPageNation();
			from = page*result.getItemNumber()-result.getItemNumber();
			number = result.getItemNumber();
			List<MainTopic> topics = mapper.getLatelyTopics(from, number);
			result.setTopicList(topics);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;	
	}
}
