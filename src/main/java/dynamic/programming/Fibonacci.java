package dynamic.programming;

import java.util.HashMap;

class Fibonacci {

    HashMap<Integer,Integer> store = new HashMap<Integer, Integer>();

    int fibDP(int n) {
        if (store.containsKey(n)) return store.get(n);
        else if (n < 2) return n;
        else {
            int f = fib(n - 1) + fib(n - 2);
            store.put(n,f);
            return store.get(n);
        }
    }

    int fib(int n) {
        if (n < 2) return n;
        else return fib(n - 1) + fib(n - 2);
    }

    int fibDP2(int n) {
        if (n < 2) return n;
        int[] array = new int[1000];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) array[i] = array[i - 1] + array[i - 2];
        return array[n];
    }

}
