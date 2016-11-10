package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.MyCoverWithTag;
import vo.Tag;

public class MyCoverWithTagDAO {
	private SqlSessionFactory factory=MybatisConfig.getSqlSessionFactory();

	public MyCoverWithTagDAO(){
		
	}
	
	public ArrayList<MyCoverWithTag> selectMyCoverWithTagListByResumeId(String resumeId){
		SqlSession ss=factory.openSession();
		
		List<MyCoverWithTag> coverList = null;
		try {
			coverList = ss.selectList("myCoverWithTag.selectMyCoverWithTagListByResumeId", resumeId);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
		
		return (ArrayList<MyCoverWithTag>) coverList;
	}
	
	public void insertMyCover(MyCoverWithTag cover){
		SqlSession ss=factory.openSession();
		
		try {
			ss.insert("myCoverWithTag.insertMyCover", cover);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
	}
	
	public void insertTag(Tag tag){
		SqlSession ss=factory.openSession();
		
		try {
			ss.insert("myCoverWithTag.insertTag", tag);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
	}
	
	public void deleteTagByMyCoverId(String myCoverId){
		SqlSession ss=factory.openSession();
		
		try {
			ss.insert("myCoverWithTag.deleteTagByMyCoverId", myCoverId);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
	}
	
	public void updateMyCover(MyCoverWithTag cover){
		SqlSession ss=factory.openSession();
		
		try {
			ss.update("myCoverWithTag.updateMyCover", cover);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
	}
	
	public void deleteMyCover(String myCoverId){
		SqlSession ss=factory.openSession();
		
		try {
			ss.delete("myCoverWithTag.deleteMyCover", myCoverId);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
	}
	
}
