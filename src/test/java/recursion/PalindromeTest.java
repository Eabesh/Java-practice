package recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeTest {

    @Test
    public void isPalindromeTest() {
        assertEquals(true,(new Palindrome()).isPalindrome(""));
        assertEquals(true,(new Palindrome()).isPalindrome("a"));
        assertEquals(false,(new Palindrome()).isPalindrome("ab"));
    }
}
