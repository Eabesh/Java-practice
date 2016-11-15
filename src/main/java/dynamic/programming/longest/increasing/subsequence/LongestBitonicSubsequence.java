package dynamic.programming.longest.increasing.subsequence;

import java.util.Arrays;

public class LongestBitonicSubsequence {

    /**
     * Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is
     * first increasing, then decreasing. Write a function that takes an array as argument and returns the length of
     * the longest bitonic subsequence. A sequence, sorted in increasing order is considered Bitonic with the
     * decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part
     * as empty.
     */
    int maxBitonic(int[] array) {
        int[] lis = new int[array.length];
        int[] lds = new int[array.length];
        getLIS(array,lis);
        getLDS(array,lds);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) max = Math.max(max, lis[i] + lds[i] - 1);
        return max;
    }

    private void getLIS(int[] array, int[] lis) {
        Arrays.fill(lis,1);
        for(int i = 1; i < lis.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) max = Math.max(max, array[j] + 1);
            }
            lis[i] = max;
        }
    }

    private void getLDS(int[] array, int[] lds) {
        Arrays.fill(lds,1);
        for(int i = lds.length - 2; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            for (int j = lds.length; j >= i; j--) {
                if (array[j] < array[i]) max = Math.max(max, array[j] + 1);
            }
            lds[i] = max;
        }
    }

}
