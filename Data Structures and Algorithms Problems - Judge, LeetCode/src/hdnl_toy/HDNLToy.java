package hdnl_toy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class HDNLToy {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int countOfLines = Integer.parseInt(reader.readLine());

    String[] tags = new String[countOfLines];
    int[] nums = new int[countOfLines];

    StringBuilder result = new StringBuilder();
    Deque<Tag> stack = new ArrayDeque<>();

    for (int i = 0; i < countOfLines; i++) {
      String currentLine = reader.readLine();
      StringBuilder builder = new StringBuilder(currentLine);

      int currentNumber = Integer.parseInt((builder.deleteCharAt(0).toString()));
      tags[i] = currentLine;
      nums[i] = currentNumber;
    }

    int currentValue = nums[0];
    int nestedLevel = 0;

    printOpenTag(nestedLevel, tags[0], result);
    stack.push(new Tag(tags[0], nums[0], nestedLevel));

    for (int i = 1; i < countOfLines; i++) {
      if (nums[i] > currentValue) {
        currentValue = nums[i];
        nestedLevel++;
        printOpenTag(nestedLevel, tags[i], result);
        stack.push(new Tag(tags[i], nums[i], nestedLevel));
      } else {
        currentValue = nums[i];
        while (!stack.isEmpty() && currentValue <= stack.peek().getValue()) {
          Tag newTag = stack.pop();
          printCloseTag(newTag.getNestedLevel(), newTag.getTag(), result);
          if (currentValue < newTag.getValue()) {
            nestedLevel--;
            nestedLevel = Math.max(nestedLevel, 0);
          }
        }
        printOpenTag(nestedLevel, tags[i], result);
        stack.push(new Tag(tags[i], nums[i], nestedLevel));
      }
    }
    while (!stack.isEmpty()) {
      Tag newTag = stack.pop();
      printCloseTag(newTag.getNestedLevel(), newTag.getTag(), result);
    }
    System.out.print(result);
  }

  private static void printCloseTag(int nestedLevel, String tag, StringBuilder builder) {
    String spaces = String.join("", Collections.nCopies(nestedLevel, " "));
    builder.append(spaces).append("<").append("/").append(tag).append(">").append(System.lineSeparator());
  }

  private static void printOpenTag(int nestedLevel, String tag, StringBuilder builder) {
    String spaces = String.join("", Collections.nCopies(nestedLevel, " "));
    builder.append(spaces).append("<").append(tag).append(">").append(System.lineSeparator());
  }

  static class Tag {
    private String tag;
    private int value;
    private int nestedLevel;

    Tag(String tag, int value, int nestedLevel) {
      this.tag = tag;
      this.value = value;
      this.nestedLevel = nestedLevel;
    }

    int getValue() {
      return value;
    }

    int getNestedLevel() {
      return nestedLevel;
    }

    String getTag() {
      return tag;
    }
  }
}
