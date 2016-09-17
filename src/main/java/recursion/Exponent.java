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

    int a(Exponent that){
        return that.getExponent(2,3);
    }

    int getExponent2(int base, int exp) {
        if (exp == 0) return 1;
        return base * getExponent2(base, exp - 1);
    }

    int getExpEfficient2(int base, int exp) {
        if (exp == 0) return 1;
        if (exp % 2 == 0) {
            int half = getExponent2(base, exp / 2);
            return  half * half;
        }
        else {
            int half = getExponent2(base, exp / 2);
            return base * half * half;
        }
    }

}
