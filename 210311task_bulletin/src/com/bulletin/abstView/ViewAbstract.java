package com.bulletin.abstView;

import java.util.List;

import com.bulletin.model.vo.Member;

public abstract class ViewAbstract {
	
	public abstract void mainView(ControllerAbstract cA);
	
	public abstract void printAll(List<Member> ref);
	
	public abstract void printMsg(int result, String ref);
}
