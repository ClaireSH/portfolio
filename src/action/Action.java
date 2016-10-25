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
		
		Member m = dao.selectMember(memberVo.getMemberId());
		
		if(m == null){
			return INPUT;
		}else if(!(memberVo.getPassword()).equals(m.getPassword())){
			return INPUT;
		}else{
			//로그인
			System.out.println(m.getName() + "  " + " Login!!");
			session.put("loginId", memberVo.getMemberId());
			return LOGIN;
		}
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
	public String initUpdateMember(){
		//현재 로그인 ID를 불러 updateMemberForm에 값을 Init 
		String loginId = (String)session.get("loginId");
		memberVo = dao.selectMember(loginId);
		memberVo.setPassword("");
		String useryear = (memberVo.getBirth()).substring(0,4);
		String usermonth = (memberVo.getBirth()).substring(5,7);	
		String userday = (memberVo.getBirth().substring(8, 10)); 
		System.out.println(useryear+"/"+usermonth+"/"+userday);
		System.out.println(memberVo.toString());
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
