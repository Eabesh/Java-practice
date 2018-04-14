package data.structures.arrays;

import algorithms.dynamic.programming.DPExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class ArrayExamples {

  /**
   * 1. Problem: Given an array A[] and a number x, check for pair in A[] with sum as x. Solution:
   * Use sorting and use left and right pointers. Or Use hash map : 1) Initialize Binary Hash Map
   * M[] = {0, 0, ...} 2) Do following for each element A[i] in A[] (a) If M[x - A[i]] is set then
   * print the pair (A[i], x - A[i]) (b) Set M[A[i]].
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
   * 2. Problem: Majority Element: A majority element in an array A[] of size n is an element that
   * appears more than n/2 times (and hence there is at most one such element). Solution: Using BST:
   * Insert elements in BST one by one and if an element is already present then increment the count
   * of the node. At any stage, if count of a node becomes more than n/2 then return. Moore's voting
   * algorithm. 1. Find candidate. 2. Check if this candidate is majority element.
   */

  /**
   * 3. Problem: Find the Number Occurring Odd Number of Times. Given an array of positive integers.
   * All numbers occur even number of times except one number which occurs odd number of times. Find
   * the number in O(n) time & constant space. Solution: Use XOR operator.
   */
  int getOddOccurrenceWithLambda(int[] array) {
    return Arrays.stream(array).reduce(0, (a, b) -> a ^ b);
  }

  int getOddOccurrence(int[] array) {
    int accumulator = 0;
    for (int elem : array) accumulator ^= elem;
    return accumulator;
  }

  /**
   * 4. Problem: Search an element in a sorted and rotated array. Solution: Use modified binary
   * search. 1) Find middle point mid = (l + h)/2 2) If key is present at middle point, return mid.
   * 3) Else If arr[l..mid-1] is sorted a) If key to be searched lies in range from arr[l] to
   * arr[mid], recur for arr[l..mid]. b) Else recur for arr[mid+1..r] 4) Else (arr[mid+1..r] must be
   * sorted) a) If key to be searched lies in range from arr[mid+1] to arr[r], recur for
   * arr[mid+1..r]. b) Else recur for arr[l..mid]
   */
  public int binarySearchRotated(int[] array, int key, int beginIndex, int endIndex) {
    if (beginIndex <= endIndex) {
      int mid = beginIndex + (endIndex - beginIndex) / 2;
      if (array[mid] == key) return mid;
      else {
        if (array[beginIndex] <= array[mid]) {
          if (key >= array[beginIndex] && key <= array[mid])
            return binarySearchRotated(array, key, beginIndex, mid - 1);
          else return binarySearchRotated(array, key, mid + 1, endIndex);
        } else {
          if (key >= array[mid] && key <= array[endIndex])
            return binarySearchRotated(array, key, mid + 1, endIndex);
          else return binarySearchRotated(array, key, beginIndex, mid - 1);
        }
      }
    }
    return -1;
  }

  /**
   * 5. Problem: Merge an array of size n into another array of size m+n. There are two sorted
   * arrays. First one is of size m+n containing only m elements. Another one is of size n and
   * contains n elements. Merge these two arrays into the first array of size m+n such that the
   * output is sorted. Solution: Move all elements together in one pass. Then fill up bigger array
   * using two pointers starting from right and moving to left.
   */
  int[] mergeArray(int[] arr1, int[] arr2) {
    int arr1Last = arr1.length - 1;
    int arr2Last = arr2.length - arr1.length - 1;
    int last = arr2.length - 1;
    while (arr2Last >= 0 && arr1Last >= 0) {
      if (arr2[arr2Last] > arr1[arr1Last]) arr2[last--] = arr2[arr2Last--];
      else arr2[last--] = arr1[arr1Last--];
    }
    while (arr1Last >= 0) arr2[last--] = arr1[arr1Last--];
    return arr2;
  }

  /**
   * 6. Problem: Write a program to reverse an array or string Solution: Either use two pointer and
   * swap iteratively or use stack frame in recursion to store elements and reverse the array in
   * place.
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

  /** 7. Problem: Program for array rotation. Solution: Use temp array or reversal algorithm. */

  /**
   * 8. Problem: Program for array rotation using reversal algo. Solution: Let AB are the two parts
   * of the input array. Reverse A and B. Reverse all to get BA.
   */
  void rotateArray(int[] array, int pivot) {
    reverseArray(array, 0, pivot);
    reverseArray(array, pivot + 1, array.length - 1);
    reverseArray(array, 0, array.length - 1);
  }

  /** 9. Problem: Block swap algo for rotation. */

  /**
   * 10. Problem: Maximum sum such that no two elements are adjacent. Given an array of positive
   * numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the
   * sequence should be adjacent in the array.
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
   * 11. Problem: Leaders in an array. An element is leader if it is greater than all the elements
   * to its right side. And the rightmost element is always a leader. Solution: Scan all the
   * elements from right to left in array and keep track of maximum till now. When maximum changes
   * it’s value, print it as it is a leader.
   */

  /**
   * 12. Problem: Sort elements by frequency. Solution: Use hash map and then sort by frequency. Or
   * use modified BST with count field.
   */

  /**
   * 13. Problem: Two elements whose sum is closest to zero. An Array of integers is given, both +ve
   * and -ve. You need to find the two elements such that their sum is closest to zero. Solution:
   * Sort the elements. Use left and right pointer. Add them and if sum < 0, l++ else r--.
   */

  /**
   * 14. Problem: Find the smallest and second smallest element in an array. Solution: 1) Initialize
   * both first and second smallest as INT_MAX first = second = INT_MAX. 2) Loop through all the
   * elements. a) If the current element is smaller than first, then update first and second. b)
   * Else if the current element is smaller than second then update second. Or use heap which will
   * take O(k.logn).
   */

  /**
   * 15. Problem: Check for Majority Element in a sorted array. Find if a given integer x appears
   * more than n/2 times in a sorted array of n integers. Solution: Use modified binary search to
   * find start and end index of element.
   */

  /**
   * 16. Segregate 0s and 1s in an array. Solution: Count 0s and fill array with 0s and remaining
   * with 1s.
   */

  /**
   * 17. k largest(or smallest) elements in an array. Solution: 1. Use Bubble k times. O(nk) 2. Use
   * Max Heap. Build a Max Heap tree in O(n)and use Extract Max k times to get k maximum elements.
   * O(n + klogn)
   */

  /**
   * 18. Problem: Maximum difference between two elements such that larger element appears after the
   * smaller element.
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

  /** 19. Problem: Union and Intersection of two sorted arrays. Solution: */
  ArrayList<Integer> arrayUnion(
      int[] array1, int index1, int[] array2, int index2, ArrayList<Integer> union) {
    if (index1 == array1.length && index2 < array2.length) {
      for (int i = 0; i < index2; i++) union.add(array2[i]);
      return union;
    } else if (index2 == array2.length && index1 < array1.length) {
      for (int i = 0; i < index1; i++) union.add(array1[i]);
      return union;
    } else if (index1 == array1.length && index2 == array2.length) return union;
    else {
      if (array1[index1] < array2[index2]) {
        union.add(array1[index1]);
        return arrayUnion(array1, index1 + 1, array2, index2, union);
      } else if (array1[index1] > array2[index2]) {
        union.add(array2[index2]);
        return arrayUnion(array1, index1, array2, index2 + 1, union);
      } else {
        union.add(array1[index1]);
        return arrayUnion(array1, index1 + 1, array2, index2 + 1, union);
      }
    }
  }

  ArrayList<Integer> arrayIntersection(
      int[] array1, int index1, int[] array2, int index2, ArrayList<Integer> intersection) {
    if (index1 == array1.length || index2 == array2.length) return intersection;
    else {
      if (array1[index1] == array2[index2]) {
        intersection.add(array1[index1]);
        return arrayIntersection(array1, index1 + 1, array2, index2 + 1, intersection);
      } else if (array1[index1] < array2[index2])
        return arrayIntersection(array1, index1 + 1, array2, index2, intersection);
      else return arrayIntersection(array1, index1, array2, index2 + 1, intersection);
    }
  }

  /**
   * 20. Problem: A Product Array Puzzle. Given an array arr[] of n integers, construct a Product
   * Array prod[] (of same size) such that prod[i] is equal to the product of all the elements of
   * arr[] except arr[i]. Solve it without division operator and in O(n). Solution: 1) Construct a
   * temporary array left[] such that left[i] contains product of all elements on left of arr[i]
   * excluding arr[i]. 2) Construct another temporary array right[] such that right[i] contains
   * product of all elements on on right of arr[i] excluding arr[i]. 3) To get prod[], multiply
   * left[] and right[].
   */

  /** 21. Problem: Segregate Even and Odd numbers. Solution: */

  /**
   * 22. Problem: Find the two repeating elements in a given array. You are given an array of n+2
   * elements. All elements of the array are in range 1 to n. And all elements occur once except two
   * numbers which occur twice. Find the two repeating numbers. Solution: Let the repeating numbers
   * be X and Y, if we xor all the elements in the array and all integers from 1 to n, then the
   * result is X xor Y. The 1’s in binary representation of X xor Y is corresponding to the
   * different bits between X and Y. Suppose that the kth bit of X xor Y is 1, we can xor all the
   * elements in the array and all integers from 1 to n, whose kth bits are 1. The result will be
   * one of X and Y.
   */

  /**
   * 23. Problem: Find duplicates in O(n) time and O(1) extra space | Set 1. Given an array of n
   * elements which contains elements from 0 to n-1, with any of these numbers appearing any number
   * of times. Find these repeating numbers in O(n) and using only constant memory space. Solution:
   * Use the array itself as a hash map and mark the index corresponding to the element as negative.
   */

  /**
   * 24. Problem: Equilibrium index of an array. Equilibrium index of an array is an index such that
   * the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
   * Solution: Initialize left sum as 0 and right sum as sum of all elements. Scan from left to
   * right and keep updating sums till they are equal.
   */

  /** 25. Problem: Linked List vs Array. Solution: */

  /** 26. Problem: Check if array elements are consecutive | Added Method 3. Solution: */

  /** 27. Problem: Find the smallest missing number. Solution: */

  /**
   * 28. Problem: Given an array arr[], find the maximum j - i such that arr[j] > arr[i]. Solution :
   * Create LeftMin and RightMax Compare both array at each index and update maxDiff. 34 1 2 10
   */
  int maxDiffArray(int[] arr) {
    int maxDiff = -1, x = 0, y = 0;
    int[] leftMin = new int[arr.length];
    int[] rightMax = new int[arr.length];
    leftMin[0] = arr[0];
    for (int i = 1; i < arr.length; i++) leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
    rightMax[arr.length - 1] = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
    while (x < arr.length && y < arr.length) {
      if (arr[x] < arr[y]) {
        maxDiff = Math.max(maxDiff, y - x);
        y++;
      } else x++;
    }
    return maxDiff;
  }

  /** 29. Problem: Find the minimum distance between two numbers. Solution: */

  /** 30. Problem: Maximum Length Bitonic Subarray | Set 1 (O(n) tine and O(n) space). Solution: */

  /**
   * 31. Problem: Count smaller elements on right side. Write a function to count number of smaller
   * elements on right of each element in an array. Given an unsorted array arr[] of distinct
   * integers, construct another array countSmaller[] such that countSmaller[i] contains count of
   * smaller elements on right side of each element arr[i] in array. Solution: Use self balancing
   * BST.
   */

  /**
   * 32. Problem: Find subarray with given sum | Set 1 (Nonnegative Numbers). Solution: Use two
   * pointers like sliding window.
   */
  boolean findSubArrayWithSum(int[] array, int sum) {
    int currentSum = array[0], windowL = 0;
    for (int windowR = 1; windowR <= array.length; windowR++) {
      if (currentSum == sum) return true;
      else if (windowR < array.length) currentSum += array[windowR];
      while (currentSum < sum && windowL < windowR - 1) {
        currentSum -= array[windowL];
        windowL++;
      }
    }
    return false;
  }

  /** 33. Problem: Longest Increasing Subsequence Size (N log N). Solution: */

  /** 34. Problem: Find a triplet that sum to a given value. Solution: */

  /**
   * 35. Problem: Find the smallest positive number missing from an unsorted array | Set 1.
   * Solution:
   */

  /** 36. Problem: Find the two numbers with odd occurrences in an unsorted array. Solution: */

  /**
   * 37. Problem: Find a sorted subsequence of size 3 in linear time. Given an array of n integers,
   * find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time. If there are
   * multiple such triplets, then print any one of them. Solution: 1) Create an auxiliary array
   * smaller[0..n-1]. smaller[i] should store the index of a number which is smaller than arr[i] and
   * is on left side of arr[i]. smaller[i] should contain -1 if there is no such element. 2) Create
   * another auxiliary array greater[0..n-1]. greater[i] should store the index of a number which is
   * greater than arr[i] and is on right side of arr[i]. greater[i] should contain -1 if there is no
   * such element. 3) Finally traverse both smaller[] and greater[] and find the index i for which
   * both smaller[i] and greater[i] are not -1.
   */
  int sortedSequence(int[] array) {
    int[] smaller = new int[array.length];
    smaller[0] = -1;
    int min = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[min]) smaller[i] = min;
      else {
        min = i;
        smaller[i] = -1;
      }
    }
    int[] greater = new int[array.length];
    greater[array.length - 1] = -1;
    int max = array.length - 1;
    for (int j = array.length - 2; j <= 0; j--) {
      if (array[j] < array[max]) greater[j] = max;
      else {
        max = j;
        greater[j] = -1;
      }
    }
    for (int i = 0; i < array.length; i++) if (smaller[i] != -1 && greater[i] != -1) return i;
    return -1;
  }

  /** 38. Problem: Largest subarray with equal number of 0s and 1s. Solution: */

  /**
   * 39. Problem: Maximum Product Subarray. Given an array that contains both positive and negative
   * integers, find the product of the maximum product subarray. Expected Time complexity is O(n)
   * and only O(1) extra space can be used. Solution: This is similar to maximum subarray. Unlike
   * sum, the sign of number affect the product value. When iterating the array, each element has
   * two possibilities: positive number or negative number. We need to track a minimum value, so
   * that when a negative number is given, it can also find the maximum value. We define two local
   * variables, one tracks the maximum and the other tracks the minimum.
   */
  int maxProduct(int[] nums) {
    int[] max = new int[nums.length];
    int[] min = new int[nums.length];
    max[0] = min[0] = nums[0];
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > 0) {
        max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
        min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
      } else {
        max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
        min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
      }
      result = Math.max(result, max[i]);
    }
    return result;
  }

  /** 40. Problem: Replace every element with the greatest element on right side. Solution: */

  /** 41. Problem: Find four elements that sum to a given value | Set 1 (n^3 solution). Solution: */

  /**
   * 42. Problem: Find four elements that sum to a given value | Set 2 ( O(n^2Logn) Solution).
   * Solution:
   */

  /**
   * 43. Problem: Maximum circular subarray sum. Given n numbers (both +ve and -ve), arranged in a
   * circle, fnd the maximum sum of consecutive number. Solution: Wrapping of contributing elements
   * implies non wrapping of non contributing elements, so find out the sum of non contributing
   * elements and subtract this sum from the total sum. To find out the sum of non contributing,
   * invert sign of each element and then run Kadane’s algorithm. Two cases 1. Simple contigious
   * subaraay sum. 2. contigious sum with ring. (remove chains of negative numbers : total sum -
   * (-invert number and find sum) return Marx(1, 2)
   */
  int maxSumCircularSubarray(int[] arr) {
    int totalSum = 0, withoutCircleSum = 0, circularSum = 0;
    withoutCircleSum = new DPExamples().maxContiguousSubArray(arr);
    for (int i = 0; i < arr.length; i++) {
      totalSum += arr[i];
      arr[i] = -arr[i];
    }
    circularSum = totalSum + new DPExamples().maxContiguousSubArray(arr);
    return Math.max(withoutCircleSum, circularSum);
  }

  /** 44. Problem: Count the number of possible triangles. Solution: */

  /** 45. Problem: Construction of Longest Increasing Subsequence (N log N). Solution: */

  /** 46. Problem: Arrange given numbers to form the biggest number. Solution: */

  /** 47. Problem: Merge Overlapping Intervals. Solution: */

  /** 48. Problem: Find the maximum repeating number in O(n) time and O(1) extra space. Solution: */

  /** 49. Problem: Stock Buy Sell to Maximize Profit. Solution: */

  /**
   * 50. Problem: Rearrange positive and negative numbers in O(n) time and O(1) extra space.
   * Solution:
   */

  /**
   * 51. Problem: Find the Increasing subsequence of length three with maximum product. Solution:
   */

  /**
   * 52. Problem: Move all zeroes to end of array. Given an array of random numbers, Push all the
   * zero’s of a given array to the end of the array. For example, if the given arrays is {1, 9, 8,
   * 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order
   * of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).
   * Solution: Scan from left to right and keep track of last non zero index i, insert next non zero
   * element at i + 1.
   */

  /** 53. Problem: Program to find sum of elements in a given array. */
  int _arraySum(int[] array) {
    return arraySum(array, 0, 0);
  }

  /**
   * 54. Problem: Rearrange an array so that arr[i] becomes arr[arr[i]] with O(1) extra space.
   * Solution:
   */

  /**
   * 55. Problem: Count all possible groups of size 2 or 3 that have sum as multiple of 3. Solution:
   */

  /** 56. Problem: Find the number of zeroes. Solution: */

  /** 57. Problem: Smallest subarray with sum greater than a given value. Solution: */

  /** 58. Problem: Program to find largest element in an array. */
  int findLargest(int[] array, int index, int largest) {
    if (index == array.length) return largest;
    else return findLargest(array, index + 1, array[index] > largest ? array[index] : largest);
  }

  /** 59. Problem: Program to cyclically rotate an array by one. Solution: */

  /** 60. Problem: Maximum Sum Path in Two Arrays. Solution: */

  /** 61. Problem: Decode a given pattern in two ways (Flipkart Interview Question). Solution: */

  /** 62. Problem: A data structure for n elements and O(1) operations. Solution: */

  /**
   * 63. Problem: Longest Monotonically Increasing Subsequence Size (N log N): Simple
   * implementation. Solution:
   */

  /**
   * 64. Problem: Rearrange array in alternating positive &#038; negative items with O(1) extra
   * space | Set 1. Solution:
   */

  /**
   * 65. Problem: Find the smallest positive integer value that cannot be represented as sum of any
   * subset of a given array. Given a sorted array (sorted in non-decreasing order) of positive
   * numbers, find the smallest positive integer value that cannot be represented as sum of elements
   * of any subset of given set. Expected time complexity is O(n). Solution: 1. Initialize result =
   * 1 (smallest possible outcome). 2. if ( arr[i] > result) found gap and res is the answer. 3.
   * else add arr[i] to result.
   */
  int findSmallest(int[] arr) {
    int res = 1;
    for (int i = 0; i < arr.length && res >= arr[i]; i++) res += arr[i];
    return res;
  }

  /**
   * 66. Problem: Print All Distinct Elements of a given integer array. Solution: Use sorting or
   * hash set.
   */

  /** 67. Problem: Find common elements in three sorted arrays. Solution: */

  /** 68. Problem: Length of the largest subarray with contiguous elements | Set 1. Solution: */

  /**
   * 69. Problem: Given a sorted array and a number x, find the pair in array whose sum is closest
   * to x. Solution:
   */

  /**
   * 70. Problem: Find Index of 0 to be replaced with 1 to get longest continuous sequence of 1s in
   * a binary array. Solution:
   */

  /** 71. Problem: Nuts &#038; Bolts Problem (Lock &#038; Key problem). Solution: */

  /**
   * 72. Problem: Given a binary string, count number of substrings that start and end with 1..
   * Solution:
   */

  /**
   * 73. Problem: Rearrange an array such that 'arr[j]' becomes 'i' if 'arr[i]' is 'j'. Solution:
   */

  /**
   * 74. Problem: Delete an element from array (Using two traversals and one traversal). Solution:
   */

  /** 75. Problem: Print missing elements that lie in range 0 - 99. Solution: */

  /**
   * 76. Problem: Pythagorean Triplet in an array. Given an array of integers, write a function that
   * returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2. Solution: 1) Do
   * square of every element in input array. This step takes O(n) time. 2) Sort the squared array in
   * increasing order. This step takes O(nLogn) time. 3) To find a triplet (a, b, c) such that a = b
   * + c, fix a as last element and search b and c in between first element and a. We can use left
   * and right pointers for this.
   */

  /**
   * 77. Problem: Find Union and Intersection of two unsorted arrays. Solution: Use set if auxiliary
   * space can be used in O(n). Else sort and use two pointers in O(nlogn) time.
   */

  /**
   * 78. Problem: Replace every array element by multiplication of previous and next. Solution: Keep
   * track of previous value and update array.
   */
  void replaceWithMultiply(int[] array, int index, int previous) {
    if (index < array.length) {
      if (index == array.length - 1) array[index] = previous;
      else {
        int previousCopy = array[index];
        array[index] = previous * array[index + 1];
        replaceWithMultiply(array, index + 1, previousCopy);
      }
    }
  }

  /**
   * 79. Problem: Count frequencies of all elements in array in O(1) extra space and O(n) time.
   * Given an unsorted array of n integers which can contain integers from 1 to n. Some elements can
   * be repeated multiple times and some other elements can be absent from the array. Count
   * frequency of all elements that are present and print the missing elements. Solution: Scan array
   * and for each element i add n + 1 to the element at index i. To print frequency do modular
   * division and (quotient / n + 1) will give the frequency.
   */

  /**
   * 80. Problem: Generate all possible sorted arrays from alternate elements of two given sorted
   * arrays. Solution:
   */

  /** 81. Problem: Find the largest three elements in an array. Solution: */

  /** 82. Problem: Reverse an array upto a given position. Solution: */

  /**
   * 83. Problem: Minimum number of swaps required for arranging pairs adjacent to each other.
   * Solution:
   */

  /**
   * 84. Problem: Trapping Rain Water. Given n non-negative integers representing an elevation map
   * where the width of each bar is 1, compute how much water it is able to trap after raining. For
   * example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
   */
  int rainWater(int[] array) {
    int[] left = fillLeftArray(array);
    int[] right = fillRightArray(array);
    int water = 0;
    for (int i = 0; i < array.length; i++) water += Math.min(left[i], right[i]) - array[i];
    return water;
  }

  private int[] fillLeftArray(int[] array) {
    int[] left = new int[array.length];
    left[0] = array[0];
    for (int i = 1; i < array.length; i++) left[i] = Math.max(left[i - 1], array[i]);
    return left;
  }

  private int[] fillRightArray(int[] array) {
    int[] right = new int[array.length];
    right[array.length - 1] = array[array.length - 1];
    for (int i = array.length - 2; i >= 0; i--) right[i] = Math.max(right[i + 1], array[i]);
    return right;
  }

  /** 85. Problem: Converting an array of integers into Zig-Zag fashion!. Solution: */

  /**
   * 86. Problem: Convert array into Zig-Zag fashion. Given an array of distinct elements, rearrange
   * the elements of array in zig-zag fashion in O(n) time. The converted array should be in form a
   * < b > c < d > e < f. Solution: Scan left to right and swap at odd and even places according to
   * condition given above.
   */

  /**
   * 87. Problem: Find maximum average subarray of k length. Given an array with positive and
   * negative numbers, find the maximum average subarray of given length. Example: Input: arr[] =
   * {1, 12, -5, -6, 50, 3}, k = 4 Output: Maximum average subarray of length 4 begins at index 1.
   */
  int maxAverage(int[] array, int k) {
    int currMax = Arrays.stream(array).limit(k).sum();
    int max = 0;
    int index = 0;
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

  /** 88. Problem: Program to print Sum Triangle for a given array. Solution: */

  /**
   * 89. Problem: Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed.
   * Solution:
   */

  /** 90. Problem: Reorder an array according to given indexes. Solution: */

  /** 91. Problem: Check if a sorted array can be divided in pairs whose sum is k. Solution: */

  /**
   * 92. Problem: Find zeroes to be flipped so that number of consecutive 1's is maximized. Given a
   * binary array and an integer k, find the position of zeroes flipping which creates maximum
   * number of consecutive 1s in array.
   */
  int maxLength(int[] array, int k) {
    int windowR = 0, windowL = 0, maxLength = 0, zeroesFlipped = 0;
    while (windowR < array.length) {
      if ((zeroesFlipped < k || array[windowR] == 1) && windowR < array.length) {
        if (array[windowR] == 0) zeroesFlipped++;
        windowR++;
      } else {
        maxLength = Math.max(maxLength, windowR - windowL);
        if (windowL < array.length && array[windowL] == 0) zeroesFlipped--;
        windowL++;
      }
    }
    return maxLength;
  }

  /**
   * 93. Problem: Count triplets with sum smaller than a given value. Given an array of distinct
   * integers and a sum value. Find count of triplets with sum smaller than given sum value.
   * Expected Time Complexity is O(n^2). Solution: Sort and then use duplet algo.
   */

  /** 94. Problem: Find the subarray with least average. Solution: */

  /** 95. Problem: Count Inversions of size three in a give array. Solution: */

  /** 96. Problem: Longest Span with same Sum in two Binary arrays. Solution: */

  /**
   * 97. Problem: Merge two sorted arrays with O(1) extra space. We are given two sorted array. We
   * need to merge these two arrays such that the initial numbers (after complete sorting) are in
   * the first array and the remaining numbers are in the second array. Extra space allowed in O(1).
   * Solution: Assume two arrays to be continous single array and use insertion sort logic.
   */

  /** 98. Problem: Form minimum number from given sequence. Solution: */

  /**
   * 99. Problem: Subarray/Substring vs Subsequence and Programs to Generate them. Solution: In
   * general, for an array/string of size n, there are n*(n+1)/2 non-empty subarrays/subsrings. We
   * can generate all by sliding window algo. More generally, we can say that for a sequence of size
   * n, we can have (2n-1) non-empty sub-sequences in total. Every subarray is a subsequence. More
   * specifically, Subsequence is a generalization of substring. Subsequences are in fact subsets
   * except for empty set.
   */

  /**
   * 100. Problem: Count Strictly Increasing Subarrays. Given an array of integers, count number of
   * subarrays (of size more than one) that are strictly increasing.
   */
  int countSIS(int[] arr) {
    int count = 0;
    int sortedLen = 1;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] < arr[i + 1]) sortedLen++;
      else {
        count += (sortedLen - 1) * sortedLen / 2;
        sortedLen = 1;
      }
    }
    if (sortedLen > 1) count += (sortedLen - 1) * sortedLen / 2;
    return count;
  }

  /**
   * 101. Problem: Rearrange an array in maximum minimum form | Set 1. Given a sorted array of
   * positive integers, rearrange the array alternately i.e first element should be maximum value,
   * second minimum value, third second max, fourth second min and so on. Solution: With extra space
   * it can be easily done using two pointers left and right. Keep moving them towards each other
   * and keep copying alternate elements in an auxiliary array.
   */

  /**
   * 102. Problem: Find minimum difference between any two elements. Given an unsorted array, find
   * the minimum difference between any pair in given array. Solution: Sort and then compare
   * adjacent elements. Time Complexity: O(n.log(n))
   */

  /**
   * 103. Problem: Find lost element from a duplicated array. Given two arrays which are duplicates
   * of each other except one element, that is one element from one of the array is missing, we need
   * to find that missing element. Solution: If elements are sorted, use modified binary search
   * starting with bigger array. Otherwise, use XOR operator.
   */

  /** 104. Problem: Count pairs with given sum. Solution: Use hash set. Result will be count/2. */

  /**
   * 105. Problem: Count minimum steps to get the given desired array. Consider an array with n
   * elements and value of all the elements is zero. We can perform following operations on the
   * array. 1. Incremental operations: Choose 1 element from the array and increment its value by 1.
   * 2. Doubling operation: Double the values of all the elements of array. Solution: The idea is to
   * follow reverse steps, i.e. to convert target to array of zeros.
   */

  /**
   * 106. Problem: Find minimum number of merge operations to make an array palindrome. Given an
   * array of positive integers. We need to make the given array a ‘Palindrome’. Only allowed
   * operation on array is merge. Merging two adjacent elements means replacing them with their sum.
   * The task is to find minimum number of merge operations required to make given array a
   * ‘Palindrome’.
   */
  int minPalindromeOperations(int[] array, int start, int end) {
    if (start >= end) return 0;
    else if (array[start] == array[end]) return minPalindromeOperations(array, start + 1, end - 1);
    else if (array[start] < array[end]) {
      array[start + 1] += array[start];
      return 1 + minPalindromeOperations(array, start + 1, end);
    } else {
      array[end - 1] += array[end];
      return 1 + minPalindromeOperations(array, start, end - 1);
    }
  }

  /**
   * 107. Problem: Minimize the maximum difference between the heights. Given heights of n towers
   * and a value k. We need to either increase or decrease height of every tower by k (only once)
   * where k > 0. The task is to minimize the difference between the heights of the longest and the
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
   * 108. Problem: Rearrange array in alternating positive &#038; negative items with O(1) extra
   * space | Set 2. Solution:
   */

  /** 109. Problem: Absolute distinct count in a sorted array. Solution: */

  /** 110. Problem: Count pairs formed by distinct element sub-arrays. Solution: */

  /** 111. Problem: Maximum product of a triplet (subsequnece of size 3) in array. Solution: */

  /** 112. Problem: Pair with given product | Set 1 (Find if any pair exists). Solution: */

  /** 113. Problem: Find smallest range containing elements from k lists. Solution: */

  /**
   * 114. Problem: Maximum absolute difference between sum of two contiguous sub-arrays. Solution:
   */
  int maxDifferenceTwoSubArray(int[] array) {
    int[] leftMaxSum = new int[array.length],
        leftMinSum = new int[array.length],
        rightMaxSum = new int[array.length],
        rightMinSum = new int[array.length];

    maxLeftSumSubArray(array, leftMaxSum);
    maxRightSumSubArray(array, rightMaxSum);
    int[] invertArray = IntStream.of(array).map(x -> -x).toArray();
    maxLeftSumSubArray(invertArray, leftMinSum);
    leftMinSum = IntStream.of(leftMinSum).map(x -> -x).toArray();
    maxRightSumSubArray(invertArray, rightMinSum);
    rightMinSum = IntStream.of(rightMinSum).map(x -> -x).toArray();
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i++) {
      int value =
          Math.max(
              Math.abs(leftMaxSum[i] - rightMinSum[i]), Math.abs(leftMinSum[i] - rightMaxSum[i]));
      result = Math.max(result, value);
    }
    return result;
  }

  private void maxLeftSumSubArray(int[] array, int[] left) {
    int maxSoFar = array[0], currMax = array[0];
    left[0] = maxSoFar;
    for (int i = 1; i < array.length; i++) {
      currMax = Math.max(array[i], currMax + array[i]);
      maxSoFar = Math.max(currMax, maxSoFar);
      left[i] = maxSoFar;
    }
  }

  private void maxRightSumSubArray(int[] array, int[] right) {
    int maxSoFar = array[array.length - 1], currMax = maxSoFar;
    right[array.length - 1] = maxSoFar;
    for (int i = array.length - 2; i >= 0; i--) {
      currMax = Math.max(array[i], currMax + array[i]);
      maxSoFar = Math.max(currMax, maxSoFar);
      right[i] = maxSoFar;
    }
  }

  /** 115. Problem: Find number of subarrays with even sum. Solution: */
  int subArrayCountWithEvenSum(int[] array) {
    return subArrayCount(array, 2);
  }

  /**
   * 116. Problem: Maximum value K such that array has at-least K elements that are >= K. Solution:
   */

  /** 117. Problem: Minimum sum of two numbers formed from digits of an array. Solution: */

  /**
   * 118. Problem: Find frequency of each element in a limited range array in less than O(n) time.
   * Solution:
   */

  /** 119. Problem: Print all subarrays with 0 sum. Solution: */

  /** 120. Problem: Find Surpasser Count of each element in array. Solution: */

  /** 121. Problem: Remove duplicates from an array of small primes. Solution: */

  /** 122. Problem: Replace every element with the least greater element on its right. Solution: */

  /** 123. Problem: Maximum sum of i*arr[i] among all rotations of a given array. Solution: */

  /** 124. Problem: Largest product of a subarray of size k. Solution: */

  /** 125. Problem: Add elements of given arrays with given constraints. Solution: */

  /** 126. Problem: Jolly Jumper Sequence. Solution: */

  /** 127. Problem: Find if array can be divided into two subarrays of equal sum. Solution: */

  /**
   * 128. Problem: Find all triplets in a sorted array that forms Geometric Progression. Solution:
   */

  /** 129. Problem: Maximum Product Subarray | Set 2 (Using Two Traversals). Solution: */

  /** 130. Problem: Reverse an array in groups of given size. Solution: */

  /**
   * 131. Problem: Reverse an array in groups of given size | Set 2 (Variations of Set 1 ).
   * Solution:
   */

  /** 132. Problem: Third largest element in an array of distinct elements. Solution: */

  /**
   * 133. Problem: Find Two Missing Numbers | Set 1 (An Interesting Linear Time Solution). Solution:
   */

  /** 134. Problem: Active and Inactive cells after k Days. Solution: */

  /** 135. Problem: Maximize value of (arr[i] - i) - (arr[j] - j) in an array. Solution: */

  /** 136. Problem: Maximize number of 0s by flipping a subarray. Solution: */

  /** 137. Problem: Change if all bits can be made same by single flip. Solution: */

  /**
   * 138. Problem: Find minimum elements after considering all possible transformations. Solution:
   */

  /** 139. Problem: Minimum Initial Energy Required To Cross Street. Solution: */

  /**
   * 140. Problem: Find Maximum value of abs(i - j) * min(arr[i], arr[j]) in an array arr[].
   * Solution:
   */

  /**
   * 141. Problem: Check if an array can be Arranged in Left or Right Positioned Array. Solution:
   */

  /** 142. Problem: Maximize array sum after K negations | Set 1. Solution: */

  /** 143. Problem: Maximum and Minimum Product Subsets. Solution: */

  /** 144. Problem: Emulating a 2-d array using 1-d array. Solution: */

  /** 145. Problem: Sorted subsequence of size 3 in linear time using constant space. Solution: */

  /** 146. Problem: Sum of subset differences. Solution: */

  /** 147. Problem: Minimum steps to reach end of array under constraints. Solution: */

  /** 148. Problem: Length of Longest sub-string that can be removed. Solution: */

  /** 149. Problem: Sum of absolute differences of all pairs in a given array. Solution: */

  /** 150. Problem: Smallest subarray whose sum is multiple of array size. Solution: */

  /** 151. Problem: Count all pairs with given XOR. Solution: */

  /** 152. Problem: Maximum sum of pairs with specific difference. Solution: */

  /** 153. Problem: Minimum number of swaps required to sort an array. Solution: */

  /** 154. Problem: Number of swaps to sort when only adjacent swapping allowed. Solution: */

  /**
   * 155. Problem: Find maximum difference between nearest left and right smaller elements.
   * Solution:
   */

  /** 156. Problem: Minimum swaps to make two arrays identical. Solution: */

  /** 157. Problem: Find Equal (or Middle) Point in a sorted array with duplicates. Solution: */

  /** 158. Problem: Sum of maximum elements of all subsets. Solution: */

  /** 159. Problem: Find Maximum Sum Strictly Increasing Subarray. Solution: */

  /** 160. Problem: Minimum delete operations to make all elements of array same. Solution: */

  /** 161. Problem: Find Maximum XOR value of a sub-array of size k. Solution: */

  /** 162. Problem: Find next Smaller of next Greater in an array. Solution: */

  /** 163. Problem: Find elements larger than half of the elements in an array. Solution: */

  /** 164. Problem: Maximize array sum after K negations | Set 2. Solution: */

  /** 165. Problem: Maximum subsequence sum such that no three are consecutive. Solution: */

  /** 166. Problem: Maximum distance between two occurrences of same element in array. Solution: */

  /** 167. Problem: Elements before which no element is bigger in array. Solution: */

  /** 168. Problem: Find the only repeating element in a sorted array of size n. Solution: */

  /** 169. Problem: Minimum XOR Value Pair. Solution: */

  /** 170. Problem: Count pairs in an array that hold i*arr[i] &gt; j*arr[j]. Solution: */

  /**
   * 171. Problem: Count minimum number of &#8220;move-to-front&#8221; moves to sort an array.
   * Solution:
   */

  /** 172. Problem: Maximum product of an increasing subsequence of size 3. Solution: */

  /** 173. Problem: Find bitonic point in given bitonic sequence. Solution: */

  /** 174. Problem: Program to find the number of persons wearing white hat. Solution: */

  /** 175. Problem: Sum of all elements between k1'th and k2'th smallest elements. Solution: */

  /** 176. Problem: Arrays in Java. Solution: */

  /** 177. Problem: Sort an array according to absolute difference with given value. Solution: */

  /** 178. Problem: Subarrays with distinct elements. Solution: */

  /**
   * 179. Problem: Minimize the sum of product of two arrays with permutations allowed. Solution:
   */

  /**
   * 180. Problem: Move all negative elements to end in order with extra space allowed. Solution:
   */

  /** 181. Problem: Position of an element after stable sort. Solution: */

  /** 182. Problem: Steps to return to {1, 2, ..n} with specified movements. Solution: */

  /** 183. Problem: Maximum sum subarray removing at most one element. Solution: */

  /**
   * 184. Problem: Maximum subarray size, such that all subarrays of that size have sum less than k.
   * Solution:
   */

  /**
   * 185. Problem: Minimum flips in two binary arrays so that their XOR is equal to another array.
   * Solution:
   */

  /**
   * 186. Problem: Number of full binary trees such that each node is product of its children.
   * Solution:
   */

  /**
   * 187. Problem: Minimum sum subsequence such that at least one of every four consecutive elements
   * is picked. Solution:
   */

  /** 188. Problem: Chocolate Distribution Problem. Solution: */

  /** 189. Problem: Sum of minimum and maximum elements of all subarrays of size k.. Solution: */

  /** 190. Problem: Subset sum queries using bitset. Solution: */

  /**
   * 191. Problem: Maximum path sum for each position with jumps under divisibility condition.
   * Solution:
   */

  /** 192. Problem: Check loop in array according to given constraints. Solution: */

  /**
   * 193. Problem: Sort even-placed elements in increasing and odd-placed in decreasing order.
   * Solution:
   */

  /** 194. Problem: Maximum occurred integer in n ranges. Solution: */

  /** 195. Problem: Count of subarrays whose maximum element is greater than k. Solution: */

  /**
   * 196. Problem: Permute two arrays such that sum of every pair is greater or equal to K.
   * Solution:
   */

  /**
   * 197. Count all sub-arrays having sum divisible by k. Solution: Construct a hash-map which will
   * store the cumulative sum of all the numbers thus far mod k mapped to the count of how often
   * that remainder value appears (constructed in expected O(n)). Increase 0's value by one - this
   * corresponds to the start of the array. Go through the hash-map and add nC2 (=
   * value!/(2*(value-2)!)) to the count. The 2 we're choosing here are the starting and ending
   * positions of the subarray.
   */
  int subArrayCount(int[] array, int k) {
    int[] mod = countRemainders(array, k);
    int result = 0;
    for (int elem : mod) result += (elem * (elem - 1)) / 2;
    return result;
  }

  private int[] countRemainders(int[] array, int k) {
    int sum = 0;
    int[] mod = new int[k];
    mod[0]++;
    for (int elem : array) {
      sum += elem;
      mod[((sum % k) + k) % k]++;
    }
    return mod;
  }

  /**
   * 198. Problem: Chose k array elements such that difference of maximum and minimum is minimized.
   * Solution:
   */

  /** 199. Problem: Sort an array when two halves are sorted. Solution: */

  /**
   * 200. Problem: Find Maximum dot product of two arrays with insertion of 0's. Solution: Done as
   * 158 in DPExamples.
   */

  /**
   * 201. Problem: Find element using minimum segments in Seven Segment Display. A Seven Segment
   * Display can be used to to display numbers. Given an array of n natural numbers. The task is to
   * find the number in the array which is using minimum segments to display number. If multiple
   * numbers have a minimum number of segments, output the number having the smallest index.
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
   * 202. Problem: Rearrange an array to minimize sum of product of consecutive pair elements.
   * Solution:
   */

  /** 203. Problem: Find a partition point in array. Solution: */

  /** 204. Problem: Find pairs in array whose sums already exist in array. Solution: */

  /** 205. Problem: Longest prefix that contains same number of X and Y in an array. Solution: */

  /**
   * 206. Problem: Find all elements in array which have at-least two greater elements. Solution:
   */

  /**
   * 207. Problem: Divide array into two sub-arrays such that their averages are equal. Solution:
   */

  /**
   * 208. Problem: Break an array into maximum number of sub-arrays such that their averages are
   * same. Solution:
   */

  /**
   * 209. Problem: Check whether Arithmetic Progression can be formed from the given array.
   * Solution:
   */

  /**
   * 210. Problem: Find three element from different three arrays such that that a + b + c = sum.
   * Solution:
   */

  /**
   * 211. Problem: Find maximum array sum after making all elements same with repeated subtraction.
   * Solution:
   */

  /** 212. Problem: Pairs of Amicable Numbers. Solution: */

  /** 213. Problem: Count of index pairs with equal elements in an array. Solution: */

  /** 214. Problem: Make two sets disjoint by removing minimum elements. Solution: */

  /** 215. Problem: Find a local minima in an array. Solution: */

  /** 216. Problem: Three way partitioning of an array around a given range. Solution: */

  /** 217. Problem: Find a subset with greatest geometric mean. Solution: */

  /** 218. Problem: Sum of the products of all possible Subsets. Solution: */

  /**
   * 219. Problem: Duplicates in an array in O(n) and by using O(1) extra space | Set-2. Solution:
   */

  /** 220. Problem: Find the missing number in Geometric Progression. Solution: */

  /** 221. Problem: Range Queries for Frequencies of array elements. Solution: */

  /**
   * 222. Problem: Check if there exist two elements in an array whose sum is equal to the sum of
   * rest of the array. Solution:
   */

  /** 223. Problem: Sum of all Subarrays. Solution: */

  /** 224. Problem: Constant time range add operation on an array. Solution: */

  /** 225. Problem: Find all triplets with zero sum. Solution: */

  /** 226. Problem: Maximum consecutive one’s (or zeros) in a binary array. Solution: */

  /** 227. Problem: Maximum sum of smallest and second smallest in an array. Solution: */

  /** 228. Problem: Minimum operations required to remove an array. Solution: */

  /** 229. Problem: Find duplicates under given constraints. Solution: */

  /** 230. Problem: Find sum of sum of all sub-sequences. Solution: */

  /** 231. Problem: Find first and last occurrences of an element in a sorted array. Solution: */

  /** 232. Problem: Sum of XOR of all possible subsets. Solution: */

  /** 233. Problem: Lexicographically smallest array after at-most K consecutive swaps. Solution: */

  /**
   * 234. Problem: Count all Quadruples from four arrays such that their XOR equals to 'x'.
   * Solution:
   */

  /**
   * 235. Problem: Rearrange an array in maximum minimum form | Set 2 (O(1) extra space). Solution:
   */

  /** 236. Problem: Type of array and its maximum element. Solution: */

  /** 237. Problem: Find floor and ceil in an unsorted array. Solution: */

  /** 238. Problem: Subset with no pair sum divisible by K. Solution: */

  /** 239. Problem: Sorting possible using size 3 subarray rotation. Solution: */

  /** 240. Problem: Count passing car pairs. Solution: */

  /**
   * 241. Problem: A permutation where each element indicates either number of elements before or
   * after it. Solution:
   */

  /** 242. Problem: Sort array after converting elements to their squares. Solution: */

  /**
   * 243. Problem: Sort all even numbers in ascending order and then sort all odd numbers in
   * descending order. Solution:
   */

  /** 244. Problem: Find N'th item in a set formed by sum of two arrays. Solution: */

  /** 245. Problem: Maximize sum of consecutive differences in a circular array. Solution: */

  /** 246. Problem: Check if two arrays are equal or not. Solution: */

  /** 247. Problem: Largest permutation after at most k swaps. Solution: */

  /** 248. Problem: Find maximum (or minimum) sum of a subarray of size k. Solution: */

  /** 249. Problem: Maximum value in an array after m range increment operations. Solution: */

  /** 250. Problem: Given two unsorted arrays, find all pairs whose sum is x. Solution: */

  /** 251. Problem: Largest divisible subset in array. Solution: */

  /**
   * 252. Problem: Construct an array from XOR of all elements of array except element at same
   * index. Solution:
   */

  /**
   * 253. Problem: Find the element that appears once in an array where every other element appears
   * twice. Solution:
   */

  /** 254. Problem: Minimum difference between max and min of all K-size subsets. Solution: */

  /**
   * 255. Problem: Minimum swaps to reach permuted array with at most 2 positions left swaps
   * allowed. Solution:
   */

  /** 256. Problem: GCD of more than two (or array) numbers. Solution: */

  /**
   * 257. Problem: Fill an array based on frequency where elements are in range from 0 to n-1.
   * Solution:
   */

  /** 258. Problem: Convert an array to reduced form | Set 2 (Using vector of pairs). Solution: */

  /** 259. Problem: Find all pairs (a,b) and (c,d) in array which satisfy ab = cd. Solution: */

  /** 260. Problem: Search, insert and delete in an unsorted array. Solution: */

  /** 261. Problem: Search, insert and delete in a sorted array. Solution: */

  /** 262. Problem: XOR of all subarray XORs | Set 1. Solution: */

  /** 263. Problem: Count pairs in a sorted array whose sum is less than x. Solution: */

  /** 264. Problem: Split an array into two equal Sum subarrays. Solution: */

  /** 265. Problem: Given pairwise sum of n numbers, find the numbers. Solution: */

  /** 266. Problem: Find sum of non-repeating (distinct) elements in an array. Solution: */

  /** 267. Problem: Minimum sum of absolute difference of pairs of two arrays. Solution: */

  /**
   * 268. Problem: Find original array from encrypted array (An array of sums of other elements).
   * Solution:
   */

  /**
   * 269. Problem: Noble integers in an array (count of greater elements is equal to value).
   * Solution:
   */

  /** 270. Problem: Perfect Sum Problem (Print all subsets with given sum). Solution: */

  /** 271. Problem: Window Sliding Technique. Solution: */

  /** 272. Problem: Find Duplicates of array using bit array. Solution: */

  /** 273. Problem: Place k elements such that minimum distance is maximized. Solution: */

  /** 274. Problem: Count the number of subarrays having a given XOR. Solution: */

  /**
   * 275. Problem: Minimum toggles to partition a binary array so that it has first 0s then 1s.
   * Solution:
   */

  /** 276. Problem: Subsequence with maximum odd sum. Solution: */

  /**
   * 277. Problem: Count of arrays in which all adjacent elements are such that one of them divide
   * the another. Solution:
   */

  /**
   * 278. Problem: Program to check if an array is sorted or not (Iterative and Recursive).
   * Solution:
   */

  /** 279. Problem: Program for average of an array (Iterative and Recursive). Solution: */

  /** 280. Problem: Smallest Difference Triplet from Three arrays. Solution: */

  /** 281. Problem: Find missing number in another array which is shuffled copy. Solution: */

  /**
   * 282. Problem: Prefix Sum Array - Implementation and Applications in Competitive Programming.
   * Solution:
   */

  /** 283. Problem: Largest sum contiguous increasing subarray. Solution: */

  /** 284. Problem: Program to print an array in Pendulum Arrangement. Solution: */

  /** 285. Problem: Smallest Difference pair of values between two unsorted Arrays. Solution: */

  /**
   * 286. Problem: Remove minimum elements from array such that no three consecutive element are
   * either increasing or decreasing. Solution:
   */

  /**
   * 287. Problem: Find whether it is possible to make array elements same using one external
   * number. Solution:
   */

  /**
   * 288. Problem: Clustering/Partitioning an array such that sum of square differences is minimum.
   * Solution:
   */

  /** 289. Problem: Maximum sum two non-overlapping subarrays of given size. Solution: */

  /** 290. Problem: Find whether a subarray is in form of a mountain or not. Solution: */

  /** 291. Problem: Program for multiplication of array elements. Solution: */

  /** 292. Problem: Number of subarrays for which product and sum are equal. Solution: */

  /**
   * 293. Problem: Find duplicates in a given array when elements are not limited to a range.
   * Solution:
   */

  /**
   * 294. Problem: Check if it is possible to sort an array with conditional swapping of adjacent
   * allowed. Solution:
   */

  /**
   * 295. Problem: Count the number of ways to divide an array into three contiguous parts having
   * equal sum. Solution:
   */

  /** 296. Problem: k-th distinct (or non-repeating) element in an array.. Solution: */

  /** 297. Problem: Sort an array after applying the given equation. Solution: */

  /** 298. Problem: Count number of ways to jump to reach end. */
  int countWaysToReachEnd(int[] array) {
    return new DPExamples().minJumps(array, 0, array.length - 1);
  }

  /**
   * 299. Problem: Reverse an array without using subtract sign ‘-‘ anywhere in the code. Solution:
   */

  /** 300. Problem: Check if product of every pair exists in an array. Solution: */

  /** 301. Problem: Find k pairs with smallest sums in two arrays. Solution: */

  /** 302. Problem: Largest subset whose all elements are Fibonacci numbers. Solution: */

  /** 303. Problem: First element occurring k times in an array. Solution: */

  /** 304. Problem: K-th Element of Two Sorted Arrays. Solution: */

  /** 305. Problem: Count subsets having distinct even numbers. Solution: */

  /**
   * 306. Problem: Maximum difference between first and last indexes of an element in array.
   * Solution:
   */

  /** 307. Problem: Remove duplicates from sorted array. Solution: */

  /** 308. Problem: Find index of an extra element present in one sorted array. Solution: */

  /** 309. Problem: Merge two sorted arrays. Solution: */
  void mergeArrays(int[] array1, int[] array2, int index1, int index2, int[] array, int index) {
    if (index1 == array1.length)
      System.arraycopy(array2, index2, array, index, array2.length - index2);
    else if (index2 == array2.length)
      System.arraycopy(array1, index1, array, index, array1.length - index1);
    else {
      if (array1[index1] < array2[index2]) {
        array[index] = array1[index1];
        mergeArrays(array1, array2, index1 + 1, index2, array, index + 1);
      } else {
        array[index] = array2[index2];
        mergeArrays(array1, array2, index1, index2 + 1, array, index + 1);
      }
    }
  }

  /** 310. Problem: Sum of array elements using recursion. Solution: */
  int arraySum(int[] array, int sum, int m) {
    if (m == array.length) return sum;
    else return arraySum(array, sum + array[m], m + 1);
  }

  /** 311. Problem: Mean of array using recursion. Solution: */

  /** 312. Problem: Number of buildings facing the sun. Solution: */

  /** 313. Problem: k-th smallest absolute difference of two elements in an array. Solution: */

  /** 314. Problem: Ways to sum to N using array elements with repetition allowed. Solution: */

  /** 315. Problem: Find a Fixed Point in an array with duplicates allowed. Solution: */

  /** 316. Problem: Largest sum subarray with at-least k numbers. Solution: */

  /** 317. Problem: Fill array with 1's using minimum iterations of filling neighbors. Solution: */

  /**
   * 318. Problem: Find the minimum value to be added so that array becomes balanced. Given an array
   * of even size, task is to find minimum value that can be added to an element so that array
   * become balanced. An array is balanced if the sum of the left half of the array elements is
   * equal to the sum of right half.
   */
  int minValue(int[] array, int left, int right, int diff) {
    if (left > right) return Math.abs(diff);
    else return minValue(array, left + 1, right - 1, diff + array[left] - array[right]);
  }

  /**
   * 319. Problem: Rearrange an array such that every odd indexed element is greater than it
   * previous. Solution:
   */

  /** 320. Problem: XOR of all subarray XORs | Set 2. Solution: */

  /** 321. Problem: First negative integer in every window of size k. Solution: */

  /** 322. Problem: Longest Subarray of non-negative Integers. Solution: */

  /** 323. Problem: Minimum number of jumps to reach end | Set 2 (O(n) solution). Solution: */

  /** 324. Problem: Sum of product of all pairs of array elements. Solution: */

  /** 325. Problem: Maximum Length Bitonic Subarray | Set 2 (O(n) time and O(1) Space). Solution: */

  /**
   * 326. Problem: For each element in 1st array count elements less than or equal to it in 2nd
   * array. Solution:
   */

  /** 327. Problem: Count of smaller or equal elements in sorted array. Solution: */

  /**
   * 328. Problem: Minimum sum of two elements from two arrays such that indexes are not same.
   * Solution:
   */

  /** 329. Problem: Count minimum right flips to set all values in an array. Solution: */

  /** 330. Problem: Find Second largest element in an array. Solution: */

  /** 331. Problem: Sum of minimum absolute difference of each array element. Solution: */

  /**
   * 332. Problem: Count elements less than or equal to a given value in a sorted rotated array.
   * Solution:
   */

  /**
   * 333. Problem: Maximizing Unique Pairs from two arrays. Given two arrays of equal size N, form
   * maximum number of pairs by using their elements, one from the first array and second from the
   * second array, such that an element from each array is used at-most once and the absolute
   * difference between the selected elements used for forming a pair is less than or equal to a
   * given element K.
   */
  int findUP(int[] array1, int[] array2, int k) {
    Arrays.sort(array1);
    Arrays.sort(array2);
    return findUniquePairs(array1, array2, 0, 0, k, 0);
  }

  private int findUniquePairs(int[] array1, int[] array2, int i, int j, int k, int res) {
    if (i > array1.length - 1 || j > array1.length - 1) return res;
    else if (Math.abs(array1[i] - array2[j]) <= k)
      return findUniquePairs(array1, array2, i + 1, j + 1, k, res + 1);
    else if (array1[i] > array2[j]) return findUniquePairs(array1, array2, i, j + 1, k, res);
    else return findUniquePairs(array1, array2, i + 1, j, k, res);
  }

  /**
   * 334. Problem: Maximum modulo of in all the pairs of array where arr[i] &gt;= arr[j]. Solution:
   */

  /**
   * 335. Problem: Find start and ending index of an element in an unsorted array. Given an array of
   * integers, task is to find the starting and ending position of a given key.
   */
  int findIndex(int[] array, int key, int index, int iterator, int res) {
    if (array.length == index || index < 0) return res;
    else if (array[index] == key) return index;
    else return findIndex(array, key, index + iterator, iterator, res);
  }

  /**
   * 336. Problem: Find the transition point in a binary array. Given a sorted array containing only
   * numbers 0 and 1, the task is to find the transition point efficiently. Transition point is a
   * point where “0” ends and “1” begins.
   */
  int findTPoint(int[] array, int start, int end) {
    if (start > end) return -1;
    else {
      int mid = (start + end) / 2;
      if (array[mid] == 1 && mid - 1 > 0 && array[mid - 1] == 0) return mid;
      else if (array[mid] == 0) return findTPoint(array, mid + 1, end);
      else return findTPoint(array, start, end - 1);
    }
  }

  /** 337. Problem: Recursive Programs to find Minimum and Maximum elements of array. Solution: */

  /** 338. Problem: Program to print Sum of even and odd elements in an array. Solution: */

  /**
   * 339. Problem: Find minimum value to assign all array elements so that array product becomes
   * greater. Solution:
   */

  /**
   * 340. Problem: Count subarrays having total distinct elements same as original array. Solution:
   */

  /**
   * 341. Problem: Search an element in an unsorted array using minimum number of comparisons.
   * Solution:
   */

  /** 342. Problem: Number of pairs in an array such that product is greater than sum. Solution: */

  /**
   * 343. Problem: Count pairs from two sorted arrays whose sum is equal to a given value x.
   * Solution:
   */

  /** Maximum sum of not necessarily contigous array for a non empty array. */
  int maxSumNonContigous(int[] array) {
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
   * Problem: Candies distribution There are N children standing in a line. Each child is assigned a
   * rating value. You are giving candies to these children subjected to the following requirements:
   * 1. Each child must have at least one candy. 2. Children with a higher rating get more candies
   * than their neighbors.
   */
  int countCandies(int[] ratings) {
    int[] candies = new int[ratings.length];
    Arrays.fill(candies, 1);
    for (int i = 1; i < candies.length; i++)
      if (ratings[i - 1] < ratings[i]) candies[i] = Math.max(candies[i - 1] + 1, candies[i]);
    for (int i = ratings.length - 2; i >= 0; i--)
      if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
    return Arrays.stream(candies).sum();
  }

  /**
   * 1. Problem: Given an array A[] and a number x, check for pair in A[] with sum as x. Solution:
   */

  /** 2. Problem: Majority Element. Solution: */

  // nlogn time
  int majorityElement(int[] num) {
    if (num.length == 1) {
      return num[0];
    }

    Arrays.sort(num);
    return num[num.length / 2];
  }

  // Linear Time Majority Vote Algorithm

  int majorityElementVotingAlgo(int[] nums) {
    int result = 0, count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (count == 0) {
        result = nums[i];
        count = 1;
      } else if (result == nums[i]) count++;
      else count--;
    }
    return result;
  }
  /** 3. Problem: Find the Number Occurring Odd Number of Times. Solution: */

  /** 4. Problem: Search an element in a sorted and rotated array. Solution: */

  /** 5. Problem: Merge an array of size n into another array of size m+n. Solution: */

  /** 6. Problem: Write a program to reverse an array or string. Solution: */

  /** 7. Problem: Program for array rotation. Solution: */

  /** 8. Problem: Reversal algorithm for array rotation. Solution: */

  /** 9. Problem: Block swap algorithm for array rotation. Solution: */

  /** 10. Problem: Maximum sum such that no two elements are adjacent. Solution: */

  /** 11. Problem: Leaders in an array. Solution: */

  /** 12. Problem: Sort elements by frequency | Set 1. Solution: */

  /** 13. Problem: Two elements whose sum is closest to zero. Solution: */

  /** 14. Problem: Find the smallest and second smallest elements in an array. Solution: */

  /** 15. Problem: Check for Majority Element in a sorted array. Solution: */

  /** 16. Problem: Segregate 0s and 1s in an array. Solution: */

  /** 17. Problem: k largest(or smallest) elements in an array | added Min Heap method. Solution: */

  /**
   * 18. Problem: Maximum difference between two elements such that larger element appears after the
   * smaller number. Solution:
   */

  /** 19. Problem: Union and Intersection of two sorted arrays. Solution: */

  /** 20. Problem: A Product Array Puzzle. Solution: */

  /** 21. Problem: Segregate Even and Odd numbers. Solution: */

  /** 22. Problem: Find the two repeating elements in a given array. Solution: */

  /** 23. Problem: Find duplicates in O(n) time and O(1) extra space | Set 1. Solution: */

  /** 24. Problem: Equilibrium index of an array. Solution: */
  int findEq(int[] arr) {
    int lSum = 0, rSum = 0;
    for (int i = 0; i < arr.length; i++) rSum += arr[i];

    for (int i = 0; i < arr.length; i++) {
      rSum -= arr[i];
      if (lSum == rSum) return i + 1;
      else lSum += arr[i];
    }
    return -1;
  }

  /** 25. Problem: Linked List vs Array. Solution: */

  /** 26. Problem: Check if array elements are consecutive | Added Method 3. Solution: */

  /** 27. Problem: Find the smallest missing number. Solution: */

  /**
   * 28. Problem: Given an array arr[], find the maximum j &#8211; i such that arr[j] > arr[i].
   * Solution:
   */

  /** 29. Problem: Find the minimum distance between two numbers. Solution: */

  /** 30. Problem: Maximum Length Bitonic Subarray | Set 1 (O(n) tine and O(n) space). Solution: */

  /** 31. Problem: Count smaller elements on right side. Solution: */

  /** 32. Problem: Find subarray with given sum | Set 1 (Nonnegative Numbers). Solution: */

  /** 33. Problem: Longest Increasing Subsequence Size (N log N). Solution: */

  /** 34. Problem: Find a triplet that sum to a given value. Solution: */

  /**
   * 35. Problem: Find the smallest positive number missing from an unsorted array | Set 1.
   * Solution:
   */

  /** 36. Problem: Find the two numbers with odd occurrences in an unsorted array. Solution: */

  /** 37. Problem: Find a sorted subsequence of size 3 in linear time. Solution: */

  /** 38. Problem: Largest subarray with equal number of 0s and 1s. Solution: */

  /** 39. Problem: Maximum Product Subarray. Solution: */

  /** 40. Problem: Replace every element with the greatest element on right side. Solution: */

  /** 41. Problem: Find four elements that sum to a given value | Set 1 (n^3 solution). Solution: */

  /**
   * 42. Problem: Find four elements that sum to a given value | Set 2 ( O(n^2Logn) Solution).
   * Solution:
   */

  /** 43. Problem: Maximum circular subarray sum. Solution: */

  /** 44. Problem: Count the number of possible triangles. Solution: */

  /** 45. Problem: Construction of Longest Increasing Subsequence (N log N). Solution: */

  /** 46. Problem: Arrange given numbers to form the biggest number | Set 1. Solution: */

  /** 47. Problem: Merge Overlapping Intervals. Solution: */

  /** 48. Problem: Find the maximum repeating number in O(n) time and O(1) extra space. Solution: */

  /** 49. Problem: Stock Buy Sell to Maximize Profit. Solution: */

  /**
   * 50. Problem: Rearrange positive and negative numbers in O(n) time and O(1) extra space.
   * Solution:
   */

  /**
   * 51. Problem: Find the Increasing subsequence of length three with maximum product. Solution:
   */

  /** 52. Problem: Move all zeroes to end of array. Solution: */

  /** 53. Problem: Program to find sum of elements in a given array. Solution: */

  /**
   * 54. Problem: Rearrange an array so that arr[i] becomes arr[arr[i]] with O(1) extra space.
   * Solution:
   */

  /**
   * 55. Problem: Count all possible groups of size 2 or 3 that have sum as multiple of 3. Solution:
   */

  /** 56. Problem: Find the number of zeroes. Solution: */

  /** 57. Problem: Smallest subarray with sum greater than a given value. Solution: */

  /** 58. Problem: Program to find largest element in an array. Solution: */

  /** 59. Problem: Program to cyclically rotate an array by one. Solution: */

  /** 60. Problem: Maximum Sum Path in Two Arrays. Solution: */

  /** 61. Problem: Decode a given pattern in two ways (Flipkart Interview Question). Solution: */

  /** 62. Problem: A data structure for n elements and O(1) operations. Solution: */

  /**
   * 63. Problem: Longest Monotonically Increasing Subsequence Size (N log N): Simple
   * implementation. Solution:
   */

  /**
   * 64. Problem: Rearrange array in alternating positive &#038; negative items with O(1) extra
   * space | Set 1. Solution:
   */

  /**
   * 65. Problem: Find the smallest positive integer value that cannot be represented as sum of any
   * subset of a given array. Solution:
   */

  /** 66. Problem: Print All Distinct Elements of a given integer array. Solution: */

  /** 67. Problem: Find common elements in three sorted arrays. Solution: */

  /** 68. Problem: Length of the largest subarray with contiguous elements | Set 1. Solution: */

  /**
   * 69. Problem: Given a sorted array and a number x, find the pair in array whose sum is closest
   * to x. Solution:
   */

  /** 70. Problem: Find the closest pair from two sorted arrays. Solution: */

  /**
   * 71. Problem: Find Index of 0 to be replaced with 1 to get longest continuous sequence of 1s in
   * a binary array. Solution:
   */

  /** 72. Problem: Nuts &#038; Bolts Problem (Lock &#038; Key problem) | Set 1. Solution: */

  /**
   * 73. Problem: Given a binary string, count number of substrings that start and end with 1..
   * Solution:
   */

  /**
   * 74. Problem: Rearrange an array such that &#8216;arr[j]&#8217; becomes &#8216;i&#8217; if
   * &#8216;arr[i]&#8217; is &#8216;j&#8217;. Solution:
   */

  /**
   * 75. Problem: Delete an element from array (Using two traversals and one traversal). Solution:
   */

  /** 76. Problem: Print missing elements that lie in range 0 &#8211; 99. Solution: */

  /** 77. Problem: Pythagorean Triplet in an array. Solution: */

  /** 78. Problem: Find Union and Intersection of two unsorted arrays. Solution: */

  /** 79. Problem: Replace every array element by multiplication of previous and next. Solution: */

  /**
   * 80. Problem: Count frequencies of all elements in array in O(1) extra space and O(n) time.
   * Solution:
   */

  /**
   * 81. Problem: Generate all possible sorted arrays from alternate elements of two given sorted
   * arrays. Solution:
   */

  /** 82. Problem: Find the largest three elements in an array. Solution: */

  /** 83. Problem: Reverse an array upto a given position. Solution: */

  /**
   * 84. Problem: Minimum number of swaps required for arranging pairs adjacent to each other.
   * Solution:
   */

  /** 85. Problem: Trapping Rain Water. Solution: */

  /** 86. Problem: Converting an array of integers into Zig-Zag fashion!. Solution: */

  /** 87. Problem: Convert array into Zig-Zag fashion. Solution: */

  /** 88. Problem: Find maximum average subarray of k length. Solution: */

  /** 89. Problem: Program to print Sum Triangle for a given array. Solution: */

  /**
   * 90. Problem: Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed.
   * Solution:
   */

  /** 91. Problem: Reorder an array according to given indexes. Solution: */

  /** 92. Problem: Check if a sorted array can be divided in pairs whose sum is k. Solution: */

  /**
   * 93. Problem: Find zeroes to be flipped so that number of consecutive 1&#8217;s is maximized.
   * Solution:
   */

  /** 94. Problem: Count triplets with sum smaller than a given value. Solution: */

  /** 95. Problem: Find the subarray with least average. Solution: */

  /** 96. Problem: Count Inversions of size three in a given array. Solution: */

  /** 97. Problem: Longest Span with same Sum in two Binary arrays. Solution: */

  /** 98. Problem: Merge two sorted arrays with O(1) extra space. Solution: */

  /** 99. Problem: Form minimum number from given sequence. Solution: */

  /** 100. Problem: Subarray/Substring vs Subsequence and Programs to Generate them. Solution: */

  /** 101. Problem: Count Strictly Increasing Subarrays. Solution: */

  /** 102. Problem: Rearrange an array in maximum minimum form | Set 1. Solution: */

  /** 103. Problem: Find minimum difference between any two elements. Solution: */

  /** 104. Problem: Find lost element from a duplicated array. Solution: */

  /** 105. Problem: Count pairs with given sum. Solution: */

  /** 106. Problem: Count minimum steps to get the given desired array. Solution: */

  /**
   * 107. Problem: Find minimum number of merge operations to make an array palindrome. Solution:
   */

  /** 108. Problem: Minimize the maximum difference between the heights. Solution: */

  /**
   * 109. Problem: Rearrange array in alternating positive &#038; negative items with O(1) extra
   * space | Set 2. Solution:
   */

  /** 110. Problem: Absolute distinct count in a sorted array. Solution: */

  /** 111. Problem: Count pairs formed by distinct element sub-arrays. Solution: */

  /** 112. Problem: Maximum product of a triplet (subsequnece of size 3) in array. Solution: */

  /** 113. Problem: Pair with given product | Set 1 (Find if any pair exists). Solution: */

  /** 114. Problem: Find smallest range containing elements from k lists. Solution: */

  /**
   * 115. Problem: Maximum absolute difference between sum of two contiguous sub-arrays. Solution:
   */

  /** 116. Problem: Find number of subarrays with even sum. Solution: */

  /**
   * 117. Problem: Maximum value K such that array has at-least K elements that are >= K. Solution:
   */

  /** 118. Problem: Minimum sum of two numbers formed from digits of an array. Solution: */

  /**
   * 119. Problem: Find frequency of each element in a limited range array in less than O(n) time.
   * Solution:
   */

  /** 120. Problem: Print all subarrays with 0 sum. Solution: */

  /** 121. Problem: Find Surpasser Count of each element in array. Solution: */

  /** 122. Problem: Remove duplicates from an array of small primes. Solution: */

  /** 123. Problem: Replace every element with the least greater element on its right. Solution: */

  /** 124. Problem: Maximum sum of i*arr[i] among all rotations of a given array. Solution: */

  /** 125. Problem: Largest product of a subarray of size k. Solution: */

  /** 126. Problem: Add elements of given arrays with given constraints. Solution: */

  /** 127. Problem: Jolly Jumper Sequence. Solution: */

  /** 128. Problem: Find if array can be divided into two subarrays of equal sum. Solution: */

  /**
   * 129. Problem: Find all triplets in a sorted array that forms Geometric Progression. Solution:
   */

  /** 130. Problem: Maximum Product Subarray | Set 2 (Using Two Traversals). Solution: */

  /** 131. Problem: Reverse an array in groups of given size. Solution: */

  /**
   * 132. Problem: Reverse an array in groups of given size | Set 2 (Variations of Set 1 ).
   * Solution:
   */

  /** 133. Problem: Third largest element in an array of distinct elements. Solution: */

  /**
   * 134. Problem: Find Two Missing Numbers | Set 1 (An Interesting Linear Time Solution). Solution:
   */

  /** 135. Problem: Active and Inactive cells after k Days. Solution: */

  /**
   * 136. Problem: Maximize value of (arr[i] &#8211; i) &#8211; (arr[j] &#8211; j) in an array.
   * Solution:
   */

  /** 137. Problem: Maximize number of 0s by flipping a subarray. Solution: */

  /** 138. Problem: Change if all bits can be made same by single flip. Solution: */

  /**
   * 139. Problem: Find minimum elements after considering all possible transformations. Solution:
   */

  /** 140. Problem: Minimum Initial Energy Required To Cross Street. Solution: */

  /**
   * 141. Problem: Find Maximum value of abs(i &#8211; j) * min(arr[i], arr[j]) in an array arr[].
   * Solution:
   */

  /**
   * 142. Problem: Check if an array can be Arranged in Left or Right Positioned Array. Solution:
   */

  /** 143. Problem: Maximize array sum after K negations | Set 1. Solution: */

  /** 144. Problem: Maximum and Minimum Product Subsets. Solution: */

  /** 145. Problem: Emulating a 2-d array using 1-d array. Solution: */

  /** 146. Problem: Sorted subsequence of size 3 in linear time using constant space. Solution: */

  /** 147. Problem: Sum of subset differences. Solution: */

  /** 148. Problem: Minimum steps to reach end of array under constraints. Solution: */

  /** 149. Problem: Length of Longest sub-string that can be removed. Solution: */

  /** 150. Problem: Sum of absolute differences of all pairs in a given array. Solution: */

  /** 151. Problem: Smallest subarray whose sum is multiple of array size. Solution: */

  /** 152. Problem: Count all pairs with given XOR. Solution: */

  /** 153. Problem: Maximum sum of pairs with specific difference. Solution: */

  /** 154. Problem: Minimum number of swaps required to sort an array. Solution: */

  /** 155. Problem: Number of swaps to sort when only adjacent swapping allowed. Solution: */

  /**
   * 156. Problem: Find maximum difference between nearest left and right smaller elements.
   * Solution:
   */

  /** 157. Problem: Minimum swaps to make two arrays identical. Solution: */

  /** 158. Problem: Find Equal (or Middle) Point in a sorted array with duplicates. Solution: */

  /** 159. Problem: Sum of maximum elements of all subsets. Solution: */

  /** 160. Problem: Find Maximum Sum Strictly Increasing Subarray. Solution: */

  /** 161. Problem: Minimum delete operations to make all elements of array same. Solution: */

  /** 162. Problem: Find Maximum XOR value of a sub-array of size k. Solution: */

  /** 163. Problem: Find next Smaller of next Greater in an array. Solution: */

  /** 164. Problem: Find elements larger than half of the elements in an array. Solution: */

  /** 165. Problem: Maximize array sum after K negations | Set 2. Solution: */

  /** 166. Problem: Maximum subsequence sum such that no three are consecutive. Solution: */

  /** 167. Problem: Maximum distance between two occurrences of same element in array. Solution: */

  /** 168. Problem: Elements before which no element is bigger in array. Solution: */

  /** 169. Problem: Find the only repeating element in a sorted array of size n. Solution: */

  /** 170. Problem: Minimum XOR Value Pair. Solution: */

  /** 171. Problem: Count pairs in an array that hold i*arr[i] &gt; j*arr[j]. Solution: */

  /**
   * 172. Problem: Count minimum number of &#8220;move-to-front&#8221; moves to sort an array.
   * Solution:
   */

  /** 173. Problem: Maximum product of an increasing subsequence of size 3. Solution: */

  /** 174. Problem: Find bitonic point in given bitonic sequence. Solution: */

  /** 175. Problem: Program to find the number of persons wearing white hat. Solution: */

  /**
   * 176. Problem: Sum of all elements between k1&#8217;th and k2&#8217;th smallest elements.
   * Solution:
   */

  /** 177. Problem: Arrays in Java. Solution: */

  /** 178. Problem: Sort an array according to absolute difference with given value. Solution: */

  /** 179. Problem: Subarrays with distinct elements. Solution: */

  /**
   * 180. Problem: Minimize the sum of product of two arrays with permutations allowed. Solution:
   */

  /**
   * 181. Problem: Move all negative elements to end in order with extra space allowed. Solution:
   */

  /** 182. Problem: Position of an element after stable sort. Solution: */

  /** 183. Problem: Steps to return to {1, 2, ..n} with specified movements. Solution: */

  /** 184. Problem: Maximum sum subarray removing at most one element. Solution: */

  /**
   * 185. Problem: Maximum subarray size, such that all subarrays of that size have sum less than k.
   * Solution:
   */

  /**
   * 186. Problem: Minimum flips in two binary arrays so that their XOR is equal to another array.
   * Solution:
   */

  /**
   * 187. Problem: Number of full binary trees such that each node is product of its children.
   * Solution:
   */

  /**
   * 188. Problem: Minimum sum subsequence such that at least one of every four consecutive elements
   * is picked. Solution:
   */

  /** 189. Problem: Chocolate Distribution Problem. Solution: */

  /** 190. Problem: Sum of minimum and maximum elements of all subarrays of size k.. Solution: */

  /** 191. Problem: Subset sum queries using bitset. Solution: */

  /**
   * 192. Problem: Maximum path sum for each position with jumps under divisibility condition.
   * Solution:
   */

  /** 193. Problem: Check loop in array according to given constraints. Solution: */

  /**
   * 194. Problem: Sort even-placed elements in increasing and odd-placed in decreasing order.
   * Solution:
   */

  /** 195. Problem: Maximum occurred integer in n ranges. Solution: */

  /** 196. Problem: Count of subarrays whose maximum element is greater than k. Solution: */

  /**
   * 197. Problem: Permute two arrays such that sum of every pair is greater or equal to K.
   * Solution:
   */

  /** 198. Problem: Count all sub-arrays having sum divisible by k. Solution: */

  /**
   * 199. Problem: Choose k array elements such that difference of maximum and minimum is minimized.
   * Solution:
   */

  /** 200. Problem: Sort an array when two halves are sorted. Solution: */

  /** 201. Problem: Find Maximum dot product of two arrays with insertion of 0&#8217;s. Solution: */

  /** 202. Problem: Find element using minimum segments in Seven Segment Display. Solution: */

  /**
   * 203. Problem: Rearrange an array to minimize sum of product of consecutive pair elements.
   * Solution:
   */

  /** 204. Problem: Find a partition point in array. Solution: */

  /** 205. Problem: Find pairs in array whose sums already exist in array. Solution: */

  /** 206. Problem: Longest prefix that contains same number of X and Y in an array. Solution: */

  /**
   * 207. Problem: Find all elements in array which have at-least two greater elements. Solution:
   */

  /**
   * 208. Problem: Divide array into two sub-arrays such that their averages are equal. Solution:
   */

  /**
   * 209. Problem: Break an array into maximum number of sub-arrays such that their averages are
   * same. Solution:
   */

  /**
   * 210. Problem: Check whether Arithmetic Progression can be formed from the given array.
   * Solution:
   */

  /**
   * 211. Problem: Find three element from different three arrays such that that a + b + c = sum.
   * Solution:
   */

  /**
   * 212. Problem: Find maximum array sum after making all elements same with repeated subtraction.
   * Solution:
   */

  /** 213. Problem: Pairs of Amicable Numbers. Solution: */

  /** 214. Problem: Count of index pairs with equal elements in an array. Solution: */

  /** 215. Problem: Make two sets disjoint by removing minimum elements. Solution: */

  /** 216. Problem: Find a local minima in an array. Solution: */

  /** 217. Problem: Three way partitioning of an array around a given range. Solution: */

  /** 218. Problem: Find a subset with greatest geometric mean. Solution: */

  /** 219. Problem: Sum of the products of all possible Subsets. Solution: */

  /**
   * 220. Problem: Duplicates in an array in O(n) and by using O(1) extra space | Set-2. Solution:
   */

  /** 221. Problem: Find the missing number in Geometric Progression. Solution: */

  /** 222. Problem: Range Queries for Frequencies of array elements. Solution: */

  /**
   * 223. Problem: Check if there exist two elements in an array whose sum is equal to the sum of
   * rest of the array. Solution:
   */

  /** 224. Problem: Sum of all Subarrays | Set 1. Solution: */

  /** 225. Problem: Constant time range add operation on an array. Solution: */

  /** 226. Problem: Find all triplets with zero sum. Solution: */

  /** 227. Problem: Maximum consecutive one’s (or zeros) in a binary array. Solution: */

  /** 228. Problem: Maximum sum of smallest and second smallest in an array. Solution: */

  /** 229. Problem: Minimum operations required to remove an array. Solution: */

  /** 230. Problem: Find duplicates under given constraints. Solution: */

  /** 231. Problem: Find sum of sum of all sub-sequences. Solution: */

  /** 232. Problem: Find first and last positions of an element in a sorted array. Solution: */

  /** 233. Problem: Sum of XOR of all possible subsets. Solution: */

  /** 234. Problem: Lexicographically smallest array after at-most K consecutive swaps. Solution: */

  /**
   * 235. Problem: Count all Quadruples from four arrays such that their XOR equals to
   * &#8216;x&#8217;. Solution:
   */

  /**
   * 236. Problem: Rearrange an array in maximum minimum form | Set 2 (O(1) extra space). Solution:
   */

  /** 237. Problem: Type of array and its maximum element. Solution: */

  /** 238. Problem: Find floor and ceil in an unsorted array. Solution: */

  /** 239. Problem: Subset with no pair sum divisible by K. Solution: */

  /** 240. Problem: Sorting possible using size 3 subarray rotation. Solution: */

  /** 241. Problem: Count passing car pairs. Solution: */

  /**
   * 242. Problem: A permutation where each element indicates either number of elements before or
   * after it. Solution:
   */

  /** 243. Problem: Sort array after converting elements to their squares. Solution: */

  /**
   * 244. Problem: Sort all even numbers in ascending order and then sort all odd numbers in
   * descending order. Solution:
   */

  /** 245. Problem: Find N&#8217;th item in a set formed by sum of two arrays. Solution: */

  /** 246. Problem: Maximize sum of consecutive differences in a circular array. Solution: */

  /** 247. Problem: Check if two arrays are equal or not. Solution: */

  /** 248. Problem: Largest permutation after at most k swaps. Solution: */

  /** 249. Problem: Find maximum (or minimum) sum of a subarray of size k. Solution: */

  /** 250. Problem: Maximum value in an array after m range increment operations. Solution: */

  /** 251. Problem: Given two unsorted arrays, find all pairs whose sum is x. Solution: */

  /** 252. Problem: Largest divisible subset in array. Solution: */

  /**
   * 253. Problem: Construct an array from XOR of all elements of array except element at same
   * index. Solution:
   */

  /**
   * 254. Problem: Find the element that appears once in an array where every other element appears
   * twice. Solution:
   */

  /** 255. Problem: Minimum difference between max and min of all K-size subsets. Solution: */

  /**
   * 256. Problem: Minimum swaps to reach permuted array with at most 2 positions left swaps
   * allowed. Solution:
   */

  /** 257. Problem: GCD of more than two (or array) numbers. Solution: */

  /**
   * 258. Problem: Fill an array based on frequency where elements are in range from 0 to n-1.
   * Solution:
   */

  /** 259. Problem: Convert an array to reduced form | Set 2 (Using vector of pairs). Solution: */

  /** 260. Problem: Find all pairs (a,b) and (c,d) in array which satisfy ab = cd. Solution: */

  /** 261. Problem: Search, insert and delete in an unsorted array. Solution: */

  /** 262. Problem: Search, insert and delete in a sorted array. Solution: */

  /** 263. Problem: XOR of all subarray XORs | Set 1. Solution: */

  /** 264. Problem: Count pairs in a sorted array whose sum is less than x. Solution: */

  /** 265. Problem: Split an array into two equal Sum subarrays. Solution: */

  /** 266. Problem: Given pairwise sum of n numbers, find the numbers. Solution: */

  /** 267. Problem: Find sum of non-repeating (distinct) elements in an array. Solution: */

  /** 268. Problem: Minimum sum of absolute difference of pairs of two arrays. Solution: */

  /**
   * 269. Problem: Find original array from encrypted array (An array of sums of other elements).
   * Solution:
   */

  /**
   * 270. Problem: Noble integers in an array (count of greater elements is equal to value).
   * Solution:
   */

  /** 271. Problem: Perfect Sum Problem (Print all subsets with given sum). Solution: */

  /** 272. Problem: Window Sliding Technique. Solution: */

  /** 273. Problem: Find Duplicates of array using bit array. Solution: */

  /** 274. Problem: Place k elements such that minimum distance is maximized. Solution: */

  /** 275. Problem: Count the number of subarrays having a given XOR. Solution: */

  /**
   * 276. Problem: Minimum toggles to partition a binary array so that it has first 0s then 1s.
   * Solution:
   */

  /** 277. Problem: Subsequence with maximum odd sum. Solution: */

  /**
   * 278. Problem: Count of arrays in which all adjacent elements are such that one of them divide
   * the another. Solution:
   */

  /**
   * 279. Problem: Program to check if an array is sorted or not (Iterative and Recursive).
   * Solution:
   */

  /** 280. Problem: Program for average of an array (Iterative and Recursive). Solution: */

  /** 281. Problem: Smallest Difference Triplet from Three arrays. Solution: */

  /** 282. Problem: Find missing number in another array which is shuffled copy. Solution: */

  /**
   * 283. Problem: Prefix Sum Array &#8211; Implementation and Applications in Competitive
   * Programming. Solution:
   */

  /** 284. Problem: Largest sum contiguous increasing subarray. Solution: */

  /** 285. Problem: Program to print an array in Pendulum Arrangement. Solution: */

  /** 286. Problem: Smallest Difference pair of values between two unsorted Arrays. Solution: */

  /**
   * 287. Problem: Remove minimum elements from array such that no three consecutive element are
   * either increasing or decreasing. Solution:
   */

  /**
   * 288. Problem: Find whether it is possible to make array elements same using one external
   * number. Solution:
   */

  /**
   * 289. Problem: Clustering/Partitioning an array such that sum of square differences is minimum.
   * Solution:
   */

  /** 290. Problem: Maximum sum two non-overlapping subarrays of given size. Solution: */

  /** 291. Problem: Find whether a subarray is in form of a mountain or not. Solution: */

  /** 292. Problem: Program for multiplication of array elements. Solution: */

  /** 293. Problem: Number of subarrays for which product and sum are equal. Solution: */

  /**
   * 294. Problem: Find duplicates in a given array when elements are not limited to a range.
   * Solution:
   */

  /**
   * 295. Problem: Check if it is possible to sort an array with conditional swapping of adjacent
   * allowed. Solution:
   */

  /**
   * 296. Problem: Count the number of ways to divide an array into three contiguous parts having
   * equal sum. Solution:
   */

  /** 297. Problem: k-th distinct (or non-repeating) element in an array.. Solution: */

  /** 298. Problem: Sort an array after applying the given equation. Solution: */

  /** 299. Problem: Count number of ways to jump to reach end. Solution: */

  /**
   * 300. Problem: Reverse an array without using subtract sign ‘-‘ anywhere in the code. Solution:
   */

  /** 301. Problem: Check if product of every pair exists in an array. Solution: */

  /** 302. Problem: Find k pairs with smallest sums in two arrays. Solution: */

  /** 303. Problem: Largest subset whose all elements are Fibonacci numbers. Solution: */

  /** 304. Problem: First element occurring k times in an array. Solution: */

  /** 305. Problem: K-th Element of Two Sorted Arrays. Solution: */

  /** 306. Problem: Count subsets having distinct even numbers. Solution: */

  /**
   * 307. Problem: Maximum difference between first and last indexes of an element in array.
   * Solution:
   */

  /** 308. Problem: Remove duplicates from sorted array. Solution: */

  /** 309. Problem: Find index of an extra element present in one sorted array. Solution: */

  /** 310. Problem: Merge two sorted arrays. Solution: */

  /** 311. Problem: Sum of array elements using recursion. Solution: */

  /** 312. Problem: Mean of array using recursion. Solution: */

  /** 313. Problem: Number of buildings facing the sun. Solution: */

  /** 314. Problem: k-th smallest absolute difference of two elements in an array. Solution: */

  /** 315. Problem: Ways to sum to N using array elements with repetition allowed. Solution: */

  /** 316. Problem: Find a Fixed Point in an array with duplicates allowed. Solution: */

  /** 317. Problem: Largest sum subarray with at-least k numbers. Solution: */

  /**
   * 318. Problem: Fill array with 1&#8217;s using minimum iterations of filling neighbors.
   * Solution:
   */

  /** 319. Problem: Find the minimum value to be added so that array becomes balanced. Solution: */

  /**
   * 320. Problem: Rearrange an array such that every odd indexed element is greater than it
   * previous. Solution:
   */

  /** 321. Problem: XOR of all subarray XORs | Set 2. Solution: */

  /** 322. Problem: First negative integer in every window of size k. Solution: */

  /** 323. Problem: Longest Subarray of non-negative Integers. Solution: */

  /** 324. Problem: Minimum number of jumps to reach end | Set 2 (O(n) solution). Solution: */

  /** 325. Problem: Sum of product of all pairs of array elements. Solution: */

  /** 326. Problem: Maximum Length Bitonic Subarray | Set 2 (O(n) time and O(1) Space). Solution: */

  /**
   * 327. Problem: For each element in 1st array count elements less than or equal to it in 2nd
   * array. Solution:
   */

  /** 328. Problem: Count of smaller or equal elements in sorted array. Solution: */

  /**
   * 329. Problem: Minimum sum of two elements from two arrays such that indexes are not same.
   * Solution:
   */

  /** 330. Problem: Count minimum right flips to set all values in an array. Solution: */

  /** 331. Problem: Find Second largest element in an array. Solution: */

  /** 332. Problem: Sum of minimum absolute difference of each array element. Solution: */

  /**
   * 333. Problem: Count elements less than or equal to a given value in a sorted rotated array.
   * Solution:
   */

  /** 334. Problem: Maximizing Unique Pairs from two arrays. Solution: */

  /**
   * 335. Problem: Maximum modulo of in all the pairs of array where arr[i] &gt;= arr[j]. Solution:
   */

  /** 336. Problem: Find start and ending index of an element in an unsorted array. Solution: */

  /** 337. Problem: Find the transition point in a binary array. Solution: */

  /** 338. Problem: Recursive Programs to find Minimum and Maximum elements of array. Solution: */

  /** 339. Problem: Program to print Sum of even and odd elements in an array. Solution: */

  /**
   * 340. Problem: Find minimum value to assign all array elements so that array product becomes
   * greater. Solution:
   */

  /**
   * 341. Problem: Count subarrays having total distinct elements same as original array. Solution:
   */

  /**
   * 342. Problem: Search an element in an unsorted array using minimum number of comparisons.
   * Solution:
   */

  /** 343. Problem: Number of pairs in an array such that product is greater than sum. Solution: */

  /**
   * 344. Problem: Count pairs from two sorted arrays whose sum is equal to a given value x.
   * Solution:
   */

  /** 345. Problem: Find all pairs (a, b) in an array such that a % b = k. Solution: */

  /** 346. Problem: Find k numbers with most occurrences in the given array. Solution: */

  /** 347. Problem: Largest triplet product in a stream. Solution: */

  /**
   * 348. Problem: Check in binary array the number represented by a subarray is odd or even.
   * Solution:
   */

  /**
   * 349. Problem: Elements of an array that are not divisible by any element of another array.
   * Solution:
   */

  /** 350. Problem: Fibonacci number in an array. Solution: */

  /** 351. Problem: Alternative Sorting. Solution: */

  /**
   * 352. Problem: Find a pair of elements swapping which makes sum of two arrays same. Solution:
   */

  /** 353. Problem: Count number of triplets with product equal to given number. Solution: */

  /** 354. Problem: Sum of product of all elements of sub-arrays of size k. Solution: */

  /** 355. Problem: Count pairs with Odd XOR. Solution: */

  /** 356. Problem: Queries for decimal values of subarrays of a binary array. Solution: */

  /** 357. Problem: Find the Sub-array with sum closest to 0. Solution: */

  /**
   * 358. Problem: Count of subarrays whose products don&#8217;t have any repeating prime factor.
   * Solution:
   */

  /** 359. Problem: Quickly find multiple left rotations of an array | Set 1. Solution: */

  /** 360. Problem: Find four elements that sum to a given value | Set 3 (Hashmap). Solution: */

  /** 361. Problem: All unique triplets that sum up to a given value. Solution: */

  /**
   * 362. Problem: Replace each node in binary tree with the sum of its inorder predecessor and
   * successor. Solution:
   */

  /**
   * 363. Problem: Minimum Number of Platforms Required for a Railway/Bus Station | Set 2 (Map based
   * approach). Solution:
   */

  /** 364. Problem: Why is it faster to process sorted array than an unsorted array ?. Solution: */

  /** 365. Problem: Queries for counts of array elements with values in given range. Solution: */

  /**
   * 366. Problem: Shuffle 2n integers in format {a1, b1, a2, b2, a3, b3, &#8230;&#8230;, an, bn}
   * without using extra space. Solution:
   */

  /**
   * 367. Problem: Find the index of first 1 in a sorted array of 0&#8217;s and 1&#8217;s. Solution:
   */

  /** 368. Problem: Number of jumps for a thief to cross walls. Solution: */

  /** 369. Problem: Serialize and Deserialize array of string. Solution: */

  /** 370. Problem: Find an element in Bitonic array. Solution: */

  /**
   * 371. Problem: Check if array elements are consecutive in O(n) time and O(1) space (Handles Both
   * Positive and negative numbers). Solution:
   */

  /** 372. Problem: Check if an array contains all elements of a given range. Solution: */

  /** 373. Problem: Distinct adjacent elements in an array. Solution: */

  /** 374. Problem: Sorting Array Elements By Frequency | Set 3 (Using STL). Solution: */

  /** 375. Problem: Arrange given numbers to form the biggest number | Set 2. Solution: */

  /** 376. Problem: Find first k natural numbers missing in given array. Solution: */

  /** 377. Problem: Sum of distinct elements when elements are in range 1 to n. Solution: */

  /** 378. Problem: Find any one of the multiple repeating elements in read only array. Solution: */

  /** 379. Problem: Queries on XOR of greatest odd divisor of the range. Solution: */

  /** 380. Problem: Merging two unsorted arrays in sorted order. Solution: */

  /** 381. Problem: Find top k (or most frequent) numbers in a stream. Solution: */

  /** 382. Problem: Find the missing number in a sorted array of limited range. Solution: */

  /** 383. Problem: K’th Smallest/Largest Element using STL. Solution: */

  /** 384. Problem: Smallest sum contiguous subarray. Solution: */

  /**
   * 385. Problem: Print modified array after multiple array range increment operations. Solution:
   */

  /** 386. Problem: Print left rotation of array in O(n) time and O(1) space. Solution: */

  /**
   * 387. Problem: RGYB(color) Slots Game to guess the correct color for the correct slot. Solution:
   */

  /** 388. Problem: Longest Bitonic Subsequence in O(n log n). Solution: */

  /** 389. Problem: Add minimum number to an array so that the sum becomes even. Solution: */

  /**
   * 390. Problem: Maximum possible sum of a window in an array such that elements of same window in
   * other array are unique. Solution:
   */

  /** 391. Problem: Maximum sum subarray having sum less than or equal to given sum. Solution: */

  /** 392. Problem: Subarray with XOR less than k. Solution: */

  /** 393. Problem: Subarray Inversions. Solution: */

  /**
   * 394. Problem: Smallest number that never becomes negative when processed against array
   * elements. Solution:
   */

  /**
   * 395. Problem: Maximum sum of lengths of non-overlapping subarrays with k as the max element..
   * Solution:
   */

  /** 396. Problem: Minimize cost of operation to equalize tower heights. Solution: */

  /** 397. Problem: A product array puzzle | Set 2 (O(1) Space). Solution: */

  /** 398. Problem: Find max in struct array. Solution: */

  /** 399. Problem: Find the compatibility difference between two arrays. Solution: */

  /** 400. Problem: Find if an array contains a string with one mismatch. Solution: */

  /** 401. Problem: Equalize an array using array elements only. Solution: */

  /**
   * 402. Problem: Smallest element in an array that is repeated exactly &#8216;k&#8217; times..
   * Solution:
   */

  /**
   * 403. Problem: Adding elements of an array until every element becomes greater than or equal to
   * k. Solution:
   */

  /** 404. Problem: Find a triplet such that sum of two equals to third element. Solution: */

  /**
   * 405. Problem: Rearrange an array in order &#8211; smallest, largest, 2nd smallest, 2nd largest,
   * ... Solution:
   */

  /**
   * 406. Problem: Count subarrays with equal number of occurrences of two given elements. Solution:
   */

  /** 407. Problem: Maximise the size of consecutive element subsets in an array. Solution: */

  /** 408. Problem: Sum of all subarrays of array | Set 2. Solution: */

  /** 409. Problem: Maximum Weight Difference. Solution: */

  /** 410. Problem: Sort first half in ascending and second half in descending order. Solution: */

  /**
   * 411. Problem: Find element in a sorted array whose frequency is greater than or equal to n/2..
   * Solution:
   */

  /**
   * 412. Problem: Smallest element repeated exactly ‘k’ times (not limited to small range).
   * Solution:
   */

  /** 413. Problem: Longest Subarray having sum of elements atmost &#8216;k&#8217;. Solution: */

  /**
   * 414. Problem: Sum of array elements that is first continuously increasing then decreasing.
   * Solution:
   */

  /** 415. Problem: Binary array after M range toggle operations. Solution: */

  /** 416. Problem: Count number of distinct pairs whose sum exists in the given array. Solution: */

  /** 417. Problem: Collect maximum points in an array with k moves. Solution: */

  /**
   * 418. Problem: Move all negative numbers to beginning and positive to end with constant extra
   * space. Solution:
   */

  /** 419. Problem: Minimum absolute difference of XOR values of two subarrays. Solution: */

  /**
   * 420. Problem: Find an element in array such that sum of left array is equal to sum of right
   * array. Solution:
   */

  /** 421. Problem: Find minimum cost to buy all books. Solution: */

  /** 422. Problem: Longest increasing subarray. Solution: */

  /** 423. Problem: Maximum sum bitonic subarray. Solution: */

  /**
   * 424. Problem: Find the sum of maximum difference possible from all subset of a given array..
   * Solution:
   */

  /** 425. Problem: Find the index of first 1 in an infinite sorted array of 0s and 1s. Solution: */

  /** 426. Problem: Positive elements at even and negative at odd positions. Solution: */

  /** 427. Problem: Efficiently merging two sorted arrays with O(1) extra space. Solution: */

  /** 428. Problem: Symmetric difference of two sorted array. Solution: */

  /** 429. Problem: Minimum operations to make XOR of array zero. Solution: */

  /** 430. Problem: Minimum operation to make all elements equal in array. Solution: */

  /** 431. Problem: Maximum area rectangle by picking four sides from array. Solution: */

  /** 432. Problem: Array range queries over range queries. Solution: */

  /** 433. Problem: Range sum queries without updates. Solution: */

  /**
   * 434. Problem: Remove minimum number of elements such that no common element exist in both
   * array. Solution:
   */

  /** 435. Problem: Split the array and add the first part to the end. Solution: */

  /** 436. Problem: Find element at given index after a number of rotations. Solution: */

  /** 437. Problem: Remove array end element to maximize the sum of product. Solution: */

  /** 438. Problem: Find element at given index after given range reversals. Solution: */

  /** 439. Problem: Count divisors of array multiplication. Solution: */

  /**
   * 440. Problem: Maximum difference between group of k-elements and rest of the array.. Solution:
   */

  /** 441. Problem: Find Unique pair in an array with pairs of numbers. Solution: */

  /** 442. Problem: Print all subsets of given size of a set. Solution: */

  /**
   * 443. Problem: Unique element in an array where all elements occur k times except one. Solution:
   */

  /**
   * 444. Problem: Maximum possible XOR of every element in an array with another array. Solution:
   */

  /** 445. Problem: Number of subarrays having product less than K. Solution: */

  /** 446. Problem: Count all subsequences having product less than K. Solution: */

  /** 447. Problem: Maximum value of |arr[i] &#8211; arr[j]| + |i &#8211; j|. Solution: */

  /**
   * 448. Problem: Minimum number of increment-other operations to make all array elements equal..
   * Solution:
   */

  /** 449. Problem: Queries for counts of multiples in an array. Solution: */

  /** 450. Problem: Steps to make array empty by removing maximum and its right side. Solution: */

  /** 451. Problem: K-th Largest Sum Contiguous Subarray. Solution: */

  /** 452. Problem: Minimum and Maximum sum of absolute differences of pairs. Solution: */

  /**
   * 453. Problem: Minimum Possible value of |ai + aj &#8211; k| for given array and k.. Solution:
   */

  /** 454. Problem: Average numbers in array. Solution: */

  /**
   * 455. Problem: Find maximum sum of triplets in an array such than i &lt; j &lt; k and a[i] &lt;
   * a[j] &lt; a[k]. Solution:
   */

  /**
   * 456. Problem: Minimum element whose n-th power is greater than product of an array of size n.
   * Solution:
   */

  /**
   * 457. Problem: Rearrange array such that even index elements are smaller and odd index elements
   * are greater. Solution:
   */

  /**
   * 458. Problem: Longest alternating sub-array starting from every index in a Binary Array.
   * Solution:
   */

  /** 459. Problem: Count ways of choosing a pair with maximum difference. Solution: */

  /**
   * 460. Problem: Print modified array after executing the commands of addition and subtraction.
   * Solution:
   */

  /** 461. Problem: Number of subarrays whose minimum and maximum are same. Solution: */

  /** 462. Problem: Print next greater number of Q queries. Solution: */

  /** 463. Problem: Minimum cost to connect weighted nodes represented as array. Solution: */

  /** 464. Problem: Mean of range in array. Solution: */

  /** 465. Problem: Distance of closest zero to every element. Solution: */

  /** 466. Problem: Pairs with Difference less than K. Solution: */

  /** 467. Problem: Maximize the sum of arr[i]*i. Solution: */

  /** 468. Problem: Minimum product of k integers in an array of positive Integers. Solution: */

  /** 469. Problem: Maximize value of (a[i]+i)*(a[j]+j) in an array. Solution: */

  /** 470. Problem: k size subsets with maximum difference d between max and min. Solution: */

  /** 471. Problem: Array Queries for multiply, replacements and product. Solution: */

  /** 472. Problem: Count number of elements between two given elements in array. Solution: */

  /**
   * 473. Problem: Shuffle array {a1, a2, .. an, b1, b2, .. bn} as {a1, b1, a2, b2, a3, b3, ……, an,
   * bn} without using extra space. Solution:
   */

  /** 474. Problem: Combinations from n arrays picking one element from each array. Solution: */

  /** 475. Problem: Program for Mean and median of an unsorted array. Solution: */

  /** 476. Problem: Counting inversions in all subarrays of given size. Solution: */

  /** 477. Problem: Queries on probability of even or odd number in given ranges. Solution: */

  /**
   * 478. Problem: Divide an array into k segments to maximize maximum of segment minimums.
   * Solution:
   */

  /** 479. Problem: Pairs of Positive Negative values in an array. Solution: */

  /** 480. Problem: Find single in an array of 2n+1 integer elements. Solution: */

  /** 481. Problem: Program for Variance and Standard Deviation of an array. Solution: */

  /** 482. Problem: Check if a given array is pairwise sorted or not. Solution: */

  /** 483. Problem: Maximum even sum subsequence. Solution: */

  /**
   * 484. Problem: Given an array and three numbers, maximize (x * a[i]) + (y * a[j]) + (z * a[k]).
   * Solution:
   */

  /** 485. Problem: Find the first, second and third minimum elements in an array. Solution: */

  /** 486. Problem: Count number of even and odd elements in an array. Solution: */

  /** 487. Problem: Programming puzzle (Assign value without any control statement). Solution: */

  /** 488. Problem: Program for product of array. Solution: */

  /** 489. Problem: Next Greater Frequency Element. Solution: */

  /** 490. Problem: Possibility of moving out of maze. Solution: */

  /**
   * 491. Problem: Rearrange positive and negative numbers using inbuilt sort function. Solution:
   */

  /** 492. Problem: Minimum sum by choosing minimum of pairs from array. Solution: */

  /** 493. Problem: Frequency of each element in an unsorted array. Solution: */

  /** 494. Problem: Introduction to Arrays. Solution: */

  /** 495. Problem: Index Mapping (or Trivial Hashing) with negatives allowed. Solution: */

  /**
   * 496. Problem: Lambda expression in Python to rearrange positive and negative numbers. Solution:
   */

  /** 497. Problem: Find the frequency of a number in an array. Solution: */

  /**
   * 498. Problem: Count frequencies of all elements in array in Python using collections module.
   * Solution:
   */

  /** 499. Problem: Check if an encoding represents a unique binary string. Solution: */

  /** 500. Problem: Array sum in C++ STL. Solution: */

  /** 501. Problem: Even numbers at even index and odd numbers at odd index. Solution: */

  /**
   * 502. Problem: Minimum absolute difference of adjacent elements in a circular array. Solution:
   */

  /** 503. Problem: Divide every element of one array by other array elements. Solution: */

  /** 504. Problem: Longest subarray having count of 1s one more than count of 0s. Solution: */

  /** 505. Problem: Largest Derangement of a Sequence. Solution: */

  /** 506. Problem: Number of NGEs to the right. Solution: */

  /**
   * 507. Problem: Longest subsequence such that difference between adjacents is one | Set 2.
   * Solution:
   */

  /**
   * 508. Problem: Lexicographically smallest permutation with distinct elements using minimum
   * replacements. Solution:
   */

  /** 509. Problem: Maximum sum subsequence with at-least k distant elements. Solution: */

  /** 510. Problem: Program for weighted mean of natural numbers.. Solution: */

  /** 511. Problem: Count ways to form minimum product triplets. Solution: */

  /** 512. Problem: Merge two sorted arrays in Python using heapq. Solution: */

  /**
   * 513. Problem: Find four missing numbers in an array containing elements from 1 to N. Solution:
   */

  /**
   * 514. Problem: Sum of array elements after every element x is XORed itself x times. Solution:
   */

  /** 515. Problem: Move all zeroes to end of array using List Comprehension in Python. Solution: */

  /** 516. Problem: Subsequences of size three in an array whose sum is divisible by m. Solution: */

  /** 517. Problem: Powers of two and subsequences. Solution: */

  /** 518. Problem: Number of steps to convert to prime factors. Solution: */

  /** 519. Problem: Smallest subarray with k distinct numbers. Solution: */

  /**
   * 520. Problem: Number of cyclic elements in an array where we can jump according to value.
   * Solution:
   */

  /**
   * 521. Problem: intersection_update() in Python to find common elements in n arrays. Solution:
   */

  /** 522. Problem: Longest subsequence with no 0 after 1. Solution: */

  /**
   * 523. Problem: Elements to be added so that all elements of a range are present in array.
   * Solution:
   */

  /** 524. Problem: Longest subarray not having more then K distinct elements. Solution: */

  /** 525. Problem: Set update() in Python to do union of n arrays. Solution: */

  /** 526. Problem: Minimum sum of product of two arrays. Solution: */

  /** 527. Problem: Python program to add two matrices. Solution: */

  /**
   * 528. Problem: Only integer with positive value in positive negative value in array. Solution:
   */

  /** 529. Problem: Minimum 1s to lend power to make whole array powerful. Solution: */

  /** 530. Problem: Find array with k number of merge sort calls. Solution: */

  /** 531. Problem: Check whether the given array is perfect or not. Solution: */

  /** 532. Problem: Longest Increasing subarray with one change allowed. Solution: */

  /** 533. Problem: Largest increasing subsequence of consecutive integers. Solution: */

  /**
   * 534. Problem: Largest in array without using conditionals / bitwise / ternary operators.
   * Solution:
   */

  /** 535. Problem: Maximum Unique Element in every subarray of size K. Solution: */

  /** 536. Problem: Minimum replacements to make elements of a ternary array same. Solution: */

  /** 537. Problem: Products of ranges in an array. Solution: */

  /** 538. Problem: Dividing an array into two halves of same sum. Solution: */

  /** 539. Problem: Make three non-empty sets with negative, positive and 0 products. Solution: */

  /** 540. Problem: Minimum operations to make the MEX of the given set equal to x. Solution: */

  /** 541. Problem: Array element moved by k using single moves. Solution: */

  /** 542. Problem: Non-overlapping sum of two sets. Solution: */

  /**
   * 543. Problem: Merging elements of two different arrays alternatively in third array. Solution:
   */

  /** 544. Problem: Maximum consecutive numbers present in an array. Solution: */

  /** 545. Problem: Longest sequence of positive integers in an array. Solution: */

  /** 546. Problem: Number of visible boxes after putting one inside another. Solution: */

  /** 547. Problem: Longest subsequence having equal numbers of 0 and 1. Solution: */

  /**
   * 548. Problem: Differences between number of increasing subarrays and decreasing subarrays in k
   * sized windows. Solution:
   */

  /** 549. Problem: Count sub-arrays which have elements less than or equal to X. Solution: */

  /** 550. Problem: GCD of array is greater than one. Solution: */

  /** 551. Problem: Pair with given sum and maximum shortest distance from end. Solution: */

  /** 552. Problem: Last seen array element (last appearance is earliest). Solution: */

  /** 553. Problem: Minimum gcd operations to make all array elements one. Solution: */

  /**
   * 554. Problem: Minimum flips to make all 1s in left and 0s in right | Set 1 (Using Bitmask).
   * Solution:
   */

  /** 555. Problem: Minimum flips to make all 1s in left and 0s in right | Set 2. Solution: */

  /** 556. Problem: Find minimum in an array without using Relational Operators. Solution: */

  /** 557. Problem: Number of subarrays with maximum values in given range. Solution: */

  /**
   * 558. Problem: Construct a distinct elements array with given size, sum and element upper bound.
   * Solution:
   */

  /** 559. Problem: Find maximum in an array without using Relational Operators. Solution: */

  /** 560. Problem: Program for Bridge and Torch problem. Solution: */

  /**
   * 561. Problem: Maximum array sum with prefix and suffix multiplications with -1 allowed.
   * Solution:
   */

  /** 562. Problem: Find element in array that divides all array elements. Solution: */

  /** 563. Problem: Closest greater element for every array element from another array. Solution: */

  /**
   * 564. Problem: Minimizing array sum by subtracting larger elements from smaller ones. Solution:
   */

  /** 565. Problem: Maximizing array sum with given operation. Solution: */

  /** 566. Problem: Number of pairs with maximum sum. Solution: */

  /** 567. Problem: Find closest number in array. Solution: */

  /**
   * 568. Problem: Generate original array from an array that store the counts of greater elements
   * on right. Solution:
   */

  /** 569. Problem: Find smallest subarray that contains all elements in same order. Solution: */

  /** 570. Problem: Maximum AND value of a pair in an array. Solution: */

  /** 571. Problem: Two Pointers Technique. Solution: */

  /** 572. Problem: Probability of a random pair being the maximum weighted pair. Solution: */

  /** 573. Problem: Maximum array from two given arrays keeping order same. Solution: */

  /** 574. Problem: Sparse Table. Solution: */

  /**
   * 575. Problem: No of pairs (a[j] >= a[i]) with k numbers in range (a[i], a[j]) that are
   * divisible by x. Solution:
   */

  /** 576. Problem: Maximum size subset with given sum. Solution: */

  /** 577. Problem: Find mean of subarray means in a given array. Solution: */

  /** 578. Problem: Length of longest strict bitonic subsequence. Solution: */

  /** 579. Problem: Product of maximum in first array and minimum in second. Solution: */

  /** 580. Problem: Binary Tree (Array implementation). Solution: */

  /** 581. Problem: Find largest element from array without using conditional operator. Solution: */

  /** 582. Problem: Count subarrays where second highest lie before highest. Solution: */

  /** 583. Problem: Game of replacing array elements. Solution: */

  /** 584. Problem: Largest divisible pairs subset. Solution: */

  /** 585. Problem: Add 1 to number represented as array | Recursive Approach. Solution: */

  /** 586. Problem: Circular array. Solution: */

  /**
   * 587. Problem: Check if the last element of array is even or odd after performing a operation p
   * times. Solution:
   */

  /** 588. Problem: Print n smallest elements from given array in their original order. Solution: */

  /** 589. Problem: Count pairs in array whose sum is divisible by 4. Solution: */

  /** 590. Problem: Probability of choosing a random pair with maximum sum in an array. Solution: */

  /**
   * 591. Problem: Longest alternating (positive and negative) subarray starting at every index.
   * Solution:
   */

  /**
   * 592. Problem: Count of suffix increment/decrement operations to construct a given array.
   * Solution:
   */

  /** 593. Problem: Longest Increasing Odd Even Subsequence. Solution: */

  /** 594. Problem: Make alphabets using the elements of an array. Solution: */

  /** 595. Problem: Queries on Left and Right Circular shift on array. Solution: */

  /** 596. Problem: De-arrangements for minimum product sum of two arrays. Solution: */

  /** 597. Problem: Length of longest increasing circular subarray. Solution: */

  /** 598. Problem: Count of possible hexagonal walks. Solution: */

  /**
   * 599. Problem: Check whether second string can be formed from characters of first string.
   * Solution:
   */

  /** 600. Problem: Ways to split array into two groups of same XOR value. Solution: */

  /**
   * 601. Problem: Longest subsegment of &#8216;1&#8217;s formed by changing at most k
   * &#8216;0&#8217;s. Solution:
   */

  /** 602. Problem: Maximum distinct elements after removing k elements. Solution: */

  /** 603. Problem: Queries on XOR of XORs of all subarrays. Solution: */

  /** 604. Problem: Maximum sum of pairwise product in an array with negative allowed. Solution: */

  /** 605. Problem: Find a rotation with maximum hamming distance. Solution: */

  /** 606. Problem: Program to generate random alphabets. Solution: */

  /**
   * 607. Problem: Partition into two subarrays of lengths k and (N &#8211; k) such that the
   * difference of sums is maximum. Solution:
   */

  /** 608. Problem: Rearrange array such that even positioned are greater than odd. Solution: */

  /** 609. Problem: Minimum insertions to make a Co-prime array. Solution: */

  /** 610. Problem: Count number of increasing subsequences of size k. Solution: */

  /** 611. Problem: Maximum triplet sum in array. Solution: */

  /** 612. Problem: Double the first element and move zero to end. Solution: */

  /** 613. Problem: Smallest subarray with all occurrences of a most frequent element. Solution: */

  /** 614. Problem: Longest subarray with sum divisible by k. Solution: */

  /** 615. Problem: Move all zeroes to end of array | Set-2 (Using single traversal). Solution: */

  /** 616. Problem: Change the array into a permutation of numbers from 1 to n. Solution: */

  /** 617. Problem: Backtracking to find all subsets. Solution: */

  /** 618. Problem: Program to reverse an array using pointers. Solution: */

  /** 619. Problem: Count subarrays with equal number of 1&#8217;s and 0&#8217;s. Solution: */

  /** 620. Problem: Maximum product of an increasing subsequence. Solution: */

  /** 621. Problem: Minimum number of subsets with distinct elements. Solution: */

  /** 622. Problem: k smallest elements in same order using O(1) extra space. Solution: */

  /** 623. Problem: Operations on Sparse Matrices. Solution: */

  /** 624. Problem: Parallel Array. Solution: */

  /**
   * 625. Problem: Check if it is possible to make array equal by doubling or tripling. Solution:
   */

  /**
   * 626. Problem: Find the number of consecutive zero at the end after multiplying n numbers.
   * Solution:
   */

  /** 627. Problem: Smallest subset with sum greater than all other elements. Solution: */

  /** 628. Problem: Minimum number of subtract operation to make an array decreasing. Solution: */

  /**
   * 629. Problem: Value of k-th index of a series formed by append and insert MEX in middle.
   * Solution:
   */

  /** 630. Problem: Largest subset with sum of every pair as prime. Solution: */

  /** 631. Problem: Count of subsequences having maximum distinct elements. Solution: */

  /**
   * 632. Problem: Intersection of two arrays in Python ( Lambda expression and filter function ).
   * Solution:
   */

  /** 633. Problem: Prefix sum array in Python using accumulate function. Solution: */

  /**
   * 634. Problem: Python List Comprehension to find pair with given sum from two arrays. Solution:
   */

  /** 635. Problem: Python Set difference to find lost element from a duplicated array. Solution: */

  /**
   * 636. Problem: Python | Check if all the values in a list that are greater than a given value.
   * Solution:
   */

  /** 637. Problem: Minimum cost to make array size 1 by removing larger of pairs. Solution: */

  /** 638. Problem: Range sum query using Sparse Table. Solution: */

  /**
   * 639. Problem: Range Query on array whose each element is XOR of index value and previous
   * element. Solution:
   */

  /**
   * 640. Problem: Maximum number of chocolates to be distributed equally among k students.
   * Solution:
   */

  /**
   * 641. Problem: Check if array contains contiguous integers with duplicates allowed. Solution:
   */

  /** 642. Problem: Maximum OR sum of sub-arrays of two different arrays. Solution: */

  /** 643. Problem: Rearrange an array such that arr[i] = i. Solution: */

  /** 644. Problem: Sum triangle from array. Solution: */

  /**
   * 645. Problem: Minimize (max(A[i], B[j], C[k]) &#8211; min(A[i], B[j], C[k])) of three different
   * sorted arrays. Solution:
   */

  /** 646. Problem: Add two numbers represented by two arrays. Solution: */

  /** 647. Problem: Maximum in array which is at-least twice of other elements. Solution: */

  /** 648. Problem: Find LCM of rational numbers. Solution: */

  /** 649. Problem: Find reminder of array multiplication divided by n. Solution: */

  /** 650. Problem: Longest sub-array having sum k. Solution: */

  /**
   * 651. Problem: Find last element after deleting every second element in array of n integers.
   * Solution:
   */

  /** 652. Problem: Distance between two closest minimum. Solution: */

  /**
   * 653. Problem: Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if i
   * is odd and j < i. Solution:
   */

  /** 654. Problem: Check if an array is stack sortable. Solution: */

  /** 655. Problem: Growable array based stack. Solution: */

  /** 656. Problem: K maximum sum combinations from two arrays. Solution: */

  /** 657. Problem: Maximum absolute difference of value and index sums. Solution: */
  int maxAbsoluteDiff(int[] array) {
    int max1 = Integer.MIN_VALUE,
        min1 = Integer.MAX_VALUE,
        max2 = Integer.MIN_VALUE,
        min2 = Integer.MAX_VALUE;

    for (int i = 0; i < array.length; i++) {
      max1 = Math.max(max1, array[i] + i);
      min1 = Math.min(min1, array[i] + i);
      max2 = Math.max(max2, array[i] - i);
      min2 = Math.min(min2, array[i] - i);
    }
    return Math.max(max1 - min1, max2 - min2);
  }

  /**
   * 658. Problem: Possible to make a divisible by 3 number using all digits in an array. Solution:
   */

  /** 659. Problem: Sum of consecutive two elements in a array. Solution: */

  /** 660. Problem: Sparse Matrix Representations | Set 3 ( CSR ). Solution: */

  /** 661. Problem: Number of local extrema in an array. Solution: */

  /** 662. Problem: Kronecker Product of two matrices. Solution: */

  /** 663. Problem: K maximum sums of non-overlapping contiguous sub-arrays. Solution: */

  /** 664. Problem: Merge 3 Sorted Arrays. Solution: */

  /** 665. Problem: Check if an array has a majority element. Solution: */

  /** 666. Problem: Sum of an array using pthreads. Solution: */

  /** 667. Problem: Find the one missing number in range. Solution: */

  /** 668. Problem: Rank of all elements in an array. Solution: */

  /** 669. Problem: Insertion Sort by Swapping Elements. Solution: */

  /** 670. Problem: Closest numbers from a list of unsorted integers. Solution: */

  /** 671. Problem: Sum of f(a[i], a[j]) over all pairs in an array of n integers. Solution: */

  /** 672. Problem: Find number of pairs in an array such that their XOR is 0. Solution: */

  /** 673. Problem: Count number of trailing zeros in product of array. Solution: */

  /**
   * 674. Problem: Minimum pair sum operations to make array each element divisible by 4. Solution:
   */

  /** 675. Problem: Optimal partition of an array into four parts. Solution: */

  /** 676. Problem: Find last k digits in product of an array numbers. Solution: */

  /** 677. Problem: Maximum subarray sum in O(n) using prefix sum. Solution: */

  /** 678. Problem: Making elements distinct in a sorted array by minimum increments. Solution: */

  /** 679. Problem: K maximum sums of overlapping contiguous sub-arrays. Solution: */

  /** 680. Problem: Dope Vector. Solution: */

  /** 681. Problem: Program for Coefficient of variation. Solution: */

  /** 682. Problem: Skewness of statistical data. Solution: */

  /** 683. Problem: Find if neat arrangement of cups and shelves can be made. Solution: */

  /**
   * 684. Problem: Maximum subarray sum in an array created after repeated concatenation. Solution:
   */

  /** 685. Problem: Consecutive steps to roof top. Solution: */

  /** 686. Problem: Difference Array | Range update query in O(1). Solution: */

  /** 687. Problem: Construct sum-array with sum of elements in given range. Solution: */

  /** 688. Problem: Program to implement t-test. Solution: */

  /** 689. Problem: Print intermediate values in an array. Solution: */

  /** 690. Problem: Reversal algorithm for right rotation of an array. Solution: */

  /** 691. Problem: Sum of even numbers at even position. Solution: */

  /** 692. Problem: Largest number that is not a perfect square. Solution: */

  /** 693. Problem: Sum of XOR of all pairs in an array. Solution: */

  /** 694. Problem: Ropes left after every removal of smallest. Solution: */

  /** 695. Problem: Numbers with prime frequencies greater than or equal to k. Solution: */

  /**
   * 696. Problem: Find a Fixed Point (Value equal to index) in a given array | Duplicates Allowed.
   * Solution:
   */

  /** 697. Problem: Find the longest sub-array having exactly k odd numbers. Solution: */

  /** 698. Problem: Smallest subarray with product divisible by k. Solution: */

  /** 699. Problem: Number of distinct subsets of a set. Solution: */

  /**
   * 700. Problem: Minimum array size after repeated replacement of even sum pair with sum.
   * Solution:
   */

  /** 701. Problem: Minimum sum of multiplications of n numbers. Solution: */

  /** 702. Problem: Array sum after dividing numbers from previous. Solution: */

  /** 703. Problem: HCF of array of fractions (or rational numbers). Solution: */

  /** 704. Problem: Find an array element such that all elements are divisible by it. Solution: */

  /** 705. Problem: Minimum total cost incurred to reach the last station. Solution: */

  /** 706. Problem: Segregate even and odd numbers | Set 2. Solution: */

  /** 707. Problem: Find the missing integer in an array if mean is given. Solution: */

  /** 708. Problem: Inverse Permutation. Solution: */

  /**
   * 709. Problem: Find final value if we double after every successful search in array. Solution:
   */

  /** 710. Problem: Sort on the basis of number of factors using STL. Solution: */

  /** 711. Problem: Minimum distance between two occurrences of maximum. Solution: */

  /** 712. Problem: Practice questions on Arrays. Solution: */

  /** 713. Problem: Array Index with same count of even or odd numbers on both sides. Solution: */

  /**
   * 714. Problem: Shuffle 2n integers as a1-b1-a2-b2-a3-b3-..bn without using extra space.
   * Solution:
   */

  /** 715. Problem: Number of unique triplets whose XOR is zero. Solution: */

  /** 716. Problem: Sparse Search. Solution: */

  /** 717. Problem: Sorted merge in one array. Solution: */

  /** 718. Problem: Completion time of a given process in round robin. Solution: */

  /** 719. Problem: Pairs such that one is a power multiple of other. Solution: */

  /** 720. Problem: Maximum sum of increasing order elements from n arrays. Solution: */

  /** 721. Problem: Check if the array is beautiful. Solution: */

  /** 722. Problem: Minimum Swaps required to group all 1&#8217;s together. Solution: */

  /**
   * 723. Problem: Find set of m-elements with difference of any two elements is divisible by k.
   * Solution:
   */

  /**
   * 724. Problem: Minimum swaps required to bring all elements less than or equal to k together.
   * Solution:
   */

  /** 725. Problem: Maximum difference between two subsets of m elements. Solution: */

  /** 726. Problem: String with maximum number of unique characters. Solution: */

  /** 727. Problem: Find relative complement of two sorted arrays. Solution: */

  /** 728. Problem: Searching in an array where adjacent differ by at most k. Solution: */

  /**
   * 729. Problem: Maximum number of partitions that can be sorted individually to make sorted.
   * Solution:
   */

  /** 730. Problem: Print all triplets in sorted array that form AP. Solution: */

  /** 731. Problem: Print uncommon elements from two sorted arrays. Solution: */

  /** 732. Problem: Sort 1 to N by swapping adjacent elements. Solution: */

  /** 733. Problem: Evaluate an array expression with numbers, + and &#8211;. Solution: */

  /** 734. Problem: Minimum removals from array to make max – min <= K Solution: */

  /** 735. Problem: Least frequent element in an array Solution: */

  /** 736. Problem: Minimum increment by k operations to make all elements equal Solution: */

  /** 737. Problem: Check given array of size n can represent BST of n levels or not Solution: */

  /** 738. Problem: Shortest Un-ordered Subarray Solution: */

  /** 739. Problem: Find the only repetitive element between 1 to n-1 Solution: */

  /** 740. Problem: Number of subarrays with given product Solution: */

  /** 741. Problem: Front and Back Search in unsorted array Solution: */

  /**
   * 742. Problem: Sort the linked list in the order of elements appearing in the array Solution:
   */

  /** 743. Problem: Insert in sorted and non-overlapping interval array Solution: */

  /** 744. Problem: Static Data Structure vs Dynamic Data Structure Solution: */

  /** 745. Problem: Sort an array containing two types of elements Solution: */

  /** 746. Problem: Sorting all array elements except one Solution: */
  void sortExceptOne(int[] array, int k) {
    swap(array, k, array.length - 1);
    Arrays.sort(array, 0, array.length - 1);
    int key = array[array.length - 1];
    for (int i = array.length - 1; i > k; i--) {
      array[i] = array[i - 1];
    }
    array[k] = key;
  }

  /** 745. Problem: Rank of an element in a stream Solution: */

  /** 745. Problem: Non-Repeating Element Solution: */

  /* Function to get pivot. For array 3, 4, 5, 6, 1, 2 it returns
  3 (index of 6) */
  int findPivot(int arr[], int low, int high) {
    if (high < low) return -1;
    else if (high == low) return low;
    else {
      int mid = (low + high) / 2;
      if (mid < high && arr[mid] > arr[mid + 1]) return mid;
      else if (mid > low && arr[mid] < arr[mid - 1]) return (mid - 1);
      else if (arr[low] >= arr[mid]) return findPivot(arr, low, mid - 1);
      else return findPivot(arr, mid + 1, high);
    }
  }

  /*
   * You have 100 coins which needs to be distributed among 3 beggars A, B, C. In how many ways you can distribute these 100 coins to all the 3 beggars. Constraint: A cannot have more than 75 coins, B cannot have more than 50 coins, C cannot have more than 25 coins. Write complete code covering all the edge cases. Also suggest test cases.
   * */
  int distributeCoins() {
    int count = 0;
    for (int c = 25; c >= 0; c--) {
      for (int b = 50; b >= 0; b--) {
        if (100 - b - c <= 75) {
          count++;
          System.out.println("A = " + (100 - b - c) + " B = " + b + " C = " + c);
        }
      }
    }
    return count;
  }

  public void searchRange(int[] A, int target, int left, int right, int[] range) {
    if (left > right) return;
    int mid = left + (right - left) / 2;
    if (A[mid] == target) {
      if (mid < range[0]) {
        range[0] = mid;
        searchRange(A, target, left, mid - 1, range);
      }
      if (mid > range[1]) {
        range[1] = mid;
        searchRange(A, target, mid + 1, right, range);
      }
    } else if (A[mid] < target) {
      searchRange(A, target, mid + 1, right, range);
    } else {
      searchRange(A, target, left, mid - 1, range);
    }
  }
}
