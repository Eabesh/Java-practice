package dynamic.programming.longest.common.subsequence;

public class SortedLCS {

    /**
     * You are given two strings.Now you have to print all longest common sub-sequences in lexicographical order.
     */

    int[][] d;

    int lcs(String s1, String s2) {
        int[][] c = new int[s1.length()+1][s2.length()+1];
        d = new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    c[i][j] = 1 + c[i-1][j-1];
                    d[i][j] = 0;
                }
                else {
                    if (c[i-1][j] > c[i][j-1]) {
                        c[i][j] = c[i-1][j];
                        d[i][j] = -1;
                    }
                    else if (c[i-1][j] < c[i][j-1]) {
                        c[i][j] = c[i][j-1];
                        d[i][j] = 1;
                    }
                    else {
                        c[i][j] = c[i][j-1];
                        d[i][j] = 2;
                    }
                }
            }
        }
        return c[s1.length()][s2.length()];
    }

    void printAllLCS(String path, int i, int j, String s1, String s2) {
        if (i > d.length || j > d[0].length) {
            System.out.println(path);
        }
        else if (d[i][j] == 0) printAllLCS(path + s1.charAt(i-1),i+1,j+1,s1,s2);
        else if (d[i][j] == 1) printAllLCS(path,i,j+1,s1,s2);
        else if (d[i][j] == 0) printAllLCS(path + s1.charAt(i-1),i+1,j+1,s1,s2);
        else if (d[i][j] == 0) printAllLCS(path + s1.charAt(i-1),i+1,j+1,s1,s2);
    }

}
