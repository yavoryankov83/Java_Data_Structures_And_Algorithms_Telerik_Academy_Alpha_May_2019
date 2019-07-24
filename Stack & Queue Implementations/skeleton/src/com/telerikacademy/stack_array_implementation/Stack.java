package com.telerikacademy.stack_array_implementation;

public interface Stack<T> {
  void push(T value);

  T pop();

  T peek();

  int size();

  boolean isEmpty();
}
