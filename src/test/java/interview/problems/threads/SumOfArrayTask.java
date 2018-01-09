package interview.problems.threads;

/**
 * Created by abhay on 05/01/18.
 */
public class SumOfArrayTask implements Runnable{

  private int count;
  private String line;
  private Main.CountWords countWords;
  private int taskNumber;

  public SumOfArrayTask(String line, Main.CountWords countWords, int taskNumber) {
    this.line = line;
    this.countWords = countWords;
    this.taskNumber = taskNumber;
  }
  @Override
  public void run() {
    try{
      String[] words = line.split("\\s+");
      count += words.length;
      System.out.println(Thread.currentThread() + " count " + count);
//      countWords.wait();
      add();
//      countWords.notify();
      Thread.sleep(5000);

    }catch (InterruptedException e){
      e.printStackTrace();
    }

  }

  public void add()
  {
    countWords.totalWords += count;
  }

//  public synchronized void subtract() {
//
//    countWords.totalWords -= count;
//  }
}



