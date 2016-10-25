package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.QNA;

public class QNADAO {
	private SqlSessionFactory factory=MybatisConfig.getSqlSessionFactory();
	SqlSession ss=null;
	
	public void insertQNA(QNA qna) {
		try {
			ss = factory.openSession();	
			ss.insert("QNAMapper.insertQNA", qna);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}
	
	public List<QNA> listQNA() {
		List<QNA> QNAlist = null;
		
		try {
			ss = factory.openSession();
			QNAlist = ss.selectList("QNAMapper.listQNA");
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
	
	public QNA getQNA(int qnano) {
		QNA qna = null;
		
		try {
			ss = factory.openSession();
			qna = ss.selectOne("QNAMapper.getQNA", qnano);
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
