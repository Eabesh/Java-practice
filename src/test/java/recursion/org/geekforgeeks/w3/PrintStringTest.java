package recursion.org.geekforgeeks.w3;

import org.junit.Test;

import java.util.HashSet;

public class PrintStringTest {

    @Test
    public void printTest() {
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('b');
        new PrintString().print(set,3);
    }
}
