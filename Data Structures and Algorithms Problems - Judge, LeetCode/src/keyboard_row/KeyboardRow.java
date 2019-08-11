package keyboard_row;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KeyboardRow {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine(), ", ", false);
    String[] words = new String[stringTokenizer.countTokens()];
    int counter = 0;
    while (stringTokenizer.hasMoreTokens()) {
      words[counter] = stringTokenizer.nextToken();
      counter++;
    }

    List<String> result = new ArrayList<>();
    for (String word : words) {
      if (isValid(word)) {
        result.add(word);
      }
    }
    String[] resultWords = getResultAsArray(result);
    System.out.println(Arrays.toString(resultWords));
  }

  private static boolean isValid(String word) {
    Character[] firstRowLetters = {'q', 'Q', 'w', 'W', 'e', 'E', 'r', 'R', 't', 'T', 'y', 'Y', 'u', 'U',
            'i', 'I', 'o', 'O', 'p', 'P'};
    Character[] secondRowLetters = {'a', 'A', 's', 'S', 'd', 'D', 'f', 'F', 'g', 'G', 'h', 'H', 'j', 'J',
            'k', 'K', 'l', 'L'};
    Character[] thirdRowLetters = {'z', 'Z', 'x', 'X', 'c', 'C', 'v', 'V', 'b', 'B', 'n', 'N', 'm', 'M'};
    Set<Character> firstRow = new HashSet<>(Arrays.asList(firstRowLetters));
    Set<Character> secondRow = new HashSet<>(Arrays.asList(secondRowLetters));
    Set<Character> thirdRow = new HashSet<>(Arrays.asList(thirdRowLetters));
    boolean[] flag = new boolean[3];
    Arrays.fill(flag, true);


    for (char currentChar : word.toCharArray()) {
      if (!firstRow.contains(currentChar)) {
        flag[0] = false;
      }
      if (!secondRow.contains(currentChar)) {
        flag[1] = false;
      }
      if (!thirdRow.contains(currentChar)) {
        flag[2] = false;
      }
    }

    return flag[0] || flag[1] || flag[2];
  }

  private static String[] getResultAsArray(List<String> result) {
    String[] words = new String[result.size()];
    for (int i = 0; i < result.size(); i++) {
      words[i] = result.get(i);
    }
    return words;
  }
}
