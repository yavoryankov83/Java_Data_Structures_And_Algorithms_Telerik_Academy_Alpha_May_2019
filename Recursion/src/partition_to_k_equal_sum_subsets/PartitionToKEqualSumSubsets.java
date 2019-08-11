package partition_to_k_equal_sum_subsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PartitionToKEqualSumSubsets {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine(), ", ", false);
    int[] nums = new int[stringTokenizer.countTokens()];
    int counter = 0;
    int sum = 0;
    while (stringTokenizer.hasMoreTokens()) {
      nums[counter] = Integer.parseInt(stringTokenizer.nextToken());
      sum += nums[counter];
      counter++;
    }
    int k = Integer.parseInt(reader.readLine());

    int[] subset = new int[k];
    int targetSum = sum / k;
    Arrays.sort(nums);

    if (isPartitionExist(nums, k, nums.length - 1, subset, targetSum, sum)) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }
  }

  private static boolean isPartitionExist(int[] nums, int k, int start, int[] subset, int targetSum, int sum) {
    if (targetSum * k != sum) {
      return false;
    }
    if (start < 0) {
      return true;
    }
    for (int i = 0; i < k; i++) {
      if (i > 0 && subset[i - 1] == 0) {
        return false;
      }
      if (subset[i] + nums[start] <= targetSum) {
        subset[i] += nums[start];
        if (isPartitionExist(nums, k, start - 1, subset, targetSum, sum)) {
          return true;
        }
        subset[i] -= nums[start];
      }
    }
    return false;
  }
}
