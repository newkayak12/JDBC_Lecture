package com.bulletin.controller;

import com.bulletin.abstView.ControllerAbstract;
import com.bulletin.view.BoardView;

public class BoardController extends ControllerAbstract{

	@Override
	public void view(ControllerAbstract con) {
		new BoardView().mainView(con);
	}

	
	@Override
	public void queryAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryConditionId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryConditionTitle() {
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
