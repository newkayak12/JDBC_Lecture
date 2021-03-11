package com.member.model.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.common.JDBCTemplate;
import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;

public class MemberService {
	private MemberDao dao = new MemberDao();
	//Connection객체를 관리하는 기능/ connection객체 반환, 트랜젝션 처리를 
		
	
		public List<Member> selectAll()	{
			
			//1.connection 객체 가져오기
			Connection conn = JDBCTemplate.getConnection();
			//가져온 connection을 dao에 전달.
			
			List<Member> list = dao.selectAll(conn);
			
			JDBCTemplate.close(conn);
			
			
			
			return list;
			
		}//규모가 커질수록 이렇게 잘게 나누면 편해진다.

		public int insert(Member temp) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int num = dao.insert(conn,temp);
			
			if(num != 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			
			
			
			return num;
			
			
			
			
			
		}

		public List<Member> selectName(String input) {
			Connection conn = JDBCTemplate.getConnection();
			
			List<Member> result = dao.selectName(conn, input);
			
			JDBCTemplate.close(conn);
			return result;
		}

		public List<Member> selectId(String input) {
			Connection conn = JDBCTemplate.getConnection();
				
			List<Member> result = dao.selectId(conn, input);
			JDBCTemplate.close(conn);
			return result;
		}

		public int update(String[] temp) {
			Connection conn = JDBCTemplate.getConnection();
			int result =  dao.update(conn, temp);
			
			JDBCTemplate.close(conn);
			
			return result;
		}

		public int delete(String input) {
			Connection conn = JDBCTemplate.getConnection();
			int result = dao.delete(conn, input);
			
			JDBCTemplate.commit(conn);
			return result;
		}
		
		
		
		

}
