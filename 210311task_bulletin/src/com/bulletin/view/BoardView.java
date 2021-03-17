package com.bulletin.view;

import java.util.*;

import com.bulletin.abstView.*;
import com.bulletin.controller.*;
import com.bulletin.model.vo.*;

public class BoardView   extends ViewAbstract <Board>{
	Scanner scn = new Scanner(System.in);
	
	
	@Override
	public void mainView(ControllerAbstract cA) {
		while(true) {
			BoardController bCon = (BoardController) cA;	
					System.out.println("1. 게시판 전체 검색");
					System.out.println("2. 게시물 등록");
					System.out.println("3. 작성자로 검색");
					System.out.println("4. 제목으로 검색");
					System.out.println("5. 게시물 수정"); // 제목/ 내용
					System.out.println("6. 게시물 삭제");
					System.out.println("0. 메인 메뉴로 ");
				int choice = scn.nextInt();
				
					switch(choice) {
						case 0:	
							new MainView().mainTheme();
							return;
						case 1:
							bCon.queryAll();
							break;
						case 2:
							bCon.queryInsert();
							break;
						case 3:
							bCon.queryConditionId();
							break;
						case 4:
							bCon.queryConditionTitle();
							break;
						case 5:
							bCon.queryModify();
							break;
						case 6:
							bCon.queryDelete();
							break;
					}
		}
	}
	
	
	
	
	
	@Override
	public void printMsg(int result, String ref) {
	 if(ref.equals("insert")) {
		System.out.println(result + "행을 삽입에 성공했습니다.");
		
	} else if(ref.equals("modify")) {
		System.out.println(result + "행을 수정에 성공했습니다.");
		
	} else if(ref.equals("delete")) {
		System.out.println(result + "행을 삭제에 성공했습니다.");
		
	}
		
	}





	@Override
	public void printAll(List<Board> ref) {
		for(Board b : ref) {
			System.out.println(b);
		}
	}

	
	////////////////////////////////////////////////////////////////////////////////
	

	public String queryConditionIdView() {
		System.out.println("검색할 아이디를 입력하세요");
		return scn.next();
	}

	public String queryConditionTitleView() {
		System.out.println("검색할 게시글 명을 입력하세요");
		return scn.next();
	}
	
//	private int idx;
//	private String div, title, cotents;
//	private int writer;
//	private String writeDate;
	
	public Board queryInsertView() {
			System.out.println("div : (일반/공지/비밀)");
		String div  = scn.next();
			System.out.println("title : ");
		String title = scn.next();
			System.out.println("contents : ");
		String contents = scn.next();
			System.out.println("writer : ");
		int writer = scn.nextInt();
		Date now = new Date();
		String writeDate = now.toString();
		
		
		Board ref = new Board(0, div, title, contents, writer, writeDate);
		
		return ref;
	}

	public String[] queryModify() {
		String[] ref = new String[3];
			System.out.println("1. 제목");
			System.out.println("2. 내용");
		int input = scn.nextInt();
			
				
			switch(input) {
				case 1:
					
					ref[0] = "TITLE";
						System.out.println("게시글 번호를 입력하세요");
					ref[2] = scn.next();
						System.out.println("수정할 제목을 입력하세요");
					ref[1] = "'"+scn.next()+"'";
					
						break;
				case 2:
					
					ref[0] = "Contents";
						System.out.println("게시글 번호를 입력하세");
					ref[2] = scn.next();
						System.out.println("수정할 게시글 내용을 입력하세요");
					ref[1] = "'"+scn.next()+"'";
					
						break;
			}
		
		return ref;
	}

	public String queryDelete() {
		System.out.println("삭제할 게시글 번호를 입력하세요");
		return scn.next();
	}

	

	

}
