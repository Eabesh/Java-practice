package data.structures.arrays;


import java.util.Arrays;

public class ArrayExamples {

    int maxSum = -1;
    String path = "";

    /**
     * 4. Maximum sum of contigous subarray for a non-empty array.
     */
    public int maxSumContigous(int[] array) {
        int currentMax = array[0];
        int maxSumSofar = array[0];
        for(int i = 1; i < array.length; i++) {
            currentMax = Math.max(array[i], currentMax + array[i]);
            maxSumSofar = Math.max(maxSumSofar,currentMax);
        }
        return maxSumSofar;
    }

    /**
     * Maximum sum of not necessarily contigous array for a non empty array.
     */
    public int maxSumNonContigous(int [] array) {
        int maxSum = 0;
        int leastNeg = Integer.MIN_VALUE;
        int negCount = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] > 0) maxSum += array[i];
            else {
                negCount ++;
                if (array[i] > leastNeg) leastNeg = array[i];
            }
        }
        if (negCount == array.length) return leastNeg;
        else return maxSum;
    }

    /**
     * 13. Maximum sum such that no two elements are adjacent.
     */
    int maxSum(int[] array) {
        sum("",array,0);
//        System.out.println(path.replace(","," "));
        return maxSum;
    }

    private void sum(String soFar, int[] array, int start) {
        if (start >= array.length) {
            if (maxSum < getSum(soFar)) {
                maxSum = getSum(soFar);
                path = soFar;
            }
        }
        else for(int i = start; i < array.length; i++) sum(soFar + "," + array[i], array, i + 2);


    }

    private int getSum(String str) {
        int sum = 0;
        for(String s : str.split(",")) if (!(s.length() == 0)) sum += Integer.parseInt(s);
        return sum;
    }

    /**
     *  Linear time algo for above.
     */
    int maxSumLinear(int[] array) {
        int incl = array[0];
        int excl = 0;
        for (int i = 1; i < array.length; i++) {
            int previousIncl = incl;
            incl = excl + array[i];
            excl = Math.max(previousIncl,excl);
        }
        return Math.max(incl,excl);
    }


    /**
     * 23. Maximum difference between two elements such that larger element appears after the smaller element.
     */
    public int maxDiff(int[] array) {
        int maxDiffSoFar = 0;
        int min = array[0];
        for (int i = 1; i < array.length; i ++) {
            maxDiffSoFar = Math.max(maxDiffSoFar, array[i] - min);
            min = Math.min(min, array[i]);
        }
        return maxDiffSoFar;
    }

    /**
     * 42. Maximum of all subarrays of size k.
     */

    /**
     * 46. Median in a stream of integers (running integers).
     */

    /**
     * 53. Find sub array with given sum
     */

    /**
     * 59. The Celebrity Problem
     */

    /**
     * 60. Longest Bitonic Subsequence
     */

    /**
     * 63. Partition problem.
     */

    /**
     * 67. Maximum Length Chain of Pairs
     */

    /**
     * 77. Find the number of islands using DFS.
     */

    /**
     * 81. Pancake sorting
     */

    /**
     * 83. Tug of War
     */

    /**
     * 84. Maximum Subarray Sum
     */

    /**
     * 88. Stock Buy Sell to Maximize Profit
     */

    /**
     * 97. Stable Marriage Problem
     */

    /**
     * 129. Online algorithm for checking palindrome in a stream
     */

    /**
     *
     */

    /**
     * 136. Trapping Rain Water
     */

    /**
     * 137. Convert array into Zig-Zag fashion.
     * Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time.
     * The converted array should be in form a < b > c < d > e < f.
     */

    /**
     * 145. Longest Span with same Sum in two Binary arrays.
     */

    /**
     * 147. Form minimum number from given sequence.
     */

    /**
     * 149. Count Strictly Increasing Subarrays
     */

    /**
     * 153.
     * Problem: Count pairs with given sum.
     *
     * Solution: Use hash set. Result will be count/2.
     */

    /**
     * 154.
     * Problem: Count minimum steps to get the given desired array.
     * Consider an array with n elements and value of all the elements is zero.
     * We can perform following operations on the array.
     * 1. Incremental operations:Choose 1 element from the array and increment its value by 1.
     * 2. Doubling operation: Double the values of all the elements of array.
     *
     * Solution: The idea is to follow reverse steps, i.e. to convert target to array of zeros.
     */

    /**
     * 155.
     * Problem: Find minimum number of merge operations to make an array palindrome.
     * Given an array of positive integers. We need to make the given array a ‘Palindrome’.
     * Only allowed operation on array is merge. Merging two adjacent elements means replacing them with their sum.
     * The task is to find minimum number of merge operations required to make given array a ‘Palindrome’.
     */
    int minPalindromeOperations(int[] array, int start, int end) {
        if (start >= end) return 0;
        else if (array[start] == array[end]) return minPalindromeOperations(array, start + 1, end - 1);
        else if (array[start] < array[end]) {
            array[start] += array[start + 1];
            return 1 + minPalindromeOperations(array, start + 1, end);
        }
        else {
            array[end] += array[end -1];
            return 1 + minPalindromeOperations(array, start, end - 1);
        }
    }

    /**
     * 156.
     * Problem: Minimize the maximum difference between the heights.
     * Given heights of n towers and a value k. We need to either increase or decrease height of every tower by k
     * (only once) where k > 0. The task is to minimize the difference between the heights of the longest and the
     * shortest tower after modifications, and output this difference.
     */
    int minDiff(int[] array, int k) {
        Arrays.sort(array);
        array[0] += k;
        array[array.length - 1] -= k;
        int min = Math.min(array[0], array[array.length - 1]);
        int max = Math.max(array[0], array[array.length - 1]);
        for (int j = 1; j < array.length - 1; j++) {
            if (array[j] < min) array[j] += k;
            else if (array[j] > max) array[j] -= k;
            else if (max - array[j] < array[j] - min) array[j] += k;
            else array[j] -= k;
            min = Math.min(array[j], min);
            max = Math.max(array[j], max);
        }
        return max - min;
    }


}
