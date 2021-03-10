package com.run;

import com.member.controller.MemberController;

public class Main {

	public static void main(String[] args) {
// 	애플리케이션을 실행하는 메소드
		//view > controller >model순으로 만듭니다.
		new MemberController().mainMenu();
		
	}

}
