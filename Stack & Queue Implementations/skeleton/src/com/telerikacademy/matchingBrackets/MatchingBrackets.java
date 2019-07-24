package com.telerikacademy.matchingBrackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MatchingBrackets {
  private static final char OPEN_BRACKET = '(';
  private static final char CLOSE_BRACKET = ')';

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5
    String expression = reader.readLine();

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) == OPEN_BRACKET) {
        stack.push(i);
      } else if (expression.charAt(i) == CLOSE_BRACKET) {
        System.out.println(expression.substring(stack.pop(), i + 1));
      }
    }
  }
}
