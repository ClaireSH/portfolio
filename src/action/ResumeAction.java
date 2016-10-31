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
import vo.Pr;
import vo.ProjectCareer;
import vo.Resume;

public class ResumeAction extends ActionSupport implements SessionAware{
	Member memberVo;
	Resume resumeVo;
	
	ArrayList<AcademicBg> academicBgList;
	ArrayList<Career> careerList;
	ArrayList<Certificate> certificateList;
	ArrayList<ProjectCareer> projectCareerList;
	
	ArrayList<Resume> resumeList;
	ArrayList<Pr> prList;
	
	String useryear;
	String usermonth;
	String userday;
	
	private Resume resume;
	private String resumeId;
	
	MemberDAO memberDAO= new MemberDAO();
	ResumeDAO resumeDAO = new ResumeDAO();
	Map<String, Object> session;
	
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
			projectCareerList = (ArrayList<ProjectCareer>) resumeDAO.allProjectCareerById(resumeVo.getResumeId());
			
			for(AcademicBg ab : academicBgList){
				System.out.println(ab.toString());
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
			
			//값을 Insert
			//각 List 값을 init하여 DB에 저장
			//academicBgList
			if(academicBgList == null){
				academicBgList = new ArrayList<>();
				//List에 없더라도  PK,FK 값 집어 넣음
				//('loginID000000', 'loginId', null, null...)
				AcademicBg academicBg = new AcademicBg();
				academicBg.setAcademicBgId(loginId+"000000");
				academicBg.setResumeId(loginId);
				academicBgList.add(academicBg);
			}else{
				//리스트만큼 순차적으로 Id에 Serial값과 이력서id를 입력 
				for(int i=0;i<academicBgList.size();i++){
					academicBgList.get(i).setAcademicBgId(loginId+String.format("%06d", i));
					academicBgList.get(i).setResumeId(loginId);
				}
			}
			//careerList
			if(careerList == null){
				careerList = new ArrayList<>();
				Career career = new Career();
				career.setCareerId(loginId+"000000");
				career.setResumeId(loginId);
				careerList.add(career);
			}else{
				for(int i=0;i<careerList.size();i++){
					careerList.get(i).setCareerId(loginId+String.format("%06d", i));
					careerList.get(i).setResumeId(loginId);
				}
			}
			//certificateList
			if(certificateList == null){
				certificateList = new ArrayList<>();
				Certificate certificate = new Certificate();
				certificate.setCertificateId(loginId+"000000");
				certificate.setResumeId(loginId);
				certificateList.add(certificate);
			}else{
				for(int i=0;i<certificateList.size();i++){
					certificateList.get(i).setCertificateId(loginId+String.format("%06d", i));
					certificateList.get(i).setResumeId(loginId);
				}
			}
			//projectCareerList
			if(projectCareerList == null){
				projectCareerList = new ArrayList<>();
				ProjectCareer projectCareer = new ProjectCareer();
				projectCareer.setProjectCareerID(loginId+"000000");
				projectCareer.setResumeId(loginId);
				projectCareerList.add(projectCareer);
			}else{
				for(int i=0;i<projectCareerList.size();i++){
					projectCareerList.get(i).setProjectCareerID(loginId+String.format("%06d", i));
					projectCareerList.get(i).setResumeId(loginId);
				}
			}
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

	public ArrayList<Pr> getPrList() {
		return prList;
	}

	public void setPrList(ArrayList<Pr> prList) {
		this.prList = prList;
	}

}
