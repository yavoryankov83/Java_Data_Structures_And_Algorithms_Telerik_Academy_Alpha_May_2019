package jumps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Jumps {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    stringTokenizer = new StringTokenizer(reader.readLine());
    stringTokenizer = new StringTokenizer(reader.readLine());
    List<Integer> nums = new ArrayList<>();

    int maxNumber = 0;
    while (stringTokenizer.hasMoreTokens()) {
      int current = Integer.parseInt(stringTokenizer.nextToken());
      if (current > maxNumber) {
        maxNumber = current;
      }
      nums.add(current);
    }

    for (int i = 0; i < nums.size(); i++) {
      int current = nums.get(i);
      nums.set(i, 0);
      for (int j = i + 1; j < nums.size(); j++) {
        int next = nums.get(j);

        if (next > current) {
          nums.set(i, nums.get(i) + 1);
          current = next;
        }
        if (next == maxNumber) {
          break;
        }
      }
    }
    printOutput(nums);
  }

  private static void printOutput(List<Integer> nums) {
    int maxJumps = 0;
    StringBuilder builder = new StringBuilder();

    for (Integer num : nums) {
      if (num > maxJumps) {
        maxJumps = num;
      }
      builder.append(num).append(" ");
    }
    System.out.println(maxJumps);
    System.out.println(builder.toString().trim());
  }
}