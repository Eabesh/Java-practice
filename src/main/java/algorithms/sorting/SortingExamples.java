package algorithms.sorting;

public class SortingExamples {

  /**
   * Bubble sort
   * Complexity: O(n^2)
   */
  void bubbleSort(int[] array) {
    for(int i = 0; i < array.length - 1; i++) {
      for(int j = 0; j < array.length - 1 - i; j++)
        if(array[j] > array[j + 1]) swap(array, j, j + 1);
    }
  }

  private void swap(int[] a, int i, int j) {
    a[i] = a[i] ^ a[j];
    a[j] = a[i] ^ a[j];
    a[i] = a[i] ^ a[j];
  }

  /**
   * Insertion sort
   * Complexity: O(n^2)
   */
  public int[] insertionSort(int[] array) {
    for(int i = 1; i < array.length; i++) {
      int key = array[i];
      int j = i - 1;
      while (j >= 0 && array[j] > key) {
        array[j+1] = array[j];
        j--;
      }
      array[j+1] = key;
    }
    return array;
  }

  /**
   * Counting sort
   * It is an algorithm for sorting a collection of objects according to keys that are small integers;
   * that is, it is an integer sorting algorithm. It operates by counting the number of objects that have each
   * distinct key value, and using arithmetic on those counts to determine the positions of each key value in the
   * output sequence. Its running time is linear in the number of items and the difference between the maximum and
   * minimum key values, so it is only suitable for direct use in situations where the variation in keys is not
   * significantly greater than the number of items.
   * Because counting sort uses key values as indexes into an array, it is not a comparison sort, and the Ω(n log n)
   * lower bound for comparison sorting does not apply to it.
   */
  void countingSort(int[] array, int k) {
    int[] hash = new int[k+1];
    for(int elem : array) hash[elem]++;
    for (int i = 0; i < hash.length; i++)
      if (hash[i] > 0)
        for (int j = 0; j < hash[i]; j++)
          System.out.print(i + " ");
  }

  /**
   * Selection sort
   * Step 1 − Set MIN to location 0
   * Step 2 − Search the minimum element in the list
   * Step 3 − Swap with value at location MIN
   * Step 4 − Increment MIN to point to next element
   * Step 5 − Repeat until list is sorted
   * Complexity: O(n^2)
   */
  void selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++)
        if (array[minIndex] > array[j]) minIndex = j;
      swap(array, i, minIndex);
    }
  }

  /**
   * Pancake sorting.
   * Given an an unsorted array, sort the given array. You are allowed to do only following operation on array.
   * flip(arr, i): Reverse array from 0 to i
   * Unlike a traditional sorting algorithm, which attempts to sort with the fewest comparisons possible, the goal
   * is to sort the sequence in as few reversals as possible.
   * Solution: Start from current size equal to n and reduce current size by one while it’s greater than 1.
   * Let the current size be curr_size. Do following for every curr_size
   * 1) Find index of the maximum element in arr[0..curr_size-1]. Let the index be ‘mi’
   * b) Call flip(arr, mi)
   * c) Call flip(arr, curr_size-1)
   */
  void panCakeSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int maxIndex = getMaxIndex(array, array.length - i);
      flip(array, 0, maxIndex);
      flip(array, 0, array.length - i);
    }
  }

  private int getMaxIndex(int[] array, int length) {
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

  /**
   * Merge sort
   * Complexity: nlog(n)
   */
  void mergeSort(int[] array, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(array, start, mid);
      mergeSort(array,mid + 1, end);
      merge(array, start, mid, end);
    }
  }

  void merge(int[] array, int start, int mid, int end) {
    int[] temp = new int[array.length];
    for(int i = 0; i < array.length; i++)
      temp[i] = array[i];

    int left = start;
    int right = mid + 1;
    int index = 0;
    while (left <= mid && right <= end) {
      if (temp[left] <= temp[right]) {
        array[index] = temp[left];
        left++;
      }
      else {
        array[index] = temp[right];
        right++;
      }
      index++;
    }
    if(left <= mid) {
      copy(temp,array,left,mid,index);
    }
    if(right <= end) {
      copy(temp,array,right,end,index);
    }
  }

  void copy(int[] array, int[] sorted, int s, int e, int index) {
    while (s <= e) {
      sorted[index] = array[s];
      s++;
      index++;
    }
  }

  /**
   * Heap sort
   * Complexity: nlog(n)
   */
  void heapSort(int[] array) {
    int heapSize = array.length;
    buildMaxHeap(array, heapSize);
    for (int i = 0; i < array.length; i++) {
      extractMax(array, heapSize);
      heapSize--;
      heapify(array,0, heapSize);
    }
  }

  private void buildMaxHeap(int[] array, int heapSize) {
    for (int i = heapSize/2 - 1; i >= 0 ; i--) heapify(array, i, heapSize);
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

  /**
   * Quick sort
   * Complexity: nlog(n)
   */
  public void quickSort(int[] array, int start, int end) {
    if (start < end) {
      int pivot = partition(array, start, end);
      quickSort(array, start, pivot - 1);
      quickSort(array, pivot + 1, end);
    }
  }

  private int partition(int[] array, int start, int end) {
    int x = array[end];
    int i = start - 1;
    for (int j = 0; j < end; j++) {
      if (array[j] <= x) {
        i++;
        swap(array, i, j);
      }
    swap(array, i + 1, end);
    }
    return i + 1;
  }

}
