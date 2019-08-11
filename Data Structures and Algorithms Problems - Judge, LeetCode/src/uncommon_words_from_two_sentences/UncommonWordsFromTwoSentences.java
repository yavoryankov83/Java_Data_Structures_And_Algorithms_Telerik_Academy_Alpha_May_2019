package uncommon_words_from_two_sentences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UncommonWordsFromTwoSentences {
  public static void main(String[] args) throws IOException {
    Map<String, Integer> result = new HashMap<>();
    List<String> uncommonWords = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine(), " ", false);
    while (stringTokenizer.hasMoreTokens()) {
      String currentWord = stringTokenizer.nextToken();
      if (!result.containsKey(currentWord)) {
        result.put(currentWord, 0);
      } else {
        result.put(currentWord, result.get(currentWord) + 1);
      }
    }
    StringTokenizer stringTokenizer1 = new StringTokenizer(reader.readLine(), " ", false);
    while (stringTokenizer1.hasMoreTokens()) {
      String currentWord = stringTokenizer1.nextToken();
      if (!result.containsKey(currentWord)) {
        result.put(currentWord, 0);
      } else {
        result.put(currentWord, result.get(currentWord) + 1);
      }
    }
    for (Map.Entry<String, Integer> stringIntegerEntry : result.entrySet()) {
      if (stringIntegerEntry.getValue() == 0) {
        uncommonWords.add(stringIntegerEntry.getKey());
      }
    }

    System.out.println(Arrays.toString(getWords(uncommonWords)));
  }

  private static String[] getWords(List<String> uncommonWords) {
    String[] result = new String[uncommonWords.size()];
    for (int i = 0; i < uncommonWords.size(); i++) {
      result[i] = uncommonWords.get(i);
    }

    return result;
  }
}
