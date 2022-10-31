package ds.linkedlist.singlylinkedlist;

import ds.linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static java.util.Optional.ofNullable;
import static util.PreCondition.checkArgument;
import static util.PreCondition.checkIndexBounds;

public class SinglyLinkedList<T extends Comparable<T>> implements LinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int length;

  @Override
  public int prepend(T value) {
    return add(value, newNode -> {
      newNode.setNext(head);
      head = newNode;
    });
  }

  @Override
  public int append(T value) {
    return add(value, newNode -> {
      tail.setNext(newNode);
      tail = newNode;
    });
  }

  @Override
  public int insertAt(int index, T value) throws IndexOutOfBoundsException {
    checkIndexBounds(index < 0, "index should be >= 0");
    checkIndexBounds((index > 0) && (length == 0), "list is empty");
    checkIndexBounds(index > length, "index should be between 0 and " + length);

    if (index == 0) {
      return prepend(value);
    } else if (index == length) {
      return append(value);
    } else {
      return addAt(index, value);
    }
  }

  @Override
  public T remove(int index) throws IndexOutOfBoundsException {
    checkIndexBounds(length == 0, "list is empty");
    checkIndexBounds(index < 0, "index should be >= 0");
    checkIndexBounds(index >= length, "index should be between 0 and " + (length - 1));

    Node<T> nodeToBeRemoved;

    if (index == 0) {
      nodeToBeRemoved = head;
      head = head.getNext();
    } else {
      final Node<T> previous = getNodeBefore(index);
      nodeToBeRemoved = previous.getNext();
      previous.setNext(nodeToBeRemoved.getNext());
    }

    --length;

    return nodeToBeRemoved.getValue();
  }

  @Override
  public List<T> values() {
    final List<T> values = new ArrayList<>(length);

    if (length > 0) {
      Node<T> currentNode = head;

      while (currentNode != null) {
        values.add(currentNode.getValue());
        currentNode = currentNode.getNext();
      }
    }

    return values;
  }

  @Override
  public Optional<T> peekHead() {
    return ofNullable(head).map(Node::getValue);
  }

  @Override
  public Optional<T> peekTail() {
    return ofNullable(tail).map(Node::getValue);
  }

  @Override
  public T get(int index) throws IndexOutOfBoundsException {
    checkIndexBounds(length == 0, "list is empty");
    checkIndexBounds(index < 0, "index should be >= 0");
    checkIndexBounds(index >= length, "index should be between 0 and " + (length - 1));

    return index == 0 ? head.getValue() : getNodeBefore(index).getNext().getValue();
  }

  @Override
  public Optional<Integer> firstIndexOf(T value) {
    if (length > 0) {
      int index = 0;
      Node<T> node = head;

      while (node != null) {
        if (node.getValue().compareTo(value) == 0) {
          return Optional.of(index);
        }
        ++index;
        node = node.getNext();
      }
    }

    return Optional.empty();
  }

  @Override
  public int size() {
    return length;
  }

  @Override
  public void reverse() {
    if (length > 1) {
      final Node<T> currentHead = head;
      head = reverse(head);
      tail = currentHead;
    }
  }

  private int add(T value, Consumer<Node<T>> addPosition) {
    final Node<T> newNode = new Node<>(value);

    if (length == 0) {
      head = tail = newNode;
    } else {
      addPosition.accept(newNode);
    }

    return ++length;
  }

  private int addAt(int index, T value) {
    final Node<T> previousNode = getNodeBefore(index);
    final Node<T> newNode = new Node<>(value);

    newNode.setNext(previousNode.getNext());
    previousNode.setNext(newNode);

    return ++length;
  }

  private Node<T> getNodeBefore(int index) {
    checkArgument(index <= 0, "Illegal index");

    Node<T> node = head;

    for (int i = 0; i < index - 1; i++) {
      node = node.getNext();
    }

    return node;
  }

  private Node<T> reverse(Node<T> headNode) {
    if (headNode == null || headNode.getNext() == null) return headNode;

    final Node<T> rest = reverse(headNode.getNext());
    headNode.getNext().setNext(headNode);
    headNode.setNext(null);

    return rest;
  }
}
