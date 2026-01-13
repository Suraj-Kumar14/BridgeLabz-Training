package com.TextEditor;

public class Main {

	public static void main(String[] args) {
		TextEditor editor=new TextEditor();
		
		editor.insert("Hi");
		editor.insert(", How");
		editor.insert(" are");
		System.out.println("Show text");
		editor.show();
		//call redo method
		editor.redo();
		System.out.println("Text after redo");
		editor.show();
		//call undo method
		editor.undo();
		System.out.println("Text after undo");
		editor.show();
	}

}
