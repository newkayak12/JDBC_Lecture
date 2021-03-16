package com.employee.view;

import java.util.List;
import java.util.Scanner;

import com.employee.controller.DepartmentController;
import com.employee.controller.EmployeeController;
import com.employee.controller.JobController;
import com.employee.model.vo.Department;
import com.employee.model.vo.Employee;
import com.employee.model.vo.Job;

public class MainView {
	Scanner scn = new Scanner(System.in);
	EmployeeController employeeController = null;
	String [] temp = null;
	
	
	
	public void mainView(EmployeeController employeeController) {
		while(true) {	
				System.out.println("1.   전체 사원 조회");
				System.out.println("2.   사원 조회"); //1.부서 2.직책 3.이름 4.급여(크고작고)
				System.out.println("3.   사원 등록");
				System.out.println("4.   사원 수정"); // 직책, 부서, 급여, 전화번호, 이메일
				System.out.println("5.   사원 삭제");	
				System.out.println("6.   부서 관리"); // 1. 등록, 수정, 삭제
				System.out.println("7.   직책 관리"); // 1 등록, 부서 수정, 삭제
				System.out.println("0.   종    료");
			
			int choice = scn.nextInt();
			
				switch (choice) {
					case 0:
						System.out.println("종료");
						scn.close();
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
						new DepartmentController().mainView();
						
						break;
					case 7:
						new JobController().mainView();
						break;
					default:
						
				}
			
			
			
			
			
			
			
		}
		
		
	}

	public void printAll(List<Employee> list, String type, String msg) {
		// TODO Auto-generated method stub
		
		if(type.equals("searchAll")){
			System.out.println(" ======== "+msg+" ======== ");
			
			for(Employee e : list) {
				System.out.println(e);
			}
				
				
		} else if (type.contains("condition")) {
				
				if(msg.contains(">=")) {
					msg = msg.replace(">=", "");
							
					
				} else if(msg.contains("<=")) {
					
					msg = msg.replace("<=", "");
				}
				
				System.out.println(" ======== "+msg+" ======== ");
				
				for(Employee e : list) {
					System.out.println(e);
				}
				
			
		}
			
			
		
		
	}
	
	public void printMsg(int i, String type) {
		if(type.equals("insert")) {
			
			System.out.println("행 "+i +" 개가 삽입되었습니다._Employee");
			
		} else if(type.equals("delete")) {
			
			System.out.println("행 "+i +" 개가 삭제되었습니다._Employee");
			
		} else if(type.equals("update")) {
			
			System.out.println("행 "+i +" 개가 삭제되었습니다._Employee");
			
		} else if(type.equals("insertDep")) {
			
			System.out.println("행 "+i +" 개가 삽입되었습니다._Department");
			
		} else if(type.equals("deleteDep")) {
			
			System.out.println("행 "+i +" 개가 삭제되었습니다._Department");
			
		} else if(type.equals("updateDep")) {
			
			System.out.println("행 "+i +" 개가 수정되었습니다._Department");
			
		}else if(type.equals("insertJob")) {
			
			System.out.println("행 "+i +" 개가 삽입되었습니다._Job");
			
		} else if(type.equals("deleteJob")) {
			
			System.out.println("행 "+i +" 개가 삭제되었습니다._Job");
			
		} else if(type.equals("updateJob")) {
			
			System.out.println("행 "+i +" 개가 수정되었습니다._Job");
			
		}
		
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String[] searching() { //부서 직책 이름 급여로 찾기
		String[] inner = new String[2];
			System.out.println("1. 부서로 검색");
			System.out.println("2. 직책으로 검색");
			System.out.println("3. 이름으로 검색");
			System.out.println("4. 급여로 검색");
		int choice = scn.nextInt();
		
			switch(choice) {
				case 1:
						System.out.println("부서명 : ");
					inner[0] = "'"+scn.next()+"'";
					inner[1] = "DEPT_CODE = ";
						break;
					
				case 2:
						System.out.println("직책명 : ");
					inner[0] = "'"+scn.next()+"'";
					inner[1] = "Job_CODE = ";
						break;
					
				case 3:
						System.out.println("이름 : ");
					inner[0] = "'"+scn.next()+"'";
					inner[1] = "EMP_NAME = ";
						break;
				case 4:
						System.out.println("급여로 검색 ");
						System.out.println(" 1. 크거나 같다.");
						System.out.println(" 2. 작거나 같다.");
					int input =scn.nextInt();
					
						if(input == 1) {
								System.out.println("급여 : ");
							inner[0] = scn.next(); // parsing?
							inner[1] = "SALARY >= ";
							break;
							
						} else {
							
								System.out.println("급여 : ");
							inner[0] = scn.next(); // parsing?
							inner[1] = "SALARY <= ";
							break;
							
						}
							
			}
			
			return inner;
		
	}

	public String[] update() { // 직책 부서 급여 전화번호 이메일
		String[] change = new String[3];
			System.out.println("수정할 내용을 고르세요");
			System.out.println(" 1. 직책");
			System.out.println(" 2. 부서");
			System.out.println(" 3. 급여");
			System.out.println(" 4. 전화번호");
			System.out.println(" 5. 이메일");
		int choice = scn.nextInt();
			
			switch (choice) {
			
				case 1:
					change[0] = "JOB_CODE";
					
						System.out.println("아이디 : ");
					change[1] = scn.next();
					
						System.out.println(" 수정 사항 : ");
					change[2] = "'"+ scn.next() + "'";
					
						break;
						
				case 2: 
					
					change[0] = "DEPT_CODE";
					
					System.out.println("아이디 : ");
				change[1] = scn.next();
				
					System.out.println(" 수정 사항 : ");
				change[2] = "'"+ scn.next() + "'";
				
						break;
						
				case 3:
					
					change[0] = "SALARY";
					
					System.out.println("아이디 : ");
				change[1] = scn.next();
				
					System.out.println(" 수정 사항 : ");
				change[2] = scn.next();
				
						break;
						
				case 4:
					
					change[0] = "Phone";
					
					System.out.println("아이디 : ");
				change[1] = scn.next();
				
					System.out.println(" 수정 사항 : ");
				change[2] = "'"+ scn.next() + "'";
				
						break;
						
				case 5:
					
					
					change[0] = "Email";
					
					System.out.println("아이디 : ");
				change[1] = scn.next();
				
					System.out.println(" 수정 사항 : ");
				change[2] = "'"+ scn.next() + "'";
					break;
				
			}
			
			return change;
		
	}

	



	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Employee regist() {
		
			System.out.println("사원번호");
		String id = scn.next();
		//1
			
			System.out.println("직원명");
		String name = scn.next();
		//2
		
			System.out.println("주민등록번호");
		String ssn = scn.next();
		//3
		
			System.out.println("emil");
		String email = scn.next();
		//4
		
			System.out.println("전화번호");
		String phone = scn.next();
		//5
		
			System.out.println("부서코드");
		String dept = scn.next();
		//6
		
			System.out.println("직급코드");
		String job = scn.next();
		//7
		
			System.out.println("급여등급");
		String salLevel = scn.next();
		//8
		
			System.out.println("급여");
		int salary = scn.nextInt();
		//9
		
			System.out.println("보너스율");
		double bonus = scn.nextDouble();
		//10
		
			System.out.println("관리자 사번");
		String manager = scn.next();
		//11
		
		
//		//12
//		
//			System.out.println("퇴사일");
//		String tempEnt = scn.next();
//		Date ent = new Date(tempEnt);
//		//13
//		
			System.out.println("재직여부 (Y/N)");
		String yn = scn.next();
		
		Employee employee = new Employee(id, name, ssn, email, phone, dept, job, salLevel, salary, bonus, manager, null, null, yn);
		
		return employee;
	}
	



	public int delete() {
		 
		
			System.out.println("삭제할 사용자의 사번을 입력하세요.");
			
		return scn.nextInt();
	}

	

	

	
	///////////////////////////
	
	public void deptManage() {
		DepartmentController dc = new DepartmentController();
			System.out.println("부서관리");
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("3. 삭제");
		int input = scn.nextInt();
			
			switch(input) {
			
				case 1: 
					dc.deptinsert();
					
					break;
					
				case 2: 
					dc.deptMoid();
					
					break;
					
				case 3: 
					
					dc.deptDel();
					
					break;
			
			}
//		 1. 등록, 수정, 삭제
		
	}
	
	public Department deptinsert() {
			System.out.println("1. 부서코드 입력 : ");
		String id = scn.next();
			System.out.println("2. 부서명 입력 : ");
		String title = scn.next();
			System.out.println("3. 지역코드 입력 : ");
		String location = scn.next();
		
		Department dept = new Department(id, title, location);
		
		return dept;
		
	}

	public String[] deptmoid() {
		temp = new String [3];
			System.out.println(" 수정할 사항을 고르세요 ");
			System.out.println("1. 부서코드");
			System.out.println("2. 부서명");
			System.out.println("3. 지역코드");
		int choice = scn.nextInt();
			
			switch(choice) {
				case 1:
					temp[0] = "Dept_id";
						System.out.println("id를 입력하세요");
					temp[2] = "'"+scn.next()+"'";
						System.out.println(" 수정 사항을 입력하세요 ");
					temp[1] = "'"+scn.next()+"'";
					
					break;
				case 2:
					temp[0] = "Dept_title";
						System.out.println("id를 입력하세요");
					temp[2] = scn.next();
						System.out.println(" 수정 사항을 입력하세요 ");
					temp[1] = scn.next();
					break;
				case 3:
					temp[0] = "location_id";
						System.out.println("id를 입력하세요");
					temp[2] = scn.next();
						System.out.println(" 수정 사항을 입력하세요 ");
					temp[1] = scn.next();
					break;
			
			}
				
		return temp;
	}

	public String deptDel() {
		System.out.println("삭제할 대상의 id를 입력하세요");
		return scn.next();
	}
////////////////////////job
	
	public void jobManage() {
		JobController jc = new JobController();
		System.out.println("직책관리");
		System.out.println("1. 등록");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
	int input = scn.nextInt();
		
		switch(input) {
		
			case 1: 
				jc.jobinsert();
				
				break;
				
			case 2: 
				jc.jobMoid();
				
				break;
				
			case 3: 
				
				jc.jobDel();
				
				break;
		
		}
		
//		 1 등록, 부서 수정, 삭제
	}
	
	
	public Job jobInsert() {
		
			System.out.println("1. 직책명 입력 : ");
		String code = scn.next();
			System.out.println("2. 직책이 입력 : ");
		String name = scn.next();
		
		
		Job job = new Job(code, name);
		
		return job;
		
	}

	public String[] jobMoid() {
		String[] ref = new String [2];
			System.out.println("직책 코드를 입력하세요");
		ref[0] = "'"+scn.next()+"'";
			System.out.println("수정할 직책 명을 입력하세요");
		ref[1] = "'"+scn.next()+"'";
		
		return ref;
	}

	public String jobDel() {
		String ref = null;
			System.out.println("삭제할 직책 코드를 입력하세요");
		ref= "'"+scn.next()+"'";
		
		return ref;
		
	}
}
