package com.bulletin.abstView;

import java.sql.Connection;
import java.util.List;

import com.bulletin.model.vo.Member;

public abstract class DaoAbstract <T> {
	
	public abstract List<T> queryAll(Connection conn);
	
	public abstract List<T> queryConditionId(Connection conn, String ref);
	
	public abstract List<T> queryConditionTitle(Connection conn, String ref);
	
	public abstract int queryInsert(Connection conn, T m);
	
	public abstract int queryModify(Connection conn, String[] ref);
	
	public abstract int queryDelete(Connection conn, String ref);
}
