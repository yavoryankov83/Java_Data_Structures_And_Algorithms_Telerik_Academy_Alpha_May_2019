package com.company;

public class DoubleNode<T> {
  private T value;
  private DoubleNode<T> prev;
  private DoubleNode<T> next;

  DoubleNode(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  DoubleNode<T> getPrev() {
    return prev;
  }

  void setPrev(DoubleNode<T> prev) {
    this.prev = prev;
  }

  public DoubleNode<T> getNext() {
    return next;
  }

  void setNext(DoubleNode<T> next) {
    this.next = next;
  }
}