package main.binarysearchtree;

public class Main {

  public static void main(String[] args) {
    final var tree = new Tree<Integer>();
    tree.insert(25);
    tree.insert(20);
    tree.insert(15);
    tree.insert(27);
    tree.insert(30);
    tree.insert(19);
    tree.insert(26);
    tree.insert(22);
    tree.insert(32);

    // tree.traverseInOrder();

    System.out.println(tree.get(26));
    System.out.println(tree.get(40));
  }
}
