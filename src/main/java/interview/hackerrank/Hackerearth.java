package interview.hackerrank;

import java.util.Scanner;

/**
 * Created by abhay on 03/02/18.
 */
public class Hackerearth {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t > 0) {
      int n = in.nextInt();
      int res = countBeautifulStrings(5, n, 0);
      System.out.println(res);
      t--;
    }
  }

  public static int countBeautifulStrings(int choice, int n, int start) {
    if (n == 0) return 1;
    else {
      int count = 0;
      for (int i = start; i < choice; i++) {
        count += countBeautifulStrings(choice, n - 1, i);
      }
      return count;
    }

  }

}
