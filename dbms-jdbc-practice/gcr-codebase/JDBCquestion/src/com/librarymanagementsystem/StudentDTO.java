package com.librarymanagementsystem;

public class StudentDTO {
	private int studentId;
	private String student_name;
	private String department;
	
	public  StudentDTO(String student_name, String department) {
		this.student_name = student_name;
		this.department = department;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	public String getDepartment() {
		return department;
	}

	public void setStudentId(int id) {
		this.studentId=studentId;
		
	}
	
	
}
