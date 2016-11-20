package sorting.algorithms;

class HeapSort {

    void heapSort(int[] array) {
        int heapSize = array.length;
        buildMaxHeap(array, heapSize);
        for (int i = 0; i < array.length ; i++) {
            extractMax(array,heapSize);
            heapSize--;
            heapify(array,0,heapSize);
        }
    }

    private void buildMaxHeap(int[] array, int heapSize) {
        for (int i = heapSize/2 - 1; i >= 0 ; i--) {
            heapify(array,i,heapSize);
        }
    }

    private void heapify(int[] array, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < heapSize && array[left] > array[i]) max = left;
        if (right < heapSize && array[right] > array[i]) max = right;
        if (array[i] < array[max]) {
            swap(array, i, max);
            heapify(array, max, heapSize);
        }
    }

    private void extractMax(int[] array, int heapSize) {
        int max = array[heapSize -1];
        array[heapSize - 1] = array[0];
        array[0] = max;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
