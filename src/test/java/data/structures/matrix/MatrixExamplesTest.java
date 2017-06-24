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

}