package recursion.org.geekforgeeks.w3;

import java.util.Vector;

class SteppingNumber {

    void printNumber(Vector<Integer> choices, String soFar, int remaining) {
        if (remaining == 0) System.out.print(soFar + " ");
        else {
            for (int choice: choices) {
                int next = remaining - 1;
                Vector<Integer> newChoices = new Vector<Integer>();
                newChoices.add(choice + 1);
                newChoices.add(choice - 1);
                printNumber(newChoices, soFar + choice,next);
            }
        }
    }

}
