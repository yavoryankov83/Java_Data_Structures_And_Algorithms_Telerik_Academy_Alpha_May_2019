package lemonade_change;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LemonadeChange {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine(), ",", false);
    List<Integer> bills = new ArrayList<>();

    while (stringTokenizer.hasMoreTokens()) {
      bills.add(Integer.parseInt(stringTokenizer.nextToken()));
    }

    Solution solution = new Solution();
    boolean result = solution.lemonadeChange(bills);

    System.out.println(result);
  }
}
