package hdnl_toy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
    int countOfTags = Integer.parseInt(stringTokenizer.nextToken());

    Deque<Character> openedTagsSymbols = new ArrayDeque<>();
    Deque<Integer> openedTagsWeights = new ArrayDeque<>();
    StringBuilder builder = new StringBuilder();
    String nestedLevel = "";

    for (int i = 0; i < countOfTags; i++) {
      StringTokenizer stringTokenizer1 = new StringTokenizer(reader.readLine());
      String currentTag = stringTokenizer1.nextToken();

      char currentTagSymbol = currentTag.charAt(0);
      int currentTagWeight = Integer.parseInt(currentTag.substring(1));

      while (!openedTagsWeights.isEmpty() && openedTagsWeights.peek() >= currentTagWeight) {
        nestedLevel = nestedLevel.substring(1);
        builder.append(String.format("%s</%c%d>%n",
                nestedLevel,
                openedTagsSymbols.pop(),
                openedTagsWeights.pop()));
      }

      builder.append(String.format("%s<%c%d>%n",
              nestedLevel,
              currentTagSymbol,
              currentTagWeight));
      openedTagsSymbols.push(currentTagSymbol);
      openedTagsWeights.push(currentTagWeight);
      nestedLevel += " ";
    }
    while (!openedTagsWeights.isEmpty()) {
      nestedLevel = nestedLevel.substring(1);
      builder.append(String.format("%s</%c%d>%n",
              nestedLevel,
              openedTagsSymbols.pop(),
              openedTagsWeights.pop()));
    }

    System.out.println(builder);
  }
}
