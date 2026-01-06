package com.stackqueue.implementqueue;
import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>(); // Enqueue stack
    Stack<Integer> stack2 = new Stack<>(); // Dequeue stack

    // Enqueue operation
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation
    public int dequeue() {
        if (stack2.isEmpty()) {
           
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1; 
        }

        return stack2.pop();
    }

    // Peek front element
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return stack2.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}