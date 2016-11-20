package cormen.sorting;

import org.junit.Test;


public class CountingSortTest {

    @Test
    public void sortTest() {
        int[] a = new int[3];
        a[0] = 3;
        a[1] = 2;
        a[2] = 1;
        new CountingSort().sort(a,3);
    }
}
