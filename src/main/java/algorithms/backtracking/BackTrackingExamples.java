package algorithms.backtracking;

import recursion.RecursionExamples;

import java.util.Set;

public class BackTrackingExamples {

  /**
   * 1.
   * Problem: 8 queen problem.
   */
  void queenProblem(int[][] board, int column) {
    new RecursionExamples().solveNQueen(board, column);
  }

  /**
   * 2.
   * Problem: Write a  program to print all permutations of a given string.
   */
  void printPermutation(String str, String rem) {
    new RecursionExamples().printPermutations(str, rem);
  }

  /**
   * 3.
   * Problem: Backtracking | Set 1 (The Knight's tour problem).
   */

  /**
   * 4.
   * Problem: Backtracking | Set 2 (Rat in a Maze).
   * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and
   * destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach
   * destination. The rat can move only in two directions: forward and down.
   */
    void solveMaze(int[][] board) {
     int[][] solution = new int[board.length][board[0].length];
      solveMazeUtil(solution, board, board.length - 1, board[0].length - 1);
      for (int i = 0; i < solution.length; i++) {
        for (int j = 0; j < solution[0].length; j++) System.out.print(solution[i][j]);
        System.out.println();
      }

   }

   boolean solveMazeUtil(int[][] solution, int[][] board, int i, int j) {
      if (i == 0 && j == 0 && board[0][0] == 1)  {
        solution[0][0] = 1;
        return true;
      }
      else {
        if (isValid(board, i, j)) {
          solution[i][j] = 1;
          if (solveMazeUtil(solution, board, i - 1, j) || solveMazeUtil(solution, board, i, j - 1)) return true;
          solution[i][j] = 0;
        }
      }
      return false;
   }

   boolean isValid(int[][] board, int i, int j) {
      return i >= 0 && j >= 0 && board[i][j] == 1;
   }


  /**
   * 5.
   * Problem: Backtracking | Set 3 (N Queen Problem).
   * Solution:
   */
  void nQueenProblem(int[][] board, int column) {
    new RecursionExamples().solveNQueen(board, column);
  }
  /**
   * 6.
   * Problem: Backtracking | Set 4 (Subset Sum).
   */
  void printSubsetSum(int[] array, int sum, String soFar, int m) {
    if (sum == 0) System.out.println(soFar + " ");
    else {
      if (sum >= 0 && m > 0) {
            printSubsetSum(array, sum - array[m - 1], soFar + array[m - 1], m - 1);
            printSubsetSum(array, sum, soFar, m - 1);
      }
    }
  }

  /**
   * 7.
   * Problem: Backtracking | Set 5 (m Coloring Problem).
   * Solution:
   */

  /**
   * 8.
   * Problem: Backtracking | Set 6 (Hamiltonian Cycle).
   * Solution:
   */

  /**
   * 9.
   * Problem: Backtracking | Set 7 (Sudoku).
   * Solution:
   */

  /**
   * 10.
   * Problem: Tug of War.
   * Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of
   * two subsets is as minimum as possible. If n is even, then sizes of two subsets must be strictly n/2 and if n is
   * odd, then size of one subset must be (n-1)/2 and size of other subset must be (n+1)/2.
   * Solution: Try every possible subset of half size. If one subset of half size is formed, the remaining elements
   * form the other subset. We check whether this solutions is better than the best solution available so far.
   * If it is, then we update the best solution.
   */

  /**
   * 11.
   * Problem: Print all possible paths from top left to bottom right of a mXn matrix.
   */

  /**
   * 12.
   * Problem: Backtracking | Set 8 (Solving Cryptarithmetic Puzzles).
   * Solution:
   */

  /**
   * 13.
   * Problem: Fill two instances of all numbers from 1 to n in a specific way.
   * Solution:
   */

  /**
   * 14.
   * Problem: Find if there is a path of more than k length from a source.
   * Solution:
   */

  /**
   * 15.
   * Problem: Find paths from corner cell to middle cell in maze.
   * Solution:
   */

  /**
   * 16.
   * Problem: Find Maximum number possible by doing at-most K swaps.
   * Solution:
   */

  /**
   * 17.
   * Problem: Match a pattern and String without using regular expressions.
   * Solution:
   */

  /**
   * 18.
   * Problem: Longest Possible Route in a Matrix with Hurdles.
   * Solution:
   */

  /**
   * 19.
   * Problem: Find shortest safe route in a path with landmines.
   * Solution:
   */

  /**
   * 20.
   * Problem: Remove Invalid Parentheses.
   * Solution:
   */

  /**
   * 21.
   * Problem: Partition of a set into K subsets with equal sum.
   * Solution:
   */

  /**
   * 22.
   * Problem: Word Break Problem using Backtracking.
   * Given a valid sentence without any spaces between the words and a dictionary of valid English words, find all
   * possible ways to break the sentence in individual dictionary words.
   */
  void printWordBreak(String soFar, String rest, Set<String> dictionary) {
    if (rest.isEmpty()) System.out.println(soFar);
    else for (int i = 0; i < rest.length(); i++) {
      String word = rest.substring(0, i + 1);
      if (dictionary.contains(word)) printWordBreak(soFar + word + " ", rest.substring(i + 1), dictionary);
    }
  }

  /**
   * 23.
   * Problem: Print all palindromic partitions of a string.
   * Solution:
   */

  /**
   * 24.
   * Problem: Printing all solutions in N-Queen Problem.
   */
  void printNQueens(int[][] board, int column) {
    if (column >= board[0].length) printBoard(board);
    else {
      for (int row = 0; row < board.length; row++) {
        if (new RecursionExamples().isSafe(board, row, column)) {
          board[row][column] = 1;
          printNQueens(board, column + 1);
          board[row][column] = 0;
        }
      }
    }
  }

  private void printBoard(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) System.out.print(board[i][j]);
      System.out.println();
    }
    System.out.println();
  }

  /**
   * 25.
   * Problem: Warnsdorff's algorithm for Knight’s tour problem.
   * Solution:
   */

  /**
   * 26.
   * Problem: Top 20 Backtracking Algorithm Interview Questions.
   * Solution:
   */

  /**
   * 27.
   * Problem: Combinations where every element appears twice and distance between appearances is equal to the value.
   * Solution:
   */

}
