package calc_num_of_blocks_in_triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcBlocksCount {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int rowsCount = Integer.parseInt(reader.readLine());
    System.out.println(calcBlocksCount(rowsCount));
  }

  private static int calcBlocksCount(int rowsCount) {
    if (rowsCount == 0) {
      return 0;
    }
    return rowsCount + calcBlocksCount(rowsCount - 1);
  }
}
