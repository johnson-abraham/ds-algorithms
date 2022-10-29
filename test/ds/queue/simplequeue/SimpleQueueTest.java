package ds.queue.simplequeue;

import ds.queue.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleQueueTest {

  private Queue<Integer> queue;

  @BeforeEach
  public void setup() {
    queue = new SimpleQueue<>();
  }

  @Test
  void push() {
    queue.push(1);
    queue.push(2);

    assertEquals(2, queue.size());
  }

  @Test
  void pop() {
    queue.push(1);
    queue.push(2);

    assertEquals(2, queue.size());
    assertEquals(1, queue.pop());
    assertEquals(1, queue.size());
  }

  @Test
  void peekHead() {
    assertEquals(Optional.empty(), queue.peekHead());

    queue.push(10);
    queue.push(20);

    assertEquals(10, queue.peekHead().get());
  }

  @Test
  void peekTail() {
    assertEquals(Optional.empty(), queue.peekTail());

    queue.push(10);
    queue.push(20);
    queue.push(30);
    queue.push(40);

    assertEquals(40, queue.peekTail().get());
  }

  @Test
  void size() {
    assertEquals(0, queue.size());

    queue.push(10);
    queue.push(20);
    queue.push(30);
    queue.push(40);

    assertEquals(4, queue.size());

    queue.pop();

    assertEquals(3, queue.size());
  }
}
