package recursion.org.geekforgeeks.w3;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecursionExamplesTest {

  @Test
  public void getExponent() throws Exception {
    assertEquals(9, new RecursionExamples().getExponent(3, 2));
  }

  @Test
  public void getExpEff() throws Exception {
    assertEquals(9, new RecursionExamples().getExponentEfficient(3, 2));
  }

  @Test
  public void isPalindrome() throws Exception {
    assertEquals(true, new RecursionExamples().isPalindrome(""));
    assertEquals(true, new RecursionExamples().isPalindrome("a"));
    assertEquals(true, new RecursionExamples().isPalindrome("madam"));
    assertEquals(false, new RecursionExamples().isPalindrome("abhay"));
  }

  @Test
  public void factorial() throws Exception {
    assertEquals(1, new RecursionExamples().factorial(0));
    assertEquals(1, new RecursionExamples().factorial(1));
    assertEquals(120, new RecursionExamples().factorial(5));
  }

  @Test
  public void factTailRecusive() throws Exception {
    assertEquals(1, new RecursionExamples().factTailRecursive(0, 1));
    assertEquals(1, new RecursionExamples().factTailRecursive(1,1));
    assertEquals(120, new RecursionExamples().factTailRecursive(5, 1));
  }

  @Test
  public void towerOfHanoi() throws Exception {

  }

  @Test
  public void printPermutation() throws Exception {

  }

  @Test
  public void printSubset() throws Exception {

  }

  @Test
  public void combination() throws Exception {

  }

  @Test
  public void isPalindromeNumber() throws Exception {

  }

  @Test
  public void recusiveBSort() throws Exception {

  }

  @Test
  public void swap() throws Exception {

  }

  @Test
  public void bunnyEars2() throws Exception {

  }

  @Test
  public void triangle() throws Exception {

  }

  @Test
  public void sumDigits() throws Exception {

  }

  @Test
  public void count7() throws Exception {

  }

  @Test
  public void countHi() throws Exception {

  }

  @Test
  public void changeXY() throws Exception {

  }

  @Test
  public void changeXY1() throws Exception {

  }

}