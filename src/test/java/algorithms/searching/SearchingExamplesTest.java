package algorithms.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javafx.concurrent.Worker;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchingExamplesTest {
  SearchingExamples searchingExamples = new SearchingExamples();
  @Test
  public void findMinElement() throws Exception {
    int[] array = {5, 6, 1, 2, 3, 4};
    assertEquals(2, new SearchingExamples().findMinElement(array,0, array.length - 1));
  }

  @Test
  public void findMissingNumber() throws Exception {
    int[] list = {1,2,3,5};
    assertEquals(4, new SearchingExamples().findMissingNumber(list, 5));
    int[] list2 = {1,2,3,5,6};
    assertEquals(4, new SearchingExamples().findMissingNumber(list2, 6));
  }

  @Test
  public void frequency() {
    int arr[] = {1, 2, 2, 3, 3, 3, 3};
    assertEquals(4, new SearchingExamples().frequency(arr, 3));
  }

  @Test
  public void rotatedBinarySearch() {
    int[] array = {4, 5, 6, 1, 2, 3};
    assertEquals(1, searchingExamples.rotatedBinarySearch(array, 5));
  }

  @Test
  public void sortRotatedArray() {
    int[] array = {4, 5, 6, 1, 2, 3};
    int[] array1 = {2, 3, 4, 1};
    Arrays.stream(searchingExamples.sortRotatedArray(array)).forEach(x -> System.out.print(x + " "));
    Arrays.stream(searchingExamples.sortRotatedArray(array1)).forEach(x -> System.out.print(x + " "));
  }

  @Test
  public void findPairRotatedArray() {
    int arr[] = {11, 15, 6, 8, 9, 10};
    int sum = 16;
    searchingExamples.findPairRotatedArray(arr, sum);
  }

  @Test
  public void countElementBetween() {
    int arr[] = { 3, 5, 7, 6, 4, 9, 12, 4, 8 };
    int num1 = 5, num2 = 4;
    assertEquals(5, searchingExamples.countElementBetween(arr, num1, num2));
  }

  @Test
  public void uncommonElements() {
    int arr1[] = {10, 20, 30};
    int arr2[] = {40, 50};
    ArrayList<Integer> result = searchingExamples.uncommonElements(arr1, arr2);
    result.forEach(x -> System.out.print(x + " "));
  }

  @Test
  public void findTriplets() {
    int arr[] = { 2, 6, 9, 12, 17, 22, 31, 32, 35, 42 };
    searchingExamples.findTriplets(arr);
  }

  @Test
  public void printTriplets() {
    int arr[] = {0, -1, 2, -3, 1};
    searchingExamples.printTriplets(arr);
  }

  @Test
  public void findTriplet() {
    int[] arr = {5, 32, 1, 7, 10, 50, 19, 21, 2};
    searchingExamples.findTriplet(arr);
  }

  class MyTask {
    private int [] array;
    int start, end;
    private Callable<Integer> task = () ->  searchingExamples.maxElement(array, start, end);

    public MyTask(int[] array, int start, int end) {
      this.array = array;
      this.start = start;
      this.end = end;
    }
}
    @Test
    public void maxElement() throws ExecutionException, InterruptedException {
      int[] array = {1, 5, 7, 10, 12, 14, 15, 18, 20, 22, 25, 27, 64, 110, 220};

      ArrayList<Callable<Integer>> tasks = new ArrayList<>();
      int range = 2;
      int start = 0, end = 0;
      for (int i = start; i < array.length && end < array.length ; i++) {
         start = i * range;
          end  = start + range;
        tasks.add(new MyTask(array, start, end).task);
      }

      ExecutorService executorService = Executors.newFixedThreadPool(3);

      ArrayList<Integer> result = new ArrayList<>();
      for (Callable<Integer> task : tasks) {
        Future<Integer> future = executorService.submit(task);
        result.add(future.get());
      }
      System.out.println(Collections.max(result));
      result.forEach(x -> System.out.println(x));
    }






  @Test
  public void LinearSearchMT() throws ExecutionException, InterruptedException {
    int array [] = { 1, 5, 7, 10, 12, 14, 15, 18, 20,
        22, 25, 27, 30, 64, 110, 220 };
    int x = 20;
    ArrayList<Callable<Integer>> tasks = new ArrayList<>();
    int range = 2;
    int start = 0, end = 0;
    for (int i = start; i < array.length && end < array.length ; i++) {
      start = i * range;
      end  = start + range;
      tasks.add(new SearchingExamples().new LinearSearchTask(array, start, end, x).task);
    }

    ExecutorService executorService = Executors.newFixedThreadPool(3);
    ArrayList<Integer> result = new ArrayList<>();
    for (Callable<Integer> task : tasks) {
      Future<Integer> future = executorService.submit(task);
      result.add(future.get());
    }
    System.out.println(result.stream().mapToInt(v -> v).max().getAsInt());

  }
  }


