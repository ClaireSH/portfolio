package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.MyCoverWithTagDAO;
import dao.QuestionDAO;
import vo.Answer;
import vo.MyCoverWithTag;
import vo.Qna;
import vo.Question;
import vo.Tag;

public class MyCoverJsonAction extends ActionSupport implements SessionAware{
	ArrayList<Qna> qnaList;
	ArrayList<MyCoverWithTag> coverList;
	
	Map<String, Object> session;

	QuestionDAO questionDao = new QuestionDAO();
	MyCoverWithTagDAO coverDao = new MyCoverWithTagDAO();
	
	public String initMyCover(){
		
		//Question 파트
		qnaList = new ArrayList<>();
		ArrayList<Question> qList = null;
		ArrayList<Answer> aList = null;
		
		String loginId = (String) session.get("loginId");
		qList = questionDao.selectFinishedQuestionListById(loginId);
		aList = questionDao.selectAnswerList(loginId);
		
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
		
		//Cover 파트//
		coverList = coverDao.selectMyCoverListByResumeId(loginId);
		ArrayList<Tag> tagList = null; 
		for(MyCoverWithTag cover : coverList){
			tagList = coverDao.selectTagList(cover.getMyCoverId());
			cover.setTagList(tagList);	
		}
		
		for(MyCoverWithTag cover : coverList){
			
			System.out.println(cover.toString());
			for(Tag tag : tagList){
				System.out.println(tag.toString());
			}
		}
		
		return SUCCESS;
	}
	
	public String updateMyCover(){

		//Question 파트
		qnaList = new ArrayList<>();
		ArrayList<Question> qList = null;
		ArrayList<Answer> aList = null;
		
		String loginId = (String) session.get("loginId");
		qList = questionDao.selectFinishedQuestionListById(loginId);
		aList = questionDao.selectAnswerList(loginId);
		
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
		
		//Cover
		//String loginId = (String) session.get("loginId");
		coverList = coverDao.selectMyCoverListByResumeId(loginId);
		ArrayList<Tag> tagList = null; 
		for(MyCoverWithTag cover : coverList){
			tagList = coverDao.selectTagList(cover.getMyCoverId());
			cover.setTagList(tagList);	
		}
		
		for(MyCoverWithTag cover:coverList){
			coverDao.updateMyCover(cover);
			coverDao.deleteTagByMyCoverId(cover.getMyCoverId());
			for(Tag tag : cover.getTagList()){
				coverDao.insertTag(tag);
			}
		}
		
		loginId = (String) session.get("loginId");
		coverList = coverDao.selectMyCoverListByResumeId(loginId);
		tagList = null; 
		for(MyCoverWithTag cover : coverList){
			tagList = coverDao.selectTagList(cover.getMyCoverId());
			cover.setTagList(tagList);	
		}
		
		for(MyCoverWithTag cover : coverList){
			
			System.out.println(cover.toString());
			for(Tag tag : tagList){
				System.out.println(tag.toString());
			}
		}
		
		return SUCCESS;
	}
	
	public String allDisplay(){
		System.out.println("allDisplay");
		qnaList = new ArrayList<>();
		
		ArrayList<Question> qList = null;
		ArrayList<Answer> aList = null;
		
		String loginId = (String) session.get("loginId");
		qList = questionDao.selectFinishedQuestionListById(loginId);
		aList = questionDao.selectAnswerList(loginId);
		
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
		qList = questionDao.selectFinishedQuestionListById(loginId);
		aList = questionDao.selectAnswerList(loginId);
		
		
		for(int i=0;i<qList.size();i++){
			if(qList.get(i).getQuestionType().equals("여가생활")){
				Qna qna = new Qna();
				//질문
				qna.setQuestionId(qList.get(i).getQuestionId());
				qna.setQuestionType(qList.get(i).getQuestionType());
				qna.setQuestion(qList.get(i).getQuestion());
				//답변
				qna.setAnswer(aList.get(i).getAnswer());
				//삽입
				System.out.println(qna.toString());
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
		qList = questionDao.selectFinishedQuestionListById(loginId);
		aList = questionDao.selectAnswerList(loginId);
		
		
		for(int i=0;i<qList.size();i++){
			if(qList.get(i).getQuestionType().equals("대학생활")){
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
		qList = questionDao.selectFinishedQuestionListById(loginId);
		aList = questionDao.selectAnswerList(loginId);
		
		
		for(int i=0;i<qList.size();i++){
			if(qList.get(i).getQuestionType().equals("일상생활")){
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
		qList = questionDao.selectFinishedQuestionListById(loginId);
		aList = questionDao.selectAnswerList(loginId);
		
		
		for(int i=0;i<qList.size();i++){
			if(qList.get(i).getQuestionType().equals("개발생활")){
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

	
	
	public ArrayList<MyCoverWithTag> getCoverList() {
		return coverList;
	}

	public void setCoverList(ArrayList<MyCoverWithTag> coverList) {
		this.coverList = coverList;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
