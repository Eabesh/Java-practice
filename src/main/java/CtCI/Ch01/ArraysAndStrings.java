package CtCI.Ch01;

import java.util.HashSet;

class ArraysAndStrings {

  /**
   * 1.1
   * Problem: Is Unique: Implement an algorithm to determine if a string has all unique characters.
   * What if you cannot use additional data structures?
   */
  boolean hasUniqueCharsWithExtraSpace(String string) {
    if (string.length() > 128) return false;
    else {
      HashSet<Character> chars = new HashSet<>();
      for (char c : string.toCharArray()) {
        if (chars.contains(c)) return false;
        else chars.add(c);
      }
      return true;
    }
  }

}
