package com.telerikacademy.stack_singly_linkedList_implementation;

public class StackImpl<T> implements Stack<T> {
  private static final String EMPTY_STACK_EXCEPTION = "Stack is empty.";

  private int size;
  private Node<T> top;

  @Override
  public void push(T value) {
    Node<T> newNode = new Node<>(value);
    if (isEmpty()) {
      top = newNode;
    } else {
      newNode.setNext(top);
      top = newNode;
    }

    size++;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new IllegalArgumentException(EMPTY_STACK_EXCEPTION);
    }
    T elementToPop = top.getValue();
    top = top.getNext();

    size--;

    return elementToPop;
  }

  @Override
  public T peek() {
    if (isEmpty()) {
      throw new IllegalArgumentException(EMPTY_STACK_EXCEPTION);
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
