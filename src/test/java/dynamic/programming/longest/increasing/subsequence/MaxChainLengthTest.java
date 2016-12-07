package dynamic.programming.longest.increasing.subsequence;

import algorithms.dynamic.programming.longest.increasing.subsequence.MaxChainLength;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxChainLengthTest {

    @Test
    public void maxChainTest() {
        int[][] pairs = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} };
        assertEquals(3,new MaxChainLength().maxChain(pairs));
    }

}
