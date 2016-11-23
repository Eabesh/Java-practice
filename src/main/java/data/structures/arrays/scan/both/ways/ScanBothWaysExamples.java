package data.structures.arrays.scan.both.ways;

import java.util.Arrays;

public class ScanBothWaysExamples {

    /**
     * 136. Trapping Rain Water
     * Given n non-negative integers representing an elevation map where the width of each bar
     * is 1, compute how much water it is able to trap after raining.
     * For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     */
    int rainWater(int[] array) {
        int[] left = new int[array.length];
        left[0] = array[0];
        for (int i = 1; i < array.length; i++) left[i] = Math.max(left[i-1], array[i]);
        int[] right = new int[array.length];
        right[array.length - 1] = array[array.length - 1];
        for (int i = array.length - 2; i >= 0 ; i--) right[i] = Math.max(right[i+1], array[i]);

        int water = 0;
        for(int i = 0; i < array.length; i++) water += Math.min(left[i], right[i]) - array[i];
        return water;
    }

    /**
     * Candies
     * There are N children standing in a line. Each child is assigned a rating value.
     * You are giving candies to these children subjected to the following requirements:
     * 1. Each child must have at least one candy.
     * 2. Children with a higher rating get more candies than their neighbors.
     */

    int countCandies(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);

        for (int i = 1; i < candies.length; i++)
            if (ratings[i - 1] < ratings[i]) candies[i] = Math.max(candies[i-1] + 1, candies[i]);

        for (int i = ratings.length - 2; i >= 0; i--)
            if (ratings[i] > ratings[i+1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);

        int candyCount = 0;
        for (int i = 0; i < candies.length; i++) candyCount += candies[i];

        return candyCount;
    }

    /**
    * 41.
    * Problem: Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
    *
    * Solution : Create LeftMin and RightMax
    * Compare both array at each index and update maxDiff.
    * 34 1 2 10
    */
    int maxDiff(int[] arr) {
        int maxDiff = -1, x = 0, y = 0;
        int[] leftMin = new int[arr.length];
        int[] rightMax = new int[arr.length];
        leftMin[0] = arr[0];
        for (int i = 1; i < arr.length; i++) leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
        rightMax[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >=0; i--) rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        while (x < arr.length && y < arr.length) {
            if (arr[x] < arr[y]) {
                maxDiff = Math.max(maxDiff, y - x);
                y++;
            }
            else x++;
        }
        return maxDiff;
    }
}
