package ds.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {
  private Stack<Integer> stack;

  @BeforeEach
  public void setup() {
    stack = new Stack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);


  }

  @Test
  void push() {
    assertEquals(3, stack.size());
  }

  @Test
  void pop() {
    final int actual = stack.pop();
    assertEquals(3, actual);
  }
}
