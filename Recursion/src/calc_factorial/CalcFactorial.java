package calc_factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcFactorial {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(reader.readLine());
    System.out.println(calcFactorial(num));
  }

  private static int calcFactorial(int num) {
    if (num == 1) {
      return 1;
    }
    return num * calcFactorial(num - 1);
  }
}
