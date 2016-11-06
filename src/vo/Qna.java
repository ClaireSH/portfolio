package vo;

public class Qna {
	String questionId;
	String questionType;
	String question;
	String answer; 
	
	public Qna() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Qna [questionId=" + questionId + ", questionType=" + questionType + ", question=" + question
				+ ", answer=" + answer + "]";
	}

    
	
	


	
}
