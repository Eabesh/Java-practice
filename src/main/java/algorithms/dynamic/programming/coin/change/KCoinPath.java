package algorithms.dynamic.programming.coin.change;

public class KCoinPath {

    /**
     * Problem: Number of paths with exactly k coins.
     * Given a matrix where every cell has some number of coins. Count number of ways to
     * reach bottom right from top left with exactly k coins. We can move to (i+1, j) and (i, j+1) from a cell (i, j).
     *
     * Solution:
     * pathCount(m, n, k):   Number of paths to reach mat[m][n] from mat[0][0] with exactly k coins.
     * If (m == 0 and n == 0)
     *      return 1 if mat[0][0] == k else return 0
     * Else:
     *      pathCount(m, n, k) = pathCount(m-1, n, k - mat[m][n]) + pathCount(m, n-1, k - mat[m][n])
     */

    int pathCountRec(int[][] mat, int m, int n, int k) {
        if (m < 0 || n < 0) return 0;
        if (m == 0 && n == 0) {
            if (k == mat[m][n]) return 1;
            else return 0;
        }

        return pathCountRec(mat, m-1, n, k-mat[m][n]) + pathCountRec(mat, m, n-1, k-mat[m][n]);
    }

    int m = 1000; int n = 1000; int k = 1000;
    int[][][] dp = new int[m][n][k];
    int pathCountDP(int[][] mat, int m, int n, int k) {
        if (m < 0 || n < 0) return 0;
        if (m == 0 && n == 0) {
            if (k == mat[m][n]) return 1;
            else return 0;
        }
        if (dp[m][n][k] != -1) return dp[m][n][k];
        else dp[m][n][k] = pathCountRec(mat, m-1, n, k-mat[m][n]) + pathCountRec(mat, m, n-1, k-mat[m][n]);
        return dp[m][n][k];
    }

}
