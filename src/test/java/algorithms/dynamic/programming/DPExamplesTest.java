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

  @Test
  public void fibonnaciDP() throws Exception {
    assertEquals(34, new DPExamples().fibonnaciDP(9));
    assertEquals(55 , new DPExamples().fibonnaciDP(10));
  }

  @Test
  public void fibonnaciSpaceOpt() throws Exception {
    assertEquals(34, new DPExamples().fibonnaciDP(9));
    assertEquals(55 , new DPExamples().fibonnaciDP(10));
  }

  @Test
  public void findLISBottomUp() throws Exception {
    int[] array = {3 , 10, 2, 1, 20};
    assertEquals(3, new DPExamples().findLISBottomUp(array));
  }

  @Test
  public void LIS() throws Exception {
    String str = "abc", str2 = "babc";
    assertEquals(3, new DPExamples().LIS(str, str2, str.length(), str2.length()));
  }

  @Test
  public void LISBottomUp() throws Exception {
    String str = "abc", str2 = "babc";
    assertEquals(3, new DPExamples().LISBottomUp(str, str2));
  }

  @Test
  public void editDistace() throws Exception {
    String str = "abc", str2 = "babc";
    assertEquals(1, new DPExamples().editDistance(str, str2, str.length(), str2.length()));
  }
}