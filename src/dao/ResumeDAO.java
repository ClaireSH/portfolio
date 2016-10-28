package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.AcademicBg;
import vo.Career;
import vo.Certificate;
import vo.ProjectCareer;
import vo.Resume;

public class ResumeDAO {
	private SqlSessionFactory factory=MybatisConfig.getSqlSessionFactory();

	public ResumeDAO(){
		
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
			aList = ss.selectList("academicBg.allAcademicBgById", resumeId);
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
			pList = ss.selectList("projectCareer.allProjectCareerById", resumeId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ss != null) ss.close();
		}
		
		return (ArrayList<ProjectCareer>) pList;
	}
	
	public void insertAcademicBgList(ArrayList<AcademicBg> aList){
		SqlSession ss = null;
		
		try {
			ss = factory.openSession();
			for(AcademicBg academicBg:aList){
				ss.insert("academicBg.insertAcademicBg", academicBg);
				
			}
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ss != null) ss.close();
		}
	}
	
	public void insertCareerList(ArrayList<Career> cList){
		SqlSession ss = null;
		
		try {
			ss = factory.openSession();
			for(Career career:cList){
				ss.insert("career.insertCareer", career);
			}
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if( ss != null) ss.close();
		}
	}
	
	public void insertCertificateList(ArrayList<Certificate> cList){
		SqlSession ss = null;
		
		try {
			ss = factory.openSession();
			for(Certificate certificate:cList){
				ss.insert("certificate.insertCertificate", certificate);
			}
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if( ss != null) ss.close();
		}
	}
	
	public void insertProjectCareerList(ArrayList<ProjectCareer> pList){
		SqlSession ss = null;
		
		try {
			ss = factory.openSession();
			for(ProjectCareer projectCareer:pList){
				ss.insert("projectCareer.insertProjectCareer", projectCareer);
			}
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if( ss != null) ss.close();
		}
	}
	
	public void insertAcademicBg(AcademicBg academicBg){
		SqlSession ss = null;
		
		try {
			ss = factory.openSession();
			System.out.println(academicBg.toString());
			ss.insert("academicBg.insertAcademicBg", academicBg);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if( ss != null) ss.close();
		}
	}
	
	public void insertCareer(Career career){
		SqlSession ss = null;
		
		try {
			ss = factory.openSession();
			ss.insert("career.insertCareer", career);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if( ss != null) ss.close();
		}
	}
	
	public void insertCertificate(Certificate certificate){
		SqlSession ss = null;
		
		try {
			ss = factory.openSession();
			ss.insert("certificate.insertCertificate", certificate);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if( ss != null) ss.close();
		}
	}
	
	public void insertProjectCareer(ProjectCareer projectCareer){
		SqlSession ss = null;
		
		try {
			ss = factory.openSession();
			ss.insert("projectCareer.insertProjectCareer", projectCareer);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if( ss != null) ss.close();
		}
	}
	
	
}
