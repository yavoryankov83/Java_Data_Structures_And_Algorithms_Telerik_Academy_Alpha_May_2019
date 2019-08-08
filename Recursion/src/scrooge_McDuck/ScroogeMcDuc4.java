package scrooge_McDuck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScroogeMcDuc4 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inp = br.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int m = Integer.parseInt(inp[1]);
    int[][] matrix = new int[n][m];
    int[] start = new int[2];

    for (int i = 0; i < n; i++) {
      String[] next = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        matrix[i][j] = Integer.parseInt(next[j]);
        if (matrix[i][j] == 0) {
          start[0] = i;
          start[1] = j;
        }
      }
    }
    goldCount(matrix, start[0], start[1]);
    System.out.println(gold);
  }

  private static int gold = 0;

  private static void goldCount(int[][] matrix, int row, int col) {

    int[] nextCell = nextCellCoordinates(matrix, row, col);
    if (nextCell[0] == -1) {
      return;
    }
    gold++;
    matrix[nextCell[0]][nextCell[1]]--;
    goldCount(matrix, nextCell[0], nextCell[1]);
  }

  //helper method for next coordinates -> returns [-1, -1] if all nearby cells contain zero gold
  private static int[] nextCellCoordinates(int[][] matrix, int row, int col) {
    int[] newCoordinates = new int[2];

    int up = 0;
    int left = 0;
    int right = 0;
    int down = 0;

    if (row - 1 >= 0) {
      up = matrix[row - 1][col];
    }
    if (col - 1 >= 0) {
      left = matrix[row][col - 1];
    }
    if (col + 1 < matrix[row].length) {
      right = matrix[row][col + 1];
    }
    if (row + 1 < matrix.length) {
      down = matrix[row + 1][col];
    }

    if (up == 0 && left == 0 && right == 0 && down == 0) {
      newCoordinates[0] = -1;
      newCoordinates[1] = -1;
      return newCoordinates;
    }

    if (left >= up && left >= right && left >= down) {
      newCoordinates[0] = row;
      newCoordinates[1] = col - 1;
      return newCoordinates;
    }
    if (right > left && right >= up && right >= down) {
      newCoordinates[0] = row;
      newCoordinates[1] = col + 1;
      return newCoordinates;
    }
    if (up > left && up > right && up >= down) {
      newCoordinates[0] = row - 1;
      newCoordinates[1] = col;
      return newCoordinates;
    }
    if (down > left && down > right && down > up) {
      newCoordinates[0] = row + 1;
      newCoordinates[1] = col;
      return newCoordinates;
    }

    return newCoordinates;
  }
}
