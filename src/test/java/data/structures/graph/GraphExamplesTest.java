package data.structures.graph;

import algorithms.dynamic.programming.DPExamples;
import algorithms.dynamic.programming.DPExamplesTest;
import org.junit.Test;
import utilities.Graph;
import utilities.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphExamplesTest {
class test {
  int x;
  test(int x) {this.x = x;}
}
  @Test
  public void stringTest() {
    String s1 = "cat";
    String s2 = "cat";
    String s3 = new String("cat");
    s3.equals(s1);
    System.out.println(new test(1).equals(new test(1)));;
    boolean result1 = s1 == s2;
    boolean result2 = s1 == s3;

    assertEquals(result1, true);
    assertEquals(result2, false);
    char[] array = "123456".toCharArray();
    reverse(array, 0, array.length - 1);
    System.out.println(array);
  }

  void reverse(char[] array, int start, int end) {
    if (start < end) {
      char temp = array[start];
      array[start] = array[end];
      array[end] = temp;
      reverse(array, start + 1, end - 1);
    }

  }

  @Test
  public void countPathsDG() throws Exception {

    int[][] graph = {{0, 1, 1, 0, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0}};
    boolean[] visited = new boolean[graph.length];
    assertEquals(4, new GraphExamples().countPathsDG(graph, 0, 4, visited));

  }

  @Test
  public void waterJugProblem() throws Exception {
    new GraphExamples().waterJugProblem(0, 0, 4, 3, 0, 2, "", new HashSet<>());
  }

  @Test
  public void printLevelOfEachNode() throws Exception {

    int[][] graph = { {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0},
  {0, 0, 0, 0, 0, 0}};

    new GraphExamples().printLevelOfEachNode(graph, 0);
  }

  @Test
  public void countNonReachable() throws Exception {
    int[][] graph = {{0, 1, 1, 0, 0, }, {1, 0, 1, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 0}};
    assertEquals(2, new GraphExamples().countNonReachable(graph, 0));
  }

  @Test
  public void areNodesInSamePath() throws Exception {
    int[][] graph = {{0, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}};
  }

  @Test
  public void isKLengthPath() throws Exception {
    int[][] graph = {{0, 1, 0, 0, 0, 0, 0, 1, 0}, {1, 0, 1, 0, 0, 0, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1},
            {0, 0, 1, 0, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 1, 0 , 0},
            {0, 0, 0, 0, 0, 1, 0, 1, 1 }, {1, 1, 0, 0, 0, 0, 1, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 1, 0}};

    int[][] weight = {{0, 4, 0, 0, 0, 0, 0, 8, 0}, {4, 0, 8, 0, 0, 0, 0, 11, 0}, {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0, 0}, {0, 0, 4, 14, 10, 0, 2, 0 , 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6 }, {8, 11, 0, 0, 0, 0, 1, 0, 7}, {0, 0, 2, 0, 0, 0, 6, 7, 0}};

    assertTrue(new GraphExamples().isKLengthPath(graph, weight, 0, 58));
  }

  @Test
  public void bfsDG() throws Exception {
      int[][] graph = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
      new GraphExamples().bfsDG(graph);
  }

  @Test
  public void minOperationToXY() throws Exception {
    assertEquals(2, new GraphExamples().minOperationToXY(4, 7));
  }

  @Test
  public void printJumpingNumbers() throws Exception {
    new GraphExamples().printJumpingNumbers(40);
  }

  @Test
  public void isCycleUD() throws Exception {
    Graph graph = new Graph(5);
    graph.addEdge(0, 1);
//    graph.addEdge(1, 2);
//    graph.addEdge(0, 2);
//    graph.addEdge(2, 0);
//    graph.addEdge(0, 3);
//    graph.addEdge(3, 4);
    assertFalse(new GraphExamples().isCycleUD(graph));
  }

  @Test
  public void solveSnakeLadder() throws Exception {
    int[] moves = new int[30];
    Arrays.fill(moves, -1);

    // Ladders
    moves[2] = 21;
    moves[4] = 7;
    moves[10] = 25;
    moves[19] = 28;

    // Snakes
    moves[26] = 0;
    moves[20] = 8;
    moves[16] = 3;
    moves[18] = 6;

    assertEquals(3, new GraphExamples().solveSnakeLadder(moves));
  }

  @Test
  public void countWynk() throws Exception {
    char mat[][] = {{'W','Y','N', 'K'},
                    {'Y','I','K', 'S'},
                    {'N','S','N', 'S'},
                    {'K','S','E', 'K'}};

    assertEquals(2, new GraphExamples().countWynk(mat, "WYNK"));
  }

  @Test
  public void findWords() throws Exception {
    char boggle[][] = {{'G','I','Z'},
      {'U','E','K'},
      {'Q','S','E'}};
    Set<String> dictionary = new HashSet<>();
    dictionary.add("GEEK");
    dictionary.add("QUIZ");
    dictionary.add("SEEK");
    new GraphExamples().findWords(boggle, dictionary);
  }

  @Test
  public void printSteppingNum() throws Exception {
    new GraphExamples().printSteppingNum(0, 20);
  }

  @Test
  public void findDistance() throws Exception {
    char matrix[][] =
    {
      {'O', 'O', 'O', 'O', 'G'},
      {'O', 'W', 'W', 'O', 'O'},
      {'O', 'O', 'O', 'W', 'O'},
      {'G', 'W', 'W', 'W', 'O'},
      {'O', 'O', 'O', 'O', 'G'}
    };

    int[][] output = new GraphExamples().findDistance(matrix);
    for (int i = 0; i < output.length; i++) {
      for (int j = 0; j < output[0].length; j++) System.out.print(output[i][j] + " ");
      System.out.println();
    }
  }

  @Test
  public void findLargestRegion() throws Exception {
   int[][] graph = { {0, 0, 1, 1, 0},
      {1, 0, 1, 1, 0},
      {0, 1, 0, 0, 0},
      {0, 0, 0, 0, 1}};
   assertEquals(6, new GraphExamples().findLargestRegion(graph));
  }

  @Test
  public void sumOfDependencies() throws Exception {
    Graph graph = new Graph(5);
    graph.addEdge(0 , 2);
    graph.addEdge(0 ,  3);
    graph.addEdge(1 , 3);
    graph.addEdge(2 , 3);
    assertEquals(4, new GraphExamples().sumOfDependencies(graph));
  }

  @Test
  public void countPaths() throws Exception {
    int[][] graph = { {0, 1, 1, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 0}
    };

    assertEquals(2, new GraphExamples().countPaths(graph, 0, 3, 2));
  }

  @Test
  public void isBipartite() throws Exception {
    int[][] graph = {{0, 1, 0, 1},
      {1, 0, 1, 0},
      {0, 1, 0, 1},
      {1, 0, 1, 0}
    };

    assertTrue(new GraphExamples().isBipartite(graph));
  }

  @Test
  public void shortestPathDAG() throws Exception {
    int[][] graph = {{0, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0}, {0, 0, 0, 1, 1, 1}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}};
    int[][] weight = {{0, 5, 3, 0, 0, 0}, {0, 0, 2, 6, 0, 0}, {0, 0, 0, 7, 4, 2}, {0, 0, 0, 0, -1, 0}, {0, 0, 0, 0, 0, -2}, {0, 0, 0, 0, 0, 0}};
    int[] res = new GraphExamples().shortestPathDAG(graph, weight, 1);
    for (Integer val : res) System.out.print(val + " ");
  }

  @Test
  public void allPairShortestPath() throws Exception {
    int INF = 9999;
    int[][] graph = { {0,   5,  INF, 10},
            {INF, 0,   3, INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
    };

    int[][] result = new GraphExamples().allPairShortestPath(graph);
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result.length; j++) System.out.print(result[i][j] + " ");
      System.out.println();
    }

  }

  @Test
  public void printPaths() throws Exception {
    int[][] graph = {{0, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 0, 0}, {0, 0, 0, 0}};
    boolean[] visited = new boolean[graph.length];
    new GraphExamples().printPaths(graph, 2, 3, "", visited);
  }

  @Test
  public void countEdgesUDG() throws Exception {
    Graph graph = new Graph(5);
    graph.addEdge(0 , 1);
    graph.addEdge(0 , 2);
    graph.addEdge(0 ,  3);
    graph.addEdge(0 , 4);
    graph.addEdge(0 , 5);
    graph.addEdge(1 , 2);
    assertEquals(6, new GraphExamples().countEdgesUDG(graph));
  }


  @Test
  public void minEdgeBFS() throws Exception {
    int[][] graph = {{0, 1, 2, 0, 4, 0, 0}, {1, 0, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1, 1},
            {0, 0, 1, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 0}};
    assertEquals(2, new GraphExamples().minEdgeBFS(graph, 1, 5));
  }

  @Test
  public void hasCycle() throws Exception {
    int[][] mat = {{0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 1}, {0, 0, 0, 0}};
    int[][] graph = {{0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}};
    assertTrue(new GraphExamples().hasCycle(graph));
    assertFalse(new GraphExamples().hasCycle(mat));
  }

  @Test
  public void hamiltonionCycle() throws Exception {
    int graph1[][] = {{0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0},
    };
    ArrayList<Integer> path = new GraphExamples().hamiltonianCycle(graph1);
    for (Integer integer : path) System.out.print(integer + " ");
  }

  @Test
  public void bfs() throws Exception {
    int[][] graph = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
    new GraphExamples().bfs(graph);

  }

  @Test
  public void topologicalSort() throws Exception {
    int[][] mat = {{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0}, {1, 0, 1, 0, 0, 0}};
    java.util.Stack<Integer> stack= new GraphExamples().topologicalSort(mat);
    while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
  }


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
        int[][] graph = {{1,1},{1,0}};
        assertEquals(3,new GraphExamples().maxConnectedCell(graph));
    }



}
