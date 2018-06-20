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
  public void removeDuplicates() {

    String str = "azxxzy";
    System.out.println(new StringExamples().removeDuplicates(str));
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
    new StringExamples().printSpaces("A", "BC");
  }

  @Test
  public void manipulationCount() {
    assertEquals(2,  new StringExamples().manipulationCount("ddcf", "cedk"));
    assertEquals(0,  new StringExamples().manipulationCount("aba", "baa"));
  }

  @Test
  public void removeAllDuplicates() {
    String str = "aaaba";
//    System.out.println(new StringExamples().removeAllDuplicates(str));
  }

  @Test
  public void printReverseString() {
    String str = "ABC";
    new StringExamples().printReverseString(str);
  }

  @Test
  public void subString() {

    new StringExamples().subString("abhay", 0);
  }

  @Test
  public void findRestaurant() {
    String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

    System.out.println(new StringExamples().findRestaurant(list1, list2)[0]);
  }

  @Test
  public void shiftingLetters() {
    String str = "abc";
    int[] shifts = {3,5,9};
    System.out.println(new StringExamples().shiftingLetters(str, shifts));
  }
}