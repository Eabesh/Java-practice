package algorithms.dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhay on 20/06/17.
 */
public class DPExamplesTest {

  @Test
  public void maxSumContigous() throws Exception {
    int[] a = {3,2,7,10};
    int[] b = {-3,-22,-7,-10};
    assertEquals(22, new DPExamples().maxContinousSubArray(a));
    assertEquals(-3, new DPExamples().maxContinousSubArray(b));
  }

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

  @Test
  public void coinChange() throws Exception {
    int[] coins = {1, 2, 3};
    assertEquals(4, new DPExamples().coinChange(coins, coins.length, 4));
  }

  @Test
  public void isSubsetSum() throws Exception {
    int[] coins = {1, 2, 3};
    assertEquals(true, new DPExamples().isSubsetSum(coins, coins.length, 5));
    assertFalse(new DPExamples().isSubsetSum(coins, coins.length, 8));
  }
  @Test
  public void minInsertion() {
    String str = "aac";
    assertEquals(1, new DPExamples().minInsertion(str, 0, str.length() - 1));
  }
  @Test
  public void findWays() {
    assertEquals(1, new DPExamples().findWays(2, 6, 2, 0));
    assertEquals(0, new DPExamples().findWays(4, 2, 1, 0));
  }

  @Test
  public void countPathsToOri() {
    assertEquals(84, new DPExamples().countPathsToOri(3, 6));
    assertEquals(1, new DPExamples().countPathsToOri(3, 0));
  }

  @Test
  public void minDeletion() {
    String str = "abc";
    assertEquals(2, new DPExamples().minDeletion(str, 0, str.length() - 1));
  }

  @Test
  public void maxDotProduct() {
    int []  A = {2, 4, 6};
    int[] B = {1, 2};
    assertEquals(16, new DPExamples().maxDotProduct(A, B, A.length, B.length));
    assertEquals(16, new DPExamples().maxDotProductBottomUp(A, B));
  }

}