package algorithms.greedy;

import java.util.Arrays;

public class FracionalKnapSack {

    /**
     *Given weights and values of n items, we need put these items in a knapsack of capacity W to get the maximum
     * total value in the knapsack.
     * In Fractional Knapsack, we can break items for maximizing the total value of knapsack. This problem in which we
     * can break item also called fractional knapsack problem.
     */

    class Item implements Comparable<Item>{

        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        public int compareTo(Item item) {
            double l = (double)item.value/item.weight;
            double r = (double) this.value/this.weight;
            if (l > r) return -1;
            else if (l < r) return 1;
            else return 0;
        }

    }

    double knapSack(int capacity, Item[] items, int n) {
        Arrays.sort(items);
        double maxValue = 0;
        int currentCapacity = capacity;
        int itemCount = 0;
        for (int i = 0; i < items.length; i++) {
           if (items[i].weight < currentCapacity) {
               maxValue += items[i].value;
               currentCapacity -= items[i].weight;
               itemCount++;
           }
        }
        if (itemCount < items.length) {
            maxValue += (double)items[itemCount].value/items[itemCount].weight * currentCapacity;
        }
        return maxValue;
    }

}
