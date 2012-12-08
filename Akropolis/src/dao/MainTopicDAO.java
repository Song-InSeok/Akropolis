package dao;

import java.util.ArrayList;
import java.util.List;

import mapper.MainTopicMapper;
import mapper.ParticipantMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.MainTopic;
import bean.PageResult;
import bean.Timeline;

public class MainTopicDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();
	
	public static boolean isOpen(String email){
		SqlSession session = sqlSessionFactory.openSession();
		boolean flag = false;
		try{
			MainTopicMapper mapper = session.getMapper(MainTopicMapper.class);
			flag = mapper.isOpen(email);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return flag;
	}
	
	public void updateFlag(int mt_id){
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println("MainTopicDAO updateFlag Start");
		MainTopic main = new MainTopic();
		try{
			MainTopicMapper mapper = session.getMapper(MainTopicMapper.class);
			ParticipantMapper pmapper = session.getMapper(ParticipantMapper.class);
			int agree,disagree;
			agree = pmapper.yesNum(mt_id);
			disagree = pmapper.noNum(mt_id);
			main.setAgree(agree);
			main.setDisagree(disagree);
			main.setMt_id(mt_id);
			mapper.updateFlag(main);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("MainTopicDAO updateFlag FIN");

		return;
	}
	
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
	
	public List<String> getTitleAuto(String searchText) {

		SqlSession session = sqlSessionFactory.openSession();
		List<String> list = null;
		try{
			MainTopicMapper mapper = session.getMapper(MainTopicMapper.class);
			list = mapper.getTitleAuto(searchText);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	public List<String> getTagAuto(String searchText) {

		SqlSession session = sqlSessionFactory.openSession();
		List<String> list = null;
		try{
			MainTopicMapper mapper = session.getMapper(MainTopicMapper.class);
			list = mapper.getTagAuto(searchText);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	
	public PageResult<MainTopic> getTitleSearch(int page, String searchText) {

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
			total = mapper.getTitleSearchTotal(searchText);
			result.setTotal(total);
			result.setPageNation();
			from = page*result.getItemNumber()-result.getItemNumber();
			number = result.getItemNumber();
			List<MainTopic> topics = mapper.getTitleSearchTopics(from, number, searchText);
			result.setTopicList(topics);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;	
	}

	public PageResult<MainTopic> getTagSearch(int page, String searchText) {
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
			total = mapper.getTagSearchTotal(searchText);
			result.setTotal(total);
			result.setPageNation();
			from = page*result.getItemNumber()-result.getItemNumber();
			number = result.getItemNumber();
			List<MainTopic> topics = mapper.getTagSearchTopics(from, number, searchText);
			result.setTopicList(topics);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}
	public List<Timeline> getTimeline(String email){
		SqlSession session = sqlSessionFactory.openSession();
		List<Timeline> timeline = null;
		try{
			MainTopicMapper mapper = session.getMapper(MainTopicMapper.class);		
			timeline = mapper.getTimeline(email);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return timeline;
	}
	
	public List<MainTopic> getSimTopics(MainTopic topic) {
		SqlSession session = sqlSessionFactory.openSession();
		List<MainTopic> list = new ArrayList<MainTopic>();
		List<String> tags = null;
		try{
			MainTopicMapper mapper = session.getMapper(MainTopicMapper.class);
			tags=mapper.getTags(topic.getMt_id());
			for(String tag : tags) {
				list.add(mapper.getSimTopics(tag));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
}
