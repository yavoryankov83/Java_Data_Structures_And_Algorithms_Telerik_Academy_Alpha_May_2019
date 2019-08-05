package hailstone_task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HailstoneTask {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(reader.readLine());
    getHailstoneNumbers(num);
  }

  private static void getHailstoneNumbers(int number) {
    if (number == 1) {
      System.out.print(1 + " ");
      return;
    }
    if (number % 2 == 0) {
      System.out.print(number + " ");
      getHailstoneNumbers(number / 2);

    }
    if (number % 2 != 0) {
      System.out.print(number + " ");
      getHailstoneNumbers(3 * number + 1);

    }
  }
}
