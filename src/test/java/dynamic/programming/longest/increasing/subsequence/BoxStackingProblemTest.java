package dynamic.programming.longest.increasing.subsequence;

import dynamic.programming.longest.increasing.subsequence.BoxStackingProblem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoxStackingProblemTest {

    @Test
    public void boxStackingProblemTest() {
        int[][] b = { {4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32} };
        assertEquals(60,new BoxStackingProblem().boxStacking(b));
    }

}
