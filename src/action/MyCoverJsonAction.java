package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.QuestionDAO;
import vo.Answer;
import vo.Qna;
import vo.Question;

public class MyCoverJsonAction extends ActionSupport implements SessionAware{
	ArrayList<Qna> qnaList;
	
	Map<String, Object> session;

	QuestionDAO dao = new QuestionDAO();
	
	public String allDisplay(){
		System.out.println("allDisplay");
		qnaList = new ArrayList<>();
		
		ArrayList<Question> qList = null;
		ArrayList<Answer> aList = null;
		
		String loginId = (String) session.get("loginId");
		qList = dao.selectFinishedQuestionListById(loginId);
		aList = dao.selectAnswerList(loginId);
		
		for(int i=0;i<qList.size();i++){
			Qna qna = new Qna();
			//질문
			qna.setQuestionId(qList.get(i).getQuestionId());
			qna.setQuestionType(qList.get(i).getQuestionType());
			qna.setQuestion(qList.get(i).getQuestion());
			//답변
			qna.setAnswer(aList.get(i).getAnswer());
			//삽입
			qnaList.add(qna);
		}
		
		for(Qna qna:qnaList){
			System.out.println(qna.toString());
		}
				
		return SUCCESS;
	}
	
	public String displayFreeTime(){
		
		qnaList = new ArrayList<>();
		
		ArrayList<Question> qList = null;
		ArrayList<Answer> aList = null;
		
		String loginId = (String) session.get("loginId");
		qList = dao.selectFinishedQuestionListById(loginId);
		aList = dao.selectAnswerList(loginId);
		
		
		for(int i=0;i<qList.size();i++){
			if(qList.get(i).getQuestionType() == "여가시간"){
				Qna qna = new Qna();
				//질문
				qna.setQuestionId(qList.get(i).getQuestionId());
				qna.setQuestionType(qList.get(i).getQuestionType());
				qna.setQuestion(qList.get(i).getQuestion());
				//답변
				qna.setAnswer(aList.get(i).getAnswer());
				//삽입
				qnaList.add(qna);
			}
		}
		
		for(Qna qna:qnaList){
			System.out.println(qna.toString());
		}
		
		return SUCCESS;
	}
	
	public String displayUniversityLife(){ 
		
		qnaList = new ArrayList<>();
		
		ArrayList<Question> qList = null;
		ArrayList<Answer> aList = null;
		
		String loginId = (String) session.get("loginId");
		qList = dao.selectFinishedQuestionListById(loginId);
		aList = dao.selectAnswerList(loginId);
		
		
		for(int i=0;i<qList.size();i++){
			if(qList.get(i).getQuestionType() == "대학생활"){
				Qna qna = new Qna();
				//질문
				qna.setQuestionId(qList.get(i).getQuestionId());
				qna.setQuestionType(qList.get(i).getQuestionType());
				qna.setQuestion(qList.get(i).getQuestion());
				//답변
				qna.setAnswer(aList.get(i).getAnswer());
				//삽입
				qnaList.add(qna);
			}
		}
		
		for(Qna qna:qnaList){
			System.out.println(qna.toString());
		}
		
		return SUCCESS;
	}
	
	public String displayEveryDayLife(){
		
		qnaList = new ArrayList<>();
		
		ArrayList<Question> qList = null;
		ArrayList<Answer> aList = null;
		
		String loginId = (String) session.get("loginId");
		qList = dao.selectFinishedQuestionListById(loginId);
		aList = dao.selectAnswerList(loginId);
		
		
		for(int i=0;i<qList.size();i++){
			if(qList.get(i).getQuestionType() == "일상생활"){
				Qna qna = new Qna();
				//질문
				qna.setQuestionId(qList.get(i).getQuestionId());
				qna.setQuestionType(qList.get(i).getQuestionType());
				qna.setQuestion(qList.get(i).getQuestion());
				//답변
				qna.setAnswer(aList.get(i).getAnswer());
				//삽입
				qnaList.add(qna);
			}
		}
		
		for(Qna qna:qnaList){
			System.out.println(qna.toString());
		}
		
		return SUCCESS;
	}
	
	public String displayDevelop(){
		
		qnaList = new ArrayList<>();
		
		ArrayList<Question> qList = null;
		ArrayList<Answer> aList = null;
		
		String loginId = (String) session.get("loginId");
		qList = dao.selectFinishedQuestionListById(loginId);
		aList = dao.selectAnswerList(loginId);
		
		
		for(int i=0;i<qList.size();i++){
			if(qList.get(i).getQuestionType() == "개발생활"){
				Qna qna = new Qna();
				//질문
				qna.setQuestionId(qList.get(i).getQuestionId());
				qna.setQuestionType(qList.get(i).getQuestionType());
				qna.setQuestion(qList.get(i).getQuestion());
				//답변
				qna.setAnswer(aList.get(i).getAnswer());
				//삽입
				qnaList.add(qna);
			}
		}
		
		for(Qna qna:qnaList){
			System.out.println(qna.toString());
		}
		
		return SUCCESS;
	}
	
	
	

	public ArrayList<Qna> getQnaList() {
		return qnaList;
	}

	public void setQnaList(ArrayList<Qna> qnaList) {
		this.qnaList = qnaList;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
