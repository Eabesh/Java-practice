package dynamic.programming.longest.increasing.subsequence;

import java.util.HashMap;

class LongestIncreasingSubsequence {

    /**
     * Problem: The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a
     * given sequence such that all elements of the subsequence are sorted in increasing order.
     */

    HashMap<Integer,Integer> store = new HashMap<Integer, Integer>();

    int LIS(int[] array, int length) {
        if (length == 1) return 1;
        else {
            int max = 1;
            for (int j = 0; j < length - 1; j++) {
                if (array[j] < array[length - 1]) max = Math.max(max, 1 + LIS(array, j + 1));
            }
            return max;
        }
    }

    int LISTopDown(int[] array, int length) {
        store.put(1,1);
        if (store.containsKey(length)) return store.get(length);
        else {
            int max = 1;
            for (int j = 0; j < length - 1; j++) {
                if (array[j] < array[length - 1]) max = Math.max(max, 1 + LIS(array, j + 1));
            }
            store.put(length,max);
            return store.get(length);
        }
    }

    int LISBottomUp(int[] array) {
        int[] lis = new int[array.length];
        lis[0] = 1;
        int maxSoFar = 1;
        for (int i = 1; i < array.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) max = Math.max(max, 1 + lis[j]);
            }
            lis[i] = max;
            maxSoFar = Math.max(maxSoFar,max);
        }
        return maxSoFar;
    }

}
