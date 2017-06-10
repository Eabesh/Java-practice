package algorithms.sorting;

import org.junit.Test;

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

  }

  @Test
  public void panCakeSort() throws Exception {

  }

  @Test
  public void mergeSort() throws Exception {

  }

  @Test
  public void heapSort() throws Exception {

  }

  @Test
  public void quickSort() throws Exception {

  }

}