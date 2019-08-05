package check_for_palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckForPalindrome {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(isPalindrome(reader.readLine()));
  }

  private static boolean isPalindrome(String input) {
    if (input.length() < 2) {
      return true;
    }
    if (input.charAt(0) == input.charAt(input.length() - 1)) {
      return isPalindrome(input.substring(1, input.length() - 1));
    }
    return false;
  }
}
