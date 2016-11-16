package dynamic.programming.longest.common.subsequence;

public class MinCostIdenticalStrings {

    /**
     * Given two strings X and Y, and two values costX and costY. We need to find minimum cost required to make the
     * given two strings identical. We can delete characters from both the strings.
     * The cost of deleting a character from string X is costX and from Y is costY. Cost of removing all characters
     * from a string is same.
     * Minimum Cost to make strings identical = costX * (m - len_LCS) +
     costY * (n - len_LCS).

     m ==> Length of string X
     m ==> Length of string Y
     len_LCS ==> Length of LCS Of X and Y.
     costX ==> Cost of removing a character from X[]
     costY ==> Cost of removing a character from Y[]
     */

    int minCost(int costX, int costY, String s1, String s2) {
        int lcs = new LCS().lcs(s1,s2);
        return costX * (s1.length() - lcs) + costY * (s2.length() - lcs);
    }

}
