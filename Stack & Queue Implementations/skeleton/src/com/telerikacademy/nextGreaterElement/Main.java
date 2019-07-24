package com.telerikacademy.nextGreaterElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Integer[] nums1 = Arrays
            .stream(reader.readLine().
                    split(","))
            .map(Integer::parseInt)
            .toArray(Integer[]::new);

    Integer[] nums2 = Arrays
            .stream(reader.readLine().
                    split(","))
            .map(Integer::parseInt)
            .toArray(Integer[]::new);

    Solution solution = new Solution();
    int[] result = solution.nextGreaterElement(nums1, nums2);

    System.out.println(Arrays.toString(result));
  }
}
