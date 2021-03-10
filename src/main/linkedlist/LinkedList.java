package main.linkedlist;

import static java.util.Objects.nonNull;

public class LinkedList<T extends Comparable<T>> {

  private Node<T> head;
  private Node<T> tail;
  private int length;

  public void addToHead(T value) {
    if (length == 0) {
      head = tail = new Node<>(value);
    } else if (length == 1) {
      head = new Node<>(value, tail);
    } else {
      head = new Node<>(value, head);
    }

    ++length;
  }

  public void addToTail(T value) {
    if (length == 0) {
      head = tail = new Node<>(value);
    } else if (length == 1) {
      tail = new Node<>(value);
      head.setNext(tail);
    } else {
      final var node = new Node<>(value);
      tail.setNext(node);
      tail = node;
    }

    ++length;
  }

  public boolean remove(T value) {
    if (length == 0) {
      return false;
    } else if (length == 1) {
      return removeElementWhenLengthIsOne(value);
    } else {
      return removeElement(value);
    }
  }

  public Node<T> getHead() {
    return head;
  }

  public Node<T> getTail() {
    return tail;
  }

  public int getLength() {
    return length;
  }

  private boolean removeElementWhenLengthIsOne(T value) {
    if (head.getData().compareTo(value) == 0) {
      head = tail = null;
      --length;
      return true;
    } else {
      return false;
    }
  }

  private boolean removeElement(T value) {
    if (head.getData().compareTo(value) == 0) {
      head = head.getNext();
      --length;
      return true;
    } else {
      var node = head;
      while (nonNull(node.getNext())) {
        if (node.getNext().getData().compareTo(value) == 0) {
          node.setNext(node.getNext().getNext());
          --length;
          return true;
        }

        node = node.getNext();
      }

      return false;
    }
  }
}
