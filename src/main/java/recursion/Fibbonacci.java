package recursion;

/**
 * 0th term = 0
 * 1st term = 1
 * F(T) = F(T-1) + F(T-2)
 */
class Fibbonacci {

    public int getTerm(int nTerm) {
        if (nTerm == 0) return 0;
        else if (nTerm == 1) return 1;
        else return getTerm(nTerm - 1) + getTerm(nTerm - 2);
    }

}
