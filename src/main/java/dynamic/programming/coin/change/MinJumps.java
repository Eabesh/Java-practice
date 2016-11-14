package dynamic.programming.coin.change;

import java.util.Arrays;

public class MinJumps {

    /**
     * Given an array of integers where each element represents the max number of steps that can be made forward from
     * that element. Write a function to return the minimum number of jumps to reach the end of the array
     * (starting from the first element). If an element is 0, then cannot move through that element.
     */
    int minJumps(int[] array) {
        int[] jumps = new int[array.length];
        Arrays.fill(jumps,array.length+1);
        jumps[0] = 0;
        for(int i = 0; i < jumps.length - 1; i++) {
            int jump = 1 + jumps[i];
            for (int j = 0; j < array[i]; j++) {
                if(i + j + 1 < array.length) jumps[i + j + 1] = Math.min(jumps[i + j + 1], jump);
            }
        }
        if(jumps[array.length-1] > array.length) return -1;
        else return jumps[array.length-1];
    }

}
