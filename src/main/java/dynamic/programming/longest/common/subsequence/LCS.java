package dynamic.programming.longest.common.subsequence;

public class LCS {

    /**
     * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
     * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
     * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
     * So a string of length n has 2^n different possible subsequences.
     */
    int lcs(String x, String y) {
        if (x.isEmpty() || y.isEmpty()) return 0;
        else if (x.charAt(x.length()-1) == y.charAt(y.length()-1))
            return 1 + lcs(x.substring(0,x.length()-1),y.substring(0,y.length()-1));
        else return Math.max(lcs(x,y.substring(0,y.length()-1)),lcs(x.substring(0,x.length()-1),y));
    }

    int lcsBottomUp(String s1, String s2) {
        int[][] c = new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) c[i][j] = 1 + c[i-1][j-1];
                else c[i][j] = Math.max(c[i-1][j],c[i][j-1]);
            }
        }
        return c[s1.length()][s2.length()];
    }
}
