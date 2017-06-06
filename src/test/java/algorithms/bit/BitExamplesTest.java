package algorithms.bit;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitExamplesTest {

  @Test
  public void getNextPowerOf2() throws Exception {
    assertEquals(8, new BitExamples().getNextPowerOf2(5));
    assertEquals(16, new BitExamples().getNextPowerOf2(15));
  }

}