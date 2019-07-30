package backspace_string_compare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackspaceStringCompare {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
    String firstString = stringTokenizer.nextToken();
    StringTokenizer stringTokenizer1 = new StringTokenizer(reader.readLine());
    String secondString = stringTokenizer1.nextToken();

    Solution solution = new Solution();
    boolean result = solution.backspaceCompare(firstString, secondString);

    System.out.println(result);
  }
}
