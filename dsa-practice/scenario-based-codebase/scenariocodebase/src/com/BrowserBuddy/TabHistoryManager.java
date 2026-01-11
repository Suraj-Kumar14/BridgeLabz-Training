package com.BrowserBuddy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TabHistoryManager {
	private static List<Tab>openTabs;
	private Stack<Tab>closedTabs;
	
	public TabHistoryManager() {
		openTabs=new ArrayList<>();
		closedTabs=new Stack<>();
	}
	
	//open a tab
	public void openTab() {
		Tab tab=new Tab();
		openTabs.add(tab);
		System.out.println("New tab opened. Tab index: "+(openTabs.size()-1));
	}
	
	//closed a tab and push it to stack
	public void closedTabs(int index) {
		if(index>=0 && index<openTabs.size()) {
			Tab tab=openTabs.remove(index);
			closedTabs.push(tab);
			System.out.println("Tab "+index+" closed and saved to stack.");
					
		}else {
			System.out.println("Invalid tab index!");
		}
	}
	
	//restore recently closed tab
	public void restoreTab() {
		if(!closedTabs.empty()) {
			Tab tab1=closedTabs.pop();
			openTabs.add(tab1);
			System.out.println("Tab restoreed at index: "+(openTabs.size()-1));
			return;
		}
		System.out.println("No closed tabs to restore!");		
	}
	
	public Tab getTab(int index) {
		if(index>=0 && index<openTabs.size()) {
			return openTabs.get(index);
		}
		System.out.println("Invalid tab index.");
		return null;
	}
}
