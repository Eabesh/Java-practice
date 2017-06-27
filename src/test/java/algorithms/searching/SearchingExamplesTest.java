package algorithms.searching;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchingExamplesTest {

  @Test
  public void findMinElement() throws Exception {
    int[] array = {5, 6, 1, 2, 3, 4};
    assertEquals(1, new SearchingExamples().findMinElement(array,0, array.length - 1));
  }

}