package com.bulletin.model.service;

import static com.comm.JDBCTEMPLATE.getConnection;

import java.sql.Connection;
import java.util.List;

import com.bulletin.abstView.ServiceAbstract;
import com.bulletin.model.dao.BoardDao;
import com.bulletin.model.vo.Board;
import com.bulletin.model.vo.Member;
import static com.comm.JDBCTEMPLATE.*;

public class BoardService  extends ServiceAbstract <Board> {
	private BoardDao bDao = new BoardDao();
	private Connection conn = null;
	List<Board> result = null;
	@Override
	public List<Board> queryAll() {
		
		if(result != null) {
			
			result.clear();
		}
		
		conn = getConnection();
		result = bDao.queryAll(conn);
		close(conn);
		
		return result;
	}

	@Override
	public List<Board> queryConditionId(String ref) {
		if(result != null) {
			
			result.clear();
		}
		conn = getConnection();
		result = bDao.queryConditionId(conn, ref);
		close(conn);
		
		return result;
	}

	@Override
	public List<Board> queryConditionTitle(String ref) {
		if(result != null) {
			
			result.clear();
		}
		conn = getConnection();
		result = bDao.queryConditionTitle(conn, ref);
		close(conn);
				
		
		
		return result;
	}

	@Override
	public int queryInsert(Board ref) {
		int result = 0;
		conn = getConnection();
		result = bDao.queryInsert(conn, ref);
		close(conn);
		
		return result;
	}

	@Override
	public int queryModify(String[] ref) {
		int result = 0;
		conn = getConnection();
		result = bDao.queryModify(conn, ref);
		close(conn);
		return result;
	}

	@Override
	public int queryDelete(String ref) {
		int result = 0;
		conn = getConnection();
		result = bDao.queryDelete(conn, ref);
		close(conn);
		
		
		return result;
	}

}
