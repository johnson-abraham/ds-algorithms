package main.binarysearchtree;

import static java.util.Objects.isNull;

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
}
