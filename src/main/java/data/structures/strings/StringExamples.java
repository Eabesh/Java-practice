package data.structures.strings;

import java.util.ArrayList;

public class StringExamples {

  /** 1. Problem: Return maximum occurring character in an input string. */

  /** 2. Problem: Remove all duplicates from a given string. */

  /** 3. Problem: Print all the duplicates in the input string. */

  /** 4. Problem: Remove characters from the first string which are present in the second string. */

  /** 5. Problem: A Program to check if strings are rotations of each other or not. */
  boolean areRotations(String str1, String str2) {
    // There lengths must be same and str2 must be
    //        // a substring of str1 concatenated with str1.
    return (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1);
  }

  /** 6. Problem: Print reverse of a string using recursion. */
  void printReverseString(String str) {
    if (!str.isEmpty()) {
      printReverseString(str.substring(1));
      System.out.print(str.substring(0, 1));
    }
  }

  /** 7. Problem: Write a program to print all permutations of a given string. */

  /** 8. Problem: Divide a string in N equal parts. */

  /** 9. Problem: Given a string, find its first non-repeating character. */

  /** 10. Problem: Print list items containing all characters of a given word. */

  /** 11. Problem: Reverse words in a given string. */

  /** 12. Problem: Run Length Encoding. */

  /**
   * 13. Problem: Find the smallest window in a string containing all characters of another string.
   */

  /** 14. Problem: Print all permutations with repetition of characters. */
  void printAllPermutations(String soFar, String rem, int n) {
    if (n == 0) System.out.println(soFar);
    else
      for (int i = 0; i < rem.length(); i++)
        printAllPermutations(soFar + rem.charAt(i), rem, n - 1);
  }

  /** 15. Problem: Print all interleavings of given two strings. */

  /** 16. Problem: Check whether a given string is an interleaving of two other given strings. */

  /** 17. Problem: Check whether two strings are anagram of each other. */

  /** 18. Problem: Lexicographic rank of a string. */

  /** 19. Problem: Longest Palindromic Substring | Set 1. */

  /** 20. Problem: An in-place algorithm for String Transformation. Solution: */

  /** 21. Problem: Longest Palindromic Substring | Set 2. Solution: */

  /** 22. Problem: Given a sequence of words, print all anagrams together | Set 1. Solution: */

  /** 23. Problem: Given a sequence of words, print all anagrams together | Set 2. Solution: */

  /** 24. Problem: Count words in a given string. Solution: */

  /** 25. Problem: String matching where one string contains wildcard characters. Solution: */

  /** 26. Problem: Write your own atoi(). Solution: */

  /** 27. Problem: Remove &#8220;b&#8221; and &#8220;ac&#8221; from a given string. Solution: */

  /** 28. Problem: Find the first non-repeating character from a stream of characters. Solution: */

  /** 29. Problem: Recursively remove all adjacent duplicates. Solution: */
  String removeAllDuplicates(String input, String output) {
    if (input.equalsIgnoreCase(output)) return output;
    else {
      output = removeDups(input);
      removeAllDuplicates(input, output);
      return output;
    }
  }
// azxxzy
  String removeDups(String input) {
    return "";
  }

  /**
   * 30. Problem: Rearrange a string so that all same characters become d distance away. Solution:
   */

  /** 31. Problem: Printing Longest Common Subsequence. Solution: */

  /** 32. Problem: Print all possible words from phone digits. Solution: */

  /** 33. Problem: C Program to Sort an array of names or strings. Solution: */

  /** 34. Problem: C Program to Check if a Given String is Palindrome. Solution: */

  /** 35. Problem: Check if a given string is a rotation of a palindrome. Solution: */

  /** 36. Problem: Find Excel column name from a given column number. Solution: */

  /** 37. Problem: C++ Program to print all palindromes in a given range. Solution: */

  /**
   * 38. Problem: Given a sorted dictionary of an alien language, find order of characters.
   * Solution:
   */

  /** 39. Problem: Find if an array of strings can be chained to form a circle | Set 1. Solution: */

  /** 40. Problem: C program to find second most frequent character. Solution: */

  /**
   * 41. Problem: Given a number as a string, find the number of contiguous subsequences which
   * recursively add up to 9. Solution:
   */

  /** 42. Problem: Print all pairs of anagrams in a given array of strings. Solution: */

  /**
   * 43. Problem: Check if characters of a given string can be rearranged to form a palindrome.
   * Solution:
   */

  /** 44. Problem: C++ Program to remove spaces from a string. Solution: */

  /** 45. Problem: Lexicographically minimum string rotation. Solution: */

  /** 46. Problem: Given two strings, find if first string is a subsequence of second. Solution: */

  /** 47. Problem: Check a given sentence for a given set of simple grammer rules. Solution: */

  /**
   * 48. Problem: Manacher&#8217;s Algorithm &#8211; Linear Time Longest Palindromic Substring
   * &#8211; Part 1. Solution:
   */

  /**
   * 49. Problem: Manacher&#8217;s Algorithm &#8211; Linear Time Longest Palindromic Substring
   * &#8211; Part 2. Solution:
   */

  /**
   * 50. Problem: Manacher&#8217;s Algorithm &#8211; Linear Time Longest Palindromic Substring
   * &#8211; Part 3. Solution:
   */

  /**
   * 51. Problem: Manacher&#8217;s Algorithm &#8211; Linear Time Longest Palindromic Substring
   * &#8211; Part 4. Solution:
   */

  /** 52. Problem: Print all possible strings that can be made by placing spaces. Solution: */
  void printSpaces(String soFar, String str) {
    if (str.isEmpty()) System.out.println(soFar);
    else {
      printSpaces(soFar + str.charAt(0), str.substring(1));
      printSpaces(soFar + " " + str.charAt(0), str.substring(1));
    }
  }

  /**
   * 53. Problem: Find if a given string can be represented from a substring by iterating the
   * substring “n” times. Solution:
   */

  /** 54. Problem: Find all distinct palindromic sub-strings of a given string. Solution: */

  /** 55. Problem: Find maximum depth of nested parenthesis in a string. Solution: */

  /** 56. Problem: Function to find Number of customers who could not get a computer. Solution: */

  /**
   * 57. Problem: Find the longest substring with k unique characters in a given string. Solution:
   */

  /** 58. Problem: Check if a given sequence of moves for a robot is circular or not. Solution: */

  /**
   * 59. Problem: Recursively print all sentences that can be formed from list of word lists.
   * Solution:
   */

  /** 60. Problem: Online algorithm for checking palindrome in a stream. Solution: */

  /** 61. Problem: Remove spaces from a given string. Solution: */

  /** 62. Problem: Recursive function to do substring search. Solution: */

  /** 63. Problem: Shortest Superstring Problem. Solution: */

  /**
   * 64. Problem: Transform One String to Another using Minimum Number of Given Operation. Solution:
   */

  /** 65. Problem: Print string of odd length in &#8216;X&#8217; format. Solution: */

  /** 66. Problem: Minimum insertions to form shortest palindrome. Solution: */

  /** 67. Problem: Given a string, print all possible palindromic partitions. Solution: */

  /** 68. Problem: Check if two given strings are isomorphic to each other. Solution: */

  /** 69. Problem: Length of the longest valid substring. Solution: */

  /** 70. Problem: Program to add two binary strings. Solution: */

  /** 71. Problem: Recursive Implementation of atoi(). Solution: */

  /** 72. Problem: Reverse an array without affecting special characters. Solution: */

  /** 73. Problem: Remove recurring digits in a given number. Solution: */

  /** 74. Problem: Check if edit distance between two strings is one. Solution: */

  /** 75. Problem: Print Concatenation of Zig-Zag String in &#8216;n&#8217; Rows. Solution: */

  /** 76. Problem: 1&#8217;s and 2&#8217;s complement of a Binary Number. Solution: */

  /** 77. Problem: How to split a string in C/C++, Python and Java?. Solution: */

  /** 78. Problem: Print all palindrome permutations of a string. Solution: */

  /** 79. Problem: Different methods to reverse a string in C/C++. Solution: */

  /**
   * 80. Problem: Minimum number of palindromic subsequences to be removed to empty a binary string.
   * Solution:
   */

  /** 81. Problem: Permutations of a given string using STL. Solution: */

  /** 82. Problem: Caesar Cipher. Solution: */

  /** 83. Problem: Caesar Cipher. Solution: */

  /** 84. Problem: All combinations of strings that can be used to dial a number. Solution: */

  /** 85. Problem: K&#8217;th Non-repeating Character. Solution: */

  /** 86. Problem: Print all ways to break a string in bracket form. Solution: */

  /** 87. Problem: Generate all binary strings from given pattern. Solution: */

  /** 88. Problem: Pangram Checking. Solution: */

  /** 89. Problem: In-place replace multiple occurrences of a pattern. Solution: */

  /**
   * 90. Problem: Rearrange a string so that all same characters become atleast d distance away.
   * Solution:
   */

  /** 91. Problem: How to find Lexicographically previous permutation?. Solution: */

  /**
   * 92. Problem: Find all strings formed from characters mapped to digits of a number. Solution:
   */

  /** 93. Problem: Longest Common Prefix | Set 1 (Word by Word Matching). Solution: */

  /** 94. Problem: Longest Common Prefix | Set 2 (Character by Character Matching). Solution: */

  /** 95. Problem: Repeated subsequence of length 2 or more. Solution: */

  /** 96. Problem: Longest Common Prefix | Set 3 (Divide and Conquer). Solution: */

  /** 97. Problem: Lower case to upper case &#8211; An interesting fact. Solution: */

  /** 98. Problem: Longest Common Prefix | Set 5 (Using Trie). Solution: */

  /** 99. Problem: Print shortest path to print a string on screen. Solution: */

  /** 100. Problem: Remove extra spaces from a string. Solution: */

  /** 101. Problem: Palindrome Substring Queries. Solution: */

  /** 102. Problem: Change gender of a given string. Solution: */

  /** 103. Problem: Count number of substrings with exactly k distinct characters. Solution: */

  /** 104. Problem: Removing spaces from a string using Stringstream. Solution: */

  /**
   * 105. Problem: Longest Common Extension / LCE | Set 1 (Introduction and Naive Method). Solution:
   */

  /** 106. Problem: Longest Common Extension / LCE | Set 2 ( Reduction to RMQ). Solution: */

  /** 107. Problem: Longest Common Extension / LCE | Set 3 (Segment Tree Method). Solution: */

  /** 108. Problem: Concurrent Merge Sort in Shared Memory. Solution: */

  /** 109. Problem: Calculate sum of all numbers present in a string. Solution: */

  /**
   * 110. Problem: Find longest palindrome formed by removing or shuffling chars from string.
   * Solution:
   */

  /**
   * 111. Problem: Check if string follows order of characters defined by a pattern or not | Set 1.
   * Solution:
   */

  /** 112. Problem: Find all strings that match specific pattern in a dictionary. Solution: */

  /** 113. Problem: Minimum Cost To Make Two Strings Identical. Solution: */

  /** 114. Problem: Find k&#8217;th character of decrypted string. Solution: */

  /**
   * 115. Problem: Check if string follows order of characters defined by a pattern or not | Set 2.
   * Solution:
   */

  /**
   * 116. Problem: Check if string follows order of characters defined by a pattern or not | Set 3.
   * Solution:
   */

  /** 117. Problem: Group Shifted String. Solution: */

  /** 118. Problem: Vigenère Cipher. Solution: */

  /** 119. Problem: Pairs of complete strings in two sets of strings. Solution: */

  /** 120. Problem: Compare two Version numbers. Solution: */

  /** 121. Problem: String with additive sequence. Solution: */

  /** 122. Problem: Longest common subsequence with permutations allowed. Solution: */

  /** 123. Problem: Perfect reversible string. Solution: */

  /**
   * 124. Problem: Check if a string has all characters with same frequency with one variation
   * allowed. Solution:
   */

  /**
   * 125. Problem: Check if a string can become empty by recursively deleting a given sub-string.
   * Solution:
   */

  /**
   * 126. Problem: Remove minimum number of characters so that two strings become anagram. Solution:
   */

  /** 127. Problem: XOR Cipher. Solution: */

  /** 128. Problem: Smallest Palindrome after replacement. Solution: */

  /** 129. Problem: Count of distinct substrings of a string using Suffix Trie. Solution: */

  /** 130. Problem: Sort a string according to the order defined by another string. Solution: */

  /** 131. Problem: Remove a character from a string to make it a palindrome. Solution: */

  /** 132. Problem: Distinct strings with odd and even changes allowed. Solution: */

  /**
   * 133. Problem: Find if an array of strings can be chained to form a circle | Set 2. Solution:
   */

  /** 134. Problem: Count characters at same position as in English alphabets. Solution: */

  /** 135. Problem: Group all occurrences of characters according to first appearance. Solution: */

  /** 136. Problem: Check for Palindrome after every character replacement Query. Solution: */

  /** 137. Problem: Count All Palindrome Sub-Strings in a String. Solution: */

  /** 138. Problem: Minimum characters to be added at front to make string palindrome. Solution: */

  /** 139. Problem: Convert to a string that is repetition of a substring of k length. Solution: */

  /** 140. Problem: Nth character in Concatenated Decimal String. Solution: */

  /** 141. Problem: Word Break Problem using Backtracking. Solution: */

  /**
   * 142. Problem: Minimum cost to sort strings using reversal operations of different costs.
   * Solution:
   */

  /** 143. Problem: Print all palindromic partitions of a string. Solution: */

  /** 144. Problem: Count of character pairs at same distance as in English alphabets. Solution: */

  /**
   * 145. Problem: Minimum number of characters to be removed to make a binary string alternate.
   * Solution:
   */

  /** 146. Problem: Check if all rows of a matrix are circular rotations of each other. Solution: */

  /** 147. Problem: Check if two strings are k-anagrams or not. Solution: */

  /**
   * 148. Problem: Check length of a string is equal to the number appended at its last. Solution:
   */

  /** 149. Problem: Generate all binary strings without consecutive 1&#8217;s. Solution: */

  /** 150. Problem: Program to toggle all characters in a string. Solution: */

  /** 151. Problem: Efficient method for 2&#8217;s complement of a binary string. Solution: */

  /** 152. Problem: Array of Strings in C++ (3 Different Ways to Create). Solution: */

  /** 153. Problem: Queries for characters in a repeated string. Solution: */

  /** 154. Problem: Queries on subsequence of string. Solution: */

  /** 155. Problem: Queries on substring palindrome formation. Solution: */

  /** 156. Problem: Check whether Strings are k distance apart or not. Solution: */

  /** 157. Problem: Boggle | Set 2 (Using Trie). Solution: */

  /** 158. Problem: Implementation of Affine Cipher. Solution: */

  /** 159. Problem: Hamming Distance between two strings. Solution: */

  /**
   * 160. Problem: Count of words whose i-th letter is either (i-1)-th, i-th, or (i+1)-th letter of
   * given word. Solution:
   */

  /**
   * 161. Problem: Efficiently check if a string has duplicates without using any additional data
   * structure. Solution:
   */

  /** 162. Problem: Print consecutive characters together in a line. Solution: */

  /** 163. Problem: Print all valid words that are possible using Characters of Array. Solution: */

  /**
   * 164. Problem: Rearrange characters in a string such that no two adjacent are same. Solution:
   */

  /** 165. Problem: Palindrome pair in an array of words (or strings). Solution: */

  /** 166. Problem: Count of total anagram substrings. Solution: */

  /** 167. Problem: Make largest palindrome by changing at most K-digits. Solution: */

  /**
   * 168. Problem: Check if a string can be obtained by rotating another string 2 places. Solution:
   */

  /**
   * 169. Problem: Find largest word in dictionary by deleting some characters of given string.
   * Solution:
   */

  /** 170. Problem: Group words with same set of characters. Solution: */

  /** 171. Problem: Sum of two large numbers. Solution: */

  /**
   * 172. Problem: Count of strings that can be formed using a, b and c under given constraints.
   * Solution:
   */

  /** 173. Problem: Maximum consecutive repeating character in string. Solution: */

  /** 174. Problem: Difference of two large numbers. Solution: */

  /**
   * 175. Problem: Replace all occurrences of string AB with C without using extra space. Solution:
   */

  /** 176. Problem: Find the missing number in a string of numbers with no separator. Solution: */

  /** 177. Problem: Count substrings with same first and last characters. Solution: */

  /** 178. Problem: Lexicographically first palindromic string. Solution: */

  /** 179. Problem: Sum of all substrings of a string representing a number | Set 1. Solution: */

  /** 180. Problem: Number of subsequences of the form a^i b^j c^k. Solution: */

  /** 181. Problem: Convert decimal fraction to binary number. Solution: */

  /** 182. Problem: Convert Binary fraction to Decimal. Solution: */

  /** 183. Problem: Count ways to increase LCS length of two strings by one. Solution: */

  /** 184. Problem: Find an equal point in a string of brackets. Solution: */

  /**
   * 185. Problem: Check if frequency of all characters can become same by one removal. Solution:
   */

  /** 186. Problem: Find the first repeated character in a string. Solution: */

  /** 187. Problem: Number of substrings divisible by 6 in a string of integers. Solution: */

  /** 188. Problem: Number of substrings divisible by 6 in a string of integers. Solution: */

  /** 189. Problem: Number of even substrings in a string of digits. Solution: */

  /** 190. Problem: Substring with highest frequency length product. Solution: */

  /**
   * 191. Problem: Meta Strings (Check if two strings can become same after a swap in one string).
   * Solution:
   */

  /** 192. Problem: Multiply Large Numbers represented as Strings. Solution: */

  /** 193. Problem: Check if a string follows a^nb^n pattern or not. Solution: */

  /** 194. Problem: Search in an array of strings where non-empty strings are sorted. Solution: */

  /**
   * 195. Problem: Smallest length string with repeated replacement of two distinct adjacent.
   * Solution:
   */

  /** 196. Problem: Print Kth character in sorted concatenated substrings of a string. Solution: */

  /** 197. Problem: Recursive function to check if a string is palindrome. Solution: */

  /** 198. Problem: Reverse string without using any temporary variable. Solution: */

  /** 199. Problem: Check if given string can be split into four distinct strings. Solution: */

  /** 200. Problem: Find Excel column number from column title. Solution: */

  /**
   * 201. Problem: Minimum number of Appends needed to make a string palindrome. Minimum number of
   * Appends needed to make a string palindrome.
   */
  int minAppends(String str, int left, int right) {
    if (left > right) return Integer.MAX_VALUE;
    else if (left == right) return 0;
    else if (left + 1 == right) return (str.charAt(left) == str.charAt(right)) ? 0 : 1;
    else if (str.charAt(left) == str.charAt(right)) return minAppends(str, left + 1, right - 1);
    else return 1 + minAppends(str, left + 1, right);
  }

  /**
   * 202. Problem: Move spaces to front of string in single traversal. Given a string that has set
   * of words and spaces, write a program to move all spaces to front of string, by traversing the
   * string only once.
   */

  /** 203. Problem: Minimum number of deletions to make a string palindrome. */

  /**
   * 204. Problem: Program to find the largest and smallest ASCII valued characters in a string.
   * Solution:
   */

  /**
   * 205. Problem: Maximum length prefix of one string that occurs as subsequence in another.
   * Solution:
   */

  /** 206. Problem: Reverse a string in Java (5 Different Ways). Solution: */

  /** 207. Problem: Binary representation of next number. Solution: */

  /**
   * 208. Problem: All possible strings of any length that can be formed from a given string.
   * Solution:
   */

  /** 209. Problem: Alternate vowel and consonant string. Solution: */

  /** 210. Problem: Left Rotation and Right Rotation of a String. Solution: */

  /** 211. Problem: String in Switch Case in Java. Solution: */

  /** 212. Problem: Generate all rotations of a given string. Solution: */

  /** 213. Problem: Sort an array of strings according to string lengths. Solution: */

  /**
   * 214. Problem: Binary representation of next greater number with same number of 1&#8217;s and
   * 0&#8217;s. Solution:
   */

  /** 215. Problem: Convert characters of a string to opposite case. Solution: */

  /**
   * 216. Problem: Minimum steps to delete a string after repeated deletion of palindrome
   * substrings. Solution:
   */

  /** 217. Problem: Missing characters to make a string Pangram. Solution: */

  /** 218. Problem: Missing characters to make a string Pangram. Solution: */

  /** 219. Problem: Print common characters of two Strings in alphabetical order. Solution: */

  /** 220. Problem: Smallest window that contains all characters of string itself. Solution: */

  /**
   * 221. Problem: Print array of strings in sorted order without copying one string into another.
   * Solution:
   */

  /** 222. Problem: Ropes Data Structure (Fast String Concatenation). Solution: */

  /** 223. Problem: Determine if a string has all Unique Characters. Solution: */

  /** 224. Problem: Shortest Uncommon Subsequence. Solution: */

  /** 225. Problem: Print all distinct characters of a string in order (3 Methods). Solution: */

  /** 226. Problem: Program to find Smallest and Largest Word in a String. Solution: */

  /** 227. Problem: Number of distinct permutation a String can have. Solution: */

  /** 228. Problem: Program to remove vowels from a String. Solution: */

  /**
   * 229. Problem: Case conversion (Lower to Upper and Vice Versa) of a string using BitWise
   * operators in C/C++. Solution:
   */

  /** 230. Problem: Removing punctuations from a given string. Solution: */

  /** 231. Problem: Toggle case of a string using Bitwise operators. Solution: */

  /** 232. Problem: Number of substrings divisible by 8 but not by 3. Solution: */

  /** 233. Problem: Length Of Last Word in a String. Solution: */

  /**
   * 234. Problem: Decimal representation of given binary string is divisible by 5 or not. Solution:
   */

  /** 235. Problem: ROT13 cipher. Solution: */

  /**
   * 236. Problem: Minimum sum of squares of character counts in a given string after removing k
   * characters. Solution:
   */

  /** 237. Problem: Program to count occurrence of a given character in a string. Solution: */

  /** 238. Problem: C++ program to concatenate a string given number of times. Solution: */

  /** 239. Problem: Implementing Atbash Cipher. Solution: */

  /** 240. Problem: C program to Replace a word in a text by another given word. Solution: */

  /**
   * 241. Problem: Check if a given string is a valid number (Integer or Floating Point) | SET
   * 1(Basic approach). Solution:
   */

  /** 242. Problem: Put spaces between words starting with capital letters. Solution: */

  /**
   * 243. Problem: Sum of all substrings of a string representing a number | Set 2 (Constant Extra
   * Space). Solution:
   */

  /** 244. Problem: Find uncommon characters of the two strings. Solution: */

  /** 245. Problem: Reverse a string preserving space positions. Solution: */

  /**
   * 246. Problem: String containing first letter of every word in a given string with spaces.
   * Solution:
   */

  /** 247. Problem: Program to print all substrings of a given string. Solution: */

  /** 248. Problem: URLify a given string (Replace spaces is %20). Solution: */

  /**
   * 249. Problem: Check if a given string is a valid number (Integer or Floating Point) in Java.
   * Solution:
   */

  /** 250. Problem: Program to extract words from a given String. Solution: */

  /** 251. Problem: Longest Common Prefix | Set 6 (Sorting). Solution: */

  /**
   * 252. Problem: Find shortest unique prefix for every word in a given list | Set 2 (Using
   * Sorting). Solution:
   */

  /** 253. Problem: Split numeric, alphabetic and special symbols from a String. Solution: */

  /** 254. Problem: Encrypt a string into the Rovarspraket (The Robber Language). Solution: */

  /** 255. Problem: Python program to check if a string is palindrome or not. Solution: */

  /** 256. Problem: Get the first letter of each word in a string using regex in Java. Solution: */

  /**
   * 257. Problem: Reverse vowels in a given string. Given a string, your task is to reverse only
   * the vowels of string.
   */
  void reverseVowels(StringBuilder str, int left, int right) {
    if (left < right) {
      if (isVowel(str.charAt(left)) && isVowel(str.charAt(right))) {
        swapCharacter(str, left, right);
        reverseVowels(str, left + 1, right - 1);
      } else if (isVowel(str.charAt(left))) reverseVowels(str, left, right - 1);
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
    return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o'
        || c == 'O' || c == 'u' || c == 'U');
  }

  /** 258. Problem: Decode a string recursively encoded as count followed by substring. Solution: */

  /** 259. Problem: Count Uppercase, Lowercase, special character and numeric values. Solution: */

  /** 260. Problem: Pattern Occurrences : Stack Implementation Java. Solution: */
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
    if (!str.isEmpty()) {
      if (Character.isUpperCase(str.charAt(0))) {
        countSumInfo.charCount[str.charAt(0) - 'A']++;
        rearrangeStringSum(str.substring(1), countSumInfo);
      } else {
        countSumInfo.sum += Character.getNumericValue(str.charAt(0));
        rearrangeStringSum(str.substring(1), countSumInfo);
      }
    }
  }

  /**
   * 262. Problem: Check if a given string is a valid number (Integer or Floating Point) in Java |
   * SET 2 (Regular Expression approach). Solution:
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

  /**
   * 332. Problem: Minimum Number of Manipulations required to make two Strings Anagram Without
   * Deletion of Character. Solution:
   */
  int manipulationCount(String str1, String str2) {
    int count = 0;
    int[] freq = new int[26];
    for (char c : str1.toCharArray()) freq[c - 'a']++;
    for (char c : str2.toCharArray()) if (freq[c - 'a']-- <= 0) count++;
    return count;
  }

  /** 263. Problem: Rearrange a string in sorted order followed by the integer sum. Solution: */

  /**
   * 264. Problem: Check if a given string is a valid number (Integer or Floating Point) in Java |
   * SET 2 (Regular Expression approach). Solution:
   */

  /**
   * 265. Problem: Check if a binary string has a 0 between 1s or not | Set 1 (General approach).
   * Solution:
   */

  /**
   * 266. Problem: Extract maximum numeric value from a given string | Set 1 (General approach).
   * Solution:
   */

  /**
   * 267. Problem: Find all the patterns of &#8220;1(0+)1&#8221; in a given string | SET 1(General
   * Approach). Solution:
   */

  /** 268. Problem: Check if a string is Isogram or not. Solution: */

  /** 269. Problem: Baconian Cipher. Solution: */

  /** 270. Problem: Count words present in a string. Solution: */

  /** 271. Problem: Second most repeated word in a sequence. Solution: */

  /**
   * 272. Problem: Count number of strings (made of R, G and B) using given combination. Solution:
   */

  /** 273. Problem: Lexicographically smallest rotated sequence | Set 2. Solution: */

  /**
   * 274. Problem: Find all the patterns of &#8220;1(0+)1&#8221; in a given string | SET 2(Regular
   * Expression Approach). Solution:
   */

  /**
   * 275. Problem: Extract maximum numeric value from a given string | Set 2 (Regex approach).
   * Solution:
   */

  /**
   * 276. Problem: Check if a binary string has a 0 between 1s or not | Set 2 (Regular Expression
   * Approach). Solution:
   */

  /** 277. Problem: Count of Palindromic substrings in an Index range. Solution: */

  /**
   * 278. Problem: Given a number as a string, find the number of contiguous subsequences which
   * recursively add up to 9 | Set 2. Solution:
   */

  /**
   * 279. Problem: std::string::append vs std::string::push_back() vs Operator += in C++. Solution:
   */

  /**
   * 280. Problem: Print the string by ignoring alternate occurrences of any character. Solution:
   */

  /** 281. Problem: Check if both halves of the string have same set of characters. Solution: */

  /** 282. Problem: Minimum insertions to form a palindrome with permutations allowed. Solution: */

  /** 283. Problem: Calculate the difficulty of a sentence. Solution: */

  /** 284. Problem: Nth Even length Palindrome. Solution: */

  /** 285. Problem: Keyword Cipher. Solution: */

  /** 286. Problem: Lexicographically n-th permutation of a string. Solution: */

  /**
   * 287. Problem: Find the character in first string that is present at minimum index in second
   * string. Solution:
   */

  /**
   * 288. Problem: Print the string after the specified character has occurred given no. of times.
   * Solution:
   */

  /**
   * 289. Problem: Find length of longest subsequence of one string which is substring of another
   * string. Solution:
   */

  /** 290. Problem: Quick way to check if all the characters of a string are same. Solution: */

  /**
   * 291. Problem: Calculate maximum value using &#8216;+&#8217; or &#8216;*&#8217; sign between two
   * numbers in a string. Solution:
   */

  /** 292. Problem: Given a sequence of words, print all anagrams together using STL. Solution: */

  /** 293. Problem: Program to check if input is an integer or a string. Solution: */

  /**
   * 294. Problem: Maximum length substring having all same characters after k changes. Solution:
   */

  /** 295. Problem: Queue based approach for first non-repeating character in a stream. Solution: */

  /**
   * 296. Problem: Min flips of continuous characters to make all characters same in a string.
   * Solution:
   */

  /** 297. Problem: Count words that appear exactly two times in an array of words. Solution: */

  /** 298. Problem: Null Cipher. Solution: */

  /** 299. Problem: Minimum Swaps for Bracket Balancing. Solution: */

  /** 300. Problem: Find numbers of balancing positions in string. Solution: */

  /** 301. Problem: Minimum rotations required to get the same string. Solution: */

  /**
   * 302. Problem: Ways to remove one element from a binary string so that XOR becomes zero.
   * Solution:
   */

  /** 303. Problem: Longest Possible Chunked Palindrome. Solution: */

  /** 304. Problem: Alphanumeric Abbreviations of a String. Solution: */

  /** 305. Problem: Check if a string is Pangrammatic Lipogram. Solution: */

  /**
   * 306. Problem: Ways of transforming one string to other by removing 0 or more characters.
   * Solution:
   */

  /**
   * 307. Problem: Largest even number possible by using one swap operation in given number.
   * Solution:
   */

  /** 308. Problem: Minimum Index Sum for Common Elements of Two Lists. Solution: */

  /** 309. Problem: Permute a string by changing case. Solution: */

  /**
   * 310. Problem: Convert all substrings of length &#8216;k&#8217; from base &#8216;b&#8217; to
   * decimal. Solution:
   */

  /** 311. Problem: Count of occurrences of a &#8220;1(0+)1&#8221; pattern in a string. Solution: */

  /**
   * 312. Problem: Sentence Palindrome (Palindrome after removing spaces, dots, .. etc). Solution:
   */

  /** 313. Problem: Minimum number of deletions so that no two consecutive are same. Solution: */

  /** 314. Problem: Longest common substring in binary representation of two numbers. Solution: */

  /** 315. Problem: Reverse words in a given String in Java. Solution: */

  /** 316. Problem: Find n-th lexicographically permutation of a string | Set 2. Solution: */

  /** 317. Problem: Lexicographic rank of a string using STL. Solution: */

  /** 318. Problem: Find the first repeated word in a string. Solution: */

  /** 319. Problem: Print all possible strings that can be made by placing spaces. Solution: */

  /** 320. Problem: Roll the characters of string. Solution: */

  /** 321. Problem: Print the longest common substring. Solution: */

  /**
   * 322. Problem: Efficiently find first repeated character in a string without using any
   * additional data structure in one traversal. Solution:
   */

  /** 323. Problem: Find if an array contains a string with one mismatch. Solution: */

  /** 324. Problem: Evaluate a boolean expression represented as string. Solution: */

  /** 325. Problem: Print characters and their frequencies in order of occurrence. Solution: */

  /** 326. Problem: Given two strings check which string makes a palindrome first. Solution: */

  /**
   * 327. Problem: Least number of manipulations needed to ensure two strings have identical
   * characters. Solution:
   */

  /**
   * 328. Problem: Print all Subsequences of String which Start with Vowel and End with Consonant..
   * Solution:
   */

  /** 329. Problem: Shortest possible combination of two strings. Solution: */

  /** 330. Problem: Check if a given string is sum-string. Solution: */

  /** 331. Problem: Count All Palindrome Sub-Strings in a String | Set 2. Solution: */

  /**
   * 380. Problem: Remove all consecutive duplicates from the string. Here we keep one character and
   * remove all subsequent same characters.
   */
  String removeDuplicates(String str) {
    int i = 0, j = 0;
    String res = "";
    while (i < str.length()) {
      while (j < str.length() && str.charAt(i) == str.charAt(j)) j++;
      res += str.charAt(i);
      i = j;
    }
    return res;
  }

  /**
   * 333. Problem: Recursive solution to count substrings with same first and last characters.
   * Solution:
   */

  /** 334. Problem: Print all subsequences of a string. Solution: */

  /**
   * 335. Problem: Length of the smallest sub-string consisting of maximum distinct characters.
   * Solution:
   */

  /** 336. Problem: isupper() and islower() and their application in C++. Solution: */

  /** 337. Problem: Remove three consecutive duplicates from string. Solution: */

  /**
   * 338. Problem: Generating distinct subsequences of a given string in lexicographic order.
   * Solution:
   */

  /** 339. Problem: Check if any anagram of a string is palindrome or not. Solution: */

  /** 340. Problem: Concatenated string with uncommon characters of two strings. Solution: */

  /** 341. Problem: Longest subsequence where every character appears at-least k times. Solution: */

  /** 342. Problem: Frequency of a string in an array of strings. Solution: */

  /**
   * 343. Problem: Check if a grid can become row-wise and column-wise sorted after adjacent swaps.
   * Solution:
   */

  /** 344. Problem: Sorting array of strings (or words) using Trie. Solution: */

  /** 345. Problem: Word Break Problem | (Trie solution). Solution: */

  /** 346. Problem: Binary representation of previous number. Solution: */

  /** 347. Problem: Decode an Encoded Base 64 String to ASCII String. Solution: */

  /** 348. Problem: Number of substrings with count of each character as k. Solution: */

  /** 349. Problem: Find substrings that contain all vowels. Solution: */

  /** 350. Problem: Longest substring of vowels. Solution: */

  /** 351. Problem: Find repeated character present first in a string. Solution: */

  /** 352. Problem: Lexicographically first alternate vowel and consonant string. Solution: */

  /** 353. Problem: Distributing all balls without repetition. Solution: */

  /** 354. Problem: Luhn algorithm. Solution: */

  /** 355. Problem: Sort string of characters. Solution: */

  /** 356. Problem: Program to find the initials of a name.. Solution: */

  /** 357. Problem: Most frequent word in an array of strings. Solution: */

  /**
   * 358. Problem: Find winner of an election where votes are represented as candidate names.
   * Solution:
   */

  /** 359. Problem: Program for credit card number validation. Solution: */

  /**
   * 360. Problem: Make a string from another by deletion and rearrangement of characters. Solution:
   */

  /** 361. Problem: Longest Common Substring in an Array of Strings. Solution: */

  /** 362. Problem: Reversing an Equation. Solution: */

  /**
   * 363. Problem: Generate two output strings depending upon occurrence of character in input
   * string.. Solution:
   */

  /** 364. Problem: Count of substrings of a binary string containing K ones. Solution: */

  /** 365. Problem: Compare two strings lexicographically in Java. Solution: */

  /** 366. Problem: Check if a two character string can be made using given words. Solution: */

  /**
   * 367. Problem: Number of positions where a letter can be inserted such that a string becomes
   * palindrome. Solution:
   */

  /** 368. Problem: Rearrange a binary string as alternate x and y occurrences. Solution: */

  /** 369. Problem: Minimal operations to make a number magical. Solution: */

  /** 370. Problem: Shortest substring of a string containing all given words. Solution: */

  /**
   * 371. Problem: Lexicographically largest subsequence such that every character occurs at least k
   * times. Solution:
   */

  /** 372. Problem: stringstream in C++ and its applications. Solution: */

  /** 373. Problem: Count of strings where adjacent characters are of difference one. Solution: */

  /**
   * 374. Problem: Lexicographically smallest string whose hamming distance from given string is
   * exactly K. Solution:
   */

  /** 375. Problem: Common characters in n strings. Solution: */

  /** 376. Problem: Length of Longest Balanced Subsequence. Solution: */

  /** 377. Problem: Simplify the directory path (Unix like). Solution: */

  /** 378. Problem: Reverse string in Python (5 different ways). Solution: */

  /**
   * 379. Problem: Minimum reduce operations to covert a given string into a palindrome. Solution:
   */

  /** 261. Problem: Rearrange a string in sorted order followed by the integer sum. Solution: */
  class CountSumInfo {
    int[] charCount;
    int sum;

    public CountSumInfo(int size, int sum) {
      this.charCount = new int[size];
      this.sum = sum;
    }
  }

  /** 381. Problem: Burrows &#8211; Wheeler Data Transform Algorithm. Solution: */

  /** 382. Problem: Possibility of moving out of maze. Solution: */

  /** 383. Problem: Length of the longest substring with equal 1s and 0s. Solution: */

  /** 384. Problem: String with k distinct characters and no same characters adjacent. Solution: */

  /** 385. Problem: Lexicographically next string. Solution: */

  /** 386. Problem: Compare Version Numbers with large inputs allowed. Solution: */

  /** 387. Problem: Inverting the Burrows &#8211; Wheeler Transform. Solution: */

  /** 388. Problem: Possibility of a word from a given set of characters. Solution: */

  /** 389. Problem: Check if an encoding represents a unique binary string. Solution: */

  /** 390. Problem: Minimum number of stops from given path. Solution: */

  /**
   * 391. Problem: Maximum number of characters between any two same character in a string.
   * Solution:
   */

  /** 392. Problem: Remove all duplicates from a given string in Python. Solution: */

  /** 393. Problem: Minimum move to end operations to make all strings equal. Solution: */

  /** 394. Problem: Program to sort string in descending order. Solution: */

  /** 395. Problem: Run Length Encoding in Python. Solution: */

  /** 396. Problem: Anagram checking in Python using collections.Counter(). Solution: */

  /** 397. Problem: Decode a median string to the original string. Solution: */

  /**
   * 398. Problem: K’th Non-repeating Character in Python using List Comprehension and OrderedDict.
   * Solution:
   */

  /** 399. Problem: Program to check Strength of Password. Solution: */

  /** 400. Problem: Generate permutations with only adjacent swaps allowed. Solution: */

  /** 401. Problem: Print words of a string in reverse order. Solution: */

  /** 402. Problem: Distinct permutations of the string | Set 2. Solution: */

  /** 403. Problem: Prefix matching in Python using pytrie module. Solution: */

  /** 404. Problem: Print number with commas as 1000 separators in Python. Solution: */

  /** 405. Problem: Construct Binary Tree from String with bracket representation. Solution: */

  /** 406. Problem: Reverse words in a given String in Python. Solution: */

  /** 407. Problem: Remove all characters other than alphabets from string. Solution: */

  /** 408. Problem: Print anagrams together in Python using List and Dictionary. Solution: */

  /** 409. Problem: Longest subsequence of the form 0*1*0* in a binary string. Solution: */

  /** 410. Problem: Check if two expressions with brackets are same. Solution: */

  /**
   * 411. Problem: Using OrderedDict() in Python to check order of characters in string. Solution:
   */

  /** 412. Problem: Program to find remainder when large number is divided by 11. Solution: */

  /**
   * 413. Problem: Using Counter() in Python to find minimum character removal to make two strings
   * anagram. Solution:
   */

  /** 414. Problem: Program to check for ISBN. Solution: */

  /** 415. Problem: Print all subsequences of a string | Iterative Method. Solution: */

  /** 416. Problem: Binary tree to string with brackets. Solution: */

  /**
   * 417. Problem: String slicing in Python to check if a string can become empty by recursive
   * deletion. Solution:
   */

  /** 418. Problem: Encoding a word into Pig Latin. Solution: */

  /** 419. Problem: Using Set() in Python Pangram Checking. Solution: */

  /** 420. Problem: Minimum cost to convert string into palindrome. Solution: */

  /**
   * 421. Problem: Number of subsequences as &#8220;ab&#8221; in a string repeated K times.
   * Solution:
   */

  /** 422. Problem: Possible Words using given characters in Python. Solution: */

  /** 423. Problem: Binary String of given length that without a palindrome of size 3. Solution: */

  /** 424. Problem: Minimum Word Break. Solution: */

  /** 425. Problem: Printing string in plus ‘+’ pattern in the matrix. Solution: */

  /** 426. Problem: Mirror characters of a string. Solution: */

  /** 427. Problem: Convert string to char array in C++. Solution: */

  /** 428. Problem: Frequency of a substring in a string. Solution: */

  /** 429. Problem: Count of operations to make a binary string&#8221;ab&#8221; free. Solution: */

  /**
   * 430. Problem: Different substrings in a string that start and end with given strings. Solution:
   */

  /** 431. Problem: String slicing in Python to rotate a string. Solution: */

  /**
   * 432. Problem: Find index of closing bracket for a given opening bracket in an expression.
   * Solution:
   */

  /** 433. Problem: Change string to a new character set. Solution: */

  /** 434. Problem: Python code to move spaces to front of string in single traversal. Solution: */

  /** 435. Problem: Find minimum shift for longest common prefix. Solution: */

  /**
   * 436. Problem: Python code to print common characters of two Strings in alphabetical order.
   * Solution:
   */

  /** 437. Problem: Identify and mark unmatched parenthesis in an expression. Solution: */

  /** 438. Problem: Move To Front Data Transform Algorithm. Solution: */

  /** 439. Problem: Construct lexicographically smallest palindrome. Solution: */

  /** 440. Problem: Inverting the Move to Front Transform. Solution: */

  /** 441. Problem: Print Longest Palindromic Subsequence. Solution: */

  /** 442. Problem: Camel case of a given sentence. Solution: */

  /**
   * 443. Problem: Regex in Python to put spaces between words starting with capital letters.
   * Solution:
   */

  /** 444. Problem: Tokenizing a string in C++. Solution: */

  /** 445. Problem: Python Regex to extract maximum numeric value from a string. Solution: */

  /** 446. Problem: Minimum cost to make two strings identical by deleting the digits. Solution: */

  /** 447. Problem: Second most repeated word in a sequence in Python. Solution: */

  /** 448. Problem: Concatenated string with uncommon characters in Python. Solution: */

  /** 449. Problem: Split the string into substrings using delimiter. Solution: */

  /**
   * 450. Problem: Check if both halves of the string have same set of characters in Python.
   * Solution:
   */

  /** 451. Problem: Sums of ASCII values of each word in a sentence. Solution: */

  /**
   * 452. Problem: Decimal to octal conversion with minimum use of arithmetic operators. Solution:
   */

  /** 453. Problem: Sum of first K even-length Palindrome numbers. Solution: */

  /** 454. Problem: Minimum cost to construct a string. Solution: */

  /** 455. Problem: Count occurrences of a word in string. Solution: */

  /** 456. Problem: Number of palindromic subsequences of length k. Solution: */

  /** 457. Problem: Fibonacci Word. Solution: */

  /** 458. Problem: Dictionary and counter in Python to find winner of election. Solution: */

  /**
   * 459. Problem: Maximum length of consecutive 1&#8217;s in a binary string in Python using Map
   * function. Solution:
   */

  /** 460. Problem: Length of longest balanced parentheses prefix. Solution: */

  /** 461. Problem: WildCard pattern matching having three symbols ( * , + , ? ). Solution: */

  /** 462. Problem: Maximum difference of zeros and ones in binary string. Solution: */

  /** 463. Problem: Replace a character c1 with c2 and c2 with c1 in a string S. Solution: */

  /** 464. Problem: Find last index of a character in a string. Solution: */

  /**
   * 465. Problem: Python counter and dictionary intersection example (Make a string using deletion
   * and rearrangement). Solution:
   */

  /** 466. Problem: Python | Print the initials of a name with last name in full. Solution: */

  /** 467. Problem: Program to implement ASCII lookup table. Solution: */

  /** 468. Problem: Number of ways to insert a character to increase the LCS by one. Solution: */

  /**
   * 469. Problem: Breaking a number such that first part is integral division of second by a power
   * of 10. Solution:
   */

  /** 470. Problem: Position of robot after given movements. Solution: */

  /** 471. Problem: SequenceMatcher in Python for Longest Common Substring. Solution: */

  /** 472. Problem: Program to check if a number belongs to a particular base or not. Solution: */

  /**
   * 473. Problem: Encrypt string with product of number of vowels and consonants in substring of
   * size k. Solution:
   */

  /** 474. Problem: Zip function in Python to change to a new character set. Solution: */

  /** 475. Problem: Map function and Lambda expression in Python to replace characters. Solution: */

  /** 476. Problem: Map function and Dictionary in Python to sum ASCII values. Solution: */

  /** 477. Problem: Print number of words, vowels and frequency of each character. Solution: */

  /**
   * 478. Problem: Check whether second string can be formed from characters of first string.
   * Solution:
   */

  /**
   * 479. Problem: Next word that does not contain a palindrome and has characters from first k.
   * Solution:
   */

  /**
   * 480. Problem: Program to count vowels, consonant, digits and special characters in string..
   * Solution:
   */

  /** 481. Problem: Form the largest palindromic number using atmost two swaps. Solution: */

  /** 482. Problem: Find the size of largest subset of anagram words. Solution: */

  /** 483. Problem: Convert Infix To Prefix Notation. Solution: */

  /** 484. Problem: Python sorted() to check if two strings are anagram or not. Solution: */

  /** 485. Problem: Python | Check if a Substring is Present in a Given String. Solution: */

  /** 486. Problem: Python set to check if string is panagram. Solution: */

  /** 487. Problem: Program to check for a Valid IMEI Number. Solution: */

  /**
   * 488. Problem: Python program to count number of vowels using sets in given string. Solution:
   */

  /** 489. Problem: Count subsequence of length three in a given string. Solution: */

  /** 490. Problem: Minimum equal palindromic cuts with rearrangements allowed. Solution: */

  /** 491. Problem: Alternate Lower Upper String Sort. Solution: */

  /** 492. Problem: Snake case of a given sentence. Solution: */

  /** 493. Problem: Subsequence queries after removing substrings. Solution: */

  /** 494. Problem: Print given sentence into its equivalent ASCII form. Solution: */

  /** 495. Problem: Check whether a given string is Heterogram or not. Solution: */

  /**
   * 496. Problem: Program to print characters present at prime indexes in a given string. Solution:
   */

  /**
   * 497. Problem: Java program to swap first and last characters of words in a sentence. Solution:
   */

  /**
   * 498. Problem: Java program to count the characters in each word in a given sentence. Solution:
   */

  /** 499. Problem: Panalphabetic window in a string. Solution: */

  /** 500. Problem: Longest Common Anagram Subsequence. Solution: */

  /** 501. Problem: Python groupby method to remove all consecutive duplicates. Solution: */

  /**
   * 502. Problem: Generate two output strings depending upon occurrence of character in input
   * string in Python. Solution:
   */

  /**
   * 503. Problem: Program to generate all possible valid IP addresses from given string. Solution:
   */

  /** 504. Problem: Python Dictionary to find mirror characters in a string. Solution: */

  /** 505. Problem: Find the arrangement of queue at given time. Solution: */

  /** 506. Problem: Print a closest string that does not contain adjacent duplicates. Solution: */

  /**
   * 507. Problem: Count subsequences in first string which are anagrams of the second string.
   * Solution:
   */

  /**
   * 508. Problem: Longest sub-string having frequency of each character less than equal to k.
   * Solution:
   */

  /**
   * 509. Problem: Find a string in lexicographic order which is in between given two strings.
   * Solution:
   */

  /**
   * 510. Problem: Find the starting indices of the substrings in string (S) which is made by
   * concatenating all words from a list(L). Solution:
   */

  /** 511. Problem: Minimum number of deletions to make a string palindrome | Set 2. Solution: */

  /**
   * 512. Problem: Print all the palindromic permutations of given string in alphabetic order.
   * Solution:
   */

  /** 513. Problem: Counting k-mers via Suffix Array. Solution: */

  /** 514. Problem: Count number of equal pairs in a string. Solution: */

  /** 515. Problem: Reverse individual words. Solution: */

  /** 516. Problem: Java program to expand a String if range is given?. Solution: */

  /** 517. Problem: Number of substrings with odd decimal value in a binary string. Solution: */

  /** 518. Problem: Remove the forbidden strings. Solution: */

  /** 519. Problem: Missing Permutations in a list. Solution: */

  /**
   * 520. Problem: Check if both halves of the string have at least one different character.
   * Solution:
   */

  /** 521. Problem: K distant string. Solution: */

  /**
   * 522. Problem: Covert string X to an anagram of string Y with minimum replacements. Solution:
   */

  /** 523. Problem: Reduce Hamming distance by swapping two characters. Solution: */

  /**
   * 524. Problem: Check if it is possible to convert one string into another with given
   * constraints. Solution:
   */

  /** 525. Problem: Count of number of given string in 2D character array. Solution: */

  /** 526. Problem: Count consonants in a string (Iterative and recursive methods). Solution: */

  /** 527. Problem: Longest palindrome subsequence with O(n) space. Solution: */

  /** 528. Problem: Generate all the binary number from 0 to n. Solution: */

  /** 529. Problem: Program for length of a string using recursion. Solution: */

  /** 530. Problem: Make a lexicographically smallest palindrome with minimal changes. Solution: */

  /** 531. Problem: Merge two strings in chunks of given size. Solution: */

  /** 532. Problem: Interchanging first and second halves of stings. Solution: */

  /**
   * 533. Problem: Create a new string by alternately combining the characters of two halves of the
   * string in reverse. Solution:
   */

  /** 534. Problem: Counting even decimal value substrings in a binary string. Solution: */

  /** 535. Problem: Lexicographic rank of a string with duplicate characters. Solution: */

  /** 536. Problem: Count maximum-length palindromes in a String. Solution: */

  /** 537. Problem: First uppercase letter in a string (Iterative and Recursive). Solution: */

  /** 538. Problem: Transform the string. Solution: */

  /** 539. Problem: gOOGLE cASE of a given sentence. Solution: */

  /** 540. Problem: Lexicographical concatenation of all substrings of a string. Solution: */

  /**
   * 541. Problem: Maximum difference of zeros and ones in binary string | Set 2 (O(n) time).
   * Solution:
   */

  /** 542. Problem: Splitting a Numeric String. Solution: */

  /** 543. Problem: String from prefix and suffix of given two strings. Solution: */

  /** 544. Problem: Longest Uncommon Subsequence. Solution: */

  /** 545. Problem: Check if it is possible to transform one string to another. Solution: */

  /** 546. Problem: Queries for frequencies of characters in substrings. Solution: */

  /** 547. Problem: Removing row or column wise duplicates from matrix of characters. Solution: */

  /**
   * 548. Problem: Convert the string into palindrome string by changing only one character..
   * Solution:
   */

  /**
   * 549. Problem: Program to build DFA that starts and end with &#8216;a&#8217; from input (a, b).
   * Solution:
   */

  /** 550. Problem: Concatenation of two strings in PHP. Solution: */

  /** 551. Problem: Maximum distinct lowercase alphabets between two uppercase. Solution: */

  /** 552. Problem: Expression contains redundant bracket or not. Solution: */

  /** 553. Problem: LCS formed by consecutive segments of at least length K. Solution: */

  /**
   * 554. Problem: Converting one string to other using append and delete last operations. Solution:
   */

  /** 555. Problem: Longest subsequence where each character occurs at least k times. Solution: */

  /** 556. Problem: Consecutive sequenced numbers in a string. Solution: */

  /**
   * 557. Problem: Convert a sentence into its equivalent mobile numeric keypad sequence. Solution:
   */

  /** 558. Problem: Comparing two strings in C++. Solution: */

  /** 559. Problem: Sum of all subsequences of a number. Solution: */

  /**
   * 560. Problem: Substrings starting with vowel and ending with consonants and vice versa.
   * Solution:
   */

  /** 561. Problem: Time complexity of all permutations of a string. Solution: */

  /**
   * 562. Problem: Print distinct sorted permutations with duplicates allowed in input. Solution:
   */

  /** 563. Problem: Postfix to Infix. Solution: */

  /** 564. Problem: Longest prefix which is also suffix. Solution: */

  /** 565. Problem: Rearrange characters to form palindrome if possible. Solution: */

  /** 566. Problem: Postfix to Prefix Conversion. Solution: */

  /** 567. Problem: Practice questions on Strings. Solution: */

  /** 568. Problem: Prefix to Postfix Conversion. Solution: */

  /** 569. Problem: Prefix to Infix Conversion. Solution: */

  /** 570. Problem: Remove all the palindromic words from the given sentence. Solution: */

  /** 571. Problem: Maximum segment value after putting k breakpoints in a number. Solution: */

  /** 572. Problem: Sparse Search. Solution: */

  /**
   * 573. Problem: Partition given string in such manner that i&#8217;th substring is sum of
   * (i-1)&#8217;th and (i-2)&#8217;th substring. Solution:
   */

  /** 574. Problem: Minimum removal to make palindrome permutation. Solution: */

  /** 575. Problem: Tribonacci Word. Solution: */

  /** 576. Problem: Polybius Square Cipher. Solution: */

  /** 577. Problem: Morse Code Implementation. Solution: */

  /**
   * 578. Problem: Find i&#8217;th Index character in a binary string obtained after n iterations.
   * Solution:
   */

  /** 579. Problem: Closest Palindrome Number (absolute difference Is min). Solution: */

  /** 580. Problem: Find if a string starts and ends with another given string. Solution: */

  /** 581. Problem: Program for length of the longest word in a sentence. Solution: */

  /** 582. Problem: String with maximum number of unique characters. Solution: */

  /** 583. Problem: Sort the given string using character search. Solution: */

  /** 584. Problem: Check if two strings have a common substring. Solution: */

  /** 585. Problem: Product of nodes at k-th level in a tree represented as string. Solution: */

  /** 586. Problem: Count special palindromes in a String. Solution: */

  /** 587. Problem: Evaluate an array expression with numbers, + and &#8211;. Solution: */

  /** 588. Problem: Number of strings of length N with no palindromic sub string. Solution: */
}
