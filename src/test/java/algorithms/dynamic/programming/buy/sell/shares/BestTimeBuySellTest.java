package algorithms.dynamic.programming.buy.sell.shares;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeBuySellTest {

  @Test
  public void maxProfit1() {
    int[] prices = {7, 1, 5, 3, 6, 4};
    assertEquals(5, new BestTimeBuySell().maxProfit1(prices));
  }

  @Test
  public void maxProfit3() {
    int prices[] = {2, 30, 15, 10, 8, 25, 80};
    assertEquals(100, new BestTimeBuySell().maxProfit3(prices));
  }
}