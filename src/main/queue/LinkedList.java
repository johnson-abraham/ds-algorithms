package main.queue;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class LinkedList<T extends Comparable<T>> {

  private Node<T> head;
  private Node<T> tail;
  private int length;

  public void addToHead(T value) {
    if (length == 0) {
      head = tail = new Node<>(value);
    } else if (length == 1) {
      head = new Node<>(value);
      head.setNext(tail);
      tail.setPrevious(head);
    } else {
      final var node = new Node<>(value);
      node.setNext(head);
      head.setPrevious(node);
      head = node;
    }

    ++length;
  }

  public T removeHead() {
    if (length == 0) {
      return null;
    } else {
      final T value = head.getData();
      if (length == 1) {
        head = tail = null;
      } else {
        head = head.getNext();
        head.setPrevious(null);
      }
      --length;
      return value;
    }
  }

  public void addToTail(T value) {
    if (length == 0) {
      head = tail = new Node<>(value);
    } else if (length == 1) {
      tail = new Node<>(value);
      head.setNext(tail);
      tail.setPrevious(head);
    } else {
      final var node = new Node<>(value);
      node.setPrevious(tail);
      tail.setNext(node);
      tail = node;
    }

    ++length;
  }

  public T removeTail() {
    if (length == 0) {
      return null;
    } else {
      final T value = tail.getData();
      if (length == 1) {
        head = tail = null;
      } else {
        tail = tail.getPrevious();
        tail.setNext(null);
      }
      --length;
      return value;
    }
  }

  public boolean remove(T value) {
    if (length == 0) {
      return false;
    } else if (length == 1) {
      return removeIfLengthIs1(value);
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

  public T peekHead() {
    return isNull(head) ? null : head.getData();
  }

  private boolean removeIfLengthIs1(T value) {
    if (head.getData().compareTo(value) == 0) {
      head = tail = null;
      --length;

      return true;
    }

    return false;
  }

  private boolean removeElement(T value) {
    if (head.getData().compareTo(value) == 0) {
      head = head.getNext();
      head.setPrevious(null);
      --length;
      return true;
    } else if (tail.getData().compareTo(value) == 0) {
      tail = tail.getPrevious();
      tail.setNext(null);
      --length;
      return true;
    } else {
      var node = head;
      while (nonNull(node.getNext())) {
        if (node.getNext().getData().compareTo(value) == 0) {
          node.setNext(node.getNext().getNext());
          node.getNext().getNext().setPrevious(node);
          --length;
          return true;
        }
        node = node.getNext();
      }
      return false;
    }
  }
}
