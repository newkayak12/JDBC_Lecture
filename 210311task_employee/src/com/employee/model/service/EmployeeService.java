package com.employee.model.service;

import static com.comm.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.employee.model.dao.EmployeeDao;
import com.employee.model.vo.Employee;

public class EmployeeService {
	Connection conn = null;
	EmployeeDao empDao = new EmployeeDao();
	
	public List<Employee> searchAll() {
		
		
		conn = getConnection();
		
		List<Employee> result = empDao.searchAll(conn);
		
		close(conn);
		
		
		return result;
	}

	public List<Employee> searching(String[] inner) {
		conn = getConnection();
		
		List<Employee> result = empDao.searching(conn, inner);
		
		close(conn);
		
		return result;
	}

	public int regist(Employee employee) {
		conn = getConnection();
		
		int result = empDao.regist(conn, employee);
			if(result >0) {
				commit(conn);
			}
			
		close(conn);
		return result;
	}

	public int delete(int id) {
		conn = getConnection();
		
		int result = empDao.delete(conn, id);
		commit(conn);
		
		close(conn);
		return result;
	}

	public int update(String[] change) {
		conn = getConnection();
		
		int result = empDao.update(conn, change);
		
		commit(conn);;
		close(conn);
		
		return result;
	}

}
