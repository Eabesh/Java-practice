package utilities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by abhay on 08/09/17.
 */
public class DijkstraGraph {
  class GraphNode {
    int weight, v;
    GraphNode(int v, int w) {
      this.v = v;
      this.weight = w;
    }
  }
  private List<List<GraphNode>> vertex = new LinkedList<>();
  public DijkstraGraph(int vertices) {
    for (int i = 0; i < vertices; i++) vertex.add(new LinkedList<>());
  }

  public void addEdge(int u, int v, int weight) {
    GraphNode newNode = new GraphNode(v, weight);
    vertex.get(u).add(newNode);
  }

  public List<List<GraphNode>> getGraph() {
    return vertex;
  }
}
