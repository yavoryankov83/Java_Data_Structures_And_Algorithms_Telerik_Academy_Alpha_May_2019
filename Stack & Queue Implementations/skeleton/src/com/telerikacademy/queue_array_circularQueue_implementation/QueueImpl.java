package com.telerikacademy.queue_array_circularQueue_implementation;

import java.util.Arrays;

public class QueueImpl<T> implements Queue<T> {
  private static final int INITIAL_CAPACITY = 8;
  private static final int RESIZE_MULTIPLIER = 2;
  private static final String EMPTY_QUEUE_EXCEPTION = "Queue is empty.";

  private T[] values;
  private int size;
  private int top;
  private int tail;

  @SuppressWarnings("unchecked")
  public QueueImpl() {
    values = (T[]) new Object[INITIAL_CAPACITY];
  }

  @Override
  public void offer(T value) {
    if (size == values.length) {
      resizeArray();
    } else {
      values[tail] = value;
      tail = (tail + 1) % values.length;
    }

    size++;
  }

  @Override
  public T poll() {
    if (size == 0) {
      throw new IllegalArgumentException(EMPTY_QUEUE_EXCEPTION);
    }
    T elementToPop = values[top];
    top = (top + 1) % values.length;

    size--;

    return elementToPop;

  }

  @Override
  public T peek() {
    if (size == 0) {
      throw new IllegalArgumentException(EMPTY_QUEUE_EXCEPTION);
    }

    return values[top];
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  private void resizeArray() {
    values = Arrays.copyOf(values, values.length * RESIZE_MULTIPLIER);
  }
}
