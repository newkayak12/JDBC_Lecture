package com.employee.controller;

import java.util.List;

import com.employee.model.service.EmployeeService;
import com.employee.model.vo.Employee;
import com.employee.view.MainView;

public class EmployeeController {

	public void mainView() {
		new MainView().mainView(this);
		
	}

	public void searchAll() {
		List<Employee> result = new EmployeeService().searchAll();
		new MainView().printAll(result);
	}

	public void searching() {
		new MainView().searching();
	}

	public void regist() {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		new MainView().update();
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public void deptManage() {
		// TODO Auto-generated method stub
		
	}

	public void jobManage() {
		// TODO Auto-generated method stub
		
	}

}
