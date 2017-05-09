package CtCI.Ch01;

import java.util.Arrays;
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

  /**
   * Assumes only letters a through z.
   */
  boolean hasUniqueChars(String string) {
    if (string.length() > 26) return false;
    else {
      int checker = 0;
      for (char c : string.toCharArray()) {
        int asciiValue = c - 'a';
        if ((checker & (1 << asciiValue)) > 0) return false;
        checker |= (1 << asciiValue);
      }
      return true;
    }
  }

  /**
   * 1.2
   * Problem: Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
   */
  boolean checkPermutationUsingSorting(String string1, String string2) {
    return string1.length() == string2.length() && sort(string1).equals(sort(string2));
  }

  private String sort(String str) {
    char[] content = str.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }

}
