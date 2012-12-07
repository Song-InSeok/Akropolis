package dao;

<<<<<<< HEAD
import mapper.InterestMapper;
=======
>>>>>>> 712f7be99456a6e5867844dc7bee32904a8fdad0
import mapper.ParticipantMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
<<<<<<< HEAD

import bean.Participant;

public class ParticipantDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();

	public Participant getParticipant(String email,int mt) {
		SqlSession session = sqlSessionFactory.openSession();
		Participant pt = new Participant();
		pt.setE_mail(email);
		pt.setMt_id(mt);
		
		try{
			ParticipantMapper mapper = session.getMapper(ParticipantMapper.class);
			pt = mapper.getParticipant(pt);
=======

import bean.Participant;

public class ParticipantDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();
	
	public Participant getParticipant(String email){
		SqlSession session = sqlSessionFactory.openSession();
		Participant participant = new Participant();
		try{
			ParticipantMapper mapper = session.getMapper(ParticipantMapper.class);
			participant = mapper.selectParticipant(email);
>>>>>>> 712f7be99456a6e5867844dc7bee32904a8fdad0
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
<<<<<<< HEAD
		return pt;
	}
}
=======
		return participant;
	}
}
>>>>>>> 712f7be99456a6e5867844dc7bee32904a8fdad0
