package dao;
<<<<<<< HEAD

import mapper.InterestMapper;
=======
>>>>>>> 23386101fd655422b6bf2aeec0e0bbb80cab6487
import mapper.ParticipantMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
<<<<<<< HEAD
=======

>>>>>>> 23386101fd655422b6bf2aeec0e0bbb80cab6487

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
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return pt;
	}
<<<<<<< HEAD
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
}
=======
}

>>>>>>> 23386101fd655422b6bf2aeec0e0bbb80cab6487
