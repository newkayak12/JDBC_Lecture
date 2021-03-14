package com.employee.controller;

import java.util.List;
import static com.comm.JDBCTemplate.*;

import com.employee.model.service.EmployeeService;
import com.employee.model.vo.Employee;
import com.employee.view.MainView;

public class EmployeeController {
	MainView view ;
	EmployeeService empservice = new EmployeeService();
	
	
	
	
	public void mainView() {
		view = new MainView();
				view.mainView(this);
		
		
	}

	public void searchAll() {
		List<Employee> result = empservice.searchAll();
		view.printAll(result, "searchAll" ,"searchAll");
	}

	public void searching() {
		String[] inner = view.searching();
		List<Employee> result = empservice.searching(inner);
		view.printAll(result, "condition" ,"_ search Conditionally _"+ inner[1]);
	}

	public void regist() {
		Employee employee = view.regist();
		int result = empservice.regist(employee);
		view.printMsg(result, "insert");
		
	}

	public void update() {
		String[] change = view.update();
		int result = empservice.update(change);
		view.printMsg(result, "update");
	}

	public void delete() {
		int id = view.delete();
		int result = empservice.delete(id);
		view.printMsg(result, "delete");
	}

//	public void deptManage() {
//		view.deptManage();
//		
//	}

	public void jobManage() {
		view.jobManage();
	}

}
