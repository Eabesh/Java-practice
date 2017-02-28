package recursion.org.geekforgeeks.w3;

/**
 * Created by abhay on 27/02/17.
 */
public class RecusiveProblems {


    /**
     * 1.
     * Problem: Exponent of a number
     *
     * Solution: base*base^exp - 1
     */

     int getExponent(int base, int exp) {
        if (exp == 0) return 1;
        else return base * getExponent(base, exp - 1);
    }
    // More Efficient
     int getExpEff(int base, int exp) {
        if (exp == 0) return 1;
        else {
            int half = base * getExpEff(base, exp - 1);
            if (exp % 2 == 0) return half * half;
            else return base * half * half;
        }
    }


    /**
     * 2.
     * Problem: Given a string, check whether palindrome or not.
     *
     * Solution:
     */

     boolean isPalindrome(String str) {
        return (str.length() <=1) || str.charAt(0) == str.charAt(str.length() - 1)
                && isPalindrome(str.substring(1, str.length() - 2));
    }

    /**
     * 3.
     * Problem: Factorial of a number
     *
     * Solution:
     */
     int factorial(int num) {
        if (num == 0 || num == 1) return num;
        else return num * factorial(num - 1);
    }

    // Tail recursive

     int factTailRecusive(int num, int acc) {
        if ( num == 0 || num == 1) return acc;
        else return factTailRecusive(num - 1, acc * num);
    }



    /**
     * 4.
     * Problem: Tower of Hanoi
     *
     * Solution:
     */

     void towerOfHanoi(int disk, String source, String dest, String temp){
        if (disk > 0) {
            towerOfHanoi(disk - 1, "A", "C", "B");
            System.out.print(source + " -> " + dest);
            towerOfHanoi(disk - 1, "C", "B", "A");
        }
    }

    /**
     * 5.
     * Problem: Permutation of String
     *
     * Solution:
     */

     void printPermutation(String sofar, String remaining) {
        if (remaining == "") System.out.print(sofar);
        else {
            for (int i = 0; i < remaining.length(); i++)
                printPermutation(sofar + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1));
        }
    }

    /**
     * 6.
     * Problem: Subset of String.
     *
     * Solution:
     */

     void printSubset(String sofar, String remaining) {
        if (remaining == "") System.out.println(sofar);
        else {
            printSubset(sofar + remaining.charAt(0), remaining.substring(1));
            printSubset(sofar, remaining.substring(1));
        }
    }


    /**
     * 7.
     * Problem: Combination
     *
     * Solution:
     */

    int combination(int n, int k) {
        if (n == k || k == 0) return 1;
        else return combination(n - 1, k) + combination(n - 1, k - 1);
    }

    /**
     * 8.
     * Problem: BinarySearch
     *
     * Solution:
     */

    /**
     * 9.
     * Problem: Fibbonacci
     *
     * Solution:
     */

    /**
     * 10.
     * Problem: Reverse a LinkedList
     *
     * Solution:
     */


    /**
     * 11.
     * Problem: Check if a number is Palindrome
     *
     * Solution:
     */


    /**
     * 12.
     * Problem: Print all possible combinations of r elements in a given array of size n
     *
     * Solution:
     */


    /**
     * 13.
     * Problem: Print all possible strings of length k that can be formed from a set of n characters
     *
     * Solution:
     */







    /**
     * 14.
     * Problem: Tail Recursion
     *
     * Solution:
     */


    /**
     * 15.
     * Problem: Print all increasing sequences of length k from first n natural numbers
     *
     * Solution:
     */


    /**
     * 16.
     * Problem: Generate all possible sorted arrays from alternate elements of two given sorted arrays
     *
     * Solution:
     */



    /**
     * 17.
     * Problem: Minimum steps to reach a destination
     *
     * Solution:
     */


    /**
     * 18.
     * Problem: Given a string, print all possible palindromic partitions
     *
     * Solution:
     */


    /**
     * .
     * Problem: Print a pattern without using any loop
     *
     * Solution:
     */


    /**
     * .
     * Problem: Print all non-increasing sequences of sum equal to a given number x
     *
     * Solution:
     */


    /**
     * .
     * Problem: Sort a stack using recursion
     *
     * Solution:
     */


    /**
     * .
     * Problem: Print all n-digit strictly increasing numbers
     *
     * Solution:
     */



    /**
     * .
     * Problem: Find all even length binary sequences with same sum of first and second half bits
     *
     * Solution:
     */



    /**
     * .
     * Problem: Print all possible expressions that evaluate to a target
     *
     * Solution:
     */


    /**
     * .
     * Problem: Print sums of all subsets of a given set
     *
     * Solution:
     */



    /**
     * .
     * Problem: String with additive sequence
     *
     * Solution:
     */



    /**
     * .
     * Problem: Print all longest common sub-sequences in lexicographical order
     *
     * Solution:
     */


    /**
     * .
     * Problem: Program for Chocolate and Wrapper Puzzle
     *
     * Solution:
     */



    /**
     * .
     * Problem: Recursion
     *
     * Solution:
     */



    /**
     * .
     * Problem:  program to implement Collatz Conjecture
     *
     * Solution:
     */


    /**
     * .
     * Problem: Generate all binary strings without consecutive 1’s.
     * Given a integer K. Task is Print All binary string of size K (Given number).
     *
     * Solution:
     */



    /**
     * .
     * Problem: Recursive Bubble Sort
     *
     * Solution:
     */


    public void recusiveBSort(int[] array, int lastIndex) {

        if (lastIndex == 1) return;
        for (int i = 0; i < lastIndex - 1; i++) {
            if (array[i] > array[i + 1]) swap(array, i, i + 1);
        }
        recusiveBSort(array, lastIndex - 1);
    }


    public void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
