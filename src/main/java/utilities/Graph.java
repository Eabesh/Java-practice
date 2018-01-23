package utilities;

import java.util.LinkedList;
import java.util.List;

public class Graph {

  private List<List<Integer>> vertex = new LinkedList<>();

  public Graph(int vertices) {
    for (int i = 0; i < vertices; i++) vertex.add(new LinkedList<>());
  }


  public void addEdge(int u, int v) {
    vertex.get(u).add(v);
  }
  public List<List<Integer>> getGraph() {
    return vertex;
  }

}
