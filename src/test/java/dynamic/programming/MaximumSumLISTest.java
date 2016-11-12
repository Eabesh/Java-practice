package dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSumLISTest {

    @Test
    public void maxSumLISTest() {
        int[] a = {1, 101, 2, 3, 100, 4, 5};
        assertEquals(106,(new MaximumSumLIS()).maxSumBottomUp(a));
    }
}
