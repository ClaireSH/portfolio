package vo;

public class AcademicBg {
	private String academicBgId;
	private String resumeId;
	private String adminssionYear;
	private String graduationYear;
	private String schoolName;
	private String major;
	private String degree;
	private String remarks;
	
	public AcademicBg() {}

	public String getAcademicBgId() {
		return academicBgId;
	}

	public void setAcademicBgId(String academicBgId) {
		this.academicBgId = academicBgId;
	}

	public String getResumeId() {
		return resumeId;
	}

	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}

	public String getAdminssionYear() {
		return adminssionYear;
	}

	public void setAdminssionYear(String adminssionYear) {
		this.adminssionYear = adminssionYear;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "AcademicBg [academicBgId=" + academicBgId + ", resumeId=" + resumeId + ", adminssionYear="
				+ adminssionYear + ", graduationYear=" + graduationYear + ", schoolName=" + schoolName + ", major="
				+ major + ", degree=" + degree + ", remarks=" + remarks + "]";
	}
	
	public void setEmptyValues(){
		this.academicBgId = "";
		this.resumeId = "";
		this.adminssionYear = "";
		this.graduationYear = "";
		this.schoolName = "";
		this.major = "";
		this.degree = "";
		this.remarks = "";
	}
	
	
	
}
