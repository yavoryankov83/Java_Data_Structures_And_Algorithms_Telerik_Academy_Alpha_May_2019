package binary_search_tree_implementation;

public class BinaryTreeNode {
  private int value;
  private BinaryTreeNode leftChild;
  private BinaryTreeNode rightChild;

  void setLeftChild(BinaryTreeNode leftChild) {
    this.leftChild = leftChild;
  }

  void setRightChild(BinaryTreeNode rightChild) {
    this.rightChild = rightChild;
  }

  BinaryTreeNode(int value) {
    this.value = value;
  }

  void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public BinaryTreeNode getLeftChild() {
    return leftChild;
  }

  public BinaryTreeNode getRightChild() {
    return rightChild;
  }

}
