package com.member.controller;

import java.util.List;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;
import com.member.view.MemberView;

public class MemberController {
	private MemberView view;
	private MemberDao dao= new MemberDao();
	
	public void mainMenu() {
		view = new MemberView();
		view.mainMenu();
	}

	public List<Member> selectAll() {
// db student 게정의 member 테이블에 있는 전체 데이터 가져오는 서비스 > 조회를 한다. (select * from ~~)		
// database access object	
		
		return dao.selectAll();
		
		//view에서 받은 데이터 출력하
		
	}
	

}
