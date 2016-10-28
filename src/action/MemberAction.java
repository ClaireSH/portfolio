package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.MemberDAO;
import dao.ResumeDAO;
import vo.AcademicBg;
import vo.Career;
import vo.Certificate;
import vo.Member;
import vo.ProjectCareer;
import vo.Resume;

public class MemberAction extends ActionSupport implements SessionAware{
	Member memberVo;
	AcademicBg academicVo;
	Resume resumeVo;
	
	ArrayList<AcademicBg> academicBgList;
	ArrayList<Career> careerList;
	ArrayList<Certificate> certificateList;
	ArrayList<ProjectCareer> projectCareerList;
	
	String id;
	String password;
	
	String useryear;
	String usermonth;
	String userday;
	
	Map<String, Object> session;
	
	MemberDAO memberDAO = new MemberDAO();
	ResumeDAO resumeDAO = new ResumeDAO();
	
	public String login(){
		
		Member m = memberDAO.selectMember(memberVo.getMemberId());
		
		if(m == null){
			return INPUT;
		}else if(!(memberVo.getPassword()).equals(m.getPassword())){
			return INPUT;
		}else{
			//로그인
			System.out.println(m.getName() + "  " + " Login!!");
			session.put("loginId", memberVo.getMemberId());
			return LOGIN;
		}
	}
	
	public String logout(){
		session.clear();
		return SUCCESS;
	}
	
	public String idCheck(){
		
		Member m = memberDAO.selectMember(memberVo.getMemberId());
		if(m != null){
			//idCheck()
			System.out.println(m.getMemberId() +" : ID 사용 가능");
			return SUCCESS;
		}else{
			System.out.println(m.getMemberId() +" : 이미 존재 하는 ID입니다.");
			return INPUT;
		}
	}
	
	public String join(){
		
		if(memberVo != null){
			//회원가입 정보가 존재하면
			String birth = useryear+"/"+usermonth+"/"+userday;
			memberVo.setBirth(birth);
			
			AcademicBg academicBg = new AcademicBg();
			Career career = new Career();
			Certificate certificate = new Certificate();
			ProjectCareer projectCareer = new ProjectCareer();
			
			academicBg.setAcademicBgId(memberVo.getMemberId()+"000000");
			academicBg.setResumeId(memberVo.getMemberId());
			career.setCareerId(memberVo.getMemberId()+"000000");
			career.setResumeId(memberVo.getMemberId());
			certificate.setCertificateId(memberVo.getMemberId()+"000000");
			certificate.setResumeId(memberVo.getMemberId());
			projectCareer.setProjectCareerID(memberVo.getMemberId()+"000000");
			projectCareer.setResumeId(memberVo.getMemberId());
			
			System.out.println(academicBg.toString());
			System.out.println(career.toString());
			System.out.println(certificate.toString());
			System.out.println(projectCareer.toString());
			
			memberDAO.insertMember(memberVo);
			resumeDAO.insertAcademicBg(academicBg);
			resumeDAO.insertCareer(career);
			resumeDAO.insertCertificate(certificate);
			resumeDAO.insertProjectCareer(projectCareer);
			
			return SUCCESS;
		}else{
			//회원가입 실패
			return INPUT;
		}
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
		
		String loginId = (String)session.get("loginId");
		Member m = memberDAO.selectMember(loginId);
		if(m == null){
			return INPUT;
		}else if(!(memberVo.getPassword()).equals(m.getPassword())){
			return INPUT;
		}else{
			//업데이트
			System.out.println(m.getName() + "  " + " Update!!");
			memberDAO.updateMember(m);
			return SUCCESS;
		}
	}
		
	//개인정보 이력 초기화 작업
	public String initUpdateResume() throws Exception{
		
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
			projectCareerList = (ArrayList<ProjectCareer>) resumeDAO.allProjectCareerById(resumeVo.getResumeId());
			
			return SUCCESS;
		}	
	}
	
	public String updateResume(){
		String loginId = (String)session.get("loginId");
		Resume r = resumeDAO.selectResume(loginId);
		if(r == null){
			return INPUT;
		}else{
			
			
		}
		
		return SUCCESS;
	}

	
	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	
}
