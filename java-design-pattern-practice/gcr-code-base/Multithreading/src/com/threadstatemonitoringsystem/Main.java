package com.threadstatemonitoringsystem;

public class Main {

	public static void main(String[] args) {

		Thread task = new Thread(new TaskRunner(), "Task-1");
        Thread monitor = new Thread(new StateMonitor(task), "Monitor");

        // NEW state
        monitor.start();
        task.start();
    }
}
