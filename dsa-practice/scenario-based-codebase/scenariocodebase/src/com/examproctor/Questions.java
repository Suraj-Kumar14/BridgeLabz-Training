package com.examproctor;

public class Questions {
	int quesId;
	String question;
	
	
	public Questions(int quesId, String question) {
		this.quesId = quesId;
		this.question = question;
	}


	public int getQuesId() {
		return quesId;
	}


	public String getQuestion() {
		return question;
	}
	
	@Override
	public String toString() {
		return "Question: "+quesId+"\n"+question;
	}
}
