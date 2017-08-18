package data.structures.graph;

import data.structures.matrix.MatrixExamples;
import utilities.Graph;

import java.lang.reflect.Array;
import java.util.*;

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
    for (int i = 0; i < mat.length; i++)
      if (!isVisited[i]) depthFirstSearch(mat, i, isVisited);
  }

  void depthFirstSearch(int[][] mat, int i, boolean[] isVisited) {
    isVisited[i] = true;
    System.out.print(i + " ");
    for (int j = 0; j < mat[0].length; j++) if (!isVisited[j] && mat[i][j] == 1) depthFirstSearch(mat, j, isVisited);
  }


  /**
   * 5.
   * Problem: Breadth First Traversal or BFS for a Graph.
   * Solution:
   */
  void bfs(int[][] graph) {
    boolean[] visited = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) if (!visited[i]) breadthFirstSearch(graph, i);
  }

  void breadthFirstSearch(int[][] graph, int source) {
    boolean[] visited = new boolean[graph.length];
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
    for (int node = 0; node < graph.length; node++) return containCycle(graph, node, visited, recStack) ? true : false;
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
      else {
        for (int i = 0; i < mat[0].length; i++)
          if (!isVisited[i] && mat[front][i] == 1) queue.add(i);
      }
    }
    return false;
  }

  /**
   * 8.
   * Problem: Backtracking | Set 6 (Hamiltonian Cycle).
   * Solution:
   */
  ArrayList hamiltonianCycle(int[][] graph) {
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
   * Solution:
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
    for (int i = 0; i < graph[0].length; i++)
      if (isValidNeighbour(graph, curr, i, visited)) tSort(graph, i, stack, visited);
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

  int[] sPaths(int[][] graph, int[][] weight, Stack<Integer> stack, int[] distance) {
    while (!stack.isEmpty()) {
      int top = stack.pop();
      if (distance[top] != Integer.MAX_VALUE) {
        for (int v = 0; v < graph.length; v++) {
          if (graph[top][v] == 1)
            if (distance[v] > distance[top] + weight[top][v]) distance[v] = distance[top] + weight[top][v];
        }
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
   * Solution:
   */

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
   * Problem: Johnson&#8217;s algorithm for All-pairs shortest paths.
   * Solution:
   */

  /**
   * 41.
   * Problem: Graph Coloring | Set 1 (Introduction and Applications).
   * Solution:
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

  /**
   * 49.
   * Problem: Shortest path with exactly k edges in a directed and weighted graph.
   * Solution:
   */

  /**
   * 50.
   * Problem: Tarjan&#8217;s Algorithm to find Strongly Connected Components.
   * Solution:
   */

  /**
   * 51.
   * Problem: Snake and Ladder Problem.
   * Solution:
   */

  /**
   * 52.
   * Problem: Check if a given graph is tree or not.
   * Solution:
   */

  /**
   * 53.
   * Problem: Vertex Cover Problem | Set 1 (Introduction and Approximate Algorithm).
   * Solution:
   */

  /**
   * 54.
   * Problem: Biconnected Components.
   * Solution:
   */

  /**
   * 55.
   * Problem: Boggle (Find all possible words in a board of characters) | Set 1.
   * Solution:
   */

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
   * Problem: Greedy Algorithms | Set 9 (Boruvka&#8217;s algorithm).
   * Solution:
   */

  /**
   * 64.
   * Problem: Karger&#8217;s algorithm for Minimum Cut | Set 1 (Introduction and Implementation).
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
   * Problem: Java Program for Dijkstra&#8217;s Algorithm with Path Printing.
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
   * Problem: Printing Paths in Dijkstra&#8217;s Shortest Path Algorithm.
   * Solution:
   */

  /**
   * 82.
   * Problem: Dijkstra’s shortest path algorithm using set in STL.
   * Solution:
   */

  /**
   * 83.
   * Problem: Dijkstra&#8217;s Shortest Path Algorithm using priority_queue of STL.
   * Solution:
   */

  /**
   * 84.
   * Problem: Prim&#8217;s algorithm using priority_queue in STL.
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
   * Solution:
   */

  /**
   * 88.
   * Problem: Push Relabel Algorithm | Set 1 (Introduction and Illustration).
   * Solution:
   */

  /**
   * 89.
   * Problem: Kahn&#8217;s algorithm for Topological Sorting.
   * Solution:
   */

  /**
   * 90.
   * Problem: Push Relabel Algorithm | Set 2 (Implementation).
   * Solution:
   */

  /**
   * 91.
   * Problem: Dial&#8217;s Algorithm (Optimized Dijkstra for small range weights).
   * Solution:
   */

  /**
   * 92.
   * Problem: Find if there is a path of more than k length from a source.
   * Solution:
   */

  /**
   * 93.
   * Problem: Kruskal&#8217;s Minimum Spanning Tree using STL in C++.
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
   * Solution:
   */

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
   * Problem: Find Shortest distance from a guard in a Bank.
   * Solution:
   */

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
   * Solution:
   */

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
   * Solution:
   */

  /**
   * 113.
   * Problem: Find if an array of strings can be chained to form a circle | Set 2.
   * Solution:
   */

  /**
   * 114.
   * Problem: Minimum Cost Path with Left, Right, Bottom and Up moves allowed.
   * Solution:
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
   * Solution: To find shortest distance. We use bfs.
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
   * Solution:
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
    int sum = 0;
    List<List<Integer>> g = graph.getGraph();
    for (List<Integer> list : g) sum += list.size();
    return sum;
  }

  /**
   * 133.
   * Problem: Sum of dependencies in a graph.
   * Solution:
   */

  /**
   * 134.
   * Problem: Find length of the largest region in Boolean Matrix.
   * Solution:
   */

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
   * Solution:
   */

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
   * Problem: Count nodes within K-distance from all nodes in a set.
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
   * Given a matrix of 0's and 1's find the count of biggest area covered by adjacent 1's.
   * Hint: We can use DFS here.
   */
  int maxConnectedCell(int[][] grid) {
    int m = grid.length;
    int n = grid.length;
    boolean[][] isVisited = new boolean[m][n];

    int max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!isVisited[i][j] && grid[i][j] == 1)
          max = Math.max(max, dfs(grid, i, j, isVisited));
      }
    }

    return max;
  }

  boolean isValidMove(int[][] grid, int x, int y, boolean[][] isVisited) {
    return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !isVisited[x][y]);
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


}
