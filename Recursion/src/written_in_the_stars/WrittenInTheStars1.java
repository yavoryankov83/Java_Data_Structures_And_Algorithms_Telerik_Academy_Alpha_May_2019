package written_in_the_stars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WrittenInTheStars1 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    LinkedList<Integer> nums = new LinkedList<>();
    String input = reader.readLine();
    Pattern pattern = Pattern.compile("[0-9]");
    Matcher matcher = pattern.matcher(input);

    while (matcher.find()) {
      nums.add(Integer.parseInt(matcher.group()));
    }

    int[] resultNums = new int[10];
    getNumerologySigns(nums, resultNums);
    for (int resultNum : resultNums) {
      System.out.print(resultNum + " ");
    }
  }

  private static void getNumerologySigns(LinkedList<Integer> nums, int[] resultNums) {
    if (nums.size() == 1) {
      resultNums[nums.get(0)]++;
      return;
    }
    for (int i = 1; i < nums.size(); i++) {
      int firstDigit = nums.get(i - 1);
      int nextDigit = nums.get(i);
      nums.remove(i);
      nums.set(i - 1, expression(firstDigit, nextDigit));
      getNumerologySigns(nums, resultNums);
      nums.set(i - 1, firstDigit);
      nums.add(i, nextDigit);
    }
  }

  private static Integer expression(int firstDigit, int nextDigit) {
    return (firstDigit + nextDigit) * (firstDigit ^ nextDigit) % 10;
  }
}
