package variations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class VariationsFromFirstIndex {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int length = Integer.parseInt(reader.readLine());
    stringTokenizer = new StringTokenizer(reader.readLine());
    String[] input = new String[stringTokenizer.countTokens()];
    int counter = 0;
    while (stringTokenizer.hasMoreTokens()) {
      input[counter++] = stringTokenizer.nextToken();
    }

    Arrays.sort(input);
    System.out.println(variationsFromFirstIndex(input, length));
  }

  private static StringBuilder variationsFromFirstIndex(String[] input, int length) {
    StringBuilder builder = new StringBuilder();
    variationsFromFirstIndex(builder, input, "", 0, length);
    return builder;
  }

  private static void variationsFromFirstIndex(StringBuilder builder, String[] input, String prefix, int index, int length) {

    // Base case: index == length,
    // append preFix
    if (index == length) {
      builder.append(prefix).append(System.lineSeparator());
      return;
    }

    // One by one add all strings from input and recursively call for length equals to length-1
    for (int i = 0; i < input.length; ++i) {

      // Next string of input added
      String newPrefix = prefix + input[i];

      // length is decreased, because we have added a new string
      variationsFromFirstIndex(builder, input, newPrefix, index + 1, length);
    }
  }
}
