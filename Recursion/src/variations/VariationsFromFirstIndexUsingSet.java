package variations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class VariationsFromFirstIndexUsingSet {
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

    Set<String> result = variationsFromFirstIndex(input, length);
    result.forEach(System.out::println);
  }

  private static Set<String> variationsFromFirstIndex(String[] input, int length) {
    Set<String> combinations = new TreeSet();
    variationsFromFirstIndex(combinations, input, "", 0, length);
    return combinations;
  }

  private static void variationsFromFirstIndex(Set<String> combinations, String[] input, String sufix, int index, int length) {

    // Base case: index == length,
    // append preFix
    if (index == length) {
      combinations.add(sufix);
      return;
    }

    // One by one add all strings from input and recursively call for length equals to length-1
    for (int i = 0; i < input.length; ++i) {

      // Next string of input added
      String newPrefix = input[i] + sufix;

      // length is decreased, because we have added a new string
      variationsFromFirstIndex(combinations, input, newPrefix, index + 1, length);
    }
  }
}
