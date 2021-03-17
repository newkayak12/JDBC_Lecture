package com.bulletin.abstView;

import java.util.List;

import com.bulletin.model.vo.Member;

public abstract class ServiceAbstract <T> {
	
	public abstract List<T> queryAll();
	
	public abstract List<T> queryConditionId(String ref);
	
	public abstract List<T> queryConditionTitle(String ref);
	
	public abstract int queryInsert(T ref);
	
	public abstract int queryModify(String[] ref);
	
	public abstract int queryDelete(String ref);
	
}
