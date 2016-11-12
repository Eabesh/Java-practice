package dynamic.programming;

import java.util.Arrays;

public class MaximumSumLIS {

    int maxSumBottomUp(int[] array) {
        int[] maxSum = Arrays.copyOfRange(array,0,array.length);
        int maxSoFar = array[0];
        for (int i = 1; i < array.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) max = Math.max(max, array[i] + maxSum[j]);
            }
            maxSum[i] = max;
            maxSoFar = Math.max(maxSoFar,max);
        }
        return maxSoFar;
    }

}
