package algorithms.searching;

import data.structures.arrays.ArrayExamples;
import java.util.Arrays;

public class SearchingExamples {
  private ArrayExamples arrayExamples = new ArrayExamples();
  /**
   * 1. Problem: Find the Missing Number. You are given a list of n-1 integers and these integers
   * are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in
   * the list. Write an efficient code to find the missing integer.
   */
  int findMissingNumber(int[] list, int n) {
    int x1 = Arrays.stream(list).reduce(0, (a, b) -> a ^ b);
    int x2 = 0;
    for (int i = 1; i <= n; i++) x2 ^= i;
    return x1 ^ x2;
  }

  /**
   * 2. Problem: Search an element in a sorted and rotated array.
   */
  int rotatedBinarySearch(int[] array, int key) {
    return arrayExamples.binarySearchRotated(array, key, 0, array.length - 1);
  }


  /**
   * 3. Problem: Median of two sorted arrays. Solution: Either merge two arrays which will take O(m
   * + n) or use divide and conquer by getting medians of each array and comparing till they are
   * equal. O(logn).
   */

  /** 4. Problem: Two elements whose sum is closest to zero. Solution: */

  /** 5. Problem: Find the smallest and second smallest elements in an array. Solution: */

  /** 6. Problem: Maximum and minimum of an array using minimum number of comparisons. Solution: */

  /** 7. Problem: k largest(or smallest) elements in an array | added Min Heap method. Solution: */

  /**
   * 8. Problem: Ceiling in a sorted array. Solution: Use modified binary search to find floor and
   * ceiling separately. Hint: If x is greater than arr[mid], then either arr[mid + 1] is ceiling of
   * x or ceiling lies in arr[mid+1...high]
   */

  /** 9. Problem: Count number of occurrences (or frequency) in a sorted array. */
  int frequency(int[] array, int key) {
    int first = leftBinarySearch(array, key, 0, array.length - 1);
    if (first == -1) {
      return -1;
    } else {
      int second = rightBinarySearch(array, key, 0, array.length - 1);
      return second - first + 1;
    }
  }

  int leftBinarySearch(int[] array, int key, int start, int end) {
    if (start <= end) {
      int mid = start + (end - start) / 2;
      if (foundLeftInside(array, key, mid) && foundOnLeftEdge(array, key, mid)) {
        return mid;
      } else if (array[mid] >= key) {
        return leftBinarySearch(array, key, start, mid - 1);
      } else {
        return leftBinarySearch(array, key, mid + 1, end);
      }
    }
    return -1;
  }

  int rightBinarySearch(int[] array, int key, int start, int end) {
    if (start <= end) {
      int mid = start + (end - start) / 2;
      if (foundRightInside(array, key, mid) && foundOnRightEdge(array, key, mid)) {
        return mid;
      } else if (array[mid] > key) {
        return rightBinarySearch(array, key, start, mid - 1);
      } else {
        return rightBinarySearch(array, key, mid + 1, end);
      }
    }
    return -1;
  }

  private boolean foundOnLeftEdge(int[] array, int key, int mid) {
    return mid == 0 && array[mid] == key;
  }

  private boolean foundLeftInside(int[] array, int key, int mid) {
    return 0 <= mid - 1 && array[mid - 1] < key && array[mid] == key;
  }

  private boolean foundOnRightEdge(int[] array, int key, int mid) {
    return mid == array.length - 1 && array[mid] == key;
  }

  private boolean foundRightInside(int[] array, int key, int mid) {
    return mid + 1 < array.length && key < array[mid + 1] && array[mid] == key;
  }

  /** 10. Problem: Interpolation search vs Binary search. Solution: */

  /** 11. Problem: Find the repeating and the missing | Added 3 new methods. Solution: */

  /**
   * 12. Problem: Find a Fixed Point (Value equal to index) in a given array. Given an array of n
   * distinct integers sorted in ascending order, write a function that returns a Fixed Point in the
   * array, if there is any Fixed Point present in array, else returns -1. Fixed Point in an array
   * is an index i such that arr[i] is equal to i. Note that integers in array can be negative.
   * Solution: Use binary search.
   */

  /**
   * 13. Problem: Find the maximum element in an array which is first increasing and then
   * decreasing. Solution:
   */

  /** 14. Problem: Find a pair with the given difference. Solution: */

  /** 15. Problem: Find the k most frequent words from a file. Solution: */

  /** 16. Problem: Median of two sorted arrays of different sizes. Solution: */

  /** 17. Problem: The Ubiquitous Binary Search | Set 1. Solution: */

  /** 18. Problem: Find a peak element. Solution: */

  /**
   * 19. Problem: Given an array of of size n and a number k, find all elements that appear more
   * than n/k times. Solution:
   */

  /**
   * 20. Problem: Unbounded Binary Search Example (Find the point where a monotonically increasing
   * function becomes positive first time). Solution:
   */

  /** 21. Problem: Find the minimum element in a sorted and rotated array. */
  int findMinElement(int[] arr, int left, int right) {
    if (left <= right) {
      int mid = left + (right - left) / 2;
      if (isMinimum(arr, mid)) return arr[mid];
       else if (arr[arr.length - 1] > arr[mid]) return findMinElement(arr, left, mid - 1);
       else return findMinElement(arr, mid + 1, right);
    }
    return -1;
  }

  private boolean isMinimum(int[] array, int mid) {
    int left = mid - 1 >= 0 ? array[mid - 1] : Integer.MAX_VALUE;
    int right = mid + 1 < array.length ? array[mid + 1] : Integer.MAX_VALUE;
    return array[mid] < left && array[mid] < right;
  }

  /** 22. Problem: Binary Search. Solution: */

  /**
   * 23. Problem: Kth smallest element in a row-wise and column-wise sorted 2D array | Set 1.
   * Solution:
   */

  /** 24. Problem: Program to find largest element in an array. Solution: */

  /** 25. Problem: Recursive program to linearly search an element in a given array. Solution: */

  /** 26. Problem: Find k closest elements to a given value. Solution: */

  /** 27. Problem: Search in an almost sorted array. Solution: */

  /** 28. Problem: A Problem in Many Binary Search Implementations. Solution: */

  /** 29. Problem: Find the first repeating element in an array of integers. Solution: */

  /** 30. Problem: Find common elements in three sorted arrays. Solution: */

  /** 31. Problem: Count 1&#8217;s in a sorted binary array. Solution: */

  /**
   * 32. Problem: Given a sorted array and a number x, find the pair in array whose sum is closest
   * to x. Solution:
   */

  /** 33. Problem: Find the closest pair from two sorted arrays. Solution: */

  /** 34. Problem: K&#8217;th Smallest/Largest Element in Unsorted Array | Set 1. Solution: */

  /**
   * 35. Problem: K&#8217;th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
   * Time). Solution:
   */

  /**
   * 36. Problem: K&#8217;th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
   * Time). Solution:
   */

  /**
   * 37. Problem: K&#8217;th Smallest/Largest Element in Unsorted Array | Set 3 (Worst Case Linear
   * Time). Solution:
   */

  /** 38. Problem: Why is Binary Search preferred over Ternary Search?. Solution: */

  /**
   * 39. Problem: Find position of an element in a sorted array of infinite numbers. Solution: Use
   * modified binary search. Let low be pointing to 1st element and high pointing to 2nd element of
   * array. Now compare key with high index element: ->if it is greater than high index element then
   * copy high index in low index and double the high index. ->if it is smaller, then apply binary
   * search on high and low indices found.
   */

  /**
   * 40. Problem: Given a sorted and rotated array, find if there is a pair with a given sum.
   * Solution:
   */

  /** 41. Problem: Find the largest pair sum in an unsorted array. Solution: */

  /** 42. Problem: Find the nearest smaller numbers on left side in an array. Solution: */

  /** 43. Problem: K&#8217;th largest element in a stream. Solution: */

  /** 44. Problem: Recursive function to do substring search. Solution: */

  /** 45. Problem: Find a pair with maximum product in array of Integers. Solution: */

  /** 46. Problem: Find the element that appears once in a sorted array. Solution: */

  /** 47. Problem: Find the odd appearing element in O(Log n) time. Solution: */

  /** 48. Problem: Find the largest three elements in an array. Solution: */

  /**
   * 49. Problem: Search an element in an array where difference between adjacent elements is 1.
   * Solution:
   */

  /** 50. Problem: Find three closest elements from given three sorted arrays. Solution: */

  /**
   * 51. Problem: Find the element before which all the elements are smaller than it, and after
   * which all are greater. Solution:
   */

  /**
   * 52. Problem: Binary Search for Rational Numbers without using floating point arithmetic.
   * Solution:
   */

  /** 53. Problem: Fibonacci Search. Solution: */

  /** 54. Problem: Floor in a Sorted Array. Solution: */

  /** 55. Problem: Third largest element in an array of distinct elements. Solution: */

  /** 56. Problem: Jump Search. Solution: */

  /** 57. Problem: Interpolation Search. Solution: */

  /** 58. Problem: Linear Search. Solution: */

  /** 59. Problem: Linear Search vs Binary Search. Solution: */

  /** 60. Problem: Second minimum element using minimum comparisons. Solution: */

  /** 61. Problem: Queries for greater than and not less than. Solution: */

  /** 62. Problem: Efficient search in an array where difference between adjacent is 1. Solution: */

  /** 63. Problem: Sublist Search (Search a linked list in another list). Solution: */

  /** 64. Problem: Print all possible sums of consecutive numbers with sum N. Solution: */

  /** 65. Problem: Minimum time required to produce m items. Solution: */

  /** 66. Problem: Exponential Search. Solution: */

  /** 67. Problem: Make all array elements equal with minimum cost. Solution: */

  /**
   * 68. Problem: Check if there exist two elements in an array whose sum is equal to the sum of
   * rest of the array. Solution:
   */

  /** 69. Problem: Check if reversing a sub array make the array sorted. Solution: */

  /** 70. Problem: Find all triplets with zero sum. Solution: */

  /** 71. Problem: Search, insert and delete in an unsorted array. Solution: */

  /** 72. Problem: Search, insert and delete in a sorted array. Solution: */

  /** 73. Problem: Move all occurrences of an element to end in a linked list. Solution: */

  /** 74. Problem: Search in an array of strings where non-empty strings are sorted. Solution: */

  /** 75. Problem: Best First Search (Informed Search). Solution: */

  /** 76. Problem: Smallest Difference Triplet from Three arrays. Solution: */

  /** 77. Problem: Recursive Programs to find Minimum and Maximum elements of array. Solution: */

  /**
   * 78. Problem: Count of only repeated element in a sorted array of consecutive elements.
   * Solution:
   */

  /**
   * 79. Problem: Search an element in an unsorted array using minimum number of comparisons.
   * Solution:
   */
}
