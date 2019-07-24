package com.telerikacademy.queue_array_circularQueue_implementation;

public class Main {
  public static void main(String[] args) {
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
