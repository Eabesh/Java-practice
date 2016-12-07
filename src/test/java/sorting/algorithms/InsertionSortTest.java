package sorting.algorithms;

import algorithms.searching.and.sorting.algorithms.InsertionSort;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsertionSortTest {

    @Test
    public void sortTest() {
        int[] a = new int[3];
        a[0] = 3;
        a[1] = 2;
        a[2] = 1;
        new InsertionSort().sort(a);
        assertEquals(1,a[0]);
        assertEquals(2,a[1]);
        assertEquals(3,a[2]);
    }

}
