package algorithms.geometric;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhay on 10/07/17.
 */
public class GeometricExamplesTest {
  @Test
  public void isPointInsideTriangle() throws Exception {
    int[] x = {0, 0}, y = {20, 0}, z = {10, 30}, p = {10, 15};
    assertTrue(new GeometricExamples().isPointInsideTriangle(x, y, z, p));

  }

}