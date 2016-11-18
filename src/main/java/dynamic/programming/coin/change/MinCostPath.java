package dynamic.programming.coin.change;

public class MinCostPath {

    /** 4.
     * Problem: Given a cost matrix cost[][] and a position (m, n) in cost[][],
     * write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
     * Each cell of the matrix represents a cost to traverse through that cell.
     * Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination).
     * You can only traverse down, right and diagonally lower cells from a given cell, i.e.,
     * from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
     * You may assume that all costs are positive integers.
     *
     * Solution: minCost(m, n) = min (minCost(m-1, n-1), minCost(m-1, n), minCost(m, n-1)) + cost[m][n]
     */

    int minPath(int[][] mat, int x, int y) {
        if((x >= mat.length || y >= mat[0].length)) return Integer.MAX_VALUE;
        else if (x == mat.length - 1 && y == mat[0].length - 1) return mat[x][y];
        else return mat[x][y] + Math.min(minPath(mat, x + 1, y), Math.min(minPath(mat, x, y + 1),
                    minPath(mat, x + 1, y + 1)));
    }

    int minPathDP(int[][] mat) {
        int[][] minPath = new int[mat.length][mat[0].length];
        minPath[0][0] = mat[0][0];
        for (int i = 1; i < mat.length; i++) minPath[i][0] = minPath[i - 1][0] + mat[i][0] ;
        for (int i = 1; i < mat[0].length; i++) minPath[0][i] = minPath[0][i - 1] + mat[0][i];
        for (int i = 1; i < mat.length; i++)
            for (int j = 1; j < mat[0].length; j++)
                minPath[i][j] = mat[i][j] + Math.min(minPath[i - 1][j], Math.min(minPath[i][j - 1], minPath[i - 1][j - 1]));
        return minPath[mat.length - 1][mat[0].length - 1];
    }

}
