package interview.hackerrank;

public class output {
  public static void main(String args[])
  {
    function(3);
  }

  static  void function(int n)
  {
    if(n == 1) return;

    for(int i = 1 ; i <= n ; i++)
      for(int j = 1 ; j <= n ; j++)
        System.out.print("* + j " );

    function(n-1);
  }
}