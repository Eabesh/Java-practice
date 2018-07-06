package interview.hackerearth;

import java.util.Scanner;
import javax.xml.bind.SchemaOutputResolver;

public class Test {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    while (t > 0) {
      int size = s.nextInt();
      int K = s.nextInt();
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = s.nextInt();
      }
      System.out.println(findMaxSumLen(array, size, K));
      t--;
    }

  }


  static int findMaxSumLen(int array[], int n, int k) {
    int result = 0;
    int counter;

    int flag;

    for (int start = 0; start < n;) {
      counter = 0;
      flag = 0;

      while (start < n && array[start] <= k) {
        counter++;
        if (array[start] == k)
          flag = 1;
        start++;
      }

      if (flag == 1)
        result += counter;

      while (start < n && array[start] > k)
        start++;
    }
    return result;
  }
}
