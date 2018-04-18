package algorithms.searching;

import data.structures.arrays.ArrayExamples;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class SearchingExamples {
  private ArrayExamples arrayExamples = new ArrayExamples();

  /** 1. Problem: Find the Missing Number. */
  int findMissingNumber(int[] list, int n) {
    int x1 = Arrays.stream(list).reduce(0, (a, b) -> a ^ b);
    int x2 = 0;
    for (int i = 1; i <= n; i++) x2 ^= i;
    return x1 ^ x2;
  }

  /** 2. Problem: Search an element in a sorted and rotated array. */
  int rotatedBinarySearch(int[] array, int key) {
    return arrayExamples.binarySearchRotated(array, key, 0, array.length - 1);
  }

  /** 3. Problem: Median of two sorted arrays of same size. */
  int findMedian(int[] array1, int[] array2, int start1, int end1, int start2, int end2) {
    if (array1.length == 1 && array2.length == 1) return (array1[0] + array1[0]) / 2;
    else {
      int median1 =
          (end1 % 2 == 0)
              ? array1[array1.length / 2] + array1[array1.length / 2 - 1]
              : array1[array1.length / 2];
      int median2 =
          (array2.length % 2 == 0)
              ? array2[array2.length / 2] + array2[array2.length / 2 - 1]
              : array2[array2.length / 2];
      if (median1 == median2) return median1;
      else if (median1 < median2)
        return findMedian(array1, array2, median1 + 1, end1, start2, median2 - 1);
      else return findMedian(array1, array2, start1, median1 - 1, median2 + 1, end2);
    }
  }

  /** 4. Problem: Two elements whose sum is closest to zero. */

  /** 5. Problem: Find the smallest and second smallest elements in an array. */

  /** 6. Problem: Maximum and minimum of an array using minimum number of comparisons. */

  /** 7. Problem: k largest(or smallest) elements in an array | added Min Heap method. */

  /** 8. Problem: Ceiling in a sorted array. */

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

  public int leftBinarySearch(int[] array, int key, int start, int end) {
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

  public int rightBinarySearch(int[] array, int key, int start, int end) {
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

  /** 10. Problem: Interpolation search vs Binary search. */

  /** 11. Problem: Find the repeating and the missing | Added 3 new methods. */

  /** 12. Problem: Find a Fixed Point (Value equal to index) in a given array. */

  /**
   * 13. Problem: Find the maximum element in an array which is first increasing and then
   * decreasing.
   */

  /** 14. Problem: Find a pair with the given difference. */

  /** 15. Problem: Find four elements that sum to a given value | Set 1 (n^3 solution). */

  /** 16. Problem: Find the k most frequent words from a file. */

  /** 17. Problem: Median of two sorted arrays of different sizes. */

  /** 18. Problem: The Ubiquitous Binary Search | Set 1. */

  /** 19. Problem: Find a peak element. */

  /**
   * 20. Problem: Given an array of of size n and a number k, find all elements that appear more
   * than n/k times.
   */

  /**
   * 21. Problem: Unbounded Binary Search Example (Find the point where a monotonically increasing
   * function becomes positive first time).
   */

  /** 22. Problem: Find the minimum element in a sorted and rotated array. */
  int findMinElement(int[] arr, int left, int right) {
    if (left <= right) {
      int mid = left + (right - left) / 2;
      if (isMinimum(arr, mid)) return mid;
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

  /** 23. Problem: C Program for Binary Search (Recursive and Iterative). */

  /** 24. Problem: Binary Search. */

  /** 25. Problem: Kth smallest element in a row-wise and column-wise sorted 2D array | Set 1. */

  /** 26. Problem: Program to find largest element in an array. */

  /** 27. Problem: Recursive program to linearly search an element in a given array. */

  /** 28. Problem: Find k closest elements to a given value. */

  /** 29. Problem: Search in an almost sorted array. */

  /** 30. Problem: A Problem in Many Binary Search Implementations. */

  /** 31. Problem: Find the first repeating element in an array of integers. */

  /** 32. Problem: Find common elements in three sorted arrays. */

  /** 33. Problem: Count 1&#8217;s in a sorted binary array. */

  /**
   * 34. Problem: Given a sorted array and a number x, find the pair in array whose sum is closest
   * to x.
   */

  /** 35. Problem: Find the closest pair from two sorted arrays. */

  /** 36. Problem: K&#8217;th Smallest/Largest Element in Unsorted Array | Set 1. */

  /**
   * 37. Problem: K&#8217;th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
   * Time).
   */

  /**
   * 38. Problem: K&#8217;th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
   * Time).
   */

  /**
   * 39. Problem: K&#8217;th Smallest/Largest Element in Unsorted Array | Set 3 (Worst Case Linear
   * Time).
   */

  /** 40. Problem: Why is Binary Search preferred over Ternary Search?. */

  /** 41. Problem: Find position of an element in a sorted array of infinite numbers. */

  /** 42. Problem: Given a sorted and rotated array, find if there is a pair with a given sum. */
  void findPairRotatedArray(int[] array, int sum) {
    int minElementIndex = findMinElement(array, 0, array.length - 1);
    int high = minElementIndex - 1;
    int low = minElementIndex;
    while (high != low) {
      if (array[high] + array[low] == sum) {
        System.out.println(array[low] + " " + array[high]);
        low = (low + 1) % array.length;
        high = (array.length + high - 1) % array.length;

      } else if (array[low] + array[high] < sum) low = (low + 1) % array.length;
      else high = (array.length + high - 1) % array.length;
    }
  }

  /** 43. Problem: Find the largest pair sum in an unsorted array. */

  /** 44. Problem: Find the nearest smaller numbers on left side in an array. */

  /** 45. Problem: K&#8217;th largest element in a stream. */

  /** 46. Problem: Recursive function to do substring search. */

  /** 47. Problem: Find a pair with maximum product in array of Integers. */

  /** 48. Problem: Find the element that appears once in a sorted array. */

  /** 49. Problem: Find the odd appearing element in O(Log n) time. */

  /** 50. Problem: Find the largest three elements in an array. */
  void print3Largest(int[] arr) {
    int third = Integer.MIN_VALUE, second = Integer.MIN_VALUE, first = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > first) {
        third = second;
        second = first;
        first = arr[i];
      } else if (arr[i] > second) {
        third = second;
        second = arr[i];
      } else if (arr[i] > third) third = arr[i];
    }

    System.out.println("Three largest elements are " + first + " " + second + " " + third);
  }

  /** 51. Problem: Search an element in an array where difference between adjacent elements is 1. */

  /** 52. Problem: Find three closest elements from given three sorted arrays. */

  /**
   * 53. Problem: Find the element before which all the elements are smaller than it, and after
   * which all are greater.
   */

  /** 54. Problem: Binary Search for Rational Numbers without using floating point arithmetic. */

  /** 55. Problem: Fibonacci Search. */

  /** 56. Problem: Floor in a Sorted Array. */

  /** 57. Problem: Third largest element in an array of distinct elements. */

  /** 58. Problem: Jump Search. */

  /** 59. Problem: Interpolation Search. */

  /** 60. Problem: Linear Search. */

  /** 61. Problem: Linear Search vs Binary Search. */

  /** 62. Problem: Second minimum element using minimum comparisons. */

  /** 63. Problem: Queries for greater than and not less than. */

  /** 64. Problem: Efficient search in an array where difference between adjacent is 1. */

  /** 65. Problem: Sublist Search (Search a linked list in another list). */

  /** 66. Problem: Print all possible sums of consecutive numbers with sum N. */

  /** 67. Problem: Minimum time required to produce m items. */

  /** 68. Problem: Exponential Search. */

  /** 69. Problem: Make all array elements equal with minimum cost. */

  /**
   * 70. Problem: Check if there exist two elements in an array whose sum is equal to the sum of
   * rest of the array.
   */

  /** 71. Problem: Check if reversing a sub array make the array sorted. */

  /** 72. Problem: Find all triplets with zero sum. */
  void printTriplets(int[] array) {
    Arrays.sort(array);
    for (int i = 0; i < array.length; i++) {
      int j = i - 1;
      int k = i + 1;
      while (0 <= j && k < array.length) {
        if (-array[i] == array[j] + array[k]) {
          System.out.println(array[j] + " " + array[i] + " " + array[k]);
          j--;
          k++;
        } else if (-array[i] < array[j] + array[k]) j--;
        else k++;
      }
    }
  }

  /** 73. Problem: Search, insert and delete in an unsorted array. */

  /** 74. Problem: Search, insert and delete in a sorted array. */

  /** 75. Problem: Move all occurrences of an element to end in a linked list. */

  /** 76. Problem: Search in an array of strings where non-empty strings are sorted. */

  /** 77. Problem: Best First Search (Informed Search). */

  /** 78. Problem: Smallest Difference Triplet from Three arrays. */

  /** 79. Problem: Recursive Programs to find Minimum and Maximum elements of array. */

  /** 80. Problem: Count of only repeated element in a sorted array of consecutive elements. */

  /** 81. Problem: Search an element in an unsorted array using minimum number of comparisons. */

  /**
   * 82. Problem: Count quadruples from four sorted arrays whose sum is equal to a given value x.
   */

  /** 83. Problem: All unique triplets that sum up to a given value. */

  /** 84. Problem: Squareroot(n)-th node in a Linked List. */

  /** 85. Problem: Check if an array contains all elements of a given range. */

  /** 86. Problem: Repeatedly search an element by doubling it after every successful search. */

  /** 87. Problem: Find a triplet such that sum of two equals to third element. */
  void findTriplet(int[] array) {
    Arrays.sort(array);
    for (int i = array.length - 1; i >= 0; i--) {
      int j = 0;
      int k = i - 1;
      while (j < k) {
        if (array[j] + array[k] == array[i]) {
          System.out.println(array[j] + " " + array[k] + " " + array[i]);
          j++;
          k--;
        } else if (array[i] > array[j] + array[k]) j++;
        else k--;
      }
    }
  }

  /**
   * 88. Problem: Find element in a sorted array whose frequency is greater than or equal to n/2..
   */
  int findMajority(int arr[], int n) {
    return arr[n / 2];
  }

  /** 89. Problem: Best meeting point in 2D binary array. */

  /** 90. Problem: Find row number of a binary matrix having maximum number of 1s. */
  void findRowWithMax1(int[][] mat) {
    int row = 0, i, j;
    for (i = 0, j = mat.length - 1; i < mat.length; i++) {

      while (mat[i][j] == 1) {
        row = i;
        j--;
      }
    }
    System.out.println("Row " + row + 1 + " Max count :" + (mat.length - (j + 1)));
  }

  /** 91. Problem: Minimum product pair an array of positive Integers. */
  int minProductPair(int[] array) {
    int firstMin = Math.min(array[0], array[1]);
    int secondMin = Math.max(array[0], array[1]);
    for (int i = 2; i < array.length; i++) {
      if (array[i] < firstMin) {
        secondMin = firstMin;
        firstMin = array[i];
      } else if (array[i] < secondMin) secondMin = array[i];
    }
    return firstMin * secondMin;
  }

  /** 92. Problem: Count ways of choosing a pair with maximum difference. */

  /** 93. Problem: Sort a Rotated Sorted Array. */
  int[] sortRotatedArray(int[] array) {
    int minElementIndex = findMinElement(array, 0, array.length);
    arrayExamples.rotateArray(array, minElementIndex - 1);
    return array;
  }

  /** 94. Problem: Count number of elements between two given elements in array. */
  int countElementBetween(int[] array, int first, int second) {
    int firstIndex = -1, secondIndex = -1;
    int left = 0, right = array.length - 1;
    while (left != right) {
      if (firstIndex == -1 && array[left] == first) firstIndex = left;
      if (secondIndex == -1 && array[right] == second) secondIndex = right;
      left++;
      right--;
    }
    if (firstIndex == -1 || secondIndex == -1) return 0;
    else return secondIndex - firstIndex - 1;
  }

  /**
   * 95. Problem: k-th missing element in increasing sequence which is not present in a given
   * sequence.
   */

  /** 96. Problem: Divide an array into k segments to maximize maximum of segment minimums. */

  /** 97. Problem: Find the first, second and third minimum elements in an array. */

  /** 98. Problem: Minimum absolute difference of adjacent elements in a circular array. */

  /** 99. Problem: Count ways to form minimum product triplets. */

  /** 100. Problem: Find four missing numbers in an array containing elements from 1 to N. */

  /** 101. Problem: Quickselect Algorithm. */

  /** 102. Problem: Counting cross lines in an array. */

  /** 103. Problem: Save from Bishop in chessboard. */

  /** 104. Problem: Find if given number is sum of first n natural numbers. */

  /** 105. Problem: Largest number less than or equal to N in BST (Iterative Approach). */

  /** 106. Problem: Pair with given sum and maximum shortest distance from end. */

  /** 107. Problem: Closest greater element for every array element from another array. */

  /** 108. Problem: Number of pairs with maximum sum. */

  /** 109. Problem: Find closest number in array. */

  /** 110. Problem: Smallest number whose set bits are maximum in a given range. */

  /** 111. Problem: Two Pointers Technique. */

  /** 112. Problem: Probability of a random pair being the maximum weighted pair. */

  /**
   * 113. Problem: No of pairs (a[j] >= a[i]) with k numbers in range (a[i], a[j]) that are
   * divisible by x.
   */

  /** 114. Problem: Program to find the minimum (or maximum) element of an array. */

  /** 115. Problem: Minimum De-arrangements present in array of AP (Arithmetic Progression). */

  /** 116. Problem: Grouping Countries. */

  /** 117. Problem: Product of maximum in first array and minimum in second. */

  /** 118. Problem: The painter&#8217;s partition problem | Set 2. */

  /** 119. Problem: Even-odd turn game with two integers. */

  /** 120. Problem: Print n smallest elements from given array in their original order. */

  /** 121. Problem: Middle of three using minimum comparisons. */

  /** 122. Problem: Count pairs in array whose sum is divisible by 4. */

  /** 123. Problem: Probability of choosing a random pair with maximum sum in an array. */

  /** 124. Problem: Print pair with maximum AND value in an array. */

  /** 125. Problem: Find last index of a character in a string. */

  /** 126. Problem: De-arrangements for minimum product sum of two arrays. */

  /**
   * 127. Problem: Minimum number of points to be removed to get remaining points on one side of
   * axis.
   */

  /** 128. Problem: First common element in two linked lists. */

  /** 129. Problem: Value of k-th index of a series formed by append and insert MEX in middle. */

  /** 130. Problem: Binary Search using pthread. */

  /**
   * 131. Problem: Minimize (max(A[i], B[j], C[k]) &#8211; min(A[i], B[j], C[k])) of three different
   * sorted arrays.
   */

  /** 132. Problem: Maximum in array which is at-least twice of other elements. */

  /** 133. Problem: Maximum absolute difference of value and index sums. */

  /** 134. Problem: Number of local extrema in an array. */

  /** 135. Problem: Check if an array has a majority element. */

  /** 136. Problem: Find the number of times every day occurs in a month. */

  /** 137. Problem: Find the one missing number in range. */

  /** 138. Problem: Closest numbers from a list of unsorted integers. */

  /** 139. Problem: K distant string. */

  /** 140. Problem: Find k maximum elements of array in original order. */

  /** 141. Problem: Find number of pairs in an array such that their XOR is 0. */

  /** 142. Problem: Making elements distinct in a sorted array by minimum increments. */

  /** 143. Problem: Count items common to both the lists but with different prices. */

  /** 144. Problem: Consecutive steps to roof top. */

  /** 145. Problem: Count elements smaller than or equal to x in a sorted matrix. */

  /** 146. Problem: Maximum sum of elements from each row in the matrix. */

  /** 147. Problem: Linear search using Multi-threading. */
  class LinearSearchTask {
    int start, end, x;
    int[] array;

    LinearSearchTask(int[] array, int start, int end, int x) {
      this.array = array;
      this.start = start;
      this.end = end;
      this.x = x;
    }

    Callable<Integer> task = () -> linearSearch(array, start, end, x);

    private int linearSearch(int[] array, int start, int end, int x) {
      return IntStream.range(start, end).filter(i -> array[i] == x).findFirst().orElse(-1);
    }
  }

  /** 148. Problem: Count pairs from two sorted matrices with given sum. */

  /**
   * 149. Problem: Maximum element in a very large array using pthreads. Given very large array of
   * integers, find maximum within the array using multithreading.
   */
  int maxElement(int[] array, int start, int end) {
    int max = Integer.MIN_VALUE;
    for (int i = start; i < array.length && i < end; i++) max = Math.max(array[i], max);
    return max;
  }

  /** 150. Problem: Find an array element such that all elements are divisible by it. */
  int findSmallestEle(int[] array) {
    int min = Arrays.stream(array).min().getAsInt();
    for (int i = 1; i < array.length; i++) if (array[i] % min >= 1) return -1;

    return min;
  }

  /** 151. Problem: Path in a Rectangle with Circles. */

  /** 152. Problem: Last duplicate element in a sorted array. */

  /** 153. Problem: Find final value if we double after every successful search in array. */

  /** 154. Problem: Longest prefix which is also suffix. */

  /** 155. Problem: Minimum distance between two occurrences of maximum. */
  int minDistance(int[] array) {
    int maxima = array[0];
    int minDistance = array.length;
    int prevIndex = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] == maxima) {
        minDistance = Math.min(minDistance, i - prevIndex);
      } else if (array[i] > maxima) {
        maxima = array[i];
        minDistance = array.length;
        prevIndex = i;
      }
    }
    return minDistance;
  }

  /** 156. Problem: Number of unique triplets whose XOR is zero. */

  /** 157. Problem: Maximum occurring character in a linked list. */

  /** 158. Problem: Pairs such that one is a power multiple of other. */

  /** 159. Problem: Maximum sum of increasing order elements from n arrays. */

  /** 160. Problem: Maximum difference between two subsets of m elements. */

  /** 161. Problem: Sort the given string using character search. */

  /** 162. Problem: Find k-th smallest element in given n ranges. */

  /** 163. Problem: Find relative complement of two sorted arrays. */

  /** 164. Problem: Searching in an array where adjacent differ by at most k. */

  /** 165. Problem: Print all triplets in sorted array that form AP. */
  void findTriplets(int[] array) {

    for (int i = 0; i < array.length; i++) {
      int left = i - 1, right = i + 1;

      while (left >= 0 && right < array.length) {
        if (array[i] * 2 == array[left] + array[right]) {
          System.out.println(array[left] + " " + array[i] + " " + array[right]);
          left--;
          right++;
        } else if (array[i] * 2 < array[left] + array[right]) left--;
        else right++;
      }
    }
  }

  /** 166. Problem: Print uncommon elements from two sorted arrays. */
  ArrayList<Integer> uncommonElements(int[] array1, int[] array2) {
    ArrayList<Integer> result = new ArrayList<>();
    return uncommon(array1, array2, array1.length, array2.length, result);
  }

  private ArrayList<Integer> uncommon(
      int[] array1, int[] array2, int m, int n, ArrayList<Integer> result) {
    if (m == 0) {
      for (int i = n; i > 0; i--) result.add(array2[i - 1]);
      return result;
    } else if (n == 0) {
      for (int i = m; i > 0; i--) result.add(array1[i - 1]);
      return result;
    } else if (array1[m - 1] < array2[n - 1]) {
      result.add(array2[n - 1]);
      return uncommon(array1, array2, m, n - 1, result);
    } else if (array1[m - 1] > array2[n - 1]) {
      result.add(array1[m - 1]);
      return uncommon(array1, array2, m - 1, n, result);
    } else return uncommon(array1, array2, m - 1, n - 1, result);
  }

  /** 167. Problem: Most frequent element in an array. */

  /** 168. Problem: Least frequent element in an array. */

  /** 169. Problem: Minimum increment by k operations to make all elements equal. */

  /** 170. Problem: Shortest Un-ordered Subarray. */

  /** 171. Problem: Print number in ascending order which contains 1, 2 and 3 in their digits.. */

  /** 172. Problem: Find the only repetitive element between 1 to n-1. */

  /** 173. Problem: Front and Back Search in unsorted array. */

  /** 174. Problem: Non-Repeating Element. */

  /** 175. Problem: Binary Search on Singly Linked List. */

  /** 176. Problem: Stella Octangula Number. */

  /** 177. Problem: Smallest greater elements in whole array. */

  /** 178. Problem: Array range queries for searching an element. */

  /** 179. Problem: Median of two sorted arrays with different sizes in O(log(min(n, m))). */

  /** 180. Problem: XOR of numbers that appeared even number of times in given Range. */

  /** 181. Problem: Immediate Smaller element in an N-ary Tree. */
  String removeDuplicates(String str) {

    int i = 0, j = 0;
    String res = "";
    while (i < str.length()) {
      while (j < str.length() && str.charAt(i) == str.charAt(j)) j++;
      res += str.charAt(i);
      i = j;
    }
    return res;
  }
}
