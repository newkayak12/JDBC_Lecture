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
	//dao에서 공통적으로 사용하는 
	//connection연결생성, statement 반환, resultSet반환, connection반환, 트랜젝션 처리 메소드
	//공통으로 관리하는 클래스
	//각 메소드는 모두 애플리케이션 안에서 공통으로 사용하기 때문에
	// static으로 관리를 한다.  > 여기서 생성되는 메소드는 static으로 선언한다. 
	
	//connection 생성
	static String ipInput = "";
	static String idInput = "";
	static String pwInput = "";
	
	
	public static Connection getConnection() {
		Properties prop = new Properties();
			try {
				
				prop.load(new FileInputStream("/Users/sanghyeonkim/Downloads/JDBC/.ignorefiles/Prop_student_sh.properties"));
				ipInput = prop.getProperty("ip");
				idInput = prop.getProperty("id");
				pwInput = prop.getProperty("pw");
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		
		Connection conn = null;
			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				conn = DriverManager.getConnection(ipInput,idInput,pwInput);
				
				//트렌젝션 오토커밋
				
				conn.setAutoCommit(false);
				
			} catch (SQLException e	) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
	}
	
	
	
	//객체 반환
	public static void close(Connection conn) {
			try {
				
					if(conn!= null && !conn.isClosed()) {
						conn.close();
					}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
	public static void close(Statement stmt) {
		try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void close(ResultSet rs) {
		try {
			if(rs!= null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void commit(Connection conn) {
		
		try {
				if( conn != null && !conn.isClosed()) {
					conn.close();
				}
		} catch( SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if( conn !=null && conn.isClosed()) {
				conn.close();
			}
		} catch( SQLException e) {
			
		}
	}
	
	
	
	
	
}
