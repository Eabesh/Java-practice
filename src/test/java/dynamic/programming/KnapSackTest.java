package dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapSackTest {

    @Test
    public void knapSackTest() {
        int[] v = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int  C = 50;
        assertEquals(220,new KnapSack().knapSack(C,wt,v,3));
    }

}
