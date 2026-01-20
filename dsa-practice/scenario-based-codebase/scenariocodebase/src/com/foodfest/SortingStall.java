package com.foodfest;

import java.util.ArrayList;
import java.util.List;

public class SortingStall {
	
	List<Stall>stalls=new ArrayList<>();
	
	//add stall
	public void addStall(Stall stall) {
		stalls.add(stall);
		System.out.println("Stall added.");
	}
	
	//Sort stall based on footfall
	public void sortStall() {
		int start=0,end=stalls.size()-1;
		mergeSort(start,end);
		System.out.println("Stall are sorted based on footfall.");
	}
	
	//mergeSort
	private void mergeSort(int start,int end) {
		if(start<end) {
			int mid=(start+end)/2;
			mergeSort(start,mid);
			mergeSort(mid+1,end);
			merge(start,mid,end);
		}
	}
	
	//sort logic
	private void merge(int start,int mid,int end) {
		int n1=mid-start+1;
		int n2=end-mid;
		
		List<Stall>left=new ArrayList<>(stalls.subList(start,mid+1));
		List<Stall>right=new ArrayList<>(stalls.subList(mid+1, end+1));
		
		int i=0,j=0,k=start;
		while(i<n1 && j<n2) {
			if(left.get(i).getCustomerFootfall()<right.get(j).getCustomerFootfall()) {
				stalls.set(k++, left.get(i++));
			}else {
				stalls.set(k++,right.get(j++));
			}
		}
		while(i<n1) {
			stalls.set(k++,left.get(i++));
		}
		while(j<n2) {
			stalls.set(k++, right.get(j++));
		}
	}
	
	//show stalls
	public void showStall() {
		System.out.println("-------------FoodFest-------------");
		if(!stalls.isEmpty()) {
			for(Stall stall:stalls) {
				System.out.println(stall);
			}
		}else {
			System.out.println("No Stall present.");
		}
		System.out.println();
	}
}
