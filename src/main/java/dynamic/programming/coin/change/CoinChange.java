package dynamic.programming.coin.change;

class CoinChange {


    /**
     * Given a value N, if we want to make change for N cents, and we have infinite supply of each of
     * S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
     * Time Complexity : O(mn)
     */
    int change(int[] coins, int sum) {
        int[] minCoins = new int[sum + 1];
        for (int coin : coins) minCoins[coin] = 1;
        for (int i = 1; i < minCoins.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0)
                    min = Math.min(min, 1 + minCoins[i - coin]);
            }
            minCoins[i] = min;
        }
        return minCoins[sum];
    }

}
