package cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cipher {
  private static Map<String, String> pairs;
  private static List<String> originalMessages;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String messageToDecode = reader.readLine();
    String cipher = reader.readLine();
    pairs = new HashMap<>();
    originalMessages = new ArrayList<>();

    String pattern = "[A-Z][0-9]+";
    Pattern compile = Pattern.compile(pattern);
    Matcher matcher = compile.matcher(cipher);
    while (matcher.find()) {
      String key = matcher.group().substring(0, 1);
      String value = matcher.group().substring(1);
      pairs.put(key, value);
    }

    String initial = "";
    getOriginalMessages(messageToDecode, initial);

    System.out.println(originalMessages.size());
    for (String originalMessage : originalMessages) {
      System.out.println(originalMessage);
    }
  }

  static void getOriginalMessages(String cipher, String initial) {
    if (cipher.length() == 0) {
      originalMessages.add(initial);
    } else {
      for (Map.Entry<String, String> currentPair : pairs.entrySet()) {
        if (cipher.startsWith(currentPair.getValue())) {
          getOriginalMessages(cipher.substring(currentPair.getValue().length()), initial + currentPair.getKey());
        }
      }
    }
  }
}
