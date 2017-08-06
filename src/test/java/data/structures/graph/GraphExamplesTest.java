package data.structures.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphExamplesTest {
  @Test
  public void depthFS() throws Exception {
    int[][] mat = {{1, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 1, 1}, {0, 0, 0, 1}};
    new GraphExamples().depthFS(mat);
  }

  @Test
    public void maxConnectedCellTest() {
        int[][] graph = {{1,0},{0,0}};
        assertEquals(1,new GraphExamples().maxConnectedCell(graph));
    }

}
