package dynamic.programming.coin.change;

import java.util.HashMap;

class CoinChange {


    /**
     * Problem: Given a value N, if we want to make change for N cents, and we have infinite supply of each of
     * S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
     *
     * Time Complexity : O(mn)
     */

    HashMap<Integer,Integer> store = new HashMap<Integer, Integer>();

    int change(int[] coins, int sum) {
        if (sum <= 0 || coins.length < 1) return 0;
        else {
            int min = Integer.MAX_VALUE;
            for (int coin : coins)
                if (coin <= sum)
                    min = Math.min(min, 1 + change(coins, sum - coin));
            return min;
        }
    }

    int changeDPTopDown(int[] coins, int sum) {
        if (store.containsKey(sum)) return store.get(sum);
        else if (sum <= 0 || coins.length < 1) return 0;
        else {
            int min = Integer.MAX_VALUE;
            for (int coin : coins)
                if (coin <= sum)
                    min = Math.min(min, 1 + changeDPTopDown(coins, sum - coin));
            store.put(sum,min);
            return store.get(sum);
        }
    }

    int changeDPBottomUp(int[] coins, int sum) {
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
