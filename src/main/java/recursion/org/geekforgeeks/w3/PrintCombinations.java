package recursion.org.geekforgeeks.w3;

import java.util.Arrays;

/**
 * Print all possible combinations of r elements in a given array of size n
 */
class PrintCombinations {

    void print(int[] array, int r) {
        printCombinations("",array,r);
    }

    private void printCombinations(String soFar, int[] array, int r) {
        if (array.length == 0 || soFar.length() == 2) {
            if (soFar.length() == 2) System.out.println(soFar);
        }
        else {
            printCombinations(soFar + array[0], Arrays.copyOfRange(array,1,array.length),r);
            printCombinations(soFar, Arrays.copyOfRange(array,1,array.length),r);
        }
    }

}
