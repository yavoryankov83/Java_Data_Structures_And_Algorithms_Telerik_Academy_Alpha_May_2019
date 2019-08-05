package replace_occurrences_of_pi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceOccurrences {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    System.out.println(replaceOccurrences(input));
  }

  private static String replaceOccurrences(String input) {
    if (input.length() < 2) {
      return input;
    }
    int indexOfTarget = input.indexOf("pi");
    if (indexOfTarget < 0) {
      return input;
    }
    String firstPart = input.substring(0, indexOfTarget);
    String replacement = "3.14";
    int targetLength = "pi".length();
    String lastPart = input.substring(indexOfTarget + targetLength);

    return replaceOccurrences(firstPart + replacement + lastPart);
  }
}
