package algorithms.searching;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PeakFinderTest {

    @Test
    public void singleDimensionTest() {
        int[] a = new int[3];
        a[0] = 3;
        a[1] = 2;
        a[2] = 1;
        assertEquals(new PeakFinder().singleDimension(a),0);
    }
}
