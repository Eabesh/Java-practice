package recursion;

class TowerOfHanoi {

    void solve(int n, char source, char destination, char temporary) {
        if (n > 0) {
            solve(n-1,source,temporary,destination);
            System.out.println(source + " -> " + destination);
            solve(n-1,temporary,destination,source);
        }
    }

}
