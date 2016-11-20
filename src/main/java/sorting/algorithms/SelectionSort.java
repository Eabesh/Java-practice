package sorting.algorithms;

public class SelectionSort {

    /**
     * Step 1 − Set MIN to location 0
     * Step 2 − Search the minimum element in the list
     * Step 3 − Swap with value at location MIN
     * Step 4 − Increment MIN to point to next element
     * Step 5 − Repeat until list is sorted
     */
    void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) minIndex = j;
            }
            swap(array, i, minIndex);
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
