package jewels_and_stones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String jewels = reader.readLine();
    String stones = reader.readLine();
    Map<Character, Integer> stonesCount = new HashMap<>();

    for (int i = 0; i < stones.length(); i++) {
      char currentChar = stones.charAt(i);
      if (!stonesCount.containsKey(currentChar)){
        stonesCount.put(currentChar, 0);
      }
      stonesCount.put(currentChar, stonesCount.get(currentChar) + 1);
    }
    int counterOfOccurrences = 0;
    for (int i = 0; i < jewels.length(); i++) {
      char currentChar = jewels.charAt(i);
      if (stonesCount.containsKey(currentChar)){
        counterOfOccurrences += stonesCount.get(currentChar);
      }
    }
    System.out.println(counterOfOccurrences);
  }
}
