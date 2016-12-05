package recursion.backtracking;

import java.util.Vector;

class Anagram {

    boolean isAnagram(String soFar, String remaining, Vector<String> dictionary) {
        if (remaining.length() == 0) return dictionary.contains(soFar);
        else {
            for (int i = 0; i < remaining.length(); i++) {
                String next = remaining.substring(0,i) + remaining.substring(i+1);
                if (isAnagram(soFar+remaining.charAt(i), next, dictionary)) return true;
            }
        }
        return false;
    }

}
