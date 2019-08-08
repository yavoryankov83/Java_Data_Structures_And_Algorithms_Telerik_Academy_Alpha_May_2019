package hdnl_toy;

import java.util.Scanner;
import java.util.Stack;

public class HDNLToy1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tagsCount = Integer.parseInt(scanner.nextLine());

    Stack<Character> openedTagsSymbols = new Stack<>();
    Stack<Integer> openedTagsRanks = new Stack<>();
    StringBuilder indentation = new StringBuilder();
    StringBuilder output = new StringBuilder();

    for (int i = 0; i < tagsCount; i++) {
      String nextTag = scanner.nextLine();
      char nextTagSymbol = nextTag.charAt(0);
      int nextTagRank = Integer.parseInt(nextTag.substring(1));

      while (!openedTagsRanks.isEmpty() && openedTagsRanks.peek() >= nextTagRank) {
        closeTag(openedTagsSymbols, openedTagsRanks, indentation, output);
      }

      openTag(indentation, output, nextTagSymbol, nextTagRank);

      openedTagsSymbols.push(nextTagSymbol);
      openedTagsRanks.push(nextTagRank);
      indentation.append(" ");
    }

    while (!openedTagsRanks.isEmpty()) {
      closeTag(openedTagsSymbols, openedTagsRanks, indentation, output);
    }

    System.out.println(output);
  }

  private static void openTag(
          StringBuilder indentation,
          StringBuilder output,
          char nextTagSymbol,
          int nextTagRank) {
    output.append(String.format(
            "%s<%c%d>%n",
            indentation,
            nextTagSymbol,
            nextTagRank));
  }

  private static void closeTag(
          Stack<Character> openedTagsSymbols,
          Stack<Integer> openedTagsRanks,
          StringBuilder indentation,
          StringBuilder output) {
    indentation.deleteCharAt(0);
    output.append(String.format(
            "%s</%c%d>%n",
            indentation,
            openedTagsSymbols.pop(),
            openedTagsRanks.pop()));
  }
}
