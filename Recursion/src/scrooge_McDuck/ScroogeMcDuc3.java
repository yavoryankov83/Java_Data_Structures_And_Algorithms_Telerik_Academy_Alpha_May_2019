package scrooge_McDuck;

import java.util.Scanner;

public class ScroogeMcDuc3 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int rows = in.nextInt();
    int cols = in.nextInt();

    int startRow = 0;
    int startCol = 0;

    int[][] matrix = new int[rows][cols];

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        matrix[r][c] = in.nextInt();
        if (matrix[r][c] == 0) {
          startRow = r;
          startCol = c;
        }
      }
    }

    int coins = 0;
    int row = startRow;
    int col = startCol;

    int[] dRows = {0, 0, -1, +1};
    int[] dCols = {-1, +1, 0, 0};


    while (true) {
      int tempMax = 0;
      int maxNextRow = row;
      int maxNextCol = col;

      for (int direction = 0; direction < dRows.length; direction++) {
        int nextRow = row + dRows[direction];
        int nextCol = col + dCols[direction];

        if (!inRange(nextRow, rows) || !inRange(nextCol, cols)) {
          continue;
        }

        if (tempMax < matrix[nextRow][nextCol]) {
          tempMax = matrix[nextRow][nextCol];
          maxNextRow = nextRow;
          maxNextCol = nextCol;
        }
      }

      if (tempMax == 0) {
        break;
      }

      row = maxNextRow;
      col = maxNextCol;
      matrix[row][col]--;
      coins++;
    }

    System.out.println(coins);
  }

  static boolean inRange(int value, int max) {
    return 0 <= value && value < max;
  }
}
