package algorithms.divideandconquer;

import algorithms.searching.SearchingExamples;

/**
 * Created by abhay on 07/07/17.
 */
public class DACExamples {
  private SearchingExamples searchingExamples = new SearchingExamples();
  /** 1. Problem: Write a program to calculate pow(x,n). */


  /** 2. Problem: Median of two sorted arrays of same size. */

  /** 3. Problem: Count Inversions in an array | Set 1 (Using Merge Sort). */

  /** 4. Problem: Check for Majority Element in a sorted array. */
  boolean isMajorityElement(int[] array, int x) {
    int first = searchingExamples.leftBinarySearch(array, x, 0, array.length);
    if (first == -1) return false;
    else if (first + array.length / 2 < array.length && array[array.length / 2 + first] == x) return true;
    else return false;
  }

  /** 5. Problem: Maximum and minimum of an array using minimum number of comparisons. */

  /** 6. Problem: Write you own Power without using multiplication(*) and division(/) operators. */

  /** 7. Problem: Program to count number of set bits in an (big) array. */

  /** 8. Problem: Count number of occurrences (or frequency) in a sorted array. */

  /** 9. Problem: Find a Fixed Point (Value equal to index) in a given array. */

  /** 10. Problem: Find the maximum element in an array which is first increasing and then decreasing. */

  /** 11. Problem: Median of two sorted arrays of different sizes. */

  /** 12. Problem: Divide and Conquer | Set 1 (Introduction). */

  /** 13. Problem: Divide and Conquer | Set 2 (Closest Pair of Points). */

  /** 14. Problem: Merge Sort. */

  /** 15. Problem: Divide and Conquer | Set 3 (Maximum Subarray Sum). */

  /** 16. Problem: Largest Rectangular Area in a Histogram | Set 1. */

  /** 17. Problem: Divide and Conquer | Set 4 (Karatsuba algorithm for fast multiplication). */

  /** 18. Problem: Find a peak element. */

  /** 19. Problem: Unbounded Binary Search Example (Find the point where a monotonically increasing function becomes positive first time). */

  /** 20. Problem: Find the minimum element in a sorted and rotated array. */

  /** 21. Problem: Closest Pair of Points |  O(nlogn) Implementation. */

  /** 22. Problem: QuickSort. */

  /** 23. Problem: Binary Search. */

  /** 24. Problem: Divide and Conquer | Set 5 (Strassen&#8217;s Matrix Multiplication). */

  /** 25. Problem: Find the number of zeroes. */

  /** 26. Problem: Divide and Conquer | Set 6 (Search in a Row-wise and Column-wise Sorted 2D Array). */

  /** 27. Problem: Multiply two polynomials. */

  /** 28. Problem: Find the missing number in Arithmetic Progression. */

  /** 29. Problem: Divide and Conquer | Set 6 (Tiling Problem). */

  /** 30. Problem: Divide and Conquer | Set 7 (The Skyline Problem). */

  /** 31. Problem: Find the element that appears once in a sorted array. */

  /** 32. Problem: Square root of an integer. */

  /** 33. Problem: Longest Common Prefix | Set 3 (Divide and Conquer). */

  /** 34. Problem: Find frequency of each element in a limited range array in less than O(n) time. */

  /** 35. Problem: Find cubic root of a number. */

  /** 36. Problem: Floor in a Sorted Array. */

  /** 37. Problem: Find the only repeating element in a sorted array of size n. */

  /** 38. Problem: Find bitonic point in given bitonic sequence. */

  /** 39. Problem: Minimum difference between adjacent elements of array which contain elements from each row of a matrix. */

  /** 40. Problem: Find the Rotation Count in Rotated Sorted array. */

  /** 41. Problem: Easy way to remember Strassen’s Matrix Equation. */

  /** 42. Problem: Allocate minimum number of pages. */

  /** 43. Problem: Place k elements such that minimum distance is maximized. */

  /** 44. Problem: Quickhull Algorithm for Convex Hull. */

  /** 45. Problem: Search element in a sorted matrix. */

  /** 46. Problem: Find a peak element in a 2D array. */

  /** 47. Problem: Collect all coins in minimum number of steps. */

  /** 48. Problem: K-th Element of Two Sorted Arrays. */

  /** 49. Problem: Convex Hull (Simple Divide and Conquer Algorithm). */

  /** 50. Problem: Find index of an extra element present in one sorted array. */

  /** 51. Problem: Shuffle 2n integers in format {a1, b1, a2, b2, a3, b3, &#8230;&#8230;, an, bn} without using extra space. */

  /** 52. Problem: Number of days after which tank will become empty. */

  /** 53. Problem: Find closest number in array. */

  /** 54. Problem: The painter&#8217;s partition problem |  Set 2. */

  /** 55. Problem: Fast Fourier Transformation for poynomial multiplication. */

  /** 56. Problem: Iterative Fast Fourier Transformation for polynomial multiplication. */

  /** 57. Problem: Numbers whose factorials end with n zeros. */

  /** 58. Problem: Binary Search using pthread. */

  /** 59. Problem: Decrease and Conquer. */

  /** 60. Problem: Binary Search on Singly Linked List. */

  /** 61. Problem: Distinct elements in subarray using Mo&#8217;s Algorithm. */



}
