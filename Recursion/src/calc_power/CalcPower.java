package calc_power;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcPower {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(reader.readLine());
    int power = Integer.parseInt(reader.readLine());
    System.out.println(calcPower(num, power));
  }

  private static int calcPower(int number, int power) {
    if (power == 0) {
      return 1;
    }
    return number * calcPower(number, power - 1);
  }
}
