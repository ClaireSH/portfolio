package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.MemberDAO;
import vo.Member;
import vo.Resume;

public class ResumeAction extends ActionSupport implements SessionAware{

	private Resume resume;
	private String resumeId;
	
	MemberDAO dao=new MemberDAO();
	Map<String, Object> session;
	
	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}

	public String insertResume(){
		String loginId = (String) session.get("loginId");
		resume.setMemberId(loginId);		
		return SUCCESS;		
	}
}
