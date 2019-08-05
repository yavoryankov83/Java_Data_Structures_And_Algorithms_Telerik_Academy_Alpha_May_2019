package calc_occurrences_of_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcOccurrences {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(reader.readLine());
    System.out.println(calcOccurrences(num));
  }

  private static int calcOccurrences(int num) {
    if (num < 10) {
      if (num == 7) {
        return 1;
      }
      return 0;
    }
    return calcOccurrences(num % 10) + calcOccurrences(num / 10);
  }
}
