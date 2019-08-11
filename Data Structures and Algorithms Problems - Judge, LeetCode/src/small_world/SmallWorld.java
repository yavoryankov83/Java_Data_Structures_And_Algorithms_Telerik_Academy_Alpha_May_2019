package small_world;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SmallWorld {
  private static StringTokenizer stringTokenizer;
  private static List<Integer> result;
  private static char[][] matrix;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    result = new ArrayList<>();
    stringTokenizer = new StringTokenizer(reader.readLine());
    int rows = Integer.parseInt(stringTokenizer.nextToken());
    int cols = Integer.parseInt(stringTokenizer.nextToken());
    matrix = new char[rows][cols];

    for (int row = 0; row < rows; row++) {
      String line = reader.readLine();
      for (int col = 0; col < cols; col++) {
        matrix[row][col] = line.charAt(col);
      }
    }
    getCountOfConquest(matrix);

    result.sort(Comparator.reverseOrder());
    for (Integer currentCount : result) {
      System.out.println(currentCount);
    }
  }

  private static void getCountOfConquest(char[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (matrix[row][col] == '1') {
          int currentCount = getCount(row, col, matrix);
          result.add(currentCount);
        }
      }
    }
  }

  private static int getCount(int row, int col, char[][] matrix) {
    int counter = 0;

    if (!isInRange(row, col)) {
      return counter;
    }

    matrix[row][col] = '0';
    counter++;

    //go left
    counter += getCount(row, col - 1, matrix);
    //go right
    counter += getCount(row, col + 1, matrix);
    //go up
    counter += getCount(row - 1, col, matrix);
    //go down
    counter += getCount(row + 1, col, matrix);

    return counter;
  }

  private static boolean isInRange(int row, int col) {
    return !(row < 0 ||
            col < 0 ||
            row >= matrix.length ||
            col >= matrix[row].length ||
            matrix[row][col] == '0');
  }
}
