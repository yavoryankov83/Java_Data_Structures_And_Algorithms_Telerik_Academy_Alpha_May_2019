package calc_bunny_ears_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcBunnyEars {
  private static final int TWO_EARS = 2;
  private static final int THREE_EARS = 3;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int bunnyCount = Integer.parseInt(reader.readLine());
    System.out.println(calcBunnyEars(bunnyCount));
  }

  private static int calcBunnyEars(int bunnyCount) {
    if (bunnyCount == 0) {
      return 0;
    }
    if (bunnyCount % 2 == 0) {
      return THREE_EARS + calcBunnyEars(bunnyCount - 1);
    } else {
      return TWO_EARS + calcBunnyEars(bunnyCount - 1);
    }
  }
}
