package mit.introduction.to.algorithms;

import java.util.Arrays;

class PeakFinder {

    int singleDimension(int[] array) {
        int mid = (array.length - 1) / 2;
        if (mid == 0 || mid == array.length - 1) return mid;
        else if (array[mid - 1] > array[mid]) {
            return singleDimension(Arrays.copyOfRange(array, 0, mid));
        }
        else if (array[mid + 1] > array[mid]) {
            return singleDimension(Arrays.copyOfRange(array,mid + 1, array.length));
        }
        else return mid;
    }

}
