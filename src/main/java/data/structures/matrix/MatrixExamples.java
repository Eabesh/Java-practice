package data.structures.matrix;
import algorithms.dynamic.programming.DPExamples;
import data.structures.stack.StackExamples;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrixExamples {

  /**
   * 1.
   * Problem: Maximum size square sub-matrix with all 1s.
   * Solution:
   */
  int[][] maxSizeSubMatrix(int[][] mat, int[][] dp) {
    return new DPExamples().maxSizeSquareMat(mat, dp);
  }


  /**
   * 2.
   * Problem: Turn an image by 90 degree.
   * Solution:
   */

  /**
   * 3.
   * Problem: Search in a row wise and column wise sorted matrix.
   * Solution:
   */

  /**
   * 4.
   * Problem: Print a given matrix in spiral form.
   * Solution:
   */

  /**
   * 5.
   * Problem: A Boolean Matrix Question.
   * Solution:
   */

  /**
   * 6.
   * Problem: Dynamic Programming | Set 6 (Min Cost Path).
   * Solution:
   */

  /**
   * 7.
   * Problem: Dynamic Programming | Set 8 (Matrix Chain Multiplication).
   * Solution:
   */

  /**
   * 8.
   * Problem: Magic Square.
   * Solution:
   */

  /**
   * 9.
   * Problem: Find the row with maximum number of 1s.
   * Solution:
   */

  /**
   * 10.
   * Problem: Print unique rows in a given boolean matrix.
   * Solution:
   */

  /**
   * 11.
   * Problem: Inplace (Fixed space) M x N size matrix transpose | Updated.
   * Solution:
   */

  /**
   * 12.
   * Problem: Find the number of islands | Set 1 (Using DFS).
   * Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the
   * below matrix contains 5 islands.
   * Input : mat[][] =
   * {{1, 1, 0, 0, 0},
   * {0, 1, 0, 0, 1},
   * {1, 0, 0, 1, 1},
   * {0, 0, 0, 0, 0},
   * {1, 0, 1, 0, 1}
   * Output : 5
   * Solution:
   */
  int countIslands(int[][] mat) {
    int islandsCount = 0;
    boolean[][] isVisited = new boolean[mat.length][mat[0].length];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 1 && !isVisited[i][j]) {
          islandsCount++;
          dfs(mat, i, j, isVisited);
        }
      }
    }
    return islandsCount;
  }
  private void dfs(int[][] mat, int x, int y, boolean[][] isVisited) {
    int[][] moves = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    isVisited[x][y] = true;
    for (int[] move : moves)
      if (isSafe(mat, x + move[0], y + move[1], isVisited)) dfs(mat, x + move[0], y + move[1], isVisited);
  }
  private boolean isSafe(int[][] mat, int x, int y, boolean[][] isVisited) {
    return x >=0 && x < mat.length && y >=0 && y < mat[0].length && mat[x][y] == 1 && !isVisited[x][y];
  }

  /**
   * 13.
   * Problem: Dynamic Programming | Set 27 (Maximum sum rectangle in a 2D matrix).
   * Solution:
   */

  /**
   * 14.
   * Problem: Zigzag (or diagonal) traversal of Matrix.
   * Solution:
   */

  /**
   * 15.
   * Problem: Print all possible paths from top left to bottom right of a mXn matrix.
   * The problem is to print all the possible paths from top left to bottom right of a mXn matrix with the constraints
   * that from each cell you can either move only to right or down.
   * Solution:
   */
  public void printAllPaths(int[][] mat, String path, int x, int y) {
    if (x == mat.length - 1 && y == mat[0].length - 1) System.out.println(path + mat[mat.length - 1][mat[0].length - 1]);
    else {
      if (x < mat.length  && y < mat[0].length) {
      printAllPaths(mat, path + mat[x][y], x + 1, y );
      printAllPaths(mat, path + mat[x][y], x, y + 1);
       }
    }
  }
  /**
   * 16.
   * Problem: Count all possible paths from top left to bottom right of a mXn matrix.
   * Solution:
   */

  /**
   * 17.
   * Problem: Kth smallest element in a row-wise and column-wise sorted 2D array | Set 1.
   * Solution:
   */

  /**
   * 18.
   * Problem: Create a matrix with alternating rectangles of O and X.
   * Solution:
   */

  /**
   * 19.
   * Problem: C program to multiply two matrices.
   * Solution:
   */

  /**
   * 20.
   * Problem: C program for addition of two matrices.
   * Solution:
   */

  /**
   * 21.
   * Problem: C program for subtraction of matrices.
   * Solution:
   */

  /**
   * 22.
   * Problem: C program to find transpose of a matrix.
   * Solution:
   */

  /**
   * 23.
   * Problem: C Program to check if two given matrices are identical.
   * Solution:
   */

  /**
   * 24.
   * Problem: Given an n x n square matrix, find sum of all sub-squares of size k x k.
   * Solution:
   */

  /**
   * 25.
   * Problem: Mobile Numeric Keypad Problem.
   * Solution:
   */

  /**
   * 26.
   * Problem: Print all elements in sorted order from row and column wise sorted matrix.
   * Solution:
   */

  /**
   * 27.
   * Problem: Flood fill Algorithm &#8211; how to implement fill() in paint?.
   * Solution:
   */

  /**
   * 28.
   * Problem: Given a matrix of &#8216;O&#8217; and &#8216;X&#8217;, find the largest subsquare surrounded by &#8216;X&#8217;.
   * Solution:
   */

  /**
   * 29.
   * Problem: Given a matrix of ‘O’ and ‘X’,  replace &#8216;O&#8217; with &#8216;X&#8217; if surrounded by &#8216;X&#8217;.
   * Solution:
   */

  /**
   * 30.
   * Problem: Find a common element in all rows of a given row-wise sorted matrix.
   * Solution:
   */

  /**
   * 31.
   * Problem: Count number of islands where every island is row-wise and column-wise separated.
   * Solution:
   */

  /**
   * 32.
   * Problem: Find sum of all elements in a matrix except the elements in row and/or column of given cell?.
   * Solution:
   */

  /**
   * 33.
   * Problem: Rotate Matrix Elements.
   * Solution:
   */

  /**
   * 34.
   * Problem: Collect maximum points in a grid using two traversals.
   * Solution:
   */

  /**
   * 35.
   * Problem: Minimum time required to rot all oranges.
   * Determine what is the minimum time required so that all the oranges become rotten. A rotten orange at index [i,j]
   * can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). If it is
   * impossible to rot every orange then simply return -1.
   * Solution: Use BFS.
   */
  public int rotOranges(int[][] oranges) {
    int[][] visited = new int[oranges.length][oranges[0].length];
    int days = rot(oranges, visited, 0);
    if (notAllRotten(oranges)) return -1;
    else return days;
  }

  private int rot(int[][] oranges, int[][] visited, int days) {
    if (!isMovePossible(oranges)) return days;
    else {
      for (int row = 0; row < oranges.length; row++)
        for (int column = 0; column < oranges[0].length; column++)
          if (oranges[row][column] == 2) rotNeighbours(oranges, visited, row, column);
      markRotten(oranges, visited);
      return rot(oranges, visited, days + 1);
    }
  }

  private void rotNeighbours(int[][] oranges, int[][] visited, int row, int column) {
    if (row + 1 < oranges.length && oranges[row + 1][column] == 1) visited[row + 1][column] = 1;
    if (row - 1 >= 0 && oranges[row - 1][column] == 1) visited[row - 1][column] = 1;
    if (column + 1 < oranges[0].length && oranges[row][column + 1] == 1) visited[row][column + 1] = 1;
    if (column - 1 >= 0 && oranges[row][column - 1] == 1) visited[row][column - 1] = 1;
  }

  private void markRotten(int[][] oranges, int[][] visited) {
    for (int row = 0; row < oranges.length; row++)
      for (int column = 0; column < oranges[0].length; column++)
        if (visited[row][column] == 1) oranges[row][column] = 2;
  }

  private boolean notAllRotten(int[][] oranges) {
    for (int row = 0; row < oranges.length; row++)
      for (int column = 0; column < oranges[0].length; column++)
        if (oranges[row][column] == 1) return true;
    return false;
  }

  private boolean isMovePossible(int[][] oranges) {
    for (int row = 0; row < oranges.length; row++)
      for (int column = 0; column < oranges[0].length; column++)
        if (oranges[row][column] == 2 &&
                ((row + 1 < oranges.length && oranges[row + 1][column] == 1) ||
                        (column + 1 < oranges[0].length && oranges[row][column + 1] == 1) ||
                        (row - 1 >= 0 && oranges[row - 1][column] == 1) ||
                        (column - 1 >= 0 && oranges[row][column - 1] == 1))) return true;
    return false;
  }

  /**
   * 36.
   * Problem: Find length of the longest consecutive path from a given starting character.
   * Solution:
   */

  /**
   * 37.
   * Problem: Minimum Initial Points to Reach Destination.
   * Solution:
   */

  /**
   * 38.
   * Problem: Validity of a given Tic-Tac-Toe board configuration.
   * Solution:
   */

  /**
   * 39.
   * Problem: Find the largest rectangle of 1&#8217;s with swapping of columns allowed.
   * Solution:
   */

  /**
   * 40.
   * Problem: Given a Boolean Matrix, find k such that all elements in k&#8217;th row are 0 and k&#8217;th column are 1..
   * Solution:
   */

  /**
   * 41.
   * Problem: Find the longest path in a matrix with given constraints.
   * Solution:
   */

  /**
   * 42.
   * Problem: Number of paths with exactly k coins
   * Given a matrix where every cell has some number of coins. Count number of ways to reach bottom right from top left
   * with exactly k coins. We can move to (i+1, j) and (i, j+1) from a cell (i, j).
   * Example:
   * Input:  k = 12
   * mat[][] =
   * { {1, 2, 3},
   * {4, 6, 5},
   * {3, 2, 1}};
   * Output:  2
   * There are two paths with 12 coins
   * 1 -> 2 -> 6 -> 2 -> 1
   * 1 -> 2 -> 3 -> 5 -> 1
   */
  int countPathsKCoins(int[][] mat, int x, int y, int k) {
    if (x == 0 && y == 0 && k == mat[0][0]) return 1;
    else if (x < 0 || y < 0) return 0;
    else return countPathsKCoins(mat, x - 1, y, k - mat[x][y])
              + countPathsKCoins(mat, x, y -1, k - mat[x][y]);
  }


  /**
   * 43.
   * Problem: Collect maximum coins before hitting a dead end.
   * Solution:
   */

  /**
   * 44.
   * Problem: Program for Rank of Matrix.
   * Solution:
   */

  /**
   * 45.
   * Problem: Submatrix Sum Queries.
   * Solution:
   */

  /**
   * 46.
   * Problem: Maximum size rectangle binary sub-matrix with all 1s.
   * Solution:
   */

  /**
   * 47.
   * Problem: Count Negative Numbers in a Column-Wise and Row-Wise Sorted Matrix.
   * Solution:
   */

  /**
   * 48.
   * Problem: Construct Ancestor Matrix from a Given Binary Tree.
   * Solution:
   */

  /**
   * 49.
   * Problem: Construct tree from ancestor matrix.
   * Solution:
   */

  /**
   * 50.
   * Problem: In-place convert matrix in specific order.
   * Solution:
   */

  /**
   * 51.
   * Problem: Common elements in all rows of a given matrix.
   * Solution:
   */

  /**
   * 52.
   * Problem: Print maximum sum square sub-matrix of given size.
   * Solution:
   */

  /**
   * 53.
   * Problem: Find a specific pair in Matrix.
   * Solution:
   */

  /**
   * 54.
   * Problem: Find orientation of a pattern in a matrix.
   * Solution:
   */

  /**
   * 55.
   * Problem: Shortest path in a Binary Maze.
   * Solution:
   */

  /**
   * 56.
   * Problem: Inplace rotate square matrix by 90 degrees | Set 1.
   * Solution:
   */

  /**
   * 57.
   * Problem: Return previous element in an expanding matrix.
   * Solution:
   */

  /**
   * 58.
   * Problem: Print n x n spiral matrix using O(1) extra space.
   * Solution:
   */

  /**
   * 59.
   * Problem: A matrix probability question.
   * Solution:
   */

  /**
   * 60.
   * Problem: Find maximum length Snake sequence.
   * Solution:
   */

  /**
   * 61.
   * Problem: Count zeros in a row wise and column wise sorted matrix.
   * Solution:
   */

  /**
   * 62.
   * Problem: Find size of the largest &#8216;+&#8217; formed by all ones in a binary matrix.
   * Solution:
   */

  /**
   * 63.
   * Problem: Find if given matrix is Toeplitz or not.
   * Solution:
   */

  /**
   * 64.
   * Problem: Longest Possible Route in a Matrix with Hurdles.
   * Solution:
   */

  /**
   * 65.
   * Problem: Print K&#8217;th element in spiral form of matrix.
   * Solution:
   */

  /**
   * 66.
   * Problem: Find shortest safe route in a path with landmines.
   * Solution:
   */

  /**
   * 67.
   * Problem: Find Shortest distance from a guard in a Bank.
   * Solution:
   */

  /**
   * 68.
   * Problem: Direction at last square block.
   * Solution:
   */

  /**
   * 69.
   * Problem: Queries in a Matrix.
   * Solution:
   */

  /**
   * 70.
   * Problem: Construct a unique matrix n x n  for an input n.
   * Solution:
   */

  /**
   * 71.
   * Problem: Count all sorted rows in a matrix.
   * Solution:
   */

  /**
   * 72.
   * Problem: Latin Square.
   * Solution:
   */

  /**
   * 73.
   * Problem: Saddle point in a matrix.
   * Solution:
   */

  /**
   * 74.
   * Problem: Maximum weight path ending at any element of last row in a matrix.
   * Solution:
   */

  /**
   * 75.
   * Problem: Nearest 1 in a binary matrix.
   * Solution:
   */

  /**
   * 76.
   * Problem: Maximum mirrors which can transfer light from bottom to right.
   * Solution:
   */

  /**
   * 77.
   * Problem: Path with maximum average value.
   * Solution:
   */

  /**
   * 78.
   * Problem: Maximum XOR value in matrix.
   * Solution:
   */

  /**
   * 79.
   * Problem: Rotate each ring of matrix anticlockwise by K elements.
   * Solution:
   */

  /**
   * 80.
   * Problem: Summed Area Table &#8211; Submatrix Summation.
   * Solution:
   */

  /**
   * 81.
   * Problem: Find pairs with given sum such that elements of pair are in different rows.
   * Solution:
   */

  /**
   * 82.
   * Problem: Minimum Cost Path with Left, Right, Bottom and Up moves allowed.
   * Solution:
   */

  /**
   * 83.
   * Problem: Maximum difference of sum of elements in two rows in a matrix.
   * Solution:
   */

  /**
   * 84.
   * Problem: Print matrix in diagonal pattern.
   * Solution:
   */

  /**
   * 85.
   * Problem: Maximum decimal value path in a binary matrix.
   * Solution:
   */

  /**
   * 86.
   * Problem: Check if possible to move from given coordinate to desired coordinate.
   * Solution:
   */

  /**
   * 87.
   * Problem: Print cells with same rectangular sums  in a matrix.
   * Solution:
   */

  /**
   * 88.
   * Problem: Find perimeter of shapes formed with 1s in binary matrix.
   * Solution:
   */

  /**
   * 89.
   * Problem: Minimum difference between adjacent elements of array which contain elements from each row of a matrix.
   * Solution:
   */

  /**
   * 90.
   * Problem: Number of palindromic paths in a matrix.
   * Solution:
   */

  /**
   * 91.
   * Problem: Replace every matrix element with maximum of GCD of row or column.
   * Solution:
   */

  /**
   * 92.
   * Problem: Total coverage of all zeros in a binary matrix.
   * Solution:
   */

  /**
   * 93.
   * Problem: Count number of ways to reach destination in a Maze.
   * Solution:
   */

  /**
   * 94.
   * Problem: Count inversion pairs in a matrix.
   * Solution:
   */

  /**
   * 95.
   * Problem: Find all permuted rows of a given row in  a matrix.
   * Solution:
   */

  /**
   * 96.
   * Problem: Find pair of rows in a binary matrix that has maximum bit difference.
   * Solution:
   */

  /**
   * 97.
   * Problem: Check if all rows of a matrix are circular rotations of each other.
   * Solution:
   */

  /**
   * 98.
   * Problem: Sum of both diagonals of a spiral odd-order square matrix.
   * Solution:
   */

  /**
   * 99.
   * Problem: Maximum determinant of a matrix with every values either 0 or n.
   * Solution:
   */

  /**
   * 100.
   * Problem: Check horizontal and vertical symmetry in binary matrix.
   * Solution:
   */

  /**
   * 101.
   * Problem: Check whether row or column swaps produce maximum size binary sub-matrix with all 1s.
   * Solution:
   */

  /**
   * 102.
   * Problem: Sum of matrix in which each element is absolute difference of its row and column numbers.
   * Solution:
   */

  /**
   * 103.
   * Problem: Sparse Matrix and its representations | Set 1 (Using Arrays and Linked Lists).
   * Solution:
   */

  /**
   * 104.
   * Problem: Maximum points collected by two persons allowed to meet once.
   * Solution:
   */

  /**
   * 105.
   * Problem: Printing brackets in Matrix Chain Multiplication Problem.
   * Solution:
   */

  /**
   * 106.
   * Problem: Form coils in a matrix.
   * Solution:
   */

  /**
   * 107.
   * Problem: Find number of transformation to make two Matrix Equal.
   * Solution:
   */

  /**
   * 108.
   * Problem: Sparse Matrix and its representations | Set 2 (Using List of Lists and Dictionary of keys).
   * Solution:
   */

  /**
   * 109.
   * Problem: Sum of matrix element where each elements is integer division of row and column.
   * Solution:
   */

  /**
   * 110.
   * Problem: Distance of nearest cell having 1 in a binary matrix.
   * Solution:
   */

  /**
   * 111.
   * Problem: Find whether there is path between two cells in matrix.
   * Solution:
   */

  /**
   * 112.
   * Problem: Maximum path sum that starting with any cell of 0-th row  and ending with any cell of (N-1)-th row.
   * Solution:
   */

  /**
   * 113.
   * Problem: Print a matrix in alternate manner (left to right then right to left).
   * Solution:
   */

  /**
   * 114.
   * Problem: Maximize sum of N X N upper left sub-matrix from given  2N X 2N matrix.
   * Solution:
   */

  /**
   * 115.
   * Problem: Finding the maximum square sub-matrix with all equal elements.
   * Solution:
   */

  /**
   * 116.
   * Problem: Minimum operations required to set all elements of binary matrix.
   * Solution:
   */

  /**
   * 117.
   * Problem: Sort a Matrix in all way increasing order.
   * Solution:
   */

  /**
   * 118.
   * Problem: Easy way to remember Strassen’s Matrix Equation.
   * Solution:
   */

  /**
   * 119.
   * Problem: Gold Mine Problem.
   * Solution:
   */

  /**
   * 120.
   * Problem: Program to find  Normal and Trace of a matrix.
   * Solution:
   */

  /**
   * 121.
   * Problem: C Program To Check whether Matrix is Skew Symmetric or not.
   * Solution:
   */

  /**
   * 122.
   * Problem: Print matrix in antispiral form.
   * Solution:
   */

  /**
   * 123.
   * Problem: Maximum and Minimum in a square matrix..
   * Solution:
   */

  /**
   * 124.
   * Problem: Rotate a matrix by 90 degree without using any extra space | Set 2.
   * Solution:
   */

  /**
   * 125.
   * Problem: Number of decisions to reach destination.
   * Solution:
   */

  /**
   * 126.
   * Problem: Maximum sum of hour glass in matrix.
   * Solution:
   */

  /**
   * 127.
   * Problem: Number of pair of positions in matrix which are not accessible.
   * Solution:
   */

  /**
   * 128.
   * Problem: Program for Conway&#8217;s Game Of Life.
   * Solution:
   */

  /**
   * 129.
   * Problem: Program for Sudoku Generator.
   * Solution:
   */

  /**
   * 130.
   * Problem: Find number of endless points.
   * Solution:
   */

  /**
   * 131.
   * Problem: Circular Matrix (Construct a matrix with numbers 1 to m*n in spiral way).
   * Solution:
   */

  /**
   * 132.
   * Problem: Largest sum Zigzag sequence in a matrix.
   * Solution:
   */

  /**
   * 133.
   * Problem: Find difference between sums of two diagonals.
   * Given a matrix of n X n. The task is to calculate the absolute difference between the sums of its diagonal.
   * Solution:
   */
  int diagnalsDiff(int[][] mat) {
    return Math.abs(diagnalSum(mat, 0, 0) - antiDiagnalSum(mat, 0, mat[0].length - 1, 0));
  }
  private int diagnalSum(int[][] mat, int x, int sum) {
    if (x == mat.length - 1) return sum + mat[x][x];
    else return diagnalSum(mat, x + 1, sum + mat[x][x]);
  }
  private int antiDiagnalSum(int[][] mat, int x, int y, int sum) {
    if (x == mat.length - 1 && y == 0) return sum + mat[mat.length - 1][0];
    else return antiDiagnalSum(mat, x + 1, y - 1, sum + mat[x][y]);
  }

  /**
   * 134.
   * Problem: Search element in a sorted matrix.
   * Solution:
   */

  /**
   * 135.
   * Problem: Find a peak element in a 2D array.
   * Solution:
   */

  /**
   * 136.
   * Problem: Find distinct elements common to all rows of a matrix.
   * Solution:
   */

  /**
   * 137.
   * Problem: Maximum sum in a 2 x n grid such that no two elements are adjacent.
   * Solution:
   */

  /**
   * 138.
   * Problem: Print a given matrix in reverse spiral form.
   * Solution:
   */

  /**
   * 139.
   * Problem: Program to print Lower triangular and Upper triangular matrix of an array.
   * Solution:
   */



  /**
   * 1.
   * Problem: Search in a row wise and column wise sorted matrix.
   * Given an n x n matrix, where every row and column is sorted in increasing order. Given a number x, how to
   * decide whether this x is in the matrix. The designed algorithm should have linear time complexity.
   * Solution: Start from top right corner. To get smaller element move left and for bigger elements go down.
   */

  /**
   * 2.
   * Problem: Print a given matrix in spiral form.
   * Solution: Use 4 for loops.
   */
  void spiralPrint(int[][] matrix) {
    int startRow = 0, endRow = matrix.length-1, startColumn = 0, endColumn = matrix[0].length-1;

    while (startRow < endRow && startColumn < endColumn) {
      for (int i = startColumn; i < endColumn; i++) System.out.print(matrix[startRow][i]);
      startRow++;
      for (int i = startRow; i < endRow; i++) System.out.print(matrix[i][endColumn]);
      endColumn--;
      if (startRow < endRow) {
        for (int i = endColumn; i >= startColumn; i--) System.out.print(matrix[endRow][i]);
        endRow--;
      }
      if (startColumn < endColumn) {
        for (int i = endRow; i >= startRow; i--) System.out.print(matrix[i][startColumn]);
        startColumn++;
      }
    }

  }


  /**
   * 3.
   * Problem: A Boolean Matrix Question.
   * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true)
   * then make all the cells of ith row and jth column as 1.
   * Solution: Either use auxiliary matrix and two hashsets for row and column or to save space use first col and row
   * as hashsets.
   */

  /**
   * 4.
   * Problem: Print unique rows in a given boolean matrix.
   * Given a binary matrix, print all unique rows of the given matrix.
   * Solution:
   * 1.Use Binary Search Tree.
   *      Find the decimal equivalent of each row and insert it into BST. Each node of the BST will contain two
   *      fields, one field for the decimal value, other for row number. Do not insert a node if it is duplicated.
   *      Finally, traverse the BST and print the corresponding rows.
   * 2. Use Trie data structure.
   *      Since the matrix is boolean, a variant of Trie data structure can be used where each node will be having
   *      two children one for 0 and other for 1. Insert each row in the Trie. If the row is already there, don’t
   *      print the row. If row is not there in Trie, insert it in Trie and print it.
   */

  /**
   * 7.
   * Problem: Print Matrix Diagonally.
   * Given a 2D matrix, print all elements of the given matrix in diagonal order.
   */
  void printDiagonal(int[][] matrix) {
    int rows = matrix.length;
    int columns = matrix[0].length;
    for (int line = 1; line <= rows + columns + 1; line++) {
      int startColumn = Math.max(0,line - rows);
      int count = Math.min(line,Math.min(columns-startColumn,rows));
      for (int i = 0; i < count; i++) System.out.print(matrix[Math.min(rows,line)-i-1][startColumn+i]);
      System.out.println("");
    }
  }

  /**
   * Problem: Rotate Matrix Elements.
   * Given a matrix, clockwise rotate elements in it.
   *
   * Solution: Code is similar to printing matrix in spiral form.
   */

  /**
   * Problem: Collect maximum coins before hitting a dead end
   Given a character matrix where every cell has one of the following values.

   'C' -->  This cell has coin

   '#' -->  This cell is a blocking cell.
   We can not go anywhere from this.

   'E' -->  This cell is empty. We don't get
   a coin, but we can move from here.
   Initial position is cell (0, 0) and initial direction is right.

   Following are rules for movements across cells.

   If face is Right, then we can move to below cells

   1. Move one step ahead, i.e., cell (i, j+1) and direction remains right.
   2. Move one step down and face left, i.e., cell (i+1, j) and direction becomes left.
   If face is Left, then we can move to below cells

   1. Move one step ahead, i.e., cell (i, j-1) and direction remains left.
   2. Move one step down and face right, i.e., cell (i+1, j) and direction becomes right.
   Final position can be anywhere and final direction can also be anything. The target is to collect maximum coins.
   */
  int R = 5;
  int C = 5;
  int maxCoinsRec(char[][] arr,  int i, int j, int dir) {
    if (!isValid(i,j) || arr[i][j] == '#') return 0;

    int result = (arr[i][j] == 'C')? 1: 0;

    if (dir == 1) return result + Math.max(maxCoinsRec(arr, i+1, j, 0), maxCoinsRec(arr, i, j+1, 1));

    return  result + Math.max(maxCoinsRec(arr, i+1, j, 1), maxCoinsRec(arr, i, j-1, 0));
  }

  boolean isValid(int i, int j) {
    return (i >=0 && i < R && j >=0 && j < C);
  }

  /**
   * 8.
   * Problem: Dynamic Programming | Set 27 (Maximum sum rectangle in a 2D matrix)
   */

  /**
   * 9.
   * Problem: Strassen’s Matrix Multiplication

   */

  /**
   * 10.
   * Problem: Create a matrix with alternating rectangles of O and X

   */


  /**
   * 11.
   * Problem: Find the row with maximum number of 1s

   */





  /**
   * 12.
   * Problem: Print all elements in sorted order from row and column wise sorted matrix

   */



  /**
   * 13.
   * Problem: Given an n x n square matrix, find sum of all sub-squares of size k x k

   */

  /**
   * 14.
   * Problem: Count number of islands where every island is row-wise and column-wise separated

   */

  /**
   * 15.
   * Problem: Given a matrix of ‘O’ and ‘X’, replace ‘O’ with ‘X’ if surrounded by ‘X’

   */

  /**
   * 16.
   * Problem: Find the longest path in a matrix with given constraints

   */


  /**
   * 17.
   * Problem: Given a Boolean Matrix, find k such that all elements in k’th row are 0 and k’th column are 1.

   */





  /**
   * 18.
   * Problem: Find the largest rectangle of 1’s with swapping of columns allowed

   */



  /**
   * 19.
   * Problem: Validity of a given Tic-Tac-Toe board configuration

   */

  /**
   * 20.
   * Problem: Minimum Initial Points to Reach Destination

   */

  /**
   * 21.
   * Problem: Find length of the longest consecutive path from a given starting character

   */

  /**
   * 22.
   * Problem: Collect maximum points in a grid using two traversals

   */


  /**
   * 23.
   * Problem: Rotate Matrix Elements

   */





  /**
   * 24.
   * Problem: Find sum of all elements in a matrix except the elements in row and/or column of given cell?

   */



  /**
   * 25.
   * Problem: Find a common element in all rows of a given row-wise sorted matrix

   */




  /**
   * 27.
   * Problem: Collect maximum coins before hitting a dead end
   */

  /**
   * 28.
   * Problem: Program for Rank of Matrix

   */


  /**
   * 29.
   * Problem: Submatrix Sum Queries

   */





  /**
   * 30.
   * Problem: Maximum size rectangle binary sub-matrix with all 1s
   * Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
   * Input :
   * 0 1 1 0
   * 1 1 1 1
   * 1 1 1 1
   * 1 1 0 0
   * Output :
   * 1 1 1 1
   * 1 1 1 1
   * Solution. The idea is to update each column of a given row with corresponding column of previous row and find
   * largest histogram area for for that row.
   * Step 1: Find maximum area for row[0]
   * Step 2:
   * for each row in 1 to N - 1
   * for each column in that row
   * if A[row][column] == 1
   * update A[row][column] with
   * A[row][column] += A[row - 1][column]
   * find area for that row
   * and update maximum area so far
   */
  int largestRect(int[][] mat) {
   int maxArea = new StackExamples().maxRectangleArea(Arrays.copyOf(mat[0], mat[0].length));
    for (int i = 1; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) if (mat[i][j] == 1) mat[i][j] += mat[i - 1][j];
      maxArea = Math.max(maxArea, new StackExamples().maxRectangleArea(Arrays.copyOf(mat[i], mat[i].length)));
    }
    return maxArea;
  }




  /**
   * 31.
   * Problem: Count Negative Numbers in a Column-Wise and Row-Wise Sorted Matrix

   */

  /**
   * 32.
   * Problem: Construct Ancestor Matrix from a Given Binary Tree

   */





  /**
   * 33.
   * Problem: Construct tree from ancestor matrix

   */

  /**
   * 34.
   * Problem: In-place convert matrix in specific order

   */


  /**
   * 35.
   * Problem: Common elements in all rows of a given matrix

   */





  /**
   * 36.
   * Problem: Print maximum sum square sub-matrix of given size

   */



  /**
   * 37.
   * Problem: Find a specific pair in Matrix

   */

  /**
   * 38.
   * Problem: Find orientation of a pattern in a matrix

   */





  /**
   * 39.
   * Problem: Shortest path in a Binary Maze
   * Given a MxN matrix where each element can either be 0 or 1. We need to find the shortest path between a given
   * source cell to a destination cell. The path can only be created out of a cell if its value is 1.
   */
  int shortesPathInMaze(int[][] maze, int[] dest, int x, int y, int count, int[][] moves, boolean[][] visited) {
    if (x == dest[0] && y == dest[1]) return count;
    else {
      int shortestPath = Integer.MAX_VALUE;
      if (!isValid(maze, x, y, visited)) {
        visited[x][y] = true;
        for (int[] move : moves) {
          shortestPath = Math.min(shortestPath,
                  shortesPathInMaze(maze, dest, x + move[0], y + move[1], count + 1, moves, visited));
        }
        return shortestPath;
      }
    }
    return 0;
  }
  private boolean isValid(int[][] mat, int x, int y, boolean[][] visited) {
    return x >= 0 && x < mat.length && y >=0 && y < mat[0].length && mat[x][y] == 1 && !visited[x][y];
  }

  /**
   * 40.
   * Problem: Inplace rotate square matrix by 90 degrees

   */


  /**
   * 41.
   * Problem: Return previous element in an expanding matrix

   */

  void gvGenerator(String gv) {
    ArrayList<String> choices = new ArrayList<>();
    for (int i = 65; i < 91; i++) choices.add(Character.toString((char) i));
//    for (int i = 0; i < 10; i++) choices.add(Integer.toString(i));
    permute(gv, "", 4, choices);
  }
  private void permute(String gv, String sofar, int k, ArrayList<String> choices) {
    if (k == 0) System.out.println(gv + sofar);
    else {
      for (int i = 0; i < choices.size(); i++) {
        permute(gv, sofar + choices.get(i), k - 1, choices);
      }
    }
  }
}
