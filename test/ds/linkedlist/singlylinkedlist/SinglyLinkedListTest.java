package ds.linkedlist.singlylinkedlist;

import ds.linkedlist.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

  private LinkedList<Integer> linkedList;

  @BeforeEach
  void setup() {
    linkedList = new SinglyLinkedList<>();
  }

  @Test
  void testPrepend() {
    linkedList.prepend(10);
    linkedList.prepend(20);
    linkedList.prepend(30);

    assertEquals(30, linkedList.peekHead().get());
    assertEquals(10, linkedList.peekTail().get());
  }

  @Test
  void testAppend() {
    linkedList.append(10);
    linkedList.append(50);
    linkedList.append(100);

    assertEquals(100, linkedList.peekTail().get());
    assertEquals(10, linkedList.peekHead().get());
  }

  @Test
  void testValues() {
    final List<Integer> expected = List.of(10, 20, 30);

    linkedList.append(20);
    linkedList.prepend(10);
    linkedList.append(30);

    final List<Integer> actual = linkedList.values();

    assertEquals(expected, actual);
  }

  @Test
  void reverse() {
    final List<Integer> expected = List.of(30, 20, 10);

    linkedList.append(20);
    linkedList.prepend(10);
    linkedList.append(30);

    linkedList.reverse();

    final List<Integer> actual = linkedList.values();

    assertEquals(expected, actual);

    linkedList.append(0);
    linkedList.prepend(40);

    assertEquals(4, linkedList.firstIndexOf(0).get());
    assertEquals(0, linkedList.firstIndexOf(40).get());
  }
}