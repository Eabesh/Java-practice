package algorithms.dynamic.programming.longest.common.subsequence;

public class KPalindrome {

    /**
     * Given a string, find out if the string is K-Palindrome or not.
     * A k-palindrome string transforms into a palindrome on removing at most k characters from it.
     *
     *
     * If we carefully analyze the problem, the task is to transform the given string into its
     * reverse by removing at most K characters from it. The problem is basically a variation of
     * Edit Distance. We can modify the Edit Distance problem to consider given string and its
     * reverse as input and only operation allowed is deletion. Since given string is compared
     * with its reverse, we will do at most N deletions from first string and N deletions from
     * second string to make them equal. Therefore, for a string to be k-palindrome, 2*N <= 2*K
     * should hold true.
     */

    int edit(String s1, String s2) {
        int[][] e = new int[s1.length()+1][s2.length()+1];
        for (int l = 1; l <= s1.length(); l++) e[l][0] = l;
        for (int r = 1; r <= s2.length(); r++) e[0][r] = r;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) e[i][j] = e[i-1][j-1];
                else e[i][j] = Math.min(1 + e[i-1][j], 1 + e[i][j-1]);
            }
        }
        return e[s1.length()][s2.length()];
    }

    boolean isKPal(String s, int k) {
        return edit(s,reverse(s)) <= 2*k;
    }

    private String reverse(String s) {
        if (s.isEmpty()) return s;
        else {
            String head = s.substring(0, 1);
            return reverse(s.substring(1)) + head;
        }
    }

}
