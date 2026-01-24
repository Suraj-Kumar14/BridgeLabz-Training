package com.exception;

import java.util.Scanner;

public class NestedTryCatchBlock {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);		
		System.out.print("Enter size of array: ");
		int size=sc.nextInt();
		int[] arr=new int[size];
		
		for(int i=0;i<size;i++) {
			System.out.print("Enter "+(i+1)+" index element: ");
			arr[i]=sc.nextInt();
		}
		System.out.print("Enter divisor: ");
		int divisor=sc.nextInt();
		try {
			System.out.print("Enter index: ");
			int idx=sc.nextInt();
			try {
				double result=arr[idx]/divisor;
				System.out.println("Result: "+result);
			}catch(ArithmeticException e) {
				System.out.println("Cannot divide by zero!");
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid array index!");
		}
		
	}

}
