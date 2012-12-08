package dao;

import java.util.List;

import mapper.MainTopicMapper;
import mapper.ParticipantMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.MainTopic;
import bean.Participant;

public class ParticipantDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();
	public int changeReq(Participant pt){
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println("ParticipantDAO changeReq Start");
		int i=0;
		try{
			ParticipantMapper mapper = session.getMapper(ParticipantMapper.class);
			i = mapper.updateRequest(pt);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("ParticipantDAO changeReq FIN");

		return i;
	}
	public int updateFlag(Participant pt){
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println("ParticipantDAO updateFlag Start");

		int i=0;
		try{
			ParticipantMapper mapper = session.getMapper(ParticipantMapper.class);
			i = mapper.updateFlag(pt);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("ParticipantDAO updateFlag FIN");

		return i;
	}
	public int updateRequest(Participant pt){
		SqlSession session = sqlSessionFactory.openSession();
		int i=0;
		try{
			ParticipantMapper mapper = session.getMapper(ParticipantMapper.class);
			i = mapper.updateRequest(pt);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return i;
	}
	public int insertParticipant(Participant pt){
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println("ParticipantDAO insertParticipant Start");
		int i=0;
		try{
			ParticipantMapper mapper = session.getMapper(ParticipantMapper.class);
			i = mapper.insertParticipant(pt);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("ParticipantDAO insertParticipant FIN");

		return i;
	}
	public Participant getParticipant(String email,int mt) {
		SqlSession session = sqlSessionFactory.openSession();
		Participant pt = new Participant();
		pt.setE_mail(email);
		pt.setMt_id(mt);
		
		try{
			ParticipantMapper mapper = session.getMapper(ParticipantMapper.class);
			pt = mapper.getParticipant(pt);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return pt;
	}
	public Participant getParticipant(String email){
		SqlSession session = sqlSessionFactory.openSession();
		Participant participant = new Participant();
		try{
			ParticipantMapper mapper = session.getMapper(ParticipantMapper.class);
			participant = mapper.selectParticipant(email);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				session.close();
			}
		return participant;
	}
	
	List<String> getParticipantAuto(int mt_id,String searchText){
		SqlSession session = sqlSessionFactory.openSession();
		List<String> list = null;

		try{
			ParticipantMapper mapper = session.getMapper(ParticipantMapper.class);
			list = mapper.getParticipantAuto(mt_id, searchText);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}

		return list;
	}
}
