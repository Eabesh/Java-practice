package dynamic.programming.longest.increasing.subsequence;

import dynamic.programming.longest.increasing.subsequence.LongestIncreasingSubsequence;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void LISTest() {
        int[] a = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        assertEquals(6,new LongestIncreasingSubsequence().LISBottomUp(a));
    }

}
