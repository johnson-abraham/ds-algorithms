package ds.linkedlist.doublylinkedlist;

public class Node<T extends Comparable<T>> {
  private final T value;
  private Node<T> previous;
  private Node<T> next;

  public Node(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public Node<T> getPrevious() {
    return previous;
  }

  public void setPrevious(Node<T> previous) {
    this.previous = previous;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }
}
