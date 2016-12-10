package algorithms.dynamic.programming.palindromes;

import java.util.Arrays;

public class MaxPalSubSequence {

    /**
     * Given a sequence, find the length of the longest palindromic subsequence in it.
     * For example, if the given sequence is “BBABCBCAB”,
     * then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it.
     * “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
     */
    int maxPal(String s) {
         if (s.length() <= 1) return s.length();
        else if (s.charAt(0) == s.charAt(s.length()-1)) return 2 + maxPal(s.substring(1,s.length()-1));
        else return Math.max(maxPal(s.substring(1)),maxPal(s.substring(0,s.length()-1)));
    }

    int maxPalTopDown(String s) {
        return 0;
    }

}
