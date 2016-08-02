package recursion;

class Combinations {

    int C(int n, int k) {
        if (k == 0 || n == k) return 1;
        else return C(n-1,k) + C(n-1,k-1);
    }

}
