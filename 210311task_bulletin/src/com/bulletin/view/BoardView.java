package com.bulletin.view;

import java.util.Scanner;

import com.bulletin.abstView.ControllerAbstract;
import com.bulletin.abstView.ViewAbstract;
import com.bulletin.controller.BoardController;

public class BoardView  extends ViewAbstract{
	Scanner scn = new Scanner(System.in);
	@Override
	public void mainView(ControllerAbstract cA) {
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

	@Override
	public void printAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printMsg() {
		// TODO Auto-generated method stub
		
	}

	

}
