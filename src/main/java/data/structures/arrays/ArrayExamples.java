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
     * 5.
     * Problem: Find the Missing Number. You are given a list of n-1 integers and these integers are in the range
     * of 1 to n. There are no duplicates in list. One of the integers is missing in the list.
     * Write an efficient code to find the missing integer.
     *
     * Solution: Use sum formulae or XOR operator.
     */

    /**
     * 6.
     * Problem: Search an element in a sorted and rotated array.
     *
     * Solution: Use modified binary search.
     * 1) Find middle point mid = (l + h)/2
     * 2) If key is present at middle point, return mid.
     * 3) Else If arr[l..mid] is sorted
     *      a) If key to be searched lies in range from arr[l] to arr[mid], recur for arr[l..mid].
     *      b) Else recur for arr[mid+1..r]
     * 4) Else (arr[mid+1..r] must be sorted)
     *      a) If key to be searched lies in range from arr[mid+1]
     *          to arr[r], recur for arr[mid+1..r].
     *      b) Else recur for arr[l..mid]
     */

    /**
     * 7.
     * Problem: Merge an array of size n into another array of size m+n
     *
     * Solution: Move all elements together in one pass. Then fill up bigger array using two pointers.
     */

    /**
     * 8.
     * Problem: Median of two sorted arrays.
     *
     * Solution: Either merge two arrays which will take O(m + n) or use divide and conquer by getting
     * medians of each array and comparing till they are equal. O(logn).
     */

    /**
     * 9.
     * Problem: Write a program to reverse an array or string
     *
     * Solution: Either use to pointer and swap iteratively or use stack frame in recursion to store
     * elements and reverse the array in place.
     */

    /**
     * 10.
     * Problem: Program for array rotation.
     *
     * Solution: Use temp array or reversal algorithm.
     */

    /**
     * 11.
     * Problem: Program for array rotation using reversal algo.
     */

    /**
     * 12.
     * Problem: Block swap algo for rotation.
     *
     * Solution:
     */

    /**
     * 13. Maximum sum such that no two elements are adjacent.
     */
    int maxSum(int[] array) {
        sum("",array,0);
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
     * 14.
     * Problem: Leaders in an array.
     * An element is leader if it is greater than all the elements to its right side. And the rightmost element is
     * always a leader.
     *
     * Solution: Scan from right to left and find the leaders.
     */

    /**
     * 15.
     * Problem: Sort elements by frequency.
     *
     * Solution: Use hash map and then sort by frequency. Or use heap.
     */

    /**
     * 16.
     * Problem: Count Inversions in an array.
     * Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already
     * sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
     * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
     *
     * Solution: Use BST. Count of left children gives number of inversions of that element.
     */

    /**
     * 17.
     * Problem: Two elements whose sum is closest to zero.
     * An Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is
     * closest to zero.
     *
     * Solution: Sort the elements. Use left and right pointer. Add them and if sum < 0, l++ else r--.
     */

    /**
     * 18.
     * Problem: Find the smallest and second smallest element in an array.
     *
     * Solution:
     * 1) Initialize both first and second smallest as INT_MAX first = second = INT_MAX.
     * 2) Loop through all the elements.
     *      a) If the current element is smaller than first, then update first and second.
     *      b) Else if the current element is smaller than second then update second.
     *
     * Or use heap which will take O(k.logn).
     */

    /**
     * 19.
     * Problem: Check for Majority Element in a sorted array.
     * Find if a given integer x appears more than n/2 times in a sorted array of n integers.
     *
     * Solution: Use modified binary search to find start and end index of element.
     */

    /**
     * 20.
     * Problem:
     *
     * Solution:
     */

    /**
     * 26.
     * Problem: A Product Array Puzzle.
     * Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal
     * to the product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).
     *
     * Solution:
     * 1) Construct a temporary array left[] such that left[i] contains product of all elements on left of arr[i]
     *    excluding arr[i].
     * 2) Construct another temporary array right[] such that right[i] contains product of all elements on on right
     *    of arr[i] excluding arr[i].
     * 3) To get prod[], multiply left[] and right[].
     */

    /**
     * 28.
     * Problem: Find the two repeating elements in a given array.
     * You are given an array of n+2 elements. All elements of the array are in range 1 to n. And all elements occur
     * once except two numbers which occur twice. Find the two repeating numbers.
     *
     * Solution: Let the repeating numbers be X and Y, if we xor all the elements in the array and all integers from
     * 1 to n, then the result is X xor Y. The 1’s in binary representation of X xor Y is corresponding to the
     * different bits between X and Y. Suppose that the kth bit of X xor Y is 1, we can xor all the elements in the
     * array and all integers from 1 to n, whose kth bits are 1. The result will be one of X and Y.
     */

    /**
     * 31.
     * Problem: Find duplicates in O(n) time and O(1) extra space.
     * Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any
     * number of times. Find these repeating numbers in O(n) and using only constant memory space.
     *
     * Solution: Use the array itself as a hash map and mark the index corresponding to the element as negative.
     */

    /**
     * 32.
     * Problem: Equilibrium index of an array.
     * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum
     * of elements at higher indexes.
     *
     * Solution: Initialize left sum as 0 and right sum as  sum of all elements. Scan from left to right and keep
     * updating sums till the are equal.
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
     * 100.
     * Problem: Move all zeroes to end of array.
     * Given an array of random numbers, Push all the zero’s of a given array to the end of the array.
     * For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to
     * {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same. Expected time complexity is
     * O(n) and extra space is O(1).
     *
     * Solution: Scan from left to right and keep track of last non zero index i, insert next non zero element at i+1.
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
     * 59.
     * Problem: The Celebrity Problem.
     * In a party of N people, only one person is known to everyone. Such a person may be present in the party,
     * if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “.
     * Find the stranger (celebrity) in minimum number of questions.
     *
     * Solution: The idea is to use two pointers, one from start and one from the end. Assume the start person is A,
     * and the end person is B. If A knows B, then A must not be the celebrity. Else, B must not be the celebrity.
     * We will find a celebrity candidate at the end of the loop. Go through each person again and check whether
     * this is the celebrity.
     */
    int findCeleb(int[][] matrix) {
        int a = 0;
        int b = matrix.length - 1;
        while (a < b) {
            if (knows(matrix,a,b)) a++;
            else b--;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (i != a) {
                if (knows(matrix,a,i) || !knows(matrix,i,a)) return -1;
            }
        }
        return a;
    }

    private boolean knows(int[][] m, int a, int b) { if (m[a][b] == 1) return true; else return false;}

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
     * 83.
     * Problem: Tug of War
     * Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of
     * two subsets is as minimum as possible. If n is even, then sizes of two subsets must be strictly n/2 and if n is
     * odd, then size of one subset must be (n-1)/2 and size of other subset must be (n+1)/2.
     *
     * Solution: Try every possible subset of half size. If one subset of half size is formed, the remaining elements
     * form the other subset. We check whether this solutions is better than the best solution available so far.
     * If it is, then we update the best solution.
     */

    /**
     * 84. Maximum Subarray Sum
     */

    /**
     * 96.
     * Problem: Find the minimum element in a sorted and rotated array
     * A sorted array is rotated at some unknown point, find the minimum element in it.
     *
     * Solution: Use modified Binary Search.
     * Search for the element with greater prev element and next element if they are present.
     */
    int findMinElement(int[] arr, int left, int right) {
        if (left > right) return -1;
        else {
            int mid = left + (right - left) / 2;
            if (isMinimum(arr,mid)) return arr[mid];
            else if (arr[arr.length - 1] > arr[mid]) return findMinElement(arr, left, mid - 1);
            else return findMinElement(arr, mid + 1, right);
        }
    }

    private boolean isMinimum(int[] array, int mid) {
        int left = mid - 1 >= 0 ? array[mid - 1] : Integer.MAX_VALUE;
        int right = mid + 1 < array.length ? array[mid + 1] : Integer.MAX_VALUE;
        return array[mid] < left && array[mid] < right;
    }

    /**
     * 97.
     * Problem: Stable Marriage Problem.
     * Given N men and N women, where each person has ranked all members of the opposite sex in order of preference,
     * marry the men and women together such that there are no two people of opposite sex who would both rather have
     * each other than their current partners. If there are no such people, all the marriages are “stable”.
     *
     * Solution: Gale–Shapley algorithm.
     * Initialize all men and women to free
     * while there exist a free man m who still has a woman w to propose to
     * {
     *      w = m's highest ranked such woman to whom he has not yet proposed
     *      if w is free
     *          (m, w) become engaged
     *      else some pair (m', w) already exists
     *          if w prefers m to m'
     *              (m, w) become engaged
     *              and m' becomes free
     *          else
     *              (m', w) remain engaged
     * }
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
     *
     * Solution: Scan left to right and swap at odd and even places according to condition given above.
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
     * Solution: Sort and then compare adjacent elements.
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
