package data.structures.strings;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by abhay on 01/09/17.
 */
public class StringExamplesTest {
  @Test
  public void minAppends() throws Exception {
    String str = "aabb";
    int res = new StringExamples().minAppends(str, 0, str.length() - 1);
    System.out.println(res);
  }

  @Test
  public void reverseVowels() throws Exception {
    StringBuilder str = new StringBuilder("Hello");
    new StringExamples().reverseVowels(str, 0, str.length() - 1);
    System.out.println(str);
  }

  @Test
  public void rearrangeStringSum() throws Exception {
    String str1 = new StringExamples().sortedStrSum("AC2BEW3");
    System.out.println(str1);
  }

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
    new StringExamples().printSpaces("A", "B");
  }

}