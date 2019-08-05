package calc_occurrences_of_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CalcOccurrences {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    stringTokenizer = new StringTokenizer(reader.readLine(), ",", false);
    int[] nums = new int[stringTokenizer.countTokens()];
    while (stringTokenizer.hasMoreTokens()) {
      for (int i = 0; i < nums.length; i++) {
        nums[i] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }

    int index = Integer.parseInt(reader.readLine());
    System.out.println(calcOccurrences(nums, index));
  }

  private static int calcOccurrences(int[] nums, int index) {
    if (index == nums.length - 1) {
      if (nums[index] == 11) {
        return 1;
      } else {
        return 0;
      }
    }
    if (nums[index] == 11) {
      return 1 + calcOccurrences(nums, index + 1);
    }
    return calcOccurrences(nums, index + 1);
  }
}

