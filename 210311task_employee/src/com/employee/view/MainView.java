package com.employee.view;

import java.util.List;
import java.util.Scanner;

import com.employee.controller.EmployeeController;
import com.employee.model.vo.Employee;

public class MainView {
	Scanner scn = new Scanner(System.in);
	
	public void mainView(EmployeeController employeeController) {
		while(true) {	
				System.out.println("1. 전체 사원 조회");
				System.out.println("2.   사원 조회"); //1.부서 2.직책 3.이름 4.급여(크고작고)
				System.out.println("3.   사원 등록");
				System.out.println("4.   사원 수정"); // 직책, 부서, 급여, 전화번호, 이메일
				System.out.println("5.   사원 삭제");	
				System.out.println("6.   부서 관리"); // 1. 등록, 수정, 삭제
				System.out.println("7.   직책 관리"); // 1 등록, 부서 수정, 삭제
			
			int choice = scn.nextInt();
			
				switch (choice) {
					case 0:
						System.out.println("종료");
						return;
						
					case 1:
						employeeController.searchAll();
						break;
					case 2:
						employeeController.searching();
						break;
					case 3: 
						employeeController.regist();
						break;
					case 4:
						employeeController.update();
						break;
					case 5: 
						employeeController.delete();
						break;
					case 6:
						employeeController.deptManage();
						break;
					case 7:
						employeeController.jobManage();
						break;
					default:
						
				}
			
			
			
			
			
			
			
		}
		
		
	}

	public void printAll(List<Employee> list) {
		// TODO Auto-generated method stub
		for(Employee e : list) {
			System.out.println(e);
		}
		
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void searching() { //부서 직책 이름 급여로 찾기
		// TODO Auto-generated method stub
		
	}

	public void update() { // 직책 부서 급여 전화번호 이메일
		// TODO Auto-generated method stub
		
	}



	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
