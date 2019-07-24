package com.telerikacademy;

class Node<T> {
  private T value;
  private Node<T> next;

  Node(T value) {
    this.value = value;
  }

  T getValue() {
    return value;
  }

  Node<T> getNext() {
    return next;
  }

  void setNext(Node<T> next) {
    this.next = next;
  }
}
