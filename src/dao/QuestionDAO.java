package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.Answer;
import vo.Question;

public class QuestionDAO {
	private SqlSessionFactory factory=MybatisConfig.getSqlSessionFactory();

	public QuestionDAO(){
		
	}
	
	public Answer selectAnswer(String memberId, String questionId){
		System.out.println("QuestionDAO.selectQnaInfo");
		SqlSession ss=factory.openSession();
		
		Answer answer = null;
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("memberId", memberId);
		hashMap.put("questionId", questionId);
		try {
			answer = ss.selectOne("answer.selectAnswer", hashMap);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
		return answer;
	}
	
	public ArrayList<Answer> selectAnswerList(String memberId){
		System.out.println("QuestionDAO.selectAnswerListById");
		SqlSession ss=factory.openSession();
		
		List<Answer> aList = null;
		
		try {
			aList = ss.selectList("answer.selectAnswerListById", memberId);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
		return (ArrayList<Answer>) aList;
	}
	
	public void insertAnswer(Answer answer){
		System.out.println("QuestionDAO.insertAnswer");
		SqlSession ss=factory.openSession();
	
		try {
			ss.insert("answer.insertAnswer", answer);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
	}
	
	public void insertAnswerList(ArrayList<Answer> aList){
		System.out.println("QuestionDAO.insertAnswerList");
		SqlSession ss=factory.openSession();
	
		try {
			for(Answer answer:aList){
				ss.insert("answer.insertAnswer", answer);
			}		
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
	}
	
	public void updateAnswer(Answer answer){
		System.out.println("QuestionDAO.updateAnswer");
		SqlSession ss=factory.openSession();

		try {
			ss.update("answer.updateAnswer", answer);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
	}
	
	public ArrayList<Question> allQuestionList(){
		System.out.println("QuestionDAO.allQuestionList");
		SqlSession ss=factory.openSession();
		
		List<Question> qList = null;
		try {
			qList = ss.selectList("question.allQuestionList");
			for(int i=0;i<qList.size();i++){
				System.out.println(qList.get(i).getQuestion());
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
		return (ArrayList<Question>) qList;
	}
	
	public ArrayList<Question> selectFinishedQuestionListById(String memberId){
		System.out.println("QuestionDAO.selectFinishedQuestionListById");
		SqlSession ss=factory.openSession();
		
		List<Question> qList = null;
		try {
			System.out.println(memberId);
			qList = ss.selectList("question.selectFinishedQuestionListById", memberId);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
		return (ArrayList<Question>) qList;
	}
	
	public void insertQuestion(Question question){
		System.out.println("QuestionDAO.insertQuestion");
		SqlSession ss=factory.openSession();
		
		try {
			ss.insert("question.insertQuestion", question);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
	}
	
	public void insertQuestionList(ArrayList<Question> qList){
		System.out.println("QuestionDAO.insertQuestionList");
		SqlSession ss=factory.openSession();
		
		try {
			for(Question question:qList){
				ss.insert("question.insertQuestion", question);
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
	}
	
	public void updateQuestion(Question question){
		System.out.println("QuestionDAO.updateQuestion");
		SqlSession ss=factory.openSession();
		
		try {
			ss.update("question.updateQuestion", question);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}  finally {
			if (ss != null) ss.close();
		}
	}
	
}
