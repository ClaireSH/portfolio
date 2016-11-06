package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.MemberDAO;
import dao.ResumeDAO;
import vo.AcademicBg;
import vo.Member;

public class ProfileAction extends ActionSupport implements SessionAware{
	Member memberVo;
	
	String useryear;
	String usermonth;
	String userday;
	
	MemberDAO memberDAO = new MemberDAO();
	ResumeDAO resumeDAO = new ResumeDAO();
	Map<String, Object> session;
	
	public String initUpdateMember(){
		
		//현재 로그인 ID를 불러 updateMemberForm에 값을 Init 
		String loginId = (String)session.get("loginId");
		memberVo = memberDAO.selectMember(loginId);
		memberVo.setPassword("");
		String useryear = (memberVo.getBirth()).substring(0,4);
		String usermonth = (memberVo.getBirth()).substring(5,7);	
		String userday = (memberVo.getBirth().substring(8, 10)); 
		
		System.out.println(useryear+"/"+usermonth+"/"+userday);
		System.out.println(memberVo.toString());
		return SUCCESS;
	}
	
	//개인정보관리
	public String updateMember(){
		
		String loginId = (String)session.get("loginId");
		Member m = memberDAO.selectMember(loginId);
		if(m == null){
			return INPUT;
		}else if(!(memberVo.getPassword()).equals(m.getPassword())){
			return INPUT;
		}else{
			//업데이트
			memberDAO.updateMember(m);
			System.out.println(m.getName() + "  " + " Update!!");
			return SUCCESS;
		}
	}
	
	//회원탈퇴
	public String deleteMember(){
		
		String loginId = (String)session.get("loginId");
		Member m = memberDAO.selectMember(loginId);
		if(m == null){
			return INPUT;
		}else if(!(memberVo.getPassword()).equals(m.getPassword())){
			return INPUT;
		}else{
			//업데이트
			memberDAO.deleteMember(loginId);
			System.out.println(m.getName() + "  " + " Delete!!");
			return SUCCESS;
		}
	}
	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
}
