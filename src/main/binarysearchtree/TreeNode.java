package main.binarysearchtree;

import static java.util.Objects.isNull;

public class TreeNode<T extends Comparable<T>> {

  private T data;
  private TreeNode<T> leftNode;
  private TreeNode<T> rightNode;

  public TreeNode(T data) {
    this.data = data;
  }

  public void insert(T data) {
    final int comparedValue = data.compareTo(this.data);

    if (comparedValue == 0) {
      return;
    }

    if (comparedValue < 0) {
      if (isNull(leftNode)) {
        leftNode = new TreeNode<>(data);
      } else {
        leftNode.insert(data);
      }
    } else {
      if (isNull(rightNode)) {
        rightNode = new TreeNode<>(data);
      } else {
        rightNode.insert(data);
      }
    }
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public TreeNode<T> getLeftNode() {
    return leftNode;
  }

  public void setLeftNode(TreeNode<T> leftNode) {
    this.leftNode = leftNode;
  }

  public TreeNode<T> getRightNode() {
    return rightNode;
  }

  public void setRightNode(TreeNode<T> rightNode) {
    this.rightNode = rightNode;
  }
}
