package src.portfolio.VO;

public class Career {
	private String careerId;
	private String joinYear;
	private String retirementYear;
	private String companyName;
	private String businessType;
	private String department;
	private String position;
	
	public Career(){}
	
	public String getCareerId() {
		return careerId;
	}
	public void setCareerId(String careerId) {
		this.careerId = careerId;
	}
	public String getJoinYear() {
		return joinYear;
	}
	public void setJoinYear(String joinYear) {
		this.joinYear = joinYear;
	}
	public String getRetirementYear() {
		return retirementYear;
	}
	public void setRetirementYear(String retirementYear) {
		this.retirementYear = retirementYear;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Career [careerId=" + careerId + ", joinYear=" + joinYear + ", retirementYear=" + retirementYear
				+ ", companyName=" + companyName + ", businessType=" + businessType + ", department=" + department
				+ ", position=" + position + "]";
	}
	
	
	
}
