package com.member.view;

import java.util.Date;
import java.util.Scanner;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

public class MemberView {
	private MemberController controller;
	private Scanner scn = new Scanner(System.in);
	// 사용자에게 보여질 화면을 구성한다. 
	// 화면(콘솔 혹은 HTML/CSS/JAVASCRIPT/JQUERY)에 출력되는 메소드(기능)을 가지고 있음.
	// view 클래스는 기능을 수행할 때 controller를 호출하게 된다.	
	public void mainMenu(MemberController mc)	{
		controller = mc;
			System.out.println("======== 회원 관리 프로그램 v1 =======");
			while(true) {
				
				
					System.out.println("  1. 전체 회원 조회하기");
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
							controller.nameSelectAll();
							break;
						case 3:
							controller.idSelectAll();
							break;
						case 4:
							controller.enroll();
							break;
						case 5: 
							controller.update();
							break;
						case 6: 
							controller.delete();
							break;
						case 0: 
							System.out.println("종료되었습니다.");
							return;
						default :
							
					
					}
						
			}
		
		
	}
	
	

	public void printData( Member temp)	{
		
			
			System.out.println(" ====== 조회한 회원 정보 ======");
			
			if(temp != null) {
				System.out.println(temp);
			} else {
				System.out.println("그런사람 없습니다.");
			}
			
			System.out.println(" ==========================");
	}
	
	
		
		
	
	public void selectAll() {
		for( Member b : controller.selectAll()) {
			System.out.println(b);
		}
	}
	
	
	public String nameSelectAll() {
			System.out.println("검색할 이름을 입력해주세요");
		return scn.next();
		
//		printData(input, temp);
		
			
	}

	public String idSelectAll() {
		System.out.println("검색할 아이디를 입력해주세요");
		return scn.next();
	}
		
		public Member enroll() {
			System.out.println("id를 입력하세요");
		String id = scn.next();
		
			System.out.println("PW를 입력하세요");
		String pwd = scn.next();
			
			System.out.println("이름을 입력하세요");
		String name = scn.next();
		
			System.out.println("성별을 입력하세요 (M/F)");
		String gen = scn.next();
		
			System.out.println("나이를 입력하세요");
		int age = scn.nextInt();
		
			System.out.println("Email를 입력하세요");
		String email = scn.next();
		
			System.out.println("전화번호를 입력하세요");
		String phone = scn.next();
		
			System.out.println("주소를 입력하세요");
		String add = scn.next();
		
			System.out.println("취미를 입력하세요");
		String hob = scn.next();
			
		Date enroll = new Date();
		
		Member inputMember = new Member(id, pwd, name, gen, age, email, phone, add, hob, enroll);
		return inputMember;
		
	}



		public String update() {
			String result = "";
				System.out.println(" 수정할 항목을 입력하세요");
				System.out.println(" 1. 비밀번호");
				System.out.println(" 2. eMail");
				System.out.println(" 3. 전화번호");
				System.out.println(" 4. 주   소");
				System.out.println(" 0. 뒤로 가기 ");
			int input = scn.nextInt();
			
				switch(input) {
					case 0:
						return "";
					case 1:
							System.out.println(" id를 입력하세요 ");
						String idPwd = scn.next();	
							System.out.println(" 수정할 비밀번호를 입력하세요");
						String pwd = scn.next();
						
						result =  "Update member set Member_Pwd = '" +pwd+"' where Member_id = '"+idPwd+"'";
							
						
							break;
					
					case 2:
						
							System.out.println(" id를 입력하세요 ");
						String idEmail = scn.next();	
							System.out.println(" 수정할 이메일을 입력하세요");
						String email = scn.next();
						
						result =  "Update member set Email = '" +email+"' where Member_id = '"+idEmail+"'";
							
							break;
						
					case 3: 
						
							System.out.println(" id를 입력하세요 ");
						String idPhone = scn.next();	
							System.out.println(" 수정할 전화번호를 입력하세요");
						String phone = scn.next();
						
						result =  "Update member set phone = '" +phone+"' where Member_id = '"+idPhone+"'";
							
							break; 

						
					case 4:
							System.out.println(" id를 입력하세요 ");
						String idAddress = scn.next();	
							System.out.println(" 수정할 주소를 입력하세요");
						String address = scn.next();
						
						result =  "Update member set Hobby = '" +address+"' where Member_id = '"+idAddress+"'";
						
							break;
				}
				
				return result;
				
		}



		public String delete() {
				System.out.println("삭제할 데이터의 id를 입력하세요");
			String id = scn.next();
			
			return id;
		}
}
