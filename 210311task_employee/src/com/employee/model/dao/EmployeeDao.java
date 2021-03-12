package com.employee.model.dao;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.comm.JDBCTemplate.*;

import com.employee.model.vo.Employee;

public class EmployeeDao {
	
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Properties prop = new Properties();
	String query = "";
	List<Employee> result = new ArrayList<Employee>();
	
	

	public List<Employee> searchAll(Connection conn) {
		query = "select * from employee";
		
		try {
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
					
				
				
					while(rs.next()) {
						
						
						Employee emp = new Employee();
						emp.setEmpId(rs.getString("emp_id"));
						emp.setEmpName(rs.getString("emp_name"));
						emp.setEmpNo(rs.getString("emp_no"));
						emp.setEmail(rs.getString("email"));
						emp.setPhone(rs.getString("Phone"));
						emp.setDeptCode(rs.getString("dept_code"));
						emp.setJobCode(rs.getString("job_code"));
						emp.setSalLevel(rs.getString("sal_level"));
						emp.setSalary(rs.getInt("salary"));
						emp.setBonus(rs.getShort("bonus"));
						emp.setManagerId(rs.getString("manager_id"));
						emp.setHireDate(rs.getDate("hire_date"));
						emp.setEntDate(rs.getDate("ent_date"));
						emp.setEntYn(rs.getString("ent_yn"));
						
						
						
						
					result.add(emp);
						
						
						
						
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

}
