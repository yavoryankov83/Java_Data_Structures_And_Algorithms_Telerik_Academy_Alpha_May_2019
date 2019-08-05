package print_stars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStars {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int maxNum = Integer.parseInt(reader.readLine());
    printStars(maxNum);
  }

  //from 1 to numberOfStars
  private static void printStars(int maxNum) {
    if (maxNum == 1) {
      System.out.print("* ");
      return;
    }
    printStars(maxNum - 1);
    System.out.print("* ");
  }
}
