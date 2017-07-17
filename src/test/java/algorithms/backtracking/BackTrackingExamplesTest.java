package algorithms.backtracking;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by abhay on 16/07/17.
 */
public class BackTrackingExamplesTest {
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

}