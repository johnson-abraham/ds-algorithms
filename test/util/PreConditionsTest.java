package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.PreConditions.checkArgument;
import static util.PreConditions.checkIndexBounds;

public class PreConditionsTest {

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
