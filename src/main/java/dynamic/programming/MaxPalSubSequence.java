package dynamic.programming;

import java.util.Arrays;

public class MaxPalSubSequence {

    int maxPal(String s) {
        if (s.length() == 1) return 1;
        else if (s.charAt(0) == s.charAt(s.length()-1) && s.length() == 2) return 2;
        else if (s.charAt(0) == s.charAt(s.length()-1)) return 2 + maxPal(s.substring(1,s.length()-1));
        else return Math.max(maxPal(s.substring(1)),maxPal(s.substring(0,s.length()-1)));
    }

    int maxPalTopDown(String s) {
        return 0;
    }

}
