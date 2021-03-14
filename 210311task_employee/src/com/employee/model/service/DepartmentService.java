package com.employee.model.service;

import static com.comm.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.employee.model.dao.DepartmentDao;
import com.employee.model.vo.Department;

public class DepartmentService {
	Connection conn = null;
	List<Department> deptList = new ArrayList<>();
	DepartmentDao dDao = new DepartmentDao();
			

	public int deptinsert(Department dept) {
		int result = 0;
		conn = getConnection();
		
		result = dDao.deptinsert(conn, dept);
		
		commit(conn);
		
		close(conn);
		
		return result;
		
	}

}
