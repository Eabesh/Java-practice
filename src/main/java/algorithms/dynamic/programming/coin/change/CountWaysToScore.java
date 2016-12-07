package algorithms.dynamic.programming.coin.change;

class CountWaysToScore {

    /**
     * Problem: Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n,
     * find number of ways to reach the given score.
     *
     * Time Complexity : O(n)
     */
    int count(int[] scores, int n) {
        int[] counts = new int[n+1];
        counts[0]++;
        for(int score : scores) {
            for(int i = score; i <= n; i++ ) {
                counts[i] += counts[i - score];
            }
        }
        return counts[n];
    }

}
