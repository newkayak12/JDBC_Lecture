package com.employee.model.dao;

import static com.comm.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.employee.model.vo.Employee;

public class EmployeeDao {
	
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Properties prop = new Properties();
	String query = "";
	List<Employee> result = new ArrayList<Employee>();
	
	
	
	public EmployeeDao() {
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
	

	public List<Employee> searchAll(Connection conn) {
		query = prop.getProperty("SLCTLL");
		Employee emp = null;
		
			result.clear();
			try {
					pstmt = conn.prepareStatement(query);
					rs = pstmt.executeQuery();
						
					
					
						while(rs.next()) {
							
							
							emp = new Employee();
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



	public List<Employee> searching(Connection conn, String[] inner) {
		
		
		
		
		query = prop.getProperty("SLCTCND");
		query = query.replace("#", inner[0]);
		query = query.replace("@", inner[1]);
		
		
		
		Employee emp = null;
		result.clear();
		
			try {
					pstmt = conn.prepareStatement(query);
					rs = pstmt.executeQuery();
						
					
					
						while(rs.next()) {
							
							
							emp = new Employee();
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


	public int regist(Connection conn, Employee emp) {
		String query = prop.getProperty("REGIST");
		
		query =  query + "?,?,?,?,? ,?,?,?,?,? ,?,null,null,?)";
		int result = 0;
		
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, emp.getEmpId());
				pstmt.setString(2, emp.getEmpName());
				pstmt.setString(3, emp.getEmpNo());
				pstmt.setString(4, emp.getEmail());
				pstmt.setString(5, emp.getPhone());
				pstmt.setString(6, emp.getDeptCode());
				pstmt.setString(7, emp.getJobCode());
				pstmt.setString(8, emp.getSalLevel());
				
				pstmt.setInt(9, emp.getSalary());
				pstmt.setDouble(10, emp.getBonus());
				
				pstmt.setString(11, emp.getManagerId());
				
				pstmt.setString(12, emp.getEntYn());
				
				
				
				result = pstmt.executeUpdate();

			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
		return result;
	}


	public int delete(Connection conn, int id) {
		int resultNum = 0;
		query = prop.getProperty("DEL");
		
			try {
				
				pstmt = conn.prepareStatement(query + id);
				resultNum = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
			
			
		return resultNum;
	}


	public int update(Connection conn, String[] change) {
		int resultNum = 0;
		query = prop.getProperty("UPDT");
		query = query.replace("@", change[0]);
		query = query.replace("#", change[2]);
		query = query.replace("$", change[1]);
//		UPDT = Update employee set @ = # where EMP_ID = $
			try {
				pstmt = conn.prepareStatement(query);
				 resultNum = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			change[0] = "JOB_CODE";
//			
//			System.out.println("아이디 : ");
//		change[1] = scn.next();
//		
//			System.out.println(" 수정 사항 : ");
//		change[2] = "'"+ scn.next() + "'";
			
		
		return resultNum;
	}
}
