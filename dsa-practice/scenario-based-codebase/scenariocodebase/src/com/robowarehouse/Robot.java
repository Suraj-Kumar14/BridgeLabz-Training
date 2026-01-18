package com.robowarehouse;

import java.util.ArrayList;
import java.util.List;

public class Robot {
	
	List<Package>packages=new ArrayList<>();
	
	public void addPackage(Package packag) {
		packages.add(packag);
		System.out.println("Package added to store.");
	}
	
	public void sortPackages() {
		int n=packages.size();
		for(int i=1;i<n;i++) {
			Package top=packages.get(i);
			int j=i-1;
			while(j>=0 && packages.get(j).getWeight()>top.getWeight()) {
				packages.set(j+1,packages.get(j));
				j--;
			}
			j++;
			packages.set(j, top);
		}
		System.out.println("Packages are sorted in terms of weight..");
	}
	
	public void showPackages() {
		System.out.println("-------------Robo Warehouse------------");
		if(!packages.isEmpty()) {
			for(Package pack:packages) {
				System.out.println(pack);
			}
		}else {
			System.out.println("No package available in store.");
		}
		System.out.println();
	}	
}
