package recursion.org.geekforgeeks.w3;


import java.util.Vector;

class ReverseStack {

    Vector<Integer> stack = new Vector<Integer>();

    void reverse(ReverseStack reverseStack) {
        if (!reverseStack.isEmpty()) {
            push(reverseStack.pop());
            reverse(reverseStack);
        }
    }

    int pop() {
        if (!isEmpty()) return stack.remove(stack.size()-1);
        else return -1;
    }

    Boolean isEmpty() {
        return stack.isEmpty();
    }

    void push(int elem) {
        stack.add(elem);
    }

}
