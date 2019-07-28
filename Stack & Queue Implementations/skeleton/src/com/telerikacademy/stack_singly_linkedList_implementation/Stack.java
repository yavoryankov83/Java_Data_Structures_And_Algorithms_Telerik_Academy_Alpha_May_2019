package com.telerikacademy.stack_singly_linkedList_implementation;

public interface Stack<T> {
  void push(T value);

  T pop();

  T peek();

  int size();

  boolean isEmpty();
}
