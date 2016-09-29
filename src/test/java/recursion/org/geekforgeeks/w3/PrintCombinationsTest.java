package recursion.org.geekforgeeks.w3;

import org.junit.Test;

public class PrintCombinationsTest {

    @Test
    public void printTest() {
        int[] a = new int[3];
        a[0] = 3;
        a[1] = 2;
        a[2] = 1;
        new PrintCombinations().print(a,2);
    }
}
