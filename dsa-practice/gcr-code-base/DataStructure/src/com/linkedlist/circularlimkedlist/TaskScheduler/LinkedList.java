package com.linkedlist.circularlimkedlist.TaskScheduler;

public class LinkedList {
	 Task head;
	 Task current;
	
	public LinkedList() {
		head=null;
		current=null;
	}
	
	public void addAtBeginning(Task newTask) {
		if(head==null) {
			head=newTask;
			newTask.next=head;
		}
		else {
			Task temp=head;
			while(temp.next!=head) {
				temp=temp.next;
			}
			newTask.next=head;
			head=newTask;
			temp.next=head;
		}
		if(current==null)
			current=head;
	}
	
    public void addAtEnd(Task newTask) {
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
        if (current == null) current = head;
    }
    public void addAtPosition(Task newTask, int position) {
        if (position <= 1) {
            addAtBeginning(newTask);
            return;
        }
        Task temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }
    
    public void removeTask(int taskID) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Task temp = head, prev = null;

        // check head separately
        if (head.taskId == taskID) {
            if (head.next == head) { // only one node
                head = null;
                current = null;
            } else {
                Task last = head;
                while (last.next != head) {
                    last = last.next;
                }
                head = head.next;
                last.next = head;
                if (current.taskId == taskID) current = head;
            }
            System.out.println("Task removed successfully!");
            return;
        }
        prev = head;
        temp = head.next;
        while (temp != head) {
            if (temp.taskId == taskID) {
                prev.next = temp.next;
                if (current.taskId == taskID) current = temp.next;
                System.out.println("Task removed successfully!");
                return;
            }
            prev = temp;
            temp = temp.next;
        }

        System.out.println("Task ID not found!");
    }

    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("----------Current Task-----------");
        System.out.println("ID: " + current.taskId + ", Name: " + current.taskName +
                ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
    }

    public void moveNext() {
        if (current != null) {
            current = current.next;
        }
    }
    
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the scheduler.");
            return;
        }
        Task temp = head;
        System.out.println("----------All Tasks----------");
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the scheduler.");
            return;
        }
        Task temp = head;
        boolean found = false;
        System.out.println("Tasks with priority " + priority + ":");
        do {
            if (temp.priority == priority) {
                System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks found with this priority.");
    }

}
