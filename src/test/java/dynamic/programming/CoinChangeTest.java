package dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinChangeTest {

    @Test
    public void changeTest() {
        int[] a = {1, 2, 3};
        assertEquals(2,new CoinChange().change(a,6));
    }

}
