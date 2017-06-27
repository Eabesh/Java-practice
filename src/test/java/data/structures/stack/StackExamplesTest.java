package data.structures.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackExamplesTest {

  @Test
  public void maxRectangleArea() throws Exception {
    int[] hist = {6, 2, 5, 4, 5, 1, 6};
    assertEquals(12, new StackExamples().maxRectangleArea(hist));
    int[] hist2 = {5};
    assertEquals(5, new StackExamples().maxRectangleArea(hist2));
  }

  @Test
  public void findCeleb() throws Exception {
    int[][] matrix = {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};
    assertEquals(2, new StackExamples().findCeleb(matrix));
  }

}