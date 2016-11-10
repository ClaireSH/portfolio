package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.MemberDAO;
import dao.QuestionDAO;
import dao.ResumeDAO;
import vo.AcademicBg;
import vo.Answer;
import vo.Career;
import vo.Certificate;
import vo.Member;
import vo.ProjectCareer;
import vo.Question;
import vo.Resume;

public class cvAction extends ActionSupport implements SessionAware{
	Member memberVo;
	Resume resumeVo;
	
	ArrayList<AcademicBg> academicBgList;
	ArrayList<Career> careerList;
	ArrayList<Certificate> certificateList;
	ArrayList<ProjectCareer> projectCareerList;
	
	ArrayList<Resume> resumeList;
	
	String useryear;
	String usermonth;
	String userday;
	
	private Resume resume;
	private String resumeId;
	
	MemberDAO memberDAO= new MemberDAO();
	ResumeDAO resumeDAO = new ResumeDAO();
	Map<String, Object> session;
	ArrayList<Question> qList;
	ArrayList<Answer> aList;
	QuestionDAO dao = new QuestionDAO();
	
	
	public ArrayList<Question> getqList() {
		return qList;
	}


	public void setqList(ArrayList<Question> qList) {
		this.qList = qList;
	}


	public ArrayList<Answer> getaList() {
		return aList;
	}


	public void setaList(ArrayList<Answer> aList) {
		this.aList = aList;
	}


	public String getCVboardList(){
		System.out.println("게시글 목록 불러옴");
		
		//질문목록가져오기 (사용자가 선택한 유형별)
		String loginId = (String) session.get("loginId");
		qList = dao.allQuestionList();
		System.out.println("1");
		aList = dao.selectAnswerList(loginId);
		System.out.println("2");
		for (Question q : qList) {
			System.out.println(q.toString());
		}
		System.out.println("4");

		if (aList != null) {

			for (Answer a : aList) {
				System.out.println(a.toString());
			}
		}

		
		//선택한 질문이 자기소개서 폼으로 들어오는데 (클라에서 할부분)
		
		//자기소개서 리스트 가져오기 
		//TODO PR리스트 가져오기 만들기 
		
		
		return SUCCESS;
	}
	
	
	//init
	public String initUpdateMember(){
		//현재 로그인 ID를 불러 updateMemberForm에 값을 Init 
		String loginId = (String)session.get("loginId");
		memberVo = memberDAO.selectMember(loginId);
		memberVo.setPassword("");
		String useryear = (memberVo.getBirth()).substring(0,4);
		String usermonth = (memberVo.getBirth()).substring(5,7);	
		String userday = (memberVo.getBirth().substring(8, 10)); 
		
		System.out.println(useryear+"/"+usermonth+"/"+userday);
		System.out.println(memberVo.toString());
		return SUCCESS;
	}
	
	//개인정보관리
	public String updateMember(){
		
		System.out.println("RESUME ACTION");
		for(AcademicBg a : academicBgList){
			System.out.println(a.toString());
		}
		String loginId = (String)session.get("loginId");
		Member m = memberDAO.selectMember(loginId);
		if(m == null){
			return INPUT;
		}else if(!(memberVo.getPassword()).equals(m.getPassword())){
			return INPUT;
		}else{
			//업데이트
			memberDAO.updateMember(m);
			System.out.println(m.getName() + "  " + " Update!!");
			return SUCCESS;
		}
	}
	
	//회원탈퇴
	public String deleteMember(){
		
		String loginId = (String)session.get("loginId");
		Member m = memberDAO.selectMember(loginId);
		if(m == null){
			return INPUT;
		}else if(!(memberVo.getPassword()).equals(m.getPassword())){
			return INPUT;
		}else{
			//업데이트
			memberDAO.deleteMember(loginId);
			System.out.println(m.getName() + "  " + " Delete!!");
			return SUCCESS;
		}
	}

	//개인정보 이력 초기화 작업
	public String initUpdateResume() throws Exception{
		
		System.out.println("-------------------------initUpdateResume");
		String loginId = (String)session.get("loginId");
		memberVo = memberDAO.selectMember(loginId);
		resumeVo = resumeDAO.selectResume(loginId);
		if(memberVo == null || resumeVo == null){
			//회원의 개인정보가 없거나, 이력서가 없으면 Fail(그러나, 계정로그인 한 이상 일어날 일은 없음!)
			return INPUT;
		}else{
			
			//생년월일
			useryear = (memberVo.getBirth().substring(0,4));
			usermonth = (memberVo.getBirth().substring(5,7));	
			userday = (memberVo.getBirth().substring(8, 10));
			
			//계정의 resumeId로 학력, 경력, 자격, 프로젝트를 각각 List로 받음
			academicBgList = (ArrayList<AcademicBg>) resumeDAO.allAcdemicBgById(resumeVo.getResumeId());
			careerList = (ArrayList<Career>) resumeDAO.allCareerById(resumeVo.getResumeId());
			certificateList = (ArrayList<Certificate>) resumeDAO.allCertificateBgById(resumeVo.getResumeId());
			System.out.println("projectCareerList Before"+ resumeVo.getResumeId());
			projectCareerList = (ArrayList<ProjectCareer>) resumeDAO.allProjectCareerById(resumeVo.getResumeId());
			System.out.println("projectCareerList After"+ resumeVo.getResumeId());
			for(AcademicBg ab : academicBgList){
				System.out.println();
				System.out.println(ab.toString());
			}
			for(Career c : careerList){
				System.out.println(c.toString());
			}
			for(Certificate cf : certificateList){
				System.out.println(cf.toString());
			}
			for(ProjectCareer pc : projectCareerList){
				System.out.println(pc.toString());
			}
			
			
			return SUCCESS;
		}	
	}
	
	public String updateResume(){
		String loginId = (String)session.get("loginId");
		Resume r = resumeDAO.selectResume(loginId);
		if(r == null || loginId == null){
			return INPUT;
		}else{
			
			if(academicBgList == null){
				System.out.println("academicBgList NULL");
			}else{
				for(AcademicBg ab : academicBgList){
					System.out.println(ab.toString());
				}
			}
			if(careerList == null){
				System.out.println("careerList NULL");
			}else{
				for(Career c : careerList){
					System.out.println(c.toString());
				}
			}
			if(certificateList == null){
				System.out.println("certificateList NULL");
			}else{
				for(Certificate c : certificateList){
					System.out.println(c.toString());
				}
			}
			if(projectCareerList == null){
				System.out.println("projectCareerList NULL");
			}else{
				for(ProjectCareer p : projectCareerList){
					System.out.println(p.toString());
				}
			}
			
			//값을 Insert
			//각 List 값을 init하여 DB에 저장
			/*
				//리스트만큼 순차적으로 Id에 Serial값과 이력서id를 입력 
				for(int i=0;i<academicBgList.size();i++){
					academicBgList.get(i).setAcademicBgId(loginId+String.format("%06d", i));
					academicBgList.get(i).setResumeId(loginId);
				}
		
				for(int i=0;i<careerList.size();i++){
					careerList.get(i).setCareerId(loginId+String.format("%06d", i));
					careerList.get(i).setResumeId(loginId);
				}
		
			
				for(int i=0;i<certificateList.size();i++){
					certificateList.get(i).setCertificateId(loginId+String.format("%06d", i));
					certificateList.get(i).setResumeId(loginId);
				}
		
				for(int i=0;i<projectCareerList.size();i++){
					projectCareerList.get(i).setProjectCareerID(loginId+String.format("%06d", i));
					projectCareerList.get(i).setResumeId(loginId);
				}
			*/
			//end
			
			//DB리스트를 전부 삭제한 후, UI에서 가져온 정보를 DB에 전부 삽입
			//리스트를 전부 삭제
			
			resumeDAO.deleteAcademicBgById(loginId);
			resumeDAO.deleteCareerById(loginId);
			resumeDAO.deleteCertificateById(loginId);
			resumeDAO.deleteProjectCareerById(loginId);
			
			//이력서 정보 전부 삽입
			resumeDAO.insertAcademicBgList(academicBgList);
			resumeDAO.insertCareerList(careerList);
			resumeDAO.insertCertificateList(certificateList);
			resumeDAO.insertProjectCareerList(projectCareerList);
		}
		
		return SUCCESS;
	}
	

	public String insertResume(){
		String loginId = (String) session.get("loginId");
		resume.setMemberId(loginId);		
		return SUCCESS;		
	}

	public Member getMemberVo() {
		return memberVo;
	}

	public void setMemberVo(Member memberVo) {
		this.memberVo = memberVo;
	}

	public Resume getResumeVo() {
		return resumeVo;
	}

	public void setResumeVo(Resume resumeVo) {
		this.resumeVo = resumeVo;
	}

	public ArrayList<AcademicBg> getAcademicBgList() {
		return academicBgList;
	}

	public void setAcademicBgList(ArrayList<AcademicBg> academicBgList) {
		this.academicBgList = academicBgList;
	}

	public ArrayList<Career> getCareerList() {
		return careerList;
	}

	public void setCareerList(ArrayList<Career> careerList) {
		this.careerList = careerList;
	}

	public ArrayList<Certificate> getCertificateList() {
		return certificateList;
	}

	public void setCertificateList(ArrayList<Certificate> certificateList) {
		this.certificateList = certificateList;
	}

	public ArrayList<ProjectCareer> getProjectCareerList() {
		return projectCareerList;
	}

	public void setProjectCareerList(ArrayList<ProjectCareer> projectCareerList) {
		this.projectCareerList = projectCareerList;
	}

	public ArrayList<Resume> getResumeList() {
		return resumeList;
	}

	public void setResumeList(ArrayList<Resume> resumeList) {
		this.resumeList = resumeList;
	}

	public String getUseryear() {
		return useryear;
	}

	public void setUseryear(String useryear) {
		this.useryear = useryear;
	}

	public String getUsermonth() {
		return usermonth;
	}

	public void setUsermonth(String usermonth) {
		this.usermonth = usermonth;
	}

	public String getUserday() {
		return userday;
	}

	public void setUserday(String userday) {
		this.userday = userday;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public String getResumeId() {
		return resumeId;
	}

	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}
	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;

	}


}
