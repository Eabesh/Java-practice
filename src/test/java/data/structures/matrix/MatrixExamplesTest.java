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

}