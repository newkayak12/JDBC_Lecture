package com.bulletin.view;

import java.util.Scanner;

import com.bulletin.abstView.ControllerAbstract;
import com.bulletin.controller.BoardController;
import com.bulletin.controller.MemberController;

public class MainView {
	Scanner scn = new Scanner(System.in);
	
	
	public ControllerAbstract mainTheme() {
		while(true) {
			System.out.println("=================");
			System.out.println(" 1. 회원관리");
			System.out.println(" 2. 게시판 관리");
			System.out.println(" 3. 프로그램 종료");
			System.out.println("=================");
		int choice = scn.nextInt();
		
			switch(choice) {
				case 1:
					
					return new MemberController();
					
				case 2:
					
					return new BoardController();
					
				case 3:
					System.out.println("프로그램을 종료합니다.");
					scn.close();
					return null;
			
			}
			
		}
		
	}
}
