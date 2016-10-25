package vo;

public class QNA {
	String num;
	String type;
	String question;
	String answer;
	String completeness;
	String id;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getCompleteness() {
		return completeness;
	}
	public void setCompleteness(String completeness) {
		this.completeness = completeness;
	}
	
	public QNA() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "QNA [num=" + num + ", type=" + type + ", question=" + question + ", answer=" + answer
				+ ", completeness=" + completeness + "]";
	}
	public QNA(String num, String type, String question, String answer, String completeness) {
		super();
		this.num = num;
		this.type = type;
		this.question = question;
		this.answer = answer;
		this.completeness = completeness;
	}
	
	
}
