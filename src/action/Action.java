package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.MemberDAO;
import vo.Member;

public class Action extends ActionSupport implements SessionAware{
	Member memberVo;
	String id;
	String password;
	
	String useryear;
	String usermonth;
	String userday;
	
	Map<String, Object> session;
	
	MemberDAO dao = new MemberDAO();
	
	public String login(){
		System.out.println("==========================로그인");
		memberVo=dao.selectMember(id);
		
		return SUCCESS; 
		
	/*	if(memberVo == null){
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
	
	public String logout(){
		session.clear();
		return SUCCESS;
	}
	
	public String idCheck(){
		
		Member m = dao.selectMember(memberVo.getMemberId());
		if(m != null){
			//idCheck()
			System.out.println(m.getMemberId() +" : ID 사용 가능");
			return SUCCESS;
		}else{
			System.out.println(m.getMemberId() +" : 이미 존재 하는 ID입니다.");
			return INPUT;
		}
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
	
	//init
	public String updateMemberForm(){
		//현재 로그인 ID를 불러 updateMemberForm에 값을 Init 
		String loginId = (String)session.get("loginId");
		memberVo = dao.selectMember(loginId);
		return SUCCESS;
	}
	
/*	public String updateMember(){
		dao.updateMember(memberVo);
	}*/

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
	
	
}
