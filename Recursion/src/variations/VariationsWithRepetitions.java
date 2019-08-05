package variations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class VariationsWithRepetitions {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    stringTokenizer = new StringTokenizer(reader.readLine());
    int size = Integer.parseInt(stringTokenizer.nextToken());
    stringTokenizer = new StringTokenizer(reader.readLine(), " ", false);
    String[] input = new String[stringTokenizer.countTokens()];
    int counter = 0;
    while (stringTokenizer.hasMoreTokens()) {
        input[counter++] = stringTokenizer.nextToken();
    }
    Arrays.sort(input);
    List<List<String>> combinations = variationsWithRepetitions(input, size);
    for (List<String> combination : combinations) {
      System.out.println(String.join("", combination));
    }
  }

  private static <T> List<List<T>> variationsWithRepetitions(T[] input, int size) {
    List<List<T>> combinations = new ArrayList<>();
    List<T> combination = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      combination.add(null);
    }
    variationsWithRepetitions(input, combinations, combination, 0);
    return combinations;
  }

  private static <T> void variationsWithRepetitions(T[] input, List<List<T>> combinations, List<T> combination, int index) {
    if (index == combination.size()) {
      combinations.add(new ArrayList<>(combination));
      return;
    }
    Arrays
            .stream(input)
            .forEach(value -> {
              combination.set(index, value);
              variationsWithRepetitions(input, combinations, combination, index + 1);
            });
  }
}
