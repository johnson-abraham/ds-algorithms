package test.binarysearchtree;

import static java.util.stream.Stream.of;

import main.binarysearchtree.Tree;

public class BinarySearchTreeHelper {

  private BinarySearchTreeHelper() {}

  public static <T extends Comparable<T>> Tree<T> generateTree(T... values) {
    final var tree = new Tree<T>();
    of(values).forEach(tree::insert);
    return tree;
  }
}
