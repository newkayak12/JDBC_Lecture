package com.emp.controller;

import java.util.List;

import com.emp.model.dao.EmpDao;
import com.emp.model.vo.Emp;
import com.emp.view.EmpView;

public class EmpController {
	EmpView eView = new EmpView();
	EmpDao eDao = new EmpDao();
	
	public void mainView() {
		eView.mainView();
	}

	public List<Emp> searchAll() {
		
		return eDao.searchAll();
	}

	
}
