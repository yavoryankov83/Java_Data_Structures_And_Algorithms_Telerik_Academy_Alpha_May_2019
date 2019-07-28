package students_order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StudentsOrder {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<String> names = new ArrayList<>();

    StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
    stringTokenizer.nextToken();
    int countOfSeatChanges = Integer.parseInt(stringTokenizer.nextToken());

    StringTokenizer stringTokenizer1 = new StringTokenizer(reader.readLine());
    while (stringTokenizer1.hasMoreTokens()) {
      names.add(stringTokenizer1.nextToken());
    }

    for (int i = 0; i < countOfSeatChanges; i++) {
      StringTokenizer stringTokenizer2 = new StringTokenizer(reader.readLine());
      String firstName = stringTokenizer2.nextToken();
      String secondName = stringTokenizer2.nextToken();

      names.remove(firstName);
      int indexOfSecondName = names.indexOf(secondName);
      names.add(indexOfSecondName, firstName);
    }
    printOutput(names);
  }

  private static void printOutput(List<String> names) {
    StringBuilder builder = new StringBuilder();
    for (String name : names) {
      builder.append(name).append(" ");
    }
    System.out.println(builder.toString().trim());
  }
}
