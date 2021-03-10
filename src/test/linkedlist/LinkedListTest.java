package test.linkedlist;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.List;
import main.linkedlist.LinkedList;
import main.linkedlist.Node;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class LinkedListTest {

  @Test
  @DisplayName("Tests adding elements to the head of the linked list")
  void addToHead() {
    final var linkedList = new LinkedList<Integer>();
    linkedList.addToHead(4);
    linkedList.addToHead(3);
    linkedList.addToHead(2);
    linkedList.addToHead(1);

    assertNode(linkedList.getHead());
  }

  @Test
  @DisplayName("Tests adding elements to the tail of the linked list")
  void addToTail() {
    final var linkedList = new LinkedList<Integer>();
    linkedList.addToTail(1);
    linkedList.addToTail(2);
    linkedList.addToTail(3);
    linkedList.addToTail(4);

    assertNode(linkedList.getHead());
  }

  private void assertNode(Node<Integer> node) {
    assertAll(
        () -> assertEquals(1, node.getData()),
        () -> assertEquals(2, node.getNext().getData()),
        () -> assertEquals(3, node.getNext().getNext().getData()),
        () -> assertEquals(4, node.getNext().getNext().getNext().getData()),
        () -> assertNull(node.getNext().getNext().getNext().getNext()));
  }

  @TestFactory
  @DisplayName("Tests removal of elements from the list")
  List<DynamicTest> remove() {
    return Arrays.asList(
        dynamicTest(
            "Should return false when the list is empty",
            () -> assertFalse(new LinkedList<Integer>().remove(10))),
        dynamicTest(
            "Should return false when the list has one element and the value to be removed is not found",
            () -> {
              final var linkedList = new LinkedList<Integer>();
              linkedList.addToHead(10);

              assertFalse(linkedList.remove(20));
            }),
        dynamicTest(
            "Should return true when the list has one element and the value to be removed is present",
            () -> {
              final var linkedList = new LinkedList<Integer>();
              linkedList.addToHead(10);

              assertAll(
                  () -> assertTrue(linkedList.remove(10)),
                  () -> assertEquals(0, linkedList.getLength()));
            }),
        dynamicTest(
            "Should return false when the list has multiple elements and the value to be removed is not found",
            () -> {
              final var linkedList = new LinkedList<Integer>();
              linkedList.addToTail(10);
              linkedList.addToTail(20);
              linkedList.addToTail(30);
              linkedList.addToTail(40);

              assertFalse(linkedList.remove(100));
            }),
        dynamicTest(
            "Should return true when the list has multiple elements and the value to be removed is present",
            () -> {
              final var linkedList = new LinkedList<Integer>();
              linkedList.addToTail(10);
              linkedList.addToTail(20);
              linkedList.addToTail(30);
              linkedList.addToTail(40);

              assertAll(
                  () -> assertTrue(linkedList.remove(10)),
                  () -> assertEquals(3, linkedList.getLength()));
            }),
        dynamicTest(
            "Should return true when the list has multiple elements and the value to be removed is present",
            () -> {
              final var linkedList = new LinkedList<Integer>();
              linkedList.addToTail(10);
              linkedList.addToTail(20);
              linkedList.addToTail(30);
              linkedList.addToTail(40);

              assertAll(
                  () -> assertTrue(linkedList.remove(40)),
                  () -> assertEquals(3, linkedList.getLength()));
            }),
        dynamicTest(
            "Should return true when the list has multiple elements and the value to be removed is present",
            () -> {
              final var linkedList = new LinkedList<Integer>();
              linkedList.addToTail(10);
              linkedList.addToTail(20);
              linkedList.addToTail(30);
              linkedList.addToTail(40);
              linkedList.addToTail(50);

              assertAll(
                  () -> assertTrue(linkedList.remove(30)),
                  () -> assertEquals(4, linkedList.getLength()));
            }),
        dynamicTest(
            "Should return true when the list has multiple elements and the value to be removed is present",
            () -> {
              final var linkedList = new LinkedList<Integer>();
              linkedList.addToTail(10);
              linkedList.addToTail(20);
              linkedList.addToTail(30);
              linkedList.addToTail(40);
              linkedList.addToTail(50);

              assertAll(
                  () -> assertTrue(linkedList.remove(20)),
                  () -> assertEquals(4, linkedList.getLength()));
            }));
  }
}
