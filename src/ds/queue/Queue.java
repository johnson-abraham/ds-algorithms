package ds.queue;

import java.util.Optional;

public interface Queue<T extends Comparable<T>> {
  int push(T value);

  T pop();

  Optional<T> peekHead();

  Optional<T> peekTail();

  int size();
}
