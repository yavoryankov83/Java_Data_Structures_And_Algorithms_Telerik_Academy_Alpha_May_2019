package sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequenceBruteForce {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] nums = reader.readLine().split(" ");
    int k = Integer.parseInt(nums[0]);
    int n = Integer.parseInt(nums[1]);

    System.out.println(getNthNumber(k, n));
  }

  private static int getNthNumber(int k, int n) {
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      return k + 1;
    }
    if (n == 3) {
      return 2 * k + 1;
    }
    if (n == 4) {
      return k + 2;
    }
    if (n == 5) {
      return k + 2;
    }
    if (n == 6) {
      return 2 * k + 3;
    }
    if (n == 7) {
      return k + 3;
    }
    if (n == 8) {
      return 2 * k + 2;
    }
    if (n == 9) {
      return 2 * k + 7;
    }
    if (n == 10) {
      return 2 * k + 3;
    }
    if (n == 11) {
      return k + 3;
    }
    if (n == 12) {
      return 2 * k + 5;
    }
    if (n == 13) {
      return k + 4;
    }
    if (n == 14) {
      return k + 3;
    }
    if (n == 15) {
      return 2 * k + 5;
    }
    if (n == 16) {
      return k + 4;
    }
    if (n == 17) {
      return 2 * k + 4;
    }
    if (n == 18) {
      return 2 * k + 11;
    }
    if (n == 19) {
      return 2 * k + 5;
    }
    if (n == 20) {
      return k + 4;
    }
    if (n == 21) {
      return 2 * k + 7;
    }
    if (n == 22) {
      return k + 5;
    }
    if (n == 23) {
      return 2 * k + 2;
    }
    if (n == 24) {
      return 4 * k + 3;
    }
    if (n == 25) {
      return 2 * k + 3;
    } else {
      return n;
    }
  }
}
