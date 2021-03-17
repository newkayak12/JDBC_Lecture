package com.bulletin.controller;

import java.util.ArrayList;
import java.util.List;

import com.bulletin.abstView.ControllerAbstract;
import com.bulletin.model.service.BoardService;
import com.bulletin.model.vo.Board;
import com.bulletin.view.BoardView;

public class BoardController extends ControllerAbstract{
	private BoardView view;
	private BoardService bSer = new BoardService();
	private List<Board> bList = new ArrayList<>();
	
	@Override
	public void view(ControllerAbstract con) {
		view = new BoardView();
		view.mainView(con);
	}

	
	@Override
	public void queryAll() {
		bList.clear();
		bList = bSer.queryAll();
		view.printAll(bList);
	}

	@Override
	public void queryConditionId() {
		bList.clear();
		String ref  = view.queryConditionIdView();
		bList = bSer.queryConditionId(ref);
		view.printAll(bList);
	}

	@Override
	public void queryConditionTitle() {
		bList.clear();
		String ref = view.queryConditionTitleView();
		bList = bSer.queryConditionTitle(ref);
		view.printAll(bList);
	}

	@Override
	public void queryInsert() {
		Board ref = view.queryInsertView();
		int result = bSer.queryInsert(ref);
		view.printMsg(result, "insert");
		
	}

	@Override
	public void queryModify() {
		String[] ref = view.queryModify();
		int result = bSer.queryModify(ref);
		view.printMsg(result, "modify");
		
	}

	@Override
	public void queryDelete() {
		String ref = view.queryDelete();
		int result = bSer.queryDelete(ref);
		view.printMsg(result, "delete");
	}
	
////	IDX	NUMBER
////	DIV	VARCHAR2(10 BYTE)
////	TITLE	VARCHAR2(50 BYTE)
////	CONTENTS	VARCHAR2(3000 BYTE)
////	WRITER	NUMBER
////	WRITE_DATE	DATE
//	private int idx;
//	private String div, title, cotents;
//	private int writer;
//	private String writeDate;
//	

}
