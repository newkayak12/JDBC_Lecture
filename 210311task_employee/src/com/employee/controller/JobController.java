package com.employee.controller;

import com.employee.model.service.JobService;
import com.employee.model.vo.Job;
import com.employee.view.MainView;

public class JobController {
	MainView view = new MainView();
	JobService jServ = new JobService();

	
	public void mainView() {
		view.jobManage();
	}
	
	
	
	public void jobinsert() {
		Job ref = view.jobInsert();
		int result = jServ.jobInsert(ref);
		view.printMsg(result, "insertJob");
		
	}
	
	
	public void jobMoid() {
		String[] ref = view.jobMoid();
		int result = jServ.jobModi(ref);
		view.printMsg(result, "updateJob");
	}
	public void jobDel() {
		// TODO Auto-generated method stub
		String ref = view.jobDel();
		int result = jServ.jobDel(ref);
		view.printMsg(result, "DeleteJob");
	}
	
	
	
	
}
