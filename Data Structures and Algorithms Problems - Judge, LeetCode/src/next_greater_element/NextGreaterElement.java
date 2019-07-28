package next_greater_element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NextGreaterElement {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> nums1 = new ArrayList<>();
    List<Integer> nums2 = new ArrayList<>();

    stringTokenizer = new StringTokenizer(reader.readLine(), ",", false);
    while (stringTokenizer.hasMoreTokens()){
      nums1.add(Integer.parseInt(stringTokenizer.nextToken()));
    }
    stringTokenizer = new StringTokenizer(reader.readLine(), ",", false);
    while (stringTokenizer.hasMoreTokens()){
      nums2.add(Integer.parseInt(stringTokenizer.nextToken()));
    }

    Solution solution = new Solution();
    List<Integer> result = solution.nextGreaterElement(nums1, nums2);

    printOutput(result);
  }

  private static void printOutput(List<Integer> result) {
    StringBuilder builder = new StringBuilder();
    for (Integer num : result) {
      builder.append(num).append(",");
    }
    System.out.println(builder.deleteCharAt(builder.length() - 1));
  }
}
