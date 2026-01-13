package com.TextEditor;

import java.util.Stack;

public class TextEditor{
	String text;
	
	private Stack<String>data=new Stack<>();
	private Stack<String> recoveryData = new Stack<>();
	
	public void insert(String text) {
		data.push(text);
		System.out.println("text added.");
		recoveryData.clear();
	}
	
	public void delete() {
		if(!data.isEmpty()) {
			recoveryData.push(data.pop());			
			return;
		}
		System.out.println("\nEmpty Text editor!");
	}
	
	public void undo() {
		if(!recoveryData.isEmpty()) {
			data.push(recoveryData.pop());
			return;
		} 
		System.out.println("\nNo text available to undo!");
	}
	
	public void redo() {
		if(!data.isEmpty()) {
			recoveryData.push(data.pop());
			return;
		}
		System.out.println("\nNo text to redo");
	}
	
	public void show() {
		for(String s:data) {
			System.out.print(s+" ");
		}
		System.out.println();
	}
}