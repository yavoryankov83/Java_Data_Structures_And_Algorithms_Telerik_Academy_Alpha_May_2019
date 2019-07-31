package binary_search_recursive;

import java.util.Comparator;
import java.util.List;

public class BinarySearch<T> {
  public static <T extends Comparable<T>> T binarySearch(List<T> collection, T valueToFind) {
    return BinarySearch.binarySearchAlgorithm(collection, valueToFind, 0, collection.size() - 1);
  }

  private static <T extends Comparable<T>> T binarySearchAlgorithm(
          List<T> collection,
          T valueToFind,
          int startIndex,
          int endIndex) {
    collection.sort(Comparator.naturalOrder());

    if (endIndex >= startIndex) {
      int middleIndex = (endIndex + startIndex) / 2;

      if (valueToFind.compareTo(collection.get(middleIndex)) < 0) {
        return binarySearchAlgorithm(collection, valueToFind, startIndex, middleIndex - 1);
      } else if (valueToFind.compareTo(collection.get(middleIndex)) > 0) {
        return binarySearchAlgorithm(collection, valueToFind, middleIndex + 1, endIndex);
      } else {
        return collection.get(middleIndex);
      }
    }
    return null;
  }
}
