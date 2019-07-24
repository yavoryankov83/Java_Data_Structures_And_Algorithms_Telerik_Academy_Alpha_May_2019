package com.telerikacademy.stack_array_implementation;

import java.util.Arrays;

public class StackImpl<T> implements Stack<T> {
  private static final int INITIAL_CAPACITY = 8;
  private static final int RESIZE_MULTIPLIER = 2;
  private static final String EMPTY_STACK_EXCEPTION = "Stack is empty.";

  private T[] values;
  private int size;
  private int top;

  @SuppressWarnings("unchecked")
  public StackImpl() {
    values = (T[]) new Object[INITIAL_CAPACITY];
    top = -1;
  }

  @Override
  public void push(T value) {
    if (size == values.length) {
      resizeArray();
    } else {
      values[++top] = value;

      size++;
    }
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new IllegalArgumentException(EMPTY_STACK_EXCEPTION);
    }
    T elementToPop = values[top];

    size--;

    return elementToPop;
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      throw new IllegalArgumentException(EMPTY_STACK_EXCEPTION);
    }

    return values[top];
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  private void resizeArray() {
    values = Arrays.copyOf(values, values.length * RESIZE_MULTIPLIER);
  }
}
