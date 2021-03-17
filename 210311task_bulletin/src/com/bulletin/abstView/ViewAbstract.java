package com.bulletin.abstView;

import java.util.*;

public abstract class  ViewAbstract <T> {
	
	public abstract void mainView(ControllerAbstract cA);
	
	public abstract void printAll(List<T> ref);
	
	public abstract void printMsg(int result, String ref);
}
