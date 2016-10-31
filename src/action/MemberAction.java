package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.MemberDAO;
import dao.ResumeDAO;
import vo.AcademicBg;
import vo.Career;
import vo.Certificate;
import vo.FavoriteMember;
import vo.Member;
import vo.ProjectCareer;
import vo.Resume;

public class MemberAction extends ActionSupport implements SessionAware{
	Member memberVo;
	AcademicBg academicVo;
	Resume resumeVo;
	Career careerVo;
	Certificate certificateVo;
	ProjectCareer projectCareerVo;
	
	String id;
	String password;
	
	String useryear;
	String usermonth;
	String userday;
	
	boolean result;
	
	Map<String, Object> session;
	
	MemberDAO memberDAO = new MemberDAO();
	ResumeDAO resumeDAO = new ResumeDAO();
	
	public String login(){
		System.out.println("로그인을하자미친놈아");
		Member m = memberDAO.selectMember(memberVo.getMemberId());
		if(m == null){
			return INPUT;
		}else if(!(memberVo.getPassword()).equals(m.getPassword())){
			return INPUT;
		}else{
			//로그인
			System.out.println(m.getName() + "  " + " Login!!");
			session.put("loginId", memberVo.getMemberId());
			
			//로그인 하면 메인으로 가는데 거기서 필요한 데이터
			//나의인생 , 알람소식 
			
			
			return LOGIN;
		}
	}
	
	public String logout(){
		session.clear();
		return SUCCESS;
	}
	
	public String idCheck() throws Exception{
		
		System.out.println("---------------"+id);
		Member member = memberDAO.selectMember(memberVo.getMemberId());
		System.out.println("--------------111-");
		if(member == null){
			//idCheck()
			System.out.println(" : ID 사용 가능");
			result = true;
			return SUCCESS;
		}else{
			System.out.println(member.getMemberId() +" : 이미 존재 하는 ID입니다.");
			result = false;
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

	public Member getMemberVo() {
		return memberVo;
	}

	public void setMemberVo(Member memberVo) {
		this.memberVo = memberVo;
	}

	public AcademicBg getAcademicVo() {
		return academicVo;
	}

	public void setAcademicVo(AcademicBg academicVo) {
		this.academicVo = academicVo;
	}

	public Resume getResumeVo() {
		return resumeVo;
	}

	public void setResumeVo(Resume resumeVo) {
		this.resumeVo = resumeVo;
	}

	public Career getCareerVo() {
		return careerVo;
	}

	public void setCareerVo(Career careerVo) {
		this.careerVo = careerVo;
	}

	public Certificate getCertificateVo() {
		return certificateVo;
	}

	public void setCertificateVo(Certificate certificateVo) {
		this.certificateVo = certificateVo;
	}

	public ProjectCareer getProjectCareerVo() {
		return projectCareerVo;
	}

	public void setProjectCareerVo(ProjectCareer projectCareerVo) {
		this.projectCareerVo = projectCareerVo;
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

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
