package sorting.algorithms;

public class PanCakeSort {

    /**
     * Pancake sorting.
     * Given an an unsorted array, sort the given array. You are allowed to do only following operation on array.
     * flip(arr, i): Reverse array from 0 to i
     * Unlike a traditional sorting algorithm, which attempts to sort with the fewest comparisons possible, the goal
     * is to sort the sequence in as few reversals as possible.
     *
     * Solution: Start from current size equal to n and reduce current size by one while it’s greater than 1.
     * Let the current size be curr_size. Do following for every curr_size
     * 1) Find index of the maximum element in arr[0..curr_size-1]. Let the index be ‘mi’
     * b) Call flip(arr, mi)
     * c) Call flip(arr, curr_size-1)
     */

    void panCakeSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int maxIndex = getMax(array, array.length - i);
            flip(array, 0, maxIndex);
            flip(array, 0, array.length - i);
        }
    }

    private int getMax(int[] array, int length) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < length; i++) {
            if (max < array[i]) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void flip(int[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

}
