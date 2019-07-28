package double_linkedList_implementation;

import java.util.Iterator;

public class DoublyLinkedListImpl<T> implements DoublyLinkedList<T> {
  private static final String EMPTY_LINKEDLIST_EXCEPTION = "No elements in LinkedList.";

  private DoubleNode<T> head;
  private DoubleNode<T> tail;
  private int count;

  public DoublyLinkedListImpl() {
  }

  public DoublyLinkedListImpl(Iterable<T> values) {
    for (T value : values) {
      addLast(value);
    }
  }

  @Override
  public DoubleNode getHead() {
    return head;
  }

  @Override
  public DoubleNode getTail() {
    return tail;
  }

  @Override
  public int getCount() {
    return count;
  }

  @Override
  public void addLast(T value) {
    DoubleNode<T> newNode = new DoubleNode<>(value);
    if (count == 0) {
      head = newNode;
      tail = head;
    } else {
      tail.setNext(newNode);
      newNode.setPrev(tail);
      tail = newNode;
    }

    count++;
  }

  @Override
  public void addFirst(T value) {
    DoubleNode<T> newNode = new DoubleNode<>(value);
    if (count == 0) {
      head = newNode;
      tail = head;
    } else {
      newNode.setNext(head);
      head.setPrev(newNode);
      head = newNode;
    }

    count++;
  }

  @Override
  public void insertBefore(DoubleNode node, T value) {
    DoubleNode<T> newNode = new DoubleNode<>(value);

    DoubleNode<T> temp = node.getPrev();
    node.setPrev(newNode);
    newNode.setNext(node);

    if (temp != null) {
      newNode.setPrev(temp);
      temp.setNext(newNode);
    } else {
      head = newNode;
    }

    count++;
  }

  @Override
  public void insertAfter(DoubleNode node, T value) {
    DoubleNode<T> newNode = new DoubleNode<>(value);

    DoubleNode<T> temp = node.getNext();
    node.setNext(newNode);
    newNode.setPrev(node);

    if (temp != null) {
      newNode.setNext(temp);
      temp.setPrev(newNode);
    }

    count++;
  }

  @Override
  public T removeFirst() {
    if (count == 0) {
      throw new NullPointerException(EMPTY_LINKEDLIST_EXCEPTION);
    }
    T temp = head.getValue();
    head = head.getNext();

    count--;

    return temp;
  }

  @Override
  public T removeLast() {
    if (count == 0) {
      throw new NullPointerException(EMPTY_LINKEDLIST_EXCEPTION);
    }
    T temp = tail.getValue();
    tail = tail.getPrev();

    count--;

    return temp;
  }

  @Override
  public DoubleNode find(T value) {
    if (count == 0) {
      return null;
    }
    DoubleNode<T> startNode = head;

    while (startNode != null) {
      T current = startNode.getValue();

      if (current == value) {
        return startNode;
      }

      startNode = startNode.getNext();
    }

    return null;
  }

  @Override
  public Iterator<T> iterator() {
    return new DoublyLinkedListIterator();
  }

  private class DoublyLinkedListIterator implements Iterator<T> {
    private DoubleNode<T> startNode;

    DoublyLinkedListIterator() {
      startNode = head;
    }

    @Override
    public boolean hasNext() {
      return startNode != null;
    }

    @Override
    public T next() {
      T value = startNode.getValue();
      startNode = startNode.getNext();

      return value;
    }
  }
}
