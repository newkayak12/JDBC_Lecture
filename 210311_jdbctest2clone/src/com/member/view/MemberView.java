package com.member.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

public class MemberView {
	Scanner scn = new Scanner(System.in);
	
	//애플리케이션을 사용하는 사용자에게 알맞는 화면을 출력해주는 역할
	//화면별 출력을 하는 기능(메소드)
	
	
	public void mainView(MemberController memCon) { //SingleTone을 이렇게 구현함
		while(true) {
		//메뉴를 출력하고 메뉴를 선택하면 서비스가 구현될 수 있도록 하는 기능
				System.out.println(" ======================== MEMBER V2.1 ======================");
				System.out.println(" = 		    1. View All MEMBERS                    =");
				System.out.println(" = 		    2. View MEMBERS by Name                =");
				System.out.println(" = 		    3. View MEMBERS by ID                  =");
				System.out.println(" = 		    4. Enroll MEMBER                       =");
				System.out.println(" = 		    5. Update MEMBER                       =");
				System.out.println(" = 		    6. Delete MEMBER                       =");
				System.out.println(" = 		    7. View MEMBER as desired              =");
				System.out.println(" = 		    0. Terminate                           =");
				System.out.println(" ===========================================================");
				System.out.print(" >_  Enter Any Number :   ");
			int inputChoice = scn.nextInt();
				
				switch(inputChoice) {
				//서비스를 요청하는 트리거
					case 0:
						
						System.out.println("terminated");
						
							return;
						
					case 1:
						
						memCon.queryAll();
						
							break;
							
					case 2:
						
						memCon.queryName();
						
							break;
					case 3: 
						
						memCon.queryId();
							break;
						
					case 4: 
						break;
					case 5:
						break;
					case 6:
						break;
						
					case 7:
						
						memCon.queryDesire();
						break;
					default :
						System.out.println("invalid input");
				}
		}	
		
	}

	

	public void print(List<Member> memList) {
		
			System.out.println(" =================================================== result =================================================== ");
			
			for( Member m : memList) {
				System.out.print("  ");
				System.out.print(m);
				System.out.println(" ");
			}
			
			System.out.println(" ============================================================================================================= ");
	}



	public String queryName() {
		
		System.out.println("enter name to find");
		return scn.next();
	}



	public Map<String,String> queryDesire() {
		//검색을 원하는 컬럼과 값으로 입력 받기
		Map<String, String> param = new HashMap<>();
		
			System.out.println("Enter the column name and value you want to search for.");
			
			System.out.println("column : ");
		String col = scn.next();
		
			System.out.println("value : ");
		String val = scn.next();
		
		param.put(col, val);
		
		return param;
		
	}



	public String queryId() {
		System.out.println("enter id to find");
		return scn.next();
	}
	
	
}
