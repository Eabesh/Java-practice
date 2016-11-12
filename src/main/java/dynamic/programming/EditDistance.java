package dynamic.programming;

public class EditDistance {

    int edit(String s1, String s2) {
        int[][] e = new int[s1.length()+1][s2.length()+1];
        for (int l = 1; l <= s1.length(); l++) e[l][0] = l;
        for (int r = 1; r <= s2.length(); r++) e[0][r] = r;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) e[i][j] = e[i-1][j-1];
                else e[i][j] = Math.min(Math.min(1 + e[i-1][j], 1 + e[i][j-1]), 1 + e[i-1][j-1]);
            }
        }
        return e[s1.length()][s2.length()];
    }

}
