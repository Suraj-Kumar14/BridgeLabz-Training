package com.medwarehouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedWarehouse {
	

	List<Medicine>medicines=new ArrayList<>();
	//add medicine
	public void addMedicine(Medicine medicine) {
		medicines.add(medicine);
		System.out.println("Medicine added.");
	}
	
	//sort medicine
	public void sortMedicine() {
		int start=0,end=medicines.size()-1;
		mergeSort(start,end);
		System.out.println("Expiry date sorted.");
	}
	
	private void mergeSort(int start,int end) {
		if(start<end) {
			int mid=(start+end)/2;
			mergeSort(start,mid);
			mergeSort(mid+1,end);
			merge(start,mid,end);
		}
	}
	
	private void merge(int start,int mid,int end) {
		int n1=mid-start+1;
		int n2=end-mid;
		
		List<Medicine>left=new ArrayList<>(medicines.subList(start,mid+1));
		List<Medicine>right=new ArrayList<>(medicines.subList(mid+1,end+1));
		
		int i=0,j=0,k=start;
		while(i<n1 && j<n2) {
			if(left.get(i).getExpiryDate().isBefore(right.get(j).getExpiryDate())) {
				medicines.set(k++,left.get(i++));
			}else {
				medicines.set(k++,right.get(j++));
			}
		}
		while(i<n1) {
			medicines.set(k++, left.get(i++));
		}
		while(j<n2) {
			medicines.set(k++,right.get(j++));
		}
	}
	
	//check expiry
	public void checkExpiry() {
		if(medicines.isEmpty()) {
			System.out.println("No medicine available");
			return;
		}
		for(Medicine medi:medicines) {
			LocalDate today=LocalDate.now();
			if(medi.getExpiryDate().isAfter(today)) {
//				System.out.println(medi+"medicine not expired");
			}else {
				System.out.println(medi+"Expired!");
			}
		}
	}
	//view medicine
	public void showMedicine() {
		System.out.println("---------Medicine Expiry Details--------");
		if(!medicines.isEmpty()) {
			for(Medicine medicine:medicines) {
				System.out.println(medicine);
			}
		}else {
			System.out.println("Medicine not available!");
		}
		System.out.println();
	}
}
