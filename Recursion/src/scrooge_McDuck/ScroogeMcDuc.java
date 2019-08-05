package scrooge_McDuck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ScroogeMcDuc {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    stringTokenizer = new StringTokenizer(reader.readLine(), " ", false);
    int rows = Integer.parseInt(stringTokenizer.nextToken());
    int cols = Integer.parseInt(stringTokenizer.nextToken());
    int[][] labyrinth = new int[rows][cols];
    int startRow = 0;
    int startCol = 0;
    int coinsCount = 0;

    for (int row = 0; row < rows; row++) {
      stringTokenizer = new StringTokenizer(reader.readLine());
      for (int col = 0; col < cols; col++) {
        labyrinth[row][col] = Integer.parseInt(stringTokenizer.nextToken());
        if (labyrinth[row][col] == 0) {
          startRow = row;
          startCol = col;
        }
      }
    }

    System.out.println(countCoins(startRow, startCol, labyrinth, coinsCount));
  }

  private static int countCoins(int row, int col, int[][] labyrinth, int coinsCount) {
    int[] maxRowCol = findMaxRowCol(row, col, labyrinth);
    int maxRow = maxRowCol[0];
    int maxCol = maxRowCol[1];
    if (maxRow != row || maxCol != col) {
      coinsCount++;
      labyrinth[maxRow][maxCol]--;
    } else {
      return coinsCount;
    }

    return countCoins(maxRowCol[0], maxRowCol[1], labyrinth, coinsCount);
  }

  private static int[] findMaxRowCol(int row, int col, int[][] labyrinth) {

    if (isInRange(row, col - 1, labyrinth) && labyrinth[row][col - 1] != 0 &&
            isLeftPositionBiggest(row, col, labyrinth)) {

      return new int[]{row, col - 1};
    } else if (isInRange(row, col + 1, labyrinth) && labyrinth[row][col + 1] != 0 &&
            isRightPositionBiggest(row, col, labyrinth)) {

      return new int[]{row, col + 1};
    } else if (isInRange(row - 1, col, labyrinth) && labyrinth[row - 1][col] != 0 &&
            isUpPositionBiggest(row, col, labyrinth)) {

      return new int[]{row - 1, col};
    } else if (isInRange(row + 1, col, labyrinth) && labyrinth[row + 1][col] != 0 &&
            isDownPositionBiggest(row, col, labyrinth)) {

      return new int[]{row + 1, col};
    }
    return new int[]{row, col};
  }

  private static boolean isDownPositionBiggest(int row, int col, int[][] labyrinth) {
    return labyrinth[row + 1][col] > isNextPositionValid(row, col + 1, labyrinth) &&
            labyrinth[row + 1][col] > isNextPositionValid(row, col - 1, labyrinth) &&
            labyrinth[row + 1][col] > isNextPositionValid(row - 1, col, labyrinth);
  }

  private static boolean isUpPositionBiggest(int row, int col, int[][] labyrinth) {
    return labyrinth[row - 1][col] > isNextPositionValid(row, col + 1, labyrinth) &&
            labyrinth[row - 1][col] > isNextPositionValid(row, col - 1, labyrinth) &&
            labyrinth[row - 1][col] >= isNextPositionValid(row + 1, col, labyrinth);
  }

  private static boolean isRightPositionBiggest(int row, int col, int[][] labyrinth) {
    return labyrinth[row][col + 1] > isNextPositionValid(row, col - 1, labyrinth) &&
            labyrinth[row][col + 1] >= isNextPositionValid(row - 1, col, labyrinth) &&
            labyrinth[row][col + 1] >= isNextPositionValid(row + 1, col, labyrinth);
  }

  private static boolean isLeftPositionBiggest(int row, int col, int[][] labyrinth) {
    return labyrinth[row][col - 1] >= isNextPositionValid(row, col + 1, labyrinth) &&
            labyrinth[row][col - 1] >= isNextPositionValid(row - 1, col, labyrinth) &&
            labyrinth[row][col - 1] >= isNextPositionValid(row + 1, col, labyrinth);
  }

  private static boolean isInRange(int row, int col, int[][] labyrinth) {
    return row < labyrinth.length && row >= 0 && col < labyrinth[0].length && col >= 0;
  }

  private static int isNextPositionValid(int row, int col, int[][] labyrinth) {
    if (isInRange(row, col, labyrinth)) {
      return labyrinth[row][col];
    }
    return -1;
  }
}
