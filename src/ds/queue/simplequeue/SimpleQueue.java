package ds.queue.simplequeue;

import ds.linkedlist.LinkedList;
import ds.linkedlist.singlylinkedlist.SinglyLinkedList;
import ds.queue.Queue;

import java.util.Optional;

public class SimpleQueue<T extends Comparable<T>> implements Queue<T> {
  private final LinkedList<T> list;

  public SimpleQueue() {
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
