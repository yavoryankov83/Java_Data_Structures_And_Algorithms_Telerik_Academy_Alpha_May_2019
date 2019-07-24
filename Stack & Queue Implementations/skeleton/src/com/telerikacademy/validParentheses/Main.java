package com.telerikacademy.validParentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String expression = reader.readLine();

    Solution solution = new Solution();

    boolean validParantheses = solution.isValidParantheses(expression);

    System.out.println(validParantheses);
  }
}
