package algorithms.sorting;

class BubbleSort {

  public void sort(int[] array) {
    for(int i = 0; i < array.length; i++) {
      for(int j = 0; j < array.length - 1 - i;  j++) {
        if(array[j] > array[j+1]) swap(array,j,j+1);
      }
    }
  }

  private void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

}
