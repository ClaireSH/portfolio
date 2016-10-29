package vo;

public class Certificate {
	private String certificateId;
	private String resumeId;
	private String year;
	private String month;
	private String certificateName;
	private String remarks;
	
	public Certificate(){}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public String getResumeId() {
		return resumeId;
	}

	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Certificate [certificateId=" + certificateId + ", resumeId=" + resumeId + ", year=" + year + ", month="
				+ month + ", certificateName=" + certificateName + ", remarks=" + remarks + "]";
	}
	
	public void setEmptyValues(){
		this.certificateId = "";
		this.resumeId = "";
		this.year = "";
		this.month = "";
		this.certificateName = "";
		this.remarks = "";
	}
	
	
}
