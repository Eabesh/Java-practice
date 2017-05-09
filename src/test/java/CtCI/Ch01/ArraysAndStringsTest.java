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
    assertFalse(new ArraysAndStrings().checkPermutationUsingSorting("abc", "aaa"));
  }

}