package com.telerikacademy;

public interface Queue<T> {
  void offer(T value);

  T poll();

  T peek();

  int size();

  boolean isEmpty();
}
