package data.structures.matrix;

import algorithms.backtracking.BackTrackingExamples;
import algorithms.dynamic.programming.DPExamples;
import data.structures.graph.GraphExamples;
import data.structures.queue.QueueExamples;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class MatrixExamplesTest {


  @Test
  public void turnBy90() throws Exception {
    int[][] mat = {{1, 2, 3}, {4, 5, 6}};
    new MatrixExamples().turnBy90(mat);
  }

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
    int[][] mat = { {1,  2,  3,  4,  5,  6},
            {7,  8,  9,  10, 11, 12},
            {13, 14, 15, 16, 17, 18}
    };
    new MatrixExamples().spiralPrint(mat);

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
//    assertEquals(11, new MatrixExamples().shortesPathInMaze(maze, dest, 0, 0, 0, moves));
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
  public void redrawMatrix() {
    int[][] mat = {{0, 0, 0, 1, 0 }, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0 }, {1, 0, 0, 0, 1}, {0, 1, 0, 1, 0}};
    new MatrixExamples().redrawMatrix(mat);
  }

  @Test
  public void searchInMat() {
    int mat[][] = { {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50} };
    new MatrixExamples().searchInMat(mat, 29);
  }

  @Test
  public void kSmallest() {
    int[][] mat =  { {10, 20, 30, 40},
            {15, 25, 35, 45},
            {25, 29, 37, 48},
            {32, 33, 39, 50},
    };

    assertEquals(20, new MatrixExamples().kSmallest(mat, 3));
    assertEquals(30, new MatrixExamples().kSmallest(mat, 7));
    assertEquals(30, new MatrixExamples().kSmallest(mat, 7));
  }

  @Test
  public void kLargest() {

    int[][] mat =  { {10, 20, 30, 40},
            {15, 25, 35, 45},
            {25, 29, 37, 48},
            {32, 33, 39, 50},
    };
    assertEquals(33, new MatrixExamples().kLargest(mat, 8));


  }

  @Test
  public void getMatrix() {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter("/Users/abhay/Desktop/out.txt", "UTF-8");
    } catch (FileNotFoundException e) {
    } catch (UnsupportedEncodingException e) {
    }
    int[][] mat = new MatrixExamples().getMatrix(1100, 1100, writer);
    writer.close();
    System.out.println(new DPExamples().sumOfAllSquares(mat));
  }
}