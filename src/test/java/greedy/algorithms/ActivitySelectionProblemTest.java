package greedy.algorithms;

import algorithms.greedy.ActivitySelectionProblem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActivitySelectionProblemTest {

    @Test
    public void rodCutTest() {
        int[] start  =  {1, 3, 0, 5, 8, 5};
        int[] finish =  {2, 4, 6, 7, 9, 9};
        assertEquals(8,new ActivitySelectionProblem().activity(start,finish).lastElement().start);
    }

}
