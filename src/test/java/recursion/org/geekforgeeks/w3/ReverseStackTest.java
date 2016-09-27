package recursion.org.geekforgeeks.w3;

import org.junit.Test;
import utilities.Stack;

import static org.junit.Assert.assertEquals;

public class ReverseStackTest {

    @Test
    public void reverseTest() {
        ReverseStack reverseStack = new ReverseStack();
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverseStack.reverse(stack);
        assertEquals(1,stack.pop());
    }
}
