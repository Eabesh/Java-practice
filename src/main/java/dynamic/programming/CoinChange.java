package dynamic.programming;

public class CoinChange {

    int change(int[] coins, int sum) {
        int[] minCoins = new int[sum + 1];
        for (int coin : coins) minCoins[coin] = 1;
        for (int i = 1; i < minCoins.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin > 0) min = Math.min(min, minCoins[i - coin]);
            }

        }
    }

}
