package CtCI.Ch01;

import java.util.HashSet;

public class ArraysAndStrings {

  /**
   * 1.1
   * Problem: Is Unique: Implement an algorithm to determine if a string has all unique characters.
   * What if you cannot use additional data structures?
   */
  boolean hasUniqueCharsWithExtraSpace(String string) {
    HashSet<Character> chars = new HashSet<Character>();
    for (char c : string.toCharArray()) {
      if (chars.contains(c)) return false;
      else chars.add(c);
    }
    return true;
  }

}
