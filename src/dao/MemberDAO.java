package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.AcademicBg;
import vo.Career;
import vo.Certificate;
import vo.Member;
import vo.ProjectCareer;
import vo.Resume;

public class MemberDAO {
	private SqlSessionFactory factory=MybatisConfig.getSqlSessionFactory();

	public MemberDAO(){
		
	}
	
	public void insertMember(Member memberVo){
		System.out.println("memberDAO.insertMember");
		SqlSession ss=factory.openSession();
		
		try {
			ss.insert("member.insertMember", memberVo);
			ss.insert("resume.insertResume", memberVo.getMemberId());
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
	}
	
	public Member selectMember(String memberId) {
		System.out.println("memberDAO.selectMember :      "+memberId );
		SqlSession ss = null;
		Member mem = null;
		try {
			ss = factory.openSession();
			mem = ss.selectOne("member.selectMember", memberId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}		
		return mem;
	}
	
	public int updateMember(Member memberVo) {
		SqlSession ss = null;
		int result = 0;
		
		try {
			ss = factory.openSession();
			result = ss.update("member.updateMember", memberVo);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return result;
	}
	
	
}
