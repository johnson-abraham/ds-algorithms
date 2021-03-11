package main.queue;

public class Queue<T extends Comparable<T>> {

  private final LinkedList<T> list;

  public Queue() {
    this.list = new LinkedList<>();
  }

  public void add(T value) {
    list.addToTail(value);
  }

  public T remove() {
    return list.removeHead();
  }

  public T peek() {
    return list.peekHead();
  }
}
