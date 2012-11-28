package dao;

import mapper.EducationListMapper;
import mybatis.config.MyBatisManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class EducationListDAO {
	public static SqlSessionFactory sqlSessionFactory = MyBatisManager.getInstance();
	
	public void setEducation(String education){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			EducationListMapper mapper = session.getMapper(EducationListMapper.class);
			if(mapper.selectEducationCount(education) == 0){
				mapper.insertEducation(education);
				session.commit();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
