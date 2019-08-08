package binary_search_tree_implementation;

import java.util.List;

public interface BinarySearchTree {
  BinaryTreeNode getRoot();

  void insert(int value);

  BinaryTreeNode search(int value);

  List<Integer> inOrder();

  List<Integer> postOrder();

  List<Integer> preOrder();

  List<Integer> bfs();

  int height();

  BinaryTreeNode remove(int value);
}
