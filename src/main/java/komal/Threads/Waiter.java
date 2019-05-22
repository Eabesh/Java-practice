package komal.Threads;

public class Waiter implements Runnable{

    private String lock;

    public Waiter(String lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        String name = Thread.currentThread().getName();
        synchronized (lock){
            try {
                System.out.println("Thread "+name+ " started at "+ System.currentTimeMillis());
                lock.wait();
            }catch (InterruptedException e){
                e.printStackTrace();

            }
            System.out.println("Thread "+name+ " notified at "+ System.currentTimeMillis());
        }

    }
}
