package algorithms.dynamic.programming.buy.sell.shares;

public class BestTimeBuySell {

  // Best Time to Buy and Sell Stock I

  int maxProfit1(int[] prices) {
    if (prices.length < 2) return 0;
    else {
      int currMin = prices[0];
      int maxProfit = prices[1] - prices[0];
      for (int i = 1; i < prices.length; i++) {
        currMin = Math.min(currMin, prices[i]);
        maxProfit = Math.max(maxProfit, prices[i] - currMin);
      }
      return maxProfit;
    }
  }
  // Best Time to Buy and Sell Stock II k = Infinity

  int maxProfit2(int[] prices) {
    int profit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      int diff = prices[i + 1] - prices[i];
      if (diff > 0)   profit += diff;
    }
    return profit;
  }

  //

  int maxProfit3(int[] prices) {

    if (prices.length < 2) return 0;
    else {
      int[] f = new int[prices.length];
      int[] g = new int[prices.length];

      f = maxProfitFromLeft(prices, f);
      g = maxProfitFromRight(prices, g);

      int profit = 0;
      for (int i = 0; i < prices.length; i++) profit = Math.max(profit, f[i] + g[i]);
      return profit;
    }
  }

  private int[] maxProfitFromLeft(int[] prices, int[] f) {
    int currMin = prices[0];
    for (int i = 1; i < prices.length; i++) {
     currMin = Math.min(currMin, prices[i]);
     f[i] = Math.max(f[i - 1], prices[i] - currMin);
    }
    return f;
  }

  private int[] maxProfitFromRight(int[] prices, int[] g) {
    int currMax = prices[prices.length - 1];
    for (int i = prices.length - 2; i >= 0; i--) {
      currMax = Math.max(currMax, prices[i]);
      g[i] = Math.max(g[i + 1], currMax - prices[i]);
    }
    return g;
  }






}
