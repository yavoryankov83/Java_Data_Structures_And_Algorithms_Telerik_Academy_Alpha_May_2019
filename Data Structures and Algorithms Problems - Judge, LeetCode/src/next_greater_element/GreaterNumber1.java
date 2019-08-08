package next_greater_element;

import java.util.*;

public class GreaterNumber1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] inputCoins = scanner.nextLine().split(",");

    int[] firstBag = new int[inputCoins.length];
    for (int i = 0; i < inputCoins.length; i++) {
      firstBag[i] = Integer.parseInt(inputCoins[i]);
    }

    inputCoins = scanner.nextLine().split(",");
    int[] secondBag = new int[inputCoins.length];
    Map<Integer, Integer> secondBagWithIndex = new HashMap<>();
    for (int i = 0; i < inputCoins.length; i++) {
      int coin = Integer.parseInt(inputCoins[i]);
      secondBag[i] = coin;
      secondBagWithIndex.put(coin, i);
    }

    List<String> result = new ArrayList<>();
    for (int i = 0; i < firstBag.length; i++) {
      if (!secondBagWithIndex.containsKey(firstBag[i])) {
        result.add(Integer.toString(-1));
      } else {
        int index = secondBagWithIndex.get(firstBag[i]);
        boolean isFound = false;

        for (int j = index + 1; j < secondBag.length; j++) {
          if (firstBag[i] < secondBag[j]) {
            result.add(Integer.toString(secondBag[j]));
            isFound = true;
            break;
          }
        }
        if (!isFound) {
          result.add(Integer.toString(-1));
        }
      }
    }

    System.out.println(String.join(",", result));
  }
}
