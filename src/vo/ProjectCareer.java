package vo;


public class ProjectCareer {
	private String projectCareerID;
	private String projectName;
	private String developmentPeriod;
	private String duration;
	private String language;
	private String dbos;
	private String etc;
	
	public ProjectCareer() {}
	
	
	public String getProjectCareerID() {
		return projectCareerID;
	}



	public void setProjectCareerID(String projectCareerID) {
		this.projectCareerID = projectCareerID;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getDevelopmentPeriod() {
		return developmentPeriod;
	}



	public void setDevelopmentPeriod(String developmentPeriod) {
		this.developmentPeriod = developmentPeriod;
	}



	public String getDuration() {
		return duration;
	}



	public void setDuration(String duration) {
		this.duration = duration;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	public String getDbos() {
		return dbos;
	}



	public void setDbos(String dbos) {
		this.dbos = dbos;
	}



	public String getEtc() {
		return etc;
	}



	public void setEtc(String etc) {
		this.etc = etc;
	}



	@Override
	public String toString() {
		return "ProjectCareer [projectCareerID=" + projectCareerID + ", projectName=" + projectName
				+ ", developmentPeriod=" + developmentPeriod + ", duration=" + duration + ", language=" + language
				+ ", dbos=" + dbos + ", etc=" + etc + "]";
	}
	
	
}
