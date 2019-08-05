package calc_occurrences_of_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcOccurrences {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    System.out.println(calcOccurrences(n));
  }

  private static int calcOccurrences(int n) {
    if (n < 10) {
      if (n == 8) {
        return 1;
      }
      return 0;
    }
    int lastDigit = n % 10;
    int firstPart = n / 10;
    if (lastDigit == firstPart % 10) {
      return 1 + calcOccurrences(lastDigit) + calcOccurrences(firstPart);
    }
    return calcOccurrences(lastDigit) + calcOccurrences(firstPart);
  }
}
