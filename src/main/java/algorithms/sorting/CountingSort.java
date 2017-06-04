package algorithms.sorting;

class CountingSort {

  /**
   * Counting sort is an algorithm for sorting a collection of objects according to keys that are small integers;
   * that is, it is an integer sorting algorithm. It operates by counting the number of objects that have each
   * distinct key value, and using arithmetic on those counts to determine the positions of each key value in the
   * output sequence. Its running time is linear in the number of items and the difference between the maximum and
   * minimum key values, so it is only suitable for direct use in situations where the variation in keys is not
   * significantly greater than the number of items.
   * Because counting sort uses key values as indexes into an array, it is not a comparison sort, and the Ω(n log n)
   * lower bound for comparison sorting does not apply to it.
   */
  void sort(int[] array, int k) {
    int[] hash = new int[k+1];
    for(int elem : array) hash[elem]++;
    for (int i = 0; i < hash.length; i++)
      if (hash[i] > 0)
        for (int j = 0; j < hash[i]; j++)
          System.out.print(i + " ");
  }
}
