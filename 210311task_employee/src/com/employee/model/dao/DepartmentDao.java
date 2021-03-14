package com.employee.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.comm.JDBCTemplate.*;

import com.employee.model.vo.Department;

public class DepartmentDao {
	List<Department> deptList = new ArrayList<>();
	PreparedStatement pstmt = null;
	String query = "";
	Properties prop = null;
	
	
	public DepartmentDao() {
		prop = new Properties();
			try {
				prop.load(new FileInputStream("/Users/sanghyeonkim/Downloads/JDBC/.ignorefiles/E_sql.properties"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	
	public int deptinsert(Connection conn, Department dept){
		int result = 0;
		
		query = prop.getProperty("DEPREGI")+"?,?,?)";
//		query = "insert into Department Values('Test', 'test', 'test')";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, dept.getDeptId());
				pstmt.setString(2, dept.getDeptTitle());
				pstmt.setString(3, dept.getLocationId());
				
			result = pstmt.executeUpdate();	
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		return result; 
	}

}
