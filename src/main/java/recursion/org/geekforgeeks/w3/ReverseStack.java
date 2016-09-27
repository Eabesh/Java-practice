package recursion.org.geekforgeeks.w3;

import utilities.Stack;

/**
 *  Reverse a stack without using any other data structure or
 *  auxiliary space.
 */
class ReverseStack {

    void reverse(Stack stack) {
        if(!stack.isEmpty()) {
            int top = stack.pop();
            reverse(stack);
            insertAtBottom(stack,top);
        }
    }

    private void insertAtBottom(Stack stack, int elem) {
        if (stack.isEmpty())
            stack.push(elem);
        else {
            int top = stack.pop();
            insertAtBottom(stack,elem);
            stack.push(top);
        }
    }



}
