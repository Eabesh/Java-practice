package recursion.org.geekforgeeks.w3;

class IncreasingSequences {

    /**
     * Problem: Print all increasing sequences of length k from first n natural numbers.
     * Given two positive integers n and k, print all increasing sequences of length k such that the elements in every
     * sequence are from first n natural numbers.
     */

    void print(int n, int k) { printSequence("", 1, n, k); }

    private void printSequence(String soFar, int start, int end, int length) {
        if (soFar.length() == length) System.out.println(soFar);
        else if (start <= end)
            for (int i = start; i <= end; i++) printSequence(soFar + i, i + 1, end, length);
    }

}
