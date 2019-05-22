package komal.Threads;

public class ThreadLocalExample implements Runnable {

    int s;
    public ThreadLocalExample(int s){
        this.s=s;

    }

    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return new Integer(10);
        }
    };

    @Override
    public void run(){
        String name = Thread.currentThread().getName();
        System.out.println("thread "+ name +" started");
        System.out.println("start threadlocal is "+name +" - "+ threadLocal.get());

        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        threadLocal.set(s);
        System.out.println("end threadlocal is "+name +" - "+ threadLocal.get());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadLocalExample(1),"t1");
        Thread thread2 = new Thread(new ThreadLocalExample(2),"t2");
        thread.start();
        thread2.start();

    }
}
