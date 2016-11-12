package dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LCSTest {

    @Test
    public void lcsTest() {
        String s1 = "AB";
        String s2 = "AED";
        assertEquals(1,new LCS().lcs(s1,s2));
    }

    @Test
    public void lcsTest2() {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        assertEquals(3,new LCS().lcs(s1,s2));
    }

}
