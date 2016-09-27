package utilities;

import java.util.Vector;

public class Stack {

    Vector<Integer> stack = new Vector<Integer>();

    public int pop() {
        if (!isEmpty()) return stack.remove(stack.size()-1);
        else return -1;
    }

    public Boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(int elem) {
        stack.add(elem);
    }

}
