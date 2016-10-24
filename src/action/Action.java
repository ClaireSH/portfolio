package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.MemberDAO;

public class Action extends ActionSupport implements SessionAware{
//	Member memberVo;
	String id;
	String password;
	
	String useryear;
	String usermonth;
	String userday;
	
	//test
	String email;
	String remember;
	
	
	
//	Map<String, Object> session;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(
			String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(
			String email) {
		this.email = email;
	}

	public String getRemember() {
		return remember;
	}

	public void setRemember(
			String remember) {
		this.remember = remember;
	}

//	MemberDAO dao = new MemberDAO();
	
	public String login(){
	
		System.out .println("123============");
		return SUCCESS;
		
		/*
		 * memberVo=dao.selectMember(id);
		
		if(memberVo == null){
			return INPUT;
		}else if(!password.equals(memberVo.getPassword())){
			return INPUT;
		}else{
			//로그인
			System.out.println(memberVo.getName() + "  " + id + " Login!!");
			session.put("loginId", id);
			return LOGIN;
		}*/
	}

	public void setSession(
			Map arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*public String logout(){
		session.clear();
		return SUCCESS;
	}
	
	public String join(){
		
		if(memberVo != null){
			//회원가입 정보가 존재하면
			String birth = useryear+"/"+usermonth+"/"+userday;
			memberVo.setBirth(birth);
			dao.insertMember(memberVo);
			return SUCCESS;
		}else{
			//회원가입 실패
			return INPUT;
		}
	}

	public Member getMemberVo() {
		return memberVo;
	}

	public void setMemberVo(Member memberVo) {
		this.memberVo = memberVo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUseryear() {
		return useryear;
	}

	public void setUseryear(String useryear) {
		this.useryear = useryear;
	}

	public String getUsermonth() {
		return usermonth;
	}

	public void setUsermonth(String usermonth) {
		this.usermonth = usermonth;
	}

	public String getUserday() {
		return userday;
	}

	public void setUserday(String userday) {
		this.userday = userday;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
*/	
	
}
