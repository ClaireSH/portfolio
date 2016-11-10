package vo;

public class Resume {
	String resumeId;		//pk
	String memberId;
	String originalImgFile;	//사용자가 첨부한 파일명
	String savedImgFile;	//실제 서버에 저장된 파일명

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
	@Override
	public String toString() {
		return "Resume [resumeId=" + resumeId + ", memberId=" + memberId + ", originalImgFile=" + originalImgFile
				+ ", savedImgFile=" + savedImgFile + "]";
	}
	
	
	
	
	
	
}
