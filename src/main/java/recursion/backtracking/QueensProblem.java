package recursion.backtracking;

class QueensProblem {

    boolean solve(int[][] board, int column, int n) {
        if (column >= n) {
            printBoard(board,n);
            return true;
        }
        else {
            for (int row = 0; row < n; row++) {
                if (isSafe(board,row,column,n)){
                    placeQueen(board,row,column);
                    if (solve(board,column + 1,n)) return true;
                    removeQueen(board,row,column);
                }
            }
            return false;
        }
    }

    private boolean isSafe(int[][] board, int row, int column, int n) {
        for(int i = 0; i < n; i++) if (board[row][i] == 1) return false;
        for(int i = 0; i < n; i++) if (board[i][column] == 1) return false;
        for(int i = 0; i < n; i++) {
            if (row + i < n && column + i < n)
            if (board[row + i][column + i] == 1) return false;
        }
        for(int i = 0; i < n; i++) {
            if (row - i >= 0 && column - i >= 0)
                if (board[row - i][column - i] == 1) return false;
        }
        for(int i = 0; i < n; i++) {
            if (row + i < n && column - i >= n)
                if (board[row + i][column - i] == 1) return false;
        }
        for(int i = 0; i < n; i++) {
            if (row - i >= 0 && column + i < n)
                if (board[row - i][column + i] == 1) return false;
        }
        return true;
    }

    private void placeQueen(int[][] board, int row, int column) { board[row][column] = 1; }

    private void removeQueen(int[][] board, int row, int column) { board[row][column] = 0; }

    private void printBoard(int[][] board, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) System.out.print(board[i][j]);
            System.out.println("");
        }
    }

}
