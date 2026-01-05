package com.linkedlist.circularlimkedlist.TaskScheduler;

public class Main {
	    public static void main(String[] args) {
	        LinkedList scheduler = new LinkedList();
	        Task t1 = new Task(1, "Submit Assignment", 1, "2026-01-10");
	        Task t2 = new Task(2, "Project Meeting", 2, "2026-01-12");
	        Task t3 = new Task(3, "Prepare Presentation", 1, "2026-01-15");
	        
	        scheduler.addAtEnd(t1);
	        scheduler.addAtBeginning(t2);
	        scheduler.addAtPosition(t3, 2);

	        scheduler.displayAllTasks();

	        scheduler.viewCurrentTask();
	        scheduler.moveNext();
	        scheduler.viewCurrentTask();

	        scheduler.searchByPriority(1);
	        scheduler.removeTask(2);
	        scheduler.displayAllTasks();
	    }
}


