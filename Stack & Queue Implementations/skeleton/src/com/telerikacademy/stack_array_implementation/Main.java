package com.telerikacademy.stack_array_implementation;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new StackImpl<>();
    stack.push(5);
    stack.push(11);
    stack.push(3);

    System.out.println(stack.pop());
  }
}
