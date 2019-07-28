package allocate_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllocateArray {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int length = Integer.parseInt(reader.readLine());
    int[] array = new int[length];

    for (int i = 0; i < length; i++) {
      array[i] = i * 5;
    }

    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }
}
