package algorithms.sorting;

import org.junit.Test;
import utilities.ListNode;

import static org.junit.Assert.*;

public class SortingExamplesTest {

  @Test
  public void bubbleSort() throws Exception {
    int[] array = {2, 1, 3, 8, 4};
    new SortingExamples().bubbleSort(array);
    assertEquals(1, array[0]);
    assertEquals(8, array[4]);
  }

  @Test
  public void recursiveBSort() throws Exception {
    int[] array = {3, 2, 1};
    new SortingExamples().recursiveBSort(array, array.length);
    assertEquals(1, array[0]);
  }

  @Test
  public void insertionSort() throws Exception {
    int[] array = {2,1,3,8,4};
    new SortingExamples().insertionSort(array);
    assertEquals(1, array[0]);
    assertEquals(8, array[4]);
  }

  @Test
  public void countingSort() throws Exception {
    int[] array = {2,1,3,8,4};
    new SortingExamples().countingSort(array, 8);
    new SortingExamples().countingSort(array, 10);
    new SortingExamples().countingSort2(array, 8);
    new SortingExamples().countingSort2(array, 10);
    assertEquals(1, array[0]);
    assertEquals(8, array[4]);
  }

  @Test
  public void selectionSort() throws Exception {
    int[] array = {2,1,3,8,4};
    new SortingExamples().selectionSort(array);
    assertEquals(1, array[0]);
    assertEquals(8, array[4]);
  }

  @Test
  public void recursiveSelectionSort() throws Exception {
    int[] array = {2,1,3,8,4};
    new SortingExamples().recursiveSelectionSort(array, 0);
    assertEquals(1, array[0]);
    assertEquals(8, array[4]);
  }

  @Test
  public void panCakeSort() throws Exception {
    int[] array = {2,1,4};
    new SortingExamples().panCakeSort(array, array.length - 1);
    assertEquals(1, array[0]);
    assertEquals(4, array[2]);
  }

  @Test
  public void mergeSort() throws Exception {
    int[] array = {2,1,3,8,4};
    new SortingExamples().mergeSort(array, 0, array.length - 1);
    assertEquals(1, array[0]);
    assertEquals(8, array[4]);
  }

  @Test
  public void heapSort() throws Exception {
    int[] array = {2,1,3,8,4};
    new SortingExamples().heapSort(array);
    assertEquals(1, array[0]);
    assertEquals(8, array[4]);
  }

  @Test
  public void quickSort() throws Exception {
    int[] array = {2,1,3,8,4};
    new SortingExamples().quickSort(array, 0, array.length - 1);
    assertEquals(1, array[0]);
    assertEquals(8, array[4]);
  }

  @Test
  public void isSortedList() {
    ListNode head = new ListNode(8);
    head.next = new ListNode(7);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(5);
    head.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next = new ListNode(3);
    assertTrue(new SortingExamples().isSortedList(head, null));
  }

  @Test
  public void countInversion() {
    int[] arr = {1, 20, 6, 4, 5};
    System.out.println(new SortingExamples().countInversion(arr, 0, arr.length - 1));
  }
}
