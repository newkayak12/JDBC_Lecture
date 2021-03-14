package com.comm;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	static String driver = "";
	static String ip = "";
	static String id = "";
	static String pw = "";
	
	
	
	
	
		
		public static Connection getConnection() {
			Properties prop = new Properties();
			Connection conn = null; 
			
			
			try {
					prop.load(new FileInputStream("/Users/sanghyeonkim/Downloads/JDBC/.ignorefiles/Prop_db.properties"));
					driver = prop.getProperty("driver");
					ip = prop.getProperty("ip");
					id = prop.getProperty("id");
					pw = prop.getProperty("pw");
					
				Class.forName(driver);
				conn = DriverManager.getConnection(ip, id, pw);
				
				conn.setAutoCommit(false);
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException s ) {
				s.printStackTrace();
			} catch (ClassNotFoundException c ) {
				c.printStackTrace();
			}
	
			return conn;
		}
		
		public static void close(Connection conn) {
				try {
						
						if(conn != null && !conn.isClosed()) {
							
						conn.close();
						
						}
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
		public static void close(Statement stmt)	{
			try {
				if(stmt != null && !stmt.isClosed()) {
					
					stmt.close();
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
		
		public static void close(ResultSet rs ) {
			try {
				if(rs != null && ! rs.isClosed()) {
					rs.close(); 
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		public static void commit(Connection conn) {
			try {
				
				
					if(conn != null && !conn.isClosed()	) {
						conn.commit();
					}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void rollback(Connection conn) {
			try {
				
				if(conn != null && !conn.isClosed()) {
					conn.rollback();
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
}
