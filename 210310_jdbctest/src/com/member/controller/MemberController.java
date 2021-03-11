package com.member.controller;

import java.util.List;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;
import com.member.view.MemberView;
import com.sun.net.httpserver.Filter;

public class MemberController {
	private MemberView view;
	private MemberDao dao= new MemberDao();
	
	public void mainMenu() {
		
		view = new MemberView();
		view.mainMenu(this);
	}

	public List<Member> selectAll() {
// db student 게정의 member 테이블에 있는 전체 데이터 가져오는 서비스 > 조회를 한다. (select * from ~~)		
// database access object	
		
		return dao.selectAll();
		
		//view에서 받은 데이터 출력하
		
	}

	public void nameSelectAll() {
		
		//1. 검색할 이름 입력받기 > view
		//2. 받은 이름 db에서 조회하기 > dao
		//3. db 조회결과 출력하기 > view
		//4. 
		String view  = new MemberView().nameSelectAll();
		
		for(Member m : dao.nameSelectAll(view)) {
			System.out.println(m);
		}
	}
	
	

	public void idSelectAll() {
//		 1. 검색할 아이디를 입력 받는다. > view에 요청
//		 2.입력받은 값을 받으면 그 값이 db에 있는지 확인한다.
//		 3. dao가 준 결과를 출력한다. > View에 요청
		
		String view = new MemberView().idSelectAll();
		Member temp = dao.idSelectAll(view);
		new MemberView().printData(temp);
	}
		
		
		
		
		
	
	

	public void enroll() {
		
		
		Member mem = null;
		mem = new MemberView().enroll();
				
		dao.enroll(mem);
	}

	public void update() {
		
		
		
		System.out.println(dao.update(new MemberView().update())+"행이 수정되었습니다.");
		
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		dao.delete(new MemberView().delete());
		
		
		
	}
	

}
