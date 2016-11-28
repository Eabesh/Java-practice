package dynamic.programming.longest.increasing.subsequence;

public class CountLIS {

    /**
     * Problem: Count all increasing subsequences.
     * We are given an array of digits (values lie in range from 0 to 9). The task is to count all the sub sequences
     * possible in array such that in each subsequence every digit is greater than its previous digits in the subsequence.
     *
     * Solution:
     * Method 1:
     * Like LIS problem, we first compute count of increasing subsequences ending at every index. Finally, we return
     * sum of all values (In LCS problem, we return max of all values).
     *
     * Method 2:
     * For example, arr[] = {3, 2, 4, 5, 4}
     * We create a count array and initialize it as 0.
     * count[10] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
     * Note that here value is used as index to store counts
     * count[3] += 1 = 1  // i = 0, arr[0] = 3
     * count[2] += 1 = 1  // i = 1, arr[0] = 2
     * Let us compute count for arr[2] which is 4
     * count[4] += 1 + count[3] + count[2] += 1 + 1 + 1  = 3
     * Let us compute count for arr[3] which is 5
     * count[5] += 1 + count[3] + count[2] + count[4]+= 1 + 1 + 1 + 3 = 6
     * Let us compute count for arr[4] which is 4
     * count[4] += 1 + count[0] + count[1] += 1 + 1 + 1 += 3 = 3 + 3 = 6
     * Note that count[] = {0, 0, 1, 1, 6, 6, 0, 0, 0, 0}
     * Result = count[0] + count[1] + ... + count[9]
     * = 1 + 1 + 6 + 6 {count[2] = 1, count[3] = 1 count[4] = 6, count[5] = 6} = 14.
     */

}
