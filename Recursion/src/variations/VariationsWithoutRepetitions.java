package variations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class VariationsWithoutRepetitions {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    stringTokenizer = new StringTokenizer(reader.readLine());
    int size = Integer.parseInt(stringTokenizer.nextToken());
    stringTokenizer = new StringTokenizer(reader.readLine(), " ", false);
    String[] input = new String[stringTokenizer.countTokens()];
    while (stringTokenizer.hasMoreTokens()) {
      for (int i = 0; i < input.length; i++) {
        input[i] = stringTokenizer.nextToken();
      }
    }
    Arrays.sort(input);
    List<List<String>> combinations = variationsWithoutRepetitions(input, size);
    for (List<String> combination : combinations) {
      System.out.println(String.join("", combination));
    }
  }

  private static <T> List<List<T>> variationsWithoutRepetitions(T[] input, int size) {
    List<List<T>> combinations = new ArrayList<>();
    List<T> combination = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      combination.add(null);
    }
    Set<T> usedValues = new HashSet<>();
    variationsWithoutRepetitions(input, combinations, combination, 0, usedValues);
    return combinations;
  }

  private static <T> void variationsWithoutRepetitions(T[] input, List<List<T>> combinations, List<T> combination, int index, Set<T> used) {
    if (index == combination.size()) {
      combinations.add(new ArrayList<>(combination));
      return;
    }
    Arrays
            .stream(input)
            .filter(value -> !used.contains(value))
            .forEach(value -> {
              combination.set(index, value);
              used.add(value);
              variationsWithoutRepetitions(input, combinations, combination, index + 1, used);
              used.remove(value);
            });
  }
}
