package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.QnaDAO;
import vo.Qna;

public class JsonTestAction extends ActionSupport {

	//JSON용 파라미터로
	private String num;
	private String type;
	private String question;
	private String answer;
	private int totalQna;  
	
	private Qna qnavo = new Qna(); 
	QnaDAO dao=new QnaDAO();
	//////////////////////////////////////
	private static int cnt = 0;
	private static String [] dummyQuestions; 
	//////////////////////////////////////
	public String tableFill() {
		System.out.println("AJAX 답변편집액션 들어옴");

		
		
		num = "1";
		type = "훈련";
		question = "어때?";
		answer = "몰라";

		return SUCCESS;

	}

	public String firstInsertQuestion(){
		System.out.println("=====AJAX 첫질문불러오는 메소드 실행=====");
		cnt++; //FIXME 질문 번호 증가 위해 초기값은 1 이므로 매번 처음부터라는 단점 
		Qna qtable = dao.getQNA(cnt); 
		System.out.println("질문테이블 SELECT 확인 : "+qtable);
		
//		type = qtable.getType(); //질문유형 
//		num = qtable.getNum();//번호 
//		question = qtable.getQuestion(); 
		System.out.println("11111111111111");

		//FIXME dao가 안되길래 더미로 넣어 수현아 
		type = "취미"; 
		num = Integer.toString(cnt);
		
		dummyQuestions = new String[]{"취미가뭐야?","어떤 계기로 하게 되었어?","다른 취미는 뭐가 있어?","취미를 직업으로 삼을 수 있다고 생각해?"};  
		if(cnt > 4){
			System.out.println("질문 array 넘어섰다. 다시 처음질문부터");
			cnt = 1; 
			num = Integer.toString(cnt); 
		}
		question = dummyQuestions[cnt-1]; 
		totalQna = dummyQuestions.length; //FIXME 전체 질문

		System.out.println("22222222222222");
		
	
		System.out.println("333333333");

		System.out.println("===========바퀴 : "+cnt);

		
		return SUCCESS;
		
	} 
	
	public String insertQNA() {
		System.out.println("=====AJAX 질문입력액션 들어옴=====");
		
//		Qna qtable = dao.getQNA(cnt); 
//		System.out.println("질문테이블 SELECT 확인 : "+qtable);
//		type = qtable.getType(); //질문유형 
//		num = qtable.getNum();//번호 
//		question = qtable.getQuestion(); 
		
		//FIXME 답변에 대한 카운팅 잘 안된다.
		if(cnt > 4){
			System.out.println("질문 array 넘어섰다. 다시 처음질문부터");
			cnt = 1; 
			num = Integer.toString(cnt); 
		}

		//ajax로 돌려줄 데이터
		num = Integer.toString(cnt);
		answer = answer; //지우면 안됨 
		question = dummyQuestions[cnt];  
		type = "취미";
		totalQna = dummyQuestions.length;
		
		//클라이언트에서 보낸 정보 객체화해 저장 
		qnavo.setAnswer(answer);
		qnavo.setNum(num);
		System.out.println("완성된 하나의 질답객체 : "+qnavo);
		
		
		cnt++; //FIXME 질문 번호 증가 위해 초기값은 1 이므로 매번 처음부터라는 단점 
		
		
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

	public int getTotalQna() {
		return totalQna;
	}

	public void setTotalQna(int totalQna) {
		this.totalQna = totalQna;
	}

}
