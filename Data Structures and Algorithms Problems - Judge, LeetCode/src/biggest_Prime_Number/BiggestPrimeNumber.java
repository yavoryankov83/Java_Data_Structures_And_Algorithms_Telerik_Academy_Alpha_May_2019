package biggest_Prime_Number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BiggestPrimeNumber {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int maxNum = Integer.parseInt(reader.readLine());
    boolean isPrime = true;

    for (int num = maxNum; num >= 1; num--) {
      for (int devider = 2; devider <= Math.sqrt(num); devider++) {
        if (num % devider == 0) {
          isPrime = false;
          break;
        } else {
          isPrime = true;
        }
      }
      if (isPrime) {
        System.out.println(num);
        return;
      }
    }
  }
}
