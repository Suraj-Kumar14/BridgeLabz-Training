package com.icecreamrush;

import java.util.ArrayList;
import java.util.List;

public class IcecreamManagement {
	
	List<IceCream>iceCream=new ArrayList<>();
	public void addIcecream(IceCream cream) {
		iceCream.add(cream);
		System.out.println("IceCream added..");
	}
	
	public void sortIceCream() {
		int n=iceCream.size();
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(iceCream.get(j).getPopularity()>iceCream.get(j+1).getPopularity()) {
					IceCream temp=iceCream.get(j);
					iceCream.set(j,iceCream.get(j+1));
					iceCream.set(j+1, temp);
				}
			}
		}
		System.out.println("IceCream are sorted in terms of popularity..");
	}
	
	public void showIceCream() {
		if(!iceCream.isEmpty()) {
			for(var cream:iceCream) {
				System.out.println(cream);
			}
		}else {
			System.out.println("No IceCream available!");
		}
		System.out.println();
	}
}
