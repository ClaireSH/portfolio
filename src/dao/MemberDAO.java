package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import vo.Member;

public class MemberDAO {
	private SqlSessionFactory factory=MybatisConfig.getSqlSessionFactory();

	public MemberDAO(){
		
	}
	
	public void insertMember(Member member){
		System.out.println("memberDAO.insertMember");
		SqlSession ss=factory.openSession();
		try {
			ss.insert("member.insertMember", member);
			ss.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}		finally {
			if (ss != null) ss.close();
		}
	}
	
	public Member selectMember(String id) {
		System.out.println("memberDAO.selectMember");
		SqlSession ss = null;
		Member mem = null;
		try {
			ss = factory.openSession();
			mem = ss.selectOne("member.selectMember", id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}		
		return mem;
	}
	
	public int updateCustomer(Member member) {
		SqlSession ss = null;
		int result = 0;
		
		try {
			ss = factory.openSession();
			result = ss.update("member.selectMember", member);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return result;
	}
}
