package valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  private static final char OPEN_BRACKET_TYPE_1 = '(';
  private static final char OPEN_BRACKET_TYPE_2 = '[';
  private static final char OPEN_BRACKET_TYPE_3 = '{';
  private static final char CLOSE_BRACKET_TYPE_1 = ')';
  private static final char CLOSE_BRACKET_TYPE_2 = ']';
  private static final char CLOSE_BRACKET_TYPE_3 = '}';

  boolean isValidParantheses(String expression) {
    Deque<Character> stack = new ArrayDeque<>();

    boolean isValid = true;

    for (int i = 0; i < expression.length(); i++) {
      char current = expression.charAt(i);
      if (current == OPEN_BRACKET_TYPE_1 ||
              current == OPEN_BRACKET_TYPE_2 ||
              current == OPEN_BRACKET_TYPE_3) {
        stack.push(current);
      } else if (current == CLOSE_BRACKET_TYPE_1 ||
              current == CLOSE_BRACKET_TYPE_2 ||
              current == CLOSE_BRACKET_TYPE_3) {

        if (stack.isEmpty()) {
          isValid = false;
          return isValid;
        } else {
          char popedChar = stack.pop();

          if (!isMatchingBrackets(popedChar, current)) {
            isValid = false;
            return isValid;
          }
        }
      }
    }
    if (!stack.isEmpty()) {
      isValid = false;
    }

    return isValid;
  }

  private static boolean isMatchingBrackets(char openBracket, char closeBracket) {
    if (openBracket == OPEN_BRACKET_TYPE_1 && closeBracket == CLOSE_BRACKET_TYPE_1) {
      return true;
    } else if (openBracket == OPEN_BRACKET_TYPE_2 && closeBracket == CLOSE_BRACKET_TYPE_2) {
      return true;
    } else return openBracket == OPEN_BRACKET_TYPE_3 && closeBracket == CLOSE_BRACKET_TYPE_3;
  }
}
