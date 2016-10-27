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
			System.out.println("member.insertMember==== SUCCESS");
			ss.commit();
			String memberId = memberVo.getMemberId();
			ss.insert("resume.insertResume", memberId);
			System.out.println("resume.insertResume==== SUCCESS");
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
	
	public Resume selectResume(String memberId) {
		SqlSession ss = null;
		Resume resume = null;
		
		try {
			ss = factory.openSession();
			resume = ss.selectOne("resume.selectResume", memberId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if( ss != null) ss.close();
		}
		
		return resume;
	}
	
	public ArrayList<AcademicBg> allAcdemicBgById(String resumeId){
		SqlSession ss = null;
		List<AcademicBg> aList = null;
		
		try {
			ss = factory.openSession();
			aList = ss.selectList("academicbg.allAcademicBgById", resumeId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ss != null) ss.close();
		}
		
		return (ArrayList<AcademicBg>) aList;
	}
	
	public ArrayList<Career> allCareerById(String resumeId){
		SqlSession ss = null;
		List<Career> cList = null;
		
		try {
			ss = factory.openSession();
			cList = ss.selectList("career.allCareerBgById", resumeId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ss != null) ss.close();
		}
		
		return (ArrayList<Career>) cList;
	}
	
	public ArrayList<Certificate> allCertificateBgById(String resumeId){
		SqlSession ss = null;
		List<Certificate> cList = null;
		
		try {
			ss = factory.openSession();
			cList = ss.selectList("certificate.allCertificateById", resumeId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ss != null) ss.close();
		}
		
		return (ArrayList<Certificate>) cList;
	}
	
	public ArrayList<ProjectCareer> allProjectCareerById(String resumeId){
		SqlSession ss = null;
		List<ProjectCareer> pList = null;
		
		try {
			ss = factory.openSession();
			pList = ss.selectList("academicbg.allProjectCareerById", resumeId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ss != null) ss.close();
		}
		
		return (ArrayList<ProjectCareer>) pList;
	}
}
