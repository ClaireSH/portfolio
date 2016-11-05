package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.QuestionDAO;
import vo.Answer;
import vo.Question;

public class QnaEditAction extends ActionSupport implements SessionAware{
	ArrayList<Question> qList;
	ArrayList<Answer>	aList;
	
	
	Map<String, Object> session;
	
	QuestionDAO dao = new QuestionDAO();

	public String initQnaList(){
		String loginId = (String)session.get("loginId");
		qList = dao.allQuestionList();
		aList = dao.selectAnswerList(loginId);
		
		for(Question q : qList){
			System.out.println(q.toString());
		}
		
		for(Answer a : aList){
			System.out.println(a.toString());
		}
		
		return SUCCESS;
	}
	
	public String updateQna(){
		String loginId = (String)session.get("loginId");

		for(Answer a : aList){
			a.setMemberId(loginId);		//아이디 지정
			dao.updateAnswer(a);
			System.out.println("updateQnaList"+a.toString());
		}
		
		return SUCCESS;
	}
	
	public ArrayList<Question> getqList() {
		return qList;
	}


	public void setqList(ArrayList<Question> qList) {
		this.qList = qList;
	}


	public ArrayList<Answer> getaList() {
		return aList;
	}


	public void setaList(ArrayList<Answer> aList) {
		this.aList = aList;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
