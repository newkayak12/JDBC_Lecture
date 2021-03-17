package com.bulletin.model.service;

import static com.comm.JDBCTEMPLATE.close;
import static com.comm.JDBCTEMPLATE.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.bulletin.abstView.ServiceAbstract;
import com.bulletin.model.dao.MemberDao;
import com.bulletin.model.vo.Member;

public class MemberService extends ServiceAbstract <Member>{
	Connection conn = null;
	MemberDao mDao = new MemberDao();
	List<Member> mList = new ArrayList<>();
	
	@Override
	public List<Member> queryAll() {
		mList.clear();
		conn = getConnection();
		mList = mDao.queryAll(conn);
		close(conn);
		
		return mList;
		
	}

	@Override
	public List<Member> queryConditionId(String ref) {
		mList.clear();
		conn = getConnection();
		mList = mDao.queryConditionId(conn, ref);
		close(conn);
		
		
		return mList;
		
	}

	@Override
	public List<Member> queryConditionTitle(String ref) {
		mList.clear();
		conn = getConnection();
		mList = mDao.queryConditionTitle(conn, ref);
		close(conn);
		
		
		return mList;
	}

	@Override
	public int queryInsert(Member ref) {
		int result = 0;
		conn = getConnection();
		result = mDao.queryInsert(conn, ref);
		close(conn);
		
		return result;
	}

	@Override
	public int queryModify(String[] ref) {
		
		int result = 0;
		conn = getConnection();
		result = mDao.queryModify(conn, ref);
		
		return result;
	}

	@Override
	public int queryDelete(String ref) {
		
		int result = 0;
		conn = getConnection();
		result = mDao.queryDelete(conn, ref);
		
		
		return result;
	}

}
