package calc_fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcFibonacci {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(reader.readLine());
    System.out.println(calcFibonacci_2(num));
  }

  private static long calcFibonacci(int num) {
    if (num < 0) {
      throw new IllegalArgumentException("Number should'n be negative.");
    }
    if (num == 0) {
      return 0;
    }
    if (num == 1) {
      return 1;
    }
    long[] memoization = new long[num + 1];
    memoization[0] = 0;
    memoization[1] = 1;

    for (int i = 2; i <= num; i++) {
      memoization[i] = memoization[i - 1] + memoization[i - 2];
    }
    return memoization[num - 1] + memoization[num - 2];
  }

  private static long calcFibonacci_2(int num) {
    long[] memoization = new long[num + 1];
    return calcFibonacci_2(num, memoization);
  }

  private static long calcFibonacci_2(int num, long[] memoization) {
    if (memoization[num] == 0) {
      if (num == 0 || num == 1) {
        memoization[num] = num;
      } else {
        memoization[num] = calcFibonacci_2(num - 1, memoization)
                + calcFibonacci_2(num - 2, memoization);
      }
    }
    return memoization[num];
  }

  private static long calcFibonacci_3(int num) {
    if (num == 0 || num == 1) {
      return num;
    }

    int previous = 0;
    int current = 1;

    for (int i = 2; i <= num; i++) {
      int next = current + previous;
      previous = current;
      current = next;
    }
    return current;
  }
}