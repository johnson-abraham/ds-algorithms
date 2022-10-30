package ds.stack;

import ds.linkedlist.LinkedList;
import ds.linkedlist.doublylinkedlist.DoublyLinkedList;

public class Stack<T extends Comparable<T>> {
  private LinkedList<T> list;

  public Stack() {
    list = new DoublyLinkedList<>();
  }

  public int push(T value) {
    return list.append(value);
  }

  public T pop() {
    return list.remove(list.size() - 1);
  }

  public int size() {
    return list.size();
  }
}
