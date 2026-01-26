package com.reflectionandannotations.annotations.suppresswarnings;

import java.util.ArrayList;
import java.util.List;

public class SuppressWarning {

	
	static List list=new ArrayList<>();
	public static void show() {
		System.out.println(list);
	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public static void main(String[] args) {
		list.add(10);
		list.add(20);
		list.add("hi");
		
		SuppressWarning w=new SuppressWarning();
		w.show();
	}

}
