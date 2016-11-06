package action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.MemberDAO;
import dao.ResumeDAO;
import util.FileService;
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
	
	private File upload;					/** 업로드할 파일. Form의 <file> 태그의 name. */
	private String uploadFileName;			/** 업로드할 파일의 파일명 (File타입 속성명 + "FileName") */
	private String uploadContentType;		/** 업로드할 파일의 컨텐츠 타입 (File타입 속성명 + "ContentType") */
	
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
			
			FileService fileService = new FileService();
			try {
				
				HttpServletRequest request = ServletActionContext.getRequest();
			    ServletContext servletContext = request.getSession().getServletContext();
			    String basePath = servletContext.getRealPath("img/"+loginId);
			    System.out.println("basePath"+basePath);
				String originalFileName = uploadFileName;
				String savedFileName = fileService.saveFile(upload, basePath, uploadFileName);
				
				resumeVo = new Resume();
				resumeVo.setOriginalImgFile(originalFileName);
				resumeVo.setSavedImgFile(savedFileName);
				
				resumeVo.setMemberId(loginId);
				resumeVo.setResumeId(loginId);
		
				System.out.println(resumeVo.getOriginalImgFile());
				System.out.println(resumeVo.getSavedImgFile());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resumeDAO.updateResume(resumeVo);
			
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

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	
	
	

}
