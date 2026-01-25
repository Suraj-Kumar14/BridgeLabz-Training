package com.regexjunit.junit.timeouttesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class TimeoutPerformanceTest {
	
	TimeoutPerformance performance;
	@BeforeEach
	void setUp() throws Exception {
		performance=new TimeoutPerformance();
	}

	@Test
	@Timeout(2)
	void testLongRunningTask() throws InterruptedException {
		performance.longRunningTask();
	}

}
