package evaluate_expression;

import java.math.BigInteger;
import java.util.Scanner;

public class EvaluateExpression1 {
  static BigInteger solve(String expression) {
    BigInteger number = BigInteger.ZERO;
    int i = 0;
    while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
      number = number.multiply(BigInteger.valueOf(10));
      number = number.add(BigInteger.valueOf(expression.charAt(i) - '0'));
      i += 1;
    }

    char op = expression.charAt(i);
    ++i;
    BigInteger other;

    if (expression.charAt(i) != '(') {
      other = new BigInteger(expression.substring(i));
    } else {
      other = solve(expression.substring(i + 1, expression.length() - 1));
    }

    BigInteger result = number;
    if (op == '+') {
      result = result.add(other);
    } else if (op == '-') {
      result = result.subtract(other);
    } else if (op == '*') {
      result = result.multiply(other);
    }

    // System.out.println(expression);
    // System.out.printf("%s %c %s = %s%n", number, op, other, result);
    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
//        String expression = "55*(10-(2+(4-12)))";
    String expression = in.nextLine();
    System.out.println(solve(expression));

  }
}
