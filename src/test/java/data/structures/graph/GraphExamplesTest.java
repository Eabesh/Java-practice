package data.structures.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphExamplesTest {
  @Test
  public void findMinSteps() throws Exception {
    int[] source = {1, 2}, dest = {0, 0};
    assertEquals(1, new GraphExamples().findMinSteps( source, dest, 6));
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
