package n_repeated_element_in_size_2n_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NRepeatedElementInSize2NArray {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine(), ",", false);
    int[] nums = new int[stringTokenizer.countTokens()];
    Set<Integer> set = new HashSet<>();
    int counter = 0;
    while (stringTokenizer.hasMoreTokens()) {
      nums[counter] = Integer.parseInt(stringTokenizer.nextToken());
      counter++;
    }
    int result = 0;
    for (int num : nums) {
      if (!set.add(num)) {
        result = num;
      }
    }
    System.out.println(result);
  }
}
