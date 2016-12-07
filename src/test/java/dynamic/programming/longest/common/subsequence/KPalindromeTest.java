package dynamic.programming.longest.common.subsequence;

import algorithms.dynamic.programming.longest.common.subsequence.KPalindrome;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KPalindromeTest {

    @Test
    public void isKPalTest() {
        String s = "abcdecba";
        int k = 1;
        assertEquals(true,new KPalindrome().isKPal(s,1));
    }
}
