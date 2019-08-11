package longest_substring_without_repeating_characters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    Set<Character> result = new HashSet<>();

    int maxLength = 0;
    int index = 0;
    for (int i = 0; i < input.length(); i++) {
      char currentChar = input.charAt(i);
      while (result.contains(currentChar)) {
        result.remove(input.charAt(index));
        index++;
      }
      result.add(currentChar);
      if (result.size() > maxLength) {
        maxLength = result.size();
      }
    }
    System.out.println(maxLength);
  }
}
