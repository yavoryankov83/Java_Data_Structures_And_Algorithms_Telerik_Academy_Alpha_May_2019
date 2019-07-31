package selection_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SelectionSort {
  public static void main(String[] args) throws IOException {
    List<Integer> input = readInput();
    selectionSort(input);
    printInput(input);
  }

  private static List<Integer> readInput() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> nums = Arrays
            .stream(reader.readLine()
                    .split("\\s+"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    return nums;
  }

  private static <T extends Comparable<T>> void selectionSort(List<T> input) {
    for (int i = 0; i < input.size() - 1; i++) {
      int index = i;
      T current = input.get(i);
      for (int j = i + 1; j < input.size(); j++) {
        T next = input.get(j);
        T minValue = input.get(index);
        if (next.compareTo(minValue) < 0) {
          index = j;
          swap(i, j, input);
        }
      }
    }
  }

  private static <T extends Comparable<T>> void swap(int firstIndex, int secondIndex, List<T> input) {
    T temp = input.get(firstIndex);
    input.set(firstIndex, input.get(secondIndex));
    input.set(secondIndex, temp);
  }

  private static void printInput(List<Integer> input) {
    input.forEach(num -> System.out.print(num + " "));
  }
}
