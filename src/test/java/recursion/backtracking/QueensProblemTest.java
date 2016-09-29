package recursion.backtracking;

import org.junit.Test;

public class QueensProblemTest {

    @Test
    public void queenTest() {
        int[][] board = new int[8][8];
        new QueensProblem().solve(board,0,8);
    }

}
