package CtCI.Ch01;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysAndStringsTest {

  @Test
  public void hasUniqueCharsWithExtraSpace() throws Exception {
    assertTrue(new ArraysAndStrings().hasUniqueCharsWithExtraSpace("abc"));
    assertFalse(new ArraysAndStrings().hasUniqueCharsWithExtraSpace("abca"));
  }

  @Test
  public void hasUniqueChars() throws Exception {
    assertTrue(new ArraysAndStrings().hasUniqueChars("abc"));
    assertFalse(new ArraysAndStrings().hasUniqueChars("abca"));
  }

  @Test
  public void checkPermutationUsingSorting() throws Exception {
    assertTrue(new ArraysAndStrings().checkPermutationUsingSorting("abc", "bca"));
    assertTrue(new ArraysAndStrings().checkPermutationUsingSorting("ab", "ba"));
    assertFalse(new ArraysAndStrings().checkPermutationUsingSorting("abc", "aaa"));
  }

  @Test
  public void checkPermutationUsingHashing() throws Exception {
    assertTrue(new ArraysAndStrings().checkPermutationUsingHashing("abc", "bca"));
    assertTrue(new ArraysAndStrings().checkPermutationUsingHashing("ab", "ba"));
    assertFalse(new ArraysAndStrings().checkPermutationUsingHashing("abc", "aaa"));
  }

}