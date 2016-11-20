package sorting.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by pankaj.thakur on 20/09/16.
 */
public class MergeSortTest {

    @Test
    public void mergeSort() {
        int[] a = new int[3];
        a[0] = 3;
        a[1] = 2;
        a[2] = 1;
        new MergeSort().mergeSort(a,0,a.length-1);
        assertEquals(1,a[0]);
        assertEquals(2,a[1]);
        assertEquals(3,a[2]);
    }
}
