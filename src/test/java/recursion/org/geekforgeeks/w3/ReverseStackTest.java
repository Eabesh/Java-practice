package recursion.org.geekforgeeks.w3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStackTest {

    @Test
    public void reverseTest() {
        ReverseStack reverseStack = new ReverseStack();
        ReverseStack reverseStack2 = new ReverseStack();
        reverseStack.push(1);
        reverseStack.push(2);
        reverseStack.push(3);
        reverseStack2.reverse(reverseStack);
        assertEquals(1,reverseStack2.pop());
    }
}
