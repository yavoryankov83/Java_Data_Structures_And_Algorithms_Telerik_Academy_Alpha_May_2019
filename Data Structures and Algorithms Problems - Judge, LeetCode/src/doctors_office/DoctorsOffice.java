package doctors_office;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DoctorsOffice {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder builder = new StringBuilder();

    List<String> names = new ArrayList<>();
    Map<String, Integer> namesCount = new HashMap<>();

    String line;
    while (!"End".equals(line = reader.readLine())) {
      stringTokenizer = new StringTokenizer(line, " ", false);
      String command = stringTokenizer.nextToken();
      String name;

      switch (command) {
        case "Append":
          name = stringTokenizer.nextToken();
          names.add(name);
          if (!namesCount.containsKey(name)) {
            namesCount.put(name, 0);
          }
          namesCount.put(name, namesCount.get(name) + 1);

          builder.append("OK").append(System.lineSeparator());
          break;

        case "Insert":
          int position = Integer.parseInt(stringTokenizer.nextToken());
          name = stringTokenizer.nextToken();
          if (position < 0 || position > names.size()) {
            builder.append("Error").append(System.lineSeparator());
          } else {
            names.add(position, name);
            if (!namesCount.containsKey(name)) {
              namesCount.put(name, 0);
            }
            namesCount.put(name, namesCount.get(name) + 1);
            builder.append("OK").append(System.lineSeparator());
          }
          break;

        case "Find":
          int countOfName;
          name = stringTokenizer.nextToken();
          if (!namesCount.containsKey(name)) {
            countOfName = 0;
          } else {
            countOfName = namesCount.get(name);
          }

          builder.append(countOfName).append(System.lineSeparator());
          break;

        case "Examine":
          int count = Integer.parseInt(stringTokenizer.nextToken());
          if (count > names.size()) {
            builder.append("Error").append(System.lineSeparator());
          } else {
            List<String> result = names.subList(0, count);
            names = names.subList(count, names.size());
            for (String currentName : result) {
              builder.append(currentName).append(" ");
              if (namesCount.get(currentName) != 0) {
                namesCount.put(currentName, namesCount.get(currentName) - 1);
              }
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(System.lineSeparator());
          }
          break;
      }
    }
    System.out.println(builder);
  }
}
