package algorithms.dynamic.programming.palindromes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxPalSubsequenceTest {

    @Test
    public void maxPalTest() {
        String s = "GEEKSFORGEEKS";
        assertEquals(5,new MaxPalSubSequence().maxPal(s));

    }
}
