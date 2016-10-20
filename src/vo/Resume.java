package src.portfolio.VO;

public class Resume {
	String resumeId;		//pk
	String originalImgFile;	//사용자가 첨부한 파일명
	String savedImgFile;	//실제 서버에 저장된 파일명
	String prTitle;			//
	String prContent;
	
	String academicBgId;
	String careerId;
	String certificateId;
	String projectCareerId;
	
	public Resume() {}
	
	public String getResumeId() {
		return resumeId;
	}
	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}
	public String getOriginalImgFile() {
		return originalImgFile;
	}
	public void setOriginalImgFile(String originalImgFile) {
		this.originalImgFile = originalImgFile;
	}
	public String getSavedImgFile() {
		return savedImgFile;
	}
	public void setSavedImgFile(String savedImgFile) {
		this.savedImgFile = savedImgFile;
	}
	public String getPrTitle() {
		return prTitle;
	}
	public void setPrTitle(String prTitle) {
		this.prTitle = prTitle;
	}
	public String getPrContent() {
		return prContent;
	}
	public void setPrContent(String prContent) {
		this.prContent = prContent;
	}
	public String getAcademicBgId() {
		return academicBgId;
	}
	public void setAcademicBgId(String academicBgId) {
		this.academicBgId = academicBgId;
	}
	public String getCareerId() {
		return careerId;
	}
	public void setCareerId(String careerId) {
		this.careerId = careerId;
	}
	public String getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
	public String getProjectCareerId() {
		return projectCareerId;
	}
	public void setProjectCareerId(String projectCareerId) {
		this.projectCareerId = projectCareerId;
	}
	@Override
	public String toString() {
		return "Resume [resumeId=" + resumeId + ", originalImgFile=" + originalImgFile + ", savedImgFile="
				+ savedImgFile + ", prTitle=" + prTitle + ", prContent=" + prContent + ", academicBgId=" + academicBgId
				+ ", careerId=" + careerId + ", certificateId=" + certificateId + ", projectCareerId=" + projectCareerId
				+ "]";
	}
	
	
	
}
