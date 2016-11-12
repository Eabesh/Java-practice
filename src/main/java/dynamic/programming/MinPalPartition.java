package dynamic.programming;

public class MinPalPartition {

    int minPalPartition(String s) {
        if (s.length() == 1) return 0;
        else if (isPalindrome(s)) return 0;
        else {
            int min = Integer.MAX_VALUE;
            for (int k = 1; k <= s.length(); k++) {
                min = Math.min(min, minPalPartition(s.substring(0,k)) + 1 + minPalPartition(s.substring(k,s.length())));
            }
            return min;
        }
    }

    private boolean isPalindrome(String s) {
        return s.length() < 2 || s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1,s.length()-2));
    }

}
