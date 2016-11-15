package dynamic.programming.buy.sell.shares;

import data.structures.arrays.ArrayExamples;

public class MaxProfitShares {

    /**
     * In share trading, a buyer buys shares and sells on future date.
     * Given stock price of n days, the trader is allowed to make at most k transactions,
     * where new transaction can only start after previous transaction is complete,
     * find out maximum profit that a share trader could have made.
     */

    /**
     * If k = 1.
     * If we are allowed to buy and sell only once, then we can use maximum difference between two elements algorithm.
     * Time Complexity : O(n)
     */
    int maxProfitOneTrans(int[] prices) {
        return new ArrayExamples().maxDiff(prices);
    }

    /**
     * If k = 2.
     * Max profit with at most two transactions = MAX {max profit with one transaction and subarray price[0..i] +
     * max profit with one transaction and subarray price[i+1..n-1]  } where i varies from 0 to n-1.
     * Time Complexity : O(n^2).
     * Efficient Solution below :
     */

    /**
     * We can buy and sell any number of times.
     */

    /**
     * Exactly k times.
     * Let profit[t][i] represent maximum profit using at most t transactions up to day i (including day i).
     * Then the relation is: profit[t][i] = max(profit[t][i-1], max(price[i] – price[j] + profit[t-1][j]))
     * for all j in range [0, i-1]
     *
     * profit[t][i] will be maximum of –
     * 1. profit[t][i-1] which represents not doing any transaction on the ith day.
     * 2. Maximum profit gained by selling on ith day. In order to sell shares on ith day,
     * we need to purchase it on any one of [0, i – 1] days. If we buy shares on jth day and sell it on ith day,
     * max profit will be price[i] – price[j] + profit[t-1][j] where j varies from 0 to i-1.
     * Here profit[t-1][j] is best we could have done with one less transaction till jth day.
     * Time Complexity : O(k.n^2).
     */
    int maxProfit(int[] prices, int k) {
        int[][] profit = new int[k+1][prices.length + 1];
        for (int i = 0; i <= k; i++) profit[i][0] = 0;
        for (int j= 0; j <= prices.length; j++) profit[0][j] = 0;
        for (int t = 1; t <= k; t++ ) {
            for (int i = 0; i <= prices.length; i++) {
                int max = Integer.MIN_VALUE;
                for (int j = 0; j <= i; j++) {
                    max = Math.max(max,prices[i] - prices[j] + profit[t-1][j]);
                }
                profit[t][i] = Math.max(max, profit[t][i-1]);
            }
        }
        return profit[k][prices.length - 1];
    }

}
