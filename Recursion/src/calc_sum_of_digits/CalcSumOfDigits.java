package calc_sum_of_digits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcSumOfDigits {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(reader.readLine());
    System.out.println(calcSumOfDigits(num));
  }

  private static int calcSumOfDigits(int num) {
    if (num < 10) {
      return num;
    }
    return num % 10 + calcSumOfDigits(num / 10);
  }
}
