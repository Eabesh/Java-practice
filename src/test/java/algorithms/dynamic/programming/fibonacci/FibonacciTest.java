package algorithms.dynamic.programming.fibonacci;

import org.junit.Test;

public class FibonacciTest {

    @Test
    public void testFib() {

//        System.out.println(new Fibonacci().fib(1));
//        System.out.println(new Fibonacci().fib(2));
//        System.out.println(new Fibonacci().fib(3));
//        System.out.println(new Fibonacci().fib(42));
//        double t1 = System.currentTimeMillis();
//        System.out.println(new Fibonacci().fib(43));
//        System.out.println(new Fibonacci().fib(44));
//        System.out.println(new Fibonacci().fib(45));
      int start = 42, end = 45;
      for (int n = start; n <= end; n++) calculateTime(n);


    }

  void calculateTime(int n) {
      double t1 = System.currentTimeMillis();
    System.out.println(new Fibonacci().fib(n));
    double t2 = System.currentTimeMillis();
    System.out.println("time taken in secs : " + (t2 - t1)/1000);
  }

    @Test
    public void testFibDP() {
        double t1 = System.currentTimeMillis();
        System.out.println(new Fibonacci().fibTopDown(46));
        double t2 = System.currentTimeMillis();
        System.out.println("time taken in secs : " + (t2 - t1)/1000);
    }

    @Test
    public void testFibDP2() {
        double t1 = System.currentTimeMillis();
        System.out.println(new Fibonacci().fibBottomUp(46));
        double t2 = System.currentTimeMillis();
        System.out.println("time taken in secs : " + (t2 - t1)/1000);
    }

}
