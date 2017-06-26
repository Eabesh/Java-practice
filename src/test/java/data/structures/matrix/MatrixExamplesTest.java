package data.structures.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhay on 24/06/17.
 */
public class MatrixExamplesTest {
  @Test
  public void spiralPrint() throws Exception {
  }

  @Test
  public void printDiagonal() throws Exception {
  }

  @Test
  public void maxCoinsRec() throws Exception {
  }

  @Test
  public void largestRect() throws Exception {
    int[][] mat = {{0, 1, 1, 0},{1, 1, 1, 1},{1, 1, 1, 1},{1, 1, 0, 0}};
    assertEquals(8, new MatrixExamples().largestRect(mat));
  }
  @Test
  public void countPathsKCoins() throws Exception {
    int[][] mat = { {1, 2, 3}, {4, 6, 5}, {3, 2, 1} };
    int k = 12;
    assertEquals(2, new MatrixExamples().countPathsKCoins(mat, mat.length - 1, mat[0].length - 1, k));
  }

  @Test
  public  void shortestPathInMaze() {
    int[][] maze = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
    int[] dest = {3, 4};
    int[][] moves = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    assertEquals(11, new MatrixExamples().shortesPathInMaze(maze, dest, 0, 0, 0, moves, visited));
  }

  @Test
  public void countIslands() {
    int[][] mat = {
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1}};
    assertEquals(3, new MatrixExamples().countIslands(mat));
  }

  @Test
  public void printAllPaths(){
    int[][] mat = { {1, 2, 3}, {4, 5, 6} };
    new MatrixExamples().printAllPaths(mat, "",  0, 0);
  }
}