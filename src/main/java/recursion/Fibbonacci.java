package recursion;

class Fibbonacci {

    int getTerm(int nTerm) {
        if (nTerm <= 1) return nTerm;
        else return getTerm(nTerm - 1) + getTerm(nTerm - 2);
    }

}
