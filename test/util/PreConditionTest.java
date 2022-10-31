package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.PreCondition.checkArgument;
import static util.PreCondition.checkIndexBounds;

public class PreConditionTest {

  @Test
  void illegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> {
      checkArgument(true, "Exception");
    });
  }

  @Test
  void indexOutOfBoundsException() {
    assertThrows(IndexOutOfBoundsException.class, () -> {
      checkIndexBounds(true, "Exception");
    });
  }
}
