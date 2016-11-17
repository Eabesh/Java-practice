package dynamic.programming.palindromes;

public class MaxPalSubstring {

    /**
     * Problem: Given a string, find the longest substring which is palindrome. For example, if the given string is
     * “forgeeksskeegfor”, the output should be “geeksskeeg”.
     *
     * Solution: We maintain a boolean table[n][n] that is filled in bottom up manner. The value of table[i][j] is true,
     * if the substring str[i..j] is palindrome, otherwise false. To calculate table[i][j], we first check the value of
     * table[i+1][j-1], if the value is true and str[i] is same as str[j], then we make table[i][j] true. Otherwise,
     * the value of table[i][j] is made false.
     *
     * Time complexity: O ( n^2 )
     * Auxiliary Space: O ( n^2 )
     */
}
