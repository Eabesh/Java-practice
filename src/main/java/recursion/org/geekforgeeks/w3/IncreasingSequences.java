package recursion.org.geekforgeeks.w3;

class IncreasingSequences {

    void print(int n, int k) { printSequence("", 1, n, k); }

    private void printSequence(String soFar, int start, int end, int length) {
        if (soFar.length() == length) System.out.println(soFar);
        else if (start <= end)
            for (int i = start; i <= end; i++) printSequence(soFar + i, i + 1, end, length);
    }
}
