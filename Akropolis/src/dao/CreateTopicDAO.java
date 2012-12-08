package dao;

import java.util.List;

import mapper.CreateMapper;
import mapper.UserMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.NewDebate;
import bean.SubTopic;
import bean.TagTag;


public class CreateTopicDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();

	public List<NewDebate> getNowTopic(String email){
		SqlSession session = sqlSessionFactory.openSession();
		List<NewDebate> nowMainTopic = null;
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
	
	public List<NewDebate> getPastTopic(String email){
		SqlSession session = sqlSessionFactory.openSession();
		List<NewDebate> nowMainTopic = null;
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			nowMainTopic = mapper.getPastTopic(email);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return nowMainTopic;
	}
	
	public void setMainTopic(NewDebate newdebate){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			CreateMapper mapper = session.getMapper(CreateMapper.class);
			mapper.insertMaintopic(newdebate);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return;
	}
	public void setSubTopic(NewDebate newdebate){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			CreateMapper mapper = session.getMapper(CreateMapper.class);
			for(SubTopic subtopic : newdebate.getSubtopics()) {
				mapper.insertSubtopic(subtopic);
			}
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return;
	}
	public void insertANDconnetTag(NewDebate newdebate){
		SqlSession session = sqlSessionFactory.openSession();
		Integer existTag_id = null;
		
		try{
			CreateMapper mapper = session.getMapper(CreateMapper.class);
			for(TagTag tag : newdebate.getTags()) {
				existTag_id = mapper.getTagId(tag);
				if(existTag_id==null){
					mapper.insertTag(tag);
					tag.setTag_id((int)mapper.getTagId(tag));
				}else{
					tag.setTag_id((int)existTag_id);
				}
				mapper.connectTag(tag);
				existTag_id=null;
			}
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return;
	}
	public int getMt_id(NewDebate newdebate){
		SqlSession session = sqlSessionFactory.openSession();
		int mt_id=-1;
		try{
			CreateMapper mapper = session.getMapper(CreateMapper.class);
			mt_id = mapper.getMt_id(newdebate);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return mt_id;
	}
	
	public void setParticipan(NewDebate newdebate){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			CreateMapper mapper = session.getMapper(CreateMapper.class);
			mapper.setParticipate(newdebate);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return;
	}
}
