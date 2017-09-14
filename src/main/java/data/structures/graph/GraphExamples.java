package data.structures.graph;

import algorithms.dynamic.programming.DPExamples;
import data.structures.matrix.MatrixExamples;
import recursion.RecursionExamples;
import utilities.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Stack;

public class GraphExamples {


  /**
   * 1.
   * Problem: Applications of Minimum Spanning Tree Problem.
   * A min weight set of edges that connects all of the vertices.
   */

  /**
   * 2.
   * Problem: Applications of Depth First Search.
   * Solution:
   */

  /**
   * 3.
   * Problem: Boruvka's algorithm for Minimum Spanning Tree.
   * Solution:
   */

  /**
   * 4.
   * Problem: Depth First Traversal or DFS for a Graph.
   * Solution:
   */
  void depthFS(int[][] mat) {
    boolean[] isVisited = new boolean[mat.length];
    for (int i = 0; i < mat.length; i++) if (!isVisited[i]) depthFirstSearch(mat, i, isVisited);
  }

  private void depthFirstSearch(int[][] mat, int i, boolean[] isVisited) {
    isVisited[i] = true;
    System.out.print(i + " ");
    for (int j = 0; j < mat[0].length; j++) if (!isVisited[j] && mat[i][j] == 1) depthFirstSearch(mat, j, isVisited);
  }



}
