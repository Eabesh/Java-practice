package algorithms.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by abhay on 07/07/17.
 */
public class GreedyExamples {


  /**
   * 1.
   * Problem: Applications of Minimum Spanning Tree Problem.
   * Solution:
   */

  /**
   * 2.
   * Problem: Boruvka&s algorithm for Minimum Spanning Tree.
   * Solution:
   */

  /**
   * 3.
   * Problem: Greedy Algorithms | Set 1 (Activity Selection Problem).
   * Solution:
   */

  /**
   * 4.
   * Problem: Greedy Algorithms | Set 2 (Kruskal’s Minimum Spanning Tree Algorithm).
   * Solution:
   */

  /**
   * 5.
   * Problem: Greedy Algorithms | Set 3 (Huffman Coding).
   * Solution:
   */

  /**
   * 6.
   * Problem: Greedy Algorithms | Set 4 (Efficient Huffman Coding for Sorted Input).
   * Solution:
   */

  /**
   * 7.
   * Problem: Greedy Algorithms | Set 5 (Prim’s Minimum Spanning Tree (MST)).
   * Solution:
   */

  /**
   * 8.
   * Problem: Greedy Algorithms | Set 6 (Prim’s MST for Adjacency List Representation).
   * Solution:
   */

  /**
   * 9.
   * Problem: Greedy Algorithms | Set 7 (Dijkstra&#8217;s shortest path algorithm).
   * Solution:
   */

  /**
   * 10.
   * Problem: Greedy Algorithms | Set 8 (Dijkstra’s Algorithm for Adjacency List Representation).
   * Solution:
   */

  /**
   * 11.
   * Problem: Graph Coloring | Set 2 (Greedy Algorithm).
   * Solution:
   */

  /**
   * 12.
   * Problem: Rearrange a string so that all same characters become d distance away.
   * Solution:
   */

  /**
   * 13.
   * Problem: Connect n ropes with minimum cost.
   * Solution:
   */
  int connectRopes(int[] ropes) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int rope : ropes) minHeap.add(rope);
    return minCostToConnect(minHeap, 0);
  }

  private int minCostToConnect(PriorityQueue<Integer> minHeap, int cost) {
    if (minHeap.size() == 1) return cost;
    else {
      int sum = minHeap.remove() + minHeap.remove();
      minHeap.add(sum);
      return minCostToConnect(minHeap, cost + sum);
    }
  }

  /**
   * 14.
   * Problem: Minimum Number of Platforms Required for a Railway/Bus Station.
   * Solution:
   */

  /**
   * 15.
   * Problem: Job Sequencing Problem | Set 1 (Greedy Algorithm).
   * Solution:
   */

  /**
   * 16.
   * Problem: Minimize Cash Flow among a given set of friends who have borrowed money from each other.
   * Solution:
   */

  /**
   * 17.
   * Problem: Greedy Algorithm for Egyptian Fraction.
   * Solution:
   */

  /**
   * 18.
   * Problem: K Centers Problem | Set 1 (Greedy Approximate Algorithm).
   * Solution:
   */

  /**
   * 19.
   * Problem: Set Cover Problem | Set 1 (Greedy Approximate Algorithm).
   * Solution:
   */

  /**
   * 20.
   * Problem: Greedy Algorithms | Set 9 (Boruvka&#8217;s algorithm).
   * Solution:
   */

  /**
   * 21.
   * Problem: Shortest Superstring Problem.
   * Solution:
   */

  /**
   * 22.
   * Problem: Greedy Algorithm to find Minimum number of Coins.
   * Given a value V, if we want to make change for V Rs, and we have infinite supply of each of the denominations  what
   * is the minimum number of coins and/or notes needed to make the change?
   * Solution. It doesn't work for {1, 5, 6, 9}, sum = 11
   */
  int minCoin(int[] denominations, int sum) {
    Arrays.sort(denominations);
    return minCoins(denominations, denominations.length, sum, 0);
  }
  int minCoins(int[] denomination, int m, int sum, int coins) {
    if (sum == 0) return coins;
    else if (m == 0 && sum > 0) return 0;
    else if (denomination[m - 1] > sum) return minCoins(denomination, m - 1, sum, coins);
    else return minCoins(denomination, m, sum - denomination[m - 1], coins + 1);
  }


  /**
   * 23.
   * Problem: Find minimum time to finish all jobs with given constraints.
   * Solution:
   */

  /**
   * 24.
   * Problem: Bin Packing Problem (Minimize number of used Bins).
   * Solution:
   */

  /**
   * 25.
   * Problem: Fractional Knapsack Problem.
   * Solution:
   */

  /**
   * 26.
   * Problem: Dial&#8217;s Algorithm (Optimized Dijkstra for small range weights).
   * Solution:
   */

  /**
   * 27.
   * Problem: Minimize the maximum difference between the heights.
   * Solution:
   */

  /**
   * 28.
   * Problem: Find smallest number with given number of digits and sum of digits.
   * Solution:
   */

  /**
   * 29.
   * Problem: Job Sequencing Problem | Set 2 (Using Disjoint Set).
   * Solution:
   */

  /**
   * 30.
   * Problem: Maximize array sum after K negations | Set 1.
   * Solution:
   */

  /**
   * 31.
   * Problem: Minimum Cost to cut a board into squares.
   * Solution:
   */

  /**
   * 32.
   * Problem: Minimum edges to reverse to make path from a source to a destination.
   * Solution:
   */

  /**
   * 33.
   * Problem: Maximize array sum after K negations | Set 2.
   * Solution:
   */

  /**
   * 34.
   * Problem: Minimum sum of two numbers formed from digits of an array.
   * Solution:
   */

  /**
   * 35.
   * Problem: Find maximum sum possible equal sum of three stacks.
   * Solution:
   */

  /**
   * 36.
   * Problem: Minimize the sum of product of two arrays with permutations allowed.
   * Solution:
   */

  /**
   * 37.
   * Problem: Paper Cut into Minimum Number of Squares.
   * Solution:
   */

  /**
   * 38.
   * Problem: Reverse Delete Algorithm for Minimum Spanning Tree.
   * Solution:
   */

  /**
   * 39.
   * Problem: Max Flow Problem Introduction.
   * Solution:
   */

  /**
   * 40.
   * Problem: Program for Shortest Job First (or SJF) scheduling | Set 1 (Non- preemptive).
   * Solution:
   */

  /**
   * 41.
   * Problem: Lexicographically smallest array after at-most K consecutive swaps.
   * Solution:
   */

  /**
   * 42.
   * Problem: Program for First Fit algorithm in Memory Management.
   * Solution:
   */

  /**
   * 43.
   * Problem: Program for Best Fit algorithm in Memory Management.
   * Solution:
   */

  /**
   * 44.
   * Problem: Program for Worst Fit algorithm in Memory Management.
   * Solution:
   */

  /**
   * 45.
   * Problem: Maximize sum of consecutive differences in a circular array.
   * Solution:
   */

  /**
   * 46.
   * Problem: Rearrange characters in a string such that no two adjacent are same.
   * Solution:
   */

  /**
   * 47.
   * Problem: Minimum sum of absolute difference of pairs of two arrays.
   * Solution:
   */

  /**
   * 48.
   * Problem: Find maximum height pyramid from the given array of objects.
   * Solution:
   */

  /**
   * 49.
   * Problem: Minimum cost for acquiring all coins with k extra coins allowed with every coin.
   * Solution:
   */

  /**
   * 50.
   * Problem: Top 20 Greedy Algorithms Interview Questions.
   * Solution:
   */

  /**
   * 51.
   * Problem: Assign Mice to Holes.
   * Solution:
   */

  /**
   * 52.
   * Problem: Find the minimum and maximum amount to buy all N candies.
   * Solution:
   */

  /**
   * 53.
   * Problem: Huffman Decoding.
   * Solution:
   */

  /**
   * 54.
   * Problem: Program for Page Replacement Algorithms | Set 1 ( LRU).
   * Solution:
   */

  /**
   * 55.
   * Problem: Program for Page Replacement Algorithms | Set 2 (FIFO).
   * Solution:
   */

  /**
   * 56.
   * Problem: Fitting Shelves Problem.
   * Solution: TODO: FIX
   */
  int[] fittingShelves(int wall, int largeShelf, int smallShelf, int[] minValues) {
//    shelfUtil(wall, smallShelf, largeShelf, minValues);
//    shelfUtil(wall, largeShelf, smallShelf, minValues);
//    shelfUtility(wall, smallShelf, largeShelf, 0, minValues);
//    shelfUtility(wall, largeShelf, smallShelf, 0, minValues);
    return minValues;
  }
  private void shelfUtil(int wall, int firstShelf, int secondShelf,int[] minValues) {
    int minFirst = 0;
    while (wall >= firstShelf) {
      minFirst++;
      wall -= firstShelf;
      int minSecond = wall / secondShelf;
      int rem = wall % secondShelf;
      if (rem <= minValues[2]) {
        minValues[0] = minFirst;
        minValues[1] = minSecond;
        minValues[2] = rem;
      }
    }
  }

}
