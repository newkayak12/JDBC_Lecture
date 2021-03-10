
package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kh {
 public static void main(String[] args) {
	 
 	Connection conn =null;
	Statement stmt = null;
	ResultSet rs =null;
	 
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@rclass.iptime.org:8877:xe", 
					"sanghyun", "oracle");
			
			stmt = conn.createStatement();
			
			String sql = "select * from department";
			rs = stmt.executeQuery(sql);
			
				while(rs.next()){
					System.out.println(rs.getString("DEPT_ID")+"  "+rs.getString("DEPT_TITLE")+"  "+rs.getString("LOCATION_ID"));
				}
			
			
			
		} catch (SQLException |ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
}
