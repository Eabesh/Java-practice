package algorithms.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by abhay on 24/03/17.
 */
public class GreedyProblems {

    /**
     * Problem: Find the minimum number of notes required to given sum.
     */

    static int[] findNotes(int amount, int [] notes) {
        int[] result = new int[notes.length];
        while (amount > 0) {
            for (int note = 0; note < notes.length; note++) {
                if (amount >= notes[note]) {
                    amount -= notes[note];
                    result[note]++;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] notes = {1000, 500, 100, 50, 20, 10, 5, 1};
        int[] res = findNotes(1602, notes);

        System.out.println("1000 = " + res[0]);
        System.out.println("500 = " + res[1]);
        System.out.println("100 = " + res[2]);
        System.out.println("50 = " + res[3]);
        System.out.println("20 = " + res[4]);
        System.out.println("10 = " + res[5]);
        System.out.println("5 = " + res[6]);
        System.out.println("1 = " + res[7]);
    }



}
