package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.QuestionDAO;
import vo.Answer;
import vo.Qna;
import vo.Question;

public class QnaEditAction extends ActionSupport implements SessionAware {
	ArrayList<Qna> qnaList;
	
	Map<String, Object> session;

	QuestionDAO dao = new QuestionDAO();

	/**질문편집 페이지에서 질문 답변 불러오기 
	 * @return
	 */
	public String initQnaList() {
		System.out.println("QnaEditAction.initQnaList 실행");

		ArrayList<Question> qList;
		ArrayList<Answer> aList;	
		
		String loginId = (String) session.get("loginId");
		qList = dao.selectFinishedQuestionListById(loginId);
		aList = dao.selectAnswerList(loginId);
		
		System.out.println("qList Length :" +qList.size());
		System.out.println("aList Length :" +aList.size());

		if (aList != null) {

			for (Answer a : aList) {
				System.out.println(a.toString());
			}
		}
		
		qnaList = new ArrayList<>();//보내줄 완성된 리스트
		for(int i=0;i<qList.size();i++){
			Qna qna = new Qna();
			qna.setQuestionId(qList.get(i).getQuestionId());
			qna.setQuestionType(qList.get(i).getQuestionType());
			qna.setQuestion(qList.get(i).getQuestion());
			qna.setAnswer(aList.get(i).getAnswer()); //Answer 넣기
			
			qnaList.add(qna);
		}
		
		for (Qna q : qnaList) {
			System.out.println(q.toString());
			
		}
		
		return SUCCESS;
	}
	
	public String updateAnswer(){
		
		String loginId = (String) session.get("loginId");
		for(Qna qna : qnaList){
			System.out.println(qna.toString());
			Answer answer = new Answer();
			answer.setQuestionId(qna.getQuestionId());		//0, 1, 2, 3, 4...
			answer.setMemberId(loginId);					//admin
			answer.setAnswer(qna.getAnswer());
			
			dao.updateAnswer(answer);
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
