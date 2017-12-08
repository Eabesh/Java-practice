package interview.problems;

/**
 * Created by abhay on 07/12/17.
 */
public class HackerRank {
  /**
   * TV commercial placement
   * Select a set of TV commercials (each commercial has duration and cost) so that the total revenue is maximal while the total length does not exceed the length of available slot.
   */

  int commercialPlacement(int availableSlot, int[] addDuration, int[] addCost, int n) {
    if (n == 0 || availableSlot == 0) return 0;
    else if (availableSlot < addDuration[n - 1]) return commercialPlacement(availableSlot, addDuration, addCost, n - 1);
    else return Math.max(addCost[n - 1] + commercialPlacement(availableSlot - addDuration[n - 1], addDuration, addCost, n - 1 ), commercialPlacement(availableSlot, addDuration, addCost, n - 1));
  }

  int commercialPlacementDP(int availableSlot, int[] addDuration, int[] addCost, int n) {
    int[][] dp = new int[availableSlot + 1][n + 1];
    for (int slot = 0; slot <= availableSlot; slot++) {
      for (int j = 0; j <= n; j++) {
        if (slot == 0 || j == 0) dp[slot][j] = 0;
        else if (slot < addDuration[j - 1]) dp[slot][j] = dp[slot][j - 1];
        else dp[slot][j] = Math.max(addCost[j - 1] + dp[slot - addDuration[j - 1]][j - 1], dp[slot][j - 1]);
      }
    }
    return dp[availableSlot][n];
  }
}
