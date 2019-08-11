package largest_surface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LargestSurface {
  private static StringTokenizer stringTokenizer;
  private static int[][] matrix;
  private static int maxLength;
  private static int currentLength;
  private static int currentNumber;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> result = new ArrayList<>();
    String[] rowCol = reader.readLine().split(" ");

    int rows = Integer.parseInt(rowCol[0]);
    int cols = Integer.parseInt(rowCol[1]);
    matrix = new int[rows][cols];

    for (int row = 0; row < rows; row++) {
      stringTokenizer = new StringTokenizer(reader.readLine());
      for (int col = 0; col < cols; col++) {
        matrix[row][col] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }
    findMaxSumOfEqualNeighbors();
  }

  private static void findMaxSumOfEqualNeighbors() {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (currentLength > maxLength) {
          maxLength = currentLength;
        }
        currentLength = 0;
        currentNumber = matrix[row][col];
        getLength(row, col);
      }
    }
    System.out.println(maxLength);
  }

  private static void getLength(int row, int col) {
    if (!isInRange(row, col)) {
      return;
    }
    if (matrix[row][col] == 0) {
      return;
    }
    if (matrix[row][col] == currentNumber) {
      matrix[row][col] = 0;
      currentLength++;

      //go left
      getLength(row, col - 1);
      //go right
      getLength(row, col + 1);
      //go up
      getLength(row - 1, col);
      //go down
      getLength(row + 1, col);
    }
  }

  private static boolean isInRange(int row, int col) {
    return !(row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length);
  }
}
