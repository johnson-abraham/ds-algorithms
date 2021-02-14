package test.binarysearchtree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import main.binarysearchtree.Tree;
import main.binarysearchtree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests binary search tree insertion")
class BinarySearchTreeInsertionTest {

  @Test
  @DisplayName("Constructs one branch and tests")
  void testOneBranch() {
    final var tree = new Tree<Integer>();
    tree.insert(5);
    tree.insert(2);
    tree.insert(10);

    final TreeNode<Integer> root = tree.getRoot();

    assertAll(
        () -> assertEquals((int) root.getData(), 5),
        () -> assertEquals((int) root.getLeftNode().getData(), 2),
        () -> assertEquals((int) root.getRightNode().getData(), 10));
  }

  @Test
  @DisplayName("Constructs two branches and tests")
  void testTwoBranches() {
    final var tree = new Tree<Integer>();
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(2);
    tree.insert(20);
    tree.insert(13);
    tree.insert(7);

    final TreeNode<Integer> root = tree.getRoot();

    assertAll(
        () -> assertEquals(root.getData(), 10),
        () -> assertEquals(root.getLeftNode().getData(), 5),
        () -> assertEquals(root.getRightNode().getData(), 15),
        () -> assertEquals(root.getLeftNode().getLeftNode().getData(), 2),
        () -> assertEquals(root.getRightNode().getRightNode().getData(), 20),
        () -> assertEquals(root.getRightNode().getLeftNode().getData(), 13),
        () -> assertEquals(root.getLeftNode().getRightNode().getData(), 7));
  }
}
