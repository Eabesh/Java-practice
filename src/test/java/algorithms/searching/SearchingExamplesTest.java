package algorithms.searching;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchingExamplesTest {
  SearchingExamples searchingExamples = new SearchingExamples();
  @Test
  public void findMinElement() throws Exception {
    int[] array = {5, 6, 1, 2, 3, 4};
    assertEquals(1, new SearchingExamples().findMinElement(array,0, array.length - 1));
  }

  @Test
  public void findMissingNumber() throws Exception {
    int[] list = {1,2,3,5};
    assertEquals(4, new SearchingExamples().findMissingNumber(list, 5));
    int[] list2 = {1,2,3,5,6};
    assertEquals(4, new SearchingExamples().findMissingNumber(list2, 6));
  }

  @Test
  public void frequency() {
    int arr[] = {1, 2, 2, 3, 3, 3, 3};
    assertEquals(4, new SearchingExamples().frequency(arr, 3));
  }

  @Test
  public void rotatedBinarySearch() {
    int[] array = {4, 5, 6, 1, 2, 3};
    assertEquals(1, searchingExamples.rotatedBinarySearch(array, 5));
  }
}