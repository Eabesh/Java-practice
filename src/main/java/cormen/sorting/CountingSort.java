package cormen.sorting;

public class CountingSort {

    void sort(int[] array, int k) {
        int[] hash = new int[k+1];
        for(int elem : array)  hash[elem] ++;
        for (int i = 0; i < hash.length; i++)
            if (hash[i] > 0)
                for (int j = 0; j < hash[i]; j++)
                    System.out.print(i + " ");
    }
}
