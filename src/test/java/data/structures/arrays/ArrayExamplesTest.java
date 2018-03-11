package data.structures.arrays;

import algorithms.dynamic.programming.DPExamplesTest;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayExamplesTest {
  @Test
  public void findUniquePairs() throws Exception {
    int[] a = {10, 15, 20};
    int[] b = {17, 12, 24};
    assertEquals(2, new ArrayExamples().findUP(a, b, 3));
  }

  @Test
  public void findTPoint() throws Exception {
    int[] array = {0, 0, 0, 0, 1, 1};
    assertEquals(4, new ArrayExamples().findTPoint(array, 0, array.length - 1));
  }

  @Test
  public void findIndex() throws Exception {
    int[] array = {1, 2, 3, 4, 5};
    int start = new ArrayExamples().findIndex(array, 5, 0, 1, -1);
    int last = new ArrayExamples().findIndex(array, 5, array.length - 1, -1, -1);
    System.out.println(start + " " + last);
  }

  @Test
  public void countWaysToReachEnd() throws Exception {
    new DPExamplesTest().minJumps();
  }

  @Test
  public void subArrayCountWithEvenSum() throws Exception {
    int[] arr = {1, 2, 2, 3, 4, 1};
    assertEquals(9, new ArrayExamples().subArrayCountWithEvenSum(arr));
  }

  @Test
  public void findSubArrayWithSum() throws Exception {
    int[] arr = {1, 4, 20, 3, 10, 5};
    assertTrue(new ArrayExamples().findSubArrayWithSum(arr, 33));
    int[] arr1 = {1, 4};
    assertFalse(new ArrayExamples().findSubArrayWithSum(arr1, 0));
  }

  @Test
  public void replaceWithMultiply() throws Exception {
    int[] arr = {2, 3, 4, 5, 6};
    new ArrayExamples().replaceWithMultiply(arr, 0, 1);
    for (int elem : arr) {
      System.out.println(elem);
    }
  }

  @Test
  public void findLargest() throws Exception {
    int[] arr = {2, 3, 4, 5, 6};
    assertEquals(6, new ArrayExamples().findLargest(arr, 0, Integer.MIN_VALUE));
  }

  @Test
  public void arrayUnion() throws Exception {
    int[] arr1 = {1, 2, 4};
    int[] arr2 = {2, 3, 4, 5, 6};
    ArrayList<Integer> result = new ArrayExamples().arrayUnion(arr1, 0, arr2, 0, new ArrayList<>());
    assertEquals(1, result.get(0).intValue());
    assertEquals(3, result.get(2).intValue());
  }

  @Test
  public void arrayIntersection() throws Exception {
    int[] arr1 = {1, 2, 4};
    int[] arr2 = {2, 3, 4, 5, 6};
    ArrayList<Integer> result = new ArrayExamples().arrayIntersection(arr1, 0, arr2, 0, new ArrayList<>());
    assertEquals(2, result.get(0).intValue());
    assertEquals(4, result.get(1).intValue());
  }

  @Test
  public void mergeArrays() throws Exception {
    int[] arr1 = {1, 2};
    int[] arr2 = {3, 4, 5, 6};
    int[] arr = new int[arr1.length + arr2.length];
    new ArrayExamples().mergeArrays(arr1, arr2, 0, 0, arr, 0);

    for (int i : arr) System.out.println(i);
  }


  @Test
  public void arraySum() throws Exception {
    int arr[] = {1, 7, 1, 1, 3, 1};
    assertEquals(14, new ArrayExamples().arraySum(arr, 0, 0));
    assertEquals(14, new ArrayExamples()._arraySum(arr));
  }

  @Test
  public void minValue() throws Exception {
    int arr[] = {1, 7, 1, 1, 3, 1};
    assertEquals(4, new ArrayExamples().minValue(arr, 0, arr.length - 1, 0));
    int arr2[] = {1, 2, 1, 2, 1, 3};
    assertEquals(2, new ArrayExamples().minValue(arr2, 0, arr.length - 1, 0));
  }

  @Test
  public void minSegments() throws Exception {
    int[] array = {1, 2, 3, 4, 5};
    assertEquals(1, new ArrayExamples().minSegments(array));
    int[] array1 = {489, 206, 745, 123, 756};
    assertEquals(745, new ArrayExamples().minSegments(array1));
  }

  @Test
  public void checkPair1() throws Exception {
    int[] array = {1, 2, 3, 1, 2};
    assertTrue(new ArrayExamples().checkPair1(array, 5));
    assertFalse(new ArrayExamples().checkPair1(array, 10));
  }

  @Test
  public void checkPair2() throws Exception {
    int[] array = {-1, 2, 3, 1, 2};
    assertTrue(new ArrayExamples().checkPair2(array, 5));
    assertTrue(new ArrayExamples().checkPair2(array, 0));
  }

  @Test
  public void getOddOccurrence() throws Exception {
    int[] array = {1, 2, 3, 1, 2};
    assertEquals(3, new ArrayExamples().getOddOccurrence(array));
    assertEquals(3, new ArrayExamples().getOddOccurrenceWithLambda(array));
  }

  @Test
  public void mergeArray() throws Exception {
    int[] array1 = {1, 2, 3};
    int[] array2 = {4, 5, 0, 0, 0};
    int[] array3 = new ArrayExamples().mergeArray(array1, array2);
    for (int element : array3) {
      System.out.println(element);
    }
  }

  @Test
  public void maxSumNonContigousTest() {
    int[] a = {-3, 2, 7, 10};
    int[] b = {-30, -22, -7, -10};
    int result = new ArrayExamples().maxSumNonContigous(a);
    assertEquals(19, result);
    assertEquals(-7, new ArrayExamples().maxSumNonContigous(b));
  }

  @Test
  public void binarySearchRotated() throws Exception {
    int[] array = {5, 6, 1, 2, 3, 4};
    assertEquals(0, new ArrayExamples().binarySearchRotated(array, 5, 0, array.length - 1));
    assertEquals(1, new ArrayExamples().binarySearchRotated(array, 6, 0, array.length - 1));
    assertEquals(2, new ArrayExamples().binarySearchRotated(array, 1, 0, array.length - 1));
    assertEquals(3, new ArrayExamples().binarySearchRotated(array, 2, 0, array.length - 1));
  }

  @Test
  public void reverseArray() throws Exception {
    int[] array = {5, 6, 1, 2, 3, 4};
    new ArrayExamples().reverseArray(array, 0, array.length - 1);
    assertEquals(4, array[0]);
    assertEquals(5, array[5]);
  }

  @Test
  public void rotateArray() throws Exception {
    int[] array = {1, 2, 3, 4, 5};
    new ArrayExamples().rotateArray(array, 2);
    assertEquals(4, array[0]);
    assertEquals(5, array[1]);
  }

  @Test
  public void maxDiffTest() throws Exception {
    int[] arr = {2, 3, 10, 6, 4, 8, 1};
    assertEquals(8, new ArrayExamples().maxDiff(arr));
  }

  @Test
  public void maxSumNonAdjacent() throws Exception {
    int[] array = {5, 4, 1, 3};
    assertEquals(8, new ArrayExamples().maxSumNonAdjacent(array));
  }

  @Test
  public void findSmallest() throws Exception {
    int[] array = {1, 3, 6, 10, 11, 15};
    assertEquals(2, new ArrayExamples().findSmallest(array));
  }

  @Test
  public void maxSumContigousLengthTest() {
    int[] arr = {0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1};
    int result = new ArrayExamples().maxLength(arr, 3);
    assertEquals(10, result);
    assertEquals(11, new ArrayExamples().maxLength(arr, 4));
  }

  @Test
  public void minDiffTest() {
    int arr[] = {1, 10, 14, 14, 14, 15};
    assertEquals(5, new ArrayExamples().minDiff(arr, 6));
  }

  @Test
  public void minPalOpTest() {
    int arr[] = {11, 14, 15, 99};
    int[] arr2 = {1, 4, 5, 1};
    assertEquals(3, new ArrayExamples().minPalindromeOperations(arr, 0, arr.length - 1));
    assertEquals(1, new ArrayExamples().minPalindromeOperations(arr2, 0, arr2.length - 1));
  }

  @Test
  public void subArrayCount() {
    int arr[] = {0, 5, 3, 8, 2, 1};
    assertEquals(5, new ArrayExamples().subArrayCount(arr, 3));
    int arr1[] = {4, 5, 0, -12, -23, 1};
    assertEquals(7, new ArrayExamples().subArrayCount(arr1, 5));
  }

}

