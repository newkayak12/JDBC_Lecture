package com.bulletin.controller;

import com.bulletin.abstView.ControllerAbstract;
import com.bulletin.view.MainView;

public class UnifiedController {
	
	
	public void unifiedView() {
		ControllerAbstract con = new MainView().mainTheme();
				if(con instanceof BoardController) {
					BoardController bCon = (BoardController) con;
					con.view(bCon);
				} else if(con instanceof MemberController) {
					MemberController mCon = (MemberController) con;
					con.view(mCon);
				}
		
	}
}
