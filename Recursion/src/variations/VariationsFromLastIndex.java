package variations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class VariationsFromLastIndex {
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
    System.out.println(variationsFromLastIndex(input, length));
  }

  private static StringBuilder variationsFromLastIndex(String[] input, int length) {
    StringBuilder builder = new StringBuilder();
    variationsFromLastIndex(builder, input, "", length);
    return builder;
  }

  private static void variationsFromLastIndex(StringBuilder builder, String[] input, String prefix, int index) {

    // Base case: length == 0,
    // print prefix
    if (index == 0) {
      builder.append(prefix).append(System.lineSeparator());
      //System.out.println(prefix);
      return;
    }

    // One by one add all strings from input and recursively call for length equals to length-1
    for (int i = 0; i < input.length; ++i) {

      // Next string of input added
      String newPrefix = prefix + input[i];

      // length is decreased, because we have added a new string
      variationsFromLastIndex(builder, input, newPrefix, index - 1);
    }
  }
}
