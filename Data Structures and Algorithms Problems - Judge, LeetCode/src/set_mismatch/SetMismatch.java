package set_mismatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SetMismatch {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine(), ",", false);
    int[] nums = new int[stringTokenizer.countTokens()];
    Map<Integer, Integer> map = new HashMap<>();
    int[] result = new int[2];
    int counter = 0;
    while (stringTokenizer.hasMoreTokens()) {
      nums[counter] = Integer.parseInt(stringTokenizer.nextToken());
      counter++;
    }

    for (int i = 0; i < nums.length; i++) {
      int currentNum = nums[i];
      if (map.containsKey(currentNum)) {
        result[0] = nums[i];
      } else {
        map.put(currentNum, 1);
      }
    }
    for (int i = 1; i <= nums.length; i++) {
      if (!map.containsKey(i)) {
        result[1] = i;
      }
    }
    System.out.println(Arrays.toString(result));
  }
}
