package recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibbonacciTest {

    @Test
    public void getTermTest() {
        assertEquals(3,(new Fibbonacci().getTerm(4)));
    }

}
