package com.timecomplexity.compareLinearBinaryPerformnce;

public class DataSet {

	public static int[] generateData(int size) {
		int[] data=new int[size];
		for(int i=0;i<size;i++) {
			data[i]=i+1;
		}
		return data;
	}
	
	
	public static void main(String[] args) {
		
		int[] sizes= {1000,10000,1_000_000};
		int target=-1;
		
		System.out.println("Dataset Size | Linear Search (ms) | Binary Search (ms)");
		System.out.println("------------------------------------------------------");
		
		for(int size:sizes) {
			int[] data=generateData(size);
			
			//Linear Search timing
			long startLinear=System.nanoTime();
			SearchComparison.linearSearch(data,target);
			long endLinear=System.nanoTime();
			
			//Binary Search timing
			long startBinary=System.nanoTime();
			SearchComparison.binarySearch(data,target);
			long endBinary=System.nanoTime();
			
			 double linearTime = (endLinear - startLinear) / 1_000_000.0;
	         double binaryTime = (endBinary - startBinary) / 1_000_000.0;
	         
	         System.out.printf("%12d | %18.3f | %18.3f%n",
	                    size, linearTime, binaryTime);
		}
	}

}
