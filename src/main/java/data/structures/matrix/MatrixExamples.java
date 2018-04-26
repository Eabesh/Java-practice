package data.structures.matrix;

import algorithms.dynamic.programming.DPExamples;
import data.structures.stack.StackExamples;

import java.awt.*;
import java.io.PrintWriter;
import java.util.*;

public class MatrixExamples {

  /**
   * 1.
   * Problem: Maximum size square sub-matrix with all 1s.
   */
  int[][] maxSizeSubMatrix(int[][] mat, int[][] dp) {
    return new DPExamples().maxSizeSquareMat(mat, dp);
  }


  /**
   * 2.
   * Problem: Turn an image by 90 degree.
   */
  void turnBy90(int[][] mat) {
    int[][] rotatedMat = new int[mat[0].length][mat.length];
    turnBy90(mat, rotatedMat);

  }

  private void turnBy90(int[][] mat, int[][] rotatedMat) {
    for (int i = 0; i < mat.length; i++)
      for (int j = 0; j < mat[0].length; j++) {
        rotatedMat[j][rotatedMat[0].length - 1 - i] = mat[i][j];
      }

    for (int i = 0; i < rotatedMat.length; i++) {
      for (int j = 0; j < rotatedMat[0].length; j++) System.out.print(rotatedMat[i][j] + " ");
      System.out.println();
    }
  }

  /**
   * 3.
   * Problem: Search in a row wise and column wise sorted matrix.
   * Solution:1) Start with top right element
   * 2) Loop: compare this element e with x
   * ….i) if they are equal then return its position
   * …ii) e < x then move it to down (if out of bound of matrix then break return false) ..iii) e > x then move it to left (if out of bound of matrix then break return false)
   * 3) repeat the i), ii) and iii) till you find element or returned false
   */

  void searchInMat(int[][] mat, int x) {
    int i = 0, j = mat[0].length - 1;

    while (i < mat.length  && j >= 0) {
      if (mat[i][j] == x) {
        System.out.println("Found At " + i + " " + j);
        return;
      } else if (mat[i][j] > x) j--;
      else i++;
    }
    System.out.println("Element not Found");
  }

   boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) return false;
    int i = 0, j = matrix[0].length - 1;
    while(i < matrix.length && j >= 0) {
      if (matrix[i][j] == target) return true;
      else if (matrix[i][j] > target) j--;
      else i++;
    }
    return false;
  }


  /**
   * 4.
   * Problem: Print a given matrix in spiral form.
   */
  void spiralPrint(int[][] matrix) {
    int startRow = 0, endRow = matrix.length - 1, startColumn = 0, endColumn = matrix[0].length - 1;

    while (startRow <= endRow && startColumn <= endColumn) {
      for (int i = startColumn; i <= endColumn; i++) System.out.print(matrix[startRow][i]);
      startRow++;
      for (int i = startRow; i <= endRow; i++) System.out.print(matrix[i][endColumn]);
      endColumn--;
      if (startRow <= endRow) {
        for (int i = endColumn; i >= startColumn; i--) System.out.print(matrix[endRow][i]);
        endRow--;
      }
      if (startColumn <= endColumn) {
        for (int i = endRow; i >= startRow; i--) System.out.print(matrix[i][startColumn]);
        startColumn++;
      }
    }
  }


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
   * Solution: For example
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
  public int countIslands(int[][] mat) {
    int islandsCount = 0;
    boolean[][] isVisited = new boolean[mat.length][mat[0].length];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 1 && !isVisited[i][j]) {
          dfs(mat, i, j, isVisited);
          islandsCount++;
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
    return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && mat[x][y] == 1 && !isVisited[x][y];
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
   */
  public    void
  printAllPaths(int[][] mat, String path, int x, int y) {

    if (x == mat.length - 1 && y == mat[0].length - 1)
      System.out.println(path + mat[mat.length - 1][mat[0].length - 1]);
    else {
      if (isValidMove(mat, x, y)) {
        printAllPaths(mat, path + mat[x][y], x + 1, y);
        printAllPaths(mat, path + mat[x][y], x, y + 1);
      }
    }
  }


  private boolean isValidMove(int[][] mat, int x, int y) {
    return x < mat.length && y < mat[0].length && mat[x][y] != -1;
  }
  /**
   * 16.
   * Problem: Count all possible paths from top left to bottom right of a mXn matrix.
   * Solution:
   */
  int countPaths(int[][] mat, int x, int y) {
    if (x == 0 && y == 0) return 1;
    else if (x < 0 || y < 0) return 0;
    else return countPaths(mat, x - 1, y) + countPaths(mat, x, y - 1);
  }

  /**
   * 17.
   * Problem: Kth smallest element in a row-wise and column-wise sorted 2D array | Set 1.
   * Solution: Use Priority Queue
   *
   * To find the Kth largest element use max heap, 2) all last column 3) replace element with its row element.
   */
  class ElementWithPos{
    int data, i, j;

    public ElementWithPos(int data, int i, int j) {
      this.data = data;
      this.i = i;
      this.j = j;
    }

    public int getData() {
      return data;
    }

    public int getI() {
      return i;
    }

    public int getJ() {
      return j;
    }
  }

  int kSmallest(int[][] mat, int k) {
    PriorityQueue<ElementWithPos> minHeap = new PriorityQueue<>(Comparator.comparingInt(ElementWithPos::getData));

    for (int i = 0; i < mat.length; i++) minHeap.add(new ElementWithPos(mat[0][i], 0, i));
    for (int j = 1; j < k ; j++) {
      ElementWithPos min = minHeap.poll();
      minHeap.add(new ElementWithPos(mat[min.getI() + 1][min.getJ()], min.getI() + 1, min.getJ()));
    }
    return minHeap.poll().getData();
  }

  int kLargest(int[][] mat, int k) {
    PriorityQueue<ElementWithPos> maxHeap = new PriorityQueue<>((ElementWithPos e1, ElementWithPos e2) -> e2.getData() - e1.getData());
    for (int j = 0; j < mat[0].length; j++) maxHeap.add(new ElementWithPos(mat[j][mat[0].length -1], j, mat[0].length - 1));
    for (int i = 1; i <k; i++) {
      ElementWithPos max = maxHeap.poll();
      int x = max.getI(), y = max.getJ() - 1;
      maxHeap.add(new ElementWithPos(mat[x][y], x, y));
    }
    return maxHeap.poll().getData();
  }

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
   * Problem: Program to find transpose of a matrix (Square Matrix).
   */
  void transpose(int A[][])
  {
    for (int i = 0; i < A.length; i++)
      for (int j = i+1; j < A.length; j++)
      {
        int temp = A[i][j];
        A[i][j] = A[j][i];
        A[j][i] = temp;
      }
  }

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
              + countPathsKCoins(mat, x, y - 1, k - mat[x][y]);
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
   */
  void rotateSquareMat(int[][] mat, int n) {
    for (int i = 0; i < n / 2; i++) {
      for (int j = i; j < n - i - 1; j++) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][n - 1 - i];
        mat[j][n - 1 - i] = mat[n - 1 - i][n - 1 - j];
        mat[n - 1 - i][n - 1 - j] = mat[n - 1 - j][i];
        mat[n - 1 - j][i] = temp;

      }
    }
  }

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
//  boolean isTherePath(int[][] mat, int i, int j) {
//    if (mat[i][j] == 2) return true;
//    else if (i < 0 || i > mat.length || j < 0 || j > mat[0].length) return false;
//    else if (mat[i][j] == 3)
//      return isTherePath(mat, i - 1, j) ||  isTherePath(mat, i + 1, j) ||  isTherePath(mat, i , j - 1) ||  isTherePath(mat, i , j + 1);
//  }



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
   * Solution: The idea is simple, we traverse matrix in spiral form and put all traversed elements in a stack. Finally
   * one by one elements from stack and print them.
   */
  void printAntiSpiral(int[][] mat) {
    Stack<Integer> stack = new Stack<>();
    printAntiSpiral(mat, stack);
  }

  private void printAntiSpiral(int[][] mat, Stack<Integer> stack) {
    int startRow = 0, endRow = mat[0].length - 1, startColumn = 0, endColumn = mat.length - 1;
    while (startRow < endRow && startColumn < endColumn) {
      for (int i = startColumn; i <= endColumn; i++) stack.push(mat[startRow][i]);
      startRow++;
      for (int i = startRow; i < endRow; i++) stack.push(mat[i][endColumn]);
      endColumn--;

      if (startRow < endRow) {
        for (int i = endColumn; i >= startColumn; i--) stack.push(mat[endRow][i]);
        endRow--;
      }

      if (startColumn < endColumn) {
        for (int i = endRow; i >= startRow; i--) stack.push(mat[i][startColumn]);
        startColumn++;
      }
    }
  }

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
   * 140.
   * Problem: Matrix Multiplication | Recursive.
   * Solution:
   */

  /**
   * 141.
   * Problem: Number of cells a queen can move with obstacles on the chessborad.
   * Solution:
   */

  /**
   * 142.
   * Problem: Magic Square | Even Order.
   * Solution:
   */

  /**
   * 143.
   * Problem: Maximize matrix as per given condition.
   * Solution:
   */

  /**
   * 144.
   * Problem: Program to Interchange Diagonals of Matrix.
   * Solution:
   */

  /**
   * 145.
   * Problem: Find median in row wise sorted matrix.
   * Solution:
   */

  /**
   * 146.
   * Problem: Discrete Cosine Transform (Algorithm and Program).
   * Solution:
   */

  /**
   * 147.
   * Problem: Maximum path sum in matrix.
   * Solution:
   */

  /**
   * 148.
   * Problem: Print a given matrix in zigzag form.
   * Solution:
   */

  /**
   * 149.
   * Problem: Matrix manipulation in Python.
   * Solution:
   */

  /**
   * 150.
   * Problem: Print matrix in snake pattern.
   * Solution:
   */

  /**
   * 151.
   * Problem: Construct a linked list from 2D matrix.
   * Solution:
   */

  /**
   * 152.
   * Problem: Print a matrix in a spiral form starting from a point.
   * Solution:
   */

  /**
   * 153.
   * Problem: Boundary elements of a Matrix.
   * Solution:
   */

  /**
   * 154.
   * Problem: Efficiently compute sums of diagonals of a matrix.
   * Solution:
   */

  /**
   * 155.
   * Problem: Largest rectangular sub-matrix whose sum is 0.
   * Solution:
   */

  /**
   * 156.
   * Problem: Unique paths in a Grid with Obstacles.
   * Solution:
   */

  /**
   * 157.
   * Problem: Minimum cells traversed to reach corner where every cell represents jumps.
   * Solution:
   */

  /**
   * 158.
   * Problem: Find if a 2-D array is completely traversed or not by following the cell values.
   * Solution:
   */

  /**
   * 159.
   * Problem: Find duplicate rows in a binary matrix.
   * Solution:
   */

  /**
   * 160.
   * Problem: Program to check if a matrix is symmetric.
   * Solution:
   */

  /**
   * 161.
   * Problem: Check if a grid can become row-wise and column-wise sorted after adjacent swaps.
   * Solution:
   */

  /**
   * 162.
   * Problem: Best meeting point in 2D binary array.
   * Solution:
   */

  /**
   * 163.
   * Problem: Find row number of a binary matrix having maximum number of 1s.
   * Solution:
   */

  /**
   * 164.
   * Problem: Check if sums of i-th row and i-th column are same in matrix.
   * Solution:
   */

  /**
   * 165.
   * Problem: Possible moves of knight.
   * Solution:
   */

  /**
   * 166.
   * Problem: Print all palindromic paths from top left to bottom right in a matrix.
   * Solution:
   */

  /**
   * 167.
   * Problem: Maximize the binary matrix by filpping submatrix once.
   * Solution:
   */

  /**
   * 168.
   * Problem: Largest area rectangular sub-matrix with equal number of 1&#8217;s and 0&#8217;s.
   * Solution:
   */

  /**
   * 169.
   * Problem: Program to Print Matrix in Z form.
   * Solution:
   */

  /**
   * 170.
   * Problem: Maximum points from top left of matrix to bottom right and return back.
   * Solution:
   */

  /**
   * 171.
   * Problem: Minimum cells required to reach destination with jumps equal to cell values.
   * Solution:
   */

  /**
   * 172.
   * Problem: Row-wise common elements in two diagonals of a square matrix.
   * Solution:
   */

  /**
   * 173.
   * Problem: Longest Increasing Path in Matrix.
   * Solution:
   */

  /**
   * 174.
   * Problem: Check if a given matrix is sparse or not.
   * Solution:
   */

  /**
   * 175.
   * Problem: Count entries equal to x in a special matrix.
   * Solution:
   */

  /**
   * 176.
   * Problem: Unique cells in a binary matrix.
   * Solution:
   */

  /**
   * 177.
   * Problem: Minimum cost to convert 3 X 3 matrix into magic square.
   * Solution:
   */

  /**
   * 178.
   * Problem: Shortest distance between two cells in a matrix or grid.
   * Solution:
   */

  /**
   * 179.
   * Problem: Doolittle Algorithm : LU Decomposition.
   * Solution:
   */

  /**
   * 180.
   * Problem: Cholesky Decomposition : Matrix Decomposition.
   * Solution:
   */

  /**
   * 181.
   * Problem: Mean and Median of a matrix.
   * Solution:
   */

  /**
   * 182.
   * Problem: Counting sets of 1s and 0s in a binary matrix.
   * Solution:
   */

  /**
   * 183.
   * Problem: Minimum cost to sort a matrix of numbers from 0 to n^2 &#8211; 1.
   * Solution:
   */

  /**
   * 184.
   * Problem: Conway&#8217;s Game Of Life (Python Implementation).
   * Solution:
   */

  /**
   * 185.
   * Problem: Sum 2D array in Python using map() function.
   * Solution:
   */

  /**
   * 186.
   * Problem: Multiplication of two Matrices in Single line using Numpy in Python.
   * Solution:
   */

  /**
   * 187.
   * Problem: Python program to add two Matrices.
   * Solution:
   */

  /**
   * 188.
   * Problem: Minimum sum submatrix in a given 2D array.
   * Solution:
   */

  /**
   * 189.
   * Problem: Count all 0s which are blocked by 1s in binary matrix.
   * Solution:
   */

  /**
   * 190.
   * Problem: heapq in Python to print all elements in sorted order from row and column wise sorted matrix.
   * Solution:
   */

  /**
   * 191.
   * Problem: Find all rectangles filled with 0.
   * Solution:
   */

  /**
   * 192.
   * Problem: Rotate a Matrix by 180 degree.
   * Solution:
   */

  /**
   * 193.
   * Problem: Print all n digit patterns formed by mobile Keypad.
   * Solution:
   */

  /**
   * 194.
   * Problem: Find if there is a rectangle in binary matrix with corners as 1.
   * Solution:
   */

  /**
   * 195.
   * Problem: Number of days until all chocolates become unhealthy.
   * Solution:
   */

  /**
   * 196.
   * Problem: Printing string in plus ‘+’ pattern in the matrix.
   * Solution:
   */

  /**
   * 197.
   * Problem: Python program to multiply two matrices.
   * Solution:
   */

  /**
   * 198.
   * Problem: Mirror of matrix across diagonal.
   * Solution:
   */

  /**
   * 199.
   * Problem: Ways of filling matrix such that product of all rows and all columns are equal to unity.
   * Solution:
   */

  /**
   * 200.
   * Problem: Program to swap upper diagonal elements with lower diagonal elements of matrix..
   * Solution:
   */

  /**
   * 201.
   * Problem: Minimum jumps to reach last building in a matrix.
   * Solution:
   */

  /**
   * 202.
   * Problem: Number of elements greater than modified mean in matrix.
   * Solution:
   */

  /**
   * 203.
   * Problem: Program for Identity Matrix.
   * Solution:
   */

  /**
   * 204.
   * Problem: Frequencies of even and odd numbers in a matrix.
   * Solution:
   */

  /**
   * 205.
   * Problem: Maximum sum path in a matrix from top to bottom.
   * Solution:
   */

  /**
   * 206.
   * Problem: Find trace of matrix formed by adding Row-major and Column-major order of same matrix.
   * Solution:
   */

  /**
   * 207.
   * Problem: Check if possible to cross the matrix with given power.
   * Solution:
   */

  /**
   * 208.
   * Problem: Program to check if matrix is upper triangular.
   * Solution:
   */

  /**
   * 209.
   * Problem: Count of possible hexagonal walks.
   * Solution:
   */

  /**
   * 210.
   * Problem: Program to check if matrix is lower triangular.
   * Solution:
   */

  /**
   * 211.
   * Problem: Pascal Matrix.
   * Solution:
   */

  /**
   * 212.
   * Problem: Maximum product of 4 adjacent elements in matrix.
   * Solution:
   */

  /**
   * 213.
   * Problem: Minimum flip required to make Binary Matrix symmetric.
   * Solution:
   */

  /**
   * 214.
   * Problem: Multiplication of Matrix using pthreads.
   * Solution:
   */

  /**
   * 215.
   * Problem: Count sub-matrices having sum divisible &#8216;k&#8217;.
   * Solution:
   */

  /**
   * 216.
   * Problem: Diagonally Dominant Matrix.
   * Solution:
   */

  /**
   * 217.
   * Problem: Minimum operations required to make each row and column of matrix equals.
   * Solution:
   */

  /**
   * 218.
   * Problem: Python map function to find row with maximum number of 1&#8217;s.
   * Solution:
   */

  /**
   * 219.
   * Problem: Find the Surface area of a 3D figure.
   * Solution:
   */

  /**
   * 220.
   * Problem: Python | Print unique rows in a given boolean matrix using Set with tuples.
   * Solution:
   */

  /**
   * 221.
   * Problem: Python heapq to find K&#8217;th smallest element in a 2D array.
   * Solution:
   */

  /**
   * 222.
   * Problem: Python List Equality | Program to check if two given matrices are identical.
   * Solution:
   */

  /**
   * 223.
   * Problem: Python Counter| Find duplicate rows in a binary matrix.
   * Solution:
   */

  /**
   * 224.
   * Problem: Largest rectangular sub-matrix having sum divisible by k.
   * Solution:
   */

  /**
   * 225.
   * Problem: Sparse Matrix Representations | Set 3 ( CSR ).
   * Solution:
   */

  /**
   * 226.
   * Problem: Kronecker Product of two matrices.
   * Solution:
   */

  /**
   * 227.
   * Problem: Operating System | Banker&#8217;s Algorithm : Print all the safe state (or safe sequences).
   * Solution:
   */

  /**
   * 228.
   * Problem: Given 1&#8217;s, 2&#8217;s, 3&#8217;s &#8230;&#8230;k&#8217;s print them in zig zag way..
   * Solution:
   */

  /**
   * 229.
   * Problem: Count frequency of k in a matrix of size n where matrix(i, j) = i+j.
   * Solution:
   */

  /**
   * 230.
   * Problem: A square matrix as sum of symmetric and skew-symmetric matrices.
   * Solution:
   */

  /**
   * 231.
   * Problem: Program to check diagonal matrix and scalar matrix.
   * Solution:
   */

  /**
   * 232.
   * Problem: Addition and Subtraction of Matrix using pthreads.
   * Solution:
   */

  /**
   * 233.
   * Problem: Check for possible path in 2D matrix.
   * Solution:
   */

  /**
   * 234.
   * Problem: Count of number of given string in 2D character array.
   * Solution:
   */

  /**
   * 235.
   * Problem: Program for Markov matrix.
   * Solution:
   */

  /**
   * 236.
   * Problem: Row wise sorting in 2D array.
   * Solution:
   */

  /**
   * 237.
   * Problem: Count elements smaller than or equal to x in a sorted matrix.
   * Solution:
   */



  /**
   * 238.
   * Problem: Print matrix in zag-zag fashion.
   * Solution:
   */

  /**
   * 239.
   * Problem: Maximum sum of elements from each row in the matrix.
   * Solution:
   */

  /**
   * 240.
   * Problem: Removing row or column wise duplicates from matrix of characters.
   * Solution:
   */

  /**
   * 241.
   * Problem: Sort the given matrix.
   * Solution:
   */

  /**
   * 242.
   * Problem: Interchange elements of first and last rows in matrix.
   * Solution:
   */

  /**
   * 243.
   * Problem: Sort the matrix row-wise and column-wise.
   * Solution:
   */

  /**
   * 244.
   * Problem: Count pairs from two sorted matrices with given sum.
   * Solution:
   */

  /**
   * 245.
   * Problem: Program to check idempotent matrix.
   * Solution:
   */

  /**
   * 246.
   * Problem: Program to check Involutory Matrix.
   * Solution:
   */

  /**
   * 247.
   * Problem: Print a matrix in Reverse Wave Form.
   * Solution:
   */



//Given MxN matrix, which contains 1s and 0s only. Redraw the matrix so that, if any one position [i,j] contains 1, mark the entire row and column with 1. But make sure because of newly marked 1s, don’t do the same

  void redrawMatrix(int[][] mat) {
    HashSet<Integer> rows = new HashSet<>(), cols = new HashSet<>();
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 1) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    for (int i = 0; i < mat.length; i++)
      for (int j = 0; j < mat[0].length; j++)
        if (rows.contains(i) || rows.contains(j)) mat[i][j] = 1;

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) System.out.print(mat[i][j] + " ");
      System.out.println();
    }
  }

  int[][] getMatrix(int row, int col, PrintWriter writer) {
    int[][] mat = new int[row][col];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        mat[i][j] = (int) Math.round(Math.random());
      }
    }

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        System.out.print(mat[i][j] + " ");
        writer.print(mat[i][j] + " ");
      }
      System.out.println();
      writer.println();
    }
    return mat;
  }
















































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
      int startColumn = Math.max(0, line - rows);
      int count = Math.min(line, Math.min(columns - startColumn, rows));
      for (int i = 0; i < count; i++) System.out.print(matrix[Math.min(rows, line) - i - 1][startColumn + i]);
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
   * Given a character matrix where every cell has one of the following values.
   * <p>
   * 'C' -->  This cell has coin
   * <p>
   * '#' -->  This cell is a blocking cell.
   * We can not go anywhere from this.
   * <p>
   * 'E' -->  This cell is empty. We don't get
   * a coin, but we can move from here.
   * Initial position is cell (0, 0) and initial direction is right.
   * <p>
   * Following are rules for movements across cells.
   * <p>
   * If face is Right, then we can move to below cells
   * <p>
   * 1. Move one step ahead, i.e., cell (i, j+1) and direction remains right.
   * 2. Move one step down and face left, i.e., cell (i+1, j) and direction becomes left.
   * If face is Left, then we can move to below cells
   * <p>
   * 1. Move one step ahead, i.e., cell (i, j-1) and direction remains left.
   * 2. Move one step down and face right, i.e., cell (i+1, j) and direction becomes right.
   * Final position can be anywhere and final direction can also be anything. The target is to collect maximum coins.
   */
  int R = 5;
  int C = 5;

  int maxCoinsRec(char[][] arr, int i, int j, int dir) {
    if (!isValid(i, j) || arr[i][j] == '#') return 0;

    int result = (arr[i][j] == 'C') ? 1 : 0;

    if (dir == 1) return result + Math.max(maxCoinsRec(arr, i + 1, j, 0), maxCoinsRec(arr, i, j + 1, 1));

    return result + Math.max(maxCoinsRec(arr, i + 1, j, 1), maxCoinsRec(arr, i, j - 1, 0));
  }

  boolean isValid(int i, int j) {
    return (i >= 0 && i < R && j >= 0 && j < C);
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


  /**
   * 40.
   * Problem: Inplace rotate square matrix by 90 degrees

   */


  /**
   * 41.
   * Problem: Return previous element in an expanding matrix

   */

}
