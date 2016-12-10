package algorithms.dynamic.programming.fibonacci;

import org.junit.Test;

public class FibonacciTest {

    @Test
    public void testFib() {
        double t1 = System.currentTimeMillis();
        System.out.println(new Fibonacci().fib(46));
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
