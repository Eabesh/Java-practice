package recursion.org.geekforgeeks.w3;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class RecursionExamplesTest {
  @Test
  public void isAnagram() throws Exception {
    HashSet<String> dictionary = new HashSet<>();
    dictionary.add("one");
    dictionary.add("there");
    dictionary.add("here");
    dictionary.add("icecream");
    dictionary.add("two");

    assertEquals(true, new RecursionExamples().isAnagram("", "creamice", dictionary));
    assertEquals(true, new RecursionExamples().isAnagram("", "owt", dictionary));

  }

  @Test
  public void solveNQueen() throws Exception {
    int[][] board = new int[4][4];
    new RecursionExamples().solveNQueen(board, 0);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++)
        System.out.print(board[i][j]);
    System.out.println();
    }
  }

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
   // assertEquals(, new RecursionExamples().factTailRecursive(0, 1));
    new RecursionExamples().towerOfHanoi(2, "Pin1", "Pin2", "Pin3");
  }

  @Test
  public void printPermutation() throws Exception {
    assertEquals(1, new RecursionExamples().factTailRecursive(1,1));
  }

  @Test
  public void printSubset() throws Exception {

  }

  @Test
  public void combination() throws Exception {
    assertEquals(1, new RecursionExamples().combination(1,0));
    assertEquals(1, new RecursionExamples().combination(1,0));
  }

  @Test
  public void binarySeach() throws Exception {
    int [] array = {1, 2, 3, 5};
    assertEquals(1, new RecursionExamples().binarySearch(array,0, array.length - 1, 2));
    assertEquals(0, new RecursionExamples().binarySearch(array,0, array.length - 1, 1));
    assertEquals(-1, new RecursionExamples().binarySearch(array,0, array.length - 1, 4));
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