package com.telerikacademy;

public class QueueImpl<T> implements Queue<T> {
  private static final String EMPTY_QUEUE_EXCEPTION = "Queue is empty.";

  private int size;
  private Node<T> top;
  private Node<T> tail;

  @Override
  public void offer(T value) {
    Node<T> newNode = new Node<>(value);
    if (isEmpty()) {
      top = newNode;
      tail = top;
    } else {
      tail.setNext(newNode);
      tail = newNode;
    }

    size++;
  }

  @Override
  public T poll() {
    if (isEmpty()) {
      throw new IllegalArgumentException(EMPTY_QUEUE_EXCEPTION);
    }
    T elementToPoll = top.getValue();

    top = top.getNext();

    size--;

    return elementToPoll;
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      throw new IllegalArgumentException(EMPTY_QUEUE_EXCEPTION);
    }

    return top.getValue();
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }
}
