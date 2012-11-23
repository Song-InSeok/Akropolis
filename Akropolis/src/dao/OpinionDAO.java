package dao;

import java.util.List;

import mapper.OpinionMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.Opinion;

public class OpinionDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();

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
}
