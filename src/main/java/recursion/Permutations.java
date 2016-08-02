package recursion;

import java.util.Vector;

class Permutations {

    Vector<String> permutations = new Vector<String>();

    void permute(String sofar, String remaining) {
        if (remaining.length() == 0) permutations.add(sofar);
        else {
            for(int i = 0; i < remaining.length(); i++) {
                String next = remaining.substring(0,i) + remaining.substring(i+1);
                permute(sofar + remaining.charAt(i),next);
            }
        }
    }

}
