package com.stackqueue.circularTourProblem;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {
	
	static class pump{
		int petrol;
		int distance;
		int index;
		public pump(int petrol,int distance,int index) {
			this.distance =petrol;
			this.distance =distance;
			this.index=index;
		}
	}
	
	public static int startIndex(int []petrol,int[] distance) {
		int n=petrol.length;
		Queue<pump>queue=new LinkedList<>();
		int surplus=0, deficit=0;
		
		for(int i=0;i<n;i++) {
			int gain=petrol[i]-distance[i];
			surplus+=gain;
			queue.add(new pump(petrol[i],distance[i],i));
			
			if(surplus<0) {
				queue.clear();
				deficit+=surplus;
				surplus=0;
			}
		}
		if(surplus+deficit >=0 && !queue.isEmpty()) {
			return queue.peek().index;
		}		
		return -1;
	}
}
