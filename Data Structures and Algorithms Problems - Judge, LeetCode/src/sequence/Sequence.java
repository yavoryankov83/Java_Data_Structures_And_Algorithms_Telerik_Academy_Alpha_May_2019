package sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sequence {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] nums = reader.readLine().split(" ");
    int k = Integer.parseInt(nums[0]);
    int n = Integer.parseInt(nums[1]);

    List<Integer> result = new ArrayList<>();
    result.add(0);
    //1st num
    result.add(k);
    //2nd num
    result.add(k + 1);
    //3th num
    result.add(2 * k + 1);
    //4th num
    result.add(k + 2);

    //start calc with 2nd num = index 2
    //calc first 3 nums and increase index
    int index = 2;
    while (result.size() <= n) {
      result.add(result.get(index) + 1);
      result.add(2 * result.get(index) + 1);
      result.add(result.get(index) + 2);
      index++;
    }
    System.out.println(result.get(n));
  }
}
