package recursion;
import org.junit.Test;
import utilities.ListNode;
import utilities.Stack;

import java.util.Arrays;
import java.util.HashSet;

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
  public void binarySearch() throws Exception {
    int [] array = {1, 2, 3, 5};
    assertEquals(1, new RecursionExamples().binarySearch(array,0, array.length - 1, 2));
    assertEquals(0, new RecursionExamples().binarySearch(array,0, array.length - 1, 1));
    assertEquals(-1, new RecursionExamples().binarySearch(array,0, array.length - 1, 4));
  }

  @Test
  public void combination() throws Exception {
    assertEquals(1, new RecursionExamples().combination(1,0));
    assertEquals(1, new RecursionExamples().combination(1,0));
  }

  @Test
  public void towerOfHanoi() throws Exception {
    new RecursionExamples().towerOfHanoi(2, "Pin1", "Pin2", "Pin3");
  }

  @Test
  public void printPermutations() throws Exception {
    new RecursionExamples().printPermutations("","ABC");
  }

  @Test
  public void printSubsets() throws Exception {
    new RecursionExamples().printSubsets("","ABC");
  }

  @Test
  public void isAnagram() throws Exception {
    HashSet<String> dictionary = new HashSet<>(Arrays.asList("one","there","here","icecream","two"));
    assertTrue(new RecursionExamples().isAnagram("", "creamice", dictionary));
    assertTrue(new RecursionExamples().isAnagram("", "owt", dictionary));
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
  public void reverseStack() throws Exception {
    Stack stack = new Stack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    new RecursionExamples().reverseStack(stack);
    while (!stack.isEmpty()) System.out.println(stack.pop());
  }

  @Test
  public void isPalindromeNumber() throws Exception {
    assertTrue(new RecursionExamples().isPalindromeNumber(12321,12321, 0));
    assertFalse(new RecursionExamples().isPalindromeNumber(12322,12322, 0));
  }

  @Test
  public void printCombinationOfArray() throws Exception {
    int[] array = {1, 2, 3, 4};
    new RecursionExamples().printCombinationOfArray(array, "", 2, 0);
  }

  @Test
  public void printKLengthString() throws Exception {
    char[] array = {'a', 'b'};
    new RecursionExamples().printKLengthString(array, 2, "");
  }

  @Test
  public void factorial() throws Exception {
    assertEquals(1, new RecursionExamples().factorial(0));
    assertEquals(1, new RecursionExamples().factorial(1));
    assertEquals(120, new RecursionExamples().factorial(5));
  }

  @Test
  public void factTailRecursive() throws Exception {
    assertEquals(1, new RecursionExamples().factTailRecursive(0, 1));
    assertEquals(1, new RecursionExamples().factTailRecursive(1,1));
    assertEquals(120, new RecursionExamples().factTailRecursive(5, 1));
  }

  @Test
  public void printIncreasingSequence() throws Exception {
    new RecursionExamples().printIncreasingSequence("", 3, 2, 1);
  }

  @Test
  public void findUniqueWays() throws Exception {
    assertEquals(1, new RecursionExamples().findUniqueWays(10, 2, 1));
    assertEquals(3, new RecursionExamples().findUniqueWays(100, 2, 1));
  }

  @Test
  public void reverseList() throws Exception {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    node1.next = node2;
    node2.next = node3;
    assertEquals(3, new RecursionExamples().reverseList(node1).data);
  }


  @Test
  public void recamanSequence() throws Exception {
//   assertEquals(2, new RecursionExamples().recamanSequence(4));
//    assertEquals(3, new RecursionExamples().recamanSequence(2));
//    assertEquals(6, new RecursionExamples().recamanSequence(3));
//    assertEquals(2, new RecursionExamples().recamanSequence(4));
//    assertEquals(7, new RecursionExamples().recamanSequence(5));
    for (int i = 0; i < 11; i++) System.out.print(new RecursionExamples().recamanSequence(i) + " ");
  }

  @Test
  public void printSubsetSum() throws Exception {
    int[] set = {1, 2, 3};
    new RecursionExamples().printSubsetSum(0, set, 0);
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