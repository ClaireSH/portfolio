package vo;

public class MyCover {
	private String myCoverId;
	private String resumeId;
	private String versionName;
	private	String content;
	
	public MyCover(){}
	
	
	
	public String getMyCoverId() {
		return myCoverId;
	}
	public void setMyCoverId(String myCoverId) {
		this.myCoverId = myCoverId;
	}

	public String getResumeId() {
		return resumeId;
	}
	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}



	@Override
	public String toString() {
		return "MyCover [myCoverId=" + myCoverId + ", resumeId=" + resumeId + ", versionName=" + versionName
				+ ", content=" + content + "]";
	}

	
}
