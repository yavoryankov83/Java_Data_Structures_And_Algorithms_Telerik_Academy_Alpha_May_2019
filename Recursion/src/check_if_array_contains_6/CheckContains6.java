package check_if_array_contains_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CheckContains6 {
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
    System.out.println(checkContains6(nums, index));
  }

  private static boolean checkContains6(int[] nums, int index) {
    if (index == nums.length) {
      return false;
    }
    if (nums[index] == 6) {
      return true;
    }
    return checkContains6(nums, index + 1);
  }
}
