package main.stack;

import static java.util.Optional.ofNullable;

public class Stack<T extends Comparable<T>> {

  private final LinkedList<T> list;

  public Stack() {
    this.list = new LinkedList<>();
  }

  public void push(T value) {
    list.addToHead(value);
  }

  public T pop() {
    return list.removeHead();
  }

  public T peek() {
    return ofNullable(list.getHead()).map(Node::getData).orElse(null);
  }
}
