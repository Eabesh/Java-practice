package algorithms.dynamic.programming;

import recursion.RecursionExamples;

import java.util.Arrays;
import java.util.Set;

public class DPExamples {

  /**
   * 1.
   * Problem: Largest Sum Contiguous Subarray.
   * Write an efficient C program to find the sum of contiguous sub array within a one-dimensional array of numbers
   * which has the largest sum.
   */
  public int maxContiguousSubArray(int[] array) {
    int maxSoFar = array[0], currMax = array[0];
    for (int i = 1; i < array.length; i++) {
      currMax = Math.max(array[i], currMax + array[i]);
      maxSoFar = Math.max(maxSoFar, currMax);
    }
    return maxSoFar;
  }


  /**
   * 2.
   * Problem: Ugly Numbers
   * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
   * shows the first 11 ugly numbers. By convention, 1 is included.
   * Given a number n, the task is to find n’th Ugly number.
   */

  /**
   * 3.
   * Problem: Maximum size square sub-matrix with all 1s
   * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
   */
  public int[][] maxSizeSquareMat(int[][] mat, int[][] dp) {
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (i == 0 || j == 0) dp[i][j] = mat[i][j];
        else if (mat[i][j] == 0) dp[i][j] = 0;
        else dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
      }
    }
    return dp;
  }

  /**
   * 4.
   * Problem: Program for Fibonacci numbers
   * The Fibonacci numbers are the numbers in the following integer sequence. 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
   */
  int fibonacci(int n) {
    if (n == 0 || n == 1) return n;
    else return fibonacci(n - 1) + fibonacci(n - 2);
  }

  int fibonnaciDP(int n) {
    int[] dp = new int[n + 1];
    for (int i = 0; i < dp.length; i++) {
      if (i == 0 || i == 1) dp[i] = i;
      else dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  int fibonnaciSpaceOpt(int n, int first, int second) {
    if (n == 0) return first;
    else return fibonnaciSpaceOpt(n - 1, second, first + second);
  }

  /**
   * 5.
   * Problem: Dynamic Programming | Set 1 (Overlapping Sub-problems Property)
   * 1) Overlapping Sub-problems: Like Divide and Conquer, Dynamic Programming combines solutions to sub-problems.
   * Dynamic Programming is mainly used when solutions of same sub-problems are needed again and again. In dynamic
   * programming, computed solutions to sub-problems are stored in a table so that these don’t have to recomputed. So
   * Dynamic Programming is not useful when there are no common (overlapping) sub-problems because there is no point
   * storing the solutions if they are not needed again. For example, Binary Search doesn’t have common sub-problems.
   * If we take example of following recursive program for Fibonacci Numbers, there are many sub-problems which are
   * solved again and again.
   * There are following two different ways to store the values so that these values can be reused:
   * a) Memoization (Top Down) (b) Tabulation (Bottom Up)
   */

  /**
   * 6.
   * Problem: Dynamic Programming | Set 2 (Optimal Substructure Property)
   * 2) Optimal Substructure: A given problems has Optimal Substructure Property if optimal solution of the given
   * problem can be obtained by using optimal solutions of its sub-problems.
   */

  /**
   * 7.
   * Problem: Dynamic Programming | Set 3 (Longest Increasing Subsequence)
   */
  int findLISBottomUp(int[] array) {
    int[] dp = new int[array.length];
    Arrays.fill(dp, 1);
    for (int i = 1; i < dp.length; i++)
      for (int j = 0; j < i; j++) if (array[i] > array[j] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;

    int max = 0;
    for (int i = 0; i < dp.length; i++) max = Math.max(max, dp[i]);
    return max;
  }

  /**
   * 8.
   * Problem: Dynamic Programming | Set 4 (Longest Common Subsequence)
   * Given two sequences, find the length of longest subsequence present in both of
   * them. A subsequence is a sequence that appears in the same relative order, but
   * not necessarily contiguous.
   * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
   * Solution: Recursive Complexity = O(2^n).
   */
  int LCS(String str1, String str2, int m, int n) {
    if (m == 0 || n == 0) return 0;
    else if (str1.charAt(m - 1) == str2.charAt(n - 1)) return 1 + LCS(str1, str2, m - 1, n - 1);
    else return Math.max(LCS(str1, str2, m - 1, n), LCS(str1, str2, m, n - 1));
  }

  int LCSBottomUp(String str1, String str2) {
    int[][] dp = new int[str1.length() + 1][str2.length() + 1];
    for (int i = 1; i <= str1.length(); i++) {
      for (int j = 1; j <= str2.length(); j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
        else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
      }
    }
    return dp[str1.length()][str2.length()];
  }

  /**
   * 9.
   * Problem: Dynamic Programming | Set 5 (Edit Distance)
   * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits
   * (operations) required to convert ‘str1’ into ‘str2’.
   * Insert
   * Remove
   * Replace
   * Solution:
   */
  int editDistance(String str1, String str2, int m, int n) {
    if (m == 0) return n;
    else if (n == 0) return m;
    else if (str1.charAt(m - 1) == str2.charAt(n - 1)) return editDistance(str1, str2, m - 1,
            n - 1);
    else return 1 + Math.min(editDistance(str1, str2, m, n - 1), Math.min(editDistance(str1, str2,
              m - 1, n), editDistance(str1, str2, m - 1, n - 1)));
  }


  /**
   * 10.
   * Problem: Dynamic Programming | Set 6 (Min Cost Path)
   * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost
   * path to reach (m, n) from (0, 0).
   */
  int minCost(int[][] mat, int i, int j) {
    if (i < 0 || j < 0) return Integer.MAX_VALUE;
    else if (i == 0 && j == 0) return mat[i][j];
    else return mat[i][j] + Math.min(minCost(mat, i - 1, j), Math.min(minCost(mat, i, j - 1),
              minCost(mat, i - 1, j - 1)));
  }

  int minCostBotUP(int[][] mat) {
    int[][] dp = new int[mat.length][mat[0].length];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (i == 0 && j == 0) dp[i][j] = mat[0][0];
        else if (i == 0) dp[i][j] = dp[i][j - 1] + mat[i][j];
        else if (j == 0) dp[i][j] = dp[i - 1][j] + mat[i][j];
        else dp[i][j] = mat[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
      }
    }
    return dp[mat.length - 1][mat[0].length - 1];
  }

  /**
   * 11.
   * Problem: Length of the longest substring without repeating characters
   * Given a string, find the length of the longest substring without repeating characters. For example, the longest
   * substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6.
   * For “BBBB” the longest substring is “B”, with length 1.
   * Solution:
   * Method 1 (Simple)
   * We can consider all substrings one by one and check for each substring whether it contains all unique characters or
   * not.There will be n*(n+1)/2 substrings. Whether a substirng contains all unique characters or not can be checked in
   * linear time by scanning it from left to right and keeping a map of visited characters. Time complexity of this
   * solution would be O(n^3).
   *
   *
   */


  /**
   * 12.
   * Problem: Minimum number of jumps to reach end
   * Given an array of integers where each element represents the max number of steps that can be made forward from that
   * element.Write a function to return the minimum number of jumps to reach the end of the array (starting from the
   * first element). If an element is 0, then cannot move through that element.
   */
  public int minJumps(int[] array, int start, int end) {
    if (start == end) return 0;
    else if (array[start] == 0) return Integer.MAX_VALUE;
    else {
      int min = Integer.MAX_VALUE;
      for (int jump = 1; jump <= array[start]; jump++)
        if (start + jump < array.length) {
          int subResult = minJumps(array, start + jump, end);
          if (subResult != Integer.MAX_VALUE) min = Math.min(min, 1 + subResult);
        }
      return min;
    }
  }

  /**
   * 13.
   * Problem: Dynamic Programming | Set 7 (Coin Change)
   * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. ,
   * Sm}valued coins, how many ways can we make the change? The order of coins doesn’t matter.
   */
  int coinChange(int coins[], int numOfCoins, int sum) {
    if (sum == 0) return 1;
    else if (numOfCoins <= 0 && sum > 0 || sum < 0) return 0;
    else return coinChange(coins, numOfCoins, sum - coins[numOfCoins - 1]) +
              coinChange(coins, numOfCoins - 1, sum);
  }


  /**
   * 14.
   * Problem: Dynamic Programming | Set 8 (Matrix Chain Multiplication)
   * Solution:
   */

  /**
   * 15.
   * Problem: Dynamic Programming | Set 9 (Binomial Coefficient)
   * Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k).
   */
  public int binomialCoefficient(int n, int k) {
    if (n == k || k == 0) return 1;
    else return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
  }

  int binomialCoefficientBottomUp(int n, int k) {
    int[][] dp = new int[n + 1][k + 1];
    for (int i = 0; i < dp.length; i++)
      for (int j = 0; j <= Math.min(i, k); j++) {
        if (i == j || j == 0) dp[i][j] = 1;
        else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
      }
    return dp[n][k];
  }


  /**
   * 16.
   * Problem: Dynamic Programming | Set 10 ( 0-1 Knapsack Problem)
   * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value
   * in the knapsack.
   */
  int knapsack(int[] weights, int[] values, int capacity, int m) {
    if (m == 0 || capacity == 0) return 0;
    else if (capacity < weights[m - 1]) return knapsack(weights, values, capacity, m - 1);
    else return Math.max(values[m - 1] + knapsack(weights, values, capacity - weights[m - 1], m - 1),
              knapsack(weights, values, capacity, m - 1));
  }

  int knapsackDP(int[] weight, int[] values, int capacity, int m) {
    int[][] dp = new int[m + 1][capacity + 1];
    for (int n = 0; n <= m; n++){
      for (int c = 0; c <= capacity; c++) {
        if (n == 0 || c == 0) dp[n][c] = 0;
        else if (c < weight[n - 1]) dp[n][c] = dp[n - 1][c];
        else dp[n][c] = Math.max(values[n - 1] + dp[n - 1][c - weight[n - 1]], dp[n - 1][c]);
      }
    }
    return dp[m][capacity];
  }

  /**
   * 17.
   * Problem: Dynamic Programming | Set 11 (Egg Dropping Puzzle)
   * Solution:
   */


  /**
   * 18.
   * Problem: Dynamic Programming | Set 12 (Longest Palindromic Subsequence)
   * Given a sequence, find the length of the longest palindromic subsequence in it.
   */
  int LPSeq(String str, int start, int end) {
    if (start == end) return 1;
    else if (start + 1 == end && str.charAt(start) == str.charAt(end)) return 2;
    else if (str.charAt(start) == str.charAt(end)) return 2 + LPSeq(str, start + 1, end - 1);
    else return Math.max(LPSeq(str, start + 1, end), LPSeq(str, start, end - 1));
  }

  int LPSeqBottomUp(String str) {
    int[][] dp = new int[str.length()][str.length()];
    for (int i = 0; i < dp.length; i++) dp[i][i] = 1;
    for (int col = 2; col <= dp[0].length; col++)
      for (int i = 0; i < dp[0].length - col + 1; i++) {
        int j = i + col - 1;
        if (str.charAt(i) == str.charAt(j) && col == 2) dp[i][j] = 2;
        else if (str.charAt(i) == str.charAt(j)) dp[i][j] = 2 + dp[i + 1][j - 1];
        else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
      }
    return dp[0][dp[0].length - 1];
  }

  /**
   * 19.
   * Problem: Dynamic Programming | Set 13 (Cutting a Rod)
   * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
   * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
   * Solution:
   */
  int rodCutting(int[] price, int rodLength) {
    if (rodLength <= 0) return 0;
    else {
      int maxProfit = Integer.MIN_VALUE;
      for (int i = 0; i < price.length; i++)
        if (rodLength >= i + 1) maxProfit = Math.max(maxProfit, price[i] + rodCutting(price, rodLength - (i + 1)));
      return maxProfit;
    }
  }


  /**
   * 20.
   * Problem: Dynamic Programming | Set 14 (Maximum Sum Increasing Subsequence)
   * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given
   * array such that the intgers in the subsequence are sorted in increasing order.
   */
  int maxSISum(int[] array) {
    int max = 0;
    int[] maxSis = new int[array.length];
    for (int i = 0; i < array.length; i++) maxSis[i] = array[i];
    for (int i = 1; i < array.length; i++)
      for (int j = 0; j < i; j++)
        if (array[j] < array[i] && maxSis[i] < array[i] + maxSis[j]) maxSis[i] = array[i] + maxSis[j];
    for (int element : maxSis) max = Math.max(max, element);
    return max;
  }


  /**
   * 21.
   * Problem: Dynamic Programming | Set 15 (Longest Bitonic Subsequence)
   * Solution:
   */

  /**
   * 22.
   * Problem: Dynamic Programming | Set 16 (Floyd Warshall Algorithm)
   * Solution:
   */

  /**
   * 23.
   * Problem: Dynamic Programming | Set 17 (Palindrome Partitioning)
   * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a
   * palindrome.
   * Solution:
   */

  /**
   * 24.
   * Problem: Dynamic Programming | Set 18 (Partition problem)
   * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of
   * elements in both subsets is same.
   * Solution:
   * Method 1: Recursive solution with Time Complexity as O(2^n).
   * Method 2: Dynamic Programming Solution.
   * The problem can be solved using dynamic programming when the sum of the elements is not too big. We can create a 2D
   * array part[][] of size (sum/2)*(n+1). And we can construct the solution in bottom up manner such that every filled
   * entry has following property: part[i][j] = true if a subset of {arr[0], arr[1], ..arr[j-1]} has
   * sum equal to i, otherwise false
   */
  boolean findPartition(int[] array) {
    int sum = Arrays.stream(array).sum();
    if (isOdd(sum)) return false;
    else {
      boolean[][] partition = new boolean[sum / 2 + 1][array.length + 1];
      for (int i = 0; i <= array.length; i++) partition[0][i] = true;
      for (int i = 1; i <= sum / 2; i++) partition[i][0] = false;
      for (int i = 1; i <= sum / 2; i++) {
        for (int j = 1; j <= array.length; j++) {
          partition[i][j] = partition[i][j - 1];
          if (i >= array[j - 1])
            partition[i][j] = partition[i][j] || partition[i - array[j - 1]][j - 1];
        }
      }
      return partition[sum / 2][array.length];
    }
  }

  private boolean isOdd(int n) {
    return n % 2 != 0;
  }

  /**
   * 25.
   * Problem: Dynamic Programming | Set 19 (Word Wrap Problem)
   * Solution:
   */


  /**
   * 26.
   * Problem: Dynamic Programming | Set 20 (Maximum Length Chain of Pairs)
   * Solution:
   */

  /**
   * 27.
   * Problem: Dynamic Programming | Set 21 (Variations of LIS)
   * Solution:
   */

  /**
   * 28.
   * Problem: Dynamic Programming | Set 22 (Box Stacking Problem)
   * Solution:
   */

  /**
   * 29.
   * Problem: Longest Palindromic Substring | Set 1
   * Solution:
   */

  /**
   * 30.
   * Problem: Dynamic Programming | Set 23 (Bellman–Ford Algorithm)
   * Solution:
   */

  /**
   * 31.
   * Problem: Dynamic Programming | Set 24 (Optimal Binary Search Tree)
   * Solution:
   */

  /**
   * 32.
   * Problem: Dynamic Programming | Set 25 (Subset Sum Problem)
   * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum
   * equal to given sum.
   */
  boolean isSubsetSum(int[] set, int setLen, int sum) {
    if (sum == 0) return true;
    else if (setLen == 0 && sum > 0) return false;
    else if (sum < set[setLen - 1]) return isSubsetSum(set, setLen - 1, sum);
    else return isSubsetSum(set, setLen - 1, sum - set[setLen - 1]) ||
              isSubsetSum(set, setLen - 1, sum);
  }

  /**
   * 33.
   * Problem: Dynamic Programming | Set 26 (Largest Independent Set Problem)
   * Solution:
   */

  /**
   * 34.
   * Problem: Dynamic Programming | Set 27 (Maximum sum rectangle in a 2D matrix)
   * Given a 2D array, find the maximum sum subarray in it. For example, in the following 2D array, the maximum sum
   * subarray is highlighted with blue rectangle and sum of this subarray is 29
   * Solution:
   * Kadane’s algorithm for 1D array can be used to reduce the time complexity to O(n^3). The idea is to fix the left
   * and right columns one by one and find the maximum sum contiguous rows for every left and right column pair.
   * We basically find top and bottom row numbers (which have maximum sum) for every fixed left and right column pair.
   * To find the top and bottom row numbers, calculate sun of elements in every row from left to right and store these
   * sums in an array say temp[]. So temp[i] indicates sum of elements from left to right in row i. If we apply Kadane’s
   * 1D algorithm on temp[], and get the maximum sum subarray of temp, this maximum sum would be the maximum possible
   * sum with left and right as boundary columns. To get the overall maximum sum, we compare this sum with the maximum
   * sum so far.
   */

  /**
   * 35.
   * Problem: Dynamic Programming | Set 28 (Minimum insertions to form a palindrome)
   * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
   */
  int minInsertion(String str, int left, int right) {
    if (left > right) return Integer.MAX_VALUE;
    else if (left == right) return 0;
    else if (left + 1 == right) return (str.charAt(left) == str.charAt(right)) ? 0 : 1;
    else if (str.charAt(left) == str.charAt(right)) return minInsertion(str, left + 1, right - 1);
    else return 1 + Math.min(minInsertion(str, left + 1, right), minInsertion(str, left, right - 1));
  }

  /**
   * 36.
   * Problem: Dynamic Programming | Set 29 (Longest Common Substring)
   * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
   * Solution:
   */


  /**
   * 37.
   * Problem: Dynamic Programming | Set 30 (Dice Throw)
   * Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X. X is the summation of
   * values on each face when all the dice are thrown.
   * Solution:
   */
  int findWays(int dices, int faces, int sum, int totalWays) {
    if (sum < 1) return 0;
    else if (dices == 1) return sum <= faces ? 1 : 0;
    else {
      for (int i = 1; i <= faces; i++) totalWays += findWays(dices - 1, faces, sum - i, 0);
      return totalWays;
    }
  }


  /**
   * 38.
   * Problem: Dynamic Programming | Set 31 (Optimal Strategy for a Game)
   * Solution:
   */


  /**
   * 39.
   * Problem: Dynamic Programming | Set 32 (Word Break Problem)
   * Given an input string and a dictionary of words, find out if the input string can be segmented into a space-
   * separated sequence of dictionary words
   */
  boolean wordBreak(String str, Set<String> dictionary) {
    if (str.isEmpty()) return true;
    else {
      for (int i = 0; i < str.length(); i++)
        if (dictionary.contains(str.substring(0, i + 1)) && wordBreak(str.substring(i + 1), dictionary)) return true;
    }
    return false;
  }

  /**
   * 40.
   * Problem: Dynamic Programming | Set 33 (Find if a string is interleaved of two other strings)
   * Solution:
   */


  /**
   * 41.
   * Problem: Dynamic Programming | Set 34 (Assembly Line Scheduling)
   * Solution:
   */


  /**
   * 42.
   * Problem: Dynamic Programming | Set 35 (Longest Arithmetic Progression)
   * Solution:
   */

  /**
   * 43.
   * Problem: Dynamic Programming | Set 36 (Maximum Product Cutting)
   * Solution:
   */

  /**
   * 44.
   * Problem: Travelling Salesman Problem | Set 1 (Naive and Dynamic Programming)
   */

  /**
   * 45.
   * Problem: Count all possible paths from top left to bottom right of a mXn matrix
   * The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints
   * that from each cell you can either move only to right or down
   */
  int countPaths(int m, int n) {
    if (m == 0 || n == 0) return 1;
    else return countPaths(m - 1, n) + countPaths(m, n - 1);
  }

  int countPathsBottomUp(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < dp.length; i++)
      for (int j = 0; j < dp[0].length; j++)
        if (i == 0 || j == 0) dp[i][j] = 1;
        else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    return dp[m - 1][n - 1];
  }


  /**
   * 46.
   * Problem: Remove minimum elements from either side such that 2*min becomes more than max
   * Solution:
   */


  /**
   * 47.
   * Problem: Program for nth Catalan Number
   * Solution:
   */

  /**
   * 48.
   * Problem: Dynamic Programming | Set 37 (Boolean Parenthesization Problem)
   * Solution:
   */

  /**
   * 49.
   * Problem: Count number of binary strings without consecutive 1’s
   * Given a positive integer N, count all possible distinct binary strings of length N such that there are no
   * consecutive 1’s.
   */

  int countStrings(int n) {
    return countWith1AtEnd(n) + countWith0AtEnd(n);
  }

  private int countWith1AtEnd(int n) {
    if (n == 1) return 1;
    else return countWith0AtEnd(n - 1);
  }

  private int countWith0AtEnd(int n) {
    if (n == 1) return 1;
    else return countWith1AtEnd(n - 1) + countWith0AtEnd(n - 1);
  }


  /**
   * 50.
   * Problem: Count Possible Decodings of a given Digit Sequence
   * Solution:
   */

  /**
   * 51.
   * Problem: Count all possible walks from a source to a destination with exactly k edges
   * Given a directed graph and two vertices ‘u’ and ‘v’ in it, count all possible walks from ‘u’ to ‘v’ with exactly
   * k edges on the walk.
   */
  public int countWalks(int[][] graph, int source, int dest, int k) {
    if (k == 0 && source == dest) return 1;
    else if (k == 1 && graph[source][dest] == 1) return 1;
    else if (k <= 0) return 0;
    else {
      int count = 0;
      for (int i = 0; i < graph[0].length; i++)
        if (graph[source][i] == 1) count += countWalks(graph, i, dest, k - 1);
      return count;
    }
  }

  int countWalksDP(int[][] graph, int source, int dest, int k) {
    int[][][] walks = new int[source][dest][k + 1];
    for (int e = 0; e <= k; e++) {
      for (int s = 0; s < graph.length; s++) {
        for (int d = 0; d < graph.length; d++) {
          walks[s][d][e] = 0;
          if (e == 0 && s == d) walks[s][d][e] = 1;
          if (e == 1 && graph[s][d] == 1) walks[s][d][e] = 1;
          if (e > 1) for (int a = 0; a < graph.length; a++) if (graph[s][a] == 1) walks[s][d][e] += walks[s][d][e - 1];
        }
      }
    }
    return walks[source][dest][k];
  }


  /**
   * 52.
   * Problem: Shortest path with exactly k edges in a directed and weighted graph
   * Solution:
   */

  /**
   * 53.
   * Problem: Mobile Numeric Keypad Problem
   * Solution:
   */

  /**
   * 54.
   * Problem: Minimum Cost Polygon Triangulation
   * Solution:
   */

  /**
   * 55.
   * Problem: Longest Even Length Substring such that Sum of First and Second Half is same
   * Solution:
   */

  /**
   * 56.
   * Problem: Weighted Job Scheduling
   * Solution:
   */


  /**
   * 57.
   * Problem: Count number of ways to reach a given score in a game
   * Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find number of ways
   * to reach the given score.
   */
  int countWaysToScore(int n, int[] points, int index) {
    if (n == 0) return 1;
    else if (index <= 0) return 0;
    else if (n < points[index - 1]) return countWaysToScore(n, points, index - 1);
    else
      return countWaysToScore(n - points[index - 1], points, index)
              + countWaysToScore(n, points, index - 1);
  }

  int countWaysToScoreBottomUp(int n, int[] points, int index) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 0; i < points.length; i++)
      for (int j = points[i]; j <= n; j++) dp[j] += dp[j - points[i]];
    return dp[n];
  }


  /**
   * 58.
   * Problem: Vertex Cover Problem | Set 2 (Dynamic Programming Solution for Tree)
   * Solution:
   */

  /**
   * 59.
   * Problem: Find the minimum cost to reach destination using a train
   * There are N stations on route of a train. The train goes from station 0 to N-1. The ticket cost for all pair of
   * stations (i, j) is given where j is greater than i. Find the minimum cost to reach the destination.
   */
  int minCostToDest(int[][] graph, int source, int dest) {
    if (source == dest) return graph[source][dest];
    else {
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < graph[0].length; i++)
        if (source < i) min = Math.min(min, graph[source][i] + minCostToDest(graph, i, dest));
      return min;
    }
  }

  /**
   * 60.
   * Problem: How to print maximum number of A’s using given four keys
   * This is a famous interview question asked in Google, Paytm and many other company interviews.
   * Imagine you have a special keyboard with the following keys:
   * Key 1:  Prints 'A' on screen
   * Key 2: (Ctrl-A): Select screen
   * Key 3: (Ctrl-C): Copy selection to buffer
   * Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
   * If you can only press the keyboard for N times (with the above four keys), write a program to produce maximum
   * numbers of A's. That is to say, the input parameter is N (No. of keys that you can press), the
   * output is M (No. of As that you can produce).
   */


  /**
   * 61.
   * Problem: Maximum profit by buying and selling a share at most twice
   * Solution:
   */


  /**
   * 62.
   * Problem: Count possible ways to construct buildings
   * Given an input number of sections and each section has 2 plots on either sides of the road. Find all possible ways
   * to construct buildings in the plots such that there is a space between any 2 buildings.
   */
  int waysToConstructBuilding(int n) {
    return (int) Math.pow(placeBuilding(n) + placeSpace(n), 2);
  }

  private int placeBuilding(int n) {
    if (n == 0 || n == 1) return n;
    else return placeSpace(n - 1);
  }

  private int placeSpace(int n) {
    if (n == 0 || n == 1) return n;
    else return placeSpace(n - 1) + placeBuilding(n - 1);
  }

  /**
   * 63.
   * Problem: Compute sum of digits in all numbers from 1 to n
   * Given a number x, find sum of digits in all numbers from 1 to n.
   */


  /**
   * 64.
   * Problem: Shortest Common Supersequence
   * Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
   */
  int superSeq(String str1, String str2) {
    return str1.length() + str2.length() - LCSBottomUp(str1, str2);
  }

  int superSeqRec(String str1, String str2, int m, int n) {
    if (m == 0) return n;
    else if (n == 0) return m;
    else if (str1.charAt(m - 1) == str2.charAt(n - 1)) return 1 + superSeqRec(str1, str2, m - 1, n - 1);
    else return 1 + Math.min(superSeqRec(str1, str2, m - 1, n), superSeqRec(str1, str2, m, n - 1));
  }

  /**
   * 65.
   * Problem: Collect maximum points in a grid using two traversals
   * Given a matrix where every cell represents points. How to collect maximum points using two traversals under
   * following conditions?
   * Let the dimensions of given grid be R x C.
   * 1) The first traversal starts from top left corner, i.e., (0, 0) and should reach left bottom corner, i.e.,
   * (R-1, 0). The second traversal starts from top right corner, i.e., (0, C-1) and should reach bottom right corner,
   * i.e., (R-1, C-1)/
   * 2) From a point (i, j), we can move to (i+1, j+1) or (i+1, j-1) or (i+1, j)
   * 3) A traversal gets all points of a particular cell through which it passes. If one traversal has already collected
   * points of a cell, then the other traversal gets no points if goes through that cell again.
   * Solution:
   */


  /**
   * 66.
   * Problem: Find minimum number of coins that make a given value
   * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm}
   * valued coins, what is the minimum number of coins to make the change?
   */
  int findMinCoins(int[] coins, int sum) {
    if (sum == 0) return 0;
    else {
      int min = Integer.MAX_VALUE;
      for (int coin : coins)
        if (sum >= coin) {
          int subResult = findMinCoins(coins, sum - coin);
          if (subResult != Integer.MAX_VALUE) min = Math.min(min, 1 + subResult);
        }
      return min;
    }
  }

  int findMinCoinsBottomUp(int[] coins, int sum) {
    int[] dp = new int[sum + 1];
    Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int coin : coins)
      for (int i = 1; i <= sum; i++)
        if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], 1 + dp[i - coin]);

    return dp[sum];
  }

  /**
   * 67.
   * Problem: Minimum number of squares whose sum equals to given number n
   * A number can always be represented as a sum of squares of other numbers. Note that 1 is a square and we can always
   * break a number as (1*1 + 1*1 + 1*1 + …). Given a number n, find the minimum number of squares that sum to X.
   */
  int countMinSquares(int n) {
    if (n <= 3) return n;
    else {
      int min = Integer.MAX_VALUE;
      for (int i = 1; i <= n; i++) {
        if (n >= square(i)) {
          int subMin = countMinSquares(n - square(i));
          if (subMin != Integer.MAX_VALUE) min = Math.min(min, 1 + subMin);
        }
      }
      return min;
    }
  }

  private int square(int n) {
    return n * n;
  }

  int countMinSquaresBottomUp(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    Arrays.fill(dp, 4, dp.length, Integer.MAX_VALUE);
    for (int i = 1; i <= n; i++)
      for (int j = 4; j < dp.length; j++)
        if (j >= square(i) && dp[j - square(i)] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], 1 + dp[j - square(i)]);
    return dp[n];
  }

  /**
   * 68.
   * Problem: Tiling Problem
   * Solution:
   */

  /**
   * 69.
   * Problem: Find length of the longest consecutive path from a given starting character
   * Solution:
   */

  /**
   * 70.
   * Problem: Total number of non-decreasing numbers with n digits
   * A number is non-decreasing if every digit (except the first one) is greater than or equal to previous digit. For
   * example, 223, 4455567, 899, are non-decreasing numbers.
   * So, given the number of digits n, you are required to find the count of total non-decreasing numbers with n digits.
   */
  int countIncreasingNum(int n, int index) {
    if (n == 0) return 1;
    else {
      int count = 0;
      for (int i = index; i < 10; i++) count += countIncreasingNum(n - 1, i);
      return count;
    }
  }

  /**
   * 71.
   * Problem: Minimum Initial Points to Reach Destination
   * Given a grid with each cell consisting of positive, negative or no points i.e, zero points. We can move across a
   * cell only if we have positive points ( > 0 ). Whenever we pass through a cell, points in that cell are added to our
   * overall points. We need to find minimum initial points to reach cell (m-1, n-1) from (0, 0).
   * Constraints :
   * From a cell (i, j) we can move to (i+1, j) or (i, j+1).
   * We cannot move from (i, j) if your overall points at (i, j) is <= 0.
   * We have to reach at (n-1, m-1) with minimum positive points i.e., > 0.
   * Solution:
   */


  /**
   * 72.
   * Problem: Count of n digit numbers whose sum of digits equals to given sum
   * Given two integers ‘n’ and ‘sum’, find count of all n digit numbers with sum of digits as ‘sum’. Leading 0’s are
   * not counted as digits. 1 <= n <= 100 and 1 <= sum <= 50000
   */
//  int countDigitSum(int n, int sum){
//    if (n == 0 && sum == 0) return 1;
//    else if (n == 0 && sum > 0) return 0;
//    else {
//      int count = 0;
//      for (int i = 0; i <= 9; i++) if (sum >= i) count += countDigitSum(n - 1, sum - i);
//      return count;
//    }
//  }


  /**
   * 73.
   * Problem: Count total number of N digit numbers such that the difference between sum of even and odd digits is 1
   * Solution:
   */

  /**
   * 74.
   * Problem: Maximum weight transformation of a given string
   * Solution:
   */

  /**
   * 75.
   * Problem: Bitmasking and Dynamic Programming | Set 1 (Count ways to assign unique cap to every person)
   * Solution:
   */

  /**
   * 76.
   * Problem: Longest Repeating Subsequence
   * Given a string, find length of the longest repeating subseequence such that the two subsequence don’t have same
   * string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index
   * in the original string.
   */
  int LRS(String str, int m, int n) {
    if (m == 0 || n == 0) return 0;
    else if (str.charAt(m - 1) == str.charAt(n - 1) && m != n) return 1;
    else return Math.max(LRS(str, m - 1, n), LRS(str, m, n - 1));
  }


  /**
   * 77.
   * Problem: Count even length binary sequences with same sum of first and second half bits
   * Solution:
   */

  /**
   * 78.
   * Problem: Count number of ways to cover a distance
   * Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.
   */
  int distanceCountWays(int distance) {
    if (distance == 0) return 1;
    else if (distance < 0) return 0;
    else return distanceCountWays(distance - 1) + distanceCountWays(distance - 2) + distanceCountWays(distance - 3);
  }


  /**
   * 79.
   * Problem: Find the longest path in a matrix with given constraints
   * Given a n*n matrix where all numbers are distinct, find the maximum length path (starting from any cell) such that
   * all cells along the path are in increasing order with a difference of 1.
   * We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) or
   * (i, j-1) with the condition that the adjacent cells have a difference of 1.
   * Example:
   * Input:  mat[][] = {{1, 2, 9}
   * {5, 3, 8}
   * {4, 6, 7}}
   * Output: 4
   * The longest path is 6-7-8-9.
   * Solution:
   */
//  int longestPathInMat(int[][] mat, int x, int y) {
//     int maxSum = 0;
//      for (int i = 0; i < mat.length; i++)
//        for (int j = 0; j < mat[0].length; j++) maxSum = Math.max(maxSum, dfs(mat, i, j));
//        return maxSum;
//  }
//  int dfs(int[][] mat, int i, int j) {
//    if (!validMove(mat, i, j)) return 0;
//    else {
//      for ()
//    }
//  }

  /**
   * 80.
   * Problem: Find number of solutions of a linear equation of n variables
   * Solution:
   */

  /**
   * 81.
   * Problem: Find minimum possible size of array with given rules for removing elements
   * Solution:
   */


  /**
   * 82.
   * Problem: Number of paths with exactly k coins
   * Solution:
   */
  int countPathsKCoin(int[][] mat, int x, int y, int k) {
    if (x == 0 && y == 0 && k == mat[0][0]) return 1;
    else if (x < 0 || y < 0) return 0;
    else return countPathsKCoin(mat, x - 1, y, k - mat[x][y])
              + countPathsKCoin(mat, x, y - 1, k - mat[x][y]);
  }


  /**
   * 83.
   * Problem: Collect maximum coins before hitting a dead end
   * Solution:
   */

  /**
   * 84.
   * Problem: Bell Numbers (Number of ways to Partition a Set)
   * Solution:
   */

  /**
   * 85.
   * Problem: Count number of ways to partition a set into k subsets
   * Given two numbers n and k where n represents number of elements in a set, find number of ways to partition the
   * set into k subsets.
   */
  int countPartitions(int n, int k) {
    if (n == 0 || k == 0 || k > n) return 0;
    else if (n == k || k == 1) return 1;
    else return countPartitions(n - 1, k - 1) + k * countPartitions(n - 1, k);
  }

  /**
   * 86.
   * Problem: Count number of paths with at-most k turns
   * Given a “m x n” matrix, count number of paths to reach bottom right from top left with maximum k turns allowed.
   * What is a turn? A movement is considered turn, if we were moving along row and now move along column.
   * OR we were moving along column and now move along row.
   * Solution:
   */
  //Not correct
  int countPathsAtKTurns(int m, int n, int k) {
    if (m == 0 && n == 0) return 1;
    return countPathsAtKTurnsUtil(m - 1, n, k, true) +
            countPathsAtKTurnsUtil(m, n - 1, k, false);
  }

  private int countPathsAtKTurnsUtil(int m, int n, int k, boolean direction) {
    if (m == 0 && n == 0) return 1;
    else if (m < 0 || n < 0) return 0;
    else if (k == 0) {
      if (m == 0 && false) return 1;
      else if (n == 0 && true) return 1;
      else return 0;
    } else if (direction) return countPathsAtKTurnsUtil(m - 1, n, k, direction) +
            countPathsAtKTurnsUtil(m, n - 1, k - 1, !direction);
    else return countPathsAtKTurnsUtil(m - 1, n, k - 1, !direction) +
              countPathsAtKTurnsUtil(m, n - 1, k, direction);
  }


  /**
   * 87.
   * Problem: Count Derangements (Permutation such that no element appears in its original position)
   * Solution:
   */

  /**
   * 88.
   * Problem: Partition a set into two subsets such that the difference of subset sums is minimum
   * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between
   * their sums is minimum.
   */
  int twoSubsetDivide(int[] array, int arraySum, int m, int soFarSum) {
    if (m == 0) return Math.abs(soFarSum - (arraySum - soFarSum));
    else return Math.min(twoSubsetDivide(array, arraySum, m - 1, soFarSum + array[m - 1]),
            twoSubsetDivide(array, arraySum, m - 1, soFarSum));
  }

  /**
   * 89.
   * Problem: Compute nCr % p | Set 1 (Introduction and Dynamic Programming Solution)
   * Solution:
   */

  /**
   * 90.
   * Problem: Longest Zig-Zag Subsequence
   * Solution:
   */

  /**
   * 91.
   * Problem: Permutation Coefficient
   * Solution:
   */


  /**
   * 92.
   * Problem: Count number of subsets having a particular XOR value
   * Solution:
   */

  /**
   * 93.
   * Problem: Weighted Job Scheduling in O(n Log n) time
   * Solution:
   */

  /**
   * 94.
   * Problem: Count number of ways to fill a “n x 4” grid using “1 x 4” tiles
   * Solution:
   */

  /**
   * 95.
   * Problem: Ways to arrange Balls such that adjacent balls are of different types
   * There are ‘p’ balls of type P, ‘q’ balls of type Q and ‘r’ balls of type R. Using the balls we want to create a
   * straight line such that no two balls of same type are adjacent.
   * Solution:
   */


  /**
   * 96.
   * Problem: A Space Optimized Solution of LCS
   * Solution:
   */


  /**
   * 97.
   * Problem: Maximum profit by buying and selling a share at most k times
   * Solution:
   */

  /**
   * 98.
   * Problem: Minimum time to finish tasks without skipping two consecutive
   * Solution:
   */

  /**
   * 99.
   * Problem: Find maximum length Snake sequence
   * Given a grid of numbers, find maximum length Snake sequence and print it. If multiple snake sequences exists with
   * the maximum length, print any one of them.
   * A snake sequence is made up of adjacent numbers in the grid such that for each number, the number on the right or
   * the number below it is +1 or -1 its value. For example, if you are at location (x, y) in the grid, you can either
   * move right i.e. (x, y+1) if that number is ± 1 or move down i.e. (x+1, y) if that number is ± 1
   * Solution:
   */
  int maxLengthSnake(int[][] grid) {
    int maxLen = Integer.MIN_VALUE;
    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid[0].length; j++)
        maxLen = Math.max(maxLen, dfsSnake(grid, i, j));
    return maxLen;
  }

  private int dfsSnake(int[][] grid, int i, int j) {
    if (i > grid.length - 1 || j > grid[0].length - 1) return 0;
    else if (isValidDownMove(grid, i + 1, j) && isValidRightMove(grid, i, j + 1)) return 1 +
            Math.max(dfsSnake(grid, i + 1, j), dfsSnake(grid, i, j + 1));
    else if (isValidDownMove(grid, i + 1, j)) return 1 + dfsSnake(grid, i + 1, j);
    else if (isValidRightMove(grid, i, j + 1)) return 1 + dfsSnake(grid, i, j + 1);
    else return 0;
  }

  private boolean isValidDownMove(int[][] grid, int x, int y) {
    return x < grid.length && y < grid[0].length && Math.abs(grid[x - 1][y] - grid[x][y]) == 1;
  }

  private boolean isValidRightMove(int[][] grid, int x, int y) {
    return x < grid.length && y < grid[0].length && Math.abs(grid[x][y - 1] - grid[x][y]) == 1;
  }


  /**
   * 100.
   * Problem: Find if string is K-Palindrome or not | Set 1
   * Solution:
   */

  /**
   * 101.
   * Problem: Wildcard Pattern Matching
   * Solution:
   */


  /**
   * 102.
   * Problem: Longest Common Increasing Subsequence (LCS + LCS)
   * Solution:
   */

  /**
   * 103.
   * Problem: Printing Longest Common Subsequence | Set 2 (Printing All)
   * Solution:
   */

  /**
   * 104.
   * Problem: Printing Shortest Common Supersequence
   * Solution:
   */

  /**
   * 105.
   * Problem: Find if string is K-Palindrome or not | Set 2
   * Solution:
   */

  /**
   * 106.
   * Problem: Construction of Longest Increasing Subsequence using Dynamic Programming
   * Solution:
   */


  /**
   * 107.
   * Problem: Maximize arr[j] – arr[i] + arr[l] – arr[k], such that i < j < k < l
   * Solution:
   */

  /**
   * 108.
   * Problem: Dynamic Programming | High-effort vs. Low-effort Tasks Problem
   * Solution:
   */

  /**
   * 109.
   * Problem: Find minimum adjustment cost of an array
   * Solution:
   */

  /**
   * 110.
   * Problem: Printing Maximum Sum Increasing Subsequence
   * Solution:
   */

  /**
   * 111.
   * Problem: Printing Longest Bitonic Subsequence
   * Solution:
   */


  /**
   * 112.
   * Problem: Find Jobs involved in Weighted Job Scheduling
   * Solution:
   */

  /**
   * 113.
   * Problem: Print Maximum Length Chain of Pairs
   * Solution:
   */

  /**
   * 114.
   * Problem: Weighted Job Scheduling | Set 2 (Using LCS)
   * Solution:
   */

  /**
   * 115.
   * Problem: Longest Geometric Progression
   * Solution:
   */

  /**
   * 116.
   * Problem: Find all combinations of k-bit numbers with n bits set where 1 <= n <= k in sorted order
   * Solution:
   */


  /**
   * 117.
   * Problem: Minimum Cost To Make Two Strings Identical
   * Given two strings X and Y, and two values costX and costY. We need to find minimum cost required to make the given
   * two strings identical. We can delete characters from both the strings. The cost of deleting a character from string
   * X is costX and from Y is costY. Cost of removing all characters from a string is same.
   */
  int minCostForIdentical(String str1, String str2, int costX, int costY) {
    int lenLCS = LCSBottomUp(str1, str2);
    return (str1.length() - lenLCS) * costX + (str2.length() - lenLCS) * costY;
  }

  /**
   * 118.
   * Problem: Find number of times a string occurs as a subsequence in given string
   * Solution:
   */

  /**
   * 119.
   * Problem: A Space Optimized DP solution for 0-1 Knapsack Problem
   * Solution:
   */

  /**
   * 120.
   * Problem: Minimum cost to fill given weight in a bag
   * Solution:
   */

  /**
   * 121.
   * Problem: Count digit groupings of a number with given constraints
   * Solution:
   */


  /**
   * 122.
   * Problem: Non-crossing lines to connect points in a circle
   * Solution:
   */

  /**
   * 123.
   * Problem: Count Distinct Subsequences
   * Solution:
   */

  /**
   * 124.
   * Problem: Find minimum sum such that one of every three consecutive elements is taken
   * Solution:
   */

  /**
   * 125.
   * Problem: Longest repeating and non-overlapping substring
   * Solution:
   */

  /**
   * 126.
   * Problem: Count distinct occurrences as a subsequence
   * Solution:
   */


  /**
   * 127.
   * Problem: Count all increasing subsequences
   * Solution:
   */

  /**
   * 128.
   * Problem: All ways to add parenthesis for evaluation
   * Solution:
   */

  /**
   * 129.
   * Problem: Choice of Area
   * Solution:
   */

  /**
   * 130.
   * Problem: Number of permutation with K inversions
   * Solution:
   */

  /**
   * 131.
   * Problem: Maximum weight path ending at any element of last row in a matrix
   * Given a matrix of integers where every element represents weight of the cell. Find the path having the maximum
   * weight in matrix [N X N]. Path Traversal Rules are:
   * It should begin from top left element. The path can end at any element of last row.We can move to following two
   * cells from a cell (i, j).
   * Down Move : (i+1, j)
   * Diagonal Move : (i+1, j+1)
   */


  /**
   * 132.
   * Problem: Print all longest common sub-sequences in lexicographical order
   * Solution:
   */

  /**
   * 133.
   * Problem: Count All Palindromic Subsequence in a given String
   * Solution:
   */

  /**
   * 134.
   * Problem: Recursively break a number in 3 parts to get maximum sum
   * Given a number n, we can divide it in only three parts n/2, n/3 and n/4 (we will consider only integer part).
   * The task is to find the maximum sum we can make by dividing number in three parts recursively and summing up them
   * together.
   */
  int maxBreakingSum(int n) {
    if (n == 0 || n == 1) return n;
    else return Math.max(maxBreakingSum(n / 2) + maxBreakingSum(n / 3) + maxBreakingSum(n / 4), n);
  }

  int maxBreakingSumBottomUp(int n) {
    int[] dp = new int[n + 1];
    for (int i = 0; i < dp.length; i++) {
      if (i == 0 || i == 1) dp[i] = i;
      else dp[i] = Math.max(dp[i / 2] + dp[i / 3] + dp[i / 4], i);
    }
    return dp[n];
  }

  /**
   * 135.
   * Problem: Path with maximum average value
   * Given a square matrix of size N*N, where each cell is associated with a specific cost. A path is defined as a
   * specific sequence of cells which starts from top left cell move only right or down and ends on bottom right cell.
   * We want to find a path with maximum average over all existing paths. Average is computed as total cost divided by
   * number of cells visited in path.
   */
  double maxAvgPath(int[][] mat, int i, int j, int pathLen, int pathSum) {
    if (i == 0 && j == 0) return (double) (pathSum + mat[0][0]) / (double) (pathLen + 1);
    else if (i < 0 || j < 0) return 0;
    else return Math.max(maxAvgPath(mat, i - 1, j, pathLen + 1, pathSum + mat[i][j]),
              maxAvgPath(mat, i, j - 1, pathLen + 1, pathSum + mat[i][j]));
  }


  /**
   * 136.
   * Problem: Maximum sum of pairs with specific difference
   * Solution:
   */


  /**
   * 137.
   * Problem: Maximum sum alternating subsequence
   * Solution:
   */

  /**
   * 138.
   * Problem: Maximum subsequence sum such that no three are consecutive
   * Solution:
   */

  /**
   * 139.
   * Problem: Count All Palindrome Sub-Strings in a String
   * Given a string, the task is to count all palindrome substring in a given string. Length of palindrome substring is
   * greater then or equal to 2.
   */
  int countPSubstrings(String str, int left, int right) {
    if (left + 1 == right && str.charAt(left) == str.charAt(right)) return 1;
    else if (left + 1 == right && str.charAt(left) != str.charAt(right) || left >= right) return 0;
    else if (new RecursionExamples().isPalindrome(str.substring(left, right + 1))) return 1 +
            countPSubstrings(str, left + 1, right) + countPSubstrings(str, left, right - 1) -
            countPSubstrings(str, left + 1, right - 1);
    return countPSubstrings(str, left + 1, right) +
            countPSubstrings(str, left, right - 1) - countPSubstrings(str, left + 1, right - 1);
  }

  /**
   * 140.
   * Problem: Sum of average of all subsets
   * Given an array arr of N integer elements, the task is to find sum of average of all subsets of this array.
   * Solution:
   */
  double subsetAvgSum(int[] array, int m, int elementCount, int avgSum) {
    if (m == 0 && elementCount == 0) return 0;
    else if (m == 0) return (double) avgSum / elementCount;
    else return subsetAvgSum(array, m - 1, elementCount + 1, avgSum + array[m - 1]) +
              subsetAvgSum(array, m - 1, elementCount, avgSum);
  }

  /**
   * 141.
   * Problem: Longest subsequence such that difference between adjacents is one
   * Solution:
   */


  /**
   * 142.
   * Problem: Maximum decimal value path in a binary matrix
   * Solution:
   */

  /**
   * 143.
   * Problem: Maximum sum subarray removing at most one element
   * Given an array, we need to find maximum sum subarray, removing one element is also allowed to get the maximum sum.
   */
  int maxSubArraySum(int[] array) {
    int[] forWardSum = new int[array.length], backWardSum = new int[array.length];
    maxSubArraySumForward(array, forWardSum);
    int maxSum = maxSubArraySumBackward(array, backWardSum);
    for (int i = 1; i < array.length - 1; i++) maxSum = Math.max(maxSum, forWardSum[i - 1] + backWardSum[i + 1]);
    return maxSum;
  }

  private int maxSubArraySumForward(int[] array, int[] forwardSumArray) {
    int maxSoFar = array[0], currMax = array[0];
    forwardSumArray[0] = array[0];
    for (int i = 1; i < array.length; i++) {
      currMax = Math.max(array[i], currMax + array[i]);
      maxSoFar = Math.max(maxSoFar, currMax);
      forwardSumArray[i] = currMax;
    }
    return maxSoFar;
  }

  private int maxSubArraySumBackward(int[] array, int[] backwardSumArray) {
    int maxSoFar = array[array.length - 1], currMax = array[array.length - 1];
    backwardSumArray[array.length - 1] = array[array.length - 1];
    for (int i = array.length - 2; i >= 0; i--) {
      currMax = Math.max(array[i], currMax + array[i]);
      maxSoFar = Math.max(maxSoFar, currMax);
      backwardSumArray[i] = currMax;
    }
    return maxSoFar;
  }


  /**
   * 144.
   * Problem: Number of palindromic paths in a matrix
   * Given a matrix containing lower alphabetical characters only, we need to count number of palindromic paths in given
   * matrix. A path is defined as a sequence of cells starting from top-left cell and ending at bottom-right cell.
   * We are allowed to move to right and down only from current cell.
   * Solution:
   */


  /**
   * 145.
   * Problem: Minimum and Maximum values of an expression with * and +
   * Solution:
   */

  /**
   * 146.
   * Problem: Minimum cost to sort strings using reversal operations of different costs
   * Solution:
   */


  /**
   * 147.
   * Problem: Minimum sum subsequence such that at least one of every four consecutive elements is picked
   * Solution:
   */

  /**
   * 148.
   * Problem: Count number of ways to reach destination in a Maze
   * Given a maze with obstacles, count number of paths to reach rightmost-bottommost cell from topmost-leftmost cell.
   * A cell in given maze has value -1 if it is a blockage or dead end, else 0. From a given cell, we are allowed to
   * move to cells (i+1, j) and (i, j+1) only.
   */
  int countWaysToReachDest(int[][] mat, int i, int j) {
    if (i == 0 && j == 0 && mat[0][0] == 0) return 1;
    else if (i < 0 || j < 0 || mat[i][j] == -1) return 0;
    else return countWaysToReachDest(mat, i - 1, j) + countWaysToReachDest(mat, i, j - 1);
  }

  int countWaysToReachDestBottomUp(int[][] mat) {
    int[][] dp = new int[mat.length + 1][mat[0].length + 1];
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (i == 1 && j == 1 && mat[0][0] == 0) dp[i][j] = 1;
        else if (mat[i - 1][j - 1] == -1) dp[i][j] = 0;
        else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[dp.length - 1][dp[0].length - 1];
  }

  /**
   * 149.
   * Problem: Maximum path sum for each position with jumps under divisibility condition
   * Solution:
   */

  /**
   * 150.
   * Problem: Super Ugly Number (Number whose prime factors are in given set)
   * Solution:
   */

  /**
   * 151.
   * Problem: Maximum sum Bi-tonic Sub-sequence
   * Solution:
   */


  /**
   * 152.
   * Problem: Find all distinct subset (or subsequence) sums of an array
   * Given a set of integers, find distinct sum that can be generated from the subsets of the given sets and print them
   * in an increasing order. It is given that sum of array elements is small.
   */


  /**
   * 153.
   * Problem: Ways to write n as sum of two or more positive integers
   * Solution:
   */

  /**
   * 154.
   * Problem: Unbounded Knapsack (Repetition of items allowed)
   * Solution:
   */

  /**
   * 155.
   * Problem:: Unbounded Knapsack (Repetition of items allowed)
   * Given a knapsack weight W and a set of n items with certain value vali and weight wti, we need to calculate minimum
   * amount that could make up this quantity exactly. This is different from classical Knapsack problem, here we are
   * allowed to use unlimited number of instances of an item.
   */
  int knapsackUnbounded(int[] weights, int[] values, int capacity) {
    if (weights.length == 0 || capacity == 0) return 0;
    else {
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < weights.length; i++)
        if (capacity >= weights[i])
          max = Math.max(max, values[i] + knapsackUnbounded(weights, values, capacity - weights[i]));
      return max;
    }
  }

  /**
   * 156.
   * Problem: LCS (Longest Common Subsequence) of three strings
   * Given 3 strings of all having length < 100,the task is to find the longest common sub-sequence in all three given
   * sequences.
   */
  int threeStringsLCS(String str1, String str2, String str3, int m, int n, int o) {
    if (m == 0 || n == 0 || o == 0) return 0;
    else if (str1.charAt(m - 1) == str2.charAt(n - 1) && str1.charAt(m - 1) == str3.charAt(o - 1))
      return 1 + threeStringsLCS(str1, str2, str3, m - 1, n - 1, o - 1);
    else return Math.max(threeStringsLCS(str1, str2, str3, m - 1, n, o),
              Math.max(threeStringsLCS(str1, str2, str3, m, n - 1, o), threeStringsLCS(str1, str2, str3, m, n, o - 1)));
  }

  /**
   * 157.
   * Problem: Probability of Knight to remain in the chessboard
   * Solution:
   */

  /**
   * 158.
   * Problem: Find Maximum dot product of two arrays with insertion of 0’s
   * Given two arrays of positive integers of size m and n where m > n. We need to maximize the dot product by
   * inserting zeros in the second array but we cannot disturb the order of elements.
   * Solution: Another way to look at this problem is, for every pair of elements element A[i] and B[j] where j >= i,
   * we have two choices:
   * We multiply A[i] and B[j] and add to product (We include A[i]).
   * We exclude A[i] from product (In other words, we insert 0 at current position in B[])
   */
  int maxDotProduct(int[] a, int[] b, int m, int n) {
    if (m == 0 || n == 0) return 0;
    else
      return Math.max(a[m - 1] * b[n - 1] + maxDotProduct(a, b, m - 1, n - 1),
              maxDotProduct(a, b, m - 1, n));

  }

  int maxDotProductBottomUp(int[] a, int[] b) {
    int[][] dp = new int[a.length + 1][b.length + 1];
    for (int i = 1; i <= a.length; i++)
      for (int j = 1; j <= b.length; j++) dp[i][j] = Math.max(a[i - 1] * b[j - 1] + dp[i - 1][j - 1], dp[i - 1][j]);
    return dp[a.length][b.length];
  }

  /**
   * 159.
   * Problem: Check whether row or column swaps produce maximum size binary sub-matrix with all 1s
   * Solution:
   */

  /**
   * 160.
   * Problem: Count of AP (Arithmetic Progression) Subsequences in an array
   * Solution:
   */

  /**
   * 161.
   * Problem: Maximum points collected by two persons allowed to meet once
   * Solution:
   */


  /**
   * 162.
   * Problem: Maximum path sum in a triangle.
   * We have given numbers in form of triangle, by starting at the top of the triangle and moving to adjacent numbers
   * on the row below, find the maximum total from top to bottom.
   */
  int maxPathInTriangleBottomUp(int[][] mat, int m, int n) {
    for (int i = m - 1; i >= 0; i--)
      for (int j = 0; j <= i; j++) mat[i][j] += Math.max(mat[i + 1][j], mat[i + 1][j + 1]);
    return mat[0][0];
  }

  /**
   * 163.
   * Problem: Printing brackets in Matrix Chain Multiplication Problem.
   * Solution:
   */

  /**
   * 164.
   * Problem: Minimum Sum Path In 3-D Array.
   * Solution:
   */

  /**
   * 165.
   * Problem: Friends Pairing Problem.
   * Solution:
   */

  /**
   * 166.
   * Problem: Check if all people can vote on two machines.
   * Solution:
   */

  /**
   * 167.
   * Problem: Count binary strings with k times appearing adjacent two set bits.
   * Solution:
   */

  /**
   * 168.
   * Problem: Probability of getting at least K heads in N tosses of Coins.
   * Given N number of coins, the task is to find probability of getting at least K number of heads after tossing all
   * the N coins simultaneously.
   * Suppose we have 3 unbiased coins and we have to find the probability of getting at least 2 heads, so there are
   * 23 = 8 ways to toss these coins, i.e., HHH, HHT, HTH, HTT, THH, THT, TTH, TTT Out of which there are 4 set which
   * contain at least 2 Heads i.e., HHH, HHT, HH, THH So the probability is 4/8 or 0.5
   * Solution:
   */

  /**
   * 169.
   * Problem: Size of array after repeated deletion of LCS.
   * Solution:
   */

  /**
   * 170.
   * Problem: Maximum path sum that starting with any cell of 0-th row  and ending with any cell of (N-1)-th row.
   * Given a N X N matrix Mat[N][N] of positive integers. There are only three possible moves from a cell (i, j)
   * (i+1, j)
   * (i+1, j-1)
   * (i+1, j+1)
   * Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.
   */
  int maxSumPath(int[][] mat) {
    int maxSumPath = Integer.MIN_VALUE;
    for (int j = 0; j < mat[0].length; j++) maxSumPath = Math.max(maxSumPath, maxSumPathUtil(mat, mat.length - 1, j));
    return maxSumPath;
  }

  private int maxSumPathUtil(int[][] mat, int i, int j) {
    if (i < 0 || j > mat[0].length - 1 || j < 0) return Integer.MIN_VALUE;
    else if (i == 0) return mat[i][j];
    else return mat[i][j] + Math.max(maxSumPathUtil(mat, i - 1, j), Math.max(maxSumPathUtil(mat, i - 1, j - 1),
              maxSumPathUtil(mat, i - 1, j + 1)));
  }

  int maxSumPathBottomUp(int[][] mat) {
    int[][] dp = new int[mat.length][mat[0].length + 2];
    for (int j = 0; j < mat[0].length; j++) dp[0][j + 1] = mat[0][j];
    for (int i = 1; i < dp.length; i++)
      for (int j = 1; j < dp[0].length - 1; j++)
        dp[i][j] = mat[i][j - 1] + Math.max(dp[i - 1][j],
                Math.max(dp[i - 1][j - 1], dp[i - 1][j + 1]));
    int maxSumPath = 0;
    for (int j = 1; j < dp[0].length - 1; j++) maxSumPath = Math.max(maxSumPath, dp[dp.length - 1][j]);
    return maxSumPath;
  }

  /**
   * 171.
   * Problem: Number of subsequences in a string divisible by n.
   * Solution:
   */


  /**
   * 172.
   * Problem: Finding the maximum square sub-matrix with all equal elements.
   * Given a N x N matrix, determine the maximum K such that K x K is a submatrix with all equal elements i.e., all
   * the elements in this submatrix must be same.
   */
  int largestKSqSubMat(int[][] mat) {
    int[][] dp = new int[mat.length][mat[0].length];
    int result = 0;
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp.length; j++) {
        if (i == 0 || j == 0) dp[i][j] = 1;
        else if (sameNeighbours(mat[i][j], mat[i - 1][j], mat[i][j - 1], mat[i - 1][j - 1])) dp[i][j] = 1 + Math.min(dp[i - 1][j],
                Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
        else dp[i][j] = 1;
        result = Math.max(result, dp[i][j]);
      }
    }
    return result;
  }

  boolean sameNeighbours(int w, int x, int y, int z) {
    return w == x && x == y && y == z;
  }

  /**
   * 173.
   * Problem: Gold Mine Problem.
   * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of
   * gold in tons. Initially the miner is at first column but can be at any row. He can move only (right->,right up /
   * ,right down\).Find out maximum amount of gold he can collect.
   */
  int maxGoldAmount(int[][] mat) {
    int maxGold = Integer.MIN_VALUE;
    for (int i = 0; i < mat.length; i++) maxGold = Math.max(maxGold, maxGoldAmountUtil(mat, i, 0));
    return maxGold;
  }

  private int maxGoldAmountUtil(int[][] mat, int i, int j) {
    if (i < 0 || i > mat.length - 1 || j > mat[0].length - 1) return 0;
    else return mat[i][j] + Math.max(maxGoldAmountUtil(mat, i, j + 1),
            Math.max(maxGoldAmountUtil(mat, i + 1, j + 1), maxGoldAmountUtil(mat, i - 1, j + 1)));
  }

  /**
   * 174.
   * Problem: Highway Billboard Problem.
   * Solution:
   */

  /**
   * 175.
   * Problem: Count of strings that can be formed using a, b and c under given constraints.
   * Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’ with at-most one
   * ‘b’ and two ‘c’s allowed.
   */
  int countStringFormed(int n, String soFar, String[] choices, int[] remaining) {
    if (n == 0) return 1;
    else {
      int count = 0;
      for (int i = 0; i < choices.length; i++) {
        if (remaining[i] > 0) {
          remaining[i]--;
          count += countStringFormed(n - 1, soFar + choices[i].charAt(0), choices, remaining);
          remaining[i]++;
        }
      }
      return count;
    }
  }

  void printStringFormed(int n, String soFar, String[] choices, int[] remaining) {
    if (n == 0) System.out.print(soFar + " ");
    else {
      for (int i = 0; i < choices.length; i++) {
        if (remaining[i] > 0) {
          remaining[i]--;
          printStringFormed(n - 1, soFar + choices[i].charAt(0), choices, remaining);
          remaining[i]++;
        }
      }
    }
  }

  /**
   * 176.
   * Problem: Modify array to maximize sum of adjacent differences.
   * Given an array, we need to modify values of this array in such a way that sum of absolute differences between two
   * consecutive elements is maximized. If the value of an array element is X, then we can change it to either 1 or X.
   */


  /**
   * 177.
   * Problem: Sum of all substrings of a string representing a number | Set 1.
   * Solution:
   */

  /**
   * 178.
   * Problem: Number of subsequences of the form a^i b^j c^k.
   * Solution:
   */

  /**
   * 179.
   * Problem: Count ways to increase LCS length of two strings by one.
   * Solution:
   */

  /**
   * 180.
   * Problem: Find number of endless points.
   * Solution:
   */

  /**
   * 181.
   * Problem: How to solve a Dynamic Programming Problem ?.
   * Solution:
   */

  /**
   * 182.
   * Problem: Tabulation vs Memoizatation.
   * Solution:
   */

  /**
   * 183.
   * Problem: Perfect Sum Problem (Print all subsets with given sum).
   * Given an array of integers and a sum, the task is to print all subsets of given array with sum equal to given sum.
   */
  void perfectSumProblem(int[] array, int sum, int m, String soFar) {
    if (sum == 0) System.out.println(soFar);
    else {
      if (m > 0 && sum > 0) {
        perfectSumProblem(array, sum - array[m - 1], m - 1, soFar + array[m - 1] + " ");
        perfectSumProblem(array, sum, m - 1, soFar);
      }
    }
  }

  /**
   * 184.
   * Problem: Largest sum Zigzag sequence in a matrix.
   * Given a matrix of size n x n, find sum of the Zigzag sequence with the largest sum. A zigzag sequence starts from
   * the top and ends at the bottom. Two consecutive elements of sequence cannot belong to same column.
   */
  int largestZigZagSum(int[][] mat) {
    int maxSum = Integer.MIN_VALUE;
    for (int j = 0; j < mat[0].length; j++) maxSum = Math.max(maxSum, largestZigZag(mat, 0, j));
    return maxSum;
  }

  private int largestZigZag(int[][] mat, int row, int col) {
    if (row == mat.length - 1) return mat[row][col];
    else {
      int zigZagSum = Integer.MIN_VALUE;
      for (int j = 0; j < mat[0].length; j++)
        if (col != j) zigZagSum = Math.max(zigZagSum, mat[row][col] + largestZigZag(mat, row + 1, j));
      return zigZagSum;
    }
  }


  /**
   * 185.
   * Problem: Maximum sum of a path in a Right Number Triangle.
   * Solution:
   */


  /**
   * 186.
   * Problem: Subset with sum divisible by m
   * Given a set of non-negative distinct integers, and a value m, determine if there is a subset of the given set with
   * sum divisible by m.
   */


  /**
   * 187.
   * Problem: Digit DP | Introduction.
   * Solution:
   */

  /**
   * 188.
   * Problem: Top 20 Dynamic Programming Interview Questions.
   * Solution:
   */

  /**
   * 189.
   * Problem: Smallest length string with repeated replacement of two distinct adjacent.
   * Solution:
   */

  /**
   * 190.
   * Problem: Temple Offerings.
   * Solution:
   */

  /**
   * 191.
   * Problem: Count of arrays in which all adjacent elements are such that one of them divide the another.
   * Solution:
   */

  /**
   * 192.
   * Problem: Minimum number of deletions to make a string palindrome
   * Given a string of size ‘n’. The task is to remove or delete minimum number of characters from the string so that
   * the resultant string is palindrome. Note: The order of characters should be maintained.
   */
  int minDeletion(String str, int left, int right) {
    if (left > right) return Integer.MAX_VALUE;
    else if (left == right) return 0;
    else if (left + 1 == right) return (str.charAt(left) == str.charAt(right)) ? 0 : 1;
    else if (str.charAt(left) == str.charAt(right)) return minDeletion(str, left + 1, right - 1);
    else return 1 + Math.min(minDeletion(str, left + 1, right), minDeletion(str, left, right - 1));
  }


  /**
   * 193.
   * Problem: Minimum steps to minimize n as per given condition.
   * Solution:
   */

  /**
   * 194.
   * Problem: Clustering/Partitioning an array such that sum of square differences is minimum.
   * Solution:
   */

  /**
   * 195.
   * Problem: Longest alternating subsequence.
   * Solution:
   */

  /**
   * 196.
   * Problem: Minimum steps to delete a string after repeated deletion of palindrome substrings.
   */


  /**
   * 197.
   * Problem: Minimum number of deletions to make a sorted sequence
   * Given an array of n integers. The task is to remove or delete minimum number of elements from the array so that
   * when the remaining elements are placed in the same sequence order form a sorted sequence.
   */
  int minDeletionToMakeSorted(int[] array) {
    return array.length - findLISBottomUp(array);
  }


  /**
   * 198.
   * Problem: Count number of ways to jump to reach end
   * Given an array of numbers where each element represents the max number of jumps that can be made forward from that
   * element.For each array element, count number of ways jumps can be made from that element to reach the end of the
   * array. If an element is 0, then move cannot be made through that element. The element that cannot reach to the end
   * should have a count “-1”.
   * Solution:
   */
  int minJumps2(int[] array) {
    return minJumps(array, 0, array.length - 1);
  }


  /**
   * 199.
   * Problem: Minimum number of deletions and insertions to transform one string into another
   * Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert minimum
   * number of characters from/in str1 so as to transform it into str2. It could be possible that the same character
   * needs to be removed/deleted from one point of str1 and inserted to some another point.
   */
  int[] minInsertionDeletionBottomUp(String str1, String str2, int m, int n) {
    int[] result = new int[2];
    int len = new DPExamples().LCSBottomUp(str1, str2);
    result[0] = m - len;
    result[1] = n - len;
    return result;
  }


  /**
   * 200.
   * Problem: Shortest Uncommon Subsequence.
   * Solution:
   */

  /**
   * 201.
   * Problem: Minimum insertions to sort an array.
   * Given an array of integer numbers, we need to sort this array in a minimum number of steps where in one step we can
   * insert any array element from its position to any other position.
   */
  int minInsertionsToSort(int[] array) {
    return array.length - findLISBottomUp(array);
  }

  /**
   * 202.
   * Problem: Dynamic Programming | Building Bridges.
   * Solution:
   */

  /**
   * 203.
   * Problem: Number of substrings divisible by 8 but not by 3.
   * Solution:
   */

  /**
   * 204.
   * Problem: Sequences of given length where every element is more than or equal to twice of previous.
   * Solution:
   */

  /**
   * 205.
   * Problem: Ways to sum to N using array elements with repetition allowed.
   * Given a set of m distinct positive integers and a value ‘N’. The problem is to count the total number of ways we
   * can form ‘N’ by doing sum of the array elements. Repetitions and different arrangements are allowed.
   */
  int waysToSumToN(int sum, int[] array) {
    if (sum == 0) return 1;
    else {
      int count = 0;
      for (int num : array)
        if (sum >= num) count += waysToSumToN(sum - num, array);
      return count;
    }
  }

  int waysToSumToNBottomUp(int sum, int[] array) {
    int[] dp = new int[sum + 1];
    dp[0] = 1;
    for (int s = 1; s <= sum; s++)
      for (int num : array) if (s >= num) dp[s] += dp[s - num];
    return dp[sum];
  }


  /**
   * 206.
   * Problem: Maximum sum in a 2 x n grid such that no two elements are adjacent.
   * Solution:
   */

  /**
   * 207.
   * Problem: Count the number of ways to tile the floor of size n x m using 1 x m size tiles.
   * Solution:
   */

  /**
   * 208.
   * Problem: Pyramid form (increasing then decreasing) consecutive array using reduce operations.
   * Solution:
   */

  /**
   * 209.
   * Problem: Counts paths from a point to reach Origin
   * You are standing on a point (n, m) and you want to go to origin (0, 0) by taking steps either left or down i.e.
   * from each point you are allowed to move either in (n-1, m) or (n, m-1). Find the number of paths from point to
   * origin.
   */
  int countPathsToOri(int x, int y) {
    if (x == 0 || y == 0) return 1;
    else return countPathsToOri(x - 1, y) + countPathsToOri(x, y - 1);
  }

  /**
   * 210.
   * Problem: Minimum time to write characters using insert, delete and copy operation.
   * Solution:
   */

  /**
   * 211.
   * Problem: Count Balanced Binary Trees of Height h.
   * Solution:
   */

  /**
   * 212.
   * Problem: Choose maximum weight with given weight and value ratio.
   * Solution:
   */

  /**
   * 213.
   * Problem: Find the Longest Increasing Subsequence in Circular manner.
   * Solution:
   */

  /**
   * 214.
   * Problem: Bitmasking and Dynamic Programming | Set-2 (TSP).
   * Solution:
   */

  /**
   * 215.
   * Problem: Painting Fence Algorithm.
   * Solution:
   */

  /**
   * 216.
   * Problem: Number of n-digits non-decreasing integers.
   * Given an integer n > 0, which denotes the number of digits, the task to find total number of n-digit positive
   * integers which are non-decreasing in nature.A non-decreasing integer is a one in which all the digits from left to
   * right are in non-decreasing form. ex: 1234, 1135, ..etc. Note :Leading zeros also count in non-decreasing integers
   * such as 0000, 0001, 0023, etc are also non-decreasing integers of 4-digits.
   */
  int nonDecreasingInCount(int n, int start) {
    if (n == 0) return 1;
    else {
      int count = 0;
      for (int i = start; i <= 9; i++) count += nonDecreasingInCount(n - 1, i);
      return count;
    }
  }


  /**
   * 217.
   * Problem: Find maximum possible stolen value from houses.
   * There are n houses build in a line, each of which contains some value in it. A thief is going to steal the maximal
   * value of these houses, but he can’t steal in two adjacent houses because owner of the stolen houses will tell his
   * two neighbour left and right side. What is the maximum stolen value.
   */
  int maxStealing(int[] array, int m) {
    if (m == 0) return 0;
    else if (m == 1) return array[0];
    else if (m == 2) return Math.max(array[0], array[1]);
    else return Math.max(array[m - 1] + maxStealing(array, m - 2), maxStealing(array, m - 1));
  }

  int maxStealingBottomUp(int[] houseValues) {
    int[] dp = new int[houseValues.length];
    for (int i = 0; i < dp.length; i++) {
      if (i == 0) dp[i] = houseValues[0];
      else if (i == 1) dp[i] = Math.max(houseValues[0], houseValues[1]);
      else dp[i] = Math.max(houseValues[i] + dp[i - 2], dp[i - 1]);
    }
    return dp[houseValues.length - 1];
  }


}
