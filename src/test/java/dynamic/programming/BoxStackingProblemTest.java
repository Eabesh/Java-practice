package dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoxStackingProblemTest {

    @Test
    public void boxStackingProblemTest() {
        int[][] b = { {4, 7, 9},
                {5, 8, 9},
                {11, 20, 40},
                {1, 2, 3} };
        assertEquals(78,new BoxStackingProblem().boxStacking(b));
    }

}
