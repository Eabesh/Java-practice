package recursion.backtracking;

import org.junit.Test;

import java.util.HashSet;

public class SubsetSumTest {

    @Test
    public void subsetTest() {
        HashSet<Integer> set = new HashSet<Integer>();
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        new SubsetSum().find(set,a,5);
    }

}
