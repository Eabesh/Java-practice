package data.structures.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphExamplesTest {
  @Test
  public void hasPath() throws Exception {
    int u = 1, v = 3;
    int[][] mat = {{0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}};
    assertTrue(new GraphExamples().hasPath(mat, u, v));
    assertTrue(new GraphExamples().bfsHasPath(mat, u, v));
  }

  @Test
  public void findMinSteps() throws Exception {
    int[] source = {5, 7}, dest = {15, 20};
    assertEquals(3, new GraphExamples().findMinSteps( source, dest, 20));
  }

  @Test
  public void depthFS() throws Exception {
    int[][] mat = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
    new GraphExamples().depthFS(mat);
  }

  @Test
    public void maxConnectedCellTest() {
        int[][] graph = {{1,0},{0,0}};
        assertEquals(1,new GraphExamples().maxConnectedCell(graph));
    }



}
