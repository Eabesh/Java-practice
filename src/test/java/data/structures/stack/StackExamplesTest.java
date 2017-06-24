package data.structures.stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhay on 23/06/17.
 */
public class StackExamplesTest {
  @Test
  public void maxRectangleArea() throws Exception {
    int[] hist = {6, 2, 5, 4, 5, 1, 6};
    assertEquals(12, new StackExamples().maxRectangleArea(hist));
    int[] hist2 = {5};
    assertEquals(5, new StackExamples().maxRectangleArea(hist2));
  }

}