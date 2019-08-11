package number_of_islands;

public class NumberOfIslands {
  public static void main(String[] args) {
    char[][] matrix = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'},
    };

    System.out.println(countOfIslands(matrix));
  }

  private static int countOfIslands(char[][] matrix) {
    int count = 0;

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (matrix[row][col] == '1') {
          count++;
          move(row, col, matrix);
        }
      }
    }
    return count;
  }

  private static void move(int row, int col, char[][] matrix) {
    if (!isDirection(row, col, matrix)) {
      return;
    }

    matrix[row][col] = 'x';

    //up
    move(row - 1, col, matrix);
    //down
    move(row + 1, col, matrix);
    //left
    move(row, col - 1, matrix);
    //right
    move(row, col + 1, matrix);
  }

  private static boolean isDirection(int row, int col, char[][] matrix) {
    return row >= 0
            && col >= 0
            && row < matrix.length
            && col < matrix[row].length
            && matrix[row][col] == '1';
  }
}
