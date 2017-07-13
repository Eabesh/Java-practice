package algorithms.maths;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhay on 13/07/17.
 */
public class MathematicalExamplesTest {
  @Test
  public void printSeq() throws Exception {
    new MathematicalExamples().printSeq(3, 2, "");
  }

  @Test
  public void printPowerSet() throws Exception {
    new MathematicalExamples().printPowerSet("abc", "");
  }

}