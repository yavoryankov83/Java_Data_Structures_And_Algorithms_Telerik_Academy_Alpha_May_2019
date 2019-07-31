package linear_search;

import java.util.List;

public class LinearSearch<T> {
  public static <T extends Comparable<T>> T linearSearch(List<T> collection, T valueToFind) {
    for (T value : collection) {
      if (value.equals(valueToFind)) {
        return value;
      }
    }
    return null;
  }
}
