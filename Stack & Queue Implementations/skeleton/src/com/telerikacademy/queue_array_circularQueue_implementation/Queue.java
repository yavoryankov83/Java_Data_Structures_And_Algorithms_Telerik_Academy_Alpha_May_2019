package com.telerikacademy.queue_array_circularQueue_implementation;

public interface Queue<T> {
  void offer(T value);

  T poll();

  T peek();

  int size();

  boolean isEmpty();
}
