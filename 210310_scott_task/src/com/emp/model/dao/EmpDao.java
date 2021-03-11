package com.emp.model.dao;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.emp.model.vo.Emp;

public class EmpDao {
	
	Map<String, String> property = new HashMap<>();
	List<Emp> empList = new ArrayList<>();
	
	Properties pro = new Properties();
	Connection con = null;
	Statement stat = null;
	ResultSet rs = null;
	
	
	
	private void prop()	{
		
		File f = new File("/Users/sanghyeonkim/Downloads/JDBC/.ignorefiles/Prop_scot.properties");
		
			try(FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);){
				property = (Map<String,String>) ois.readObject();
				
			} catch (IOException | ClassNotFoundException  e	) {
				
			}
		
		
	}
	
	private Statement Driv() {
		
		
		prop();
		
			try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection(property.get("ip"), property.get("id"), property.get("pw"));
					stat = con.createStatement();
					
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			
			
		
			return stat;
	}
	
	
	public List<Emp> searchAll() {
		String query = "SELECT * FROM EMP";
		try {
			rs = Driv().executeQuery(query);
			
			
				while(rs.next()) {
					
					int no = rs.getInt("empno");
					String name = rs.getString("ename");
					String job = rs.getString("Job");
					int manage = rs.getInt("MGR");
					Date hire = rs.getDate("hiredate");
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptNo = rs.getInt("DeptNo");
					
					empList.add(new Emp(no, name, job, manage, hire, sal, comm, deptNo));
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null && !rs.isClosed()) {
					rs.close();
				}
				if(stat!=null && !stat.isClosed()) {
					stat.close();
				}
				if(con!=null & !con.isClosed()) {
					con.close();
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return empList;
		
	}
	
	
	
}
