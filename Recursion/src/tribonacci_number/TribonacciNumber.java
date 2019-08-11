package tribonacci_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TribonacciNumber {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(reader.readLine());
    System.out.println(calcTribonnacci(num));
  }

  private static long calcTribonnacci(int num) {
    if (num == 0) {
      return 0;
    } else if (num == 1 || num == 2) {
      return 1;
    } else {
      long[] memoization = new long[num + 1];
      memoization[0] = 0;
      memoization[1] = 1;
      memoization[2] = 1;

      for (int i = 3; i <= num; i++) {
        memoization[i] = memoization[i - 1] + memoization[i - 2] + memoization[i - 3];
      }
      return memoization[num];
    }
  }
}
