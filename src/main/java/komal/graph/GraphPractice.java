package komal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphPractice {

    static final int ROW = 5, COL = 5;

    public static int maxNoOfIslands(int[][] mat){
        boolean[][] visited = new boolean[ROW][COL];

        int count =0;
        for(int i = 0; i< ROW; i++){
            for (int j = 0;j<COL;j++){
                if(mat[i][j] == 1 && !visited[i][j]) {
                    DFS(mat, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void DFS(int[][] mat, int i, int j , boolean[][] visited){

        int[] rowsK = new int[] {-1,-1,-1,0,0,1,1,1};
        int[] colsK = new int[]{-1,0,1,-1,1,-1,0,1};

        visited[i][j] = true;

        for (int k =0; k<8;k++){
            if(isSafe(mat, i+rowsK[k],j+colsK[k],visited))
                DFS(mat, i+rowsK[k],j+colsK[k],visited);
        }
    }

    private static boolean isSafe(int[][] mat, int row, int col , boolean[][] visited){

        /*return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL) &&
                (mat[row][col]==1 && !visited[row][col]);*/
        return (row>=0) && (row<ROW)  && (col>=0) && (col<COL) && (mat[row][col] ==1&& (!visited[row][col]));

        }

    public static void main (String[] args) throws java.lang.Exception
    {
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("Number of islands is: "+ maxNoOfIslands(M));
    }

}
