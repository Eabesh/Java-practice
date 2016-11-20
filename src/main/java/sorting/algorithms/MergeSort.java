package sorting.algorithms;

public class MergeSort {

    void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array,start,mid);
            mergeSort(array,mid+1,end);
            merge(array,start,mid,end);
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
}
