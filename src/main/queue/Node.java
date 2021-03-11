package main.queue;

public class Node<T extends Comparable<T>> {

  private T data;
  private Node<T> previous;
  private Node<T> next;

  public Node(T data) {
    this.data = data;
  }

  public Node() {}

  public T getData() {
    return data;
  }

  public Node<T> getPrevious() {
    return previous;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setPrevious(Node<T> previous) {
    this.previous = previous;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }
}
