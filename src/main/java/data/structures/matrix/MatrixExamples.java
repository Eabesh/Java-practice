package data.structures.matrix;

public class MatrixExamples {

    /**
     * Problem: Search in a row wise and column wise sorted matrix.
     * Given an n x n matrix, where every row and column is sorted in increasing order. Given a number x, how to
     * decide whether this x is in the matrix. The designed algorithm should have linear time complexity.
     *
     * Solution: Start from top right corner. To get smaller element move left and for bigger elements go down.
     */

    /**
     * Print a given matrix in spiral form.
     *
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
     * Problem: A Boolean Matrix Question.
     * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true)
     * then make all the cells of ith row and jth column as 1.
     *
     * Solution: Either use auxiliary matrix and two hashsets for row and column or to save space use first col and row
     * as hashsets.
     */

}
