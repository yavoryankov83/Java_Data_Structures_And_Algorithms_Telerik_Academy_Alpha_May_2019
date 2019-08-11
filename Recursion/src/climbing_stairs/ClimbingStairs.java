package climbing_stairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int stairsCount = Integer.parseInt(reader.readLine());

    System.out.println(countWaysToMove(stairsCount));
  }

  private static int countWaysToMove(int stairsCount) {
    if (stairsCount == 1){
      return 1;
    } else if (stairsCount == 2){
      return 2;
    } else {
      int[] memoization = new int[stairsCount + 1];
      memoization[0] = 0;
      memoization[1] = 1;
      memoization[2] = 2;
      for (int i = 3; i <= stairsCount; i++) {
        memoization[i] = memoization[i - 1] + memoization[i -2];
      }
      return memoization[stairsCount];
    }
  }
}
