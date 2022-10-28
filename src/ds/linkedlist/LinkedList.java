package ds.linkedlist;

import java.util.List;
import java.util.Optional;

public interface LinkedList<T extends Comparable<T>> {
  int prepend(T value);

  int append(T value);

  int insertAt(int index, T value) throws IndexOutOfBoundsException;

  T remove(int index) throws IndexOutOfBoundsException;

  List<T> values();

  Optional<T> peekHead();

  Optional<T> peekTail();

  T get(int index) throws IndexOutOfBoundsException;

  Optional<Integer> firstIndexOf(T value);

  int size();

  void reverse();
}
