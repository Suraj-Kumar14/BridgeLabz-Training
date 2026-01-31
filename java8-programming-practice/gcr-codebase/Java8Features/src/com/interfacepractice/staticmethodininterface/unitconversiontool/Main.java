package com.interfacepractice.staticmethodininterface.unitconversiontool;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		double km=10;
		System.out.println(UnitConverter.milesConverter(km));
		
		double kg=10;
		System.out.println(UnitConverter.lbsConverter(kg));

	}

}
