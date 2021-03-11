package com.member.controller;

import java.util.List;

import com.member.model.service.MemberService;
import com.member.model.vo.Member;
import com.member.view.MemberView;

public class MemberController {
	private MemberService service = new MemberService();//트랜젝션 관리
	private MemberView view;
	
	public void mainMenu()	{
		view = new MemberView();
		view.mainMenu(this);
	}
	
	
	public void selectAll()	{
		
		List<Member> list = service.selectAll();
		view.printData(list);
	}


	public void insert() {
		Member temp = new MemberView().insert();
		service.insert(temp);
		
		
	}


	public void selectName() {
		String input = new MemberView().selectName();
		view.printData(service.selectName(input));
	}


	public void selectId() {
		String input = new MemberView().selectId();
		view.printData(service.selectId(input));
		
	}


	public void update() {
		String[] temp = new MemberView().update();
		view.printData(service.update(temp), "수정");
	}


	public void delete() {
		String input = new MemberView().delete();
		view.printData(service.delete(input), "삭제");
	}
	
	
	
	
}
