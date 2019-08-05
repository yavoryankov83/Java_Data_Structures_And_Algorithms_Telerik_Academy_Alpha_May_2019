package print_nums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintNums {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int maxNum = Integer.parseInt(reader.readLine());
    printNums(maxNum);
  }

  //from 1 to maxNum
  private static void printNums(int maxNum) {
    if (maxNum == 1) {
      System.out.print(1 + " ");
      return;
    }
    printNums(maxNum - 1);
    System.out.print(maxNum + " ");
  }
}
