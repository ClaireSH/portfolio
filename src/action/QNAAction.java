package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import dao.QNADAO;
import vo.QNA;

public class QNAAction extends ActionSupport{
	QNA qna;
	int qnano;
	List<QNA> qnalist;
	
	QNADAO dao=new QNADAO();
	Map<String,Object> session;
	
	public String insertQNA() throws Exception {
		//세션으로부터 로그인한 ID 읽어서 qna객체에 저장
		String loginId = (String) session.get("loginId");
		qna.setId(loginId);		
		dao.insertQNA(qna);
		return SUCCESS;
	}
	
	public String listQNA() throws Exception {
		QNADAO dao = new QNADAO();
		
		qnalist = dao.listQNA();
		
		System.out.println(qnalist);
		return SUCCESS;
	}
	
	public String readQNA() throws Exception {
		//전달된 글번호로 검색. 해당 번호의 글이 없으면 리턴
		qna = dao.getQNA(qnano);
		if (qna == null) return INPUT;
		return SUCCESS;
	}
	
	public QNA getQna() {
		return qna;
	}
	public void setQna(QNA qna) {
		this.qna = qna;
	}
	public int getQnano() {
		return qnano;
	}
	public void setQnano(int qnano) {
		this.qnano = qnano;
	}
	public List<QNA> getQnalist() {
		return qnalist;
	}
	public void setQnalist(List<QNA> qnalist) {
		this.qnalist = qnalist;
	}
	
	public QNADAO getDao() {
		return dao;
	}
	public void setDao(QNADAO dao) {
		this.dao = dao;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	
}
