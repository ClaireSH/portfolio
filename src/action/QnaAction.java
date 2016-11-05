package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.QnaDAO;
import dao.QuestionDAO;
import vo.Qna;

public class QnaAction extends ActionSupport implements SessionAware{

	
	Qna qna;
	int qnano;
	List<Qna> qnalist;
	
	QnaDAO dao=new QnaDAO();
	Map<String,Object> session;
	
	public String insertQNA() throws Exception {
		//세션으로부터 로그인한 ID 읽어서 qna객체에 저장
		String loginId = (String) session.get("loginId");
		qna.setId(loginId);		
		dao.insertQNA(qna);
		return SUCCESS;		
	}
	
	public String listQNA() throws Exception {
		QnaDAO dao = new QnaDAO();		
		qnalist = dao.listQNA();		
		System.out.println(qnalist);
		return SUCCESS;
	}
	
	public String readQNA() throws Exception {
		//전달된 글번호로 검색. 해당 번호의 글이 없으면 리턴
		qna = dao.getQNA(qnano);
		return SUCCESS;
	}
	
	public Qna getQna() {
		return qna;
	}
	public void setQna(Qna qna) {
		this.qna = qna;
	}
	public int getQnano() {
		return qnano;
	}
	public void setQnano(int qnano) {
		this.qnano = qnano;
	}
	public List<Qna> getQnalist() {
		return qnalist;
	}
	public void setQnalist(List<Qna> qnalist) {
		this.qnalist = qnalist;
	}
	
	public QnaDAO getDao() {
		return dao;
	}
	public void setDao(QnaDAO dao) {
		this.dao = dao;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}	
}
