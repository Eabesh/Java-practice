package algorithms.dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RodCuttingTest {

    @Test
    public void rodCutTest() {
        int[] price = {0,1,5,8,9,10,17,17,20,24,30};
        assertEquals(new RodCutting().rodCut(price,4),10);
    }

    @Test
    public void rodCutTestDPTopDown() {
        int[] price = {0,1,5,8,9,10,17,17,20,24,30};
        assertEquals(new RodCutting().rodCutDPTopDown(price,4),10);
    }

    @Test
    public void rodCutTestDPBottomUp() {
        int[] price = {0,1,5,8,9,10,17,17,20,24,30};
        assertEquals(new RodCutting().rodCutDPBottomUp(price,4),10);
    }

}
