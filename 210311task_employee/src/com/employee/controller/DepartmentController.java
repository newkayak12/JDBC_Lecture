package com.employee.controller;

import com.employee.model.service.DepartmentService;
import com.employee.model.vo.Department;
import com.employee.view.MainView;

public class DepartmentController {
	MainView view = new MainView();
	DepartmentService dServ = new DepartmentService();
	Department dept = null;
	
	public void mainView() {
		view.deptManage();
		
	}

	

	public void deptinsert() {
		int result =0;
		dept = new MainView().deptinsert();
		result = dServ.deptinsert(dept);
		view.printMsg(result, "insertDep");
	}



	public void deptMoid() {
		int result = 0;
		String[] temp = new MainView().deptmoid();
		result = dServ.deptmoid(temp);
			System.out.println(result+"con");
		
		view.printMsg(result, "updateDep");
		
		
	}
	
	



	public void deptDel() {
		int result = 0;
		String ref = new MainView().deptDel();
		result = dServ.deptDel(ref);
		view.printMsg(result, "deleteDep");
		
	}

}
