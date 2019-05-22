package komal.Threads;

public class Notifier implements Runnable {
    private String lock;

    public Notifier(String lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        String name = Thread.currentThread().getName();
        System.out.println("Notifier "+ name + " started");
        try {
            Thread.sleep(100);
            synchronized (lock) {
                lock.notifyAll();
                System.out.println("Notifier done");
            }
        }catch (InterruptedException e){

         }
    }


}
