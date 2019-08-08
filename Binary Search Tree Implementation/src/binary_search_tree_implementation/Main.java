package binary_search_tree_implementation;

public class Main {
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTreeImpl();
    //20, 30, 40, 50, 60, 70, 71, 72, 80
    tree.insert(20);
    tree.insert(30);
    tree.insert(40);
    tree.insert(50);
    tree.insert(60);
    tree.insert(70);
    tree.insert(71);
    tree.insert(72);
    tree.insert(80);

    System.out.println(tree.inOrder());
  }
}
