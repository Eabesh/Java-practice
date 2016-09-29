package recursion.org.geekforgeeks.w3;

import java.util.HashSet;

/**
 * Print all possible strings of length k that can be formed from a set of n characters
 */
class PrintString {

    void print(HashSet<Character> set, int k) { printString("",set,k); }

    private void printString(String soFar, HashSet<Character> set, int k) {
        if (soFar.length() == k) System.out.println(soFar);
        else for(Character c : set) printString(soFar + c, set, k);
    }

}
