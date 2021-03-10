package com.emp.view;

import java.util.Scanner;

import com.emp.controller.EmpController;
import com.emp.model.vo.Emp;

public class EmpView {
	Scanner scn = new Scanner(System.in);
	EmpController eCont;
	public void mainView()	{
		while(true) {
				System.out.println(" === EMP MANAGEMENT PROGRAM ===");
				System.out.println("     1. SEARCH ALL");
				System.out.println("     0.    EXIT");
			
			int choice = scn.nextInt();
				
				switch (choice){
					
					case 0:
						return;
						
					case 1:
						searchAll();
						break;
					
						default :
							
				}
			
			
		}
	}

	public void searchAll() {
		eCont = new EmpController();
			System.out.println(" ============== result set ============== ");
			
			for( Emp temp : eCont.searchAll()) {
				System.out.println(temp);
			}
			
			System.out.println(" ========================================");
	}
}
