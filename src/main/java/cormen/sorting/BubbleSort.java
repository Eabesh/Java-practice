package cormen.sorting;

public class BubbleSort {

    public void sort(int[] array) {
        for(int i = 0; i < array.length;  i++) {
            for(int j = i+1; j < array.length;  j++) {
                if(array[i] > array[j]) swap(array,i,j);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
