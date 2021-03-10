package com.member.view;

import java.util.Scanner;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

public class MemberView {
	private MemberController controller = new MemberController();
	private Scanner scn = new Scanner(System.in);
	// 사용자에게 보여질 화면을 구성한다. 
	// 화면(콘솔 혹은 HTML/CSS/JAVASCRIPT/JQUERY)에 출력되는 메소드(기능)을 가지고 있음.
	// view 클래스는 기능을 수행할 때 controller를 호출하게 된다.	
	public void mainMenu()	{
			System.out.println("======== 회원 관리 프로그램 v1 =======");
			while(true) {
				
				
					System.out.println( " 1. 전체 회원 조회하기");
					System.out.println("  2. 이름으로 조회하기 ");
					System.out.println("  3. 아이디로 조회하기");
					System.out.println("  4. 회원 등록");
					System.out.println("  5. 회원정보 수정");
					System.out.println("  6. 회원 삭제하기 ");
					System.out.println("  0. 프로그램 종료");
					System.out.print(" > ");
					
				int cho = scn.nextInt();
					
					switch (cho) {
						case 1:
//							controller.selectAll();
							selectAll();
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						case 5: 
							break;
						case 6: 
							break;
						case 0: 
							return;
						default :
							
					
					}
						
			}
		
		
	}
	public void selectAll() {
		for( Member b : controller.selectAll()) {
			System.out.println(b);
		}
	}
	
}
