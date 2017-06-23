package data.structures.matrix;

public class MatrixExamples {

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
   * 26.
   * Problem: Number of paths with exactly k coins

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

   */



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
