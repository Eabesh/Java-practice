package recursion;

class Exponent {

    private int getExponent(int base, int exp) {
        if (exp == 0) return 1;
        else return base * getExponent(base, exp -1);
    }

    int getExpEfficient(int base, int exp) {
        if (exp == 0) return 1;
        else {
            int halve = getExpEfficient(base,exp/2);
            if (exp % 2 == 0) return halve * halve;
            else return base * halve * halve;
        }
    }

}
