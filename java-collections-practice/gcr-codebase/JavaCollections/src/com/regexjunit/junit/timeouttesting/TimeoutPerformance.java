package com.regexjunit.junit.timeouttesting;

public class TimeoutPerformance {
	
	public void longRunningTask() throws InterruptedException {
		Thread.sleep(3000);
	}
}
