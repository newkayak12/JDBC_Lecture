package com.member.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.member.model.vo.Member;

public class MemberDao {
	List<Member> memList = new ArrayList<>();
	Map<String, String> prop = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	private void proper() {
		File f = new File("/Users/sanghyeonkim/Downloads/JDBC/.ignorefiles/Prop_student_sh.properties");
		if(f.exists()) {
			try( FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);){
				
				prop = (Map<String, String>)ois.readObject();
				
				
			} catch (IOException | ClassNotFoundException e	) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	private Statement query() throws ClassNotFoundException, SQLException{
		
		proper();
			
			
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(prop.get("ip"),prop.get("id"), prop.get("pw"));
		stmt = conn.createStatement();
		
		return stmt;
	}
	
	
	
	//DB접속 정보를 가지고 DB에 접속해서 SQL구문을 실행하는 기능을 하는 클래스
	//SQL 실행결과를 호출한 쪽으로 반환해줌
	public List<Member> selectAll() {  //  반환해야지 > 반환형?
		//DB연결해서 resultset으로 데이터 받아오기
		try {
			
			
			
			
			String query = "Select * from Member";
			rs = query().executeQuery(query);
			
				while(rs.next()){
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
					
					memList.add(new Member(id, pwd, name, gen, age, email, phone, add, hob, enroll));
					
				}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
						if(rs != null & !rs.isClosed()) {
							rs.close();
						}
						if(stmt != null & !stmt.isClosed()) {
							stmt.close();
						}
						if(conn != null & !conn.isClosed()) {
							conn.close();
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
		}
		
		
		
		return memList;
	}

}
