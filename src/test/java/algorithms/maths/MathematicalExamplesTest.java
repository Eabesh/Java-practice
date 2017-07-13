package algorithms.maths;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhay on 13/07/17.
 */
public class MathematicalExamplesTest {
  @Test
  public void printBalParentheses() throws Exception {
//    new MathematicalExamples().printBalParentheses(2, 0, 0, "");
    new MathematicalExamples().printBalParentheses(3, 0, 0, "");
  }

  @Test
  public void printSeq() throws Exception {
    new MathematicalExamples().printSeq(3, 2, "");
  }

  @Test
  public void printPowerSet() throws Exception {
    new MathematicalExamples().printPowerSet("abc", "");
  }

}