package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.QnaDAO;
import dao.QuestionDAO;
import vo.Answer;
import vo.Qna;
import vo.Question;

public class JsonTestAction extends ActionSupport implements SessionAware{

	private Question questionVo;
	private Answer	answerVo;
	private ArrayList<Question> qList;
	private ArrayList<Answer> aList;
	private ArrayList<Qna> qnaList;
	
	QuestionDAO qDao = new QuestionDAO(); 

	Map<String, Object> session;
	
	
	public String initQna(){
		System.out.println("initQna");
		String loginId = (String)session.get("loginId");
		qList = qDao.allQuestionList();
		aList = qDao.selectAnswerList(loginId);
		
		
		if(aList == null){
			//답변이 등록되지 않으면, 첫번째 질문만 정보를 가져옴
			Question firstQuestion = qDao.selectQuestion("00000");
			qList.add(firstQuestion);
			System.out.println("11111"+qList.get(0).toString());
			int convertQuestionId = Integer.parseInt(qList.get(0).getQuestionId());
			//qList.questionId = 00000, 00001, 00002, 00003...
			qList.get(0).setQuestionId(String.valueOf(convertQuestionId));
			
		}else{
			//00000 자리수를 정상적으로 변환
			for(int i=0;i<qList.size();i++){
				int convertQuestionId = Integer.parseInt(qList.get(i).getQuestionId());
				//qList.questionId = 00000, 00001, 00002, 00003...
				qList.get(i).setQuestionId(String.valueOf(convertQuestionId));
			}
			
			for(int i=0;i<aList.size();i++){
				int convertQuestionId = Integer.parseInt(aList.get(i).getQuestionId());
				//aList.questionId = 00000, 00001, 00002, 00003...
				aList.get(i).setQuestionId(String.valueOf(convertQuestionId));
			}
		}

		return SUCCESS;
	}
	
	public String insertAnswer(){
	
		String loginId = (String)session.get("loginId");
		
		//총 질문 수, 해당 계정의 총 답변 수
		qList = qDao.allQuestionList();
		System.out.println("qList.size()"+qList.size());
		aList = qDao.selectAnswerList(loginId);
		System.out.println("aList.size()"+aList.size());
		
		//DB에 답변이 없으면 00000, loginId, 해당 답변을 넣어준다 
		if(aList == null){
			//첫 답변을 DB에 저장		
			answerVo.setMemberId(loginId);
			answerVo.setQuestionId(String.format("%05d", 0));
			qDao.insertAnswer(answerVo);
			
			//다음 질문을 DB에서 불러옴
			questionVo = qDao.selectQuestion(String.format("%05d", 1));
			
			//00000자리수를 정상적으로 컨버팅하여 출력
			answerVo.setQuestionId("0");
			questionVo.setQuestionId("1");
			
			return SUCCESS;
		}
		
		System.out.println(qList.size()+"    "+aList.size());
		if(qList.size() <= aList.size()-1){
			System.out.println("in");
			//마지막 질문에 대한 답변
			int finishedQuestionLength = (qDao.selectFinishedQuestionListById(loginId)).size(); 		
			answerVo.setMemberId(loginId);
			answerVo.setQuestionId(String.format("%05d", finishedQuestionLength));
			qDao.insertAnswer(answerVo);
			
			answerVo.setQuestionId(String.valueOf(finishedQuestionLength));
			return SUCCESS;
		}else if(qList.size() <= aList.size()){
			// 질문 수와 답변 수가 같거나 그 이상이면 에러
			// 이유 : insert해도 질문Vo와 답변Vo가 Null
			return SUCCESS;
		}else{
			//답변을 DB에 저장
			int finishedQuestionLength = (qDao.selectFinishedQuestionListById(loginId)).size(); 		
			answerVo.setMemberId(loginId);
			answerVo.setQuestionId(String.format("%05d", finishedQuestionLength));
			qDao.insertAnswer(answerVo);
			
			//다음 질문을 DB에서 불러옴
			int nextLength = finishedQuestionLength + 1;
			questionVo = qDao.selectQuestion(String.format("%05d", nextLength));
			
			//00000자리수를 정상적으로 컨버팅하여 출력
			answerVo.setQuestionId(String.valueOf(finishedQuestionLength));
			questionVo.setQuestionId(String.valueOf(nextLength));
		}

		return SUCCESS;
	}
	
	public Question getQuestionVo() {
		return questionVo;
	}

	public void setQuestionVo(Question questionVo) {
		this.questionVo = questionVo;
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

	public Answer getAnswerVo() {
		return answerVo;
	}

	public void setAnswerVo(Answer answerVo) {
		this.answerVo = answerVo;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

}
