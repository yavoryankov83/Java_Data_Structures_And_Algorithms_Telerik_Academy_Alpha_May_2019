package bubble_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {
  public static void main(String[] args) throws IOException {
    List<Integer> input = readInput();
    bubbleSort(input);
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

  private static <T extends Comparable<T>> void bubbleSort(List<T> input) {
    boolean isSwapped = true;

    do {
      isSwapped = false;

      for (int i = 0; i < input.size() - 1; i++) {
        int currentIndex = i;
        int nextIndex = i + 1;

        if (input.get(nextIndex).compareTo(input.get(currentIndex)) < 0) {
          swap(currentIndex, nextIndex, input);

          isSwapped = true;
        }
      }
    } while (isSwapped);
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
