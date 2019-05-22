package komal;

import java.util.concurrent.atomic.AtomicInteger;

/*facts - IllegalThreadStateException when we try to start a thread more than 1 time and execute for the last*/
public class ThreadClass extends Thread{
    int count=0;
    public void run(){
        count++;
        System.out.println("count is "+ count);

    }

   /* public static void main(String[] args) {
        *//*ThreadClass threadClass1 = new ThreadClass("1");
        ThreadClass threadClass2 = new ThreadClass();

        threadClass1.run();
        threadClass2.run();*//*
        ThreadExample threadExample = new ThreadExample();
        Thread thread1 = new Thread(threadExample,"1");
        Thread thread2 = new Thread(threadExample,"2");
        thread1.start();
        thread1.start();
        thread1.start();
    }*/

    public static class ThreadExample implements Runnable{
        int count = 0;

        public int getCount() {
            return count;
        }

        @Override
        public void run(){
            for(int i = 0 ;i<5 ; i++) {
                 try {
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                count ++;

               // System.out.println("count is " + i + " "+ Thread.currentThread().getName());
            }
        }
    }

    /*What if we call run() method directly instead start() method?
    *1. Each thread starts in a separate call stack.
    2. Invoking the run() method from main thread,
    the run() method goes onto the current call stack rather than at the beginning of a new call stack.
    3. As you can see in the above program that there is no context-switching because here t1 and t2 will
     be treated as normal object not thread object.*/


    public static void main(String[] args) {
        ThreadExample threadExample = new ThreadExample();
        Thread thread1 = new Thread(threadExample,"1");
        Thread thread2 = new Thread(threadExample,"2");
        Thread thread3 = new ThreadClass();
        Thread thread4 = new ThreadClass();

        thread1.start();
        thread2.start();
       // thread3.start();
       // thread4.start();
        System.out.println("count is "+ threadExample.getCount());
    }


}
