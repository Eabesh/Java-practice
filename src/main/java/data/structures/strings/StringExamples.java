package data.structures.strings;

import java.util.ArrayList;

public class StringExamples {

  /**
   * 1.
   * Problem: Return maximum occurring character in an input string.
   */

  /**
   * 2.
   * Problem: Remove all duplicates from a given string.
   */

  /**
   * 3.
   * Problem: Print all the duplicates in the input string.
   */

  /**
   * 4.
   * Problem: Remove characters from the first string which are present in the second string.
   */

  /**
   * 5.
   * Problem: A Program to check if strings are rotations of each other or not.
   */
  boolean areRotations(String str1, String str2) {
    return (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1);
  }

  /**
   * 6.
   * Problem: Print reverse of a string using recursion.
   */

  /**
   * 7.
   * Problem: Write a  program to print all permutations of a given string.
   */

  /**
   * 8.
   * Problem: Divide a string in N equal parts.
   */

  /**
   * 9.
   * Problem: Given a string, find its first non-repeating character.
   */

  /**
   * 10.
   * Problem: Print list items containing all characters of a given word.
   */

  /**
   * 11.
   * Problem: Reverse words in a given string.
   */

  /**
   * 12.
   * Problem: Run Length Encoding.
   */

  /**
   * 13.
   * Problem: Find the smallest window in a string containing all characters of another string.
   */

  /**
   * 14.
   * Problem: Print all permutations with repetition of characters.
   */
  void printAllPermutations(String soFar, String rem, int n) {
    if (n == 0) System.out.println(soFar);
    else
      for (int i = 0; i < rem.length(); i++) printAllPermutations(soFar + rem.charAt(i), rem, n - 1);
  }

  /**
   * 15.
   * Problem: Print all interleavings of given two strings.
   */

  /**
   * 16.
   * Problem: Check whether a given string is an interleaving of two other given strings.
   */

  /**
   * 17.
   * Problem: Check whether two strings are anagram of each other.
   */

  /**
   * 18.
   * Problem: Lexicographic rank of a string.
   */

  /**
   * 19.
   * Problem: Longest Palindromic Substring | Set 1.
   */

  /**
   * 20.
   * Problem: An in-place algorithm for String Transformation.
   * Solution:
   */

  /**
   * 21.
   * Problem: Longest Palindromic Substring | Set 2.
   * Solution:
   */

  /**
   * 22.
   * Problem: Given a sequence of words, print all anagrams together | Set 1.
   * Solution:
   */

  /**
   * 23.
   * Problem: Given a sequence of words, print all anagrams together | Set 2.
   * Solution:
   */

  /**
   * 24.
   * Problem: Count words in a given string.
   * Solution:
   */

  /**
   * 25.
   * Problem: String matching where one string contains wildcard characters.
   * Solution:
   */

  /**
   * 26.
   * Problem: Write your own atoi().
   * Solution:
   */

  /**
   * 27.
   * Problem: Remove &#8220;b&#8221; and &#8220;ac&#8221; from a given string.
   * Solution:
   */

  /**
   * 28.
   * Problem: Find the first non-repeating character from a stream of characters.
   * Solution:
   */

  /**
   * 29.
   * Problem: Recursively remove all adjacent duplicates.
   * Solution:
   */

  /**
   * 30.
   * Problem: Rearrange a string so that all same characters become d distance away.
   * Solution:
   */

  /**
   * 31.
   * Problem: Printing Longest Common Subsequence.
   * Solution:
   */

  /**
   * 32.
   * Problem: Print all possible words from phone digits.
   * Solution:
   */

  /**
   * 33.
   * Problem: C Program to Sort an array of names or strings.
   * Solution:
   */

  /**
   * 34.
   * Problem: C Program to Check if a Given String is Palindrome.
   * Solution:
   */

  /**
   * 35.
   * Problem: Check if a given string is a rotation of a palindrome.
   * Solution:
   */

  /**
   * 36.
   * Problem: Find Excel column name from a given column number.
   * Solution:
   */

  /**
   * 37.
   * Problem: C++ Program to print all palindromes in a given range.
   * Solution:
   */

  /**
   * 38.
   * Problem: Given a sorted dictionary of an alien language, find order of characters.
   * Solution:
   */

  /**
   * 39.
   * Problem: Find if an array of strings can be chained to form a circle | Set 1.
   * Solution:
   */

  /**
   * 40.
   * Problem: C program to find second most frequent character.
   * Solution:
   */

  /**
   * 41.
   * Problem: Given a number as a string, find the number of contiguous subsequences which recursively add up to 9.
   * Solution:
   */

  /**
   * 42.
   * Problem: Print all pairs of anagrams in a given array of strings.
   * Solution:
   */

  /**
   * 43.
   * Problem: Check if characters of a given string can be rearranged to form a palindrome.
   * Solution:
   */

  /**
   * 44.
   * Problem: C++ Program to remove spaces from a string.
   * Solution:
   */

  /**
   * 45.
   * Problem: Lexicographically minimum string rotation.
   * Solution:
   */

  /**
   * 46.
   * Problem: Given two strings, find if first string is a subsequence of second.
   * Solution:
   */

  /**
   * 47.
   * Problem: Check a given sentence for a given set of simple grammer rules.
   * Solution:
   */

  /**
   * 48.
   * Problem: Manacher&#8217;s Algorithm &#8211; Linear Time Longest Palindromic Substring &#8211; Part 1.
   * Solution:
   */

  /**
   * 49.
   * Problem: Manacher&#8217;s Algorithm &#8211; Linear Time Longest Palindromic Substring &#8211; Part 2.
   * Solution:
   */

  /**
   * 50.
   * Problem: Manacher&#8217;s Algorithm &#8211; Linear Time Longest Palindromic Substring &#8211; Part 3.
   * Solution:
   */

  /**
   * 51.
   * Problem: Manacher&#8217;s Algorithm &#8211; Linear Time Longest Palindromic Substring &#8211; Part 4.
   * Solution:
   */

  /**
   * 52.
   * Problem: Print all possible strings that can be made by placing spaces.
   * Solution:
   */
  void printSpaces(String soFar, String str) {
    if (str.isEmpty()) System.out.println(soFar);
    else {
      printSpaces(soFar + str.charAt(0), str.substring(1));
      printSpaces(soFar + " " + str.charAt(0), str.substring(1));
    }
  }

  /**
   * 53.
   * Problem: Find if a given string can be represented from a substring by iterating the substring “n” times.
   * Solution:
   */

  /**
   * 54.
   * Problem: Find all distinct palindromic sub-strings of a given string.
   * Solution:
   */

  /**
   * 55.
   * Problem: Find maximum depth of nested parenthesis in a string.
   * Solution:
   */

  /**
   * 56.
   * Problem: Function to find Number of customers who could not get a computer.
   * Solution:
   */

  /**
   * 57.
   * Problem: Find the longest substring with k unique characters in a given string.
   * Solution:
   */

  /**
   * 58.
   * Problem: Check if a given sequence of moves for a robot is circular or not.
   * Solution:
   */

  /**
   * 59.
   * Problem: Recursively print all sentences that can be formed from list of word lists.
   * Solution:
   */

  /**
   * 60.
   * Problem: Online algorithm for checking palindrome in a stream.
   * Solution:
   */

  /**
   * 61.
   * Problem: Remove spaces from a given string.
   * Solution:
   */

  /**
   * 62.
   * Problem: Recursive function to do substring search.
   * Solution:
   */

  /**
   * 63.
   * Problem: Shortest Superstring Problem.
   * Solution:
   */

  /**
   * 64.
   * Problem: Transform One String to Another using Minimum Number of Given Operation.
   * Solution:
   */

  /**
   * 65.
   * Problem: Print string of odd length in &#8216;X&#8217; format.
   * Solution:
   */

  /**
   * 66.
   * Problem: Minimum insertions to form shortest palindrome.
   * Solution:
   */

  /**
   * 67.
   * Problem: Given a string, print all possible palindromic partitions.
   * Solution:
   */

  /**
   * 68.
   * Problem: Check if two given strings are isomorphic to each other.
   * Solution:
   */

  /**
   * 69.
   * Problem: Length of the longest valid substring.
   * Solution:
   */

  /**
   * 70.
   * Problem: Program to add two binary strings.
   * Solution:
   */

  /**
   * 71.
   * Problem: Recursive Implementation of atoi().
   * Solution:
   */

  /**
   * 72.
   * Problem: Reverse an array without affecting special characters.
   * Solution:
   */

  /**
   * 73.
   * Problem: Remove recurring digits in a given number.
   * Solution:
   */

  /**
   * 74.
   * Problem: Check if edit distance between two strings is one.
   * Solution:
   */

  /**
   * 75.
   * Problem: Print Concatenation of Zig-Zag String in &#8216;n&#8217; Rows.
   * Solution:
   */

  /**
   * 76.
   * Problem: 1&#8217;s and 2&#8217;s complement of a Binary Number.
   * Solution:
   */

  /**
   * 77.
   * Problem: How to split a string in C/C++, Python and Java?.
   * Solution:
   */

  /**
   * 78.
   * Problem: Print all palindrome permutations of a string.
   * Solution:
   */

  /**
   * 79.
   * Problem: Different methods to reverse a string in C/C++.
   * Solution:
   */

  /**
   * 80.
   * Problem: Minimum number of palindromic subsequences to be removed to empty a binary string.
   * Solution:
   */

  /**
   * 81.
   * Problem: Permutations of a given string using STL.
   * Solution:
   */

  /**
   * 82.
   * Problem: Caesar Cipher.
   * Solution:
   */

  /**
   * 83.
   * Problem: Caesar Cipher.
   * Solution:
   */

  /**
   * 84.
   * Problem: All combinations of strings that can be used to dial a number.
   * Solution:
   */

  /**
   * 85.
   * Problem: K&#8217;th Non-repeating Character.
   * Solution:
   */

  /**
   * 86.
   * Problem: Print all ways to break a string in bracket form.
   * Solution:
   */

  /**
   * 87.
   * Problem: Generate all binary strings from given pattern.
   * Solution:
   */

  /**
   * 88.
   * Problem: Pangram Checking.
   * Solution:
   */

  /**
   * 89.
   * Problem: In-place replace multiple occurrences of a pattern.
   * Solution:
   */

  /**
   * 90.
   * Problem: Rearrange a string so that all same characters become atleast d distance away.
   * Solution:
   */

  /**
   * 91.
   * Problem: How to find Lexicographically previous permutation?.
   * Solution:
   */

  /**
   * 92.
   * Problem: Find all strings formed from characters mapped to digits of a number.
   * Solution:
   */

  /**
   * 93.
   * Problem: Longest Common Prefix | Set 1 (Word by Word Matching).
   * Solution:
   */

  /**
   * 94.
   * Problem: Longest Common Prefix | Set 2 (Character by Character Matching).
   * Solution:
   */

  /**
   * 95.
   * Problem: Repeated subsequence of length 2 or more.
   * Solution:
   */

  /**
   * 96.
   * Problem: Longest Common Prefix | Set 3 (Divide and Conquer).
   * Solution:
   */

  /**
   * 97.
   * Problem: Lower case to upper case &#8211; An interesting fact.
   * Solution:
   */

  /**
   * 98.
   * Problem: Longest Common Prefix | Set 5 (Using Trie).
   * Solution:
   */

  /**
   * 99.
   * Problem: Print shortest path to print a string on screen.
   * Solution:
   */

  /**
   * 100.
   * Problem: Remove extra spaces from a string.
   * Solution:
   */

  /**
   * 101.
   * Problem: Palindrome Substring Queries.
   * Solution:
   */

  /**
   * 102.
   * Problem: Change gender of a given string.
   * Solution:
   */

  /**
   * 103.
   * Problem: Count number of substrings with exactly k distinct characters.
   * Solution:
   */

  /**
   * 104.
   * Problem: Removing spaces from a string using Stringstream.
   * Solution:
   */

  /**
   * 105.
   * Problem: Longest Common Extension / LCE | Set 1 (Introduction and Naive Method).
   * Solution:
   */

  /**
   * 106.
   * Problem: Longest Common Extension / LCE | Set 2 ( Reduction to RMQ).
   * Solution:
   */

  /**
   * 107.
   * Problem: Longest Common Extension / LCE | Set 3 (Segment Tree Method).
   * Solution:
   */

  /**
   * 108.
   * Problem: Concurrent Merge Sort in Shared Memory.
   * Solution:
   */

  /**
   * 109.
   * Problem: Calculate sum of all numbers present in a string.
   * Solution:
   */

  /**
   * 110.
   * Problem: Find longest palindrome formed by removing or shuffling chars from string.
   * Solution:
   */

  /**
   * 111.
   * Problem: Check if string follows order of characters defined by a pattern or not | Set 1.
   * Solution:
   */

  /**
   * 112.
   * Problem: Find all strings that match specific pattern in a dictionary.
   * Solution:
   */

  /**
   * 113.
   * Problem: Minimum Cost To Make Two Strings Identical.
   * Solution:
   */

  /**
   * 114.
   * Problem: Find k&#8217;th character of decrypted string.
   * Solution:
   */

  /**
   * 115.
   * Problem: Check if string follows order of characters defined by a pattern or not | Set 2.
   * Solution:
   */

  /**
   * 116.
   * Problem: Check if string follows order of characters defined by a pattern or not | Set 3.
   * Solution:
   */

  /**
   * 117.
   * Problem: Group Shifted String.
   * Solution:
   */

  /**
   * 118.
   * Problem: Vigenère Cipher.
   * Solution:
   */

  /**
   * 119.
   * Problem: Pairs of complete strings in two sets of strings.
   * Solution:
   */

  /**
   * 120.
   * Problem: Compare two Version numbers.
   * Solution:
   */

  /**
   * 121.
   * Problem: String with additive sequence.
   * Solution:
   */

  /**
   * 122.
   * Problem: Longest common subsequence with permutations allowed.
   * Solution:
   */

  /**
   * 123.
   * Problem: Perfect reversible string.
   * Solution:
   */

  /**
   * 124.
   * Problem: Check if a string has all characters with same frequency with one variation allowed.
   * Solution:
   */

  /**
   * 125.
   * Problem: Check if a string can become empty by recursively deleting a given sub-string.
   * Solution:
   */

  /**
   * 126.
   * Problem: Remove minimum number of characters so that two strings become anagram.
   * Solution:
   */

  /**
   * 127.
   * Problem: XOR Cipher.
   * Solution:
   */

  /**
   * 128.
   * Problem: Smallest Palindrome after replacement.
   * Solution:
   */

  /**
   * 129.
   * Problem: Count of distinct substrings of a string using Suffix Trie.
   * Solution:
   */

  /**
   * 130.
   * Problem: Sort a string according to the order defined by another string.
   * Solution:
   */

  /**
   * 131.
   * Problem: Remove a character from a string to make it a palindrome.
   * Solution:
   */

  /**
   * 132.
   * Problem: Distinct strings with odd and even changes allowed.
   * Solution:
   */

  /**
   * 133.
   * Problem: Find if an array of strings can be chained to form a circle | Set 2.
   * Solution:
   */

  /**
   * 134.
   * Problem: Count characters at same position as in English alphabets.
   * Solution:
   */

  /**
   * 135.
   * Problem: Group all occurrences of characters according to first appearance.
   * Solution:
   */

  /**
   * 136.
   * Problem: Check for Palindrome  after every character replacement Query.
   * Solution:
   */

  /**
   * 137.
   * Problem: Count All Palindrome Sub-Strings in a String.
   * Solution:
   */

  /**
   * 138.
   * Problem: Minimum characters to be added at front to make string palindrome.
   * Solution:
   */

  /**
   * 139.
   * Problem: Convert to a string that is repetition of a substring of k length.
   * Solution:
   */

  /**
   * 140.
   * Problem: Nth character in Concatenated Decimal String.
   * Solution:
   */

  /**
   * 141.
   * Problem: Word Break Problem using Backtracking.
   * Solution:
   */

  /**
   * 142.
   * Problem: Minimum cost to sort strings using reversal operations of different costs.
   * Solution:
   */

  /**
   * 143.
   * Problem: Print all palindromic partitions of a string.
   * Solution:
   */

  /**
   * 144.
   * Problem: Count of character pairs at same distance as in English alphabets.
   * Solution:
   */

  /**
   * 145.
   * Problem: Minimum number of characters to be removed to make a binary string alternate.
   * Solution:
   */

  /**
   * 146.
   * Problem: Check if all rows of a matrix are circular rotations of each other.
   * Solution:
   */

  /**
   * 147.
   * Problem: Check if two strings are k-anagrams or not.
   * Solution:
   */

  /**
   * 148.
   * Problem: Check length of a string is equal to the number appended at its last.
   * Solution:
   */

  /**
   * 149.
   * Problem: Generate all binary strings without consecutive 1&#8217;s.
   * Solution:
   */

  /**
   * 150.
   * Problem: Program to toggle all characters in a string.
   * Solution:
   */

  /**
   * 151.
   * Problem: Efficient method for 2&#8217;s complement of a binary string.
   * Solution:
   */

  /**
   * 152.
   * Problem: Array of Strings in C++ (3 Different Ways to Create).
   * Solution:
   */

  /**
   * 153.
   * Problem: Queries for characters in a repeated string.
   * Solution:
   */

  /**
   * 154.
   * Problem: Queries on subsequence of string.
   * Solution:
   */

  /**
   * 155.
   * Problem: Queries on substring palindrome formation.
   * Solution:
   */

  /**
   * 156.
   * Problem: Check whether Strings are k distance apart or not.
   * Solution:
   */

  /**
   * 157.
   * Problem: Boggle | Set 2 (Using Trie).
   * Solution:
   */

  /**
   * 158.
   * Problem: Implementation of Affine Cipher.
   * Solution:
   */

  /**
   * 159.
   * Problem: Hamming Distance between two strings.
   * Solution:
   */

  /**
   * 160.
   * Problem: Count of words whose i-th letter is either (i-1)-th, i-th, or (i+1)-th letter of given word.
   * Solution:
   */

  /**
   * 161.
   * Problem: Efficiently check if a string has duplicates without using any additional data structure.
   * Solution:
   */

  /**
   * 162.
   * Problem: Print consecutive characters together in a line.
   * Solution:
   */

  /**
   * 163.
   * Problem: Print all valid words that are possible using Characters of Array.
   * Solution:
   */

  /**
   * 164.
   * Problem: Rearrange characters in a string such that no two adjacent are same.
   * Solution:
   */

  /**
   * 165.
   * Problem: Palindrome pair in an array of words (or strings).
   * Solution:
   */

  /**
   * 166.
   * Problem: Count of total anagram substrings.
   * Solution:
   */

  /**
   * 167.
   * Problem: Make largest palindrome by changing at most K-digits.
   * Solution:
   */

  /**
   * 168.
   * Problem: Check if a string can be obtained by rotating another string 2 places.
   * Solution:
   */

  /**
   * 169.
   * Problem: Find largest word in dictionary by deleting some characters of given string.
   * Solution:
   */

  /**
   * 170.
   * Problem: Group words with same set of characters.
   * Solution:
   */

  /**
   * 171.
   * Problem: Sum of two large numbers.
   * Solution:
   */

  /**
   * 172.
   * Problem: Count of strings that can be formed using a, b and c under given constraints.
   * Solution:
   */

  /**
   * 173.
   * Problem: Maximum consecutive repeating character in string.
   * Solution:
   */

  /**
   * 174.
   * Problem: Difference of two large numbers.
   * Solution:
   */

  /**
   * 175.
   * Problem: Replace all occurrences of string AB with C without using extra space.
   * Solution:
   */

  /**
   * 176.
   * Problem: Find the missing number in a string of numbers with no separator.
   * Solution:
   */

  /**
   * 177.
   * Problem: Count substrings with same first and last characters.
   * Solution:
   */

  /**
   * 178.
   * Problem: Lexicographically first palindromic string.
   * Solution:
   */

  /**
   * 179.
   * Problem: Sum of all substrings of a string representing a number | Set 1.
   * Solution:
   */

  /**
   * 180.
   * Problem: Number of subsequences of the form a^i b^j c^k.
   * Solution:
   */

  /**
   * 181.
   * Problem: Convert decimal fraction to binary number.
   * Solution:
   */

  /**
   * 182.
   * Problem: Convert Binary fraction to Decimal.
   * Solution:
   */

  /**
   * 183.
   * Problem: Count ways to increase LCS length of two strings by one.
   * Solution:
   */

  /**
   * 184.
   * Problem: Find an equal point in a string of brackets.
   * Solution:
   */

  /**
   * 185.
   * Problem: Check if frequency of all characters can become same by one removal.
   * Solution:
   */

  /**
   * 186.
   * Problem: Find the first repeated character in a string.
   * Solution:
   */

  /**
   * 187.
   * Problem: Number of substrings divisible by 6 in a string of integers.
   * Solution:
   */

  /**
   * 188.
   * Problem: Number of substrings divisible by 6 in a string of integers.
   * Solution:
   */

  /**
   * 189.
   * Problem: Number of even substrings in a string of digits.
   * Solution:
   */

  /**
   * 190.
   * Problem: Substring with highest frequency length product.
   * Solution:
   */

  /**
   * 191.
   * Problem: Meta Strings (Check if two strings can become same after a swap in one string).
   * Solution:
   */

  /**
   * 192.
   * Problem: Multiply Large Numbers represented as Strings.
   * Solution:
   */

  /**
   * 193.
   * Problem: Check if a string follows a^nb^n pattern or not.
   * Solution:
   */

  /**
   * 194.
   * Problem: Search in an array of strings where non-empty strings are sorted.
   * Solution:
   */

  /**
   * 195.
   * Problem: Smallest length string with repeated replacement of two distinct adjacent.
   * Solution:
   */

  /**
   * 196.
   * Problem: Print Kth character in sorted concatenated substrings of a string.
   * Solution:
   */

  /**
   * 197.
   * Problem: Recursive function to check if a string is palindrome.
   * Solution:
   */

  /**
   * 198.
   * Problem: Reverse string without using any temporary variable.
   * Solution:
   */

  /**
   * 199.
   * Problem: Check if given string can be split into four distinct strings.
   * Solution:
   */

  /**
   * 200.
   * Problem: Find Excel column number from column title.
   * Solution:
   */

  /**
   * 201.
   * Problem: Minimum number of Appends needed to make a string palindrome.
   * Minimum number of Appends needed to make a string palindrome.
   */
  int minAppends(String str, int left, int right) {
    if (left > right) return Integer.MAX_VALUE;
    else if (left == right) return 0;
    else if (left + 1 == right) return (str.charAt(left) == str.charAt(right)) ? 0 : 1;
    else if (str.charAt(left) == str.charAt(right)) return minAppends(str, left + 1, right - 1);
    else return 1 + minAppends(str, left + 1, right);
  }


  /**
   * 202.
   * Problem: Move spaces to front of string in single traversal.
   * Given a string that has set of words and spaces, write a program to move all spaces to front of string, by traversing
   * the string only once.
   */


  /**
   * 203.
   * Problem: Minimum number of deletions to make a string palindrome.
   */


  /**
   * 204.
   * Problem: Program to find the largest and smallest ASCII valued characters in a string.
   * Solution:
   */

  /**
   * 205.
   * Problem: Maximum length prefix of one string that occurs as subsequence in another.
   * Solution:
   */

  /**
   * 206.
   * Problem: Reverse a string in Java (5 Different Ways).
   * Solution:
   */

  /**
   * 207.
   * Problem: Binary representation of next number.
   * Solution:
   */

  /**
   * 208.
   * Problem: All possible strings of any length that can be formed from a given string.
   * Solution:
   */

  /**
   * 209.
   * Problem: Alternate vowel and consonant string.
   * Solution:
   */

  /**
   * 210.
   * Problem: Left Rotation and Right Rotation of a String.
   * Solution:
   */

  /**
   * 211.
   * Problem: String in Switch Case in Java.
   * Solution:
   */

  /**
   * 212.
   * Problem: Generate all rotations of a given string.
   * Solution:
   */

  /**
   * 213.
   * Problem: Sort an array of strings  according to string lengths.
   * Solution:
   */

  /**
   * 214.
   * Problem: Binary representation of next greater number with same number of 1&#8217;s and 0&#8217;s.
   * Solution:
   */

  /**
   * 215.
   * Problem: Convert  characters of a string to opposite case.
   * Solution:
   */

  /**
   * 216.
   * Problem: Minimum steps to delete a string after repeated deletion of palindrome substrings.
   * Solution:
   */

  /**
   * 217.
   * Problem: Missing characters to make a string Pangram.
   * Solution:
   */

  /**
   * 218.
   * Problem: Missing characters to make a string Pangram.
   * Solution:
   */

  /**
   * 219.
   * Problem: Print common characters of two Strings in alphabetical order.
   * Solution:
   */

  /**
   * 220.
   * Problem: Smallest window that contains all characters of string itself.
   * Solution:
   */

  /**
   * 221.
   * Problem: Print array of strings in sorted order without copying one string into another.
   * Solution:
   */

  /**
   * 222.
   * Problem: Ropes Data Structure (Fast String Concatenation).
   * Solution:
   */

  /**
   * 223.
   * Problem: Determine if a string has all Unique Characters.
   * Solution:
   */

  /**
   * 224.
   * Problem: Shortest Uncommon Subsequence.
   * Solution:
   */

  /**
   * 225.
   * Problem: Print all distinct characters of a string in order (3 Methods).
   * Solution:
   */

  /**
   * 226.
   * Problem: Program to find Smallest and Largest Word in a String.
   * Solution:
   */

  /**
   * 227.
   * Problem: Number of distinct permutation a String can have.
   * Solution:
   */

  /**
   * 228.
   * Problem: Program to remove vowels from a String.
   * Solution:
   */

  /**
   * 229.
   * Problem: Case conversion (Lower to Upper and Vice Versa) of a string using BitWise operators in C/C++.
   * Solution:
   */

  /**
   * 230.
   * Problem: Removing punctuations from a given string.
   * Solution:
   */

  /**
   * 231.
   * Problem: Toggle case of a string using Bitwise operators.
   * Solution:
   */

  /**
   * 232.
   * Problem: Number of substrings divisible by 8 but not by 3.
   * Solution:
   */

  /**
   * 233.
   * Problem: Length Of Last Word in a String.
   * Solution:
   */

  /**
   * 234.
   * Problem: Decimal representation of given binary string is divisible by 5 or not.
   * Solution:
   */

  /**
   * 235.
   * Problem: ROT13 cipher.
   * Solution:
   */

  /**
   * 236.
   * Problem: Minimum sum of squares of character counts in a given string after removing k characters.
   * Solution:
   */

  /**
   * 237.
   * Problem: Program to count occurrence of a given character in a string.
   * Solution:
   */

  /**
   * 238.
   * Problem: C++ program to concatenate a string given number of times.
   * Solution:
   */

  /**
   * 239.
   * Problem: Implementing Atbash Cipher.
   * Solution:
   */

  /**
   * 240.
   * Problem: C program to Replace a word in a text by another given word.
   * Solution:
   */

  /**
   * 241.
   * Problem: Check if a given string is a valid number (Integer or Floating Point) | SET 1(Basic approach).
   * Solution:
   */

  /**
   * 242.
   * Problem: Put spaces between words starting with capital letters.
   * Solution:
   */

  /**
   * 243.
   * Problem: Sum of all substrings of a string representing a number | Set 2 (Constant Extra Space).
   * Solution:
   */

  /**
   * 244.
   * Problem: Find uncommon characters of the two strings.
   * Solution:
   */

  /**
   * 245.
   * Problem: Reverse a string preserving space positions.
   * Solution:
   */

  /**
   * 246.
   * Problem: String containing first letter of every word in a given string with spaces.
   * Solution:
   */

  /**
   * 247.
   * Problem: Program to print all substrings of a given string.
   * Solution:
   */

  /**
   * 248.
   * Problem: URLify a given string (Replace spaces is %20).
   * Solution:
   */

  /**
   * 249.
   * Problem: Check if a given string is a valid number (Integer or Floating Point) in Java.
   * Solution:
   */

  /**
   * 250.
   * Problem: Program to extract words from a given String.
   * Solution:
   */

  /**
   * 251.
   * Problem: Longest Common Prefix | Set 6 (Sorting).
   * Solution:
   */

  /**
   * 252.
   * Problem: Find shortest unique prefix for every word in a given list | Set 2 (Using Sorting).
   * Solution:
   */

  /**
   * 253.
   * Problem: Split numeric, alphabetic  and special symbols from a  String.
   * Solution:
   */

  /**
   * 254.
   * Problem: Encrypt a string into the Rovarspraket (The Robber Language).
   * Solution:
   */

  /**
   * 255.
   * Problem: Python program to check if a string is palindrome or not.
   * Solution:
   */

  /**
   * 256.
   * Problem: Get the first letter of each word in a string using regex in Java.
   * Solution:
   */

  /**
   * 257.
   * Problem: Reverse vowels in a given string.
   * Given a string, your task is to reverse only the vowels of string.
   */
  void reverseVowels(StringBuilder str, int left, int right) {
    if (left < right) {
      if (isVowel(str.charAt(left)) && isVowel(str.charAt(right))) {
        swapCharacter(str, left, right);
        reverseVowels(str, left + 1, right - 1);
      }
      else if (isVowel(str.charAt(left))) reverseVowels(str, left, right - 1);
      else if (isVowel(str.charAt(right))) reverseVowels(str, left + 1, right);
      else reverseVowels(str, left + 1, right - 1);
    }
  }

  private void swapCharacter(StringBuilder str, int left, int right) {
    char temp = str.charAt(left);
    str.setCharAt(left, str.charAt(right));
    str.setCharAt(right, temp);
  }

  private boolean isVowel(char c) {
    return (c=='a' || c=='A' || c=='e' ||
            c=='E' || c=='i' || c=='I' ||
            c=='o' || c=='O' || c=='u' ||
            c=='U');
  }

  /**
   * 258.
   * Problem: Decode a string recursively encoded as count followed by substring.
   * Solution:
   */

  /**
   * 259.
   * Problem: Count Uppercase, Lowercase, special character and numeric values.
   * Solution:
   */

  /**
   * 260.
   * Problem: Pattern Occurrences : Stack Implementation Java.
   * Solution:
   */

  /**
   * 261.
   * Problem: Rearrange a string in sorted order followed by the integer sum.
   * Solution:
   */
  class CountSumInfo {
    int[] charCount;
    int sum ;

    public CountSumInfo(int size, int sum) {
      this.charCount = new int[size];
      this.sum = sum;
    }
  }

  String sortedStrSum(String str) {
    CountSumInfo countSumInfo = new CountSumInfo(26, 0);
    rearrangeStringSum(str, countSumInfo);
    String res = "";
    for (int i = 0; i < countSumInfo.charCount.length; i++)
      while (countSumInfo.charCount[i]-- != 0) res += (char) (i + 'A');
    res += countSumInfo.sum;
    return res;
  }

  void rearrangeStringSum(String str, CountSumInfo countSumInfo) {
    if (!str.isEmpty()){
      if (Character.isUpperCase(str.charAt(0))) {
        countSumInfo.charCount[str.charAt(0) - 'A']++;
        rearrangeStringSum(str.substring(1), countSumInfo);
      }
      else {
        countSumInfo.sum += Character.getNumericValue(str.charAt(0));
        rearrangeStringSum(str.substring(1), countSumInfo);
      }
    }
  }


  /**
   * 262.
   * Problem: Check if a given string is a valid number (Integer or Floating Point) in Java | SET 2 (Regular Expression approach).
   * Solution:
   */

  void findNumber(int maxNum, int k) {
    ArrayList<Integer> set = new ArrayList<>();
    for (int i = 0; i < maxNum; i++) findNumber(maxNum, k, i, set);
  }
  
  void findNumber(int maxNum, int k, int soFar, ArrayList<Integer> set) {
    if (k == 0) System.out.println(soFar);
    else {
      for (int i = 0; i < 9; i++) {
        int currNum = soFar * 10 + i;
        if (currNum <= maxNum) findNumber(maxNum, k - 1, soFar, set);
        else {
          findNumber(maxNum, k - 1, soFar, set);
        }
      }
    }
  }

}
