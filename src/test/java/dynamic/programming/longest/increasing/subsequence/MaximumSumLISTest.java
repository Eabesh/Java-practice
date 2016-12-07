package dynamic.programming.longest.increasing.subsequence;

import algorithms.dynamic.programming.longest.increasing.subsequence.MaximumSumLIS;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSumLISTest {

    @Test
    public void maxSumLISTest() {
        int[] a = {1, 101, 2, 3, 100, 4, 5};
        assertEquals(106,(new MaximumSumLIS()).maxSumBottomUp(a));
    }
}
