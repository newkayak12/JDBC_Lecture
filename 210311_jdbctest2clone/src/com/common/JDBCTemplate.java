package com.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	//Connection객체 생성 공용 메소드
	//DB실행에 필요한 객체를 반환하는 공용 메소드 선언
	//Commit/Rollback을 처리하는 메소드 선언

	
	
	static String ip = "";
	static String id = "";
	static String pw = "";
	static String driver = "";
	
	public static Connection getConnection()	{
		Properties prop = new Properties();
		Connection conn = null;
			
			try {
				
					prop.load(new FileInputStream("/Users/sanghyeonkim/Downloads/JDBC/.ignorefiles/Prop_student_sh.properties"));
					//jdbc:oracle:thin:@주소:포트:SID
					ip = prop.getProperty("ip");
					id = prop.getProperty("id");
					pw = prop.getProperty("pw");
					driver = prop.getProperty("driver");
					
					Class.forName(driver);
					
					conn = DriverManager.getConnection(ip, id, pw);
					conn.setAutoCommit(false);
				
				
			} catch(IOException e) {
				
				e.printStackTrace();
				
			} catch(ClassNotFoundException f){
				
				f.printStackTrace();
				
			} catch(SQLException s) {
				
				s.printStackTrace();
				
			}
			
		
		
		
		
		
		return conn;
	}
	
	
	
	//객체를 반환하는 공용 메소드를 선언한다. 
	//Conncetion
	public static void close(Connection conn) {
		
		try {
			
				if(conn != null && !conn.isClosed()) {
					conn.close();
					
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//Statement
	public static void close(Statement stmt) {
		
		try {
			
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ResultSet
	public static void close(ResultSet rs) {
		
		try {
			
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//트렌젝션 처리
	//커밋
	public static void commit(Connection conn)	{
		try {
			
				if(conn != null && !conn.isClosed()) {
					
					conn.commit();
				}
			
			
		} catch ( SQLException e) {
			e.printStackTrace();
		}
	}
	
	//롤백
	public static void rollback(Connection conn) {
			try {

					if(conn != null && !conn.isClosed()) {
						
						conn.rollback();
					}
					
			} catch ( SQLException e) {
				
				e.printStackTrace();
			}
	}
}
