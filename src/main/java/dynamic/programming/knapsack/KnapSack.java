package dynamic.programming.knapsack;

public class KnapSack {

    int knapSack(int Capacity, int[] weights, int[] value, int n) {
        if (n == 0 || Capacity == 0) return 0;
        else if (weights[n-1] > Capacity) return knapSack(Capacity,weights,value,n-1);
        else return Math.max(value[n-1] + knapSack(Capacity - weights[n-1],weights,value,n-1),knapSack(Capacity,weights,value,n-1));
    }

}
