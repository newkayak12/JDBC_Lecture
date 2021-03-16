package com.bulletin.view;

import java.util.Scanner;

import com.bulletin.abstView.ControllerAbstract;
import com.bulletin.abstView.ViewAbstract;
import com.bulletin.controller.MemberController;

public class MemberView extends ViewAbstract{
	private Scanner scn = new Scanner(System.in);
	
	@Override
	public void mainView(ControllerAbstract cA) {
		MemberController mCon = (MemberController) cA;
				System.out.println("1. 전체회원조회");
				System.out.println("2. 회원 아이디로 조회");
				System.out.println("3. 회원 이름으로 조회");
				System.out.println("4. 회원가입");	
				System.out.println("5. 회원정보수정");
				System.out.println("6. 회원탈퇴");
				System.out.println("0. 메인 메뉴");
			int choice = scn.nextInt();
				
				switch(choice) {
					case 0:
						return;
					case 1:
						mCon.queryAll();
						break;
					case 2:
						mCon.queryConditionId();
						break;
					case 3:
						mCon.queryConditionTitle();
						break;
					case 4:
						mCon.queryInsert();
						break;
					case 5:
						mCon.queryModify();
						break;
					case 6:
						mCon.queryDelete();
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
