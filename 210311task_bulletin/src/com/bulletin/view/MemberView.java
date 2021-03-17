package com.bulletin.view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.bulletin.abstView.ControllerAbstract;
import com.bulletin.abstView.ViewAbstract;
import com.bulletin.controller.MemberController;
import com.bulletin.model.vo.Member;

public class MemberView extends ViewAbstract <Member>{
	private Scanner scn = new Scanner(System.in);
	
	@Override
	public void mainView(ControllerAbstract cA) {
		MemberController mCon = (MemberController) cA;
			while(true) {
					System.out.println("================");
					System.out.println("1. 전체회원조회");
					System.out.println("2. 회원 아이디로 조회");
					System.out.println("3. 회원 이름으로 조회");
					System.out.println("4. 회원가입");	
					System.out.println("5. 회원정보수정");
					System.out.println("6. 회원탈퇴");
					System.out.println("0. 메인 메뉴");
					System.out.println("================");
				int choice = scn.nextInt();
					
					switch(choice) {
						case 0:
							new MainView().mainTheme();
							scn.close();
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
	}

	@Override
	public void printAll(List<Member> ref) {
		for(Member temp : ref) {
			System.out.println(temp);
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
	
	public String queryConditionIdView() {
		System.out.println("검색할 아이디를 입력하세요");
		return scn.next();
	}

	public String queryConditionNameView() {
		System.out.println("검색할 이름을 입력하세요");
		return scn.next();
	}
	
	public Member queryInsertView() {
			System.out.println("id : ");
		String id  = scn.next();
			System.out.println("pwd : ");
		String pwd = scn.next();
			System.out.println("name : ");
		String name = scn.next();
			System.out.println("email : ");
		String email = scn.next();
			System.out.println("address : ");
		String address = scn.next();
			System.out.println("phone : ");
		String phone = scn.next();
		Date now = new Date();
		String enroll = now.toString();
		
		
		Member ref = new Member(0, id, pwd, name, email, address, phone, enroll);
		
		return ref;
	}

	public String[] queryModify() {
		String[] ref = new String[3];
			System.out.println("1. 주소");
			System.out.println("2. 전화번호");
			System.out.println("3. 이메일");
		int input = scn.nextInt();
			
				
			switch(input) {
				case 1:
					
					ref[0] = "ADDRESS";
						System.out.println("id를 입력하세요");
					ref[2] = "'"+scn.next()+"'";
						System.out.println("수정할 주소");
					ref[1] = "'"+scn.next()+"'";
					
						break;
				case 2:
					
					ref[0] = "PHONE";
						System.out.println("id를 입력하세요");
					ref[2] = "'"+scn.next()+"'";
						System.out.println("수정할 전화번호");
					ref[1] = "'"+scn.next()+"'";
					
						break;
				case 3: 
					
					ref[0] = "EMAIL";
						System.out.println("id를 입력하세요");
					ref[2] = "'"+scn.next()+"'";
						System.out.println("수정할 이메일 주소");
					ref[1] = "'"+scn.next()+"'";
					
					break;
			}
		
		return ref;
	}

	public String queryDelete() {
		System.out.println("삭제할 id를 입력하세요");
		return scn.next();
	}
	
}
