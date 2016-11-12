package dynamic.programming;

import java.util.Arrays;

class LongestIncreasingSubsequence {

    int LISBottomUp(int[] array) {
        int[] lis = new int[array.length];
        Arrays.fill(lis,1);
        int maxSoFar = 1;
        for (int i = 1; i < array.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) max = Math.max(max, 1 + lis[j]);
            }
            lis[i] = max;
            maxSoFar = Math.max(maxSoFar,max);
        }
        return maxSoFar;
    }

}
