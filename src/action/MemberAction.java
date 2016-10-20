package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.MemberDAO;
import vo.Member;

public class MemberAction extends ActionSupport implements SessionAware{
	Member member;
	String id;
	String password;
	boolean duplicated;
	
	MemberDAO dao=new MemberDAO();
	Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	public String insertMember(){
		dao.insertMember(member);
		return SUCCESS;
	}
	
	public String idCheck(){
		member=dao.selectMember(id);
		duplicated=member !=null;
		return SUCCESS;
	}
	
	public String login(){
		member=dao.selectMember(id);
		if(member==null){
			return INPUT;
		}
		if(!password.equals(member.getPassword())){
			return INPUT;	
		}
		session.put("loginId", id);
		return SUCCESS;
	}
	
	public String logout(){
		session.clear();
		return SUCCESS;
	}
}
