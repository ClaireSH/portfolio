package vo;

public class Resume {
	String resumeId;		//pk
	String memberId;
	String originalImgFile;	//사용자가 첨부한 파일명
	String savedImgFile;	//실제 서버에 저장된 파일명
	String prTitle;			//자기소개서 제목
	String prContent;		//자기소개서 내용
	
	
	
	public Resume() {
	}
	public String getResumeId() {
		return resumeId;
	}
	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	@Override
	public String toString() {
		return "Resume [resumeId=" + resumeId + ", memberId=" + memberId + ", originalImgFile=" + originalImgFile
				+ ", savedImgFile=" + savedImgFile + ", prTitle=" + prTitle + ", prContent=" + prContent + "]";
	}
	
	
	
	
}
