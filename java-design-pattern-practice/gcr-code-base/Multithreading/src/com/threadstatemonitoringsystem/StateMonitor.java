package com.threadstatemonitoringsystem;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class StateMonitor implements Runnable{

	 private final Thread taskThread;
	    private Thread.State lastState = null;
	    private final Set<Thread.State> observedStates = new HashSet<>();

	    StateMonitor(Thread taskThread) {
	        this.taskThread = taskThread;
	    }

	    @Override
	    public void run() {
	        try {
	            while (true) {
	                Thread.State currentState = taskThread.getState();

	                // Print only when state changes
	                if (currentState != lastState) {
	                    observedStates.add(currentState);
	                    System.out.printf(
	                        "[Monitor] %s is in %s state at %s%n",
	                        taskThread.getName(),
	                        currentState,
	                        LocalTime.now()
	                    );
	                    lastState = currentState;
	                }

	                if (currentState == Thread.State.TERMINATED) {
	                    break;
	                }

	                Thread.sleep(500);
	            }

	            System.out.println(
	                "Summary: " + taskThread.getName() +
	                " went through " + observedStates.size() + " states"
	            );

	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
}