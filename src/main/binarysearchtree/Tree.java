package main.binarysearchtree;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Tree<T extends Comparable<T>> {

  private TreeNode<T> root;

  public TreeNode<T> getRoot() {
    return root;
  }

  public void insert(T data) {
    if (isNull(root)) {
      root = new TreeNode<>(data);
    }
    root.insert(data);
  }

  public TreeNode<T> get(T value) {
    return nonNull(root) ? root.get(value) : null;
  }

  public void traverseInOrder() {
    if (nonNull(root)) {
      root.traverseInOrder();
    }
  }
}
