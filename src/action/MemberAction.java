package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.MemberDAO;
import vo.Member;

public class MemberAction extends ActionSupport implements SessionAware{
	Member memberVo;
	String id;
	String password;
	
	//membervo.birth에 들어갈 유저의 생년월일 정보  
	String useryear;
	String usermonth;
	String userday;
	
	boolean duplicated;
	
	MemberDAO dao=new MemberDAO();
	Map<String, Object> session;
	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	
	public String insertMember(){
		dao.insertMember(memberVo);
		return SUCCESS;
	}
	
	public String idCheck(){
		memberVo=dao.selectMember(id);
		duplicated=memberVo !=null;
		return SUCCESS;
	}
	
	public String login(){
		memberVo=dao.selectMember(id);
		if(memberVo==null){
			return INPUT;
		}
		if(!password.equals(memberVo.getPassword())){
			return INPUT;	
		}
		session.put("loginId", id);
		return SUCCESS;
	}
	
	public String logout(){
		session.clear();
		return SUCCESS;
	}
	
	public String join(){
		
		memberVo.setBirth(useryear+"-"+usermonth+"-"+userday);
		if(memberVo != null){
			//회원가입 성공
			dao.insertMember(memberVo);
			return SUCCESS;
		}else{
			//회원가입 실패
			return INPUT;
		}
		
	}
	
	public String updateCustomerForm() {
		id = (String) session.get("loginId");
		memberVo = dao.selectMember(id);
		return SUCCESS;
	}

	public String updateCustomer() {
		id = (String) session.get("loginId");
		memberVo.setMemberId(id);
		dao.updateCustomer(memberVo);
		return SUCCESS;
	}
}
