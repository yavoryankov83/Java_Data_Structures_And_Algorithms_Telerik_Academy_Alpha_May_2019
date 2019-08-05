package check_if_array_contains_value_10_times;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CheckIfContains {
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
    System.out.println(checkIfContains(nums, index));
  }

  private static boolean checkIfContains(int[] nums, int index) {
    if (index == nums.length - 1) {
      return false;
    }
    if (nums[index + 1] == nums[index] * 10){
      return true;
    }
    return checkIfContains(nums, index + 1);
  }
}

