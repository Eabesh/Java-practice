package algorithms.sorting;

class SortingExamples {

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

  void recursiveBSort(int[] array, int length) {
    if (length == 1) return;
    for (int i = 0; i < length - 1; i++) if (array[i] > array[i + 1]) swap(array, i, i + 1);
    recursiveBSort(array, length - 1);
  }

  private void swap(int[] a, int i, int j) {
    if (i != j) {
      a[i] = a[i] ^ a[j];
      a[j] = a[i] ^ a[j];
      a[i] = a[i] ^ a[j];
    }
  }

  /**
   * Insertion sort
   * Complexity: O(n^2)
   */
  int[] insertionSort(int[] array) {
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
   * Time Complexity: O(n+k)
   */
  void countingSort(int[] array, int k) {
    int[] hash = new int[k+1];
    for(int elem : array) hash[elem]++;
    for (int i = 0; i < hash.length; i++)
      if (hash[i] > 0)
        for (int j = 0; j < hash[i]; j++)
          System.out.print(i + " ");
  }

  void countingSort2(int[] array, int k) {
    int[] hash = new int[k + 1];
    for (int elem : array) hash[elem]++;
    for (int i = 1; i < hash.length; i++) hash[i] += hash[i - 1];
    int[] output = new int[array.length];
    for (int elem : array) {
      output[hash[elem] - 1] = elem;
      hash[elem]--;
    }
    System.arraycopy(output, 0, array, 0, array.length);
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

  void recursiveSelectionSort(int[] array, int startIndex) {
    if (startIndex < array.length - 1) {
      swap(array, startIndex, getMinIndex(array, startIndex));
      recursiveSelectionSort(array, startIndex + 1);
    }
  }

  private int getMinIndex(int[] array, int startIndex) {
    int minIndex = startIndex;
    for (int j = startIndex + 1; j < array.length; j++)
      if (array[minIndex] > array[j]) minIndex = j;
    return minIndex;
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
  void panCakeSort(int[] array, int endIndex) {
    if (endIndex > 0) {
      int maxIndex = getMaxIndex(array, endIndex);
      flip(array, 0, maxIndex);
      flip(array, 0, endIndex);
      panCakeSort(array, endIndex - 1);
    }
  }

  private int getMaxIndex(int[] array, int length) {
    int maxIndex = 0;
    for (int i = 1; i <= length; i++)
      if (array[maxIndex] < array[i]) maxIndex = i;
    return maxIndex;
  }

  private void flip(int[] array, int startIndex, int endIndex) {
    if (startIndex < endIndex) {
      swap(array, startIndex, endIndex);
      flip(array, startIndex + 1, endIndex - 1);
    }
  }

  /**
   * Merge sort
   * Complexity: O(nlog(n))
   */
  void mergeSort(int[] array, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(array, start, mid);
      mergeSort(array,mid + 1, end);
      merge(array, start, mid, end);
    }
  }

  private void merge(int[] array, int start, int mid, int end) {
    int leftCount = mid - start + 1;
    int rightCount = end - mid;
    int[] leftArray = new int[leftCount + 1];
    int[] rightArray = new int[rightCount + 1];
    System.arraycopy(array, start, leftArray, 0, leftCount);
    System.arraycopy(array, mid + 1, rightArray, 0, rightCount);
    leftArray[leftCount] = Integer.MAX_VALUE;
    rightArray[rightCount] = Integer.MAX_VALUE;
    int leftPointer = 0;
    int rightPointer = 0;
    for (int i = start; i <= end; i++) {
      if (leftArray[leftPointer] <= rightArray[rightPointer]) {
        array[i] = leftArray[leftPointer];
        leftPointer++;
      } else {
        array[i] = rightArray[rightPointer];
        rightPointer++;
      }
    }
  }

  /**
   * Heap sort
   * Complexity: O(nlog(n))
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

  /**
   * An n-element heap has height floor(logn) and at most ceiling(n/(2^(h+1))) nodes of any height h.
   * So summation of no of nodes from 0 to height x O(h) reduces to linear time O(n).
   */
  private void buildMaxHeap(int[] array, int heapSize) {
    for (int i = heapSize/2 - 1; i >= 0 ; i--) heapify(array, i, heapSize);
  }

  private void heapify(int[] array, int i, int heapSize) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int max = i;
    if (left < heapSize && array[left] > array[max]) max = left;
    if (right < heapSize && array[right] > array[max]) max = right;
    if (array[i] < array[max]) {
      swap(array, i, max);
      heapify(array, max, heapSize);
    }
  }

  private void extractMax(int[] array, int heapSize) {
    swap(array, 0, heapSize - 1);
  }

  /**
   * Quick sort
   * Complexity: O(nlog(n))
   */
  void quickSort(int[] array, int start, int end) {
    if (start < end) {
      int pivot = partition(array, start, end);
      quickSort(array, start, pivot - 1);
      quickSort(array, pivot + 1, end);
    }
  }

  private int partition(int[] array, int start, int end) {
    int pivot = array[end];
    int soFar = start - 1;
    for (int j = start; j < end; j++) {
      if (array[j] <= pivot) {
        soFar++;
        swap(array, soFar, j);
      }
    }
    swap(array, soFar + 1, end);
    return soFar + 1;
  }

}
