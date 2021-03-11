package com.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.common.JDBCTemplate;
import com.member.model.vo.Member;

public class MemberDao {
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	List<Member> list = new ArrayList<>();
	String sql = "";
	
	
	
	public List<Member> selectAll(Connection conn){
		
			try {
				String sql = "select * from Member";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				
				while(rs.next()) {
					
					String id = rs.getString("Member_id");
					String pwd = rs.getString("Member_pwd");
					String name = rs.getString("Member_name");
					String gen = rs.getString("gender");
					int age = rs.getInt("Age");
					String email =rs.getString("email");
					String phone = rs.getString("phone");
					String add = rs.getString("address");
					String hob = rs.getString("hobby");
					Date enroll = rs.getDate("enroll_date");
					Member m = new Member(id, pwd, name, gen, age, email, phone, add, hob, enroll);
					list.add(m);
				}
			} catch (SQLException	e) {
				
				
			}finally {
				
				JDBCTemplate.close(rs);
				JDBCTemplate.close(stmt);
				
			}
			
			return list;
		
	}

	public int insert(Connection conn, Member mem) {
//		Statement stmt = null;
		//위치홀더('?') 표시를 이용해서 데이터의 자료형 표시를 대신해줌.
//		 특정 메소드로 (setString,setInt) 해당 위치홀더 값만 대입하면 끝.
		int num = 0;
		try {
			
			
			
			
/*			
//			stmt = conn.createStatement();
 * 
//			preparedstat을 생성ㅎ라 때는 Connection에 prepareStatement()메소드를 이용을 한다.
 * 
//			String query = "insert into Member  values('"+mem.getMemberId()+"','"+
//					mem.getMemberPwd()+"','"+mem.getMemberName()+"','"+
//					mem.getGender()+"','"+mem.getAge()+"','"+mem.getEmil()+"','"+
//					mem.getPhone()+"','"+mem.getAddress()+"','"+mem.getHobby()+"', default )";
 * 
 */
			
			
			
			
			
			
			
			sql = "insert into Member values("/*위치홀더로 표시*/+"?,?,?,?,?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			// select * from memeber where Member_name like ?;
//			String sql = "insert into Member values("/*위치홀더로 표시*/+"?,'rkqt','rqq',?,?,?,?,?,sysdate)";
//			이러면 앞에서부터 1~                          : ?만 모아놓고 
			
			
			
			pstmt .setString(1, mem.getMemberId());
			pstmt .setString(2, mem.getMemberPwd());
			pstmt .setString(3, mem.getMemberName());
			pstmt .setString(4, mem.getGender());
			
			pstmt .setInt(5, mem.getAge());
			
			pstmt .setString(6, mem.getEmil());
			pstmt .setString(7, mem.getPhone());
			pstmt .setString(8, mem.getAddress());
			pstmt .setString(9, mem.getHobby());
			
			
			//pstmt 에서 쿼리문을 실행할 떄는 executeQuery()/ executeUpdate() > 매개변수가 없다.
			
			
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(pstmt);
			
		}
		
		return num;
	}

	public List<Member> selectName(Connection conn, String input) {
		try {
			sql = "SELECT * from MEMBER WHERE MEMBER_NAME like '%"+input+"%'";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			list.clear();
			
			
				while(rs.next()) {
					
					String id = rs.getString("Member_id");
					String pwd = rs.getString("Member_pwd");
					String name = rs.getString("Member_name");
					String gen = rs.getString("gender");
					int age = rs.getInt("Age");
					String email =rs.getString("email");
					String phone = rs.getString("phone");
					String add = rs.getString("address");
					String hob = rs.getString("hobby");
					Date enroll = rs.getDate("enroll_date");
					Member m = new Member(id, pwd, name, gen, age, email, phone, add, hob, enroll);
					list.add(m);
					
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public List<Member> selectId(Connection conn, String input) {
		try {
			sql = "SELECT * from MEMBER WHERE MEMBER_ID = '"+input+"'";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			list.clear();
			
			
				while(rs.next()) {
					
					String id = rs.getString("Member_id");
					String pwd = rs.getString("Member_pwd");
					String name = rs.getString("Member_name");
					String gen = rs.getString("gender");
					int age = rs.getInt("Age");
					String email =rs.getString("email");
					String phone = rs.getString("phone");
					String add = rs.getString("address");
					String hob = rs.getString("hobby");
					Date enroll = rs.getDate("enroll_date");
					Member m = new Member(id, pwd, name, gen, age, email, phone, add, hob, enroll);
					list.add(m);
					
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally	{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int update(Connection conn, String[] temp) {
//		checkId, pointer, modification 
		int result = 0;
		sql = "update Member set" + temp[1] + " = '" +temp[2] +"' where Member id = '"+temp[0]+"'";
			
			try {
					stmt = conn.createStatement();
					result = stmt.executeUpdate(sql);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(pstmt);
				}
			
			return result;
	}

	public int delete(Connection conn, String input) {
		int result = 0;
		try {
			
			sql = "DELETE MEMBER Where Member_id= '"+input+"'";
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(stmt);
		}
		return result;
	}

	
}
