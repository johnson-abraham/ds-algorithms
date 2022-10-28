package ds.queue.impl;

import ds.linkedlist.LinkedList;
import ds.linkedlist.singlylinkedlist.SinglyLinkedList;

import java.util.Optional;

public class Queue<T extends Comparable<T>> implements ds.queue.Queue<T> {
  private final LinkedList<T> list;

  public Queue() {
    list = new SinglyLinkedList<>();
  }

  @Override
  public int push(T value) {
    return list.append(value);
  }

  @Override
  public T pop() {
    return list.remove(0);
  }

  @Override
  public Optional<T> peekHead() {
    return list.peekHead();
  }

  @Override
  public Optional<T> peekTail() {
    return list.peekTail();
  }

  @Override
  public int size() {
    return list.size();
  }
}
