package com.examcell;

public class ExamCell {

	public static void main(String[] args) {
		
		RankGenerator rank=new RankGenerator();
		
		rank.addStudentRecord(new Student("kali",97));
		rank.addStudentRecord(new Student("monu",90));
		rank.addStudentRecord(new Student("aalu",89));
		rank.addStudentRecord(new Student("sonu",79));
		rank.addStudentRecord(new Student("polu",91));
		rank.addStudentRecord(new Student("bholu",95));
		rank.addStudentRecord(new Student("sallu",87));
		rank.addStudentRecord(new Student("vasu",96));
		rank.addStudentRecord(new Student("anku",93));
		rank.addStudentRecord(new Student("sattu",99));
		rank.addStudentRecord(new Student("motu",88));
		
		System.out.println();
		rank.showStudent();
		rank.sortStudent();
		rank.showStudent();

	}

}
