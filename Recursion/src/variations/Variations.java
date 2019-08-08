package variations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Variations {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int number = Integer.parseInt(br.readLine());

    String[] inp = br.readLine().split(" ");

    brute(inp, number, new StringBuffer());
    tSet.forEach(System.out::println);
  }

  static TreeSet tSet = new TreeSet();

  private static void brute(String[] input, int depth, StringBuffer output) {
    if (depth == 0) {
      tSet.add(output.toString());
      return;
    }

    for (String s : input) {
      output.append(s);
      brute(input, depth - 1, output);
      output.delete(output.length() - s.length(), output.length());
    }
  }
}
