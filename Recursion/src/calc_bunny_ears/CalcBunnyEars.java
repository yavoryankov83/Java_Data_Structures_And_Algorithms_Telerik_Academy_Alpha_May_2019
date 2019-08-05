package calc_bunny_ears;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcBunnyEars {
  private static final int BUNNY_EARS = 2;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int bunnyCount = Integer.parseInt(reader.readLine());
    System.out.println(calcBunnyEars(bunnyCount));
  }

  private static int calcBunnyEars(int numOfBunnies) {
    if (numOfBunnies == 0) {
      return 0;
    }
    return BUNNY_EARS + calcBunnyEars(numOfBunnies - 1);
  }
}
