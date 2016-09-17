package recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExponentTest {

    @Test
    public void getExponentTest() {
        assertEquals(8,(new Exponent()).getExponent2(2,3));
    }

    @Test
    public void getExpEfficientTest() {
        assertEquals(16,(new Exponent()).getExpEfficient2(2,4));
    }

}
