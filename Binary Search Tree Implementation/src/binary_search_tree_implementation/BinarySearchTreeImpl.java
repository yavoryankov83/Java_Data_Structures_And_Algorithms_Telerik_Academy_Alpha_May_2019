package binary_search_tree_implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeImpl implements BinarySearchTree {
  private BinaryTreeNode root;

  @Override
  public BinaryTreeNode getRoot() {
    return root;
  }

  @Override
  public void insert(int value) {
    root = insertHelper(root, value);
  }

  private BinaryTreeNode insertHelper(BinaryTreeNode currentNode, int value) {
    if (currentNode == null) {
      currentNode = new BinaryTreeNode(value);
      return currentNode;
    }
    if (value < currentNode.getValue()) {
      currentNode.setLeftChild(insertHelper(currentNode.getLeftChild(), value));
    } else {
      currentNode.setRightChild(insertHelper(currentNode.getRightChild(), value));
    }
    return currentNode;
  }

  @Override
  public BinaryTreeNode search(int value) {
    return searchHelper(root, value);
  }

  private BinaryTreeNode searchHelper(BinaryTreeNode currentNode, int value) {
    if (currentNode == null || currentNode.getValue() == value) {
      return currentNode;
    }
    if (value < currentNode.getValue()) {
      return searchHelper(currentNode.getLeftChild(), value);
    } else {
      return searchHelper(currentNode.getRightChild(), value);
    }
  }

  @Override
  public List<Integer> inOrder() {
    List<Integer> result = new ArrayList<>();
    inOrderHelper(root, result);

    return result;
  }

  private void inOrderHelper(BinaryTreeNode currentNode, List<Integer> result) {
    if (currentNode == null) {
      return;
    }

    inOrderHelper(currentNode.getLeftChild(), result);
    result.add(currentNode.getValue());
    inOrderHelper(currentNode.getRightChild(), result);
  }

  @Override
  public List<Integer> postOrder() {
    List<Integer> result = new ArrayList<>();

    postOrderHelper(root, result);
    return result;
  }

  private void postOrderHelper(BinaryTreeNode currentNode, List<Integer> result) {
    if (currentNode == null) {
      return;
    }

    postOrderHelper(currentNode.getLeftChild(), result);
    postOrderHelper(currentNode.getRightChild(), result);
    result.add(currentNode.getValue());
  }

  @Override
  public List<Integer> preOrder() {
    List<Integer> result = new ArrayList<>();

    preOrderHelper(root, result);
    return result;
  }

  private void preOrderHelper(BinaryTreeNode currentNode, List<Integer> result) {
    if (currentNode == null) {
      return;
    }

    result.add(currentNode.getValue());
    preOrderHelper(currentNode.getLeftChild(), result);
    preOrderHelper(currentNode.getRightChild(), result);
  }

  @Override
  public List<Integer> bfs() {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }
    Queue<BinaryTreeNode> temp = new LinkedList<>();
    temp.offer(root);
    while (!temp.isEmpty()) {
      BinaryTreeNode current = temp.poll();
      result.add(current.getValue());
      addChildren(current, temp);
    }
    return result;
  }

  private void addChildren(BinaryTreeNode current, Queue<BinaryTreeNode> temp) {
    if (current.getLeftChild() != null) {
      temp.add(current.getLeftChild());
    }
    if (current.getRightChild() != null) {
      temp.add(current.getRightChild());
    }
  }

  @Override
  public int height() {
    return heightHelper(root);
  }

  private int heightHelper(BinaryTreeNode currentNode) {
    if (currentNode == null) {
      return -1;
    }
    int leftHeight = heightHelper(currentNode.getLeftChild());
    int rightHeight = heightHelper(currentNode.getRightChild());

    if (leftHeight > rightHeight) {
      return leftHeight + 1;
    } else {
      return rightHeight + 1;
    }
  }

  @Override
  public BinaryTreeNode remove(int value) {
    return removeHelper(root, value);
  }

  private BinaryTreeNode removeHelper(BinaryTreeNode currentNode, int value) {
    if (currentNode == null) {
      return currentNode;
    }
    /* Otherwise, recur down the tree */
    if (value < currentNode.getValue()) {
      currentNode.setLeftChild(removeHelper(currentNode.getLeftChild(), value));
    } else if (value > currentNode.getValue()) {
      currentNode.setRightChild(removeHelper(currentNode.getRightChild(), value));
    }
    // if key is same as root's key, then This is the node
    // to be deleted
    else {
      // node with only one child or no child
      if (currentNode.getLeftChild() == null) {
        return currentNode.getRightChild();
      } else if (currentNode.getRightChild() == null) {
        return currentNode.getLeftChild();
      }
      // node with two children: Get the inorder successor (smallest
      // in the right subtree)
      currentNode.setValue(getMinValue(currentNode.getRightChild()));
      // Delete the inorder successor
      currentNode.setRightChild(removeHelper(currentNode.getRightChild(), currentNode.getValue()));
    }
    return currentNode;
  }

  int getMinValue(BinaryTreeNode currentNode) {
    int minValue = currentNode.getValue();
    while (currentNode.getLeftChild() != null) {
      minValue = currentNode.getLeftChild().getValue();
      currentNode = currentNode.getLeftChild();
    }
    return minValue;
  }
}
