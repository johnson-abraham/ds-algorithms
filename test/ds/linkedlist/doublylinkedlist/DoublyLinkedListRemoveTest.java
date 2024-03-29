package ds.linkedlist.doublylinkedlist;

import ds.linkedlist.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoublyLinkedListRemoveTest {

  private LinkedList<Integer> linkedList;

  @BeforeEach
  void setup() {
    linkedList = new DoublyLinkedList<>();
  }

  @Test
  void exceptionIfEmptyList() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      linkedList.remove(0);
    });
  }

  @Test
  void exceptionIfIndexIsNegative() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      linkedList.append(10);

      linkedList.remove(-1);
    });
  }

  @Test
  void exceptionIfIndexOutOfBounds() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      linkedList.append(20);
      linkedList.prepend(10);

      linkedList.remove(2);
    });
  }

  @Test
  void remove() {
    linkedList.append(10);
    linkedList.prepend(0);
    linkedList.append(20);
    linkedList.append(30);

    assertEquals(4, linkedList.size());

    final int removedValue = linkedList.remove(2);
    assertEquals(removedValue, 20);

    assertEquals(3, linkedList.size());
  }

  @Test
  void removeHead() {
    linkedList.append(10);
    linkedList.prepend(0);
    linkedList.append(20);
    linkedList.append(30);

    assertEquals(4, linkedList.size());

    final int removedValue = linkedList.remove(0);
    assertEquals(removedValue, 0);

    assertEquals(3, linkedList.size());
  }

  @Test
  void removeTail() {
    linkedList.append(10);
    linkedList.prepend(0);
    linkedList.append(20);
    linkedList.append(30);

    assertEquals(4, linkedList.size());

    final int removedValue = linkedList.remove(3);
    assertEquals(removedValue, 30);

    assertEquals(3, linkedList.size());
  }
}
