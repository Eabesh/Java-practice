package komal.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int v;
    LinkedList<Integer> linkedLists[];

    Graph(int v){
        this.v = v;
        linkedLists = new LinkedList[v];

        for(int i = 0; i<v;i++){
            linkedLists[i] = new LinkedList<>();
        }
    }

    /*public void addEdge(int v,int e){
        linkedLists[v].add(e);
        linkedLists[e].add(v);
    }*/

    public void addEdge(int v,int e){
        linkedLists[v].add(e);
    }

    public void bFS(int s){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];

        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.println(" "+tmp);
            LinkedList linkedList = linkedLists[tmp];

           for(Object integer : linkedList){
               Integer i = (Integer)integer;
               if(!visited[i]) {
                   queue.add(i);
                   visited[i] = true;
               }
           }
        }

    }

    public void dFS(int s){
        boolean[] visted = new boolean[v];
        dfsUtil(s,visted);

    }

    private void dfsUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(" "+v);
        LinkedList visitedList = linkedLists[v];

        Iterator<Integer> iterator = visitedList.listIterator();

        while (iterator.hasNext()){
            int n = iterator.next();
            if(!visited[n])
                dfsUtil(n,visited);
        }

    }

   /* public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.dFS(2);
        g.bFS(2);
    }
*/

   static int max_sum = Integer.MIN_VALUE;
   static ArrayList arr = new ArrayList();
    static int  numberOfPaths(int[][] mat,int m, int n,int sum)
    {
        // If either given row number is first or
        // given column number is first

        sum=sum+mat[m-1][n-1];
        if(sum> max_sum) {
            arr.add(mat[m-1][n-1]+" "+(m-1)+","+(n-1));
            max_sum = sum;
        }
        if (m == 1 || n == 1)
            return max_sum;



        // If diagonal movements are allowed then
        // the last addition is required.
        return  numberOfPaths(mat,m-1, n,sum) + numberOfPaths(mat,m, n-1,sum)
         + numberOfPaths(mat,m-1,n-1,sum);
    }

    public static void main(String args[])
    {
        int[][] mat = { {1, 2,500, 3}, {4,10, 5, 6} , {4,10, 5, 6},{4,10, 5, 6}};
        System.out.println("max sum is "+numberOfPaths(mat,4, 4,0));
       // arr.add((mat[0][0]+" "+(0)+","+(0)));
        System.out.println("sum is "+max_sum);
        System.out.println("matrix is "+ arr);
    }
}
