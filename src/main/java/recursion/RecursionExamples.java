package recursion;

import utilities.ListNode;
import utilities.Stack;

import java.util.*;

public class RecursionExamples {



  /**
   * 1.
   * Problem: Exponent of a number
   * Solution: base*base^(exp - 1)
   */
  int getExponent(int base, int exp) {
    if (exp == 0) return 1;
    else return base * getExponent(base, exp - 1);
  }

  int getExponentTR(int base, int exp, int acc) {
    if (exp == 0) return acc;
    else return getExponentTR(base, exp - 1, acc * base);
  }

  /**
   * More efficient.
   */
  int getExponentEfficient(int base, int exp) {
    if (exp == 0) return 1;
    else {
      int half = getExponentEfficient(base, exp / 2);
      if (exp % 2 == 0) return half * half;
      else return base * half * half;
    }
  }

  /**
   * 2.
   * Problem: Given a string, check whether palindrome or not.
   */
  public boolean isPalindrome(String str) {
    return (str.length() <= 1) || str.charAt(0) == str.charAt(str.length() - 1)
            && isPalindrome(str.substring(1, str.length() - 1));
  }

  /**
   * 3.
   * Problem: BinarySearch
   */
  int binarySearch(int[] array, int startIndex, int endIndex, int value) {
    if (startIndex <= endIndex) {
      int midIndex = startIndex + (endIndex - startIndex) / 2;
      if (value == array[midIndex]) return midIndex;
      else if (value < array[midIndex]) return binarySearch(array, startIndex, midIndex - 1, value);
      else return binarySearch(array, midIndex + 1, endIndex, value);
    } else return -1;
  }

  /**
   * 4.
   * Problem: Combination
   */
  int combination(int n, int k) {
    if (n == k || k == 0) return 1;
    else return combination(n - 1, k) + combination(n - 1, k - 1);
  }

  /**
   * 5.
   * Problem: Tower of Hanoi
   */
  void towerOfHanoi(int disk, String source, String dest, String temp){
    if (disk > 0) {
      towerOfHanoi(disk - 1, source, temp, dest);
      System.out.println(source + " -> " + dest);
      towerOfHanoi(disk - 1, temp, dest, source);
    }
  }

  /**
   * 6.
   * Problem: Permutations of a string
   */
 public void printPermutations(String soFar, String remaining) {
    if (remaining.isEmpty()) System.out.println(soFar);
    else {
      for (int i = 0; i < remaining.length(); i++)
        printPermutations(soFar + remaining.charAt(i),
                remaining.substring(0, i) + remaining.substring(i + 1));
    }
  }

  /**
   * 7.
   * Problem: Subset of String.
   */
  void printSubsets(String soFar, String remaining) {
    if (remaining.isEmpty()) System.out.println(soFar);
    else {
      printSubsets(soFar + remaining.charAt(0), remaining.substring(1));
      printSubsets(soFar, remaining.substring(1));
    }
  }

  /**
   * 8.
   * Problem: AnagramFinder
   * Solution: Use backtracking
   *  boolean solve(configuration conf) {
   *    // BASE CASE
   *    if (no more choices)
   *      return (conf is in goal state);
   *    else {
   *      for (choice : choices) {
   *        try one choice c;
   *        // solve from here, if work out, you are done
   *        if (solve(conf with choice c made) return true;
   *        unmake choice c;
   *      }
   *      return false;  // tried all choices, no solution found.
   *    }
   *  }
   */
  boolean isAnagram(String soFar, String remaining, HashSet<String> dictionary) {
    if (remaining.isEmpty()) return dictionary.contains(soFar);
    else {
      for (int i = 0; i < remaining.length(); i++) {
        if (isAnagram(soFar + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), dictionary))
          return true;
      }
    }
    return false;
  }

  /**
   * 9.
   * Problem: N Queens Problems
   */
  public void placeQueen(int[][] board, int row, int column) {
    board[row][column] = 1;
  }

  public void removeQueen(int[][] board, int row, int column) {
    board[row][column] = 0;
  }

  public boolean isSafe(int[][] board, int row, int column) {
    for (int c = column; c >= 0 ; c--) if (board[row][c] == 1) return false;
    for (int r = row, c = column; r >= 0 && c >=0; r--, c--) if (board[r][c] == 1) return false;
    for (int r = row, c = column; r < board.length && c >= 0; r++, c--) if(board[r][c] == 1) return false;
    return true;
  }

  public boolean solveNQueen(int[][] board, int column) {
    if (column >= board[0].length) return true;
    else {
      for (int row = 0; row < board.length; row++) {
        if (isSafe(board, row, column)) {
          placeQueen(board, row, column);
          if (solveNQueen(board, column + 1)) return true;
          removeQueen(board, row, column);
        }
      }
    }
    return false;
  }



  /**
   * 2.
   * Problem: Reverse a stack without using any other data structure or auxiliary space.
   */



}
