package algorithms.dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhay on 20/06/17.
 */
public class DPExamplesTest {
  @Test
  public void maxContinousSubArray1() throws Exception {
  }

  @Test
  public void maxSizeSquareMat() throws Exception {
    int[][] mat = {{0, 1, 1, 0, 1}, {1, 1, 0, 1, 0},{0, 1, 1, 1, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1},{0, 0, 0, 0, 0}};
    int[][] dp = new int[mat.length][mat[0].length];

    dp = new DPExamples().maxSizeSquareMat(mat, dp);
    printMatrix(dp);
  }
  void printMatrix(int[][] dp) {

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
  }


}