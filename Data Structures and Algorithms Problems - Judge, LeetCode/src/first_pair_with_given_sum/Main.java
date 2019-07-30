package first_pair_with_given_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Set<Integer> nums = new HashSet<>();
    StringBuilder builder = new StringBuilder();

    //12, 2, 6, 14, 8, 1, 5, 3, 12, 5
    //13
    stringTokenizer = new StringTokenizer(reader.readLine(), ", ", false);
    while (stringTokenizer.hasMoreTokens()) {
      nums.add(Integer.parseInt(stringTokenizer.nextToken()));
    }

    stringTokenizer = new StringTokenizer(reader.readLine());
    int sum = Integer.parseInt(stringTokenizer.nextToken());

    for (Integer integer : nums) {
      if (nums.contains(sum - integer)) {
        builder.append(String.format("(%d, %d)", integer, sum - integer));
        break;
      }
    }

    System.out.println(builder);
  }
}
