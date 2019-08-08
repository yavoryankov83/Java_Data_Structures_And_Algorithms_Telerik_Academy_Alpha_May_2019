package students_order;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentsOrder1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] counts = scanner.nextLine().split(" ");
    int n = Integer.parseInt(counts[0]);
    int k = Integer.parseInt(counts[1]);

    String[] students = scanner.nextLine().split(" ");
    LinkedList<String> studentsList = new LinkedList<>(Arrays.asList(students));

    for (int i = 0; i < k; i++) {
      String[] change = scanner.nextLine().split(" ");
      studentsList.remove(change[0]);
      int insertPosition = studentsList.indexOf(change[1]);
      studentsList.add(insertPosition, change[0]);
    }

    System.out.println(String.join(" ", studentsList));
  }
}
