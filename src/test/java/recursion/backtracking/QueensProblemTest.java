package recursion.backtracking;

import org.junit.Test;

public class QueensProblemTest {

    @Test
    public void queenTest() {
        int[][] board = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        new QueensProblem().solve(board,0,4);
    }

}
