package algorithms.backtracking;

import org.junit.Test;
import sun.swing.BakedArrayList;

import java.util.*;

/**
 * Created by abhay on 16/07/17.
 */
public class BackTrackingExamplesTest {
  @Test
  public void graphColoring() throws Exception {
    int graph[][] = {{0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0},

    };
    String s1 = "I Love";
    s1 += " Java";
    String s2 = "I";
    s2 += " Love Java";

    String s3 = s1.intern();
    String s4 = s2.intern();
//    System.out.println(s3 == s4);
    int[][] graph1 ={{0, 1, 1, 0}, {1, 0, 0, 1},{1, 0, 0, 1}, {0, 1, 1, 0}};
//    boolean result = new BackTrackingExamples().graphColoring(graph, 3);
    boolean result1 = new BackTrackingExamples().graphColoring(graph1, 2);
    System.out.println(result1);

  }

  @Test
  public void palindromicPartitions() throws Exception {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    //    new BackTrackingExamples().palindromicPartitions("aab", result, new ArrayList<>());
    //    for (ArrayList<String> strings : result) System.out.println(strings);
        new BackTrackingExamples().palindromicPartitions2("aba", "");
  }

  @Test
  public void combinationsOfdist() throws Exception {
    int n = 3;
    int[] board = new int[2 * n];
    Arrays.fill(board, Integer.MIN_VALUE);
    new BackTrackingExamples().combinationsOfdist(board, 1, n);
  }

  @Test
  public void findCombinationSum() throws Exception {

    int[] array = {2, 4, 6, 8};
    new BackTrackingExamples().findCombinationSum(array, 8, "", array.length);
  }

  @Test
  public void subSets() throws Exception {
    ArrayList<Integer> set = new ArrayList<>();
    for (int i = 1; i < 3; i++) set.add(i);
    new BackTrackingExamples().subSets(set, "");
  }

  @Test
  public void printPermutation() throws Exception {
    new BackTrackingExamples().printPermutation("", "abc");
  }

  @Test
  public void queenProblem() throws Exception {
    int[][] board = new int[8][8];
    new BackTrackingExamples().queenProblem(board, 8);
  }

  @Test
  public void printAllPaths() throws Exception {
    int[][] mat = { {1, 2, 3}, {4, 5, 6} };
    new BackTrackingExamples().printAllPath(mat, "", 0, 0);
  }

  @Test
  public void printWordBreak() throws Exception {
    Set<String> dictionary = new HashSet<>();
    dictionary.add("i");
    dictionary.add("like");
    dictionary.add("sam");
    dictionary.add("samsung");
    dictionary.add("sung");
    new BackTrackingExamples().printWordBreak("", "ilikesamsung", dictionary);
  }

  @Test
  public void printNQueens() throws Exception {
    int[][] board = new int[4][4];
    new BackTrackingExamples().printNQueens(board, 0);
  }

  @Test
  public void printSubsetSum() throws Exception {
    int[] array = {1, 2, 3};
    new BackTrackingExamples().printSubsetSum(array, 5, "", array.length);
  }

  @Test
  public void solveMaze() throws Exception {
    int[][] board = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
    new BackTrackingExamples().solveMaze(board);

  }

  @Test
  public void combinationSum2() {
    int[] a = {10, 1, 2, 7, 6, 1, 5};
//    List<List<Integer>> result = new BackTrackingExamples().combinationSum2(a, 8);
//    result.forEach(System.out::println);
  }

  @Test
  public void combine() {
    List<List<Integer>> result = new BackTrackingExamples().combine(4, 2);
    result.forEach(System.out::println);
  }

  @Test
  public void letterCombinations() {
    List<String> result = new BackTrackingExamples().letterCombinations("10123");
    result.forEach(System.out::println);
  }

  @Test
  public void subsets() {
    int[] nums = {1,2,3};
    List<List<Integer>> result = new BackTrackingExamples().subsets(nums);
    result.forEach(System.out::println);
  }
}