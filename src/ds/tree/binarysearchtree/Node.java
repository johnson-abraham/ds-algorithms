package ds.tree.binarysearchtree;

public class Node<T extends Comparable<T>> {
  private final T value;
  private Node<T> left;
  private Node<T> right;

  public Node(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public Node<T> getLeft() {
    return left;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public Node<T> getRight() {
    return right;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }
}
