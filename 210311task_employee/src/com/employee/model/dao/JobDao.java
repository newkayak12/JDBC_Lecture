package com.employee.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import static com.comm.JDBCTemplate.*;
import com.employee.model.vo.Job;

public class JobDao {
	PreparedStatement pstmt = null;
	Properties prop = null;
	String query = null;
	
	public JobDao() {
		prop = new Properties();
		
			try {
				
					prop.load(new FileInputStream("/Users/sanghyeonkim/Downloads/JDBC/.ignorefiles/E_sql.properties"));
				
			} catch (FileNotFoundException e) {

				e.printStackTrace();
				
			} catch (IOException e) {
				
				
				e.printStackTrace();
			}
		
	}

	public int jobInsert(Connection conn, Job ref) {
		int result = 0;
		query = prop.getProperty("JOBREGI");
		query = query + "?, ?)";
			
			try {
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, ref.getJobCode());
					pstmt.setString(2, ref.getJobName());
					
					result = pstmt.executeUpdate();
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		return result;
	}

	public int jobModi(Connection conn, String[] ref) {
		int result = 0;
		query = prop.getProperty("JOBUPD");
		query = query.replace("#", ref[0]);
		query = query.replace("@", ref[1]);
			
			try {
				
				pstmt = conn.prepareStatement(query);
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		
		return result;
	}

	public int jobDel(Connection conn, String ref) {
		int result = 0;
		query = prop.getProperty("JOBDEL");
		query = query + ref;
		
			try {
				
				
				pstmt = conn.prepareStatement(query);
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {

				e.printStackTrace();
				
				
			}
			
		
		
		return result;
	}

}
