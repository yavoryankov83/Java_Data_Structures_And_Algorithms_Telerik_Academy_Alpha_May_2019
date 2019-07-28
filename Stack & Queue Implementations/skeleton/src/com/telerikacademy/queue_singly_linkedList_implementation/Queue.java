package com.telerikacademy.queue_singly_linkedList_implementation;

public interface Queue<T> {
  void offer(T value);

  T poll();

  T peek();

  int size();

  boolean isEmpty();
}
