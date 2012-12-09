package dao;

import java.util.List;

import mapper.OpinionMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.Opinion;

public class OpinionDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();
	public String getEmail(int opinion_id){
		SqlSession session = sqlSessionFactory.openSession();
		String e_mail=null;
		try{
			OpinionMapper mapper = session.getMapper(OpinionMapper.class);
			e_mail = mapper.getEmail(opinion_id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return e_mail;		
	}
	public int deleteOP(int op){
		SqlSession session = sqlSessionFactory.openSession();
		int i=0;
		try{
			OpinionMapper mapper = session.getMapper(OpinionMapper.class);
			i = mapper.deleteOP(op);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return i;
	}
	public int changeHonor(int preop,int newop){
		SqlSession session = sqlSessionFactory.openSession();
		int i=0;
		try{
			OpinionMapper mapper = session.getMapper(OpinionMapper.class);
			mapper.honorMM(preop);
			mapper.honorPP(newop);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return i;
	}
	public Opinion getOP(int opinion_id){
		SqlSession session = sqlSessionFactory.openSession();
		Opinion op=null;
		try{
			OpinionMapper mapper = session.getMapper(OpinionMapper.class);
			op=mapper.getOP(opinion_id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return op;
	}
	
	public int insertOP(Opinion op){
		SqlSession session = sqlSessionFactory.openSession();
		int res=0;
		try{
			OpinionMapper mapper = session.getMapper(OpinionMapper.class);
			res = mapper.insertOP(op);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return res;
	}
	
	public List<Opinion> getOpinions(int mt_id,int sub_id){
		SqlSession session = sqlSessionFactory.openSession();
		Opinion op = new Opinion();
		List<Opinion> list = null;
		op.setMt_id(mt_id);
		op.setSub_id(sub_id);
		try{
			OpinionMapper mapper = session.getMapper(OpinionMapper.class);
			list = mapper.getOpinions(op);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	public List<Opinion> getOPs(int mt_id,int sub_id){
		SqlSession session = sqlSessionFactory.openSession();
		Opinion op = new Opinion();
		List<Opinion> list = null;
		op.setMt_id(mt_id);
		op.setSub_id(sub_id);
		try{
			OpinionMapper mapper = session.getMapper(OpinionMapper.class);
			list = mapper.getOPs(op);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	} 
}
