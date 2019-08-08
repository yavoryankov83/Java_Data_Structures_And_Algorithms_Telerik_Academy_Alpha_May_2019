package jumps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Jumps1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    String[] numbersStr = scanner.nextLine().split(" ");

    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(numbersStr[i]);
    }

    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && numbers[i] >= numbers[stack.peek()]) {
        stack.pop();
      }

      if (!stack.isEmpty()) {
        result[i] = result[stack.peek()] + 1;
      }
      stack.push(i);
    }

    StringBuilder output = new StringBuilder();
    output.append(Arrays.stream(result).max().getAsInt());
    output.append("\n");
    for (int x : result) {
      output.append(x);
      output.append(" ");
    }

    System.out.println(output);
  }
}
