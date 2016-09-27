package recursion.org.geekforgeeks.w3;

import java.util.Vector;

/**
 * A number is called as a stepping number if the adjacent digits are having a difference of 1.
 * For eg. 8,343,545 are stepping numbers. While 890, 098 are not.
 * The difference between a ‘9’ and ‘0’ should not be considered as 1.
 */
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
