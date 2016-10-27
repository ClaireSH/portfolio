package action;

import com.opensymphony.xwork2.ActionSupport;

public class JsonTestAction extends ActionSupport {

	//JSON용 파라미터로
	private String num;
	private String type;
	private String question;
	private String answer;

	//////////////////////////////////////

	//////////////////////////////////////
	public String tableFill() {
		System.out.println("AJAX 답변편집액션 들어옴");

		num = "1";
		type = "훈련";
		question = "어때?";
		answer = "몰라";

		return SUCCESS;

	}

	public String insertQNA() {
		System.out.println("AJAX 질문입력액션 들어옴");
		System.out.println(answer);
		return SUCCESS;
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

}
