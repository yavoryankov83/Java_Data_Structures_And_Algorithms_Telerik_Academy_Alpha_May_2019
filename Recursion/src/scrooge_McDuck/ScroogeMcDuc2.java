package scrooge_McDuck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ScroogeMcDuc2 {
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    stringTokenizer = new StringTokenizer(reader.readLine(), " ", false);
    int rows = Integer.parseInt(stringTokenizer.nextToken());
    int cols = Integer.parseInt(stringTokenizer.nextToken());
    int[][] labyrinth = new int[rows][cols];
    int startRow = 0;
    int startCol = 0;

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

    System.out.println(countCoins(startRow, startCol, labyrinth));
  }

  private static int countCoins(int startRow, int startCol, int[][] labyrinth) {
    int maxValue = 0;
    int maxRow = 0;
    int maxCol = 0;

    //move left
    int nextPosition = validPositionMovement(startRow, startCol - 1, labyrinth);
    if (nextPosition > maxValue) {
      maxValue = nextPosition;
      maxRow = startRow;
      maxCol = startCol - 1;
    }

    //move right
    nextPosition = validPositionMovement(startRow, startCol + 1, labyrinth);
    if (nextPosition > maxValue) {
      maxValue = nextPosition;
      maxRow = startRow;
      maxCol = startCol + 1;
    }

    //move up
    nextPosition = validPositionMovement(startRow - 1, startCol, labyrinth);
    if (nextPosition > maxValue) {
      maxValue = nextPosition;
      maxRow = startRow - 1;
      maxCol = startCol;
    }

    //move down
    nextPosition = validPositionMovement(startRow + 1, startCol, labyrinth);
    if (nextPosition > maxValue) {
      maxValue = nextPosition;
      maxRow = startRow + 1;
      maxCol = startCol;
    }

    if (maxValue == 0) {
      return maxValue;
    }

    int preferredPositionCoinCount = labyrinth[maxRow][maxCol];
    labyrinth[maxRow][maxCol] = preferredPositionCoinCount - 1;
    return 1 + countCoins(maxRow, maxCol, labyrinth);
  }

  private static int validPositionMovement(int row, int col, int[][] labyrinth) {
    if (row < 0 || row >= labyrinth.length || col < 0 || col >= labyrinth[row].length) {
      return 0;
    }
    return labyrinth[row][col];
  }
}
