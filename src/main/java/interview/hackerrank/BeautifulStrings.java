package interview.hackerrank;

/**
 * Created by abhay on 03/02/18.
 */
public class BeautifulStrings {

  static public void beautifulString(String str, int n, String soFar, int start) {
    if (n == 0) System.out.print(soFar + " ");
    else {
      for (int i = start; i < str.length(); i++) {
        beautifulString(str, n - 1, soFar + str.charAt(i), i);
      }
    }
  }

  static public int countBeautifulString(String str, int n, int start) {
    if (n == 0) return 1;
    else {
      int count = 0;
      for (int i = start; i < str.length(); i++) {
        count += countBeautifulString(str, n - 1, i);
      }
      return count;
    }
  }

  public static void main(String[] args) {
    System.out.println(countBeautifulString("aeiou", 100, 0));
  }
}
