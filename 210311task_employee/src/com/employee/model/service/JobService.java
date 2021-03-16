package com.employee.model.service;

import static com.comm.JDBCTemplate.close;
import static com.comm.JDBCTemplate.commit;
import static com.comm.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.employee.model.dao.JobDao;
import com.employee.model.vo.Job;

public class JobService {
	private Connection conn = null;
	private JobDao  jdao = new JobDao();
	
	
	public int jobInsert(Job ref) {
		conn = getConnection();
		
		int result = jdao.jobInsert(conn, ref);
				
		commit(conn);
		close(conn);
		
		return result;
	}

	public int jobModi(String[] ref) {
		conn = getConnection();
		int result = jdao.jobModi(conn, ref);
		
				
		commit(conn);
		close(conn);
		
		return result;
	}

	public int jobDel(String ref) {
		conn = getConnection();
		int result = jdao.jobDel(conn, ref);
		
				
		commit(conn);
		close(conn);
		
		return result;
	}

}
