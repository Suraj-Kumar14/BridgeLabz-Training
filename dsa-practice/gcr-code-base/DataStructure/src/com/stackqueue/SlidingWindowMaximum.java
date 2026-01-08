package com.stackqueue;
import java.util.*;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int i=0,j=0;
        int max = -1;
        
        while(j<arr.length) {
        	//work
        	max = Math.max(max, arr[j]);
        	
        	//slide the window
        	if(j-i+1<k) {
        		j+=1;
        	}
        	
        	else if(j-i+1==k) {
        		//add the max in list
        		list.add(max);
        		
        		//increment the i by 1
        		i+=1;
        		j+=1;
        	}
        }
        
      //print the max window
  		for(int p=0;p<list.size();p++) {
  			System.out.print(list.get(p)+" ");
  		}
	}
}