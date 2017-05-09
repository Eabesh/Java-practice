package CtCI.Ch01;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysAndStringsTest {

  @Test
  public void hasUniqueCharsWithExtraSpace() throws Exception {
    assertTrue(new ArraysAndStrings().hasUniqueCharsWithExtraSpace("abc"));
    assertFalse(new ArraysAndStrings().hasUniqueCharsWithExtraSpace("abca"));
  }

}