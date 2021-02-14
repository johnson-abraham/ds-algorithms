package main.binarysearchtree;

import static java.lang.System.out;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import org.jetbrains.annotations.NotNull;

public class TreeNode<T extends Comparable<T>> {

  private T data;
  private TreeNode<T> leftNode;
  private TreeNode<T> rightNode;

  public TreeNode(T data) {
    this.data = data;
  }

  public void insert(@NotNull T data) {
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

  public TreeNode<T> get(T value) {
    final int comparedValue = value.compareTo(data);

    if (comparedValue == 0) {
      return this;
    } else if (comparedValue < 0) {
      if (nonNull(leftNode)) {
        return leftNode.get(value);
      }
    } else if (nonNull(rightNode)) {
      return rightNode.get(value);
    }

    return null;
  }

  public T min() {
    return isNull(leftNode) ? data : leftNode.min();
  }

  public T max() {
    return isNull(rightNode) ? data : rightNode.max();
  }

  public void traverseInOrder() {
    if (nonNull(leftNode)) {
      leftNode.traverseInOrder();
    }

    out.print(data + ", ");

    if (nonNull(rightNode)) {
      rightNode.traverseInOrder();
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

  @Override
  public String toString() {
    return data.toString();
  }
}
