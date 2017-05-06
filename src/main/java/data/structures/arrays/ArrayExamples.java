package data.structures.arrays;


import java.util.Arrays;
import java.util.HashMap;

public class ArrayExamples {

  /**
   * 1.
   * Problem: Given an array A[] and a number x, check for pair in A[] with sum as x.
   *
   * Solution: Use sorting and use left and right pointers. Or
   * Use hash map :
   * 1) Initialize Binary Hash Map M[] = {0, 0, ...}
   * 2) Do following for each element A[i] in A[]
   *      (a)	If M[x - A[i]] is set then print the pair (A[i], x - A[i])
   *      (b)	Set M[A[i]].
   */

  /**
   * 2.
   * Problem: Majority Element: A majority element in an array A[] of size n is an element that appears more than
   * n/2 times (and hence there is at most one such element).
   *
   * Solution:
   * Using BST: Insert elements in BST one by one and if an element is already present then increment the
   * count of the node. At any stage, if count of a node becomes more than n/2 then return.
   *
   * Moore's voting algorithm.
   * 1. Find candidate.
   * 2. Check if this candidate is majority element.
   */

  /**
   * 3.
   * Problem: Find the Number Occurring Odd Number of Times.
   * Given an array of positive integers. All numbers occur even number of times except one number which occurs odd
   * number of times. Find the number in O(n) time & constant space.
   *
   * Solution: Use XOR operator.
   */
  int getOddOccurrenceWithLambda(int[] array) {
    return Arrays.stream(array).reduce(0, (a,b) -> a ^ b);
  }

  int getOddOccurrence(int[] array) {
    int accumulator = 0;
    for (int elem : array) accumulator ^= elem;
    return accumulator;
  }

  /**
   * 4. Maximum sum of contigous subarray for a non-empty array.
   */
  int maxSumContigous(int[] array) {
    int currentMax = array[0];
    int maxSumSoFar = array[0];
    for (int i = 1; i < array.length; i++) {
      currentMax = Math.max(array[i], currentMax + array[i]);
      maxSumSoFar = Math.max(maxSumSoFar, currentMax);
    }
    return maxSumSoFar;
  }

  /**
   * Maximum sum of not necessarily contigous array for a non empty array.
   */
  int maxSumNonContigous(int [] array) {
    int maxSum = 0;
    int leastNeg = Integer.MIN_VALUE;
    int negCount = 0;
    for(int i = 0; i < array.length; i++) {
      if (array[i] > 0) maxSum += array[i];
      else {
        negCount++;
        if (array[i] > leastNeg) leastNeg = array[i];
      }
    }
    if (negCount == array.length) return leastNeg;
    else return maxSum;
  }

  /**
   * 5.
   * Problem: Find the Missing Number.
   * You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates
   * in list. One of the integers is missing in the list.
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
   * Problem: Merge an array of size n into another array of size m+n.
   * There are two sorted arrays. First one is of size m+n containing only m elements. Another one is of size n and
   * contains n elements. Merge these two arrays into the first array of size m+n such that the output is sorted.
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
   * Solution: Either use two pointer and swap iteratively or use stack frame in recursion to store
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
   * 13.
   * Problem: Maximum sum such that no two elements are adjacent.
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
   * 23.
   * Problem: Maximum difference between two elements such that larger element appears after the smaller element.
   */
  public int maxDiff(int[] array) {
    int maxDiffSoFar = 0;
    int min = array[0];
    for (int i = 1; i < array.length; i++) {
      maxDiffSoFar = Math.max(maxDiffSoFar, array[i] - min);
      min = Math.min(min, array[i]);
    }
    return maxDiffSoFar;
  }

  /**
   * 25.
   * Problem: Floor and Ceiling in a sorted array.
   *
   * Solution: Use modified binary search to find floor and ceiling separately.
   * Hint: If x is greater than arr[mid], then either arr[mid + 1] is ceiling of x or ceiling lies in arr[mid+1...high]
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
   * Solution: Initialize left sum as 0 and right sum as sum of all elements. Scan from left to right and keep
   * updating sums till they are equal.
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
   *
   * Problem:
   *
   * Solution:
   */

  /**
   * 47.
   * Problem: Find a Fixed Point in a given array.
   * Given an array of n distinct integers sorted in ascending order, write a function that returns a Fixed Point
   * in the array, if there is any Fixed Point present in array, else returns -1. Fixed Point in an array is an
   * index i such that arr[i] is equal to i. Note that integers in array can be negative.
   *
   * Solution: Use binary search.
   */

  /**
   * 50.
   * Problem: Count smaller elements on right side.
   * Write a function to count number of smaller elements on right of each element in an array. Given an unsorted
   * array arr[] of distinct integers, construct another array countSmaller[] such that countSmaller[i] contains
   * count of smaller elements on right side of each element arr[i] in array.
   *
   * Solution: Use self balancing BST.
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
      if (i != a)
        if (knows(matrix,a,i) || !knows(matrix,i,a)) return -1;
    }
    return a;
  }

  private boolean knows(int[][] m, int a, int b) { return m[a][b] == 1 ;}

  /**
   * 61.
   * Problem: Find a sorted subsequence of size 3 in linear time.
   * Given an array of n integers, find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time.
   * If there are multiple such triplets, then print any one of them.
   *
   * Solution:
   * 1) Create an auxiliary array smaller[0..n-1]. smaller[i] should store the index of a number which is smaller
   * than arr[i] and is on left side of arr[i]. smaller[i] should contain -1 if there is no such element.
   * 2) Create another auxiliary array greater[0..n-1]. greater[i] should store the index of a number which is
   * greater than arr[i] and is on right side of arr[i]. greater[i] should contain -1 if there is no such element.
   * 3) Finally traverse both smaller[] and greater[] and find the index i for which both smaller[i] and greater[i]
   * are not -1.
   */
  int sortedSequence(int[] array) {
    int[] smaller = new int[array.length];
    smaller[0] = -1;
    int min = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[min])
        smaller[i] = min;
      else {
        min = i;
        smaller[i] = -1;
      }
    }
    int[] greater = new int[array.length];
    greater[array.length - 1] = -1;
    int max = array.length - 1;
    for (int j = array.length - 2; j <= 0; j--) {
      if (array[j] < array[max])
        greater[j] = max;
      else {
        max = j;
        greater[j] = -1;
      }
    }
    for (int i = 0; i < array.length; i++)
      if (smaller[i] != -1 && greater[i] != -1) return i;
    return -1;
  }

  /**
   * 63.
   * Problem: Partition problem.
   * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of
   * elements in both subsets is same.
   *
   * Solution:
   * Method 1: Recursive solution with Time Complexity as O(2^n).
   *
   * Method 2: Dynamic Programming Solution.
   * The problem can be solved using dynamic programming when the sum of the elements is not too big. We can
   * create a 2D array part[][] of size (sum/2)*(n+1). And we can construct the solution in bottom up manner such
   * that every filled entry has following property:
   *         part[i][j] = true if a subset of {arr[0], arr[1], ..arr[j-1]} has sum
   *         equal to i, otherwise false
   */
  boolean findPartition(int[] array) {
    int sum = Arrays.stream(array).sum();
    if (isOdd(sum)) return false;
    else {
      boolean[][] partition = new boolean[sum / 2 + 1][array.length + 1];
      for (int i = 0; i <= array.length; i++) partition[0][i] = true;
      for (int i = 1; i <= sum / 2; i++) partition[i][0] = false;
      for (int i = 1; i <= sum / 2; i++) {
        for (int j = 1; j <= array.length; j++) {
          partition[i][j] = partition[i][j-1];
          if (i >= array[j-1])
            partition[i][j] = partition[i][j] || partition[i-array[j-1]][j-1];
        }
      }
      return partition[sum/2][array.length];
    }
  }

  private boolean isOdd(int n) { return n % 2 != 0;}

  /**
   * 64.
   * Problem: Maximum Product Subarray.
   * Given an array that contains both positive and negative integers, find the product of the maximum product
   * subarray. Expected Time complexity is O(n) and only O(1) extra space can be used.
   *
   * Solution: This is similar to maximum subarray. Unlike sum, the sign of number affect the product value.
   * When iterating the array, each element has two possibilities: positive number or negative number. We need to
   * track a minimum value, so that when a negative number is given, it can also find the maximum value. We define
   * two local variables, one tracks the maximum and the other tracks the minimum.
   */
  int maxProduct(int[] nums) {
    int[] max = new int[nums.length];
    int[] min = new int[nums.length];
    max[0] = min[0] = nums[0];
    int result = nums[0];
    for (int i = 1; i < nums.length; i++){
      if (nums[i] > 0){
        max[i] = Math.max(nums[i], max[i-1]*nums[i]);
        min[i] = Math.min(nums[i], min[i-1]*nums[i]);
      } else {
        max[i] = Math.max(nums[i], min[i-1]*nums[i]);
        min[i] = Math.min(nums[i], max[i-1]*nums[i]);
      }
      result = Math.max(result, max[i]);
    }
    return result;
  }

  /**
   * 71.
   * Problem: Maximum circular subarray sum
   * Given n numbers (both +ve and -ve), arranged in a circle, fnd the maximum sum of consecutive number.
   *
   * Solution: Wrapping of contributing elements implies non wrapping of non contributing elements, so find out the
   * sum of non contributing elements and subtract this sum from the total sum. To find out the sum of non
   * contributing, invert sign of each element and then run Kadane’s algorithm.
   * Two cases
   * 1. Simple contigious subaraay sum.
   * 2. contigious sum with ring. (remove chains of negative numbers : total sum - (-invert number and find sum)
   * return Marx(1, 2)
   */

  int maxSumCircularSubarray(int[] arr) {
    int totalSum = 0, withoutCircleSum = 0, circularSum = 0;
    withoutCircleSum = maxSumContigous(arr);
    for (int i = 0; i < arr.length; i++) {
      totalSum += arr[i];
      arr[i] = - arr[i];
    }
    circularSum = totalSum + maxSumContigous(arr);
    return Math.max(withoutCircleSum, circularSum);
  }

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
   * 119.
   * Problem: Find the smallest positive integer value that cannot be represented as sum of any subset of a
   * given array.
   * Given a sorted array (sorted in non-decreasing order) of positive numbers, find the smallest positive integer
   * value that cannot be represented as sum of elements of any subset of given set.
   * Expected time complexity is O(n).
   *
   * Solution:
   * 1. Initialize result = 1 (smallest possible outcome).
   * 2. if ( arr[i] > result) found gap and res is the answer.
   * 3. else add arr[i] to result.
   */
  int findSmallest(int[] arr) {
    int res = 1;
    for (int i = 0; i < arr.length && res >= arr[i]; i++) res += arr[i];
    return res;
  }

  /**
   * 121.
   * Problem: Find position of an element in a sorted array of infinite numbers.
   *
   * Solution: Use modified binary search.
   * Let low be pointing to 1st element and high pointing to 2nd element of array. Now compare key with high
   * index element:
   * ->if it is greater than high index element then copy high index in low index and double the high index.
   * ->if it is smaller, then apply binary search on high and low indices found.
   */

  /**
   * 123.
   * Problem: Check if a given array contains duplicate elements within k distance from each other.
   * Given an unsorted array that may contain duplicates. Also given a number k which is smaller than size of array.
   */
  void checkDuplicatesKDistance(int[] arr, int k) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < k; i++) {
      if (map.containsValue(arr[i])) System.out.print(arr[i] + " ");
      map.put(i, arr[i]);
    }
    for (int windowR = k; windowR < arr.length; windowR++) {
      map.remove(arr[windowR - k]);
      if(map.containsValue(arr[windowR])) System.out.print(arr[windowR] + " ");
      map.put(windowR, arr[windowR]);
    }
  }


  /**
   * 129. Online algorithm for checking palindrome in a stream
   */

  /**
   * 130.
   * Problem: Pythagorean Triplet in an array.
   * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies
   * a2 + b2 = c2.
   *
   * Solution:
   * 1) Do square of every element in input array. This step takes O(n) time.
   * 2) Sort the squared array in increasing order. This step takes O(nLogn) time.
   * 3) To find a triplet (a, b, c) such that a = b + c, fix a as last element and search b and c in between first
   *    element and a. We can use left and right pointers for this.
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
   * 148.
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
      array[start + 1] += array[start];
      return 1 + minPalindromeOperations(array, start + 1, end);
    }
    else {
      array[end - 1] += array[end];
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
