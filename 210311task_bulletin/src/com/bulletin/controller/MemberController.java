package com.bulletin.controller;

import java.util.ArrayList;
import java.util.List;

import com.bulletin.abstView.ControllerAbstract;
import com.bulletin.model.service.MemberService;
import com.bulletin.model.vo.Member;
import com.bulletin.view.MemberView;

public class MemberController extends ControllerAbstract {
	List<Member> mList = new ArrayList<>();
	MemberView view ;
	
	@Override
	public void view(ControllerAbstract con) {
		view = new MemberView();
		view.mainView(con);
	}

	@Override
	public void queryAll() {
		mList = new MemberService().queryAll();
		view.printAll(mList);
	}

	@Override
	public void queryConditionId() { //id
		String ref = view.queryConditionIdView();
		mList = new MemberService().queryConditionId(ref);
		view.printAll(mList);
	}

	@Override
	public void queryConditionTitle() { //name
		String ref = view.queryConditionNameView();
		mList = new MemberService().queryConditionTitle(ref);
		view.printAll(mList);
	}

	@Override
	public void queryInsert() {
		Member ref = view.queryInsertView();
		int result = new MemberService().queryInsert(ref);
		view.printMsg(result, "insert");
	}

	@Override
	public void queryModify() {
		String[] ref = view.queryModify();
		int result = new MemberService().queryModify(ref);
		view.printMsg(result, "modify");
	}

	@Override
	public void queryDelete() {
		String ref = view.queryDelete();
		int result = new MemberService().queryDelete(ref);
		view.printMsg(result, "delete");
	}

	
}
