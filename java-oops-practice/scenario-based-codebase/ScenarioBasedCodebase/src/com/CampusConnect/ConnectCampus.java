package com.CampusConnect;

import java.util.Scanner;

public class ConnectCampus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------Welcome To Connect Campus-----------");
		System.out.print("\nEnter the name: ");
		String name = sc.nextLine();
		System.out.print("Enter the teacher Id: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the Email: ");
		String email = sc.nextLine();
		Teacher teach = new Teacher(id,name,email);
		do {
			System.out.println("Enter '1' to Add Student: ");
			System.out.println("Enter '2' to Add Course: ");
			System.out.println("Enter '3' to Enroll Student in Course: ");
			System.out.println("Enter '4' to Drop Student from Course: ");
			System.out.println("Enter '5' to See Details: ");
			System.out.println("Enter '6' to Exit: ");
			int n = sc.nextInt();
			if(n==1) {
				System.out.println("Enter student Id: ");
				int i = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Student Name: ");
				String stuname= sc.nextLine();
				System.out.println("Enter Studnet Email: ");
				String stuemail = sc.nextLine();
				teach.addStudent(i, stuname, stuemail);
			}else if(n==2) {
				System.out.println("Enter student id: ");
				int stuid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Course Name:");
				String courseName = sc.nextLine();
				System.out.println("Enter Course Id  :");
				int coursId = sc.nextInt();
				teach.addCourse(stuid, courseName, coursId);
			}else if(n==3) {
				System.out.println("Enter student id :");
				int stuid = sc.nextInt();
				System.out.println("Enter Course Id  :");
				int coursId = sc.nextInt();
				teach.enroll(stuid, coursId);
			}else if(n==4) {
				System.out.println("Enter student id :");
				int stuid = sc.nextInt();
				System.out.println("Enter Course Id  :");
				int coursId = sc.nextInt();
				teach.drop(stuid, coursId);
			}else if(n==5) {
				teach.details();
			}else {
				System.out.println("\nWE TEACH FOR GROWTH");
				break;
			}
		}while(true);
	}
}