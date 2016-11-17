package data.structures.arrays;


import java.util.Arrays;

public class ArrayExamples {

    int maxSum = -1;
    String path = "";

    /**
     * 1.
     * Problem: Given an array A[] and a number x, check for pair in A[] with sum as x.
     *
     * Solution: Use sorting or hashmap.
     */

    /**
     * 2.
     * Problem: Majority Element: A majority element in an array A[] of size n is an element that appears more than
     * n/2 times (and hence there is at most one such element).
     *
     * Solution: Use BST or Moore's voting algorithm.
     */

    /**
     * 3.
     * Problem: Find the Number Occurring Odd Number of Times.
     * Given an array of positive integers. All numbers occur even number of times except one number which occurs odd
     * number of times. Find the number in O(n) time & constant space.
     *
     * Solution: Use XOR operator.
     */
    int getOddOccurrence(int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++)
            res = res ^ array[i];
        return res;
    }

    /**
     * 4. Maximum sum of contigous subarray for a non-empty array.
     */
    int maxSumContigous(int[] array) {
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
     *
     * Problem:
     *
     * Solution:
     */

    /**
     *
     * Problem:
     *
     * Solution:
     */

    /**
     *
     * Problem:
     *
     * Solution:
     */

    /**
     *
     * Problem:
     *
     * Solution:
     */

    /**
     *
     * Problem:
     *
     * Solution:
     */

    /**
     *
     * Problem:
     *
     * Solution:
     */

    /**
     *
     * Problem:
     *
     * Solution:
     */

    /**
     *
     * Problem:
     *
     * Solution:
     */



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
     * 16.
     * Problem: Count Inversions in an array.
     * Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
     * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
     *
     * Solution: Use BST. Count of left children gives number of inversions of that element.
     */

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
     * 144.
     * Problem: Count triplets with sum smaller than a given value.
     * Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value.
     * Expected Time Complexity is O(n^2).
     *
     * Solution: Sort and then use duplet algo.
     */

    /**
     * 145. Longest Span with same Sum in two Binary arrays.
     */

    /**
     * 146.
     * Problem: Merge two sorted arrays with O(1) extra space.
     * We are given two sorted array. We need to merge these two arrays such that the initial numbers
     * (after complete sorting) are in the first array and the remaining numbers are in the second array.
     * Extra space allowed in O(1).
     *
     * Solution: Assume two arrays to be continous single array and use insertion sort logic.
     */

    /**
     * 147. Form minimum number from given sequence.
     */

    /**
     * 150.
     * Problem: Subarray/Substring vs Subsequence and Programs to Generate them.
     *
     * Solution: In general, for an array/string of size n, there are n*(n+1)/2 non-empty subarrays/subsrings. We can
     * generate all by sliding window algo.
     *
     * More generally, we can say that for a sequence of size n, we can have (2n-1) non-empty sub-sequences in total.
     * Every subarray is a subsequence. More specifically, Subsequence is a generalization of substring.
     * Subsequences are in fact subsets except for empty set.
     */

    /**
     * 149.
     * Problem: Count Strictly Increasing Subarrays.
     * Given an array of integers, count number of subarrays (of size more than one) that are strictly increasing.
     */
    int countSIS(int[] arr) {
        int count = 0;
        int sortedLen = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) sortedLen++;
            else {
                count += (sortedLen - 1) * sortedLen/2;
                sortedLen = 1;
            }
        }
        if (sortedLen > 1) count += (sortedLen - 1) * sortedLen/2;
        return count;
    }

    /**
     * 150.
     * Problem: Rearrange an array in maximum minimum form.
     * Given a sorted array of positive integers, rearrange the array alternately i.e first element should be maximum
     * value, second minimum value, third second max, fourth second min and so on.
     *
     * Solution: With extra space it can be easily done using two pointers. For in place, use below :
     * Output index j for an element arr[i]
     * If (i < n/2) j = 2*i + 1
     * Else j = 2*(n-1-i);
     * The idea is to use the fact that numbers are positive. One by one place numbers at their correct positions
     * and mark them negative.
     */

    /**
     * 151.
     * Problem: Find minimum difference between any two elements.
     * Given an unsorted array, find the minimum difference between any pair in given array.
     *
     * Solution: Sort and then compare adjust elements.
     *
     * Time Complexity: O(n.log(n))
     */

    /**
     * 152.
     * Problem: Find lost element from a duplicated array.
     * Given two arrays which are duplicates of each other except one element, that is one element
     * from one of the array is missing, we need to find that missing element.
     *
     * Solution: If elements are sorted, use modified binary search starting with bigger array.
     * Otherwise, use XOR operator.
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
