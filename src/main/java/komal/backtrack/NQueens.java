package komal.backtrack;

public class NQueens {

    public static int N =4;
    public static boolean solveNQueensProblem(int[][] board, int col){
        if(col>=N)
            return true;
        for(int i =0; i< N; i++){
            if(isSafe(board,i,col)){
                board[i][col] =1;
                if(solveNQueensProblem(board,col+1)==true)
                    return true;

                board[i][col] = 0;
            }
        }
        return false;

    }

    private static boolean isSafe(int[][]board, int row, int col){

        for(int i =0; i<col ;i++){
            if(board[row][i] == 1)
                return false;
        }

        int j,i;
        for ( i = row, j = col; i>=0&&j>=0; i--,j--){
            if(board[i][j] == 1)
                return false;
        }
        for ( i = row, j = col; i<N&&j>=0; i++,j--){
            if(board[i][j] == 1)
                return false;
        }
        return true;
    }
    public  static boolean solveNQ()
    {
        int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (solveNQueensProblem(board, 0) == false)
        {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }
   static void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        solveNQ();
    }
}
