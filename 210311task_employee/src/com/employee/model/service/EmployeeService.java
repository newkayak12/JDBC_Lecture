package com.employee.model.service;

import java.sql.Connection;
import java.util.List;
import static com.comm.JDBCTemplate.*;

import com.employee.model.dao.EmployeeDao;
import com.employee.model.vo.Employee;

public class EmployeeService {

	public List<Employee> searchAll() {
		Connection conn = null;
		
		conn = getConnection();
		
		List<Employee> result = new EmployeeDao().searchAll(conn);
		
		close(conn);
		
		
		return result;
	}

}
