package data.structures.graph;

import algorithms.dynamic.programming.DPExamples;
import data.structures.matrix.MatrixExamples;
import recursion.RecursionExamples;
import utilities.*;

import java.util.*;
import java.util.Stack;

public class GraphExamples {

  /**
   * 1. Problem: Applications of Minimum Spanning Tree Problem. A min weight set of edges that
   * connects all of the vertices.
   *
   * Prim’s algorithm,  Kruskal’s algorithm,
   */

  /** 2. Problem: Applications of Depth First Search. Solution: */

  /** 3. Problem: Boruvka's algorithm for Minimum Spanning Tree. Solution: */

  /** 4. Problem: Depth First Traversal or DFS for a Graph. Solution: */
  void depthFS(int[][] mat) {
    boolean[] isVisited = new boolean[mat.length];
    for (int i = 0; i < mat.length; i++) if (!isVisited[i]) depthFirstSearch(mat, i, isVisited);
  }

  private void depthFirstSearch(int[][] mat, int i, boolean[] isVisited) {
    if (!isVisited[i]) {
      isVisited[i] = true;
      System.out.print(i + " ");
      for (int j = 0; j < mat[0].length; j++) if (!isVisited[j] && mat[i][j] == 1) depthFirstSearch(mat, j, isVisited);
    }
  }


  /**
   * 5.
   * Problem: Breadth First Traversal or BFS for a Graph.
   * Solution:
   */
  void bfs(int[][] graph) {
    boolean[] visited = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) if (!visited[i]) breadthFirstSearch(graph, i, visited);
  }

  private void breadthFirstSearch(int[][] graph, int source, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<>();
    visited[source] = true;
    queue.add(source);
    while (!queue.isEmpty()) {
      int node = queue.poll();
      System.out.println(node + " ");
      visited[source] = true;
      for (int i = 0; i < graph[0].length; i++) if (isValidNeighbour(graph, node, i, visited)) queue.add(i);
    }
  }

  /**
   * 6.
   * Problem: Detect Cycle in a Directed Graph.
   */
  boolean hasCycle(int[][] graph) {
    boolean[] visited = new boolean[graph.length];
    boolean[] recStack = new boolean[graph.length];
    for (int node = 0; node < graph.length; node++) if (containCycle(graph, node, visited, recStack)) return true;
    return false;
  }

  private boolean containCycle(int[][] graph, int node, boolean[] visited, boolean[] recStack) {
    visited[node] = true;
    recStack[node] = true;
    for (int v = 0; v < graph[0].length; v++)
      if ((isValidNeighbour(graph, node, v, visited) && containCycle(graph, v, visited, recStack)) || graph[node][v] == 1 && recStack[v])
        return true;
    recStack[node] = false;
    return false;
  }

  /**
   * 7.
   * Problem: Find if there is a path between two vertices in a directed graph.
   */
  boolean hasPath(int[][] mat, int source, int dest) {
    boolean[] isVisited = new boolean[mat.length];
    return dfsHasPath(mat, source, dest, isVisited);
  }

  private boolean dfsHasPath(int[][] mat, int current, int dest, boolean[] isVisited) {
    isVisited[current] = true;
    if (current == dest) return true;
    else {
      for (int i = 0; i < mat[0].length; i++)
        if (isValidNeighbour(mat, current, i, isVisited) && dfsHasPath(mat, i, dest, isVisited)) return true;
    }
    return false;
  }

  boolean bfsHasPath(int[][] mat, int source, int dest) {
    boolean[] isVisited = new boolean[mat.length];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    isVisited[source] = true;
    while (!queue.isEmpty()) {
      int front = queue.poll();
      isVisited[front] = true;
      if (front == dest) return true;
      else
        for (int i = 0; i < mat[0].length; i++) if (!isVisited[i] && mat[front][i] == 1) {

        queue.add(i);
        }
    }
    return false;
  }

  /**
   * 8.
   * Problem: Backtracking | Set 6 (Hamiltonian Cycle).
   */
  public ArrayList hamiltonianCycle(int[][] graph) {
    ArrayList<Integer> path = new ArrayList<>();
    path.add(0);
    return (hamCycle(graph, path, 1)) ? path : null;
  }

  private boolean hamCycle(int[][] graph, ArrayList<Integer> path, int index) {
    if (index == graph.length) if (graph[path.get(index - 1)][path.get(0)] == 1) return true;
    else {
      for (int currNode = 1; currNode < graph.length; currNode++) {
        if (isValidNode(graph, currNode, path)) {
          path.add(currNode);
          if (hamCycle(graph, path, index + 1)) return true;
          path.remove(path.size() - 1);
        }
      }
    }
    return false;
  }

  private boolean isValidNode(int[][] graph, int node, ArrayList<Integer> path) {
    return graph[path.get(path.size() - 1)][node] == 1 && !path.contains(node);
  }

  /**
   * 9.
   * Problem: Dynamic Programming | Set 16 (Floyd Warshall Algorithm).
   * The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem. The problem is to find shortest
   * distances between every pair of vertices in a given edge weighted directed Graph.
   */
  int[][] allPairShortestPath(int[][] graph) {
    int[][] result = new int[graph.length][graph.length];
    for (int i = 0; i < graph.length; i++)
      for (int j = 0; j < graph.length; j++) result[i][j] = graph[i][j];

    for (int k = 0; k < graph.length; k++)
      for (int i = 0; i < graph.length; i++)
        for (int j = 0; j < graph.length; j++)
          if (result[i][k] + result[k][j] < result[i][j]) result[i][j] = result[i][k] + result[k][j];

    return result;
  }

  /**
   * 10.
   * Problem: Find the number of islands | Set 1 (Using DFS).
   * Solution:
   */
  int countIslands(int[][] mat) {
    return new MatrixExamples().countIslands(mat);
  }

  /**
   * 11.
   * Problem: Disjoint Set (Or Union-Find) | Set 1 (Detect Cycle in an Undirected Graph).
   * Solution:
   */

  /**
   * 12.
   * Problem: Union-Find Algorithm | Set 2 (Union By Rank and Path Compression).
   * Solution:
   */

  /**
   * 13.
   * Problem: Greedy Algorithms | Set 2 (Kruskal’s Minimum Spanning Tree Algorithm).
   * Solution:
   */


  /**
   * 14.
   * Problem: Graph and its representations.
   * Solution: Graph is a data structure that consists of following two components:
   * 1. A finite set of vertices also called as nodes.
   * 2. A finite set of ordered pair of the form (u, v) called as edge.
   *
   *
   * Adjacency Matrix:
   * Adjacency Matrix is a 2D array of size V x V where V is the number of vertices in a graph. Let the 2D array be
   * adj[][], a slot adj[i][j] = 1 indicates that there is an edge from vertex i to vertex j.
   *
   *Pros: Representation is easier to implement and follow. Removing an edge takes O(1) time. Queries like whether
   * there is an edge from vertex ‘u’ to vertex ‘v’ are efficient and can be done O(1)
   * Cons: Consumes more space O(V^2). Even if the graph is sparse(contains less number of edges), it consumes the
   * same space. Adding a vertex is O(V^2) time.
   *
   * Adjacency List:
   * An array of linked lists is used. Size of the array is equal to number of vertices. Let the array be array[]. An
   * entry array[i] represents the linked list of vertices adjacent to the ith vertex. This representation can also
   * be used to represent a weighted graph.
   *
   * Pros: Saves space O(|V|+|E|) . In the worst case, there can be C(V, 2) number of edges in a graph thus consuming
   * O(V^2) space. Adding a vertex is easier.
   */


  /**
   * 15.
   * Problem: Greedy Algorithms | Set 5 (Prim’s Minimum Spanning Tree (MST)).
   * Solution:
   */

  /**
   * 16.
   * Problem: Greedy Algorithms | Set 6 (Prim’s MST for Adjacency List Representation).
   * Solution:
   */


  /**
   * 17.
   * Problem: Greedy Algorithms | Set 7 (Dijkstra's shortest path algorithm).
   * Solution:
   */

  /**
   * 18.
   * Problem: Greedy Algorithms | Set 8 (Dijkstra’s Algorithm for Adjacency List Representation).
   * Solution:
   */
  void dijkstraAlgo(DijkstraGraph graph) {

  }

  /**
   * 19.
   * Problem: Dynamic Programming | Set 23 (Bellman–Ford Algorithm).
   * Solution:
   */

  /**
   * 20.
   * Problem: Transitive closure of a graph.
   * Solution:
   */

  /**
   * 21.
   * Problem: Check whether a given graph is Bipartite or not.
   */
  boolean isBipartite(int[][] graph) {
    int[] color = new int[graph.length];
    Arrays.fill(color, -1);
    for (int i = 0; i < graph.length; i++) if (color[i] == -1) if (!bfsBipartite(graph, i, color)) return false;
    return true;
  }

  private boolean bfsBipartite(int[][] graph, int source, int[] color) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    color[source] = 1;
    while (!queue.isEmpty()) {
      int u = queue.poll();
      if (graph[u][u] == 1) return false;
      for (int v = 0; v < graph.length; v++) {
        if (graph[u][v] == 1 && color[v] == -1) {
          color[v] = 1 - color[u];
          queue.add(v);
        } else if (graph[u][v] == 1 && color[v] == color[u]) return false;
      }
    }
    return true;
  }

  /**
   * 22.
   * Problem: Topological Sorting.
   */
  Stack topologicalSort(int[][] graph) {
    Stack<Integer> stack = new Stack();
    boolean[] visited = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) if (!visited[i]) tSort(graph, i, stack, visited);
    return stack;
  }

  private void tSort(int[][] graph, int curr, Stack<Integer> stack, boolean[] visited) {
    visited[curr] = true;
    for (int j = 0; j < graph[0].length; j++)
      if (isValidNeighbour(graph, curr, j, visited)) tSort(graph, j, stack, visited);
    stack.push(curr);
  }

  private boolean isValidNeighbour(int[][] graph, int source, int dest, boolean[] visited) {
    return !visited[dest] && graph[source][dest] == 1;
  }

  /**
   * 23.
   * Problem: Shortest Path in Directed Acyclic Graph.
   * Given a Weighted Directed Acyclic Graph and a source vertex in the graph, find the shortest paths from given source
   * to all other vertices.
   */
  int[] shortestPathDAG(int[][] graph, int[][] weight, int source) {
    int[] distance = new int[graph.length];
    Arrays.fill(distance, Integer.MAX_VALUE);
    Stack<Integer> stack = topologicalSort(graph);
    distance[source] = 0;
    distance = sPaths(graph, weight, stack, distance);
    return distance;
  }

  private int[] sPaths(int[][] graph, int[][] weight, Stack<Integer> stack, int[] distance) {
    while (!stack.isEmpty()) {
      int top = stack.pop();
      if (distance[top] != Integer.MAX_VALUE) {
        for (int v = 0; v < graph.length; v++)
          if (graph[top][v] == 1 && distance[v] > distance[top] + weight[top][v])
            distance[v] = distance[top] + weight[top][v];
      }
    }
    return distance;
  }

  /**
   * 24.
   * Problem: Strongly Connected Components.
   */

  /**
   * 25.
   * Problem: Articulation Points (or Cut Vertices) in a Graph.
   * Solution:
   */

  /**
   * 26.
   * Problem: Bridges in a graph.
   * Solution:
   */

  /**
   * 27.
   * Problem: Bi-connected graph.
   * Solution:
   */

  /**
   * 28.
   * Problem: Check if a graph is strongly connected | Set 1 (Kosaraju using DFS).
   * Solution:
   */

  /**
   * 29.
   * Problem: Eulerian path and circuit for undirected graph.
   * Solution:
   */

  /**
   * 30.
   * Problem: Ford-Fulkerson Algorithm for Maximum Flow Problem.
   * Solution:
   */

  /**
   * 31.
   * Problem: Maximum Bipartite Matching.
   * Solution:
   */

  /**
   * 32.
   * Problem: Find minimum s-t cut in a flow network.
   * Solution:
   */

  /**
   * 33.
   * Problem: Stable Marriage Problem.
   * Given N men and N women, where each person has ranked all members of the opposite sex in order of preference,
   * marry the men and women together such that there are no two people of opposite sex who would both rather have
   * each other than their current partners. If there are no such people, all the marriages are “stable”.
   * Solution: Gale–Shapley algorithm.
   * Initialize all men and women to free
   * while there exist a free man m who still has a woman w to propose to {
   *      w = m's highest ranked such woman to whom he has not yet proposed
   *      if w is free
   *          (m, w) become engaged
   *      else some pair (m', w) already exists
   *          if w prefers m to m'
   *              (m, w) become engaged
   *              and m' becomes free
   *          else
   *              (m', w) remain engaged
   * }
   */

  /**
   * 34.
   * Problem: Fleury's Algorithm for printing Eulerian Path or Circuit.
   * Solution:
   */

  /**
   * 35.
   * Problem: Longest Path in a Directed Acyclic Graph.
   * Solution:
   */

  /**
   * 36.
   * Problem: Find maximum number of edge disjoint paths between two vertices.
   * Solution:
   */

  /**
   * 37.
   * Problem: Detect cycle in an undirected graph.
   */
  boolean isCycleUD(Graph graph) {
    List<List<Integer>> graphList = graph.getGraph();
    boolean[] visited = new boolean[graphList.size()];
    for (int u = 0; u < graphList.size(); u++) if (!visited[u]) if (isCycleUD(graphList, 0, visited, -1)) return true;
    return false;
  }

  private boolean isCycleUD(List<List<Integer>> graphList, int u, boolean[] visited, int parent) {
    visited[u] = true;
    for (Integer v : graphList.get(u)) {
      if (!visited[v]) if (isCycleUD(graphList, v, visited, u)) return true;
      else if (v != parent) return true;
    }
    return false;
  }

  /**
   * 38.
   * Problem: Travelling Salesman Problem | Set 1 (Naive and Dynamic Programming).
   * Solution:
   */

  /**
   * 39.
   * Problem: Travelling Salesman Problem | Set 2 (Approximate using MST).
   * Solution:
   */

  /**
   * 40.
   * Problem: Johnson's algorithm for All-pairs shortest paths.
   * Solution:
   */

  /**
   * 41.
   * Problem: Graph Coloring | Set 1 (Introduction and Applications).
   * Solution:
   * 1) Vertex coloring is the most common graph coloring problem. The problem is, given m colors, find a way of coloring the
   * vertices of a graph such that no two adjacent vertices are colored using same color.
   * 2) Chromatic Number: The smallest number of colors needed to color a graph G is called its chromatic number.
   * Applications of Graph Coloring:
   * 1) Making Schedule or Time Table:
   * 2) Mobile Radio Frequency Assignment:
   * 3) Sudoku:
   * 4) Register Allocation:
   * 5) Bipartite Graphs:
   */

  /**
   * 42.
   * Problem: Graph Coloring | Set 2 (Greedy Algorithm).
   * Solution:
   */

  /**
   * 43.
   * Problem: Some interesting shortest path questions | Set 1.
   * Solution:
   */

  /**
   * 44.
   * Problem: Channel Assignment Problem.
   * Solution:
   */

  /**
   * 45.
   * Problem: Given a sorted dictionary of an alien language, find order of characters.
   * Solution:
   */

  /**
   * 46.
   * Problem: Find if an array of strings can be chained to form a circle | Set 1.
   * Solution:
   */

  /**
   * 47.
   * Problem: Euler Circuit in a Directed Graph.
   * Solution:
   */

  /**
   * 48.
   * Problem: Count all possible walks from a source to a destination with exactly k edges.
   * Solution:
   */
  int countPaths(int[][] graph, int source, int dest, int k) {
    return new DPExamples().countWalks(graph, source, dest, k);
  }

  /**
   * 49.
   * Problem: Shortest path with exactly k edges in a directed and weighted graph.
   * Solution:
   */

  /**
   * 50.
   * Problem: Tarjan's Algorithm to find Strongly Connected Components.
   * Solution:
   */

  /**
   * 51.
   * Problem: Snake and Ladder Problem.
   * Solution:
   */
  class BoardNode {
    int vertex, diceThrow;

    public BoardNode(int v, int d) {
      this.vertex = v;
      this.diceThrow = d;
    }
  }

  int solveSnakeLadder(int[] board) {
    int[] moves = {1, 2, 3, 4, 5, 6};
    boolean[] visited = new boolean[board.length];
    BoardNode source = new BoardNode(0, 0);
    Queue<BoardNode> queue = new LinkedList<>();
    visited[source.vertex] = true;
    queue.add(source);
    while (!queue.isEmpty()) {
      BoardNode u = queue.poll();
      if (u.vertex == board.length - 1) return u.diceThrow;
      else {
        for (int move : moves) {
          int nextMove = u.vertex + move;
          if (isValidBoardMove(board, nextMove, visited)) {
            visited[nextMove] = true;
            if (isSnakeOrLadder(board[nextMove])) queue.add(new BoardNode(board[nextMove], u.diceThrow + 1));
            else queue.add(new BoardNode(nextMove, u.diceThrow + 1));
          }
        }
      }
    }
    return Integer.MIN_VALUE;
  }

  private boolean isValidBoardMove(int[] board, int nextMove, boolean[] visited) {
    return nextMove < board.length && !visited[nextMove];
  }

  private boolean isSnakeOrLadder(int x) {
    return x == -1 ? false : true;
  }

  /**
   * 52.
   * Problem: Check if a given graph is tree or not.
   */
  boolean isTree(Graph graph) {
    List<List<Integer>> graphList = graph.getGraph();
    boolean[] visited = new boolean[graphList.size()];
    if (isCycleUD(graphList, 0, visited, -1)) return false;
    for (int i = 0; i < graphList.size(); i++) if (!visited[i]) return false;
    return true;
  }

  /**
   * 53.
   * Problem: Vertex Cover Problem | Set 1 (Introduction and Approximate Algorithm).
   * Solution:
   */

  /**
   * 54.
   * Problem: Bi-connected Components.
   * Solution:
   */

  /**
   * 55.
   * Problem: Boggle (Find all possible words in a board of characters) | Set 1.
   */
  void findWords(char[][] mat, Set<String> dictionary) {
    boolean[][] visited = new boolean[mat.length][mat[0].length];
    int[][] moves = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    for (int i = 0; i < mat.length; i++)
      for (int j = 0; j < mat[0].length; j++)
        findWord(mat, dictionary, i, j, visited, "", moves);
  }

  private void findWord(char[][] mat, Set<String> dictionary, int x, int y, boolean[][] visited, String soFar, int[][] moves) {
    if (safeNextMove(mat, x,  y, visited)) {
      visited[x][y] = true;
      soFar += mat[x][y];
      if (dictionary.contains(soFar)) System.out.println(soFar);
      for (int[] move : moves) findWord(mat, dictionary, x + move[0], y + move[1], visited, soFar, moves);
      visited[x][y] = false;
    }

  }

  private boolean safeNextMove(char[][] mat, int x, int y, boolean[][] visited) {
    return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && !visited[x][y];
  }

  /**
   * 56.
   * Problem: Minimize Cash Flow among a given set of friends who have borrowed money from each other.
   * Solution:
   */

  /**
   * 57.
   * Problem: Print all paths from a given source to a destination.
   * Given a directed graph, a source vertex ‘s’ and a destination vertex ‘d’, print all paths from given ‘s’ to ‘d’.
   */
  void printPaths(int[][] graph, int source, int dest, String path, boolean[] visited) {
    if (source == dest) System.out.println(path + dest);
    else {
      for (int d = 0; d < graph.length; d++) {
        if (graph[source][d] == 1 && !visited[d]) {
          visited[source] = true;
          printPaths(graph, d, dest, path + source + " ", visited);
          visited[source] = false;
        }
      }
    }
  }

  /**
   * 58.
   * Problem: Optimal read list for given number of days.
   * Solution:
   */

  /**
   * 59.
   * Problem: Applications of Breadth First Traversal.
   * Solution:
   */

  /**
   * 60.
   * Problem: Find the minimum cost to reach destination using a train.
   * Solution:
   */

  /**
   * 61.
   * Problem: K Centers Problem | Set 1 (Greedy Approximate Algorithm).
   * Solution:
   */

  /**
   * 62.
   * Problem: Assign directions to edges so that the directed graph remains acyclic.
   * Solution:
   */

  /**
   * 63.
   * Problem: Greedy Algorithms | Set 9 (Boruvka's algorithm).
   * Solution:
   */

  /**
   * 64.
   * Problem: Karger's algorithm for Minimum Cut | Set 1 (Introduction and Implementation).
   * Solution:
   */

  /**
   * 65.
   * Problem: Connected  Components in an undirected graph.
   * Solution:
   */

  /**
   * 66.
   * Problem: Steiner Tree Problem.
   * Solution:
   */

  /**
   * 67.
   * Problem: Karger’s algorithm for Minimum Cut | Set 2 (Analysis and Applications).
   * Solution:
   */

  /**
   * 68.
   * Problem: Minimum time required to rot all oranges.
   */
  public int rotOranges(int[][] oranges) {
    return new MatrixExamples().rotOranges(oranges);
  }


  /**
   * 69.
   * Problem: Find same contacts in a list of contacts.
   * Solution:
   */

  /**
   * 70.
   * Problem: Word Ladder (Length of shortest chain to reach a target word).
   * Solution:
   */

  /**
   * 71.
   * Problem: Java Program for Dijkstra's Algorithm with Path Printing.
   * Solution:
   */

  /**
   * 72.
   * Problem: Hopcroft–Karp Algorithm for Maximum Matching | Set 1 (Introduction).
   * Solution:
   */

  /**
   * 73.
   * Problem: Hopcroft–Karp Algorithm for Maximum Matching | Set 2 (Implementation).
   * Solution:
   */

  /**
   * 74.
   * Problem: Print all Jumping Numbers smaller than or equal to a given value.
   * Solution:
   */
  void printJumpingNumbers(int num) {
    printSteppingNum(0, num);
  }


  /**
   * 75.
   * Problem: Iterative Depth First Traversal of Graph.
   * Solution:
   */

  /**
   * 76.
   * Problem: Number of Triangles in an Undirected Graph.
   * Solution:
   */

  /**
   * 77.
   * Problem: Number of Triangles in Directed and Undirected Graphs.
   * Solution:
   */
  int numberOfTriangles(int[][] graph, int k, ArrayList<Integer> nodes) {
    if (k == 0 && graph[nodes.get(0)][nodes.get(1)] == 1 && graph[nodes.get(1)][nodes.get(2)] == 1 && graph[nodes.get(2)][nodes.get(0)] == 1)
      return 1;
    else {
      int total = 0;
      for (int i = 0; i < graph.length; i++) {
        nodes.add(i);
        total += numberOfTriangles(graph, k - 1, nodes);
        nodes.remove(nodes.size() - 1);
      }
      return total;
    }
  }

  /**
   * 78.
   * Problem: Transitive Closure of a Graph using DFS.
   * Solution:
   */

  /**
   * 79.
   * Problem: Detect Cycle in a directed graph using colors.
   * Solution:
   */

  /**
   * 80.
   * Problem: Shortest Path in a weighted Graph where weight of an edge is 1 or 2.
   * Solution:
   */

  /**
   * 81.
   * Problem: Printing Paths in Dijkstra's Shortest Path Algorithm.
   * Solution:
   */

  /**
   * 82.
   * Problem: Dijkstra’s shortest path algorithm using set in STL.
   * Solution:
   */

  /**
   * 83.
   * Problem: Dijkstra's Shortest Path Algorithm using priority_queue of STL.
   * Given a graph and a source vertex in graph, find shortest paths from source to all vertices in the given graph.
   */


  /**
   * 84.
   * Problem: Prim's algorithm using priority_queue in STL.
   * Solution:
   */

  /**
   * 85.
   * Problem: All Topological Sorts of a Directed Acyclic Graph.
   * Solution:
   */

  /**
   * 86.
   * Problem: Find k-cores of an undirected graph.
   * Solution:
   */

  /**
   * 87.
   * Problem: Find a Mother Vertex in a Graph.
   */
  int findMotherVertex(int[][] graph) {
    boolean[] visited = new boolean[graph.length];
    int motherVertex = 0;
    for (int i = 0; i < graph.length; i++) {
      if (!visited[i]) {
        depthFirstSearch(graph, i, visited);
        motherVertex = i;
      }
    }
    Arrays.fill(visited, false);
    depthFirstSearch(graph, motherVertex, visited);
    return areVisitedAll(visited) ? motherVertex : -1;
  }

  private boolean areVisitedAll(boolean[] visited) {
    for (int i = 0; i < visited.length; i++) if (!visited[i]) return false;
    return true;
  }


  /**
   * 88.
   * Problem: Push Relabel Algorithm | Set 1 (Introduction and Illustration).
   * Solution:
   */

  /**
   * 89.
   * Problem: Kahn's algorithm for Topological Sorting.
   * Solution:
   */

  /**
   * 90.
   * Problem: Push Relabel Algorithm | Set 2 (Implementation).
   * Solution:
   */

  /**
   * 91.
   * Problem: Dial's Algorithm (Optimized Dijkstra for small range weights).
   * Solution:
   */

  /**
   * 92.
   * Problem: Find if there is a path of more than k length from a source.
   */
  public boolean isKLengthPath(int[][] graph, int[][] weight, int source, int k) {
    boolean[] visited = new boolean[graph.length];
    visited[source] = true;
    return isKLengthPath1(graph, weight, k, source, 0, visited);
  }

  private boolean isKLengthPath1(int[][] graph, int[][] weight, int k, int source, int sum, boolean[] visited) {
    if (k <= sum) return true;
    else {
      for (int node = 0; node < graph.length; node++) {
        if (graph[source][node] == 1 && !visited[node]) {
          visited[node] = true;
          if (isKLengthPath1(graph, weight, k, node, sum + weight[source][node], visited)) return true;
          visited[node] = false;
        }
      }
      return false;
    }
  }

  /**
   * 93.
   * Problem: Kruskal's Minimum Spanning Tree using STL in C++.
   * Solution:
   */

  /**
   * 94.
   * Problem: Iterative Deepening Search(IDS) or Iterative Deepening Depth First Search(IDDFS).
   * Solution:
   */

  /**
   * 95.
   * Problem: A matrix probability question.
   * Solution:
   */

  /**
   * 96.
   * Problem: Check if two nodes are on same path in a tree.
   */
  boolean areNodesInSamePath(int[][] graph, int u, int v) {
    int[] inTime = new int[graph.length];
    int[] outTime = new int[graph.length];
    boolean[] visited = new boolean[graph.length];
    int[] currentTime = {};
    dfsWithTime(graph, 0, inTime, outTime, visited, currentTime);
    return query(u, v, inTime, outTime);
  }

  private boolean query(int u, int v, int[] inTime, int[] outTime) {
    return inTime[u] < inTime[v] && outTime[u] < outTime[v] || inTime[v] < inTime[u] && outTime[v] < outTime[u];
  }

  private void dfsWithTime(int[][] graph, int source, int[] inTime, int[] outTime, boolean[] visited, int[] currentTime) {
    inTime[source] = ++currentTime[0];
    visited[source] = true;
    for (int node = 0; node < graph.length; node++)
      if (isValidNeighbour(graph, source, node, visited))
        dfsWithTime(graph, node, inTime, outTime, visited, currentTime);
    outTime[source] = ++currentTime[0];
  }

  /**
   * 97.
   * Problem: Find the number of Islands | Set 2 (Using Disjoint Set).
   * Solution:
   */

  /**
   * 98.
   * Problem: Finding minimum vertex cover size of a graph using binary search.
   * Solution:
   */

  /**
   * 99.
   * Problem: Topological Sort of a graph using departure time of vertex.
   * Solution:
   */

  /**
   * 100.
   * Problem: Find Shortest diceThrow from a guard in a Bank.
   * Given a matrix that is filled with ‘O’, ‘G’, and ‘W’ where ‘O’ represents open space, ‘G’ represents guards and ‘W’
   * represents walls in a Bank. Replace all of the O’s in the matrix with their shortest diceThrow from a guard, without
   * being able to go through any walls. Also, replace the guards with 0 and walls with -1 in output matrix.
   */
  int[][] findDistance(char[][] mat) {
    int[][] output = new int[mat.length][mat[0].length];
    Queue<BFSNode> queue = new LinkedList<>();
    for (int[] row : output) Arrays.fill(row, -1);

    for (int i = 0; i < mat.length; i++)
      for (int j = 0; j < mat[0].length; j++)
        if (mat[i][j] == 'G') {
          queue.add(new BFSNode(i, j, 0));
          output[i][j] = 0;
        }
    return bfsGuard(mat, output, queue);

  }

  private int[][] bfsGuard(char[][] mat, int[][] output, Queue<BFSNode> queue) {
    int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    while (!queue.isEmpty()) {
      BFSNode front = queue.poll();
      for (int[] move : moves) {
        int x = front.x + move[0], y = front.y + move[1];
        if (isSafeMove(mat, output, x, y)) {
          output[x][y] = front.distance + 1;
          queue.add(new BFSNode(x, y, front.distance + 1));
        }
      }
    }
    return output;
  }

  private boolean isSafeMove(char[][] mat, int[][] output, int x, int y) {
    return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && output[x][y] == -1 && mat[x][y] == 'O';
  }

  /**
   * 101.
   * Problem: Longest Path in a Directed Acyclic Graph | Set 2.
   * Solution:
   */

  /**
   * 102.
   * Problem: Clone an Undirected Graph.
   * Solution:
   */

  /**
   * 103.
   * Problem: Stepping Numbers.
   * Given two integers ‘n’ and ‘m’, find all the stepping numbers in range [n, m]. A number is called stepping number if
   * all adjacent digits have an absolute difference of 1. 321 is a Stepping Number while 421 is not.
   */
  void printSteppingNum(int n, int m) {
    new RecursionExamples().printSteppingNumbers(n, m);
  }

  /**
   * 104.
   * Problem: Find all reachable nodes from every node present in a given set.
   * Solution:
   */

  /**
   * 105.
   * Problem: Roots of a tree which give minimum height.
   * Solution:
   */

  /**
   * 106.
   * Problem: Longest path between any pair of vertices.
   * Solution:
   */

  /**
   * 107.
   * Problem: Check whether given degrees of vertices represent a Graph or Tree.
   * Solution:
   */

  /**
   * 108.
   * Problem: Find the smallest binary digit multiple of given number.
   * Solution:
   */

  /**
   * 109.
   * Problem: Minimum steps to reach end of array under constraints.
   * Solution:
   */

  /**
   * 110.
   * Problem: Maximum edges that can be added to DAG so that is remains DAG.
   * Solution:
   */

  /**
   * 111.
   * Problem: Minimum edges to reverse to make path from a source to a destination.
   * Solution:
   */

  /**
   * 112.
   * Problem: Minimum number of operation required to convert number x into y.
   * Given a initial number x and two operations which are given below:
   * Multiply number by 2. Subtract 1 from the number.
   * The task is to find out minimum number of operation required to convert number x into y using only above two operations.
   * We can apply these operations any number of times
   */
  int minOperationToXY(int x, int y) {
    Queue<BFSElement> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    visited.add(x);
    queue.add(new BFSElement(x, 0));

    while (!queue.isEmpty()) {
      BFSElement front = queue.poll();
      if (front.getVal() == y) return front.getDistance();
      else if (x > 1000) return -1;
      else {
        int first = front.getVal() * 2;
        int second = front.getVal() - 1;
        if (visited.add(first)) queue.add(new BFSElement(first, front.getDistance() + 1));
        if (second > 0 && visited.add(second)) queue.add(new BFSElement(second, front.getDistance() + 1));

      }
    }
    return -1;
  }

  /**
   * 113.
   * Problem: Find if an array of strings can be chained to form a circle | Set 2.
   * Solution:
   */

  /**
   * 114.
   * Problem: Minimum Cost Path with Left, Right, Bottom and Up moves allowed.
   */


  /**
   * 115.
   * Problem: Minimum Product Spanning Tree.
   * Solution:
   */

  /**
   * 116.
   * Problem: Two Clique Problem (Check if Graph can be divided in two Cliques).
   * Solution:
   */

  /**
   * 117.
   * Problem: Check loop in array according to given constraints.
   * Solution:
   */

  /**
   * 118.
   * Problem: k&#8217;th heaviest adjacent node in a graph where each vertex has weight.
   * Solution:
   */

  /**
   * 119.
   * Problem: Graph implementation using STL for competitive programming | Set 1 (DFS of Unweighted and Undirected).
   * Solution:
   */

  /**
   * 120.
   * Problem: Graph implementation using STL for competitive programming | Set 2 (Weighted graph).
   * Solution:
   */

  /**
   * 121.
   * Problem: Hierholzer&#8217;s Algorithm for directed graph.
   * Solution:
   */

  /**
   * 122.
   * Problem: Chinese Postman or Route Inspection | Set 1 (introduction).
   * Solution:
   */

  /**
   * 123.
   * Problem: Total number of Spanning Trees in a Graph.
   * Solution:
   */

  /**
   * 124.
   * Problem: Check if removing a given edge disconnects a graph.
   * Solution:
   */

  /**
   * 125.
   * Problem: Reverse Delete Algorithm for Minimum Spanning Tree.
   * Solution:
   */

  /**
   * 126.
   * Problem: Minimum steps to reach target by a Knight.
   * Solution: To find shortest diceThrow. We use bfs.
   */
  class Cell {
    int x, y, distance;

    Cell(int x, int y, int dis) {
      this.x = x;
      this.y = y;
      this.distance = dis;
    }
  }

  int findMinSteps(int[] source, int[] dest, int size) {
    boolean[][] isVisited = new boolean[size + 1][size + 1];
    isVisited[source[0]][source[1]] = true;
    int[][] moves = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}};
    Queue<Cell> queue = new LinkedList<>();
    queue.add(new Cell(source[0], source[1], 0));
    while (!queue.isEmpty()) {
      Cell front = queue.poll();
      isVisited[front.x][front.y] = true;
      if (dest[0] == front.x && dest[1] == front.y) return front.distance;
      else {
        for (int[] move : moves) {
          int x = front.x + move[0];
          int y = front.y + move[1];
          if (isSafe(x, y, isVisited, size)) queue.add(new Cell(x, y, front.distance + 1));
        }
      }
    }
    return Integer.MIN_VALUE;
  }

  private boolean isSafe(int x, int y, boolean[][] isVisited, int size) {
    return x >= 1 && x <= size && y >= 1 && y <= size && !isVisited[x][y];
  }

  /**
   * 127.
   * Problem: Max Flow Problem Introduction.
   * Solution:
   */

  /**
   * 128.
   * Problem: Check if a given directed graph is strongly connected | Set 2 (Kosaraju using BFS).
   * Solution:
   */

  /**
   * 129.
   * Problem: Dinic&#8217;s algorithm for Maximum Flow.
   * Solution:
   */

  /**
   * 130.
   * Problem: Find the minimum number of moves needed to move from one cell of matrix to another.
   * Given a N X N matrix (M) filled with 1 , 0 , 2 , 3 . Find the minimum numbers of moves needed to move from source to
   * destination (sink) . while traversing through blank cells only. You can traverse up, down, right and left.
   * A value of cell 1 means Source. A value of cell 2 means Destination. A value of cell 3 means Blank cell.
   * A value of cell 0 means Blank Wall.
   */


  /**
   * 131.
   * Problem: Find minimum weight cycle in an undirected graph.
   * Solution:
   */

  /**
   * 132.
   * Problem: Count number of edges in an undirected graph.
   * Solution:
   */
  int countEdgesUDG(Graph graph) {
    return sumOfDependencies(graph) / 2;
  }

  /**
   * 133.
   * Problem: Sum of dependencies in a graph.
   */
  int sumOfDependencies(Graph graph) {
    int sum = 0;
    List<List<Integer>> g = graph.getGraph();
    for (List<Integer> list : g) sum += list.size();
    return sum;
  }

  /**
   * 134.
   * Problem: Find length of the largest region in Boolean Matrix.
   * Consider a matrix with rows and columns, where each cell contains either a ‘0’ or a ‘1’ and any cell containing a 1
   * is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically,
   * or diagonally .If one or more filled cells are also connected, they form a region. find the length of the largest region.
   */
  int findLargestRegion(int[][] mat) {
    boolean[][] visited = new boolean[mat.length][mat[0].length];
    int maxLength = Integer.MIN_VALUE;
    int[][] moves = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    for (int i = 0; i < mat.length; i++)
      for (int j = 0; j < mat[0].length; j++)
        if (mat[i][j] == 1 && !visited[i][j]) maxLength = Math.max(maxLength, dfsLR(mat, i, j, visited, moves));
    return maxLength;
  }

  private int dfsLR(int[][] mat, int x, int y, boolean[][] visited, int[][] moves) {
    if (!isValidMove(mat, x, y, visited)) return 0;
    else {
      visited[x][y] = true;
      int res = 1;
      for (int[] move : moves) res += dfsLR(mat, x + move[0], y + move[1], visited, moves);
      return res;
    }
  }

  boolean isValidMove(int[][] grid, int x, int y, boolean[][] isVisited) {
    return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !isVisited[x][y]);
  }

  /**
   * 135.
   * Problem: Delete Edge to minimize subtree sum difference.
   * Solution:
   */

  /**
   * 136.
   * Problem: Maximum product of two non-intersecting paths in a tree.
   * Solution:
   */

  /**
   * 137.
   * Problem: Number of pair of positions in matrix which are not accessible.
   * Solution:
   */

  /**
   * 138.
   * Problem: Generate a graph using Dictionary in Python.
   * Solution:
   */

  /**
   * 139.
   * Problem: NetworkX : Python software package for study of complex networks.
   * Solution:
   */

  /**
   * 140.
   * Problem: 0-1 BFS (Shortest Path in a Binary Weight Graph).
   * Solution:
   */

  /**
   * 141.
   * Problem: Largest subset of Graph vertices with edges of 2 or more colors.
   * Solution:
   */

  /**
   * 142.
   * Problem: Top 10 Interview Questions on Depth First Search (DFS).
   * Solution:
   */

  /**
   * 143.
   * Problem: Best First Search (Informed Search).
   * Solution:
   */

  /**
   * 144.
   * Problem: Number of sink nodes in a graph.
   * Solution:
   */

  /**
   * 145.
   * Problem: Minimum edges required to add to make Euler Circuit.
   * Solution:
   */

  /**
   * 146.
   * Problem: Move weighting scale alternate under given constraints.
   * Solution:
   */

  /**
   * 147.
   * Problem: BFS for Disconnected Graph.
   */
  void bfsDG(int[][] graph) {
    bfs(graph);
  }

  /**
   * 148.
   * Problem: Karp 's minimum mean (or average) weight cycle algorithm.
   * Solution:
   */

  /**
   * 149.
   * Problem: Minimum edge reversals to make a root.
   * Solution:
   */

  /**
   * 150.
   * Problem: Dynamic Connectivity | Set 1 (Incremental).
   * Solution:
   */

  /**
   * 151.
   * Problem: Determine whether a universal sink exists in a directed graph.
   * Solution:
   */

  /**
   * 152.
   * Problem: Bidirectional Search.
   * Solution:
   */

  /**
   * 153.
   * Problem: Count nodes within K-diceThrow from all nodes in a set.
   * Solution:
   */

  /**
   * 154.
   * Problem: Minimum number of edges between two vertices of a Graph.
   */
  int minEdgeBFS(int[][] graph, int source, int dest) {
    boolean[] visited = new boolean[graph.length];
    int[] distance = new int[graph.length];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    visited[source] = true;
    while (!queue.isEmpty()) {
      int currentNode = queue.poll();
      if (currentNode == dest) return distance[dest];
      else {
        for (int i = 0; i < graph[0].length; i++) {
          if (isValidNeighbour(graph, currentNode, i, visited)) {
            queue.add(i);
            distance[i] = distance[currentNode] + 1;
            visited[i] = true;
          }
        }
      }
    }
    return Integer.MIN_VALUE;
  }

  /**
   * 155.
   * Problem: Clone a Directed Acyclic Graph.
   * Solution:
   */

  /**
   * 156.
   * Problem: 2-Satisfiability (2-SAT) Problem.
   * Solution:
   */

  /**
   * 157.
   * Problem: Calculate number of nodes between two vertices in an acyclic Graph by Disjoint Union method.
   * Solution:
   */

  /**
   * 158.
   * Problem: Print all paths from a given source to a destination using BFS.
   * Solution:
   */
  /**
   * 159.
   * Problem: Clustering Coefficient in Graph Theory.
   * Solution:
   */

  /**
   * 160.
   * Problem: Implementation of Graph in JavaScript.
   * Solution:
   */

  /**
   * 161.
   * Problem: Check if a graphs has a cycle of odd length.
   * Solution:
   */
  /**
   * 162.
   * Problem: Check if there is a cycle with odd weight sum in an undirected graph.
   * Solution:
   */
  /**
   * 163.
   * Problem: A Peterson Graph Problem.
   * Solution:
   */
  /**
   * 164.
   * Problem: Maximum number of edges to be added to a tree so that it stays a Bipartite graph.
   * Solution:
   */
  /**
   * 165.
   * Problem: DFS for a n-ary tree (acyclic graph) represented as adjacency list.
   * Solution:
   */
  /**
   * 166.
   * Problem: Count single node isolated sub-graphs in a disconnected graph.
   * Solution:
   */

  /**
   * 167.
   * Problem: Detect a negative cycle in a Graph | (Bellman Ford).
   * Solution:
   */
  /**
   * 168.
   * Problem: Detecting negative cycle using Floyd Warshall.
   * Solution:
   */
  /**
   * 169.
   * Problem: Clone a Directed Acyclic Graph.
   * Solution:
   */


  /**
   * 170.
   * Problem: Minimum cost to connect weighted nodes represented as array.
   * Solution:
   */
  /**
   * 171.
   * Problem: Cycles of length n in an undirected and connected graph.

   * Solution:
   */
  /**
   * 172.
   * Problem: Comparison of Dijkstra’s and Floyd–Warshall algorithms.
   * Solution:
   */


  /**
   * 173.
   * Problem: BFS using STL for competitive coding.
   * Solution:
   */

  /**
   * 174.
   * Problem: Number of groups formed in a graph of friends.
   * Solution:
   */

  /**
   * 175.
   * Problem: Graph representations using set and hash.
   * Solution:
   */

  /**
   * 176.
   * Problem: Betweenness Centrality (Centrality Measure)
   .
   * Solution:
   */

  /**
   * 177.
   * Problem: Mathematics | Graph theory practice questions
   .
   * Solution:
   */

  /**
   * 178.
   * Problem: Number of cyclic elements in an array where we can jump according to value.
   * Solution:
   */

  /**
   * 179.
   * Problem: Water Jug problem using BFS.
   * Solution:  For the water jug problem, the following production rules are sufficient:
   * 1. (x, y) -> (a, y) if x < a i.e., Fill the first jug if it is not already full
   * 2. (x, y) -> (x, b) if y < b i.e., Fill the second jug if it is not already full
   * 3. (x, y) -> (0, y) if x > 0 i.e., Empty the first jug
   * 4. (x, y) -> (x, 0) if y > 0 i.e, Empty the second jug
   * 5. (x, y) -> (min(x + y, a), max(0, x + y – a)) if y > 0 i.e., Pour from second jug into first jug until the
   * first jug is full or the second jug is empty
   * 6. (x, y) -> (max(0, x + y – b), min(x + y, b)) if x > 0 i.e., Pour from first jug into second jug until the
   * second jug is full or the first jug is empty
   */

  void waterJugProblem(int x, int y, int jug1Capacity, int jug2Capacity, int targetX, int targetY, String path, Set<String> set) {
    if (x == targetX && y == targetY) System.out.println(path);
    else {
      if (!set.contains(String.valueOf(x) + String.valueOf(y))) {
        set.add(String.valueOf(x) + String.valueOf(y));
        if (x < jug1Capacity)
          waterJugProblem(jug1Capacity, y, jug1Capacity, jug2Capacity, targetX, targetY, path + jug1Capacity + "," + y + " ", set);
        if (y < jug1Capacity)
          waterJugProblem(x, jug2Capacity, jug1Capacity, jug2Capacity, targetX, targetY, path + x + "," + jug2Capacity + " ", set);
        if (x > 0) waterJugProblem(0, y, jug1Capacity, jug2Capacity, targetX, targetY, path + 0 + "," + y + " ", set);
        if (y > 0) waterJugProblem(x, 0, jug1Capacity, jug2Capacity, targetX, targetY, path + x + "," + 0 + " ", set);
        if (x > 0) {
          int nextX = Math.max(0, x + y - jug2Capacity);
          int nextY = Math.min(x + y, jug2Capacity);
          waterJugProblem(nextX, nextY, jug1Capacity, jug2Capacity, targetX, targetY, path + nextX + "," + nextY + " ", set);
        }
        if (y > 0) {
          int nextX = Math.min(x + y, jug1Capacity);
          int nextY = Math.max(0, x + y - jug1Capacity);
          waterJugProblem(nextX, nextY, jug1Capacity, jug2Capacity, targetX, targetY, path + nextX + "," + nextY + " ", set);
        }
      }

    }
  }

  /**
   * 180.
   * Problem: Degree Centrality (Centrality Measure)
   .
   * Solution:
   */

  /**
   * 181.
   * Problem: Traveling Salesman Problem (TSP) Implementation.
   * Solution:
   */

  /**
   * 182.
   * Problem: Shortest path to reach one prime to other by changing single digit at a time.
   * Solution:
   */

  /**
   * 183.
   * Problem: Minimum initial vertices to traverse whole matrix with given conditions.
   * Solution:
   */

  /**
   * 184.
   * Problem: Count all possible paths between two vertices.
   * Count the total number of ways or paths that exist between two vertices in a directed graph.
   */

  public int countPathsDG(int[][] graph, int source, int dest, boolean[] visited) { ;
    if (source == dest) return 1;
    else if (visited[source]) return 0;
    else {
      int count = 0;
      for (int i = 0; i < graph[0].length; i++) {
        if (isNeigbour(graph, source, i)) {
          visited[source] = true;
          count += countPathsDG(graph, i, dest, visited);
          visited[source] = false;
        }
      }
      return count;
    }
  }

  private boolean isNeigbour(int[][] graph, int u, int v) {
    return graph[u][v] == 1;
  }

  /**
   * 185.
   * Problem: Construct a graph from given degrees of all vertices.
   * Solution:
   */


  /**
   * 186.
   * Problem: Union-Find Algorithm | (Union By Rank and Find by Optimized Path Compression).
   * Solution:
   */


  /**
   * 187.
   * Problem: Katz Centrality (Centrality Measure).
   * Solution:
   */


  /**
   * 188.
   * Problem: Barabasi Albert Graph (for Scale Free Models).
   * Solution:
   */


  /**
   * 189.
   * Problem: Level of Each node in a Tree from source node (using BFS).
   */
  void printLevelOfEachNode(int[][] graph, int source) {
    int[] level = new int[graph.length];
    boolean[] isVisited = new boolean[graph.length];
    Queue<Integer> queue = new LinkedList<>();
    isVisited[source] = true;
    queue.add(source);
    while (!queue.isEmpty()) {
      int current = queue.poll();
      System.out.println(current + " At Level " + level[current]);
      for (int i = 0; i < graph[0].length; i++) {
        if (isValidNeighbour(graph, current, i, isVisited)) {
          isVisited[i] = true;
          queue.add(i);
          level[i] = level[current] + 1;
        }
      }
    }

  }

  /**
   * 190.
   * Problem: Count the number of non-reachable nodes.
   * Solution:
   */
  int countNonReachable(int[][] graph, int source) {
    boolean[] isVisited = new boolean[graph.length];
    countDFS(graph, source, isVisited);
    int count = 0;
    for (boolean visited : isVisited) if (!visited) count++;
    return count;
  }

  private void countDFS(int[][] graph, int source, boolean[] isVisited) {
    isVisited[source] = true;
    for (int i = 0; i < graph[0].length; i++)
      if (isValidNeighbour(graph, source, i, isVisited)) countDFS(graph, i, isVisited);
  }


  /**
   * Given a matrix of 0's and 1's find the count of biggest area covered by adjacent 1's.
   * Hint: We can use DFS here.
   */
  int maxConnectedCell(int[][] grid) {
    int m = grid.length;
    int n = grid.length;
    boolean[][] isVisited = new boolean[m][n];
    int[][] moves = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    int max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!isVisited[i][j] && grid[i][j] == 1) {
          max = Math.max(max, dfs2(grid, i, j, isVisited, moves));
        }
      }
    }
    return max;
  }


  int dfs2(int[][] grid, int x, int y, boolean[][] isVisited, int[][] moves) {
    if (!isValidMove(grid, x, y, isVisited)) return 0;
    else {
      int count = 0;
      isVisited[x][y] = true;
      for (int[] move : moves) {
        int nextX = x + move[0];
        int nextY = y + move[1];
        count += dfs2(grid, nextX, nextY, isVisited, moves);
      }
      return 1 + count;
    }

  }

  int dfs(int[][] grid, int x, int y, boolean[][] isVisited) {
    if (!isValidMove(grid, x, y, isVisited)) return 0;
    else {
      isVisited[x][y] = true;
      return 1 +
              dfs(grid, x, y + 1, isVisited) +
              dfs(grid, x, y - 1, isVisited) +
              dfs(grid, x + 1, y, isVisited) +
              dfs(grid, x - 1, y, isVisited) +
              dfs(grid, x + 1, y + 1, isVisited) +
              dfs(grid, x + 1, y - 1, isVisited) +
              dfs(grid, x - 1, y + 1, isVisited) +
              dfs(grid, x - 1, y - 1, isVisited);
    }
  }


  int countWynk(char[][] mat, String pat) {
    boolean[][] visited = new boolean[mat.length][mat[0].length];
    int res = 0;
    int[][] moves = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 'W') res += dfsWynk(mat, i, j, pat, visited, moves);
      }
    }
    return res;
  }

  private int dfsWynk(char[][] mat, int x, int y, String pat, boolean[][] visited, int[][] moves) {
    if (pat.length() == 1 && pat.charAt(0) == mat[x][y]) return 1;
    else {
      int count = 0;
      for (int[] move : moves) {
        int nextX = x + move[0];
        int nextY = y + move[1];
        if (isSafeWynk(mat, nextX, nextY, pat.substring(1), visited)) {
          visited[nextX][nextY] = true;
          int[][] newMoves = {{move[0], move[1]}};
          count += dfsWynk(mat, nextX, nextY, pat.substring(1), visited, newMoves);
          visited[nextX][nextY] = false;
        }
      }
      return count;
    }
  }

  private boolean isSafeWynk(char[][] mat, int x, int y, String pat, boolean[][] visited) {
    return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && !visited[x][y] && pat.charAt(0) == mat[x][y];
  }

}
