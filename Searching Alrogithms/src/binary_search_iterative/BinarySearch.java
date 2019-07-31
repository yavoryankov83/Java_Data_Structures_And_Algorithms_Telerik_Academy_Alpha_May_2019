package binary_search_iterative;

import java.util.Comparator;
import java.util.List;

public class BinarySearch<T> {
  public static <T extends Comparable<T>> T binarySearch(List<T> collection, T valueToFind) {
    collection.sort(Comparator.naturalOrder());

    int startIndex = 0;
    int endIndex = collection.size() - 1;

    while (startIndex <= endIndex) {
      int middleIndex = (startIndex + endIndex) / 2;

      if (valueToFind.compareTo(collection.get(middleIndex)) < 0) {
        endIndex = middleIndex - 1;
      } else if (valueToFind.compareTo(collection.get(middleIndex)) > 0) {
        startIndex = middleIndex + 1;
      } else {
        return collection.get(middleIndex);
      }
    }
    return null;
  }
}
