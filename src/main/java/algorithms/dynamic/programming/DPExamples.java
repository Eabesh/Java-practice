package algorithms.dynamic.programming;

import java.util.Arrays;

/**
 * Created by abhay on 02/05/17.
 */
public class DPExamples {

  /**
   * GeeksForGeeks Problems
   */

  /**
   * 1.
   * Problem: Largest Sum Contiguous Subarray.
   * Write an efficient C program to find the sum of contiguous
   * sub array within a one-dimensional array of numbers which has
   * the largest sum.
   * Solution: Kadane’s Algorithm:
   * Initialize:
   * maxSoFar = 0, currMax = 0;
   * for each element
   * currMax = currMax + arr[i]
   * if (currMax < 0) currMax = 0;
   * if (maxSoFar < currMax) maxSoFar = currMax
   * return maxSoFar
   */
  int maxContinousSubArray(int[] array) {
    int maxSoFar = array[0], currMax = array[0];
    for (int i = 1; i < array.length; i++) {
      currMax = Math.max(array[i], currMax + array[i]);
      maxSoFar = Math.max(maxSoFar, currMax);
    }
    return maxSoFar;
  }

  /**
  *To print the subarray with the maximum sum, we maintain indices
  * whenever we get the maximum sum.
  */
  int printContinousSubArray(int[] array) {
    int maxSoFar = array[0], currMax = array[0], start = 0, end = 0, currStart = 0;
    for (int i = 1; i < array.length; i++) {
      currMax = Math.max(array[i], currMax + array[i]);
      if (currMax + array[i] < array[i]) currMax = i;
      if (maxSoFar < currMax) {
        maxSoFar = currMax;
        start = currStart;
        end = i;
      }
    }
    return maxSoFar;
  }


  /**
   * 2.
   * Problem: Ugly Numbers
   * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
   * Thesequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11
   * ugly numbers. By convention, 1 is included.
   * Given a number n, the task is to find n’th Ugly number.
   * Input  : n = 7
   * Output : 8
   * Input  : n = 10
   * Output : 12
   * Input  : n = 15
   * Output : 24
   * Input  : n = 150
   * Output : 5832

   * Solution:
   */

  /**
   * 3.
   * Problem: Maximum size square sub-matrix with all 1s
   * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
   * Solution:
   */
   int[][] maxSizeSquareMat(int[][] mat, int[][] dp) {
     for (int i = 0; i < mat.length; i++){
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
   * The Fibonacci numbers are the numbers in the following integer sequence.
   * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,
   * Solution:
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

  /**
   *  Space Optimized Method
   *  We can optimize the space used in above method by storing the previous two numbers
   *  only because that is all we need to get the next Fibonacci number in series.
   */
   int fibonnaciSpaceOpt(int n, int first, int second, int sumOfLastTerms) {
     if (n == 0) return first;
     else if (n == 1) return second;
     else return fibonnaciSpaceOpt(n - 1, second, sumOfLastTerms,  first + second);
   }

  /**
   * 5.
   * Problem: Dynamic Programming | Set 1 (Overlapping Subproblems Property)
   * Solution:
   * 1) Overlapping Subproblems:
   * Like Divide and Conquer, Dynamic Programming combines solutions to sub-problems.
   * Dynamic Programming is mainly used when solutions of same subproblems are needed
   * again and again.In dynamic programming, computed solutions to subproblems are
   * stored in a table so that these don’t have to recomputed. So Dynamic Programming
   * is not useful when there are no common (overlapping) subproblems because there is
   * no point storing the solutions if they are not needed again. For example, Binary
   * Search doesn’t have common subproblems. If we take example of following recursive
   * program for Fibonacci Numbers, there are many subproblems which are solved again
   * and again.
   *  There are following two different ways to store the values so that these values
   *  can be reused:
   *  a) Memoization (Top Down)
   *  b) Tabulation (Bottom Up)

   */

  /**
   * 6.
   * Problem: Dynamic Programming | Set 2 (Optimal Substructure Property)
   * Solution:
   *
   * 2) Optimal Substructure: A given problems has Optimal Substructure Property if
   * optimal solution of the given problem can be obtained by using optimal solutions
   * of its subproblems.
   */

  /**
   * 7.
   * Problem: Dynamic Programming | Set 3 (Longest Increasing Subsequence)
   * Input  : arr[] = {3, 10, 2, 1, 20}
   * Output : Length of LIS = 3
   * The longest increasing subsequence is 3, 10, 20
   * Solution:Then, L(i) can be recursively written as:
   * L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
   * L(i) = 1, if no such j exists.
   */
  int findLISBottomUp(int[] array) {
    int[] dp = new int[array.length];
    Arrays.fill(dp, 1);
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < i; j++) {
        if (array[i] > array[j] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
      }
    }
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
  int LIS(String str1, String str2, int str1Length, int str2Length) {
    if (str1Length == 0 || str2Length == 0) return 0;
    else if (str1.charAt(str1Length - 1) == str2.charAt(str2Length - 1))
      return 1 + LIS(str1, str2, str1Length - 1 , str2Length - 1);
    else
      return Math.max(LIS(str1, str2, str1Length - 1, str2Length), LIS(str1, str2, str1Length, str2Length - 1));
  }

  int LISBottomUp(String str1, String str2) {
    int[][] dp = new int[str1.length() + 1][str2.length() + 1];
    for (int str1Len = 0; str1Len <= str1.length(); str1Len++) {
      for (int str2Len= 0; str2Len <= str2.length(); str2Len++) {
        if (str1Len == 0 || str2Len == 0 ) dp[str1Len][str2Len] = 0;
        else if (str1.charAt(str1Len - 1) == str2.charAt(str2Len - 1)) dp[str1Len][str2Len] = 1 + dp[str1Len - 1][str2Len - 1];
        else dp[str1Len][str2Len] = Math.max(dp[str1Len][str2Len - 1], dp[str1Len - 1][str2Len]);
      }
    }
    return dp[str1.length()][str2.length()];
  }

  /**
   * 9.
   * Problem: Dynamic Programming | Set 5 (Edit Distance)
   * Solution:
   */

  /**
   * 10.
   * Problem: Dynamic Programming | Set 6 (Min Cost Path)
   * Solution:
   */

  /**
   * 11.
   * Problem: Length of the longest substring without repeating characters
   * Solution:
   */


  /**
   * 12.
   * Problem: Minimum number of jumps to reach end
   * Solution:
   */

  /**
   * 13.
   * Problem: Dynamic Programming | Set 7 (Coin Change)
   * Solution:
   */


  /**
   * 14.
   * Problem: Dynamic Programming | Set 8 (Matrix Chain Multiplication)
   * Solution:
   */

  /**
   * 15.
   * Problem: Dynamic Programming | Set 9 (Binomial Coefficient)
   * Solution:
   */


  /**
   * 16.
   * Problem: Dynamic Programming | Set 10 ( 0-1 Knapsack Problem)
   * Solution:
   */

  /**
   * 17.
   * Problem: Dynamic Programming | Set 11 (Egg Dropping Puzzle)
   * Solution:
   */


  /**
   * 18.
   * Problem: Dynamic Programming | Set 12 (Longest Palindromic Subsequence)
   * Solution:
   */

  /**
   * 19.
   * Problem: Dynamic Programming | Set 13 (Cutting a Rod)
   * Solution:
   */

  /**
   * 20.
   * Problem: Dynamic Programming | Set 14 (Maximum Sum Increasing Subsequence)
   * Solution:
   */

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
   * Solution:
   */

  /**
   * 24.
   * Problem: Dynamic Programming | Set 18 (Partition problem)
   * Solution:
   */

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
   * Solution:
   */

  /**
   * 33.
   * Problem: Dynamic Programming | Set 26 (Largest Independent Set Problem)
   * Solution:
   */

  /**
   * 34.
   * Problem: Dynamic Programming | Set 27 (Maximum sum rectangle in a 2D matrix)
   * Solution:
   */

  /**
   * 35.
   * Problem: Dynamic Programming | Set 28 (Minimum insertions to form a palindrome)
   * Solution:
   */

  /**
   * 35.
   * Problem: Dynamic Programming | Set 29 (Longest Common Substring)
   * Solution:
   */

  /**
   * 35.
   * Problem: Dynamic Programming | Set 30 (Dice Throw)
   * Solution:
   */


  /**
   * 35.
   * Problem: Dynamic Programming | Set 31 (Optimal Strategy for a Game)
   * Solution:
   */


  /**
   * 35.
   * Problem: Dynamic Programming | Set 32 (Word Break Problem)
   * Solution:
   */

  /**
   * 35.
   * Problem: Dynamic Programming | Set 33 (Find if a string is interleaved of two other strings)
   * Solution:
   */


  /**
   * 35.
   * Problem: Dynamic Programming | Set 34 (Assembly Line Scheduling)
   * Solution:
   */


  /**
   * 35.
   * Problem: Dynamic Programming | Set 35 (Longest Arithmetic Progression)
   * Solution:
   */

  /**
   * 35.
   * Problem: Dynamic Programming | Set 36 (Maximum Product Cutting)
   * Solution:
   */

  /**
   * 35.
   * Problem: Travelling Salesman Problem | Set 1 (Naive and Dynamic Programming)
   * Solution:
   */

  /**
   * 35.
   * Problem: Count all possible paths from top left to bottom right of a mXn matrix
   * Solution:
   */

  /**
   * 35.
   * Problem: Remove minimum elements from either side such that 2*min becomes more than max
   * Solution:
   */



  /**
   * 35.
   * Problem: Program for nth Catalan Number
   * Solution:
   */

  /**
   * 35.
   * Problem: Dynamic Programming | Set 37 (Boolean Parenthesization Problem)
   * Solution:
   */

  /**
   * 35.
   * Problem: Count number of binary strings without consecutive 1’s
   * Solution:
   */

  /**
   * 35.
   * Problem: Count Possible Decodings of a given Digit Sequence
   * Solution:
   */

  /**
   * 35.
   * Problem: Count all possible walks from a source to a destination with exactly k edges
   * Solution:
   */


  /**
   * 35.
   * Problem: Shortest path with exactly k edges in a directed and weighted graph
   * Solution:
   */

  /**
   * 35.
   * Problem: Mobile Numeric Keypad Problem
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum Cost Polygon Triangulation
   * Solution:
   */

  /**
   * 35.
   * Problem: Longest Even Length Substring such that Sum of First and Second Half is same
   * Solution:
   */

  /**
   * 35.
   * Problem: Weighted Job Scheduling
   * Solution:
   */


  /**
   * 35.
   * Problem: Count number of ways to reach a given score in a game
   * Solution:
   */

  /**
   * 35.
   * Problem: Vertex Cover Problem | Set 2 (Dynamic Programming Solution for Tree)
   * Solution:
   */

  /**
   * 35.
   * Problem: Find the minimum cost to reach destination using a train
   * Solution:
   */

  /**
   * 35.
   * Problem: How to print maximum number of A’s using given four keys
   * Solution:
   */

  /**
   * 35.
   * Problem: Maximum profit by buying and selling a share at most twice
   * Solution:
   */


  /**
   * 35.
   * Problem: Count possible ways to construct buildings
   * Solution:
   */

  /**
   * 35.
   * Problem: Compute sum of digits in all numbers from 1 to n
   * Solution:
   */

  /**
   * 35.
   * Problem: Shortest Common Supersequence
   * Solution:
   */

  /**
   * 35.
   * Problem: Collect maximum points in a grid using two traversals
   * Solution:
   */

  /**
   * 35.
   * Problem: Find minimum number of coins that make a given value
   * Solution:
   */


  /**
   * 35.
   * Problem: Minimum number of squares whose sum equals to given number n
   * Solution:
   */

  /**
   * 35.
   * Problem: Tiling Problem
   * Solution:
   */

  /**
   * 35.
   * Problem: Find length of the longest consecutive path from a given starting character
   * Solution:
   */

  /**
   * 35.
   * Problem: Total number of non-decreasing numbers with n digits
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum Initial Points to Reach Destination
   * Solution:
   */


  /**
   * 35.
   * Problem: Count of n digit numbers whose sum of digits equals to given sum
   * Solution:
   */

  /**
   * 35.
   * Problem: Count total number of N digit numbers such that the difference between sum of even and odd digits is 1
   * Solution:
   */

  /**
   * 35.
   * Problem: Maximum weight transformation of a given string
   * Solution:
   */

  /**
   * 35.
   * Problem: Bitmasking and Dynamic Programming | Set 1 (Count ways to assign unique cap to every person)
   * Solution:
   */

  /**
   * 35.
   * Problem: Longest Repeating Subsequence
   * Solution:
   */


  /**
   * 35.
   * Problem: Count even length binary sequences with same sum of first and second half bits
   * Solution:
   */

  /**
   * 35.
   * Problem: Count number of ways to cover a distance
   * Solution:
   */

  /**
   * 35.
   * Problem: Find the longest path in a matrix with given constraints
   * Solution:
   */

  /**
   * 35.
   * Problem: Find number of solutions of a linear equation of n variables
   * Solution:
   */

  /**
   * 35.
   * Problem: Find minimum possible size of array with given rules for removing elements
   * Solution:
   */


  /**
   * 35.
   * Problem: Number of paths with exactly k coins
   * Solution:
   */

  /**
   * 35.
   * Problem: Collect maximum coins before hitting a dead end
   * Solution:
   */

  /**
   * 35.
   * Problem: Bell Numbers (Number of ways to Partition a Set)
   * Solution:
   */

  /**
   * 35.
   * Problem: Count number of ways to partition a set into k subsets
   * Solution:
   */

  /**
   * 35.
   * Problem: Count number of paths with at-most k turns
   * Solution:
   */


  /**
   * 35.
   * Problem: Count Derangements (Permutation such that no element appears in its original position)
   * Solution:
   */

  /**
   * 35.
   * Problem: Partition a set into two subsets such that the difference of subset sums is minimum
   * Solution:
   */

  /**
   * 35.
   * Problem: Compute nCr % p | Set 1 (Introduction and Dynamic Programming Solution)
   * Solution:
   */

  /**
   * 35.
   * Problem: Longest Zig-Zag Subsequence
   * Solution:
   */

  /**
   * 35.
   * Problem: Permutation Coefficient
   * Solution:
   */


  /**
   * 35.
   * Problem: Count number of subsets having a particular XOR value
   * Solution:
   */

  /**
   * 35.
   * Problem: Weighted Job Scheduling in O(n Log n) time
   * Solution:
   */

  /**
   * 35.
   * Problem: Count number of ways to fill a “n x 4” grid using “1 x 4” tiles
   * Solution:
   */

  /**
   * 35.
   * Problem: Ways to arrange Balls such that adjacent balls are of different types
   * Solution:
   */

  /**
   * 35.
   * Problem: A Space Optimized Solution of LCS
   * Solution:
   */


  /**
   * 35.
   * Problem: Maximum profit by buying and selling a share at most k times
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum time to finish tasks without skipping two consecutive
   * Solution:
   */

  /**
   * 35.
   * Problem: Find maximum length Snake sequence
   * Solution:
   */

  /**
   * 35.
   * Problem: Find if string is K-Palindrome or not | Set 1
   * Solution:
   */

  /**
   * 35.
   * Problem: Wildcard Pattern Matching
   * Solution:
   */


  /**
   * 35.
   * Problem: Longest Common Increasing Subsequence (LCS + LIS)
   * Solution:
   */

  /**
   * 35.
   * Problem: Printing Longest Common Subsequence | Set 2 (Printing All)
   * Solution:
   */

  /**
   * 35.
   * Problem: Printing Shortest Common Supersequence
   * Solution:
   */

  /**
   * 35.
   * Problem: Find if string is K-Palindrome or not | Set 2
   * Solution:
   */

  /**
   * 35.
   * Problem: Construction of Longest Increasing Subsequence using Dynamic Programming
   * Solution:
   */


  /**
   * 35.
   * Problem: Maximize arr[j] – arr[i] + arr[l] – arr[k], such that i < j < k < l
   * Solution:
   */

  /**
   * 35.
   * Problem: Dynamic Programming | High-effort vs. Low-effort Tasks Problem
   * Solution:
   */

  /**
   * 35.
   * Problem: Find minimum adjustment cost of an array
   * Solution:
   */

  /**
   * 35.
   * Problem: Printing Maximum Sum Increasing Subsequence
   * Solution:
   */

  /**
   * 35.
   * Problem: Printing Longest Bitonic Subsequence
   * Solution:
   */


  /**
   * 35.
   * Problem: Find Jobs involved in Weighted Job Scheduling
   * Solution:
   */

  /**
   * 35.
   * Problem: Print Maximum Length Chain of Pairs
   * Solution:
   */

  /**
   * 35.
   * Problem: Weighted Job Scheduling | Set 2 (Using LIS)
   * Solution:
   */

  /**
   * 35.
   * Problem: Longest Geometric Progression
   * Solution:
   */

  /**
   * 35.
   * Problem: Find all combinations of k-bit numbers with n bits set where 1 <= n <= k in sorted order
   * Solution:
   */


  /**
   * 35.
   * Problem: Minimum Cost To Make Two Strings Identical
   * Solution:
   */

  /**
   * 35.
   * Problem: Find number of times a string occurs as a subsequence in given string
   * Solution:
   */

  /**
   * 35.
   * Problem: A Space Optimized DP solution for 0-1 Knapsack Problem
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum cost to fill given weight in a bag
   * Solution:
   */

  /**
   * 35.
   * Problem: Count digit groupings of a number with given constraints
   * Solution:
   */


  /**
   * 35.
   * Problem: Non-crossing lines to connect points in a circle
   * Solution:
   */

  /**
   * 35.
   * Problem: Count Distinct Subsequences
   * Solution:
   */

  /**
   * 35.
   * Problem: Find minimum sum such that one of every three consecutive elements is taken
   * Solution:
   */

  /**
   * 35.
   * Problem: Longest repeating and non-overlapping substring
   * Solution:
   */

  /**
   * 35.
   * Problem: Count distinct occurrences as a subsequence
   * Solution:
   */


  /**
   * 35.
   * Problem: Count all increasing subsequences
   * Solution:
   */

  /**
   * 35.
   * Problem: All ways to add parenthesis for evaluation
   * Solution:
   */

  /**
   * 35.
   * Problem: Choice of Area
   * Solution:
   */

  /**
   * 35.
   * Problem: Number of permutation with K inversions
   * Solution:
   */

  /**
   * 35.
   * Problem: Maximum weight path ending at any element of last row in a matrix
   * Solution:
   */


  /**
   * 35.
   * Problem: Print all longest common sub-sequences in lexicographical order
   * Solution:
   */

  /**
   * 35.
   * Problem: Count All Palindromic Subsequence in a given String
   * Solution:
   */

  /**
   * 35.
   * Problem: Recursively break a number in 3 parts to get maximum sum
   * Solution:
   */

  /**
   * 35.
   * Problem: Path with maximum average value
   * Solution:
   */

  /**
   * 35.
   * Problem: Maximum sum of pairs with specific difference
   * Solution:
   */


  /**
   * 35.
   * Problem: Maximum sum alternating subsequence
   * Solution:
   */

  /**
   * 35.
   * Problem: Maximum subsequence sum such that no three are consecutive
   * Solution:
   */

  /**
   * 35.
   * Problem: Count All Palindrome Sub-Strings in a String
   * Solution:
   */

  /**
   * 35.
   * Problem: Sum of average of all subsets
   * Solution:
   */

  /**
   * 35.
   * Problem: Longest subsequence such that difference between adjacents is one
   * Solution:
   */


  /**
   * 35.
   * Problem: Maximum decimal value path in a binary matrix
   * Solution:
   */

  /**
   * 35.
   * Problem: Maximum sum subarray removing at most one element
   * Solution:
   */

  /**
   * 35.
   * Problem: Number of palindromic paths in a matrix
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum and Maximum values of an expression with * and +
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum cost to sort strings using reversal operations of different costs
   * Solution:
   */


  /**
   * 35.
   * Problem: Minimum sum subsequence such that at least one of every four consecutive elements is picked
   * Solution:
   */

  /**
   * 35.
   * Problem: Count number of ways to reach destination in a Maze
   * Solution:
   */

  /**
   * 35.
   * Problem: Maximum path sum for each position with jumps under divisibility condition
   * Solution:
   */

  /**
   * 35.
   * Problem: Super Ugly Number (Number whose prime factors are in given set)
   * Solution:
   */

  /**
   * 35.
   * Problem: Maximum sum Bi-tonic Sub-sequence
   * Solution:
   */


  /**
   * 35.
   * Problem: Find all distinct subset (or subsequence) sums of an array
   * Solution:
   */

  /**
   * 35.
   * Problem: Ways to write n as sum of two or more positive integers
   * Solution:
   */

  /**
   * 35.
   * Problem: Unbounded Knapsack (Repetition of items allowed)
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum number of elements which are not part of Increasing or decreasing subsequence in array
   * Solution:
   */

  /**
   * 35.
   * Problem: LCS (Longest Common Subsequence) of three strings
   * Solution:
   */


  /**
   * 35.
   * Problem: Probability of Knight to remain in the chessboard
   * Solution:
   */

  /**
   * 35.
   * Problem: Find Maximum dot product of two arrays with insertion of 0’s
   * Solution:
   */

  /**
   * 35.
   * Problem: Check whether row or column swaps produce maximum size binary sub-matrix with all 1s
   * Solution:
   */

  /**
   * 35.
   * Problem: Count of AP (Arithmetic Progression) Subsequences in an array
   * Solution:
   */

  /**
   * 35.
   * Problem: Maximum points collected by two persons allowed to meet once
   * Solution:
   */


  /**
   * 35.
   * Problem: Maximum path sum in a triangle.
   * Solution:
   */

  /**
   * 35.
   * Problem: Printing brackets in Matrix Chain Multiplication Problem
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum Sum Path In 3-D Array
   * Solution:
   */

  /**
   * 35.
   * Problem: Friends Pairing Problem
   * Solution:
   */

  /**
   * 35.
   * Problem: Check if all people can vote on two machines
   * Solution:
   */


  /**
   * 35.
   * Problem: Count binary strings with k times appearing adjacent two set bits
   * Solution:
   */

  /**
   * 35.
   * Problem: Probability of getting at least K heads in N tosses of Coins
   * Solution:
   */

  /**
   * 35.
   * Problem: Size of array after repeated deletion of LIS
   * Solution:
   */

  /**
   * 35.
   * Problem: Maximum path sum that starting with any cell of 0-th row and ending with any cell of (N-1)-th row
   * Solution:
   */

  /**
   * 35.
   * Problem: Number of subsequences in a string divisible by n
   * Solution:
   */


  /**
   * 35.
   * Problem: Finding the maximum square sub-matrix with all equal elements
   * Solution:
   */

  /**
   * 35.
   * Problem: Gold Mine Problem
   * Solution:
   */

  /**
   * 35.
   * Problem: Highway Billboard Problem
   * Solution:
   */

  /**
   * 35.
   * Problem: Count of strings that can be formed using a, b and c under given constraints
   * Solution:
   */

  /**
   * 35.
   * Problem: Modify array to maximize sum of adjacent differences
   * Solution:
   */


  /**
   * 35.
   * Problem: Sum of all substrings of a string representing a number | Set 1
   * Solution:
   */

  /**
   * 35.
   * Problem: Number of subsequences of the form a^i b^j c^k
   * Solution:
   */

  /**
   * 35.
   * Problem: Count ways to increase LCS length of two strings by one
   * Solution:
   */

  /**
   * 35.
   * Problem: Find number of endless points
   * Solution:
   */

  /**
   * 35.
   * Problem: How to solve a Dynamic Programming Problem ?
   * Solution:
   */


  /**
   * 35.
   * Problem: Tabulation vs Memoizatation
   * Solution:
   */

  /**
   * 35.
   * Problem: Perfect Sum Problem (Print all subsets with given sum)
   * Solution:
   */

  /**
   * 35.
   * Problem: Largest sum Zigzag sequence in a matrix
   * Solution:
   */

  /**
   * 35.
   * Problem: Maximum sum of a path in a Right Number Triangle
   * Solution:
   */

  /**
   * 35.
   * Problem: Subset with sum divisible by m
   * Solution:
   */


  /**
   * 35.
   * Problem: Digit DP | Introduction
   * Solution:
   */

  /**
   * 35.
   * Problem: Smallest length string with repeated replacement of two distinct adjacent
   * Solution:
   */

  /**
   * 35.
   * Problem: Temple Offerings
   * Solution:
   */

  /**
   * 35.
   * Problem: Count of arrays in which all adjacent elements are such that one of them divide the another
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum number of deletions to make a string palindrome
   * Solution:
   */


  /**
   * 35.
   * Problem: Minimum steps to minimize n as per given condition
   * Solution:
   */

  /**
   * 35.
   * Problem: Clustering/Partitioning an array such that sum of square differences is minimum
   * Solution:
   */

  /**
   * 35.
   * Problem: Longest alternating subsequence
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum steps to delete a string after repeated deletion of palindrome substrings
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum number of deletions to make a sorted sequence
   * Solution:
   */


  /**
   * 35.
   * Problem: Count number of ways to jump to reach end
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum number of deletions and insertions to transform one string into another
   * Solution:
   */

  /**
   * 35.
   * Problem: Shortest Uncommon Subsequence
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum insertions to sort an array
   * Solution:
   */

  /**
   * 35.
   * Problem: Dynamic Programming | Building Bridges
   * Solution:
   */


  /**
   * 35.
   * Problem: Number of substrings divisible by 8 but not by 3
   * Solution:
   */

  /**
   * 35.
   * Problem: Sequences of given length where every element is more than or equal to twice of previous
   * Solution:
   */

  /**
   * 35.
   * Problem: Ways to sum to N using array elements with repetition allowed
   * Solution:
   */

  /**
   * 35.
   * Problem: Maximum sum in a 2 x n grid such that no two elements are adjacent
   * Solution:
   */

  /**
   * 35.
   * Problem: Count the number of ways to tile the floor of size n x m using 1 x m size tiles
   * Solution:
   */


  /**
   * 35.
   * Problem: Pyramid form (increasing then decreasing) consecutive array using reduce operations
   * Solution:
   */

  /**
   * 35.
   * Problem: Counts paths from a point to reach Origin
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum time to write characters using insert, delete and copy operation
   * Solution:
   */

  /**
   * 35.
   * Problem: Count Balanced Binary Trees of Height h
   * Solution:
   */

  /**
   * 35.
   * Problem: Choose maximum weight with given weight and value ratio
   * Solution:
   */































}
