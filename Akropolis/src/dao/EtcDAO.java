package dao;

import java.util.List;

import mapper.EtcMapper;
import mapper.OpinionMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.Report;
import bean.Thumbsup;

public class EtcDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();
	public List<Report> getReports(int mt_id){
		SqlSession session = sqlSessionFactory.openSession();
		List<Report>	reportList=null;
		try{
			EtcMapper mapper = session.getMapper(EtcMapper.class);
			reportList = mapper.getReports(mt_id);
			System.out.println("겟리포트 리포트 가져오기 "+reportList);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return reportList;
	}
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
	public int deleteReport(int report_id){
		SqlSession session = sqlSessionFactory.openSession();
		int i=0;
		try{
			EtcMapper mapper = session.getMapper(EtcMapper.class);
			i=mapper.deleteReport(report_id);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return i;
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
