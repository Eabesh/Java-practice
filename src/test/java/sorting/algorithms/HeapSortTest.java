package sorting.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeapSortTest {

    @Test
    public void heapSortTest() {
        int[] a = new int[3];
        a[0] = 3;
        a[1] = 2;
        a[2] = 1;
        new HeapSort().heapSort(a);
        assertEquals(a[0],1);
    }

}
