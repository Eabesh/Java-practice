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
        if (sum <= 0) return 0;
        else {
            int min = Integer.MAX_VALUE;
            for (int coin : coins)
                if (coin <= sum)
                    min = Math.min(min, 1 + change(coins, sum - coin));
            return min;
        }
    }

    int changeDPTopDown(int[] coins, int sum) {
        store.put(0,0);
        if (store.containsKey(sum)) return store.get(sum);
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
        for (int s = 1; s <= sum; s++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= s)
                    min = Math.min(min, minCoins[s-coin] != Integer.MAX_VALUE ? 1 + minCoins[s - coin] : Integer.MAX_VALUE);
            }
            minCoins[s] = min;
        }
        return minCoins[sum];
    }

}
