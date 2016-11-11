package vo;

import java.util.ArrayList;

public class MyCoverWithTag {
	private String myCoverId;
	private String resumeId;
	private String versionName;
	private String content;
	private ArrayList<Tag> tagList;
	
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
	public ArrayList<Tag> getTagList() {
		return tagList;
	}
	public void setTagList(ArrayList<Tag> tagList) {
		this.tagList = tagList;
	}
	@Override
	public String toString() {
		return "MyCoverWithTag [myCoverId=" + myCoverId + ", resumeId=" + resumeId + ", versionName=" + versionName
				+ ", content=" + content + ", tagList=" + tagList + "]";
	}
	
	
	
	
	
	
}
