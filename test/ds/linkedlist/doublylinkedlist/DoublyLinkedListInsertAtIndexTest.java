package ds.linkedlist.doublylinkedlist;

import ds.linkedlist.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoublyLinkedListInsertAtIndexTest {

  private LinkedList<Integer> linkedList;

  @BeforeEach
  void setup() {
    linkedList = new DoublyLinkedList<>();
  }

  @Test
  void negativeIndexException() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      linkedList.insertAt(-1, 10);
    });
  }

  @Test
  void indexGreaterThenZeroWhenEmptyListException() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      linkedList.insertAt(1, 10);
    });
  }

  @Test
  void indexGreaterThanListLengthException() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      linkedList.append(10);
      linkedList.prepend(20);
      linkedList.insertAt(3, 30);
    });
  }

  @Test
  void insertAtHeadWhenListIsEmpty() {
    linkedList.insertAt(0, 10);
    assertEquals(10, linkedList.peekHead().get());
    assertEquals(1, linkedList.size());
  }

  @Test
  void insertAtTail() {
    linkedList.append(10);
    linkedList.append(20);
    linkedList.append(30);

    linkedList.insertAt(3, 40);

    assertEquals(40, linkedList.peekTail().get());
    assertEquals(4, linkedList.size());
  }

  @Test
  void insertAtIndex() {
    linkedList.append(20);
    linkedList.prepend(10);
    linkedList.append(30);
    linkedList.append(50);

    linkedList.insertAt(3, 40);

    final List<Integer> expected = List.of(10, 20, 30, 40, 50);

    assertEquals(expected, linkedList.values());
    assertEquals(5, linkedList.size());
  }
}
