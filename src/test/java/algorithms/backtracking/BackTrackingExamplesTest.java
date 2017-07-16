package algorithms.backtracking;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by abhay on 16/07/17.
 */
public class BackTrackingExamplesTest {
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