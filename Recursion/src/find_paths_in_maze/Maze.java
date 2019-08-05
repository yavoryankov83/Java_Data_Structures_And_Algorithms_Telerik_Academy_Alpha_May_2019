package find_paths_in_maze;

public class Maze {
  private static final char WALL = '\u25A0';
  private static final char EMPTY_SPACE = '\u25CB';
  private static final char VISITED = '\u25CD';
  private static final char EXIT = '\u25A1';

  public static void main(String[] args) {
    char[][] maze = {
            {EMPTY_SPACE, WALL, EMPTY_SPACE, EMPTY_SPACE, WALL, EXIT},
            {EMPTY_SPACE, WALL, WALL, EMPTY_SPACE, WALL, EMPTY_SPACE},
            {EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL, WALL, EMPTY_SPACE},
            {EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE},
            {EMPTY_SPACE, WALL, WALL, EMPTY_SPACE, WALL, EMPTY_SPACE},
    };

    printMaze(maze);
    System.out.println();
    //System.out.println(hasPath(maze));
    //printMaze(maze);
    //findPath(maze);
    System.out.println(findALLPaths(maze));
  }

  private static boolean hasPath(char[][] maze){
    return hasPath(0, 0, maze);
  }

  private static boolean hasPath(int row, int col, char[][] maze){
    if (!isInRange(row, col, maze)){
      return false;
    }

    if (maze[row][col] == WALL){
      return false;
    }
    if (maze[row][col] == EXIT){
      return true;
    }
    if (maze[row][col] == VISITED){
      return false;
    }

    maze[row][col] = VISITED;

    boolean checkUp = hasPath(row - 1, col, maze);
    boolean checkDown = hasPath(row + 1, col, maze);
    boolean checkLeft = hasPath(row, col - 1, maze);
    boolean checkRight = hasPath(row, col + 1, maze);

    return checkUp || checkDown || checkLeft || checkRight;
  }

  private static void findPath(char[][] maze){
    findPath(0, 0, maze);
  }

  private static void findPath(int row, int col, char[][] maze){
    if (!isInRange(row, col, maze)){
      return;
    }

    if (maze[row][col] == WALL){
      return;
    }
    if (maze[row][col] == EXIT){
      printMaze(maze);
      return;
    }
    if (maze[row][col] == VISITED){
      return;
    }

    maze[row][col] = VISITED;

    findPath(row - 1, col, maze);
    findPath(row + 1, col, maze);
    findPath(row, col - 1, maze);
    findPath(row, col + 1, maze);
  }

  private static int findALLPaths(char[][] maze){
    return findALLPaths(0, 0, maze);
  }

  private static int findALLPaths(int row, int col, char[][] maze){
    int counter = 0;
    if (!isInRange(row, col, maze)){
      return counter;
    }

    if (maze[row][col] == WALL){
      return counter;
    }
    if (maze[row][col] == EXIT){
      printMaze(maze);
      System.out.println();
      return ++counter;
    }
    if (maze[row][col] == VISITED){
      return counter;
    }

    maze[row][col] = VISITED;

    counter += findALLPaths(row - 1, col, maze);
    counter += findALLPaths(row + 1, col, maze);
    counter += findALLPaths(row, col - 1, maze);
    counter += findALLPaths(row, col + 1, maze);

    maze[row][col] = EMPTY_SPACE;

    return counter;
  }

  private static boolean isInRange(int row, int col, char[][] maze){
    return (row >= 0 && col >= 0 && row < maze.length && col < maze[row].length);
  }

  private static void printMaze(char[][] maze){
    for (int row = 0; row < maze.length; row++) {
      for (int col = 0; col < maze[row].length; col++) {
        System.out.print("|" + maze[row][col]);
      }
      System.out.println("|");
    }
  }
}
