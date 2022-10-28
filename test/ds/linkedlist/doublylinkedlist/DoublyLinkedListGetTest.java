package ds.linkedlist.doublylinkedlist;

import ds.linkedlist.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListGetTest {

  private LinkedList<Integer> linkedList;

  @BeforeEach
  void setup() {
    linkedList = new DoublyLinkedList<>();
  }

  @Test
  void throwIfEmptyList() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      linkedList.get(0);
    });
  }

  @Test
  void throwIfIndexLessThanZero() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      linkedList.append(10);
      linkedList.get(-1);
    });
  }

  @Test
  void throwIfIndexGreaterThanOrEqualToLength() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      linkedList.append(10);
      linkedList.append(20);
      linkedList.append(30);

      linkedList.get(3);
    });
  }

  @Test
  void get() {
    linkedList.append(10);
    linkedList.prepend(1);
    linkedList.append(20);

    assertEquals(1, linkedList.get(0));
    assertEquals(10, linkedList.get(1));
    assertEquals(20, linkedList.get(2));
  }

  @Test
  void firstIndexOf() {
    assertTrue(linkedList.firstIndexOf(10).isEmpty());

    linkedList.append(20);
    linkedList.prepend(10);
    linkedList.append(30);
    linkedList.append(20);

    assertEquals(1, linkedList.firstIndexOf(20).get());
    assertEquals(0, linkedList.firstIndexOf(10).get());

    assertTrue(linkedList.firstIndexOf(50).isEmpty());
  }
}
