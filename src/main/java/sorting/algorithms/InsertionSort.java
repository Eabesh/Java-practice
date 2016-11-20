package sorting.algorithms;

class InsertionSort {

    public int[] sort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int key = array[i];
            int j;
            for (j = i-1; j > -1; j--){
                if (array[j] > key) array[j+1] = array[j];
            }
            array[j+1] = key;
        }
        return array;
    }

}
