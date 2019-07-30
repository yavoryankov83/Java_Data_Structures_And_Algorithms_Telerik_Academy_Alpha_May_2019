package backspace_string_compare;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  private static final char BACKSPACE_SYMBOL = '#';

  boolean backspaceCompare(String firstString, String secondString) {
    String first = getString(firstString);
    String second = getString(secondString);

    return first.compareTo(second) == 0;
  }

  private String getString(String firstString) {
    Deque<Character> stack = new ArrayDeque<>();
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < firstString.length(); i++) {
      if (firstString.charAt(i) == BACKSPACE_SYMBOL && !stack.isEmpty()) {
        stack.pop();
      } else if (firstString.charAt(i) != BACKSPACE_SYMBOL) {
        stack.push(firstString.charAt(i));
      }
    }
    if (stack.isEmpty()) {
      builder.append("0");
      return builder.toString();
    } else {
      while (!stack.isEmpty()) {
        builder.append(stack.getFirst());
        return builder.toString();
      }
    }
    return "";
  }
}
