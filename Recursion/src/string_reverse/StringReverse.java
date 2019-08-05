package string_reverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverse {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    System.out.println(stringReverse(input));
  }

  private static String stringReverse(String input) {
    if (input.length() < 2) {
      return input;
    }
    char lastSymbol = input.charAt(input.length() - 1);
    String lastPart = input.substring(0, input.length() - 1);

    return lastSymbol + stringReverse(lastPart);
  }
}
