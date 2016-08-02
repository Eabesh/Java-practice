package recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialTest {

    @Test
    public void factorialTest() {
        Factorial factorial = new Factorial();
        assertEquals(120,factorial.getFactorial(5));
    }

}
