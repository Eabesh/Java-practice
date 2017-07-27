package utilities;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {
  @Test
  public void min() throws Exception {
    assertEquals(1, Utils.max(1, 2, 3));
  }

  @Test
  public void max() throws Exception {
    assertEquals(3, Utils.max(1, 2, 3));
  }

}