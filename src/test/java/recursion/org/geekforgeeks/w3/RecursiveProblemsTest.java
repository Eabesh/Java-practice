package recursion.org.geekforgeeks.w3;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by abhay on 28/02/17.
 */
public class RecursiveProblemsTest {

    @Test
    public void isPalindromeTest() {
        int num = 1231;
        assertEquals(true, new RecursionExamples().isPalindromeNumber(num, num, 0));
    }


}
