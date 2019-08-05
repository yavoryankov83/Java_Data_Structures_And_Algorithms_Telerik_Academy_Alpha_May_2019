package calc_occurrences_of_hi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcOccurrences {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    System.out.println(calcOccurrences(input));
  }

  private static int calcOccurrences(String input) {
    if (input.length() == 0 || input.length() == 1) {
      return 0;
    }
    if (input.length() == 2) {
      if (input.equals("hi")) {
        return 1;
      } else {
        return 0;
      }
    }
    String lastSymbols = input.substring(input.length() - 2);
    String lastPart = input.substring(0, input.length() - 1);

    return calcOccurrences(lastSymbols) + calcOccurrences(lastPart);
  }
}
