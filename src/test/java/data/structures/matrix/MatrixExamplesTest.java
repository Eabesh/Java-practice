package data.structures.matrix;

import data.structures.graph.GraphExamples;
import data.structures.queue.QueueExamples;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixExamplesTest {

  @Test
  public void rotOranges() throws Exception {
    int[][] oranges1 = { {2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
    assertEquals(2, new MatrixExamples().rotOranges(oranges1));
    int[][] oranges2 = { {2, 1, 0, 2, 1}, {0, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
    assertEquals(-1, new MatrixExamples().rotOranges(oranges2));
    int[][] oranges3 = { {2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
    assertEquals(2, new QueueExamples().rotOranges(oranges3));
    int[][] oranges4 = { {2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
    assertEquals(2, new GraphExamples().rotOranges(oranges4));
  }

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
    int[][] maze =
            {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
    int[] dest = {3, 4};
    int[][] moves = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    assertEquals(11, new MatrixExamples().shortesPathInMaze(maze, dest, 0, 0, 0, moves));
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

  @Test
  public void diagnalsDiff(){
    int[][] mat = {
            {11, 2, 4},
            {4 , 5, 6},
            {10, 8, -12}
    };

    assertEquals(15, new MatrixExamples().diagnalsDiff(mat));
  }

  @Test
  public void gvTest() {
    new MatrixExamples().gvGenerator("LILEC997D");
  }


}