package com.exception;

import java.util.Scanner;

public class MultipleCatchBlock {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try {
			System.out.print("Enter the size of array: ");
			int size=sc.nextInt();
			int[] arr=new int[size];
			for(int i=0;i<size;i++) {
				System.out.print("Enter "+(i+1)+" index number: ");
				arr[i]=sc.nextInt();
			}
			System.out.print("Enter index to get element: ");
			int idx=sc.nextInt();			
						
			System.out.println("Value at index "+idx+" is: "+(arr[idx]));
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index!");
		}
		catch(NullPointerException e) {
			System.out.println("Array is not initialized!");
		}finally {
			sc.close();
		}
	}

}
