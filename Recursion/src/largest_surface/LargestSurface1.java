package largest_surface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class LargestSurface1 {
  private static Deque<Integer> branchingCellCol;
  private static Deque<Integer> branchingCellRow;
  private static int[][] matrix;
  private static boolean[][] visitedCells;
  private static int rows;
  private static int cols;
  private static int maxAreaSize;
  private static int currentAreaSize;
  private static StringTokenizer stringTokenizer;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    stringTokenizer = new StringTokenizer(reader.readLine(), " ", false);
    int rows = Integer.parseInt(stringTokenizer.nextToken());
    int cols = Integer.parseInt(stringTokenizer.nextToken());
    matrix = new int[rows][cols];

    for (int row = 0; row < rows; row++) {
      stringTokenizer = new StringTokenizer(reader.readLine());
      for (int col = 0; col < cols; col++) {
        matrix[row][col] = Integer.parseInt(stringTokenizer.nextToken());
      }
    }
    System.out.println(checkMatrix(matrix, cols, rows));
    ;
  }

  private static void initialize(int[][] matrix, int cols, int rows) {
    branchingCellCol = new ArrayDeque<>();
    branchingCellRow = new ArrayDeque<>();
    initializeVisitedCells(cols, rows);
    LargestSurface1.matrix = matrix;
    LargestSurface1.cols = cols;
    LargestSurface1.rows = rows;
    maxAreaSize = 0;
    currentAreaSize = 0;
  }

  private static void initializeVisitedCells(int cols, int rows) {
    visitedCells = new boolean[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        visitedCells[row][col] = false;
      }
    }
  }

  private static boolean isBranching(int row, int col) {
    int currentValue = matrix[row][col];
    if (col - 1 >= 0 && matrix[row][col - 1] == currentValue &&
            !isVisited(row, col - 1)) //left
    {
      return true;
    } else if (col + 1 < cols && matrix[row][col + 1] == currentValue &&
            !isVisited(row, col + 1))//right
    {
      return true;
    } else if (row - 1 >= 0 && matrix[row - 1][col] == currentValue &&
            !isVisited(row - 1, col))//up
    {
      return true;
    } else if (row + 1 < rows && matrix[row + 1][col] == currentValue &&
            !isVisited(row + 1, col))//down
    {
      return true;
    }
    return false;
  }


  private static boolean isVisited(int row, int col) {
    return visitedCells[row][col];
  }


  private static int checkMatrix(int[][] table, int cols, int rows) {
    initialize(table, cols, rows);

    for (int row = 0; row < LargestSurface1.rows; row++) {
      for (int col = 0; col < LargestSurface1.cols; col++) {
        if (!visitedCells[row][col] && isBranching(row, col)) {
          branchingCellCol.push(col);
          branchingCellRow.push(row);
          explore(col, row);
        }
      }
    }
    return maxAreaSize;
  }


  private static void explore(int col, int row) {
    int currentValue = matrix[row][col];
    //currentAreaSize++;
    while (branchingCellCol.size() > 0 && branchingCellRow.size() > 0) {
      col = branchingCellCol.pop();
      row = branchingCellRow.pop();


      int colTemp = col;
      int rowTemp = row;
      while (colTemp - 1 >= 0 && matrix[rowTemp][colTemp - 1] == currentValue &&
              !isVisited(rowTemp, colTemp - 1)) //left
      {
        colTemp = colTemp - 1;
        //rowTemp = rowTemp;
        branchingCellCol.push(colTemp);
        branchingCellRow.push(rowTemp);
        visitedCells[rowTemp][colTemp] = true;
        currentAreaSize++;
      }

      colTemp = col;
      rowTemp = row;
      while (colTemp + 1 < cols && matrix[rowTemp][colTemp + 1] == currentValue &&
              !isVisited(rowTemp, colTemp + 1))//right
      {
        colTemp = colTemp + 1;
        //rowTemp = rowTemp;
        branchingCellCol.push(colTemp);
        branchingCellRow.push(rowTemp);
        visitedCells[rowTemp][colTemp] = true;
        currentAreaSize++;
      }

      colTemp = col;
      rowTemp = row;
      while (rowTemp - 1 >= 0 && matrix[rowTemp - 1][colTemp] == currentValue &&
              !isVisited(rowTemp - 1, colTemp))//up
      {
        //colTemp = colTemp;
        rowTemp = rowTemp - 1;
        branchingCellCol.push(colTemp);
        branchingCellRow.push(rowTemp);
        visitedCells[rowTemp][colTemp] = true;
        currentAreaSize++;
      }

      colTemp = col;
      rowTemp = row;
      while (rowTemp + 1 < rows && matrix[rowTemp + 1][colTemp] == currentValue &&
              !isVisited(rowTemp + 1, colTemp))//down
      {
        //colTemp = colTemp;
        rowTemp = rowTemp + 1;
        branchingCellCol.push(colTemp);
        branchingCellRow.push(rowTemp);
        visitedCells[rowTemp][colTemp] = true;
        currentAreaSize++;
      }
    }
    if (currentAreaSize > maxAreaSize) {
      maxAreaSize = currentAreaSize;
    }
    currentAreaSize = 0;
  }
}
