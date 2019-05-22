package komal.Threads;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
      //  Lock lock1 = new Lock("msg");
        String mutex = "mutex";
        Thread thread = new Thread(new Waiter(mutex),"w1");

        thread.start();
        //thread.setDaemon(true);
        new Thread(new Waiter(mutex),"w2").start();
        new Thread(new Notifier(mutex),"notifier").start();
    }

    /*public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(3); ints.add(5); ints.add(10);
        double sum = sum(ints);
        System.out.println("Sum of ints="+sum);
    }*/

    public static double sum(List< Integer> list){
        double sum = 0;
        for(Integer n : list){
            sum += n.doubleValue();
        }
        return sum;
    }



}
