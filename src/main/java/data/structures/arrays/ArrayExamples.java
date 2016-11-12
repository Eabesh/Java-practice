package data.structures.arrays;


public class ArrayExamples {

    int maxSum = -1;
    String path = "";

    /**
     * 4. Maximum sum of contigous subarray for a non-empty array.
     */
    public int maxSumContigous(int[] array) {
        int currentMax = array[0];
        int maxSumSofar = array[0];
        for(int i = 1; i < array.length; i++) {
            currentMax = Math.max(array[i], currentMax + array[i]);
            maxSumSofar = Math.max(maxSumSofar,currentMax);
        }
        return maxSumSofar;
    }

    /**
     * Maximum sum of not necessarily contigous array for a non empty array.
     */
    public int maxSumNonContigous(int [] array) {
        int maxSum = 0;
        int leastNeg = Integer.MIN_VALUE;
        int negCount = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] > 0) maxSum += array[i];
            else {
                negCount ++;
                if (array[i] > leastNeg) leastNeg = array[i];
            }
        }
        if (negCount == array.length) return leastNeg;
        else return maxSum;
    }

    /**
     * 13. Maximum sum such that no two elements are adjacent.
     */
    int maxSum(int[] array) {
        sum("",array,0);
//        System.out.println(path.replace(","," "));
        return maxSum;
    }

    private void sum(String soFar, int[] array, int start) {
        if (start >= array.length) {
            if (maxSum < getSum(soFar)) {
                maxSum = getSum(soFar);
                path = soFar;
            }
        }
        else for(int i = start; i < array.length; i++) sum(soFar + "," + array[i], array, i + 2);


    }

    private int getSum(String str) {
        int sum = 0;
        for(String s : str.split(",")) if (!s.isEmpty()) sum += Integer.parseInt(s);
        return sum;
    }

    /**
     *  Linear time algo for above.
     */
    int maxSumLinear(int[] array) {
        int incl = array[0];
        int excl = 0;
        for (int i = 1; i < array.length; i++) {
            int previousIncl = incl;
            incl = excl + array[i];
            excl = Math.max(previousIncl,excl);
        }
        return Math.max(incl,excl);
    }


    /**
     * 23. Maximum difference between two elements such that larger element appears after the smaller element.
     */

    /**
     * 42. Maximum of all subarrays of size k.
     */

    /**
     * 46. Median in a stream of integers (running integers).
     */

    /**
     * 53. Find sub array with given sum
     */

    /**
     * 59. The Celebrity Problem
     */

    /**
     * 60. Longest Bitonic Subsequence
     */

    /**
     * 63. Partition problem.
     */

    /**
     * 67. Maximum Length Chain of Pairs
     */

    /**
     * 77. Find the number of islands using DFS.
     */

    /**
     * 81. Pancake sorting
     */

    /**
     * 83. Tug of War
     */

    /**
     * 84. Maximum Subarray Sum
     */

    /**
     * 88. Stock Buy Sell to Maximize Profit
     */

    /**
     * 97. Stable Marriage Problem
     */

    /**
     * 129. Online algorithm for checking palindrome in a stream
     */

    /**
     *
     */

    /**
     * 136. Trapping Rain Water
     */


}
