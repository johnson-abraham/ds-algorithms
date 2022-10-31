package util;

public class PreCondition {
  public static void checkArgument(boolean failureCondition, String exceptionMessage) {
    if (failureCondition) {
      throw new IllegalArgumentException(exceptionMessage);
    }
  }

  public static void checkIndexBounds(boolean failureCondition, String exceptionMessage) {
    if (failureCondition) {
      throw new IndexOutOfBoundsException(exceptionMessage);
    }
  }
}
