package com.member.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.member.model.vo.Member;

public class MemberDao {
	//전달받은 DB정보를 활용해서 DB에 접속한 후 해당하는 서비스의 데이터를 조회, 조작하는 것

	//sql문을 실행하는 객체 > Statement / PreparedStatement
	PreparedStatement pstmt = null;
	// DB에서 가져온 데이터를 보관할 객체
	ResultSet rs= null;

	
	List<Member> result = new ArrayList<>();
	String sql = "";
	
	
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		try {
			prop.load(new FileReader("resources/sql/member_sql.properties"));
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public List<Member> queryAll(Connection conn) {
		
		
		
		try {
//				 sql =  "SELECT * FROM MEMBER";	
				sql = prop.getProperty("selectAll");
//				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery(sql);
				
				//위의 것들이 기존에 하던 것
				
				
				//preparedStatement  사용  >> sql문과 같이 생성해서 sql문을 메소드로 완성 후 실행하는 객체입니다.
				//위치 홀더 '?'가 없어도 사용 가능
				
				
				pstmt = conn.prepareStatement(sql);
				//위치홀더 '?'가  있는 매개변수로 들어온 쿼리문에 있으면 Set000으로 값을 설정하고
				// 없으면 그냥 실행하면 된다. 
				// 아래는 그냥 실행
				
				rs= pstmt.executeQuery();
				//DB에서 가져오는 row가 1개 이상이면 while
				//최대 1개를 가져오면 if로 처리
				
					while(rs.next()) {
						Member mem = new Member();
						mem.setMemberId(rs.getString("Member_id"));
						mem.setMemberPwd(rs.getString("Member_pwd"));
						mem.setMemberName(rs.getString("MEMBER_NAME"));
						mem.setGender(rs.getString("gender"));
						mem.setAge(rs.getInt("age"));
						mem.setEmail(rs.getString("email"));
						mem.setPhone(rs.getString("phone"));
						mem.setAddress(rs.getString("address"));
						mem.setHobby(rs.getString("Hobby"));
						mem.setEnrollDate(rs.getDate("enroll_date"));
						
						result.add(mem);
						
						
					}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
				
			}
		
		
		
		return result;
	}

	public List<Member> queryName(Connection conn, String name) {
//		sql = "select * from member where member_name like '%?%'";

			try {
				
//				pstmt = conn.prepareStatement("select * from member where MEMBER_NAME like (?)");
//				pstmt.setString(1, "%"+name+"%");
//				
				sql = prop.getProperty("selectName");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+name+"%");
				
				// 두 번째 방법은 (devel에 맞춰서)
//				pstmt = conn.prepareStatement("select * from member where MEMBER_NAME like ('%'||?||'%')");
//				pstmt.setString(1, name);
				
				
				
				
				rs = pstmt.executeQuery();
				
				
				
				result.clear();
				
				
					while(rs.next()) {
						
						Member mem = new Member();
						
						mem.setMemberId(rs.getString("Member_id"));
						mem.setMemberPwd(rs.getString("Member_pwd"));
						mem.setMemberName(rs.getString("MEMBER_NAME"));
						mem.setGender(rs.getString("gender"));
						mem.setAge(rs.getInt("age"));
						mem.setEmail(rs.getString("email"));
						mem.setPhone(rs.getString("phone"));
						mem.setAddress(rs.getString("address"));
						mem.setHobby(rs.getString("Hobby"));
						mem.setEnrollDate(rs.getDate("enroll_date"));
						
						result.add(mem);
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		
		
		
		return result;
	}

	public List<Member> queryDesire(Connection conn, Map<String, String> param) {
		int count =0;
		Set<Map.Entry<String, String>> mapper = param.entrySet();
		
		Iterator it = mapper.iterator();
		String col = "";
		String val = "";
		Map.Entry<String, String> temp = null;
			while(it.hasNext()) {
				
				temp =(Map.Entry<String, String>) it.next();
				
			}
		col = temp.getKey();
		val = temp.getValue();
		
//		sql = "select * from member where "+col+" like ?";
		sql = prop.getProperty("choiceSelect");
		sql= sql.replace("#", col);
		
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+val+"%");
				
				rs = pstmt.executeQuery();
				

				result.clear();
				
				
					while(rs.next()) {
						count++;
						Member mem = new Member();
						
						mem.setMemberId(rs.getString("Member_id"));
						mem.setMemberPwd(rs.getString("Member_pwd"));
						mem.setMemberName(rs.getString("MEMBER_NAME"));
						mem.setGender(rs.getString("gender"));
						mem.setAge(rs.getInt("age"));
						mem.setEmail(rs.getString("email"));
						mem.setPhone(rs.getString("phone"));
						mem.setAddress(rs.getString("address"));
						mem.setHobby(rs.getString("Hobby"));
						mem.setEnrollDate(rs.getDate("enroll_date"));
						
						result.add(mem);
					}
				System.out.println("  "+count+"건의 결과를 찾았습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
				
				
		
		return result;
	}

	public List<Member> queryId(Connection conn, String input) {
		int count =0;
		
		sql = "select * from member where member_id = ?";
		
			try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, input);
					rs = pstmt.executeQuery();
					
					
					result.clear();
					
					
						while(rs.next()) {
							count++;
							
								Member mem = new Member();
								
								mem.setMemberId(rs.getString("Member_id"));
								mem.setMemberPwd(rs.getString("Member_pwd"));
								mem.setMemberName(rs.getString("MEMBER_NAME"));
								mem.setGender(rs.getString("gender"));
								mem.setAge(rs.getInt("age"));
								mem.setEmail(rs.getString("email"));
								mem.setPhone(rs.getString("phone"));
								mem.setAddress(rs.getString("address"));
								mem.setHobby(rs.getString("Hobby"));
								mem.setEnrollDate(rs.getDate("enroll_date"));
								
								result.add(mem);
							}
						
			} catch (SQLException e) {
				
				e.printStackTrace();
				
				
			} finally {
				close(rs);
				close(pstmt);
			}
			
	System.out.println("  "+count+"건의 결과를 찾았습니다.");

		return result;
	}
	
	
	
	
	
	

}
