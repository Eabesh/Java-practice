package dynamic.programming.longest.increasing.subsequence;

import java.util.Arrays;

public class MaxChainLength {

    class Pair implements Comparable<Pair>{

        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair x) {
            return this.a - x.a;
        }

    }

    int maxChain(int[][] pairs) {
        Pair[] p = new Pair[pairs.length];
        for (int i = 0; i < pairs.length; i++) p[i] = new Pair(pairs[i][0],pairs[i][1]);
        int[] lis = new int[pairs.length];
        Arrays.fill(lis,1);
        Arrays.sort(p);
        int maxSoFar = 1;
        for (int k = 1; k < p.length; k++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                if (p[j].b < p[k].a) {
                    max = Math.max(max, lis[j] + 1);
                }
            }
            lis[k] = max;
            maxSoFar = Math.max(maxSoFar, max);
        }
        return maxSoFar;
    }

}
