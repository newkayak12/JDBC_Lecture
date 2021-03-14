package com.employee.controller;

import com.employee.model.service.DepartmentService;
import com.employee.model.vo.Department;
import com.employee.view.MainView;

public class DepartmentController {
	MainView view;
	DepartmentService dServ = new DepartmentService();
	Department dept = null;
	public void MainView() {
		view = new MainView();
		view.deptManage();
		
	}

	

	public void deptinsert() {
		int result =0;
		dept = new MainView().deptinsert();
		System.out.println(dept + "con");
		result = dServ.deptinsert(dept);
	}



	public void deptMoid() {
		System.out.println("modi");
		
	}



	public void deptDel() {
		System.out.println("del");
		
	}

}
