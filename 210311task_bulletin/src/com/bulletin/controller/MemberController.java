package com.bulletin.controller;

import com.bulletin.abstView.ControllerAbstract;
import com.bulletin.view.MemberView;

public class MemberController extends ControllerAbstract {

	
	@Override
	public void view(ControllerAbstract con) {
		new MemberView().mainView(con);
	}

	@Override
	public void queryAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryConditionId() { //id
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryConditionTitle() { //name
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryInsert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryModify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryDelete() {
		// TODO Auto-generated method stub
		
	}

	
}
