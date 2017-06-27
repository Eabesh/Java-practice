package data.structures.arrays;


import algorithms.dynamic.programming.DPExamples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ArrayExamples {

  /**
   * 1.
   * Problem: Given an array A[] and a number x, check for pair in A[] with sum as x.
   * Solution: Use sorting and use left and right pointers. Or
   * Use hash map :
   * 1) Initialize Binary Hash Map M[] = {0, 0, ...}
   * 2) Do following for each element A[i] in A[]
   *      (a)	If M[x - A[i]] is set then print the pair (A[i], x - A[i])
   *      (b)	Set M[A[i]].
   */
  boolean checkPair1(int[] array, int sum) {
    Arrays.sort(array);
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      int currentSum = array[left] + array[right];
      if (currentSum == sum) return true;
      else if (currentSum < sum) left++;
      else right--;
    }
    return false;
  }

  boolean checkPair2(int[] array, int sum) {
    HashSet<Integer> set = new HashSet<>();
    for (int element : array) {
      if (set.contains(sum - element)) return true;
      else set.add(element);
    }
    return false;
  }

  /**
   * 2.
   * Problem: Majority Element: A majority element in an array A[] of size n is an element that appears more than
   * n/2 times (and hence there is at most one such element).
   * Solution:
   * Using BST: Insert elements in BST one by one and if an element is already present then increment the
   * count of the node. At any stage, if count of a node becomes more than n/2 then return.
   * Moore's voting algorithm.
   * 1. Find candidate.
   * 2. Check if this candidate is majority element.
   */

  /**
   * 3.
   * Problem: Find the Number Occurring Odd Number of Times.
   * Given an array of positive integers. All numbers occur even number of times except one number which occurs odd
   * number of times. Find the number in O(n) time & constant space.
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
   * 4.
   * Problem: Search an element in a sorted and rotated array.
   * Solution: Use modified binary search.
   * 1) Find middle point mid = (l + h)/2
   * 2) If key is present at middle point, return mid.
   * 3) Else If arr[l..mid-1] is sorted
   *      a) If key to be searched lies in range from arr[l] to arr[mid], recur for arr[l..mid].
   *      b) Else recur for arr[mid+1..r]
   * 4) Else (arr[mid+1..r] must be sorted)
   *      a) If key to be searched lies in range from arr[mid+1]
   *          to arr[r], recur for arr[mid+1..r].
   *      b) Else recur for arr[l..mid]
   */
  int binarySearchRotated(int[] array, int key, int beginIndex, int endIndex) {
    if (beginIndex <= endIndex) {
      int mid = beginIndex + (endIndex - beginIndex) / 2;
      if (array[mid] == key) return mid;
      else {
        if (array[beginIndex] < array[mid]) {
          if (key < array[mid] && key >= array[beginIndex]) return binarySearchRotated(array, key, beginIndex, mid - 1);
          else return binarySearchRotated(array, key, mid + 1, endIndex);
        }
        else {
          if (key > array[mid] && key <= array[endIndex]) return binarySearchRotated(array, key, mid + 1, endIndex);
          else return binarySearchRotated(array, key, beginIndex, mid - 1);
        }
      }
    }
    return -1;
  }

  /**
   * 5.
   * Problem: Merge an array of size n into another array of size m+n.
   * There are two sorted arrays. First one is of size m+n containing only m elements. Another one is of size n and
   * contains n elements. Merge these two arrays into the first array of size m+n such that the output is sorted.
   * Solution: Move all elements together in one pass. Then fill up bigger array using two pointers starting from right
   * and moving to left.
   */
  int[] mergeArray(int[] arr1, int[] arr2) {
    int arr1Last = arr1.length - 1;
    int arr2Last = arr2.length - arr1.length - 1;
    int last = arr2.length - 1;
    while (arr2Last >= 0 && arr1Last >=0) {
      if (arr2[arr2Last] > arr1[arr1Last]) arr2[last--] = arr2[arr2Last--];
      else arr2[last--] = arr1[arr1Last--];
    }
    while(arr1Last >= 0) arr2[last--] = arr1[arr1Last--];
    return arr2;
  }

  /**
   * 6.
   * Problem: Write a program to reverse an array or string
   * Solution: Either use two pointer and swap iteratively or use stack frame in recursion to store
   * elements and reverse the array in place.
   */
  void reverseArray(int[] array, int startIndex, int endIndex) {
    if (startIndex < endIndex) {
      swap(array, startIndex, endIndex);
      reverseArray(array, startIndex + 1, endIndex - 1);
    }
  }

  private void swap(int[] array, int i, int j) {
    array[i] = array[i] ^ array[j];
    array[j] = array[i] ^ array[j];
    array[i] = array[i] ^ array[j];
  }

  /**
   * 7.
   * Problem: Program for array rotation.
   * Solution: Use temp array or reversal algorithm.
   */

  /**
   * 8.
   * Problem: Program for array rotation using reversal algo.
   * Solution: Let AB are the two parts of the input array. Reverse A and B. Reverse all to get BA.
   */
  void rotateArray(int[] array, int pivot) {
    reverseArray(array,0, pivot);
    reverseArray(array,pivot + 1, array.length - 1);
    reverseArray(array, 0, array.length - 1);
  }

  /**
   * 9.
   * Problem: Block swap algo for rotation.
   */

  /**
   * 10.
   * Problem: Maximum sum such that no two elements are adjacent.
   * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in
   * the sequence should be adjacent in the array.
   */
  int maxSumNonAdjacent(int[] array) {
    int incl = array[0];
    int excl = 0;
    for (int i = 1; i < array.length; i++) {
      int previousIncl = incl;
      incl = excl + array[i];
      excl = Math.max(previousIncl, excl);
    }
    return Math.max(incl, excl);
  }

  /**
   * 11.
   * Problem: Leaders in an array.
   * An element is leader if it is greater than all the elements to its right side. And the rightmost element is
   * always a leader.
   * Solution: Scan all the elements from right to left in array and keep track of maximum till now. When maximum
   * changes it’s value, print it as it is a leader.
   */

  /**
   * 12.
   * Problem: Sort elements by frequency.
   * Solution: Use hash map and then sort by frequency. Or use modified BST with count field.
   */

  /**
   * 13.
   * Problem: Two elements whose sum is closest to zero.
   * An Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is
   * closest to zero.
   * Solution: Sort the elements. Use left and right pointer. Add them and if sum < 0, l++ else r--.
   */

  /**
   * 14.
   * Problem: Find the smallest and second smallest element in an array.
   * Solution:
   * 1) Initialize both first and second smallest as INT_MAX first = second = INT_MAX.
   * 2) Loop through all the elements.
   *      a) If the current element is smaller than first, then update first and second.
   *      b) Else if the current element is smaller than second then update second.
   * Or use heap which will take O(k.logn).
   */

  /**
   * 15.
   * Problem: Check for Majority Element in a sorted array.
   * Find if a given integer x appears more than n/2 times in a sorted array of n integers.
   * Solution: Use modified binary search to find start and end index of element.
   */

  /**
   * 16. Segregate 0s and 1s in an array.
   * Solution: Count 0s and fill array with 0s and remaining with 1s.
   */

  /**
   * 17. k largest(or smallest) elements in an array.
   * Solution: 1. Use Bubble k times. O(nk)
   * 2. Use Max Heap. Build a Max Heap tree in O(n)and use Extract Max k times to get k maximum elements. O(n + klogn)
   */

  /**
   * 18.
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
   * 19.
   * Problem: Union and Intersection of two sorted arrays.
   * Solution:
   */

  /**
   * 20.
   * Problem: A Product Array Puzzle.
   * Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal
   * to the product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).
   * Solution:
   * 1) Construct a temporary array left[] such that left[i] contains product of all elements on left of arr[i]
   *    excluding arr[i].
   * 2) Construct another temporary array right[] such that right[i] contains product of all elements on on right
   *    of arr[i] excluding arr[i].
   * 3) To get prod[], multiply left[] and right[].
   */

  /**
   * 21.
   * Problem: Segregate Even and Odd numbers.
   * Solution:
   */

  /**
   * 22.
   * Problem: Find the two repeating elements in a given array.
   * Solution:
   */

  /**
   * 23.
   * Problem: Find duplicates in O(n) time and O(1) extra space | Set 1.
   * Solution:
   */

  /**
   * 24.
   * Problem: Equilibrium index of an array.
   * Solution:
   */

  /**
   * 25.
   * Problem: Linked List vs Array.
   * Solution:
   */

  /**
   * 26.
   * Problem: Check if array elements are consecutive | Added Method 3.
   * Solution:
   */

  /**
   * 27.
   * Problem: Find the smallest missing number.
   * Solution:
   */

  /**
   * 28.
   * Problem: Given an array arr[], find the maximum j &#8211; i such that arr[j] > arr[i].
   * Solution:
   */

  /**
   * 29.
   * Problem: Find the minimum distance between two numbers.
   * Solution:
   */

  /**
   * 30.
   * Problem: Maximum Length Bitonic Subarray | Set 1 (O(n) tine and O(n) space).
   * Solution:
   */

  /**
   * 31.
   * Problem: Count smaller elements on right side.
   * Solution:
   */

  /**
   * 32.
   * Problem: Find subarray with given sum | Set 1 (Nonnegative Numbers).
   * Solution:
   */

  /**
   * 33.
   * Problem: Longest Increasing Subsequence Size (N log N).
   * Solution:
   */

  /**
   * 34.
   * Problem: Find a triplet that sum to a given value.
   * Solution:
   */

  /**
   * 35.
   * Problem: Find the smallest positive number missing from an unsorted array | Set 1.
   * Solution:
   */

  /**
   * 36.
   * Problem: Find the two numbers with odd occurrences in an unsorted array.
   * Solution:
   */

  /**
   * 37.
   * Problem: Find a sorted subsequence of size 3 in linear time.
   * Solution:
   */

  /**
   * 38.
   * Problem: Largest subarray with equal number of 0s and 1s.
   * Solution:
   */

  /**
   * 39.
   * Problem: Maximum Product Subarray.
   * Solution:
   */

  /**
   * 40.
   * Problem: Replace every element with the greatest element on right side.
   * Solution:
   */

  /**
   * 41.
   * Problem: Find four elements that sum to a given value | Set 1 (n^3 solution).
   * Solution:
   */

  /**
   * 42.
   * Problem: Find four elements that sum to a given value | Set 2 ( O(n^2Logn) Solution).
   * Solution:
   */

  /**
   * 43.
   * Problem: Maximum circular subarray sum.
   * Solution:
   */

  /**
   * 44.
   * Problem: Count the number of possible triangles.
   * Solution:
   */

  /**
   * 45.
   * Problem: Construction of Longest Increasing Subsequence (N log N).
   * Solution:
   */

  /**
   * 46.
   * Problem: Arrange given numbers to form the biggest number.
   * Solution:
   */

  /**
   * 47.
   * Problem: Merge Overlapping Intervals.
   * Solution:
   */

  /**
   * 48.
   * Problem: Find the maximum repeating number in O(n) time and O(1) extra space.
   * Solution:
   */

  /**
   * 49.
   * Problem: Stock Buy Sell to Maximize Profit.
   * Solution:
   */

  /**
   * 50.
   * Problem: Rearrange positive and negative numbers in O(n) time and O(1) extra space.
   * Solution:
   */

  /**
   * 51.
   * Problem: Find the Increasing subsequence of length three with maximum product.
   * Solution:
   */

  /**
   * 52.
   * Problem: Move all zeroes to end of array.
   * Solution:
   */

  /**
   * 53.
   * Problem: Program to find sum of elements in a given array.
   * Solution:
   */

  /**
   * 54.
   * Problem: Rearrange an array so that arr[i] becomes arr[arr[i]] with O(1) extra space.
   * Solution:
   */

  /**
   * 55.
   * Problem: Count all possible groups of size 2 or 3 that have sum as multiple of 3.
   * Solution:
   */

  /**
   * 56.
   * Problem: Find the number of zeroes.
   * Solution:
   */

  /**
   * 57.
   * Problem: Smallest subarray with sum greater than a given value.
   * Solution:
   */

  /**
   * 58.
   * Problem: Program to find largest element in an array.
   * Solution:
   */

  /**
   * 59.
   * Problem: Program to cyclically rotate an array by one.
   * Solution:
   */

  /**
   * 60.
   * Problem: Maximum Sum Path in Two Arrays.
   * Solution:
   */

  /**
   * 61.
   * Problem: Decode a given pattern in two ways (Flipkart Interview Question).
   * Solution:
   */

  /**
   * 62.
   * Problem: A data structure for n elements and O(1) operations.
   * Solution:
   */

  /**
   * 63.
   * Problem: Longest Monotonically Increasing Subsequence Size (N log N): Simple implementation.
   * Solution:
   */

  /**
   * 64.
   * Problem: Rearrange array in alternating positive &#038; negative items with O(1) extra space | Set 1.
   * Solution:
   */

  /**
   * 65.
   * Problem: Find the smallest positive integer value that cannot be represented as sum of any subset of a given array.
   * Given a sorted array (sorted in non-decreasing order) of positive numbers, find the smallest positive integer
   * value that cannot be represented as sum of elements of any subset of given set.
   * Expected time complexity is O(n).
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
   * 66.
   * Problem: Print All Distinct Elements of a given integer array.
   * Solution:
   */

  /**
   * 67.
   * Problem: Find common elements in three sorted arrays.
   * Solution:
   */

  /**
   * 68.
   * Problem: Length of the largest subarray with contiguous elements | Set 1.
   * Solution:
   */

  /**
   * 69.
   * Problem: Given a sorted array and a number x, find the pair in array whose sum is closest to x.
   * Solution:
   */

  /**
   * 70.
   * Problem: Find Index of 0 to be replaced with 1 to get longest continuous sequence of 1s in a binary array.
   * Solution:
   */

  /**
   * 71.
   * Problem: Nuts &#038; Bolts Problem (Lock &#038; Key problem).
   * Solution:
   */

  /**
   * 72.
   * Problem: Given a binary string, count number of substrings that start and end with 1..
   * Solution:
   */

  /**
   * 73.
   * Problem: Rearrange an array such that &#8216;arr[j]' becomes &#8216;i' if  &#8216;arr[i]' is &#8216;j'.
   * Solution:
   */

  /**
   * 74.
   * Problem: Delete an element from array (Using two traversals and one traversal).
   * Solution:
   */

  /**
   * 75.
   * Problem: Print missing elements that lie in range 0 &#8211; 99.
   * Solution:
   */

  /**
   * 76.
   * Problem: Pythagorean Triplet in an array.
   * Solution:
   */

  /**
   * 77.
   * Problem: Find Union and Intersection of two unsorted arrays.
   * Solution:
   */

  /**
   * 78.
   * Problem: Replace every array element by multiplication of previous and next.
   * Solution:
   */

  /**
   * 79.
   * Problem: Count frequencies of all elements in array in O(1) extra space and O(n) time.
   * Solution:
   */

  /**
   * 80.
   * Problem: Generate all possible sorted arrays from alternate elements of two given sorted arrays.
   * Solution:
   */

  /**
   * 81.
   * Problem: Find the largest three elements in an array.
   * Solution:
   */

  /**
   * 82.
   * Problem: Reverse an array upto a given position.
   * Solution:
   */

  /**
   * 83.
   * Problem: Minimum number of swaps required for arranging pairs adjacent to each other.
   * Solution:
   */

  /**
   * 84.
   * Problem: Trapping Rain Water.
   * Solution:
   */

  /**
   * 85.
   * Problem: Converting an array of integers into Zig-Zag fashion!.
   * Solution:
   */

  /**
   * 86.
   * Problem: Convert array into Zig-Zag fashion.
   * Solution:
   */

  /**
   * 87.
   * Problem: Find maximum average subarray of k length.
   * Solution:
   */

  /**
   * 88.
   * Problem: Program to print Sum Triangle for a given array.
   * Solution:
   */

  /**
   * 89.
   * Problem: Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed.
   * Solution:
   */

  /**
   * 90.
   * Problem: Reorder an array according to given indexes.
   * Solution:
   */

  /**
   * 91.
   * Problem: Check if a sorted array can be divided in pairs whose sum is k.
   * Solution:
   */

  /**
   * 92.
   * Problem: Find zeroes to be flipped so that number of consecutive 1's is maximized.
   * Solution:
   */

  /**
   * 93.
   * Problem: Count triplets with sum smaller than a  given value.
   * Solution:
   */

  /**
   * 94.
   * Problem: Find the subarray with least average.
   * Solution:
   */

  /**
   * 95.
   * Problem: Count Inversions of size three in a give array.
   * Solution:
   */

  /**
   * 96.
   * Problem: Longest Span with same Sum in two Binary arrays.
   * Solution:
   */

  /**
   * 97.
   * Problem: Merge two sorted arrays with O(1) extra space.
   * Solution:
   */

  /**
   * 98.
   * Problem: Form minimum number from given sequence.
   * Solution:
   */

  /**
   * 99.
   * Problem: Subarray/Substring vs Subsequence and Programs to Generate them.
   * Solution:
   */

  /**
   * 100.
   * Problem: Count Strictly Increasing Subarrays.
   * Solution:
   */

  /**
   * 101.
   * Problem: Rearrange an array in maximum minimum form | Set 1.
   * Solution:
   */

  /**
   * 102.
   * Problem: Find minimum difference between any two elements.
   * Solution:
   */

  /**
   * 103.
   * Problem: Find lost element from a duplicated array.
   * Solution:
   */

  /**
   * 104.
   * Problem: Count pairs with given sum.
   * Solution:
   */

  /**
   * 105.
   * Problem: Count minimum steps to get the given desired array.
   * Solution:
   */

  /**
   * 106.
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
   * 107.
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

  /**
   * 108.
   * Problem: Rearrange array in alternating positive &#038; negative items with O(1) extra space | Set 2.
   * Solution:
   */

  /**
   * 109.
   * Problem: Absolute distinct count in a sorted array.
   * Solution:
   */

  /**
   * 110.
   * Problem: Count pairs formed by distinct element sub-arrays.
   * Solution:
   */

  /**
   * 111.
   * Problem: Maximum product of a triplet (subsequnece of size 3) in array.
   * Solution:
   */

  /**
   * 112.
   * Problem: Pair with given product | Set 1 (Find if any pair exists).
   * Solution:
   */

  /**
   * 113.
   * Problem: Find smallest range containing elements from k lists.
   * Solution:
   */

  /**
   * 114.
   * Problem: Maximum absolute difference between sum of two contiguous sub-arrays.
   * Solution:
   */

  /**
   * 115.
   * Problem: Find number of subarrays with even sum.
   * Solution:
   */

  /**
   * 116.
   * Problem: Maximum value K such that array has at-least K elements that are >= K.
   * Solution:
   */

  /**
   * 117.
   * Problem: Minimum sum of two numbers formed from digits of an array.
   * Solution:
   */

  /**
   * 118.
   * Problem: Find frequency of each element in a limited range array in less than O(n) time.
   * Solution:
   */

  /**
   * 119.
   * Problem: Print all subarrays with 0 sum.
   * Solution:
   */

  /**
   * 120.
   * Problem: Find Surpasser Count of each element in array.
   * Solution:
   */

  /**
   * 121.
   * Problem: Remove duplicates from an array of small primes.
   * Solution:
   */

  /**
   * 122.
   * Problem: Replace every element with the least greater element on its right.
   * Solution:
   */

  /**
   * 123.
   * Problem: Maximum sum of i*arr[i] among all rotations of a given array.
   * Solution:
   */

  /**
   * 124.
   * Problem: Largest product of a subarray of size k.
   * Solution:
   */

  /**
   * 125.
   * Problem: Add elements of given arrays with given constraints.
   * Solution:
   */

  /**
   * 126.
   * Problem: Jolly Jumper Sequence.
   * Solution:
   */

  /**
   * 127.
   * Problem: Find if array can be divided into two subarrays of equal sum.
   * Solution:
   */

  /**
   * 128.
   * Problem: Find all triplets in a sorted array that forms Geometric Progression.
   * Solution:
   */

  /**
   * 129.
   * Problem: Maximum Product Subarray | Set 2 (Using Two Traversals).
   * Solution:
   */

  /**
   * 130.
   * Problem: Reverse an array in groups of given size.
   * Solution:
   */

  /**
   * 131.
   * Problem: Reverse an array in groups of given size | Set 2 (Variations of Set 1 ).
   * Solution:
   */

  /**
   * 132.
   * Problem: Third largest element in an array of distinct elements.
   * Solution:
   */

  /**
   * 133.
   * Problem: Find Two Missing Numbers | Set 1 (An Interesting Linear Time Solution).
   * Solution:
   */

  /**
   * 134.
   * Problem: Active and Inactive cells after k Days.
   * Solution:
   */

  /**
   * 135.
   * Problem: Maximize value of (arr[i] &#8211; i) &#8211; (arr[j] &#8211; j) in an array.
   * Solution:
   */

  /**
   * 136.
   * Problem: Maximize number of 0s by flipping a subarray.
   * Solution:
   */

  /**
   * 137.
   * Problem: Change if all bits can be made same by single flip.
   * Solution:
   */

  /**
   * 138.
   * Problem: Find minimum elements after considering all possible transformations.
   * Solution:
   */

  /**
   * 139.
   * Problem: Minimum Initial Energy Required To Cross Street.
   * Solution:
   */

  /**
   * 140.
   * Problem: Find Maximum value of abs(i &#8211; j) * min(arr[i], arr[j]) in an array arr[].
   * Solution:
   */

  /**
   * 141.
   * Problem: Check if an array can be Arranged in Left or Right Positioned Array.
   * Solution:
   */

  /**
   * 142.
   * Problem: Maximize array sum after K negations | Set 1.
   * Solution:
   */

  /**
   * 143.
   * Problem: Maximum and Minimum Product Subsets.
   * Solution:
   */

  /**
   * 144.
   * Problem: Emulating a 2-d array using 1-d array.
   * Solution:
   */

  /**
   * 145.
   * Problem: Sorted subsequence of size 3 in linear time using constant space.
   * Solution:
   */

  /**
   * 146.
   * Problem: Sum of subset differences.
   * Solution:
   */

  /**
   * 147.
   * Problem: Minimum steps to reach end of array under constraints.
   * Solution:
   */

  /**
   * 148.
   * Problem: Length of Longest sub-string that can be removed.
   * Solution:
   */

  /**
   * 149.
   * Problem: Sum of absolute differences of all pairs in a given array.
   * Solution:
   */

  /**
   * 150.
   * Problem: Smallest subarray whose sum is multiple of array size.
   * Solution:
   */

  /**
   * 151.
   * Problem: Count all pairs with given XOR.
   * Solution:
   */

  /**
   * 152.
   * Problem: Maximum sum of pairs with specific difference.
   * Solution:
   */

  /**
   * 153.
   * Problem: Minimum number of swaps required to sort an array.
   * Solution:
   */

  /**
   * 154.
   * Problem: Number of swaps to sort when only adjacent swapping allowed.
   * Solution:
   */

  /**
   * 155.
   * Problem: Find maximum difference between nearest left and right smaller elements.
   * Solution:
   */

  /**
   * 156.
   * Problem: Minimum swaps to make two arrays identical.
   * Solution:
   */

  /**
   * 157.
   * Problem: Find Equal (or Middle) Point in a sorted array with duplicates.
   * Solution:
   */

  /**
   * 158.
   * Problem: Sum of maximum elements of all subsets.
   * Solution:
   */

  /**
   * 159.
   * Problem: Find Maximum Sum Strictly Increasing Subarray.
   * Solution:
   */

  /**
   * 160.
   * Problem: Minimum delete operations to make all elements of array same.
   * Solution:
   */

  /**
   * 161.
   * Problem: Find Maximum XOR value of a sub-array of size k.
   * Solution:
   */

  /**
   * 162.
   * Problem: Find next Smaller of next Greater in an array.
   * Solution:
   */

  /**
   * 163.
   * Problem: Find elements larger than half of the elements in an array.
   * Solution:
   */

  /**
   * 164.
   * Problem: Maximize array sum after K negations | Set 2.
   * Solution:
   */

  /**
   * 165.
   * Problem: Maximum subsequence sum such that no three are consecutive.
   * Solution:
   */

  /**
   * 166.
   * Problem: Maximum distance between two occurrences of same element in array.
   * Solution:
   */

  /**
   * 167.
   * Problem: Elements before which no element is bigger in array.
   * Solution:
   */

  /**
   * 168.
   * Problem: Find the only repeating element in a sorted array of size n.
   * Solution:
   */

  /**
   * 169.
   * Problem: Minimum XOR Value Pair.
   * Solution:
   */

  /**
   * 170.
   * Problem: Count pairs in an array that hold i*arr[i] &gt; j*arr[j].
   * Solution:
   */

  /**
   * 171.
   * Problem: Count minimum number of &#8220;move-to-front&#8221; moves to sort an array.
   * Solution:
   */

  /**
   * 172.
   * Problem: Maximum product of an increasing subsequence of size 3.
   * Solution:
   */

  /**
   * 173.
   * Problem: Find bitonic point in given bitonic sequence.
   * Solution:
   */

  /**
   * 174.
   * Problem: Program to find the number of persons wearing white hat.
   * Solution:
   */

  /**
   * 175.
   * Problem: Sum of all elements between k1'th and k2'th smallest elements.
   * Solution:
   */

  /**
   * 176.
   * Problem: Arrays in Java.
   * Solution:
   */

  /**
   * 177.
   * Problem: Sort an array according to absolute difference with given value.
   * Solution:
   */

  /**
   * 178.
   * Problem: Subarrays with distinct elements.
   * Solution:
   */

  /**
   * 179.
   * Problem: Minimize the sum of product of two arrays with permutations allowed.
   * Solution:
   */

  /**
   * 180.
   * Problem: Move all negative elements to end in order with extra space allowed.
   * Solution:
   */

  /**
   * 181.
   * Problem: Position of an element after stable sort.
   * Solution:
   */

  /**
   * 182.
   * Problem: Steps to return to {1, 2, ..n} with specified movements.
   * Solution:
   */

  /**
   * 183.
   * Problem: Maximum sum subarray removing at most one element.
   * Solution:
   */

  /**
   * 184.
   * Problem: Maximum subarray size, such that all subarrays of that size have sum less than k.
   * Solution:
   */

  /**
   * 185.
   * Problem: Minimum flips in two binary arrays so that their XOR is equal to another array.
   * Solution:
   */

  /**
   * 186.
   * Problem: Number of full binary trees such that each node is product of its children.
   * Solution:
   */

  /**
   * 187.
   * Problem: Minimum sum subsequence such that at least one of every four consecutive elements is picked.
   * Solution:
   */

  /**
   * 188.
   * Problem: Chocolate Distribution Problem.
   * Solution:
   */

  /**
   * 189.
   * Problem: Sum of minimum and maximum elements of all subarrays of size k..
   * Solution:
   */

  /**
   * 190.
   * Problem: Subset sum queries using bitset.
   * Solution:
   */

  /**
   * 191.
   * Problem: Maximum path sum for each position with jumps under divisibility condition.
   * Solution:
   */

  /**
   * 192.
   * Problem: Check loop in array according to given constraints.
   * Solution:
   */

  /**
   * 193.
   * Problem: Sort even-placed elements in increasing and odd-placed in decreasing order.
   * Solution:
   */

  /**
   * 194.
   * Problem: Maximum occurred integer in n ranges.
   * Solution:
   */

  /**
   * 195.
   * Problem: Count of subarrays whose maximum element is greater than k.
   * Solution:
   */

  /**
   * 196.
   * Problem: Permute two arrays such that sum of every pair is greater or equal to K.
   * Solution:
   */

  /**
   * 197. Count all sub-arrays having sum divisible by k.
   * Solution:
   * 1. Create auxiliary hash array to count frequency of remainders.
   * 2. Compute cumulative sum and take remainder of this current cumulative sum and increase count by 1 for this
   * remainder in mod[] array.
   * 3. As the sum can be negative, taking modulo twice.
   * 4. If there are more than one prefix subarrays with a particular mod value.
   * 5. Add the elements which are divisible by k itself i.e., the elements whose sum = 0
   */
  int subArrayCount(int[] array, int k) {
    int sum = 0;
    int[] mod = new int[array.length];
    for (int elem : array) {
      sum += elem;
      mod[((sum % k) + k) % k]++;
    }
    int result = 0;
    for (int elem : mod) {
      if (elem > 0) result += (elem * (elem - 1)) / 2;
    }
    result += mod[0];
    return result;
  }

  /**
   * 198.
   * Problem: Chose k array elements such that difference of maximum and minimum is minimized.
   * Solution:
   */

  /**
   * 199.
   * Problem: Sort an array when two halves are sorted.
   * Solution:
   */

  /**
   * 200.
   * Problem: Find Maximum dot product of two arrays with insertion of 0's.
   * Solution: Done as 158 in DPExamples.
   */

  /**
   * 201.
   * Problem: Find element using minimum segments in Seven Segment Display.
   * A Seven Segment Display can be used to to display numbers. Given an array of n natural numbers. The task is to find
   * the number in the array which is using minimum segments to display number. If multiple numbers have a minimum number
   * of segments, output the number having the smallest index.
   * Solution:
   */
  int minSegments(int[] array) {
    int[] segments = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    int minSegments = Integer.MAX_VALUE;
    int result = array[0];
    for (int element : array) {
      int currentSegments = countSegments(element, segments, 0);
      if (currentSegments < minSegments) {
        result = element;
        minSegments = currentSegments;
      }
    }
    return result;
  }

  private int countSegments(int number, int[] segments, int count) {
    if (number < 10) return count + segments[number];
    else return countSegments(number / 10, segments, count + segments[number % 10]);
  }

  /**
   * 202.
   * Problem: Rearrange an array to minimize sum of product of consecutive pair elements.
   * Solution:
   */

  /**
   * 203.
   * Problem: Find a partition point in array.
   * Solution:
   */

  /**
   * 204.
   * Problem: Find pairs in array whose sums already exist in array.
   * Solution:
   */

  /**
   * 205.
   * Problem: Longest prefix that contains same number of X and Y in an array.
   * Solution:
   */

  /**
   * 206.
   * Problem: Find all elements in array which have at-least two greater elements.
   * Solution:
   */

  /**
   * 207.
   * Problem: Divide array into two sub-arrays such that their averages are equal.
   * Solution:
   */

  /**
   * 208.
   * Problem: Break an array into maximum number of sub-arrays such that their averages are same.
   * Solution:
   */

  /**
   * 209.
   * Problem: Check whether Arithmetic Progression can be formed from the given array.
   * Solution:
   */

  /**
   * 210.
   * Problem: Find three element from different three arrays such that that a + b + c = sum.
   * Solution:
   */

  /**
   * 211.
   * Problem: Find maximum array sum after making all elements same with repeated subtraction.
   * Solution:
   */

  /**
   * 212.
   * Problem: Pairs of Amicable Numbers.
   * Solution:
   */

  /**
   * 213.
   * Problem: Count of index pairs with equal elements in an array.
   * Solution:
   */

  /**
   * 214.
   * Problem: Make two sets disjoint by removing minimum elements.
   * Solution:
   */

  /**
   * 215.
   * Problem: Find a local minima in an array.
   * Solution:
   */

  /**
   * 216.
   * Problem: Three way partitioning of an array around a given range.
   * Solution:
   */

  /**
   * 217.
   * Problem: Find a subset with greatest geometric mean.
   * Solution:
   */

  /**
   * 218.
   * Problem: Sum of the products of all possible Subsets.
   * Solution:
   */

  /**
   * 219.
   * Problem: Duplicates in an array in O(n) and by using O(1) extra space | Set-2.
   * Solution:
   */

  /**
   * 220.
   * Problem: Find the missing number in Geometric Progression.
   * Solution:
   */

  /**
   * 221.
   * Problem: Range Queries for Frequencies of array elements.
   * Solution:
   */

  /**
   * 222.
   * Problem: Check if there exist two elements in an array whose sum is equal to the sum of rest of the array.
   * Solution:
   */

  /**
   * 223.
   * Problem: Sum of all Subarrays.
   * Solution:
   */

  /**
   * 224.
   * Problem: Constant time range add operation on an array.
   * Solution:
   */

  /**
   * 225.
   * Problem: Find all  triplets with zero sum.
   * Solution:
   */

  /**
   * 226.
   * Problem: Maximum consecutive one’s (or zeros) in a binary array.
   * Solution:
   */

  /**
   * 227.
   * Problem: Maximum sum of smallest and second smallest in an array.
   * Solution:
   */

  /**
   * 228.
   * Problem: Minimum operations required to remove an array.
   * Solution:
   */

  /**
   * 229.
   * Problem: Find duplicates under given constraints.
   * Solution:
   */

  /**
   * 230.
   * Problem: Find sum of sum of all sub-sequences.
   * Solution:
   */

  /**
   * 231.
   * Problem: Find first and last occurrences of an element in a sorted array.
   * Solution:
   */

  /**
   * 232.
   * Problem: Sum of XOR of all possible subsets.
   * Solution:
   */

  /**
   * 233.
   * Problem: Lexicographically smallest array after at-most K consecutive swaps.
   * Solution:
   */

  /**
   * 234.
   * Problem: Count all Quadruples from four arrays such that their XOR equals to &#8216;x'.
   * Solution:
   */

  /**
   * 235.
   * Problem: Rearrange an array in maximum minimum form | Set 2 (O(1) extra space).
   * Solution:
   */

  /**
   * 236.
   * Problem: Type of array and its maximum element.
   * Solution:
   */

  /**
   * 237.
   * Problem: Find floor and ceil in an unsorted array.
   * Solution:
   */

  /**
   * 238.
   * Problem: Subset with no pair sum divisible by K.
   * Solution:
   */

  /**
   * 239.
   * Problem: Sorting possible using size 3 subarray rotation.
   * Solution:
   */

  /**
   * 240.
   * Problem: Count passing car pairs.
   * Solution:
   */

  /**
   * 241.
   * Problem: A permutation where each element indicates either number of elements before or after it.
   * Solution:
   */

  /**
   * 242.
   * Problem: Sort array after converting elements to their squares.
   * Solution:
   */

  /**
   * 243.
   * Problem: Sort all even numbers in ascending order and then sort all odd numbers in descending order.
   * Solution:
   */

  /**
   * 244.
   * Problem: Find N'th item in a set formed by sum of two arrays.
   * Solution:
   */

  /**
   * 245.
   * Problem: Maximize sum of consecutive differences in a circular array.
   * Solution:
   */

  /**
   * 246.
   * Problem: Check if two arrays are equal or not.
   * Solution:
   */

  /**
   * 247.
   * Problem: Largest permutation after at most k swaps.
   * Solution:
   */

  /**
   * 248.
   * Problem: Find maximum (or minimum) sum of a subarray of size k.
   * Solution:
   */

  /**
   * 249.
   * Problem: Maximum value in an array after m range increment operations.
   * Solution:
   */

  /**
   * 250.
   * Problem: Given two unsorted arrays, find all pairs whose sum is x.
   * Solution:
   */

  /**
   * 251.
   * Problem: Largest divisible subset in array.
   * Solution:
   */

  /**
   * 252.
   * Problem: Construct an array from XOR of all elements of array except element at same index.
   * Solution:
   */

  /**
   * 253.
   * Problem: Find the element that appears once in an array where every other element appears twice.
   * Solution:
   */

  /**
   * 254.
   * Problem: Minimum difference between max and min of all K-size subsets.
   * Solution:
   */

  /**
   * 255.
   * Problem: Minimum swaps to reach permuted array with at most 2 positions left swaps allowed.
   * Solution:
   */

  /**
   * 256.
   * Problem: GCD of more than two (or array) numbers.
   * Solution:
   */

  /**
   * 257.
   * Problem: Fill an array based on frequency where elements are in range from 0 to n-1.
   * Solution:
   */

  /**
   * 258.
   * Problem: Convert an array to reduced form | Set 2 (Using vector of pairs).
   * Solution:
   */

  /**
   * 259.
   * Problem: Find all pairs (a,b) and (c,d) in array which satisfy ab = cd.
   * Solution:
   */

  /**
   * 260.
   * Problem: Search, insert and delete in an unsorted array.
   * Solution:
   */

  /**
   * 261.
   * Problem: Search, insert and delete in a sorted array.
   * Solution:
   */

  /**
   * 262.
   * Problem: XOR of all subarray XORs | Set 1.
   * Solution:
   */

  /**
   * 263.
   * Problem: Count pairs in a sorted array whose sum is less than x.
   * Solution:
   */

  /**
   * 264.
   * Problem: Split an array into two equal Sum subarrays.
   * Solution:
   */

  /**
   * 265.
   * Problem: Given pairwise sum of n numbers, find the numbers.
   * Solution:
   */

  /**
   * 266.
   * Problem: Find sum of non-repeating (distinct) elements in an array.
   * Solution:
   */

  /**
   * 267.
   * Problem: Minimum sum of absolute difference of pairs of two arrays.
   * Solution:
   */

  /**
   * 268.
   * Problem: Find original array from encrypted array (An array of sums of other elements).
   * Solution:
   */

  /**
   * 269.
   * Problem: Noble integers in an array (count of greater elements is equal to value).
   * Solution:
   */

  /**
   * 270.
   * Problem: Perfect Sum Problem (Print all subsets with given sum).
   * Solution:
   */

  /**
   * 271.
   * Problem: Window Sliding Technique.
   * Solution:
   */

  /**
   * 272.
   * Problem: Find Duplicates of array using bit array.
   * Solution:
   */

  /**
   * 273.
   * Problem: Place k elements such that minimum distance is maximized.
   * Solution:
   */

  /**
   * 274.
   * Problem: Count the number of subarrays having a given XOR.
   * Solution:
   */

  /**
   * 275.
   * Problem: Minimum toggles to partition a binary array so that it has first 0s then 1s.
   * Solution:
   */

  /**
   * 276.
   * Problem: Subsequence with maximum odd sum.
   * Solution:
   */

  /**
   * 277.
   * Problem: Count of arrays in which all adjacent elements are such that one of them divide the another.
   * Solution:
   */

  /**
   * 278.
   * Problem: Program to check if an array is sorted or not (Iterative and Recursive).
   * Solution:
   */

  /**
   * 279.
   * Problem: Program for average of an array (Iterative and Recursive).
   * Solution:
   */

  /**
   * 280.
   * Problem: Smallest Difference Triplet from Three arrays.
   * Solution:
   */

  /**
   * 281.
   * Problem: Find missing number in another array which is shuffled copy.
   * Solution:
   */

  /**
   * 282.
   * Problem: Prefix Sum Array &#8211; Implementation and Applications in Competitive Programming.
   * Solution:
   */

  /**
   * 283.
   * Problem: Largest sum contiguous increasing subarray.
   * Solution:
   */

  /**
   * 284.
   * Problem: Program to print an array in Pendulum Arrangement.
   * Solution:
   */

  /**
   * 285.
   * Problem: Smallest Difference pair of values between two unsorted Arrays.
   * Solution:
   */

  /**
   * 286.
   * Problem: Remove minimum elements from array such that no three consecutive element are either increasing or decreasing.
   * Solution:
   */

  /**
   * 287.
   * Problem: Find whether it is possible to make array elements same using one external number.
   * Solution:
   */

  /**
   * 288.
   * Problem: Clustering/Partitioning an array such that sum of square differences is minimum.
   * Solution:
   */

  /**
   * 289.
   * Problem: Maximum sum two non-overlapping subarrays of given size.
   * Solution:
   */

  /**
   * 290.
   * Problem: Find whether a subarray is in form of a mountain or not.
   * Solution:
   */

  /**
   * 291.
   * Problem: Program for multiplication of array elements.
   * Solution:
   */

  /**
   * 292.
   * Problem: Number of subarrays for which product and sum are equal.
   * Solution:
   */

  /**
   * 293.
   * Problem: Find duplicates in a given array when elements are not limited to a range.
   * Solution:
   */

  /**
   * 294.
   * Problem: Check if it is possible to sort an array with conditional swapping of adjacent allowed.
   * Solution:
   */

  /**
   * 295.
   * Problem: Count the number of ways to divide an array into three contiguous parts having equal sum.
   * Solution:
   */

  /**
   * 296.
   * Problem: k-th distinct (or non-repeating) element in an array..
   * Solution:
   */

  /**
   * 297.
   * Problem: Sort an array after applying the given equation.
   * Solution:
   */

  /**
   * 298.
   * Problem: Count number of ways to jump  to reach end.
   * Solution:
   */

  /**
   * 299.
   * Problem: Reverse an array without using subtract sign ‘-‘ anywhere in the code.
   * Solution:
   */

  /**
   * 300.
   * Problem: Check if product of every pair exists in an array.
   * Solution:
   */

  /**
   * 301.
   * Problem: Find k pairs with smallest sums in two arrays.
   * Solution:
   */

  /**
   * 302.
   * Problem: Largest subset whose all elements are Fibonacci numbers.
   * Solution:
   */

  /**
   * 303.
   * Problem: First element occurring k times in an array.
   * Solution:
   */

  /**
   * 304.
   * Problem: K-th Element of Two Sorted Arrays.
   * Solution:
   */

  /**
   * 305.
   * Problem: Count subsets having distinct even numbers.
   * Solution:
   */

  /**
   * 306.
   * Problem: Maximum difference between first and last indexes of an element in array.
   * Solution:
   */

  /**
   * 307.
   * Problem: Remove duplicates from sorted array.
   * Solution:
   */

  /**
   * 308.
   * Problem: Find index of an extra element present in one sorted array.
   * Solution:
   */

  /**
   * 309.
   * Problem: Merge two sorted arrays.
   * Solution:
   */

  /**
   * 310.
   * Problem: Sum of array elements using recursion.
   * Solution:
   */

  /**
   * 311.
   * Problem: Mean of array using recursion.
   * Solution:
   */

  /**
   * 312.
   * Problem: Number of buildings facing the sun.
   * Solution:
   */

  /**
   * 313.
   * Problem: k-th smallest absolute difference of two elements in an array.
   * Solution:
   */

  /**
   * 314.
   * Problem: Ways to sum to N using array elements with repetition allowed.
   * Solution:
   */

  /**
   * 315.
   * Problem: Find a Fixed Point in an array with duplicates allowed.
   * Solution:
   */

  /**
   * 316.
   * Problem: Largest sum subarray with at-least k numbers.
   * Solution:
   */

  /**
   * 317.
   * Problem: Fill array with 1's using minimum iterations of filling neighbors.
   * Solution:
   */

  /**
   * 318.
   * Problem: Find the minimum value to be added so that array becomes balanced.
   * Solution:
   */

  /**
   * 319.
   * Problem: Rearrange an array such that every odd indexed element is greater than it previous.
   * Solution:
   */

  /**
   * 320.
   * Problem: XOR of all subarray XORs | Set 2.
   * Solution:
   */

  /**
   * 321.
   * Problem: First negative integer in every window of size k.
   * Solution:
   */

  /**
   * 322.
   * Problem: Longest Subarray of non-negative Integers.
   * Solution:
   */

  /**
   * 323.
   * Problem: Minimum number of jumps to reach end | Set 2 (O(n) solution).
   * Solution:
   */

  /**
   * 324.
   * Problem: Sum of product of all pairs of array elements.
   * Solution:
   */

  /**
   * 325.
   * Problem: Maximum Length Bitonic Subarray | Set 2 (O(n) time and O(1) Space).
   * Solution:
   */

  /**
   * 326.
   * Problem: For each element in 1st array count elements less than or equal to it in 2nd array.
   * Solution:
   */

  /**
   * 327.
   * Problem: Count of smaller or equal elements in sorted array.
   * Solution:
   */

  /**
   * 328.
   * Problem: Minimum sum of two elements from two arrays such that indexes are not same.
   * Solution:
   */

  /**
   * 329.
   * Problem: Count minimum right flips to set all values in an array.
   * Solution:
   */

  /**
   * 330.
   * Problem: Find Second largest element in an array.
   * Solution:
   */

  /**
   * 331.
   * Problem: Sum of minimum absolute difference of each array element.
   * Solution:
   */

  /**
   * 332.
   * Problem: Count elements less than or equal to a given value in a sorted rotated array.
   * Solution:
   */

  /**
   * 333.
   * Problem: Maximizing Unique Pairs from two arrays.
   * Solution:
   */

  /**
   * 334.
   * Problem: Maximum modulo of in all the pairs of array where arr[i] &gt;= arr[j].
   * Solution:
   */

  /**
   * 335.
   * Problem: Find start and ending index of an element in an unsorted array.
   * Solution:
   */

  /**
   * 336.
   * Problem: Find the transition point in a binary array.
   * Solution:
   */

  /**
   * 337.
   * Problem: Recursive Programs to find Minimum and Maximum elements of array.
   * Solution:
   */

  /**
   * 338.
   * Problem: Program to print Sum of even and odd elements in an array.
   * Solution:
   */

  /**
   * 339.
   * Problem: Find minimum value to assign all array elements so that array product becomes greater.
   * Solution:
   */

  /**
   * 340.
   * Problem: Count subarrays having total distinct elements same as original array.
   * Solution:
   */

  /**
   * 341.
   * Problem: Search an element in an unsorted array using minimum number of comparisons.
   * Solution:
   */

  /**
   * 342.
   * Problem: Number of pairs in an array such that product is greater than sum.
   * Solution:
   */

  /**
   * 343.
   * Problem: Count pairs from two sorted arrays whose sum is equal to a given value x.
   * Solution:
   */

  /**
   * Maximum sum of not necessarily contigous array for a non empty array.
   */
  int maxSumNonContigous(int [] array) {
    int maxSum = 0, leastNeg = Integer.MIN_VALUE, negCount = 0;
    for (int elem : array) {
      if (elem > 0) maxSum += elem;
      else {
        negCount++;
        if (elem > leastNeg) leastNeg = elem;
      }
    }
    if (negCount == array.length) return leastNeg;
    else return maxSum;
  }

  /**
   * 7.
   * Problem: Find the Missing Number.
   * You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates
   * in list. One of the integers is missing in the list.
   * Write an efficient code to find the missing integer.
   * Solution: Use sum formulae or XOR operator.
   */
  int findMissingNumber(int[] list, int n) {
    int x1 = Arrays.stream(list).reduce(0, (a, b) -> a ^ b);
    int x2 = 0;
    for (int i = 1; i <= n; i++) x2 ^= i;
    return x1 ^ x2;
  }

 /**
   * 10.
   * Problem: Median of two sorted arrays.
   * Solution: Either merge two arrays which will take O(m + n) or use divide and conquer by getting
   * medians of each array and comparing till they are equal. O(logn).
   */

  /**
   * 18.
   * Problem: Count Inversions in an array.
   * Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already
   * sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
   * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
   * Solution: Use BST. Count of left children gives number of inversions of that element.
   */

  /**
   * 30.
   * Problem: Find the two repeating elements in a given array.
   * You are given an array of n+2 elements. All elements of the array are in range 1 to n. And all elements occur
   * once except two numbers which occur twice. Find the two repeating numbers.
   * Solution: Let the repeating numbers be X and Y, if we xor all the elements in the array and all integers from
   * 1 to n, then the result is X xor Y. The 1’s in binary representation of X xor Y is corresponding to the
   * different bits between X and Y. Suppose that the kth bit of X xor Y is 1, we can xor all the elements in the
   * array and all integers from 1 to n, whose kth bits are 1. The result will be one of X and Y.
   */

  /**
   * 33.
   * Problem: Find duplicates in O(n) time and O(1) extra space.
   * Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any
   * number of times. Find these repeating numbers in O(n) and using only constant memory space.
   * Solution: Use the array itself as a hash map and mark the index corresponding to the element as negative.
   */

  /**
   * 34.
   * Problem: Equilibrium index of an array.
   * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum
   * of elements at higher indexes.
   * Solution: Initialize left sum as 0 and right sum as sum of all elements. Scan from left to right and keep
   * updating sums till they are equal.
   */

  /**
   * 41.
   * Problem: Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
   * Solution : Create LeftMin and RightMax
   * Compare both array at each index and update maxDiff.
   * 34 1 2 10
   */
  int maxDiffArray(int[] arr) {
    int maxDiff = -1, x = 0, y = 0;
    int[] leftMin = new int[arr.length];
    int[] rightMax = new int[arr.length];
    leftMin[0] = arr[0];
    for (int i = 1; i < arr.length; i++) leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
    rightMax[arr.length - 1] = arr[arr.length - 1];
    for (int i = arr.length - 2; i >=0; i--) rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
    while (x < arr.length && y < arr.length) {
      if (arr[x] < arr[y]) {
        maxDiff = Math.max(maxDiff, y - x);
        y++;
      }
      else x++;
    }
    return maxDiff;
  }

  /**
   * 49.
   * Problem: Find a Fixed Point in a given array.
   * Given an array of n distinct integers sorted in ascending order, write a function that returns a Fixed Point
   * in the array, if there is any Fixed Point present in array, else returns -1. Fixed Point in an array is an
   * index i such that arr[i] is equal to i. Note that integers in array can be negative.
   * Solution: Use binary search.
   */

  /**
   * 52.
   * Problem: Count smaller elements on right side.
   * Write a function to count number of smaller elements on right of each element in an array. Given an unsorted
   * array arr[] of distinct integers, construct another array countSmaller[] such that countSmaller[i] contains
   * count of smaller elements on right side of each element arr[i] in array.
   * Solution: Use self balancing BST.
   */

  /**
   * 55. Find sub array with given sum
   */

  /**
   * 63.
   * Problem: Find a sorted subsequence of size 3 in linear time.
   * Given an array of n integers, find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time.
   * If there are multiple such triplets, then print any one of them.
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
   * 65.
   * Problem: Partition problem.
   * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of
   * elements in both subsets is same.
   * Solution:
   * Method 1: Recursive solution with Time Complexity as O(2^n).
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
   * 66.
   * Problem: Maximum Product Subarray.
   * Given an array that contains both positive and negative integers, find the product of the maximum product
   * subarray. Expected Time complexity is O(n) and only O(1) extra space can be used.
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
   * 73.
   * Problem: Maximum circular subarray sum
   * Given n numbers (both +ve and -ve), arranged in a circle, fnd the maximum sum of consecutive number.
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
    withoutCircleSum = new DPExamples().maxContinousSubArray(arr);
    for (int i = 0; i < arr.length; i++) {
      totalSum += arr[i];
      arr[i] = - arr[i];
    }
    circularSum = totalSum + new DPExamples().maxContinousSubArray(arr);
    return Math.max(withoutCircleSum, circularSum);
  }

  /**
   * 85.
   * Problem: Tug of War
   * Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of
   * two subsets is as minimum as possible. If n is even, then sizes of two subsets must be strictly n/2 and if n is
   * odd, then size of one subset must be (n-1)/2 and size of other subset must be (n+1)/2.
   * Solution: Try every possible subset of half size. If one subset of half size is formed, the remaining elements
   * form the other subset. We check whether this solutions is better than the best solution available so far.
   * If it is, then we update the best solution.
   */

  /**
   * 99.
   * Problem: Stable Marriage Problem.
   * Given N men and N women, where each person has ranked all members of the opposite sex in order of preference,
   * marry the men and women together such that there are no two people of opposite sex who would both rather have
   * each other than their current partners. If there are no such people, all the marriages are “stable”.
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
   * 102.
   * Problem: Move all zeroes to end of array.
   * Given an array of random numbers, Push all the zero’s of a given array to the end of the array.
   * For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to
   * {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same. Expected time complexity is
   * O(n) and extra space is O(1).
   *
   * Solution: Scan from left to right and keep track of last non zero index i, insert next non zero element at i+1.
   */

  /**
   * 123.
   * Problem: Find position of an element in a sorted array of infinite numbers.
   * Solution: Use modified binary search.
   * Let low be pointing to 1st element and high pointing to 2nd element of array. Now compare key with high
   * index element:
   * ->if it is greater than high index element then copy high index in low index and double the high index.
   * ->if it is smaller, then apply binary search on high and low indices found.
   */

  /**
   * 125.
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
   * 132.
   * Problem: Pythagorean Triplet in an array.
   * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies
   * a2 + b2 = c2.
   * Solution:
   * 1) Do square of every element in input array. This step takes O(n) time.
   * 2) Sort the squared array in increasing order. This step takes O(nLogn) time.
   * 3) To find a triplet (a, b, c) such that a = b + c, fix a as last element and search b and c in between first
   *    element and a. We can use left and right pointers for this.
   */

  /**
   * 136.
   * Problem: Trapping Rain Water
   * Given n non-negative integers representing an elevation map where the width of each bar
   * is 1, compute how much water it is able to trap after raining.
   * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
   */
  int rainWater(int[] array) {
    int[] left = new int[array.length];
    left[0] = array[0];
    for (int i = 1; i < array.length; i++) left[i] = Math.max(left[i-1], array[i]);
    int[] right = new int[array.length];
    right[array.length - 1] = array[array.length - 1];
    for (int i = array.length - 2; i >= 0 ; i--) right[i] = Math.max(right[i+1], array[i]);

    int water = 0;
    for(int i = 0; i < array.length; i++) water += Math.min(left[i], right[i]) - array[i];
    return water;
  }

  /**
   * 138.
   * Problem: Find maximum average subarray of k length
   * Given an array with positive and negative numbers, find the maximum average subarray of given length.
   * Example:
   * Input: arr[] = {1, 12, -5, -6, 50, 3}, k = 4
   * Output: Maximum average subarray of length 4 begins at index 1.
   */
  int maxAverage(int[] array, int k) {
    int currMax = Arrays.stream(array).limit(k).sum();
    int max = 0; int index = 0;
    int windowL;
    int windowR = k - 1;
    for (windowL = 0; windowL <= array.length - k; windowL++) {
      currMax -= array[windowL];
      currMax += array[++windowR];
      if (currMax > max) {
        max = currMax;
        index = windowL;
      }
    }
    return index;
  }

  /**
   * 139.
   * Problem: Convert array into Zig-Zag fashion.
   * Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time.
   * The converted array should be in form a < b > c < d > e < f.
   * Solution: Scan left to right and swap at odd and even places according to condition given above.
   */

  /**
   * 141.
   * Problem: Given a binary array and an integer k, find the position of zeroes flipping which creates maximum
   * number of consecutive 1s in array.
   */

  int maxLength(int[] array, int k) {
    int windowR = 0, windowL = 0, maxLength = 0, zeroesFlipped = 0;
    while (windowR < array.length) {
      if ((zeroesFlipped < k || array[windowR] == 1) && windowR < array.length) {
        if (array[windowR] == 0) zeroesFlipped++;
        windowR++;
      }
      else {
        maxLength = Math.max(maxLength, windowR - windowL);
        if (windowL < array.length && array[windowL] == 0) zeroesFlipped--;
        windowL++;
      }
    }
    return maxLength;
  }

  /**
   * 143. Find minimum average subarray of k length.
   */

  /**
   * 144.
   * Problem: Count triplets with sum smaller than a given value.
   * Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value.
   * Expected Time Complexity is O(n^2).
   * Solution: Sort and then use duplet algo.
   */

  /**
   * 147. Longest Span with same Sum in two Binary arrays.
   */

  /**
   * 148.
   * Problem: Merge two sorted arrays with O(1) extra space.
   * We are given two sorted array. We need to merge these two arrays such that the initial numbers
   * (after complete sorting) are in the first array and the remaining numbers are in the second array.
   * Extra space allowed in O(1).
   * Solution: Assume two arrays to be continous single array and use insertion sort logic.
   */

  /**
   * 149. Form minimum number from given sequence.
   */

  /**
   * 150.
   * Problem: Subarray/Substring vs Subsequence and Programs to Generate them.
   * Solution: In general, for an array/string of size n, there are n*(n+1)/2 non-empty subarrays/subsrings. We can
   * generate all by sliding window algo.
   * More generally, we can say that for a sequence of size n, we can have (2n-1) non-empty sub-sequences in total.
   * Every subarray is a subsequence. More specifically, Subsequence is a generalization of substring.
   * Subsequences are in fact subsets except for empty set.
   */

  /**
   * 151.
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
   * 152.
   * Problem: Rearrange an array in maximum minimum form.
   * Given a sorted array of positive integers, rearrange the array alternately i.e first element should be maximum
   * value, second minimum value, third second max, fourth second min and so on.
   * Solution: With extra space it can be easily done using two pointers. For in place, use below :
   * Output index j for an element arr[i]
   * If (i < n/2) j = 2*i + 1
   * Else j = 2*(n-1-i);
   * The idea is to use the fact that numbers are positive. One by one place numbers at their correct positions
   * and mark them negative.
   */

  /**
   * 153.
   * Problem: Find minimum difference between any two elements.
   * Given an unsorted array, find the minimum difference between any pair in given array.
   * Solution: Sort and then compare adjacent elements.
   * Time Complexity: O(n.log(n))
   */

  /**
   * 154.
   * Problem: Find lost element from a duplicated array.
   * Given two arrays which are duplicates of each other except one element, that is one element
   * from one of the array is missing, we need to find that missing element.
   * Solution: If elements are sorted, use modified binary search starting with bigger array.
   * Otherwise, use XOR operator.
   */

  /**
   * 155.
   * Problem: Count pairs with given sum.
   * Solution: Use hash set. Result will be count/2.
   */

  /**
   * 156.
   * Problem: Count minimum steps to get the given desired array.
   * Consider an array with n elements and value of all the elements is zero.
   * We can perform following operations on the array.
   * 1. Incremental operations:Choose 1 element from the array and increment its value by 1.
   * 2. Doubling operation: Double the values of all the elements of array.
   * Solution: The idea is to follow reverse steps, i.e. to convert target to array of zeros.
   */

  /**
   * Problem: Candies distribution
   * There are N children standing in a line. Each child is assigned a rating value.
   * You are giving candies to these children subjected to the following requirements:
   * 1. Each child must have at least one candy.
   * 2. Children with a higher rating get more candies than their neighbors.
   */
  int countCandies(int[] ratings) {
    int[] candies = new int[ratings.length];
    Arrays.fill(candies,1);
    for (int i = 1; i < candies.length; i++)
      if (ratings[i - 1] < ratings[i]) candies[i] = Math.max(candies[i-1] + 1, candies[i]);
    for (int i = ratings.length - 2; i >= 0; i--)
      if (ratings[i] > ratings[i+1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
    return Arrays.stream(candies).sum();
  }

}
