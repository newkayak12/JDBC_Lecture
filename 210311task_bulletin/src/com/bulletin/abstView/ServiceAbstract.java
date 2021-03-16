package com.bulletin.abstView;

import java.util.List;

import com.bulletin.model.vo.Member;

public abstract class ServiceAbstract {
	
	public abstract List<Member> queryAll();
	
	public abstract List<Member> queryConditionId(String ref);
	
	public abstract List<Member> queryConditionTitle(String ref);
	
	public abstract int queryInsert(Member ref);
	
	public abstract int queryModify(String[] ref);
	
	public abstract int queryDelete(String ref);
	
}
