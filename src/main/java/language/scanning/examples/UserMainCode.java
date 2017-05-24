package language.scanning.examples;

import java.util.Scanner;

public class UserMainCode {

  public static String GetSubString(String input1, String input2) {
    int start = -1;
    int end = 0;
    for(int i = 0; i < input1.length(); i++) {
      end = i;
      int j = i;
      while(!input2.isEmpty() && j < input1.length()) {
        if(input2.contains("" + input1.charAt(i))) {
          if (start <  0) start = i;
          input2 = input2.substring(0,input2.indexOf(input1.charAt(i)))
                  + input2.substring(input2.indexOf(input1.charAt(i)) + 1);
          end++;
        }
        j++;
      }
    }
    return input1.substring(start,end-1);
    //throw new UnsupportedOperationException("GetSubString(String input1,String input2)");
  }

  int a = 20;
  static int b = 10;

  static void m1() {
    UserMainCode u = new UserMainCode();
    System.out.println(u.a);
    final int x;
    x = 0;
  }

  public static int flip(int element) {
    return (element == 1) ? 0: 1;
  }

  public static int findMaxSub(int[] array) {
    int currMax = 1;
    int maxSoFar = 1;
    int previous = array[0];
    for (int i = 1; i < array.length; i++) {
      if(array[i] == flip(previous)) currMax++;
      else currMax = 1;
      maxSoFar = Math.max(maxSoFar, currMax);
      previous = array[i];
    }
    return maxSoFar;
  }

  public static void main(String args[]) {
    double a = 25.000;
    a = a%10;
    String s1 = "Its Great";
    String s2 = "Its Tricky";
    System.out.println(s1.concat(s2).length() + " ");
    System.out.println(s1.concat(s2.substring(1,s1.length())).length() + " ");
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int[] array = new int[n];
    for (int i = 0; i < k ; i++) {
      int index = in.nextInt();
      array[index - 1] = 1;
      System.out.println(findMaxSub(array));
    }
  }

}
