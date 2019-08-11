package find_the_difference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Map<Character, Integer> map = new HashMap<>();
    String first = reader.readLine();
    String second = reader.readLine();
    for (char currentChar : second.toCharArray()) {
      map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
    }
    for (char currentChar : first.toCharArray()) {
      map.put(currentChar, map.getOrDefault(currentChar, 0) - 1);
    }
    for (Character character : map.keySet()) {
      if (map.get(character) != 0) {
        System.out.println(character);
      }
    }
  }
}
