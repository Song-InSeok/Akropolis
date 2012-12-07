package dao;
import mapper.ParticipantMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


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
}

