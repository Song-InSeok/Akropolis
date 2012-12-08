package dao;

import mapper.EtcMapper;
import mapper.OpinionMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.Report;
import bean.Thumbsup;

public class EtcDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();
	public Thumbsup getThumbsup(Thumbsup t){
		SqlSession session = sqlSessionFactory.openSession();
		Thumbsup result=null;
		try{
			EtcMapper mapper = session.getMapper(EtcMapper.class);
			result = mapper.getThumbsup(t);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}
	public int insertReport(Report r){
		SqlSession session = sqlSessionFactory.openSession();
		int i=0;
		try{
			EtcMapper mapper = session.getMapper(EtcMapper.class);
			OpinionMapper omapper = session.getMapper(OpinionMapper.class);
			i=mapper.insertReport(r);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return i;
	}
	public int insertThumbsup(Thumbsup t){
		SqlSession session = sqlSessionFactory.openSession();
		int i=0;
		try{
			EtcMapper mapper = session.getMapper(EtcMapper.class);
			i=mapper.insertThumbsup(t);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return i;
	}
	public int updateThumbsup(Thumbsup t){
		SqlSession session = sqlSessionFactory.openSession();
		int i=0;
		try{
			EtcMapper mapper = session.getMapper(EtcMapper.class);
			i=mapper.updateThumbsup(t);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return i;
	}
	
}
