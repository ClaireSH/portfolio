package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.Qna;

public class QnaDAO {
	private SqlSessionFactory factory=MybatisConfig.getSqlSessionFactory();
	SqlSession ss=null;
	
	public void insertQNA(Qna qna) {
		try {
			ss = factory.openSession();	
			ss.insert("QnaMapper.insertQna", qna);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}
	
	public List<Qna> listQNA() {
		List<Qna> QNAlist = null;
		
		try {
			ss = factory.openSession();
			QNAlist = ss.selectList("QnaMapper.listQna");
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ss.close();
		}
		return QNAlist;
	}	
	
	/**
	 * 하나의 글 읽기
	 * @param qnano 글번호
	 * @return 해당 게시물의 상세 정보
	 */	
	public Qna getQNA(int qnano) {
		Qna qna = null;
		
		try {
			ss = factory.openSession();
			qna = ss.selectOne("QnaMapper.getQna", qnano);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ss.close();
		}
		return qna;
	}	
}
