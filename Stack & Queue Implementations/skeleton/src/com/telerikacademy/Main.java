package com.telerikacademy;

import com.telerikacademy.queue_singly_linkedList_implementation.Queue;
import com.telerikacademy.queue_singly_linkedList_implementation.QueueImpl;
import com.telerikacademy.stack_singly_linkedList_implementation.Stack;
import com.telerikacademy.stack_singly_linkedList_implementation.StackImpl;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new StackImpl<>();
    stack.push(5);
    stack.push(11);
    stack.push(3);

    System.out.println(stack.pop());

    Queue<Integer> queue = new QueueImpl<>();
    queue.offer(5);
    queue.offer(11);
    queue.offer(3);

    try {
      System.out.println(queue.poll());
      System.out.println(queue.poll());
      System.out.println(queue.poll());
      System.out.println(queue.poll());
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
