package com.member.model.service;

// 굳이 클래스명을 안 쓰게하려면
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static com.common.JDBCTemplate.*;
import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;

public class MemberService {
	
	private MemberDao dao = new MemberDao();
	//db 연결을 위해서 필요한 Connection 객체를 생성하고, Connection을 관리한다.
	//트렌젝션 처리를 한다. (Commit/Rollback)을 한다. 
	public List<Member> queryAll() {
		
		Connection conn = getConnection();
		//여기까지하고 또 다른 곳으로 넘긴다. ㅋㅋ
		
		List<Member> result = dao.queryAll(conn);
		
		//여기서 생성했으니까 관리해줘야지
		close(conn);
		
		
		
		return result;
	}
	public List<Member> queryName(String name) {
		Connection conn = getConnection();
		
		List<Member> result = dao.queryName(conn, name);
		
		close(conn);
		
		return result;
	}
	
	public List<Member> queryDesire(Map<String, String> param) {
		Connection conn = getConnection();
		
		List<Member> result = dao.queryDesire(conn, param);
		
		close(conn);
		
		return result;
		
	}
	public List<Member> queryId(String input) {
		Connection conn = getConnection();
		List<Member>result = dao.queryId(conn, input);
		
		close(conn);
		
		return result;
	}

}
