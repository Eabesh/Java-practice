package data.structures.strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhay on 01/09/17.
 */
public class StringExamplesTest {
  @Test
  public void printAllPermutations() throws Exception {
    new StringExamples().printAllPermutations("", "AB", 2);
  }

  @Test
  public void areRotations() throws Exception {
    assertTrue(new StringExamples().areRotations("ABCD", "CDAB"));
  }

  @Test
  public void printSpaces() throws Exception {
    new StringExamples().printSpaces("A", "BCD");
  }

}