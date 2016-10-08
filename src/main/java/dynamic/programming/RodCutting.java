package dynamic.programming;

import java.util.HashMap;

class RodCutting {

    HashMap<Integer,Integer> store = new HashMap<Integer, Integer>();
    int rodCut(int[] price, int length) {
        if (length < 1) return 0;
        else {
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= length; i++)
                max = findMax(max, price[i] + rodCut(price,length - i));
            return max;
        }
    }

    private int findMax(int left, int right) { return (left > right) ? left : right; }

    int rodCutDPTopDown(int[] price, int length) {
        if (length < 1) return 0;
        else if (store.containsKey(length)) return store.get(length);
        else {
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= length; i++) max = findMax(max, price[i] + rodCutDPTopDown(price, length - i));
            store.put(length,max);
            return max;
        }
    }

    int rodCutDPBottomUp(int[] price, int length) {
        store.put(0,0);
        if (store.containsKey(length)) return store.get(length);
        for (int i = 1; i<= length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++)
                max = findMax(max, price[j] + store.get(i - j));
            store.put(i,max);
        }
        return store.get(length);
    }

}
