package com.bulletin.abstView;

import java.sql.Connection;
import java.util.List;

import com.bulletin.model.vo.Member;

public abstract class DaoAbstract {
	
	public abstract List<Member> queryAll(Connection conn);
	
	public abstract List<Member> queryConditionId(Connection conn, String ref);
	
	public abstract List<Member> queryConditionTitle(Connection conn, String ref);
	
	public abstract int queryInsert(Connection conn, Member m);
	
	public abstract int queryModify(Connection conn, String[] ref);
	
	public abstract int queryDelete(Connection conn, String ref);
}
