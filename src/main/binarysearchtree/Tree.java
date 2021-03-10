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

  public T min() {
    return nonNull(root) ? root.min() : null;
  }

  public T max() {
    return nonNull(root) ? root.max() : null;
  }

  public void delete(T value) {
    delete(root, value);
  }

  private TreeNode<T> delete(TreeNode<T> subTreeRoot, T value) {
    if (isNull(subTreeRoot)) {
      return null;
    }

    final int compared = value.compareTo(subTreeRoot.getData());

    if (compared < 0) {
      subTreeRoot.setLeftNode(delete(subTreeRoot.getLeftNode(), value));
    } else if (compared > 0) {
      subTreeRoot.setRightNode(delete(subTreeRoot.getRightNode(), value));
    } else {
      if (isNull(subTreeRoot.getLeftNode())) {
        return subTreeRoot.getRightNode();
      } else if (isNull(subTreeRoot.getRightNode())) {
        return subTreeRoot.getLeftNode();
      } else {
        subTreeRoot.setData(subTreeRoot.getRightNode().min());
        subTreeRoot.setRightNode(delete(subTreeRoot.getRightNode(), subTreeRoot.getData()));
      }
    }

    return subTreeRoot;
  }

  public void traverseInOrder() {
    if (nonNull(root)) {
      root.traverseInOrder();
    }
  }
}
