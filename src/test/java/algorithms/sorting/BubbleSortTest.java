package algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by pankaj.thakur on 22/09/16.
 */
public class BubbleSortTest {

    @Test
    public void sortTest() {
        int[] a = new int[3];
        a[0] = 3;
        a[1] = 2;
        a[2] = 1;
        new BubbleSort().sort(a);
        assertEquals(1,a[0]);
        assertEquals(2,a[1]);
        assertEquals(3,a[2]);
    }

}
