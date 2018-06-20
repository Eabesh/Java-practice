package interview.hackerrank;

import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    int n = 5;
    numberPatternPrint(n);
  }

  public static int[] sortMergedArray(int[] arr1, int[] arr2) {
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    int[] array = new int[arr1.length + arr2.length];
    mergeArrays1(arr1, arr2, 0, 0, array, 0);
    return array;
  }
  static void mergeArrays1(int[] array1, int[] array2, int index1, int index2, int[] array, int index) {

    while (index1 < array1.length && index2 < array2.length) {
      if (array1[index1] < array2[index2]) {
        array[index++] = array1[index1++];
        }
        else array[index++] = array2[index2++];
    }

    while (index1 < array1.length) array[index++] = array1[index1++];
    while (index2 < array2.length) array[index++] = array2[index2++];
  }

  public static void numberPatternPrint(int n) {
    int start = 1;
    for (int i = 1; i <= n; i++) {
      start = print(start, i, (i - 1) % 2);
      System.out.println("");
    }
  }

  private static int print(int start, int digits, int dir) {
    if (dir == 0) {
      String out = "";
      for (int i = 0; i < digits; i++) {
        out = out + start + "*";
        start++;
      }
      System.out.println(out.substring(0, out.length() - 1));
    }
    else {
      String out = "";
      for (int i = digits; i > 0; i--) {
        out = "*" + start + out;
        start++;
      }
      System.out.println(out.substring(1));
    }
    return start;
  }
}
