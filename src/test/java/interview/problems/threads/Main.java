package interview.problems.threads;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by abhay on 05/01/18.
 */
public class Main {


  static class CountWords {
    int totalWords;
    public CountWords(int totalWords) {
      this.totalWords = totalWords;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    ArrayList<String> file = new ArrayList<>();
    file.add("i am abhay");
    file.add("i know nothing.");
    file.add("i am learning about threads.");
    file.add("This file is about thread pool in java.");

    Runnable[] tasks = new Runnable[file.size()];

    CountWords countWords = new CountWords(0);

    for (int i = 0; i < file.size(); i++) tasks[i] = new SumOfArrayTask(file.get(i), countWords, i + 1);
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    for (int i = 0; i < file.size(); i++) executorService.execute(tasks[i]);

    executorService.shutdown();
    while (!executorService.awaitTermination(24L, TimeUnit.HOURS)) {
      System.out.println("Not yet. Still waiting for termination");
    }
    System.out.println(countWords.totalWords);



  }
}
