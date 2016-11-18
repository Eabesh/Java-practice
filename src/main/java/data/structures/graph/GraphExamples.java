package data.structures.graph;

class GraphExamples {

    /**
     *
     */

    /**
     * Given a matrix of 0's and 1's find the count of biggest area covered by adjacent 1's.
     * Hint: We can use DFS here.
     */
    int maxConnectedCell(int[][] grid) {

        int m = grid.length;
        int n = grid.length;
        boolean[][] isVisited = new boolean[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!isVisited[i][j] && grid[i][j] == 1)
                    max = Math.max(max, dfs(grid, i, j, isVisited));
            }
        }

        return max;
    }

    boolean isValidMove(int[][] grid, int x, int y, boolean[][] isVisited) {
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !isVisited[x][y]);
    }

    int dfs(int[][] grid, int x, int y, boolean[][] isVisited) {
        if (!isValidMove(grid, x, y, isVisited)) return 0;
        else {
            isVisited[x][y] = true;
            return 1 +
                    dfs(grid, x, y + 1, isVisited) +
                    dfs(grid, x, y - 1, isVisited) +
                    dfs(grid, x + 1, y, isVisited) +
                    dfs(grid, x - 1, y, isVisited) +
                    dfs(grid, x + 1, y + 1, isVisited) +
                    dfs(grid, x + 1, y - 1, isVisited) +
                    dfs(grid, x - 1, y + 1, isVisited) +
                    dfs(grid, x - 1, y - 1, isVisited);
        }
    }

}
