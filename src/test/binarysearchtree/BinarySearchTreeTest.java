package test.binarysearchtree;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;
import static test.binarysearchtree.BinarySearchTreeHelper.generateTree;

import java.util.stream.Stream;
import main.binarysearchtree.Tree;
import main.binarysearchtree.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Tests binary search tree insertion")
class BinarySearchTreeTest {

  @Test
  @DisplayName("Constructs one branch and tests")
  void testOneBranch() {
    final var tree = generateTree(5, 2, 10);

    final TreeNode<Integer> root = tree.getRoot();

    assertAll(
        () -> assertEquals((int) root.getData(), 5),
        () -> assertEquals((int) root.getLeftNode().getData(), 2),
        () -> assertEquals((int) root.getRightNode().getData(), 10));
  }

  @Test
  @DisplayName("Constructs two branches and tests")
  void testTwoBranches() {
    final var tree = generateTree(10, 5, 15, 2, 20, 13, 7);
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

  @ParameterizedTest(name = "#{index} - Getting {1} should return {2}")
  @MethodSource("testGetArguments")
  @DisplayName("Tests the get method")
  <T extends Comparable<T>> void testGet(Tree<T> tree, T input, T expected) {
    assertEquals(expected, ofNullable(tree.get(input)).map(TreeNode::getData).orElse(null));
  }

  private static Stream<Arguments> testGetArguments() {
    final var tree = generateTree(10, 5, 15, 2, 20, 13, 7);
    return Stream.of(
        of(tree, 5, 5),
        of(tree, 20, 20),
        of(tree, 1, null),
        of(tree, 40, null),
        of(new Tree<>(), 15, null));
  }

  @ParameterizedTest(name = "#{index} - Minimum value should be {1}")
  @MethodSource("testMinArguments")
  @DisplayName("Tests the minimum value get")
  <T extends Comparable<T>> void testMin(Tree<T> tree, T expected) {
    assertEquals(expected, tree.min());
  }

  private static Stream<Arguments> testMinArguments() {
    return Stream.of(of(generateTree(8, 2, 6, 1, 0, 3, -5, 1), -5), of(new Tree<>(), null));
  }

  @ParameterizedTest(name = "#{index} - Maximum value should be {1}")
  @MethodSource("testMaxArguments")
  @DisplayName("Tests the minimum value get")
  <T extends Comparable<T>> void testMax(Tree<T> tree, T expected) {
    assertEquals(expected, tree.max());
  }

  private static Stream<Arguments> testMaxArguments() {
    return Stream.of(of(generateTree(8, 2, 6, 1, 0, 3, -5, 1), 8), of(new Tree<>(), null));
  }
}
