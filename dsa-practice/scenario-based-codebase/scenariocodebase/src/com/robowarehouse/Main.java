
package com.robowarehouse;

public class Main {

	public static void main(String[] args) {
		
		Robot robot=new Robot();
		robot.addPackage(new Package("TA101",100,5000));
		robot.addPackage(new Package("PA101",80,6000));
		robot.addPackage(new Package("CA101",150,9990));
		robot.addPackage(new Package("QA101",50,3000));
		robot.addPackage(new Package("LA101",10,500));
		robot.addPackage(new Package("TX101",30,2500));
		robot.addPackage(new Package("YS101",25,1900));
		robot.addPackage(new Package("RF101",15,1700));
		System.out.println();
		System.out.println("Packages before sorting..");
		robot.showPackages();
		robot.sortPackages();
		System.out.println("Packages after sorting..");
		robot.showPackages();		

	}

}
