package data.structures.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayExamplesTest {

    @Test
    public void maxSumTest() {
        int[] a = {3,2,7,10};
        int result = new ArrayExamples().maxSum(a);
        assertEquals(13,result);
        assertEquals(13,new ArrayExamples().maxSumLinear(a));
    }

    @Test
    public void maxSumContigousTest() {
        int[] a = {3,2,7,10};
        int[] b = {-3,-22,-7,-10};
        int result = new ArrayExamples().maxSumContigous(a);
        assertEquals(22,result);
        assertEquals(-3,new ArrayExamples().maxSumContigous(b));
    }


    @Test
    public void maxSumNonContigousTest() {
        int[] a = {-3,2,7,10};
        int[] b = {-30,-22,-7,-10};
        int result = new ArrayExamples().maxSumNonContigous(a);
        assertEquals(19,result);
        assertEquals(-7,new ArrayExamples().maxSumNonContigous(b));
    }
}
