package merge_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort<T> {
  public static void main(String[] args) throws IOException {
    List<Integer> input = readInput();
    mergeSort(input);
    printInput(input);
  }

  private static <T extends Comparable<T>> void mergeSort(List<T> input) {
    MergeSort.mergeSortAlgorithm(input, 0, input.size() - 1);
  }

  private static <T extends Comparable<T>> void merge(
          List<T> input,
          int leftIndex,
          int middleIndex,
          int rightIndex) {

    int leftHalveSize = middleIndex - leftIndex + 1;
    int rightHalveSize = rightIndex - middleIndex;

    List<T> leftHalve = new ArrayList<>(leftHalveSize);
    List<T> rightHalve = new ArrayList<>(rightHalveSize);

    //copy data to to halves
    for (int i = 0; i < leftHalveSize; i++) {
      leftHalve.set(i, input.get(leftIndex + i));
    }
    for (int i = 0; i < rightHalveSize; i++) {
      rightHalve.set(i, input.get(middleIndex + 1 + i));
    }

    //merge
    int initialIndexOfLeftHalve = 0;
    int initialIndexOfRightHalve = 0;
    int initialIndexOfMerged = leftIndex;

    while (initialIndexOfLeftHalve < leftHalveSize && initialIndexOfRightHalve < rightHalveSize) {
      if (leftHalve.get(initialIndexOfLeftHalve).compareTo(rightHalve.get(initialIndexOfRightHalve)) <= 0) {
        input.set(initialIndexOfMerged, leftHalve.get(initialIndexOfLeftHalve));
        initialIndexOfLeftHalve++;
      } else {
        input.set(initialIndexOfMerged, rightHalve.get(initialIndexOfRightHalve));
        initialIndexOfRightHalve++;
      }
      initialIndexOfMerged++;
    }

    //copy remaining elements in left halve
    while (initialIndexOfLeftHalve < leftHalveSize) {
      input.set(initialIndexOfMerged, leftHalve.get(initialIndexOfLeftHalve));
      initialIndexOfLeftHalve++;
      initialIndexOfMerged++;
    }

    //copy remaining elements in right halve
    while (initialIndexOfRightHalve < rightHalveSize) {
      input.set(initialIndexOfMerged, rightHalve.get(initialIndexOfRightHalve));
      initialIndexOfRightHalve++;
      initialIndexOfMerged++;
    }
  }

  private static <T extends Comparable<T>> void mergeSortAlgorithm(List<T> input, int leftIndex, int rightIndex) {
    if (leftIndex < rightIndex) {
      // Find the middle point
      int middleIndex = (leftIndex + rightIndex) / 2;

      // Sort first and second halves
      mergeSortAlgorithm(input, leftIndex, middleIndex);
      mergeSortAlgorithm(input, middleIndex + 1, rightIndex);

      // Merge the sorted halves
      merge(input, leftIndex, middleIndex, rightIndex);
    }
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


  private static void printInput(List<Integer> input) {
    input.forEach(num -> System.out.print(num + " "));
  }
}
