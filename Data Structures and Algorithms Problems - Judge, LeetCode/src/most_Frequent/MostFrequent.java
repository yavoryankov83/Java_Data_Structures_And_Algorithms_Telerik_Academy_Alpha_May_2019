package most_Frequent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MostFrequent {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //read input
    int numberCount = Integer.parseInt(reader.readLine());

    //initialize array to store count of each value
    int[] result = new int[10000];

    //iterate and read value
    for (int i = 0; i < numberCount; i++) {
      int currentNumber = Integer.parseInt(reader.readLine());

      //increase value of index = currentNumber
      result[currentNumber]++;
    }

    //initialize max number as first index
    //initialize index of max number as first value
    int indexOfMaxNumber = result[0];
    int maxNumber = 0;

    //iterate array
    for (int i = 0; i < result.length; i++) {
      int currentNumber = result[i];

      //chaeck if current > max and store it
      if (currentNumber > indexOfMaxNumber) {
        indexOfMaxNumber = currentNumber;
        maxNumber = i;
      }
    }

    //print
    System.out.printf("%d (%d times)", maxNumber, indexOfMaxNumber);
  }
}
