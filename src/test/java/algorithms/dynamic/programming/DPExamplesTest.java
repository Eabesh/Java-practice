package algorithms.dynamic.programming;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by abhay on 20/06/17.
 */
public class DPExamplesTest {
  @Test
  public void largestZigZagSum() throws Exception {
    int[][] mat  = { {4, 2, 1},
            {3, 9, 6},
            {11, 3, 15}};
    int[][] mat2  = { {3, 1, 2},
            {4, 8, 5},
            {6, 9, 7}};
    assertEquals(28, new DPExamples().largestZigZagSum(mat));
    assertEquals(18, new DPExamples().largestZigZagSum(mat2));
  }

  @Test
  public void perfectSumProblem() throws Exception {
    int[] array = {2, 3, 5, 6, 8, 10};
    new DPExamples().perfectSumProblem(array, 10, array.length, "");
  }

  @Test
  public void twoSubsetDivide() throws Exception {
    int[] array = {3, 1, 4, 2, 2, 1};
    int arraySum = 13;
    assertEquals(1, new DPExamples().twoSubsetDivide(array, arraySum, array.length, 0));
  }

  @Test
  public void binomialCofficient() throws Exception {
    assertEquals(6, new DPExamples().binomialCoefficient(4, 2));
    assertEquals(6, new DPExamples().binomialCoefficientBottomUp(4, 2));
  }

  @Test
  public void largestKSqSubMat() throws Exception {
    int a[][] = {{2, 3, 3},
      {2, 3, 3},
      {2, 2, 2}};
    assertEquals(2, new DPExamples().largestKSqSubMat(a));
  }

  @Test
  public void knapsackUnbounded() throws Exception {
    int val[]  = {1, 30}, wt[] = {1, 50};
    assertEquals(100, new DPExamples().knapsackUnbounded(wt, val, 100));
    int val1[] = {10, 30, 20};
    int wt1[] = {5, 10, 15};
    assertEquals(300, new DPExamples().knapsackUnbounded(wt1, val1, 100));
  }

  @Test
  public void hasWords() throws Exception {
    Set<String> dictionary = new HashSet<>();
    dictionary.add("i");
    dictionary.add("like");
    assertEquals(true, new DPExamples().wordBreak("ilike", dictionary));
    assertEquals(true, new DPExamples().wordBreakDP("ilike", dictionary));
    assertEquals(true, new DPExamples().wordBreak("i", dictionary));
  }

  @Test
  public void LPSeq() throws Exception {
    String str = "aa";
    assertEquals(2, new DPExamples().LPSeq(str, 0, str.length() - 1));
    assertEquals(2, new DPExamples().LPSeqBottomUp(str));
  }

  @Test
  public void maxSISum() throws Exception {
    int arr[] = {1, 101, 2, 3, 100, 4, 5};
    assertEquals(106, new DPExamples().maxSISum(arr));

  }

  @Test
  public void minJumps() throws Exception {
    int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
    assertEquals(3, new DPExamples().minJumps(arr, 0, arr.length - 1));
    int[] arr2 = {1, 3, 6, 1, 0, 9};
    assertEquals(3, new DPExamples().minJumps(arr2, 0, arr2.length - 1));
    assertEquals(3, new DPExamples().minJumpsDP(arr2));
  }

  @Test
  public void rodCutting() throws Exception {
    int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
    assertEquals(22, new DPExamples().rodCutting(arr, arr.length));
  }

  @Test
  public void threeStringsLCS() throws Exception {
    String str1 = "ab", str2 = "ab", str3 = "abc";
    assertEquals(2, new DPExamples().threeStringsLCS(str1, str2, str3, str1.length(), str2.length(),
            str3.length()));
  }

  @Test
  public void maxGoldAmount() throws Exception {
    int mat[][] = {{1, 3, 3},
            {2, 1, 4},
            {0, 6, 4}};
    assertEquals(12, new DPExamples().maxGoldAmount(mat));
  }

  @Test
  public void minInsertionsToSort() throws Exception {
    int[] array = {1, 4, 2, 3};
    assertEquals(1, new DPExamples().minInsertionsToSort(array));
  }

  @Test
  public void maxLengthSnake() throws Exception {
    int[][] grid = {
            {9, 6, 5, 2},
            {8, 7, 6, 5},
            {7, 3, 1, 6},
            {1, 1, 1, 7},
    };
    assertEquals(6, new DPExamples().maxLengthSnake(grid));
    int[][] grid2 = {
            {10, 6, 5, 2},
            {8, 7, 6, 5},
            {7, 3, 1, 6},
            {1, 1, 1, 7},
    };
    assertEquals(5, new DPExamples().maxLengthSnake(grid2));
  }

  @Test
  public void minCost() throws Exception {
    int[][] cost =  { {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3} };
    assertEquals(8, new DPExamples().minCost(cost, cost.length - 1, cost[0].length - 1));
    assertEquals(8, new DPExamples().minCostBotUP(cost));
  }

  @Test
  public void knapsack() throws Exception {
    int[] values = {60, 100, 120};
    int[] weights = {10, 20, 30};
    assertEquals(220, new DPExamples().knapsack(weights, values, 50, weights.length));
    assertEquals(220, new DPExamples().knapsackDP(
            weights, values, 50, weights.length));
  }

  @Test
  public void LRS() throws Exception {
    String str = "axxxy";
    assertEquals(2, new DPExamples().LRS(str, str.length(), str.length()));
    assertEquals(2, new DPExamples().LRSDP(str));

   int res =  (new DPExamples().LRSDP("abab") >= 2) ? 1 : 0;
    System.out.println(res);
  }
  @Test
  public void countDigitSum() throws Exception {
//    assertEquals(2, new DPExamples().countDigitSum(2, 2));
  }

  @Test
  public void countIncreasingNum() throws Exception {
    assertEquals(10, new DPExamples().countIncreasingNum(1, 0));
    assertEquals(55, new DPExamples().countIncreasingNum(2, 0));
    assertEquals(220, new DPExamples().countIncreasingNum(3, 0));
  }

  @Test
  public void countMinSquares() throws Exception {
    assertEquals(3, new DPExamples().countMinSquares(6));
    assertEquals(1, new DPExamples().countMinSquaresBottomUp(100));
  }

  @Test
  public void findMinCoins() throws Exception {
    int[] coins = {9, 5, 6, 1};
    assertEquals(2, new DPExamples().findMinCoins(coins, 11));
    assertEquals(2, new DPExamples().findMinCoinsBottomUp(coins, 11));
  }

  @Test
  public void superSeq() throws Exception {
    String str1 = "abc", str2 = "b";
    assertEquals(3, new DPExamples().superSeq(str1, str2));
  }

  @Test
  public void waysToSumToN() throws Exception {
    int[] array = {1, 5, 6};
    assertEquals(6, new DPExamples().waysToSumToN(7, array));
    assertEquals(6, new DPExamples().waysToSumToNBottomUp(7, array));
  }

  @Test
  public void waysToConstructBuilding() throws Exception {
    assertEquals(4, new DPExamples().waysToConstructBuilding(1));
    assertEquals(25, new DPExamples().waysToConstructBuilding(3));
    assertEquals(64, new DPExamples().waysToConstructBuilding(4));
  }

  @Test
  public void minCostToDest() throws Exception {
    int[][] cost = { {0, 15, 80, 90},
            {Integer.MAX_VALUE, 0, 40, 50},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 70},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
    };
    assertEquals(65, new DPExamples().minCostToDest(cost, 0, 3));
  }

  @Test
  public void countWaysToScore() throws Exception {
    int[] choices = { 3, 5, 10};
    assertEquals(4, new DPExamples().countWaysToScore(20, choices, choices.length));
    assertEquals(2, new DPExamples().countWaysToScore(13, choices, choices.length));
    assertEquals(2, new DPExamples().countWaysToScoreBottomUp(13, choices, choices.length));
  }

  @Test
  public void countWalks() throws Exception {
    int[][] graph = { {0, 1, 1, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 0}
    };
    assertEquals(2, new DPExamples().countWalks(graph, 0, 3, 2));
  }

  @Test
  public void countStrings() throws Exception {
    assertEquals(3, new DPExamples().countStrings(2));
  }

  @Test
  public void countPaths() throws Exception {
    assertEquals(6, new DPExamples().countPaths(2, 2));
    assertEquals(6, new DPExamples().countPathsBottomUp(3, 3));
  }

  @Test
  public void countPathsAtKTurns() throws Exception {
    assertEquals(4, new DPExamples().countPathsAtKTurns(2, 2, 2));
  }

  @Test
  public void distanceCountWays() throws Exception {
    assertEquals(4, new DPExamples().distanceCountWays( 3));
  }

  @Test
  public void minCostForIdentical() throws Exception {
    String str1 = "ef", str2 = "gh";
    assertEquals(60, new DPExamples().minCostForIdentical(str1, str2, 10, 20));
  }

  @Test
  public void countPSubstrings() throws Exception {
    String str = "abbaeae";
    assertEquals(4, new DPExamples().countPSubstrings(str, 0, str.length() - 1));
  }

  @Test
  public void maxAvgPath() throws Exception {
    int[][] mat = {{1,  2, 3},
    {4, 5, 6},
    {7, 8, 9}};
    double res = new DPExamples().maxAvgPath(mat, mat.length - 1, mat[0].length - 1, 0, 0 );
    System.out.println(res);
  }

  @Test
  public void subsetAvgSum() throws Exception {
    int[] array = {2, 3, 5};
    double res = new DPExamples().subsetAvgSum(array, array.length, 0, 0);
    System.out.println(res);
  }

  @Test
  public void maxSubArraySum() throws Exception {
    int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
    assertEquals(9, new DPExamples().maxSubArraySum(arr));
  }

  @Test
  public void countWaysToReachDest() throws Exception {
    int[][] mat =  {{0,  0, 0, 0},
            {0, -1, 0, 0},
            {-1, 0, 0, 0},
            {0,  0, 0, 0}};
    assertEquals(4, new DPExamples().countWaysToReachDest(mat, mat.length - 1, mat[0].length - 1));
    assertEquals(4, new DPExamples().countWaysToReachDestBottomUp(mat));
  }

  @Test
  public void maxSumPath() throws Exception {
    int[][]  mat = { {4, 2, 3, 4},
      {2, 9, 1, 10},
      {15, 1, 3, 0},
      {16, 92, 41, 44} };
    assertEquals(120, new DPExamples().maxSumPath(mat));
    assertEquals(120, new DPExamples().maxSumPathBottomUp(mat));
  }

  @Test
  public void countStringFormed() throws Exception {
    String[] choices = {"a", "b" ,"c"};
    int[] remaining = {Integer.MAX_VALUE, 1, 2};
    assertEquals(19 , new DPExamples().countStringFormed(3, "", choices, remaining));
  }

  @Test
  public void printStringsFormed() throws Exception {
    String[] choices = {"a", "b" ,"c", "d"};
    int[] remaining = {Integer.MAX_VALUE, 1, 2, 3};
    new DPExamples().printStringFormed(3, "", choices, remaining);
  }

  @Test
  public void minDeletionToMakeSorted() throws Exception {
    int[] arr = {30, 40, 2, 5, 1, 7, 45, 50, 8};
    assertEquals(4, new DPExamples().minDeletionToMakeSorted(arr));

  }

  @Test
  public void nonDecresingInCount() throws Exception {
    assertEquals(10, new DPExamples().nonDecreasingInCount(1, 0));
    assertEquals(55, new DPExamples().nonDecreasingInCount(2, 0) );
  }

  @Test
  public void maxStealing() throws Exception {
    int[] hvals = {6, 7, 1, 3, 8, 2, 4};
    int[] hvals2 = {5, 3, 4, 11, 2};
    assertEquals(19, new DPExamples().maxStealing(hvals, hvals.length));
    assertEquals(19, new DPExamples().maxStealing(hvals, hvals.length));
    assertEquals(16, new DPExamples().maxStealingBottomUp(hvals2));
    assertEquals(16, new DPExamples().maxStealingBottomUp(hvals2));
  }

  @Test
  public void minInsertionDeletionBottomUp() throws Exception {
    assertEquals(2, new DPExamples().minInsertionDeletionBottomUp("heap", "pea", 4, 3)[0]);
  }

  @Test
  public void maxContiguousSubArray() throws Exception {
    int[] a = {3,2,7,10};
    int[] b = {-3,-22,-7,-10};
    assertEquals(22, new DPExamples().maxContiguousSubArray(a));
    assertEquals(-3, new DPExamples().maxContiguousSubArray(b));
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
//    double t1 = System.currentTimeMillis();
//
//    double t2 = System.currentTimeMillis();
//    System.out.println("time taken in secs : " + (t2 - t1)/1000);
    assertEquals(102334155, new DPExamples().fibonacci(40));
    assertEquals(102334155 , new DPExamples().fibonnaciDP(40));
    assertEquals(102334155 , new DPExamples().fibonnaciSpaceOpt(40, 0, 1));


  }

  @Test
  public void findLISBottomUp() throws Exception {
    int[] array = {3 , 10, 2, 1, 20};
    assertEquals(3, new DPExamples().findLISBottomUp(array));
  }

  @Test
  public void LIS() throws Exception {
    String str = "abc", str2 = "babc";
    assertEquals(3, new DPExamples().LCS(str, str2, str.length(), str2.length()));
  }

  @Test
  public void LISBottomUp() throws Exception {
    String str = "abc", str2 = "babc";
    assertEquals(3, new DPExamples().LCSBottomUp(str, str2));
  }

  @Test
  public void editDistace() throws Exception {
    String str = "abc", str2 = "babc";
    assertEquals(1, new DPExamples().editDistance(str, str2, str.length(), str2.length()));
    assertEquals(1, new DPExamples().editDistanceDP(str, str2));
  }

  @Test
  public void coinChange() throws Exception {
    int[] coins = {1, 2, 5};
    assertEquals(11, new DPExamples().coinChange(coins, coins.length, 4));
    assertEquals(11, new DPExamples().coinChangeDP(coins, 4));

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

  @Test
  public void maxLengthSub() {
   int arr[] = {2, 5, 6, 3, 7, 6, 5, 8};
   assertEquals(5, new DPExamples().maxLengthSub(arr));

   int arr1[] = {-2, -1, 5, -1, 4, 0, 3};
   assertEquals(4, new DPExamples().maxLengthSub(arr1));

  }

  @Test
  public void longestAP() {
    int array[] = {1, 7, 10, 13, 14, 19};
    int [] array2 = {100, 10, 8, 300, 6, 1, 4, 2};
    assertEquals(4, new DPExamples().longestAP(array2));
  }

  @Test
  public void sumOfAllSquares() {
    int[][] mat = {{0, 0}, {0, 0}};

    int[][] mat2 = { {1, 0, 0, 1},
                     {0, 0, 1, 0},
                     {0, 0, 0, 0},};

    int[][] mat3 = { { 1, 1, 1, 0, 1 },
                     { 1, 0, 0, 1, 0 },
                     { 1, 0, 0, 0, 1 },
                     { 0, 1, 1, 1, 1 } };


//    assertEquals(5, new DPExamples().sumOfAllSquares(mat));
    long millis = System.currentTimeMillis();
    assertEquals(9, new DPExamples().squaresCount(mat));
    long t2 = System.currentTimeMillis();
    System.out.println((t2 - millis) + "");

   assertEquals(9, new DPExamples().sumOfAllSquares(mat3));
    long t3 = System.currentTimeMillis();
    System.out.println((t3 - t2) + "");
  }

  @Test
  public void longestBS() {

    Integer arr[] = {80, 60, 30, 40, 20, 10};
    assertEquals(5, new DPExamples().longestBS(Arrays.asList(arr)));
  }


  @Test
  public void countOccurence() {
    String s = "rabbbit";
    String t = "rabbit";
    assertEquals(3, new DPExamples().countOccurence(s, t, s.length() - 1, t.length() - 1 ));
    assertEquals(3, new DPExamples().countOccuranceDP(s, t));
  }

  @Test
  public void isInterleaved() {
    String s1 = "XY", s2 = "WZ", s3 = "WZXY";
    assertTrue( new DPExamples().isInterleaved(s1, s2, s3, s1.length(), s2.length(), s3.length()));
    assertTrue( new DPExamples().isInterleavedDP(s1, s2, s3));
  }

  @Test
  public void numDecodings() {
    HashMap<String, String> map = new HashMap<>();
    for (int i = 0; i < 26; i++) map.put(String.valueOf(i + 1), Character.toString((char) (i + 65)));
    assertEquals(2, new DPExamples().numDecodings("12", map));
  }
}