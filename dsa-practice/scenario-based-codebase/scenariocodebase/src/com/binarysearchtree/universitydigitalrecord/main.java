package com.binarysearchtree.universitydigitalrecord;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		StudentRecord stud=new StudentRecord();
		
		while (true) {
            System.out.println("\n1. Insert Student\n2. Delete Student\n3. Search Student\n4. Display All\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    stud.root = stud.insert(stud.root, name,rollNo);
                    break;

                case 2:
                    System.out.print("Enter Roll No to Delete: ");
                    int delRoll = sc.nextInt();
                    stud.root = stud.delete(stud.root, delRoll);
                    System.out.println("Deleted if existed.");
                    break;

                case 3:
                    System.out.print("Enter Roll No to Search: ");
                    int searchRoll = sc.nextInt();
                    stud.search(stud.root, searchRoll);
                    break;

                case 4:
                    System.out.println("\n---All Students (Sorted by Roll No)---");
                    stud.inorder(stud.root);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
	}

}
